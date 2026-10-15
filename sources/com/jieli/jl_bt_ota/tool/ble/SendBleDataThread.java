package com.jieli.jl_bt_ota.tool.ble;

import S.a;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.datastore.preferences.protobuf.C0524s;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.jieli.jl_bt_ota.interfaces.bt.OnBleSendDataCallback;
import com.jieli.jl_bt_ota.model.base.ThreadState;
import com.jieli.jl_bt_ota.model.ble.BleSendParam;
import com.jieli.jl_bt_ota.model.ble.BleSendTask;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.starburst.sdk.core.feed.FeedManager;
import java.util.concurrent.LinkedBlockingQueue;
import p072j6.k;

/* JADX INFO: loaded from: classes.dex */
public class SendBleDataThread extends Thread {
    private static final String j = "SendBleDataThread";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f16224k = 50;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f16225l = 26433;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBleOperation f16226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a<ThreadState> f16227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedBlockingQueue<BleSendTask> f16228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f16229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f16230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f16231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f16232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile BleSendTask f16233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f16234i;

    public interface IBleOperation {
        int getBleMtu(BluetoothDevice bluetoothDevice);

        boolean writeBleData(BleSendParam bleSendParam);
    }

    public SendBleDataThread(IBleOperation iBleOperation, a<ThreadState> aVar) {
        super(j);
        this.f16228c = new LinkedBlockingQueue<>();
        this.f16229d = false;
        this.f16230e = false;
        this.f16231f = true;
        this.f16232g = false;
        this.f16234i = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: j6.l
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f19909a.a(message);
            }
        });
        this.f16226a = iBleOperation;
        this.f16227b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (f16225l != message.what || !this.f16230e || this.f16228c.isEmpty()) {
            return true;
        }
        JL_Log.d(j, "MSG_CHECK_QUEUE", "size ---> " + this.f16228c.size());
        a();
        return true;
    }

    public boolean addSendTask(BleSendTask bleSendTask) {
        BluetoothDevice device;
        int bleMtu;
        if (!this.f16229d) {
            return false;
        }
        byte[] data = bleSendTask.getData();
        if (data.length == 0 || (bleMtu = this.f16226a.getBleMtu((device = bleSendTask.getDevice()))) <= 0) {
            return false;
        }
        int i9 = 0;
        while (i9 < data.length) {
            int iMin = Math.min(data.length - i9, bleMtu);
            byte[] bArr = new byte[iMin];
            System.arraycopy(data, i9, bArr, 0, iMin);
            if (!a(new BleSendTask(device, bleSendTask.getServiceUUID(), bleSendTask.getCharacteristicUUID(), bleSendTask.getWriteType(), bArr, bleSendTask.getCallback()))) {
                JL_Log.i(j, "addSendTask", CommonUtil.formatString("loss data, data = [ %s ]", CHexConver.byte2HexStr(bArr)));
                return false;
            }
            i9 += iMin;
        }
        return true;
    }

    public boolean isRunning() {
        return this.f16229d;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        JL_Log.d(j, "run", "start");
        a<ThreadState> aVar = this.f16227b;
        if (aVar != null) {
            aVar.accept(new ThreadState(getId(), getName()).setState(1));
        }
        while (this.f16229d) {
            this.f16233h = null;
            this.f16232g = false;
            this.f16231f = this.f16228c.isEmpty();
            if (this.f16231f) {
                JL_Log.d(j, "run", "queue is empty, so waiting for data");
                a(0L);
            } else {
                try {
                    if (b(this.f16228c.peek())) {
                        this.f16228c.poll();
                    }
                } catch (InterruptedException e9) {
                    JL_Log.w(j, "run", "exception : " + e9.getMessage());
                }
            }
        }
        this.f16229d = false;
        this.f16230e = false;
        this.f16232g = false;
        this.f16228c.clear();
        this.f16231f = true;
        this.f16234i.removeCallbacksAndMessages(null);
        a<ThreadState> aVar2 = this.f16227b;
        if (aVar2 != null) {
            aVar2.accept(new ThreadState(getId(), getName()).setState(0));
        }
        JL_Log.d(j, "run", "exit");
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        this.f16229d = true;
        super.start();
    }

    public synchronized void stopThread() {
        JL_Log.d(j, "stopThread", "");
        this.f16229d = false;
        a();
    }

    public void wakeupSendThread(BleSendTask bleSendTask) {
        BleSendTask bleSendTask2;
        if (!this.f16229d || bleSendTask == null || (bleSendTask2 = this.f16233h) == null || !bleSendTask2.equals(bleSendTask)) {
            return;
        }
        bleSendTask.setCallback(bleSendTask2.getCallback());
        this.f16233h = bleSendTask;
        a("wakeupSendThread", "status = " + bleSendTask.getStatus());
        a();
    }

    private boolean b() {
        synchronized (this.f16228c) {
            a("unlock", "isLocked : " + this.f16230e);
            if (!this.f16230e) {
                return false;
            }
            try {
                a("unlock", "try to unlock");
                this.f16228c.notifyAll();
                this.f16234i.removeMessages(f16225l);
                return true;
            } catch (Exception e9) {
                JL_Log.w(j, "unlock", "occurred exception : " + e9.getMessage());
                return false;
            }
        }
    }

    private void a(BleSendTask bleSendTask, boolean z8) {
        OnBleSendDataCallback callback;
        if (bleSendTask == null || bleSendTask.getCallback() == null || (callback = bleSendTask.getCallback()) == null) {
            return;
        }
        k kVar = new k(callback, bleSendTask, z8);
        if (BluetoothConstant.IS_CALLBACK_IN_MAIN) {
            this.f16234i.post(kVar);
        } else {
            kVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(OnBleSendDataCallback onBleSendDataCallback, BleSendTask bleSendTask, boolean z8) {
        onBleSendDataCallback.onResult(bleSendTask.getDevice(), bleSendTask.getServiceUUID(), bleSendTask.getCharacteristicUUID(), z8, bleSendTask.getData());
    }

    private boolean b(BleSendTask bleSendTask) throws InterruptedException {
        if (bleSendTask == null) {
            return true;
        }
        this.f16233h = bleSendTask;
        a("handleTask", "" + bleSendTask);
        this.f16233h.setStatus(FeedManager.FILE_TYPE_INT_AIGC_ORIGIN_PNG);
        this.f16232g = this.f16226a.writeBleData(this.f16233h.getSendParam());
        a("handleTask", "writeDataByBleSync : " + this.f16232g);
        if (this.f16232g && this.f16233h.getStatus() == 257) {
            a(6000L);
        }
        int status = this.f16233h.getStatus();
        StringBuilder sbA = C0524s.a(status, "send data status : ", ", ");
        sbA.append(status == 0 ? "success" : "fail");
        a("handleTask", sbA.toString());
        if (status != 0) {
            if (this.f16233h.isSendFailedOverLimit()) {
                a(this.f16233h, false);
            } else {
                Thread.sleep(10L);
                return false;
            }
        } else {
            a(this.f16233h, true);
        }
        return true;
    }

    private boolean a(BleSendTask bleSendTask) {
        boolean z8;
        if (!this.f16229d) {
            return false;
        }
        synchronized (this.f16228c) {
            try {
                this.f16228c.put(bleSendTask);
                z8 = true;
            } catch (InterruptedException e9) {
                e9.printStackTrace();
                z8 = false;
            }
            a("addTask", "result : " + z8 + ", " + bleSendTask + "\n size : " + this.f16228c.size() + ", isQueueEmpty : " + this.f16231f + ", isWaitingForResult : " + this.f16232g);
            if (z8 && this.f16231f && !this.f16232g) {
                this.f16231f = false;
                a();
            }
        }
        return z8;
    }

    private void a(long j8) {
        synchronized (this.f16228c) {
            if (this.f16230e) {
                return;
            }
            try {
                a("lock", "try to lock, timeout = " + j8);
                if (j8 > 0) {
                    this.f16230e = true;
                    this.f16228c.wait(j8);
                } else if (!this.f16228c.isEmpty()) {
                    JL_Log.d(j, "lock", "Continue working because the task queue is not empty");
                    return;
                } else {
                    this.f16230e = true;
                    this.f16228c.wait();
                }
            } catch (InterruptedException e9) {
                JL_Log.w(j, "lock", "occurred exception : " + e9.getMessage());
            }
            this.f16230e = false;
            a("lock", "release lock.");
        }
    }

    private void a() {
        boolean zB = b();
        a("tryToUnlock", "unlock : " + zB);
        if (zB) {
            return;
        }
        this.f16234i.removeMessages(f16225l);
        this.f16234i.sendEmptyMessageDelayed(f16225l, 50L);
    }

    private void a(String str, String str2) {
        if (BluetoothConstant.IS_LOG_BLE_SEND) {
            JL_Log.d(j, str, str2);
        }
    }
}

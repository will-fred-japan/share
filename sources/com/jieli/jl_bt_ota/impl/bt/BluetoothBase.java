package com.jieli.jl_bt_ota.impl.bt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtAssistantCallback;
import com.jieli.jl_bt_ota.model.BluetoothOTAConfigure;
import com.jieli.jl_bt_ota.tool.callback.BtAssistantCallbackManager;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;

/* JADX INFO: loaded from: classes.dex */
class BluetoothBase {
    protected static final int OPERATION_TIMEOUT = 6000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BluetoothAdapterReceiver f16106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BluetoothOTAConfigure f16107b;
    protected final BluetoothAdapter mBluetoothAdapter;
    protected final BtAssistantCallbackManager mCallbackManager;
    protected final Context mContext;
    protected final boolean mHasBle;
    protected String TAG = getClass().getSimpleName();
    protected final Handler mUIHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_bt_ota.impl.bt.a
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f16146a.handleMessageEvent(message);
        }
    });

    public class BluetoothAdapterReceiver extends BroadcastReceiver {
        private BluetoothAdapterReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (intExtra2 == -1) {
                    return;
                }
                JL_Log.i(BluetoothBase.this.TAG, "ACTION_STATE_CHANGED", W5.e.h(intExtra2, intExtra, "state : ", ", prevState : "));
                if (intExtra == intExtra2) {
                    return;
                }
                if (10 == intExtra2) {
                    BluetoothBase.this.onAdapterStatus(false);
                } else if (12 == intExtra2) {
                    BluetoothBase.this.onAdapterStatus(true);
                }
            }
        }
    }

    public BluetoothBase(Context context) {
        this.mContext = (Context) CommonUtil.checkNotNull(context, "Context can not be null.");
        CommonUtil.setMainContext(context);
        this.mHasBle = BluetoothUtil.hasBle(context);
        this.mCallbackManager = new BtAssistantCallbackManager();
        this.f16107b = BluetoothOTAConfigure.createDefault();
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
        this.mBluetoothAdapter = adapter == null ? BluetoothAdapter.getDefaultAdapter() : adapter;
        a();
        JL_Log.i(this.TAG, TCPTimingCache.P_INIT, "clazz : " + this);
    }

    private void a() {
        if (this.f16106a != null || this.mContext == null) {
            return;
        }
        this.f16106a = new BluetoothAdapterReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mContext.registerReceiver(this.f16106a, intentFilter);
    }

    private void b() {
        Context context;
        BluetoothAdapterReceiver bluetoothAdapterReceiver = this.f16106a;
        if (bluetoothAdapterReceiver == null || (context = this.mContext) == null) {
            return;
        }
        context.unregisterReceiver(bluetoothAdapterReceiver);
        this.f16106a = null;
    }

    public void addOnBtAssistantCallback(OnBtAssistantCallback onBtAssistantCallback) {
        this.mCallbackManager.addCallback(onBtAssistantCallback);
    }

    public void configure(BluetoothOTAConfigure bluetoothOTAConfigure) {
        if (bluetoothOTAConfigure == null) {
            return;
        }
        this.f16107b = bluetoothOTAConfigure;
    }

    public void executeTimeoutTask(int i9, BluetoothDevice bluetoothDevice, long j) {
        removeTimeoutTask(i9);
        if (j < 0) {
            j = 0;
        }
        if (bluetoothDevice == null) {
            this.mUIHandler.sendEmptyMessageDelayed(i9, j);
        } else {
            Handler handler = this.mUIHandler;
            handler.sendMessageDelayed(handler.obtainMessage(i9, bluetoothDevice), j);
        }
    }

    public BluetoothOTAConfigure getBluetoothOption() {
        return this.f16107b;
    }

    public boolean handleMessageEvent(Message message) {
        return true;
    }

    public boolean isBluetoothEnable() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public boolean isHasTimeoutTask(int i9) {
        return this.mUIHandler.hasMessages(i9);
    }

    public boolean isInvalidEnv(String str, BluetoothDevice bluetoothDevice) {
        if (!CommonUtil.checkHasConnectPermission(this.mContext)) {
            JL_Log.w(this.TAG, str, "Missing connect permissions.");
            return true;
        }
        if (bluetoothDevice == null) {
            JL_Log.w(this.TAG, str, "Device is null.");
            return true;
        }
        if (BluetoothUtil.isBluetoothEnable()) {
            return false;
        }
        JL_Log.w(this.TAG, str, "Bluetooth is off.");
        return true;
    }

    public void onAdapterStatus(boolean z8) {
        this.mCallbackManager.onAdapterStatus(z8, this.mHasBle);
    }

    public String printBtDeviceInfo(BluetoothDevice bluetoothDevice) {
        return printBtDeviceInfo(bluetoothDevice, true);
    }

    public void release() {
        b();
        this.mUIHandler.removeCallbacksAndMessages(null);
        this.mCallbackManager.release();
        JL_Log.i(this.TAG, "release", "clazz : " + this);
    }

    public void removeOnBtAssistantCallback(OnBtAssistantCallback onBtAssistantCallback) {
        this.mCallbackManager.removeCallback(onBtAssistantCallback);
    }

    public void removeTimeoutTask(int i9) {
        this.mUIHandler.removeMessages(i9);
    }

    public void runOnMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            runnable.run();
        } else {
            this.mUIHandler.post(runnable);
        }
    }

    public String printBtDeviceInfo(BluetoothDevice bluetoothDevice, boolean z8) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, bluetoothDevice, z8);
    }
}

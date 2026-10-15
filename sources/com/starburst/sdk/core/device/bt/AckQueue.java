package com.starburst.sdk.core.device.bt;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.starburst.sdk.common.utils.ByteTools;
import com.starburst.sdk.utils.j;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class AckQueue {
    private static AckQueue instance;
    private Handler ackHandler;
    private AckLooperThread ackLooperThread;
    private String TAG = "AckQueue";
    private HashMap<String, Integer> ackMap = new HashMap<>();
    private ArrayList<String> ackList = new ArrayList<>();
    private final Object ackLock = new Object();
    private final int MSG_SEND_ACK = 101;
    private int sendNum = 0;
    private boolean isSending = false;

    public class AckLooperThread extends Thread {
        private AckLooperThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            AckQueue.this.ackHandler = new Handler(Looper.myLooper()) { // from class: com.starburst.sdk.core.device.bt.AckQueue.AckLooperThread.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what != 101) {
                        return;
                    }
                    synchronized (AckQueue.this.ackLock) {
                        try {
                            if (AckQueue.this.ackMap != null) {
                                j.f(AckQueue.this.TAG, "MSG_SEND_ACK--" + AckQueue.this.sendNum);
                                if (AckQueue.this.sendNum >= 4) {
                                    if (AckQueue.this.ackList.size() > 0) {
                                        AckQueue.this.ackMap.remove(AckQueue.this.ackList.get(0));
                                        AckQueue.this.ackList.remove(0);
                                    }
                                    AckQueue.this.sendNum = 0;
                                    if (AckQueue.this.ackList.size() > 0) {
                                        AckQueue.this.ackHandler.sendEmptyMessage(101);
                                    } else {
                                        AckQueue.this.isSending = false;
                                        AckQueue.this.ackHandler.removeMessages(101);
                                    }
                                } else if (AckQueue.this.ackList.size() == 0) {
                                    AckQueue.this.sendNum = 0;
                                    AckQueue.this.isSending = false;
                                    AckQueue.this.ackHandler.removeMessages(101);
                                } else {
                                    String str = (String) AckQueue.this.ackList.get(0);
                                    Integer num = (Integer) AckQueue.this.ackMap.get(str);
                                    if (num == null) {
                                        j.f(AckQueue.this.TAG, "MSG_SEND_ACK drop stale ack--" + str);
                                        AckQueue.this.ackList.remove(0);
                                        AckQueue.this.sendNum = 0;
                                        if (AckQueue.this.ackList.size() > 0) {
                                            AckQueue.this.ackHandler.sendEmptyMessage(101);
                                        } else {
                                            AckQueue.this.isSending = false;
                                            AckQueue.this.ackHandler.removeMessages(101);
                                        }
                                    } else {
                                        AckQueue.access$408(AckQueue.this);
                                        AckQueue.this.sendAck(ByteTools.hexToByteArr(str), num.intValue());
                                        AckQueue.this.ackHandler.sendEmptyMessageDelayed(101, 200L);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
            Looper.loop();
        }
    }

    public static /* synthetic */ int access$408(AckQueue ackQueue) {
        int i9 = ackQueue.sendNum;
        ackQueue.sendNum = i9 + 1;
        return i9;
    }

    public static AckQueue getInstance() {
        if (instance == null) {
            instance = new AckQueue();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAck(byte[] bArr, int i9) {
        j.f(this.TAG, "sendAck--sendAck--");
        BleMsgManager.getInstance().sendAnswerMsgNoEncryption(ConnectedDeviceManager.getInstance().getMasterDevice(), 255, i9, bArr);
    }

    public void addAck(String str, int i9) {
        Handler handler;
        synchronized (this.ackLock) {
            try {
                this.ackMap.put(str, Integer.valueOf(i9));
                this.ackList.add(str);
                j.f(this.TAG, "addAck--" + this.isSending);
                if (!this.isSending && (handler = this.ackHandler) != null) {
                    this.sendNum = 0;
                    this.isSending = true;
                    handler.sendEmptyMessage(101);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clear() {
        synchronized (this.ackLock) {
            try {
                j.f(this.TAG, "clear--");
                this.ackMap.clear();
                this.ackList.clear();
                this.sendNum = 0;
                this.isSending = false;
                Handler handler = this.ackHandler;
                if (handler != null) {
                    handler.removeMessages(101);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void init() {
        if (this.ackLooperThread == null) {
            AckLooperThread ackLooperThread = new AckLooperThread();
            this.ackLooperThread = ackLooperThread;
            ackLooperThread.start();
        }
    }

    public void removeAck(int i9) {
        Handler handler;
        synchronized (this.ackLock) {
            try {
                if (this.ackList.size() == 0) {
                    j.f(this.TAG, "ackList size 0");
                } else {
                    j.f(this.TAG, "removeAck--111--" + i9);
                    String str = this.ackList.get(0);
                    Integer num = this.ackMap.get(str);
                    if (num == null) {
                        j.f(this.TAG, "removeAck drop stale ack--" + str);
                        this.ackList.remove(0);
                        this.sendNum = 0;
                        if (!this.isSending || this.ackList.size() <= 0 || (handler = this.ackHandler) == null) {
                            this.isSending = false;
                        } else {
                            handler.sendEmptyMessage(101);
                        }
                    } else if (num.intValue() == i9 && this.isSending) {
                        j.f(this.TAG, "removeAck--222--" + i9);
                        this.ackHandler.removeMessages(101);
                        this.ackList.remove(0);
                        this.ackMap.remove(str);
                        this.sendNum = 0;
                        if (this.ackList.size() > 0) {
                            this.ackHandler.sendEmptyMessage(101);
                        } else {
                            this.isSending = false;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

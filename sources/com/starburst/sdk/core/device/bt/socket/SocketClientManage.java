package com.starburst.sdk.core.device.bt.socket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.starburst.sdk.utils.j;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class SocketClientManage {
    private static String TAG = "--SocketClientManage--";
    private static SocketClientManage sInstance;
    private Handler mSocketHandle;
    private SocketLooperThread mSocketLooperThread;

    public class SocketLooperThread extends Thread {
        private SocketLooperThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            SocketClientManage.this.mSocketHandle = new Handler() { // from class: com.starburst.sdk.core.device.bt.socket.SocketClientManage.SocketLooperThread.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    String str;
                    String str2;
                    super.handleMessage(message);
                    switch (message.what) {
                        case 0:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_SCOKET";
                            break;
                        case 1:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_BIND";
                            break;
                        case 2:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_GETSOCKETOPT";
                            break;
                        case 3:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_SETSOCKETOPT";
                            break;
                        case 4:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_CONNECT";
                            break;
                        case 5:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_RECV";
                            break;
                        case 6:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_RECVFROM";
                            break;
                        case 7:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_READ";
                            break;
                        case 8:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_SEND";
                            break;
                        case 9:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_SENDMSG";
                            break;
                        case 10:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_WRITE";
                            break;
                        case 11:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_SELECT";
                            break;
                        case 12:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_FCNTL";
                            break;
                        case 13:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_GETADDRINFO";
                            break;
                        case 14:
                            str = SocketClientManage.TAG;
                            str2 = "收到Socket消息--MSG_SCOKET_GETHOSTBYNAME";
                            break;
                        default:
                            return;
                    }
                    j.f(str, str2);
                }
            };
            Looper.loop();
        }
    }

    public SocketClientManage() {
        j.f(TAG, "-----SocketClientManage-----init----" + this.mSocketLooperThread);
        if (this.mSocketLooperThread == null) {
            SocketLooperThread socketLooperThread = new SocketLooperThread();
            this.mSocketLooperThread = socketLooperThread;
            socketLooperThread.start();
        }
        new Socket();
    }

    public static SocketClientManage getInstance() {
        if (sInstance == null) {
            synchronized (SocketClientManage.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new SocketClientManage();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }
}

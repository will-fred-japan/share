package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class BinderAdapter implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BinderCallBack f14768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IBinder f14769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f14770f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14771g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f14772h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f14773i = null;

    public interface BinderCallBack {
        void onBinderFailed(int i9);

        void onBinderFailed(int i9, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f14765a = context;
        this.f14766b = str;
        this.f14767c = str2;
    }

    private void c() {
        synchronized (this.f14770f) {
            try {
                Handler handler = this.f14772h;
                if (handler != null) {
                    handler.removeMessages(getConnTimeOut());
                    this.f14772h = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void d() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.i("BinderAdapter", "The serviceConnection has been bind for 1800s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack binderCallBackF = BinderAdapter.this.f();
                if (binderCallBackF == null) {
                    return true;
                }
                binderCallBackF.onTimedDisconnected();
                return true;
            }
        });
        this.f14773i = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
    }

    private void e() {
        HMSLog.e("BinderAdapter", "In connect, bind core service fail");
        try {
            ComponentName componentName = new ComponentName(this.f14765a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack binderCallBackF = f();
            if (binderCallBackF != null) {
                binderCallBackF.onBinderFailed(-1, intent);
            }
        } catch (RuntimeException e9) {
            HMSLog.e("BinderAdapter", "getBindFailPendingIntent failed " + e9.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BinderCallBack f() {
        return this.f14768d;
    }

    private void g() {
        Handler handler = this.f14772h;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.f14772h = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.e("BinderAdapter", "In connect, bind core service time out");
                    BinderAdapter.this.b();
                    return true;
                }
            });
        }
        this.f14772h.sendEmptyMessageDelayed(getConnTimeOut(), 10000L);
    }

    private void h() {
        HMSLog.d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            try {
                Handler handler = this.f14773i;
                if (handler != null) {
                    handler.removeMessages(getMsgDelayDisconnect());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.f14768d = binderCallBack;
        a();
    }

    public int getConnTimeOut() {
        return 0;
    }

    public int getMsgDelayDisconnect() {
        return 0;
    }

    public String getServiceAction() {
        return this.f14766b;
    }

    public IBinder getServiceBinder() {
        return this.f14769e;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f14771g) {
            this.f14771g = false;
            return;
        }
        unBind();
        c();
        BinderCallBack binderCallBackF = f();
        if (binderCallBackF != null) {
            binderCallBackF.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f14769e = iBinder;
        c();
        BinderCallBack binderCallBackF = f();
        if (binderCallBackF != null) {
            binderCallBackF.onServiceConnected(componentName, iBinder);
        }
        d();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack binderCallBackF = f();
        if (binderCallBackF != null) {
            binderCallBackF.onServiceDisconnected(componentName);
        }
        h();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f14765a, this);
    }

    public void updateDelayTask() {
        HMSLog.d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            try {
                Handler handler = this.f14773i;
                if (handler != null) {
                    handler.removeMessages(getMsgDelayDisconnect());
                    this.f14773i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a() {
        if (TextUtils.isEmpty(this.f14766b) || TextUtils.isEmpty(this.f14767c)) {
            e();
        }
        Intent intent = new Intent(this.f14766b);
        try {
            intent.setPackage(this.f14767c);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
            e();
        }
        synchronized (this.f14770f) {
            try {
                if (this.f14765a.bindService(intent, this, 1)) {
                    g();
                } else {
                    this.f14771g = true;
                    e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BinderCallBack binderCallBackF = f();
        if (binderCallBackF != null) {
            binderCallBackF.onBinderFailed(-1);
        }
    }
}

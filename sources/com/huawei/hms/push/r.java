package com.huawei.hms.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: compiled from: RemoteService.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ServiceConnection f15470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Messenger f15471b = null;

    /* JADX INFO: compiled from: RemoteService.java */
    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f15472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f15473b;

        public a(Bundle bundle, Context context) {
            this.f15472a = bundle;
            this.f15473b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.i("RemoteService", "remote service onConnected");
            r.this.f15471b = new Messenger(iBinder);
            Message messageObtain = Message.obtain();
            messageObtain.setData(this.f15472a);
            try {
                r.this.f15471b.send(messageObtain);
            } catch (RemoteException unused) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f15473b.unbindService(r.this.f15470a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            r.this.f15471b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f15470a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f15470a, 1);
    }
}

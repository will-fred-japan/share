package S4;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class P implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4137a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4138b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f4140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final O f4141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f4142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ S f4143g;

    public P(S s8, O o2) {
        this.f4143g = s8;
        this.f4141e = o2;
    }

    public final void a(String str, Executor executor) throws Throwable {
        this.f4138b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (Build.VERSION.SDK_INT >= 31) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            S s8 = this.f4143g;
            p003a5.a aVar = s8.f4148g;
            Context context = s8.f4146e;
            try {
                boolean zB = aVar.b(context, str, this.f4141e.a(context), this, executor);
                this.f4139c = zB;
                if (zB) {
                    this.f4143g.f4147f.sendMessageDelayed(this.f4143g.f4147f.obtainMessage(1, this.f4141e), this.f4143g.f4150i);
                } else {
                    this.f4138b = 2;
                    try {
                        S s9 = this.f4143g;
                        s9.f4148g.a(s9.f4146e, this);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                StrictMode.setVmPolicy(vmPolicy);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                StrictMode.setVmPolicy(vmPolicy);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f4143g.f4145d) {
            try {
                this.f4143g.f4147f.removeMessages(1, this.f4141e);
                this.f4140d = iBinder;
                this.f4142f = componentName;
                Iterator it = this.f4137a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f4138b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f4143g.f4145d) {
            try {
                this.f4143g.f4147f.removeMessages(1, this.f4141e);
                this.f4140d = null;
                this.f4142f = componentName;
                Iterator it = this.f4137a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f4138b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

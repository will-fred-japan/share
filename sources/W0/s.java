package W0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: ServiceBlockBinder.java */
/* JADX INFO: loaded from: classes.dex */
public final class s<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f5031a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f5032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<SERVICE, RESULT> f5033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f5034d;

    /* JADX INFO: compiled from: ServiceBlockBinder.java */
    public interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t);
    }

    public s(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.f5034d = context;
        this.f5032b = intent;
        this.f5033c = bVar;
    }

    public final RESULT a() {
        a aVar;
        Context context = this.f5034d;
        b<SERVICE, RESULT> bVar = this.f5033c;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            try {
                CountDownLatch countDownLatch = this.f5031a;
                aVar = new a(countDownLatch, bVar);
                context.bindService(this.f5032b, aVar, 1);
                countDownLatch.await();
                try {
                    RESULT resultA = bVar.a(aVar.f5037c);
                    try {
                        context.unbindService(aVar);
                        return resultA;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return resultA;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        return null;
                    } finally {
                        if (aVar != null) {
                            try {
                                context.unbindService(aVar);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                aVar = null;
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: ServiceBlockBinder.java */
    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f5035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<SERVICE, RESULT> f5036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SERVICE f5037c;

        public a(CountDownLatch countDownLatch, b bVar) {
            this.f5035a = countDownLatch;
            this.f5036b = bVar;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CountDownLatch countDownLatch = this.f5035a;
            String str = k.f5004i;
            Objects.toString(componentName);
            try {
                this.f5037c = this.f5036b.a(iBinder);
                try {
                    countDownLatch.countDown();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    String str2 = k.f5004i;
                } finally {
                    try {
                        countDownLatch.countDown();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            String str = k.f5004i;
            Objects.toString(componentName);
            try {
                this.f5035a.countDown();
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName componentName) {
        }
    }
}

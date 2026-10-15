package S4;

import Q4.C0369z;
import Q4.RunnableC0368y;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.zzk;
import com.huawei.hms.api.HuaweiApiClientImpl;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: S4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0370a<T extends IInterface> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Feature[] f4151w = new Feature[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public N3.a f4153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f4154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final S f4155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f4156e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InterfaceC0374e f4159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InterfaceC0049a f4160i;
    public IInterface j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public H f4162l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final J6.a f4164n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final B0.N f4165o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f4166p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f4167q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile String f4168r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f4152a = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4157f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4158g = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f4161k = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4163m = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ConnectionResult f4169s = null;
    public boolean t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile zzk f4170u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicInteger f4171v = new AtomicInteger(0);

    /* JADX INFO: renamed from: S4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public interface InterfaceC0049a {
        void a(ConnectionResult connectionResult);
    }

    /* JADX INFO: renamed from: S4.a$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public class b implements InterfaceC0049a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p086l5.a f4172a;

        public b(p086l5.a aVar) {
            this.f4172a = aVar;
        }

        @Override // S4.AbstractC0370a.InterfaceC0049a
        public final void a(ConnectionResult connectionResult) {
            boolean z8 = connectionResult.f12451b == 0;
            p086l5.a aVar = this.f4172a;
            if (z8) {
                aVar.c(null, aVar.f4184x);
                return;
            }
            B0.N n8 = aVar.f4165o;
            if (n8 != null) {
                ((P4.d.b) n8.f1624b).y(connectionResult);
            }
        }
    }

    public AbstractC0370a(Context context, Looper looper, S s8, O4.b bVar, int i9, J6.a aVar, B0.N n8, String str) {
        C0376g.f(context, "Context must not be null");
        this.f4154c = context;
        C0376g.f(looper, "Looper must not be null");
        C0376g.f(s8, "Supervisor must not be null");
        this.f4155d = s8;
        C0376g.f(bVar, "API availability must not be null");
        this.f4156e = new E(this, looper);
        this.f4166p = i9;
        this.f4164n = aVar;
        this.f4165o = n8;
        this.f4167q = str;
    }

    public static /* bridge */ /* synthetic */ boolean w(AbstractC0370a abstractC0370a, int i9, int i10, IInterface iInterface) {
        synchronized (abstractC0370a.f4157f) {
            try {
                if (abstractC0370a.f4163m != i9) {
                    return false;
                }
                abstractC0370a.x(i10, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(com.google.android.gms.common.internal.b bVar, Set<Scope> set) {
        Bundle bundleQ = q();
        String str = this.f4168r;
        int i9 = O4.c.f3474a;
        Scope[] scopeArr = GetServiceRequest.f12503o;
        Bundle bundle = new Bundle();
        int i10 = this.f4166p;
        Feature[] featureArr = GetServiceRequest.f12504p;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i10, i9, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f12508d = this.f4154c.getPackageName();
        getServiceRequest.f12511g = bundleQ;
        if (set != null) {
            getServiceRequest.f12510f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (k()) {
            Account accountO = o();
            if (accountO == null) {
                accountO = new Account(HuaweiApiClientImpl.DEFAULT_ACCOUNT, "com.google");
            }
            getServiceRequest.f12512h = accountO;
            if (bVar != null) {
                getServiceRequest.f12509e = bVar.asBinder();
            }
        }
        getServiceRequest.f12513i = f4151w;
        getServiceRequest.j = p();
        if (this instanceof p056h5.r) {
            getServiceRequest.f12516m = true;
        }
        try {
            synchronized (this.f4158g) {
                try {
                    InterfaceC0374e interfaceC0374e = this.f4159h;
                    if (interfaceC0374e != null) {
                        interfaceC0374e.L(new G(this, this.f4171v.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e9) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e9);
            int i11 = this.f4171v.get();
            E e10 = this.f4156e;
            e10.sendMessage(e10.obtainMessage(6, i11, 3));
        } catch (RemoteException e11) {
            e = e11;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i12 = this.f4171v.get();
            I i13 = new I(this, 8, null, null);
            E e12 = this.f4156e;
            e12.sendMessage(e12.obtainMessage(1, i12, -1, i13));
        } catch (SecurityException e13) {
            throw e13;
        } catch (RuntimeException e14) {
            e = e14;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i14 = this.f4171v.get();
            I i15 = new I(this, 8, null, null);
            E e15 = this.f4156e;
            e15.sendMessage(e15.obtainMessage(1, i14, -1, i15));
        }
    }

    public final void d(String str) {
        this.f4152a = str;
        disconnect();
    }

    public final void disconnect() {
        this.f4171v.incrementAndGet();
        synchronized (this.f4161k) {
            try {
                int size = this.f4161k.size();
                for (int i9 = 0; i9 < size; i9++) {
                    F f6 = (F) this.f4161k.get(i9);
                    synchronized (f6) {
                        f6.f4123a = null;
                    }
                }
                this.f4161k.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f4158g) {
            this.f4159h = null;
        }
        x(1, null);
    }

    public final boolean e() {
        return true;
    }

    public int f() {
        return O4.c.f3474a;
    }

    public final Feature[] g() {
        zzk zzkVar = this.f4170u;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.f12551b;
    }

    public final String h() {
        if (!isConnected() || this.f4153b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return "com.google.android.gms";
    }

    public final void i(InterfaceC0049a interfaceC0049a) {
        this.f4160i = interfaceC0049a;
        x(2, null);
    }

    public final boolean isConnected() {
        boolean z8;
        synchronized (this.f4157f) {
            z8 = this.f4163m == 4;
        }
        return z8;
    }

    public final boolean isConnecting() {
        boolean z8;
        synchronized (this.f4157f) {
            int i9 = this.f4163m;
            z8 = true;
            if (i9 != 2 && i9 != 3) {
                z8 = false;
            }
        }
        return z8;
    }

    public final String j() {
        return this.f4152a;
    }

    public boolean k() {
        return false;
    }

    public final void m(B0.T t) {
        ((C0369z) t.f1668b).f3863x.f3822m.post(new RunnableC0368y(t));
    }

    public abstract T n(IBinder iBinder);

    public Account o() {
        return null;
    }

    public Feature[] p() {
        return f4151w;
    }

    public Bundle q() {
        return new Bundle();
    }

    public final T r() {
        T t;
        synchronized (this.f4157f) {
            try {
                if (this.f4163m == 5) {
                    throw new DeadObjectException();
                }
                if (!isConnected()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                t = (T) this.j;
                C0376g.f(t, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    public abstract String s();

    public abstract String t();

    public boolean u() {
        return f() >= 211700000;
    }

    public void v() {
        System.currentTimeMillis();
    }

    public final void x(int i9, IInterface iInterface) {
        N3.a aVar;
        if ((i9 == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f4157f) {
            try {
                this.f4163m = i9;
                this.j = iInterface;
                if (i9 == 1) {
                    H h9 = this.f4162l;
                    if (h9 != null) {
                        S s8 = this.f4155d;
                        String str = this.f4153b.f3201a;
                        C0376g.e(str);
                        this.f4153b.getClass();
                        if (this.f4167q == null) {
                            this.f4154c.getClass();
                        }
                        s8.a(str, h9, this.f4153b.f3202b);
                        this.f4162l = null;
                    }
                } else if (i9 == 2 || i9 == 3) {
                    H h10 = this.f4162l;
                    if (h10 != null && (aVar = this.f4153b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + aVar.f3201a + " on com.google.android.gms");
                        S s9 = this.f4155d;
                        String str2 = this.f4153b.f3201a;
                        C0376g.e(str2);
                        this.f4153b.getClass();
                        if (this.f4167q == null) {
                            this.f4154c.getClass();
                        }
                        s9.a(str2, h10, this.f4153b.f3202b);
                        this.f4171v.incrementAndGet();
                    }
                    H h11 = new H(this, this.f4171v.get());
                    this.f4162l = h11;
                    String strT = t();
                    boolean zU = u();
                    this.f4153b = new N3.a(strT, zU);
                    if (zU && f() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f4153b.f3201a)));
                    }
                    S s10 = this.f4155d;
                    String str3 = this.f4153b.f3201a;
                    C0376g.e(str3);
                    this.f4153b.getClass();
                    String name = this.f4167q;
                    if (name == null) {
                        name = this.f4154c.getClass().getName();
                    }
                    if (!s10.b(new O(str3, this.f4153b.f3202b), h11, name, null)) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f4153b.f3201a + " on com.google.android.gms");
                        int i10 = this.f4171v.get();
                        J j = new J(this, 16);
                        E e9 = this.f4156e;
                        e9.sendMessage(e9.obtainMessage(7, i10, -1, j));
                    }
                } else if (i9 == 4) {
                    C0376g.e(iInterface);
                    System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

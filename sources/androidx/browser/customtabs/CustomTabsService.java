package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.browser.customtabs.CustomTabsService;
import java.util.List;
import java.util.NoSuchElementException;
import p006b.c;
import p006b.d;
import p006b.e;
import p130r.k;
import p155u.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabsService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<IBinder, IBinder.DeathRecipient> f6739a = new g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6740b = new a();

    public class a extends d.a {
        public a() {
            attachInterface(this, d.f8473o);
        }

        public static PendingIntent y(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        @Override // p006b.d
        public final boolean G() {
            return CustomTabsService.this.i();
        }

        @Override // p006b.d
        public final boolean M(c cVar, IBinder iBinder, Bundle bundle) {
            IInterface iInterfaceQueryLocalInterface;
            if (iBinder != null && (iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(e.f8476p)) != null && (iInterfaceQueryLocalInterface instanceof e)) {
            }
            new k(cVar, y(bundle));
            return false;
        }

        public final boolean O(c cVar, PendingIntent pendingIntent) {
            final k kVar = new k(cVar, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: r.f
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        CustomTabsService.a aVar = this.f21079a;
                        k kVar2 = kVar;
                        CustomTabsService customTabsService = CustomTabsService.this;
                        customTabsService.getClass();
                        try {
                            synchronized (customTabsService.f6739a) {
                                try {
                                    c cVar2 = kVar2.f21089a;
                                    IBinder iBinderAsBinder = cVar2 == null ? null : cVar2.asBinder();
                                    if (iBinderAsBinder == null) {
                                        return;
                                    }
                                    iBinderAsBinder.unlinkToDeath(customTabsService.f6739a.get(iBinderAsBinder), 0);
                                    customTabsService.f6739a.remove(iBinderAsBinder);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } catch (NoSuchElementException unused) {
                        }
                    }
                };
                synchronized (CustomTabsService.this.f6739a) {
                    cVar.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.f6739a.put(cVar.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.c();
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // p006b.d
        public final boolean b(c cVar, Uri uri) {
            new k(cVar, null);
            new Bundle();
            return CustomTabsService.this.f();
        }

        @Override // p006b.d
        public final boolean g(c cVar, Uri uri, Bundle bundle) {
            new k(cVar, y(bundle));
            if (bundle != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                }
            }
            return CustomTabsService.this.f();
        }

        @Override // p006b.d
        public final boolean h(c cVar, Bundle bundle) {
            new k(cVar, y(bundle));
            return false;
        }

        @Override // p006b.d
        public final boolean i(p130r.c cVar) {
            return O(cVar, null);
        }

        @Override // p006b.d
        public final int j(c cVar, String str, Bundle bundle) {
            new k(cVar, y(bundle));
            return CustomTabsService.this.d();
        }

        @Override // p006b.d
        public final boolean m(c cVar, int i9, Uri uri, Bundle bundle) {
            new k(cVar, y(bundle));
            return CustomTabsService.this.h();
        }

        @Override // p006b.d
        public final boolean n(c cVar, Bundle bundle) {
            new k(cVar, y(bundle));
            return CustomTabsService.this.g();
        }

        @Override // p006b.d
        public final boolean v(c cVar, Uri uri, Bundle bundle, List<Bundle> list) {
            new k(cVar, y(bundle));
            return CustomTabsService.this.b();
        }
    }

    public abstract Bundle a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract int d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f6740b;
    }
}

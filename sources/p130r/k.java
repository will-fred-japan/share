package p130r;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import p006b.c;

/* JADX INFO: compiled from: CustomTabsSessionToken.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f21089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f21090b;

    /* JADX INFO: compiled from: CustomTabsSessionToken.java */
    public class a extends b {
        public a() {
        }

        @Override // p130r.b
        public final void extraCallback(String str, Bundle bundle) {
            try {
                k.this.f21089a.l(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final Bundle extraCallbackWithResult(String str, Bundle bundle) {
            try {
                return k.this.f21089a.u(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                return null;
            }
        }

        @Override // p130r.b
        public final void onActivityLayout(int i9, int i10, int i11, int i12, int i13, Bundle bundle) {
            try {
                k.this.f21089a.o(i9, i10, i11, i12, i13, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final void onActivityResized(int i9, int i10, Bundle bundle) {
            try {
                k.this.f21089a.c(i9, i10, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final void onMessageChannelReady(Bundle bundle) {
            try {
                k.this.f21089a.D(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final void onMinimized(Bundle bundle) {
            try {
                k.this.f21089a.H(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final void onNavigationEvent(int i9, Bundle bundle) {
            try {
                k.this.f21089a.r(i9, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final void onPostMessage(String str, Bundle bundle) {
            try {
                k.this.f21089a.C(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final void onRelationshipValidationResult(int i9, Uri uri, boolean z8, Bundle bundle) {
            try {
                k.this.f21089a.F(i9, uri, z8, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final void onUnminimized(Bundle bundle) {
            try {
                k.this.f21089a.K(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // p130r.b
        public final void onWarmupCompleted(Bundle bundle) {
            try {
                k.this.f21089a.p(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    public k(c cVar, PendingIntent pendingIntent) {
        if (cVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f21089a = cVar;
        this.f21090b = pendingIntent;
        if (cVar == null) {
            return;
        }
        new a();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            PendingIntent pendingIntent = kVar.f21090b;
            PendingIntent pendingIntent2 = this.f21090b;
            if ((pendingIntent2 == null) == (pendingIntent == null)) {
                if (pendingIntent2 != null) {
                    return pendingIntent2.equals(pendingIntent);
                }
                c cVar = this.f21089a;
                if (cVar == null) {
                    throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
                }
                IBinder iBinderAsBinder = cVar.asBinder();
                c cVar2 = kVar.f21089a;
                if (cVar2 != null) {
                    return iBinderAsBinder.equals(cVar2.asBinder());
                }
                throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
            }
        }
        return false;
    }

    public final int hashCode() {
        PendingIntent pendingIntent = this.f21090b;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        c cVar = this.f21089a;
        if (cVar != null) {
            return cVar.asBinder().hashCode();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }
}

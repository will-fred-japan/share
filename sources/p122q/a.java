package p122q;

import android.app.PendingIntent;
import android.os.IBinder;
import p006b.b;

/* JADX INFO: compiled from: AuthTabSessionToken.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f20874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f20875b;

    public a(b bVar, PendingIntent pendingIntent) {
        if (bVar == null && pendingIntent == null) {
            throw new IllegalStateException("AuthTabSessionToken must have either a session id or a callback (or both).");
        }
        this.f20874a = bVar;
        this.f20875b = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            PendingIntent pendingIntent = aVar.f20875b;
            PendingIntent pendingIntent2 = this.f20875b;
            if ((pendingIntent2 == null) == (pendingIntent == null)) {
                if (pendingIntent2 != null) {
                    return pendingIntent2.equals(pendingIntent);
                }
                b bVar = this.f20874a;
                if (bVar == null) {
                    throw new IllegalStateException("AuthTabSessionToken must have valid binder or pending session");
                }
                IBinder iBinderAsBinder = bVar.asBinder();
                b bVar2 = aVar.f20874a;
                if (bVar2 != null) {
                    return iBinderAsBinder.equals(bVar2.asBinder());
                }
                throw new IllegalStateException("AuthTabSessionToken must have valid binder or pending session");
            }
        }
        return false;
    }

    public final int hashCode() {
        PendingIntent pendingIntent = this.f20875b;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        b bVar = this.f20874a;
        if (bVar != null) {
            return bVar.asBinder().hashCode();
        }
        throw new IllegalStateException("AuthTabSessionToken must have valid binder or pending session");
    }
}

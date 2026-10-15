package S4;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x extends F {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f4205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0370a f4206f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(AbstractC0370a abstractC0370a, int i9, Bundle bundle) {
        super(abstractC0370a);
        this.f4206f = abstractC0370a;
        this.f4204d = i9;
        this.f4205e = bundle;
    }

    @Override // S4.F
    public final /* bridge */ /* synthetic */ void a() {
        AbstractC0370a abstractC0370a = this.f4206f;
        int i9 = this.f4204d;
        if (i9 != 0) {
            abstractC0370a.x(1, null);
            Bundle bundle = this.f4205e;
            c(new ConnectionResult(i9, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (d()) {
                return;
            }
            abstractC0370a.x(1, null);
            c(new ConnectionResult(8, null));
        }
    }

    public abstract void c(ConnectionResult connectionResult);

    public abstract boolean d();
}

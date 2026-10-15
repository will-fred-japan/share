package S4;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class J extends x {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC0370a f4132g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(AbstractC0370a abstractC0370a, int i9) {
        super(abstractC0370a, i9, null);
        this.f4132g = abstractC0370a;
    }

    @Override // S4.x
    public final void c(ConnectionResult connectionResult) {
        AbstractC0370a abstractC0370a = this.f4132g;
        abstractC0370a.getClass();
        abstractC0370a.f4160i.a(connectionResult);
        System.currentTimeMillis();
    }

    @Override // S4.x
    public final boolean d() {
        this.f4132g.f4160i.a(ConnectionResult.f12449e);
        return true;
    }
}

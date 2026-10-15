package Q4;

import S4.C0371b;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class O extends p086l5.c implements P4.d.a, P4.d.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p079k5.b f3778h = p079k5.e.f19973a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p041f5.h f3780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p079k5.b f3781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f3782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0371b f3783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p079k5.f f3784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C f3785g;

    public O(Context context, p041f5.h hVar, C0371b c0371b) {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
        this.f3779a = context;
        this.f3780b = hVar;
        this.f3783e = c0371b;
        this.f3782d = c0371b.f4174b;
        this.f3781c = f3778h;
    }

    @Override // Q4.InterfaceC0347c
    public final void onConnected() {
        this.f3784f.a(this);
    }

    @Override // Q4.InterfaceC0347c
    public final void onConnectionSuspended(int i9) {
        C c5 = this.f3785g;
        C0369z c0369z = (C0369z) c5.f3756f.j.get(c5.f3752b);
        if (c0369z != null) {
            if (c0369z.f3859i) {
                c0369z.n(new ConnectionResult(17));
            } else {
                c0369z.onConnectionSuspended(i9);
            }
        }
    }

    @Override // Q4.InterfaceC0354j
    public final void y(ConnectionResult connectionResult) {
        this.f3785g.b(connectionResult);
    }
}

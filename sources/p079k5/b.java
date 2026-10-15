package p079k5;

import P4.a;
import P4.d;
import S4.C0371b;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a.AbstractC0036a {
    @Override // P4.a.AbstractC0036a
    public final a.e a(Context context, Looper looper, C0371b c0371b, Object obj, d.a aVar, d.b bVar) {
        c0371b.getClass();
        Integer num = c0371b.f4179g;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c0371b.f4173a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return new p086l5.a(context, looper, c0371b, bundle, aVar, bVar);
    }
}

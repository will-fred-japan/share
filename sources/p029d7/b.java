package p029d7;

import android.content.Context;
import android.hardware.biometrics.BiometricPrompt;
import android.media.session.MediaSessionManager;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ BiometricPrompt.AuthenticationResult b(Object obj) {
        return (BiometricPrompt.AuthenticationResult) obj;
    }

    public static /* synthetic */ BiometricPrompt.Builder c(Context context) {
        return new BiometricPrompt.Builder(context);
    }

    public static /* synthetic */ void f(int i9, int i10, String str) {
        new MediaSessionManager.RemoteUserInfo(str, i9, i10);
    }
}

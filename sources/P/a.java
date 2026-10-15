package P;

import android.os.Build;
import android.os.ext.SdkExtensions;

/* JADX INFO: compiled from: BuildCompat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3597a = 0;

    /* JADX INFO: renamed from: P.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BuildCompat.kt */
    public static final class C0035a {
        public static void a(int i9) {
            SdkExtensions.getExtensionVersion(i9);
        }
    }

    static {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30) {
            C0035a.a(30);
        }
        if (i9 >= 30) {
            C0035a.a(31);
        }
        if (i9 >= 30) {
            C0035a.a(33);
        }
        if (i9 >= 30) {
            C0035a.a(1000000);
        }
    }
}

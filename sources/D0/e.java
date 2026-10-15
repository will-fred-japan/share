package D0;

import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.z;

/* JADX INFO: compiled from: ExtensionsUtil.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f1821a = new e();

    static {
        z.a(e.class).d();
    }

    public static int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return 0;
        }
    }
}

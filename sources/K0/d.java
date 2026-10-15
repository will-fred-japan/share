package K0;

import T.Q;
import android.content.Context;
import android.view.WindowInsets;
import android.view.WindowManager;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ContextCompatHelper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2765a = new d();

    public final Q a(Context context) {
        k.e(context, "context");
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        k.d(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        return Q.g(null, windowInsets);
    }
}

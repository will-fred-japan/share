package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: compiled from: TintContextWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public final class H extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f6414a = null;

    public static void a(Context context) {
        if ((context instanceof H) || (context.getResources() instanceof J)) {
            return;
        }
        context.getResources();
        int i9 = P.f6463a;
    }
}

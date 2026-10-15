package p133r2;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: compiled from: ApmHandlerThread.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f21105a;

    static {
        new HashSet();
        f21105a = new Handler(Looper.getMainLooper());
    }
}

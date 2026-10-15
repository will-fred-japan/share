package T;

import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: T.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: VelocityTrackerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0438z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<VelocityTracker, A> f4460a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: T.z$a */
    /* JADX INFO: compiled from: VelocityTrackerCompat.java */
    public static class a {
        public static float a(VelocityTracker velocityTracker, int i9) {
            return velocityTracker.getAxisVelocity(i9);
        }
    }
}

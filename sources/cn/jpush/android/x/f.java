package cn.jpush.android.x;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Queue<Integer> f11791a = new ConcurrentLinkedQueue();

    public static int a() {
        if (f11791a.size() > 0) {
            return f11791a.poll().intValue();
        }
        return 0;
    }

    public static int b() {
        return f11791a.size();
    }

    public static boolean a(int i9) {
        return f11791a.offer(Integer.valueOf(i9));
    }

    public static boolean b(int i9) {
        return f11791a.contains(Integer.valueOf(i9));
    }
}

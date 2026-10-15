package com.engagelab.privates.common;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Queue<Integer> f12405a = new ConcurrentLinkedQueue();

    public static boolean a() {
        return f12405a.isEmpty();
    }

    public static int b() {
        if (f12405a.size() > 0) {
            return f12405a.poll().intValue();
        }
        return 0;
    }

    public static boolean c(int i9) {
        return f12405a.remove(Integer.valueOf(i9));
    }

    public static boolean a(int i9) {
        return f12405a.contains(Integer.valueOf(i9));
    }

    public static int c() {
        return f12405a.size();
    }

    public static boolean b(int i9) {
        return f12405a.offer(Integer.valueOf(i9));
    }
}

package p088l7;

import android.util.DisplayMetrics;
import java.util.concurrent.ConcurrentLinkedQueue;
import p096m7.b;
import p096m7.f;

/* JADX INFO: compiled from: SettingsChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f20204a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<Object> f20205b;

    /* JADX INFO: compiled from: SettingsChannel.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedQueue<C0227a> f20206a = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C0227a f20207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0227a f20208c;

        /* JADX INFO: renamed from: l7.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SettingsChannel.java */
        public static class C0227a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static int f20209c = Integer.MIN_VALUE;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f20210a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DisplayMetrics f20211b;

            public C0227a(DisplayMetrics displayMetrics) {
                int i9 = f20209c;
                f20209c = i9 + 1;
                this.f20210a = i9;
                this.f20211b = displayMetrics;
            }
        }
    }

    public u(p013b7.a aVar) {
        this.f20205b = new b<>(aVar, "flutter/settings", f.f20494a, null);
    }
}

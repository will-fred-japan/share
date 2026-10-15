package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class hn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ai f17653a = new ai(true, 20);

    public static void a(final Runnable runnable) {
        f17653a.a(new ai.b() { // from class: com.xiaomi.push.hn.1
            @Override // com.xiaomi.push.ai.b
            public void b() {
                runnable.run();
            }
        });
    }

    public static void a(ai.b bVar) {
        f17653a.a(bVar);
    }

    public static void a(ai.b bVar, long j) {
        f17653a.a(bVar, j);
    }
}

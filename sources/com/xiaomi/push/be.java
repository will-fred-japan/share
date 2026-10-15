package com.xiaomi.push;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
class be extends az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<be> f17077a = new AtomicReference<>();

    private be() {
        super(4, 10L, TimeUnit.SECONDS, 10000, "light");
    }

    public static be a() {
        AtomicReference<be> atomicReference = f17077a;
        if (atomicReference.get() == null || atomicReference.get().isTerminated()) {
            synchronized (be.class) {
                try {
                    if (atomicReference.get() == null || atomicReference.get().isTerminated()) {
                        atomicReference.set(new be());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return atomicReference.get();
    }
}

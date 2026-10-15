package p117p3;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: MemoryWidgetThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20788a;

    public b(String str) {
        this.f20788a = "MemoryWidget_".concat(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f20788a);
    }
}

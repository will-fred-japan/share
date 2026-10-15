package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile dw f17285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private dv f300a;

    public static dw a() {
        if (f17285a == null) {
            synchronized (dw.class) {
                try {
                    if (f17285a == null) {
                        f17285a = new dw();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17285a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public dv m254a() {
        return this.f300a;
    }

    public void a(dv dvVar) {
        this.f300a = dvVar;
    }
}

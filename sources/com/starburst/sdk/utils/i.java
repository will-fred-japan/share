package com.starburst.sdk.utils;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class i extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList arrayList = new ArrayList(100);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = j.f16467q;
                String str = (String) linkedBlockingQueue.poll(100L, TimeUnit.MILLISECONDS);
                if (str != null) {
                    arrayList.add(str);
                    linkedBlockingQueue.drainTo(arrayList, 99);
                }
                if (!arrayList.isEmpty()) {
                    j.z(arrayList);
                    arrayList.clear();
                }
            } catch (InterruptedException unused) {
            }
        }
        synchronized (j.f16466p) {
            try {
                j.f16467q.drainTo(arrayList);
                if (!arrayList.isEmpty()) {
                    j.z(arrayList);
                    arrayList.clear();
                }
                j.c();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

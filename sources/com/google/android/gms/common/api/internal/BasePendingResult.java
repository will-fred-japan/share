package com.google.android.gms.common.api.internal;

import P4.e;
import P4.f;
import P4.h;
import P4.i;
import Q4.a0;
import Q4.b0;
import S4.C0376g;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepName
public abstract class BasePendingResult<R extends h> extends e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12472a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f12473b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f12474c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f12475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12476e;

    @KeepName
    private b0 resultGuardian;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static class a<R extends h> extends p041f5.h {
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i9 = message.what;
            if (i9 != 1) {
                if (i9 != 2) {
                    Log.wtf("BasePendingResult", W5.e.i(i9, "Don't know how to handle message: "), new Exception());
                    return;
                } else {
                    ((BasePendingResult) message.obj).b(Status.f12466f);
                    return;
                }
            }
            Pair pair = (Pair) message.obj;
            i iVar = (i) pair.first;
            h hVar = (h) pair.second;
            try {
                iVar.a();
            } catch (RuntimeException e9) {
                BasePendingResult.f(hVar);
                throw e9;
            }
        }
    }

    static {
        new a0();
    }

    @Deprecated
    public BasePendingResult() {
        new AtomicReference();
        new a(Looper.getMainLooper());
        new WeakReference(null);
    }

    public static void f(h hVar) {
        if (hVar instanceof f) {
            try {
                ((f) hVar).release();
            } catch (RuntimeException e9) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(hVar)), e9);
            }
        }
    }

    public abstract h a();

    @Deprecated
    public final void b(Status status) {
        synchronized (this.f12472a) {
            try {
                if (!c()) {
                    d(a());
                    this.f12476e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        return this.f12473b.getCount() == 0;
    }

    public final void d(R r8) {
        synchronized (this.f12472a) {
            try {
                if (this.f12476e) {
                    f(r8);
                    return;
                }
                c();
                C0376g.g("Results have already been set", !c());
                C0376g.g("Result has already been consumed", !false);
                e(r8);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(h hVar) {
        this.f12475d = hVar;
        hVar.b();
        this.f12473b.countDown();
        if (this.f12475d instanceof f) {
            this.resultGuardian = new b0(this);
        }
        ArrayList arrayList = this.f12474c;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((e.a) arrayList.get(i9)).a();
        }
        this.f12474c.clear();
    }
}

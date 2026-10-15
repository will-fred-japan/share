package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p022d0.i;
import p022d0.j;
import p022d0.m;

/* JADX INFO: compiled from: EmojiCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final Object j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile c f7369k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f7370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p155u.b f7371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f7372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f7373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f7374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f7375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f7376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p022d0.c f7378i;

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile p022d0.g f7379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile i f7380c;
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f7381a;

        public b(c cVar) {
            this.f7381a = cVar;
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EmojiCompat.java */
    public static abstract class AbstractC0103c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f7382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7383b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p022d0.c f7384c = new p022d0.c();

        public AbstractC0103c(g gVar) {
            this.f7382a = gVar;
        }
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static class d {
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f7385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7386b;

        public f(List list, int i9, Throwable th) {
            A1.b.K0(list, "initCallbacks cannot be null");
            this.f7385a = new ArrayList(list);
            this.f7386b = i9;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = this.f7385a;
            int size = arrayList.size();
            int i9 = 0;
            if (this.f7386b != 1) {
                while (i9 < size) {
                    ((e) arrayList.get(i9)).a();
                    i9++;
                }
            } else {
                while (i9 < size) {
                    ((e) arrayList.get(i9)).b();
                    i9++;
                }
            }
        }
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public interface g {
        void a(h hVar);
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(i iVar);
    }

    public c(EmojiCompatInitializer.a aVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f7370a = reentrantReadWriteLock;
        this.f7372c = 3;
        g gVar = aVar.f7382a;
        this.f7375f = gVar;
        int i9 = aVar.f7383b;
        this.f7377h = i9;
        this.f7378i = aVar.f7384c;
        this.f7373d = new Handler(Looper.getMainLooper());
        this.f7371b = new p155u.b(0);
        this.f7376g = new d();
        a aVar2 = new a(this);
        this.f7374e = aVar2;
        reentrantReadWriteLock.writeLock().lock();
        if (i9 == 0) {
            try {
                this.f7372c = 0;
            } catch (Throwable th) {
                this.f7370a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                gVar.a(new androidx.emoji2.text.b(aVar2));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static c a() {
        c cVar;
        synchronized (j) {
            try {
                cVar = f7369k;
                if (!(cVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public final int b() {
        this.f7370a.readLock().lock();
        try {
            return this.f7372c;
        } finally {
            this.f7370a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f7377h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f7370a.writeLock().lock();
        try {
            if (this.f7372c == 0) {
                this.f7370a.writeLock().unlock();
                return;
            }
            this.f7372c = 0;
            this.f7370a.writeLock().unlock();
            a aVar = this.f7374e;
            c cVar = aVar.f7381a;
            try {
                cVar.f7375f.a(new androidx.emoji2.text.b(aVar));
            } catch (Throwable th) {
                cVar.d(th);
            }
        } catch (Throwable th2) {
            this.f7370a.writeLock().unlock();
            throw th2;
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f7370a.writeLock().lock();
        try {
            this.f7372c = 2;
            arrayList.addAll(this.f7371b);
            this.f7371b.clear();
            this.f7370a.writeLock().unlock();
            this.f7373d.post(new f(arrayList, this.f7372c, th));
        } catch (Throwable th2) {
            this.f7370a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x009f A[Catch: all -> 0x0082, TryCatch #1 {all -> 0x0082, blocks: (B:32:0x005a, B:35:0x005f, B:37:0x0063, B:39:0x0070, B:46:0x008f, B:48:0x0099, B:50:0x009c, B:52:0x009f, B:54:0x00af, B:55:0x00b2), top: B:91:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00af A[Catch: all -> 0x0082, TryCatch #1 {all -> 0x0082, blocks: (B:32:0x005a, B:35:0x005f, B:37:0x0063, B:39:0x0070, B:46:0x008f, B:48:0x0099, B:50:0x009c, B:52:0x009f, B:54:0x00af, B:55:0x00b2), top: B:91:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:96:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    public final CharSequence e(CharSequence charSequence, int i9, int i10) throws Throwable {
        Throwable th;
        CharSequence charSequence2;
        int i11;
        int i12;
        p022d0.h[] hVarArr;
        int spanStart;
        if (!(b() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i9 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        A1.b.G0("start should be <= than end", i9 <= i10);
        m mVar = null;
        if (charSequence == null) {
            return null;
        }
        A1.b.G0("start should be < than charSequence length", i9 <= charSequence.length());
        A1.b.G0("end should be < than charSequence length", i10 <= charSequence.length());
        if (charSequence.length() == 0 || i9 == i10) {
            return charSequence;
        }
        p022d0.g gVar = this.f7374e.f7379b;
        gVar.getClass();
        boolean z8 = charSequence instanceof j;
        if (z8) {
            ((j) charSequence).a();
        }
        if (z8) {
            mVar = new m((Spannable) charSequence);
            if (mVar != null) {
                for (p022d0.h hVar : hVarArr) {
                    spanStart = mVar.f18484b.getSpanStart(hVar);
                    int spanEnd = mVar.f18484b.getSpanEnd(hVar);
                    if (spanStart != i10) {
                        mVar.removeSpan(hVar);
                    }
                    i9 = Math.min(spanStart, i9);
                    i10 = Math.max(spanEnd, i10);
                }
            }
            i11 = i9;
            i12 = i10;
            if (i11 != i12) {
                charSequence2 = charSequence;
                if (!z8) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                if (!z8) {
                    return charSequence2;
                }
            }
            ((j) charSequence2).b();
            return charSequence2;
        }
        try {
            if (charSequence instanceof Spannable) {
                try {
                    mVar = new m((Spannable) charSequence);
                } catch (Throwable th2) {
                    th = th2;
                    charSequence2 = charSequence;
                    th = th;
                    if (!z8) {
                        throw th;
                    }
                    ((j) charSequence2).b();
                    throw th;
                }
            } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i9 - 1, i10 + 1, p022d0.h.class) <= i10) {
                mVar = new m();
                mVar.f18483a = false;
                mVar.f18484b = new SpannableString(charSequence);
            }
            if (mVar != null && (hVarArr = (p022d0.h[]) mVar.f18484b.getSpans(i9, i10, p022d0.h.class)) != null && hVarArr.length > 0) {
                while (i < r5) {
                    spanStart = mVar.f18484b.getSpanStart(hVar);
                    int spanEnd2 = mVar.f18484b.getSpanEnd(hVar);
                    if (spanStart != i10) {
                        mVar.removeSpan(hVar);
                    }
                    i9 = Math.min(spanStart, i9);
                    i10 = Math.max(spanEnd2, i10);
                }
            }
            i11 = i9;
            i12 = i10;
            if (i11 != i12 || i11 >= charSequence.length()) {
                charSequence2 = charSequence;
                if (!z8) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                try {
                    m mVar2 = (m) gVar.c(charSequence2, i11, i12, Integer.MAX_VALUE, false, new d0.g.a(mVar, gVar.f18452a));
                    if (mVar2 != null) {
                        Spannable spannable = mVar2.f18484b;
                        if (z8) {
                            ((j) charSequence2).b();
                        }
                        return spannable;
                    }
                    if (!z8) {
                        return charSequence2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (!z8) {
                        throw th;
                    }
                    ((j) charSequence2).b();
                    throw th;
                }
            }
            ((j) charSequence2).b();
            return charSequence2;
        } catch (Throwable th4) {
            th = th4;
            charSequence2 = charSequence;
        }
        if (!z8) {
            throw th;
        }
        ((j) charSequence2).b();
        throw th;
    }

    public final void f(e eVar) {
        A1.b.K0(eVar, "initCallback cannot be null");
        this.f7370a.writeLock().lock();
        try {
            if (this.f7372c == 1 || this.f7372c == 2) {
                this.f7373d.post(new f(Arrays.asList(eVar), this.f7372c, null));
            } else {
                this.f7371b.add(eVar);
            }
        } finally {
            this.f7370a.writeLock().unlock();
        }
    }

    /* JADX INFO: compiled from: EmojiCompat.java */
    public static abstract class e {
        public void a() {
        }

        public void b() {
        }
    }
}

package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;
import p022d0.i;

/* JADX INFO: compiled from: EmojiCompatInitializer.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends c.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.h f7387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f7388b;

    public d(c.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f7387a = hVar;
        this.f7388b = threadPoolExecutor;
    }

    @Override // androidx.emoji2.text.c.h
    public final void a(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f7388b;
        try {
            this.f7387a.a(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // androidx.emoji2.text.c.h
    public final void b(i iVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f7388b;
        try {
            this.f7387a.b(iVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}

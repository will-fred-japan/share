package N6;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: N6.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0332c implements K7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0334e f3311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicLong f3313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f3314d;

    public /* synthetic */ C0332c(C0334e c0334e, long j, AtomicLong atomicLong, long j8) {
        this.f3311a = c0334e;
        this.f3312b = j;
        this.f3313c = atomicLong;
        this.f3314d = j8;
    }

    @Override // K7.a
    public final Object invoke() {
        return Boolean.valueOf(this.f3311a.f3318a.get() == this.f3312b && this.f3313c.get() == this.f3314d);
    }
}

package p087l6;

import java.util.HashMap;
import p096m7.k;

/* JADX INFO: compiled from: JPushHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f20085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f20086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f20087c;

    public b(d dVar, k kVar, HashMap map) {
        this.f20087c = dVar;
        this.f20085a = kVar;
        this.f20086b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f20085a.success(this.f20086b);
        this.f20087c.f20100i = null;
    }
}

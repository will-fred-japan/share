package cn.jiguang.ad;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0118a[] f8949a = new C0118a[17];

    /* JADX INFO: renamed from: cn.jiguang.ad.a$a, reason: collision with other inner class name */
    public static class C0118a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g f8950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        C0118a f8952c;

        private C0118a() {
        }
    }

    public int a(g gVar) {
        int i9 = -1;
        for (C0118a c0118a = this.f8949a[(gVar.hashCode() & Integer.MAX_VALUE) % 17]; c0118a != null; c0118a = c0118a.f8952c) {
            if (c0118a.f8950a.equals(gVar)) {
                i9 = c0118a.f8951b;
            }
        }
        return i9;
    }

    public void a(int i9, g gVar) {
        if (i9 > 16383) {
            return;
        }
        int iHashCode = (gVar.hashCode() & Integer.MAX_VALUE) % 17;
        C0118a c0118a = new C0118a();
        c0118a.f8950a = gVar;
        c0118a.f8951b = i9;
        C0118a[] c0118aArr = this.f8949a;
        c0118a.f8952c = c0118aArr[iHashCode];
        c0118aArr[iHashCode] = c0118a;
    }
}

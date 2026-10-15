package p046g2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruKhighFreqHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f18848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap f18849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18851d;

    /* JADX INFO: compiled from: LruKhighFreqHelper.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18852a;

        static {
            b bVar = new b();
            bVar.f18850c = Math.min(3, 25);
            bVar.f18851d = 0;
            f18852a = bVar;
        }
    }

    public final synchronized void a(long j, String str) {
        try {
            if (this.f18849b == null) {
                this.f18849b = new HashMap();
            }
            if (this.f18849b.containsKey(str)) {
                e eVar = (e) this.f18849b.get(str);
                eVar.f18861c++;
                eVar.f18862d = System.currentTimeMillis();
                int i9 = eVar.f18861c;
                if (i9 > this.f18851d) {
                    this.f18851d = i9;
                }
            } else {
                HashMap map = this.f18848a;
                if (map != null) {
                    String str2 = null;
                    long j8 = Long.MAX_VALUE;
                    if (map.containsKey(str)) {
                        e eVar2 = (e) this.f18848a.get(str);
                        int i10 = eVar2.f18861c;
                        eVar2.f18861c = i10 + 1;
                        eVar2.f18862d = System.currentTimeMillis();
                        if (i10 > this.f18850c) {
                            this.f18848a.remove(str);
                            if (this.f18849b.size() >= 20) {
                                long jCurrentTimeMillis = System.currentTimeMillis() / 2;
                                for (Map.Entry entry : this.f18849b.entrySet()) {
                                    if (((e) entry.getValue()).f18862d < jCurrentTimeMillis && ((e) entry.getValue()).f18861c < j8) {
                                        j8 = ((e) entry.getValue()).f18861c;
                                        str2 = ((e) entry.getValue()).f18859a;
                                    }
                                }
                                if (str2 != null) {
                                    this.f18849b.remove(str2);
                                }
                            }
                            this.f18849b.put(str, eVar2);
                        }
                    } else {
                        if (this.f18848a.size() >= 50) {
                            for (Map.Entry entry2 : this.f18848a.entrySet()) {
                                if (((e) entry2.getValue()).f18862d < j8) {
                                    j8 = ((e) entry2.getValue()).f18862d;
                                    str2 = ((e) entry2.getValue()).f18859a;
                                }
                            }
                            if (str2 != null) {
                                this.f18848a.remove(str2);
                            }
                        }
                        this.f18848a.put(str, new e(str, j));
                    }
                } else {
                    HashMap map2 = new HashMap();
                    this.f18848a = map2;
                    map2.put(str, new e(str, j));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}

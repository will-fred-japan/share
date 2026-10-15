package cn.jiguang.commons.a;

import androidx.datastore.preferences.protobuf.C0524s;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Integer> f9749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f9750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, m> f9751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Integer> f9752d;

    private bq() {
        this.f9749a = new ArrayList(bf.f9723d);
        this.f9750b = new ArrayList();
        this.f9751c = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        this.f9752d = arrayList;
        arrayList.add(1106);
    }

    public static int a(String str) {
        Integer num = bf.f9721b.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static long b(String str) {
        Long l8 = bf.f9722c.get(str);
        if (l8 != null) {
            return l8.longValue();
        }
        return 0L;
    }

    public /* synthetic */ bq(byte b9) {
        this();
    }

    private boolean b(int i9, aa aaVar) {
        long jB = aaVar.b();
        if (jB <= 0) {
            return true;
        }
        m mVarA = a(i9);
        synchronized (mVarA) {
            try {
                int i10 = mVarA.f10392e;
                if (i10 >= jB) {
                    ee.a("DataCollectionController", "scd:" + i9 + " count limited:" + mVarA.f10392e + "/" + jB);
                    return false;
                }
                mVarA.f10392e = i10 + 1;
                ee.a("DataCollectionController", "scd:" + i9 + " count check ok:" + mVarA.f10392e + "/" + jB);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final long a(String str, int i9, long j) {
        try {
            aa aaVarA = bl.e().a(i9);
            if (aaVarA == null) {
                ee.a("DataCollectionController", "tag:" + str + " scd:" + i9 + " no config, delay:" + (j / 1000) + "s");
                return j;
            }
            long jA = aaVarA.a();
            if (this.f9750b.contains(str)) {
                jA = 0;
            } else {
                this.f9750b.add(str);
            }
            long j8 = jA + j;
            ee.a("DataCollectionController", "tag:" + str + " scd:" + i9 + " calc delay:" + (j8 / 1000) + "s (cold:" + (jA / 1000) + "s + extra:" + (j / 1000) + "s)");
            return j8;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("calc task delay failed, tag:");
            sb.append(str);
            sb.append(" scd:");
            sb.append(i9);
            sb.append(", err:");
            W5.f.o(th, sb, "DataCollectionController");
            return j;
        }
    }

    private boolean b(int i9, boolean z8) {
        try {
            if (z8) {
                ey.b().a(i9, 3009);
                return true;
            }
            aa aaVarA = bl.e().a(i9);
            if (aaVarA == null) {
                ee.a("DataCollectionController", "scd:" + i9 + " disabled");
                ey.b().a(i9, 3010);
                return false;
            }
            if (a(aaVarA)) {
                ey.b().a(i9, MTPushConstants.MainWhat.TAG_ADD);
                return false;
            }
            if (!b(aaVarA)) {
                ee.a("DataCollectionController", "scd:" + i9 + " not fg");
                ey.b().a(i9, MTPushConstants.MainWhat.TAG_DELETE);
                return false;
            }
            if (!a(i9, aaVarA)) {
                ey.b().a(i9, MTPushConstants.MainWhat.TAG_UPDATE);
                return false;
            }
            if (!b(i9, aaVarA)) {
                ey.b().a(i9, MTPushConstants.MainWhat.TAG_QUERY);
                return false;
            }
            ee.a("DataCollectionController", "scd:" + i9 + ",allow");
            ey.b().a(i9, MTPushConstants.MainWhat.TAG_DELETE_ALL);
            return true;
        } catch (Throwable th) {
            defpackage.f.n(th, C0524s.a(i9, "scd:", ",svc err="), "DataCollectionController");
            return false;
        }
    }

    public static bq a() {
        return bs.f9755a;
    }

    private m a(int i9) {
        return (m) ke.a((ConcurrentHashMap<Integer, V>) this.f9751c, Integer.valueOf(i9), (Callable) new br(this, i9));
    }

    public final Object a(int i9, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        try {
            if (!cb.f9788a.c()) {
                ee.a("DataCollectionController", "scd:" + i9 + ",no_auth");
                return Boolean.FALSE;
            }
            if (z8 && !bn.a().a(i9)) {
                ee.a("DataCollectionController", "scd:" + i9 + ",usr=f");
                return Boolean.FALSE;
            }
            aa aaVarA = bl.e().a(i9);
            if (aaVarA == null) {
                ee.a("DataCollectionController", "scd:" + i9 + " disabled");
                return Boolean.FALSE;
            }
            if (z9 && a(aaVarA)) {
                return Boolean.FALSE;
            }
            if (z10 && !b(aaVarA)) {
                return Boolean.FALSE;
            }
            if (!z11 || a(i9, aaVarA)) {
                return (!z12 || b(i9, aaVarA)) ? Boolean.TRUE : Boolean.FALSE;
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            defpackage.f.n(th, C0524s.a(i9, "scd:", ",all err="), "DataCollectionController");
            return Boolean.FALSE;
        }
    }

    private static boolean b(aa aaVar) {
        boolean zB = cb.f9788a.b();
        ee.a("DataCollectionController", "fg check:" + zB);
        return zB || aaVar.g() != 0;
    }

    private boolean a(int i9, aa aaVar) {
        String str;
        StringBuilder sb;
        String str2;
        int iH = aaVar.h();
        if (iH == 0) {
            str = "DataCollectionController";
            sb = new StringBuilder("scd:");
            sb.append(i9);
            str2 = " freq 0";
        } else {
            m mVarA = a(i9);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (iH != -1) {
                if (iH <= 0) {
                    return true;
                }
                synchronized (mVarA) {
                    try {
                        long jAbs = Math.abs(jCurrentTimeMillis - mVarA.f10390c);
                        long j = jAbs / 1000;
                        long j8 = iH / 1000;
                        if (jAbs < iH) {
                            ee.a("DataCollectionController", "scd:" + i9 + " freq check: elapsed:" + j + "s, limit:" + j8 + "s, result:skip");
                            return false;
                        }
                        mVarA.f10390c = jCurrentTimeMillis;
                        ee.a("DataCollectionController", "scd:" + i9 + " freq check: elapsed:" + j + "s, limit:" + j8 + "s, result:allow");
                        return true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (mVarA.f10391d.compareAndSet(false, true)) {
                str = "DataCollectionController";
                sb = new StringBuilder("scd:");
                sb.append(i9);
                str2 = " freq -1 check ok";
            } else {
                ee.a("DataCollectionController", "scd:" + i9 + " freq -1 collected");
                return false;
            }
        }
        sb.append(str2);
        ee.a(str, sb.toString());
        return true;
    }

    public final boolean a(int i9, boolean z8) {
        try {
            if (!cb.f9788a.c()) {
                ee.a("DataCollectionController", "scd:" + i9 + ",no_auth");
                ey.b().a(i9, MTPushConstants.PlatformNode.CODE_UPLOAD_TOKEN_SUCCESS);
                return false;
            }
            if (bn.a().a(i9)) {
                return b(i9, z8);
            }
            ee.a("DataCollectionController", "scd:" + i9 + ",usr=f");
            ey.b().a(i9, MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS);
            return false;
        } catch (Throwable th) {
            defpackage.f.n(th, C0524s.a(i9, "scd:", ",err="), "DataCollectionController");
            return false;
        }
    }

    public final boolean a(aa aaVar) {
        int iC = aaVar.c();
        long jE = aaVar.e();
        if (this.f9752d.contains(Integer.valueOf(iC))) {
            jE = Math.max(jE, 604800000L);
        }
        if (jE <= 0) {
            return false;
        }
        ca unused = cb.f9788a;
        long j = ca.j();
        if (j <= 0) {
            ee.a("DataCollectionController", "scd:" + iC + " server time <=0,value=" + j + "result: in rpp");
            return true;
        }
        long jAbs = Math.abs(System.currentTimeMillis() - j);
        long j8 = jAbs / 1000;
        long j9 = jE / 1000;
        boolean z8 = jAbs < jE;
        if (z8) {
            ee.a("DataCollectionController", "scd:" + iC + " elapsed:" + j8 + "s, limit:" + j9 + "s, result: in rpp");
        }
        return z8;
    }

    public final boolean a(String str, long j) {
        int iA = a(str);
        if (iA == -1) {
            ee.a("TopicManager", str + " no config mapping, skip");
            return false;
        }
        try {
            if (!cb.f9788a.c()) {
                ee.a("TopicManager", str + " scd:" + iA + ",no_auth");
                ey.b().a(iA, MTPushConstants.PlatformNode.CODE_UPLOAD_TOKEN_SUCCESS);
                return false;
            }
            if (!bn.a().a(iA)) {
                ee.a("TopicManager", str + " scd:" + iA + ",usr=f");
                ey.b().a(iA, MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS);
                return false;
            }
            aa aaVarA = bl.e().a(iA);
            if (aaVarA == null) {
                ee.a("TopicManager", str + " scd:" + iA + " disabled");
                ey.b().a(iA, 3010);
                return false;
            }
            if (a(aaVarA)) {
                ee.a("TopicManager", str + " scd:" + iA + " in rpp");
                ey.b().a(iA, MTPushConstants.MainWhat.TAG_ADD);
                return false;
            }
            long jB = AbstractC0552a.b(str);
            long jF = aaVarA.f() > 0 ? aaVarA.f() : 86400000L;
            boolean z8 = true;
            if (jB == 0) {
                ee.a("TopicManager", str + " scd:" + iA + " interval:first,allow");
                ey.b().a(iA, MTPushConstants.MainWhat.TAG_DELETE_ALL);
                return true;
            }
            long jAbs = Math.abs(j - jB);
            if (jAbs <= jF) {
                z8 = false;
            }
            long j8 = jAbs / 1000;
            long j9 = jF / 1000;
            if (z8) {
                ee.a("TopicManager", str + " scd:" + iA + " elapsed:" + j8 + "s,limit:" + j9 + "s,allow");
                ey.b().a(iA, MTPushConstants.MainWhat.TAG_DELETE_ALL);
                return z8;
            }
            ee.a("TopicManager", str + " scd:" + iA + " elapsed:" + j8 + "s,limit:" + j9 + "s,skip");
            ey.b().a(iA, MTPushConstants.MainWhat.TAG_QUERY_ALL);
            return z8;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("shouldCollectTopic failed: "), "DataCollectionController");
            return false;
        }
    }
}

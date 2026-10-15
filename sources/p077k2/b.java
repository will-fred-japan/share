package p077k2;

import android.app.Application;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import defpackage.f;
import p061i1.h;

/* JADX INFO: compiled from: NewTrafficStatisticsImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p077k2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f19925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f19926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f19927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f19928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f19929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f19930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f19931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f19932i;
    public NetworkStatsManager j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19933k;

    /* JADX INFO: compiled from: NewTrafficStatisticsImpl.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f19934a;

        public a(boolean z8) {
            this.f19934a = z8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.k();
            b.this.f19932i = !this.f19934a;
        }
    }

    @Override // p077k2.a
    public final void a(boolean z8) {
        p133r2.b.f21107i.a(new a(z8));
    }

    @Override // p077k2.a
    public final long b() {
        k();
        return this.f19930g;
    }

    @Override // p077k2.a
    public final long c() {
        k();
        return this.f19928e + this.f19930g;
    }

    @Override // p077k2.a
    public final long d() {
        k();
        return this.f19928e + this.f19927d;
    }

    @Override // p077k2.a
    public final long e() {
        k();
        return this.f19928e;
    }

    @Override // p077k2.a
    public final void f() {
        if (this.f19924a) {
            return;
        }
        this.f19924a = true;
        this.f19931h = SystemClock.elapsedRealtime();
        this.f19925b = b(1);
        this.f19926c = b(0);
        if (h.f19230b) {
            p010b3.b.a("NewTrafficStatisticsImp", "initTrafficData: mTotalWifiBytes:" + this.f19925b[0] + " mTotalWifiPackets:" + this.f19925b[1] + " mTotalMobileBytes:" + this.f19926c[0] + " mTotalMobilePackets:" + this.f19926c[1]);
        }
    }

    @Override // p077k2.a
    public final long g() {
        k();
        long j = this.f19928e + this.f19930g;
        k();
        return this.f19927d + this.f19929f + j;
    }

    @Override // p077k2.a
    public final long h() {
        k();
        return this.f19930g + this.f19929f;
    }

    @Override // p077k2.a
    public final long i() {
        k();
        return this.f19927d;
    }

    @Override // p077k2.a
    public final long j() {
        k();
        return this.f19927d + this.f19929f;
    }

    public final void k() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f19931h;
        if (jElapsedRealtime - j < 1000 || j == -1) {
            return;
        }
        long[] jArrB = b(1);
        long[] jArrB2 = b(0);
        long j8 = jArrB2[0];
        long[] jArr = this.f19926c;
        long j9 = j8 - jArr[0];
        long j10 = jArrB2[1];
        long j11 = jArr[1];
        this.f19926c = jArrB2;
        long j12 = jArrB[0];
        long[] jArr2 = this.f19925b;
        long j13 = j12 - jArr2[0];
        long j14 = jArrB[1];
        long j15 = jArr2[1];
        this.f19925b = jArrB;
        if (h.f19230b) {
            p010b3.b.a("NewTrafficStatisticsImp", "mTotalWifiBytes:" + this.f19925b[0] + " mTotalWifiPackets:" + this.f19925b[1] + " mTotalMobileBytes:" + this.f19926c[0] + " mTotalMobilePackets:" + this.f19926c[1]);
        }
        if (this.f19932i) {
            this.f19930g += j9;
            this.f19929f += j13;
        } else {
            this.f19928e += j9;
            this.f19927d += j13;
        }
        if (h.f19230b) {
            StringBuilder sbH = f.h(j13, "periodWifiBytes", " periodMobileBytes:");
            sbH.append(j9);
            sbH.append(" mMobileBackBytes:");
            sbH.append(this.f19928e);
            sbH.append(" mWifiBackBytes:");
            sbH.append(this.f19927d);
            p010b3.b.a("NewTrafficStatisticsImp", sbH.toString());
        }
        this.f19931h = jElapsedRealtime;
    }

    @Override // p077k2.a
    public final long a() {
        k();
        return this.f19929f;
    }

    public final long[] b(int i9) {
        NetworkStats networkStatsQuerySummary;
        Application application = h.f19229a;
        if (this.j == null) {
            this.j = (NetworkStatsManager) application.getApplicationContext().getSystemService("netstats");
        }
        if (this.j == null) {
            return new long[]{0, 0};
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        try {
            networkStatsQuerySummary = this.j.querySummary(i9, null, 0L, 4611686018427387903L);
        } catch (Exception e9) {
            e9.printStackTrace();
            networkStatsQuerySummary = null;
        }
        long rxBytes = 0;
        long txBytes = 0;
        long rxPackets = 0;
        long txPackets = 0;
        NetworkStats networkStats = networkStatsQuerySummary;
        while (networkStats != null && networkStats.hasNextBucket()) {
            networkStats.getNextBucket(bucket);
            int uid = bucket.getUid();
            if (this.f19933k == -1) {
                try {
                    PackageInfo packageInfo = application.getApplicationContext().getPackageManager().getPackageInfo(application.getApplicationContext().getPackageName(), 128);
                    if (packageInfo != null) {
                        this.f19933k = packageInfo.applicationInfo.uid;
                    }
                } catch (PackageManager.NameNotFoundException e10) {
                    e10.printStackTrace();
                }
            }
            if (this.f19933k == uid) {
                rxBytes = bucket.getRxBytes() + rxBytes;
                txBytes = bucket.getTxBytes() + txBytes;
                rxPackets = bucket.getRxPackets() + rxPackets;
                txPackets = bucket.getTxPackets() + txPackets;
            }
        }
        if (networkStats != null) {
            networkStats.close();
        }
        return new long[]{rxBytes + txBytes, rxPackets + txPackets};
    }
}

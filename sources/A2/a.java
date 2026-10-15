package A2;

import A.f;
import java.util.ArrayList;

/* JADX INFO: compiled from: SlardarHandlerConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f1439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f1440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1445i;

    public final String toString() {
        StringBuilder sb = new StringBuilder("SlardarHandlerConfig{onceReportMaxSizeBytes=");
        sb.append(this.f1437a);
        sb.append(", reportUrlList=");
        sb.append(this.f1438b);
        sb.append(", exceptionUrl=");
        sb.append(this.f1439c);
        sb.append(", traceReportUrl=");
        sb.append(this.f1440d);
        sb.append(", isEncrypt=");
        sb.append(this.f1441e);
        sb.append(", isUploadInternalExcetpion=");
        sb.append(this.f1442f);
        sb.append(", reportInterval=");
        sb.append(this.f1443g);
        sb.append(", maxSizeMB=");
        sb.append(this.f1444h);
        sb.append(", keepDays=");
        return f.i(sb, this.f1445i, ", maxSizeMBToday=0}");
    }
}

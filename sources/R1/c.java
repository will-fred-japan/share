package R1;

import org.json.JSONObject;

/* JADX INFO: compiled from: LocalLog.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f3975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3976e;

    public c() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LocalLog{id=");
        sb.append(this.f3972a);
        sb.append(", type='");
        sb.append(this.f3973b);
        sb.append("', type2='");
        sb.append(this.f3974c);
        sb.append("', data='");
        sb.append(this.f3975d);
        sb.append("', versionId=");
        return W5.e.m(sb, this.f3976e, ", createTime=0, isSampled=false}");
    }

    public c(String str, long j, String str2, long j8) {
        this.f3972a = j;
        this.f3973b = str;
        try {
            this.f3975d = new JSONObject(str2);
        } catch (Exception unused) {
        }
        this.f3976e = j8;
    }
}

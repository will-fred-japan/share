package I1;

import org.json.JSONObject;

/* JADX INFO: compiled from: BaseHookInfo.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StackTraceElement[] f2553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f2555f;

    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (int i9 = 9; i9 < this.f2553d.length; i9++) {
            sb.append("\tat ");
            sb.append(this.f2553d[i9].toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}

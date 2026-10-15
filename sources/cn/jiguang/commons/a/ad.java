package cn.jiguang.commons.a;

import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9623i;
    public long j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9624k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f9625l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f9626m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f9627n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f9628o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f9629p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f9630q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f9631r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9632s;
    public int t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f9633u;

    public final JSONObject a(int i9) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("uid", this.f9615a).put("pid", this.f9616b).put("ppid", this.f9617c);
            String str = this.f9618d;
            int length = str.length();
            String strSubSequence = str;
            if (128 < length) {
                strSubSequence = str.subSequence(0, 128);
            }
            return jSONObjectPut.put("proc_name", strSubSequence).put("foreground", this.f9619e).put("state", this.f9620f).put("start_time", this.f9621g).put(RemoteMessageConst.Notification.PRIORITY, this.f9622h).put("num_threads", this.f9623i).put("size", this.j).put("tpgid", this.f9624k).put("cpuacct", this.f9625l).put("cpu", this.f9626m).put("utime", this.f9627n).put("stime", this.f9628o).put("cutime", this.f9629p).put("cstime", this.f9630q).put("rt_priority", this.f9631r).put("oom_score", this.f9632s).put("oom_adj", this.t).put("oom_score_adj", this.f9633u);
        } catch (JSONException unused) {
            return null;
        }
    }
}

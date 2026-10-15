package S3;

import java.util.HashMap;

/* JADX INFO: compiled from: TaskForegroundState.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4110a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4111b = "stopped";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4117h;

    public final HashMap a() {
        HashMap map = new HashMap();
        map.put("revision", Long.valueOf(this.f4110a));
        map.put("status", this.f4111b);
        map.put("connectedDevice", Boolean.valueOf(this.f4114e));
        map.put("microphone", Boolean.valueOf(this.f4115f));
        String str = this.f4116g;
        if (str != null) {
            map.put("errorCode", str);
        }
        String str2 = this.f4117h;
        if (str2 != null) {
            map.put("message", str2);
        }
        return map;
    }
}

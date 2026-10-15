package H3;

import java.util.HashMap;

/* JADX INFO: compiled from: UploadInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2411b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2412c = "no error";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, String> f2414e;

    public a(String str, String str2, HashMap map) {
        this.f2413d = 0L;
        this.f2414e = null;
        this.f2410a = str2;
        this.f2413d = System.currentTimeMillis();
        this.f2414e = map;
    }

    public final String toString() {
        return "UploadInfo{lastUploadTime=0, isUploading=false, commandId='" + this.f2410a + "', cloudMsgResponseCode=" + this.f2411b + ", errorMsg='" + this.f2412c + "', operateTime=" + this.f2413d + ", specificParams=" + this.f2414e + '}';
    }
}

package cn.jiguang.z;

import android.text.TextUtils;
import cn.jiguang.aw.j;
import cn.jiguang.aw.n;
import java.io.File;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f10957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f10958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f10959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10961f;

    private d(File file, JSONObject jSONObject, JSONObject jSONObject2, boolean z8) {
        this.f10958c = file;
        this.f10959d = jSONObject;
        this.f10957b = jSONObject2;
        this.f10956a = file.length();
        this.f10961f = z8;
        this.f10960e = z8;
    }

    public static d a(File file, Set<String> set) {
        JSONObject jSONObjectA = a(file);
        if (jSONObjectA != null) {
            return new d(file, jSONObjectA, n.a(jSONObjectA, set), false);
        }
        j.b(file);
        return null;
    }

    public static d a(File file, JSONObject jSONObject) {
        JSONObject jSONObjectA = a(file);
        if (jSONObjectA != null) {
            return new d(file, jSONObjectA, jSONObject, true);
        }
        j.b(file);
        return null;
    }

    public static JSONObject a(File file) {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        try {
            String strC = j.c(file);
            if (TextUtils.isEmpty(strC) || (jSONArrayOptJSONArray = (jSONObject = new JSONObject(strC)).optJSONArray("content")) == null || jSONArrayOptJSONArray.length() <= 0) {
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0044 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:4:0x0006, B:6:0x0012, B:7:0x001f, B:9:0x0025, B:10:0x002f, B:12:0x003e, B:14:0x0044, B:15:0x0047, B:17:0x0056, B:18:0x005d, B:23:0x0074, B:21:0x0069), top: B:26:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0056 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:4:0x0006, B:6:0x0012, B:7:0x001f, B:9:0x0025, B:10:0x002f, B:12:0x003e, B:14:0x0044, B:15:0x0047, B:17:0x0056, B:18:0x005d, B:23:0x0074, B:21:0x0069), top: B:26:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0069 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:4:0x0006, B:6:0x0012, B:7:0x001f, B:9:0x0025, B:10:0x002f, B:12:0x003e, B:14:0x0044, B:15:0x0047, B:17:0x0056, B:18:0x005d, B:23:0x0074, B:21:0x0069), top: B:26:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0074 A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0079, blocks: (B:4:0x0006, B:6:0x0012, B:7:0x001f, B:9:0x0025, B:10:0x002f, B:12:0x003e, B:14:0x0044, B:15:0x0047, B:17:0x0056, B:18:0x005d, B:23:0x0074, B:21:0x0069), top: B:26:0x0006 }] */
    public boolean a(d dVar, File file) {
        File file2;
        boolean zEquals;
        if (dVar != null) {
            try {
                if (this.f10956a + dVar.f10956a <= 40960) {
                    JSONArray jSONArray = this.f10959d.getJSONArray("content");
                    JSONArray jSONArray2 = dVar.f10959d.getJSONArray("content");
                    for (int i9 = 0; i9 < jSONArray2.length(); i9++) {
                        jSONArray.put(jSONArray2.getJSONObject(i9));
                    }
                    this.f10956a += dVar.f10956a;
                    this.f10960e = true;
                    j.b(dVar.f10958c);
                    return true;
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                file2 = new File(file, this.f10958c.getName());
                if (this.f10961f) {
                    n.a(this.f10959d, this.f10957b);
                }
                zEquals = this.f10958c.equals(file2);
                if (this.f10960e || !zEquals) {
                    j.b(file2, this.f10959d.toString());
                }
                if (!zEquals) {
                    j.b(this.f10958c);
                }
            } catch (Throwable unused) {
            }
        } else {
            if (!file.exists()) {
                file.mkdirs();
            }
            file2 = new File(file, this.f10958c.getName());
            if (this.f10961f) {
                n.a(this.f10959d, this.f10957b);
            }
            zEquals = this.f10958c.equals(file2);
            if (this.f10960e) {
                j.b(file2, this.f10959d.toString());
            } else {
                j.b(file2, this.f10959d.toString());
            }
            if (!zEquals) {
                j.b(this.f10958c);
            }
        }
        return false;
    }
}

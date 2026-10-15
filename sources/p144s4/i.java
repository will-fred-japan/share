package p144s4;

import android.os.Environment;
import android.os.StatFs;
import com.apm.insight.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static JSONObject a() {
        long freeBytes;
        long totalBytes;
        long freeSpace;
        long totalSpace;
        long freeBytes2;
        JSONObject jSONObject = new JSONObject();
        long totalBytes2 = 0;
        try {
            freeBytes = new StatFs(Environment.getRootDirectory().getPath()).getFreeBytes();
        } catch (Throwable unused) {
            freeBytes = 0;
        }
        try {
            jSONObject.put("inner_free", freeBytes);
            try {
                totalBytes = new StatFs(Environment.getRootDirectory().getPath()).getTotalBytes();
            } catch (Throwable unused2) {
                totalBytes = 0;
            }
            jSONObject.put("inner_total", totalBytes);
            try {
                freeSpace = "mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getFreeSpace() : 0L;
            } catch (Throwable unused3) {
            }
            jSONObject.put("sdcard_free", freeSpace);
            try {
                totalSpace = "mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getTotalSpace() : 0L;
            } catch (Throwable unused4) {
            }
            jSONObject.put("sdcard_total", totalSpace);
            try {
                freeBytes2 = new StatFs(f.f11853a.getFilesDir().getPath()).getFreeBytes();
            } catch (Throwable unused5) {
                freeBytes2 = 0;
            }
            jSONObject.put("inner_free_real", freeBytes2);
            try {
                totalBytes2 = new StatFs(f.f11853a.getFilesDir().getPath()).getTotalBytes();
            } catch (Throwable unused6) {
            }
            jSONObject.put("inner_total_real", totalBytes2);
        } catch (Throwable unused7) {
        }
        return jSONObject;
    }
}

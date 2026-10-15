package P3;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogMessageBaseHandler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends O3.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T1.b.C0055b f3612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f3613d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f3614e = 0;

    @Override // O3.a
    public final synchronized boolean e(E.a aVar) {
        boolean z8;
        JSONObject jSONObject = new JSONObject((String) aVar.f1947c);
        if (this.f3612c == null) {
            A1.b.x(0, this.f3468a, (String) aVar.f1949e, "未设置Log回捞处理组件");
            return false;
        }
        if (System.currentTimeMillis() - this.f3614e < 180000) {
            H3.a aVar2 = new H3.a(this.f3468a, (String) aVar.f1949e, null);
            aVar2.f2411b = 0;
            aVar2.f2412c = "3分钟内不重复执行log回捞";
            G3.a.a(aVar2);
            return false;
        }
        this.f3614e = System.currentTimeMillis();
        List<String> listA = this.f3612c.a(b(), jSONObject.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000), jSONObject.optLong("fetch_end_time", System.currentTimeMillis() / 1000));
        List<String> list = this.f3612c.f4471a;
        boolean z9 = true;
        boolean z10 = list != null && list.size() > 0;
        N3.a aVar3 = new N3.a(z10, z10 ? "log file get" : "log file not get");
        if (listA == null || listA.size() == 0) {
            Object obj = this.f3612c;
            if ((obj instanceof K3.a) && (listA = ((K3.a) obj).a()) != null && listA.size() != 0) {
                aVar3 = new N3.a(true, "兜底策略数据");
            }
        }
        if (listA == null || listA.size() == 0 || !aVar3.f3202b) {
            z8 = true;
            if (!aVar3.f3202b) {
                String str = aVar3.f3201a;
                H3.a aVar4 = new H3.a(this.f3468a, (String) aVar.f1949e, null);
                aVar4.f2411b = 3;
                aVar4.f2412c = str;
                G3.a.a(aVar4);
            }
        } else {
            this.f3613d.clear();
            this.f3613d.addAll(listA);
            F3.a aVarB = F3.a.b(this.f3468a);
            if (!aVarB.f2037b.exists()) {
                aVarB.f2037b.mkdirs();
            }
            File file = new File(aVarB.f2037b, ((String) aVar.f1949e) + "temp");
            if (file.exists()) {
                file.delete();
            }
            file.mkdirs();
            File file2 = new File(file, ((String) aVar.f1949e) + "-cloudMsg.zip");
            if (file2.exists()) {
                file2.delete();
            }
            String[] strArr = (String[]) listA.toArray(new String[listA.size()]);
            p199z2.b.j(file2.getAbsolutePath(), strArr);
            A1.b.x(0, this.f3468a, (String) aVar.f1949e, "Alog回捞:" + Arrays.toString(strArr) + " ErrMsg=" + aVar3.f3201a);
            F3.a aVarB2 = F3.a.b(this.f3468a);
            synchronized (aVarB2) {
                try {
                    A1.b.x(0, aVarB2.f2038c.f2833a, (String) aVar.f1949e, "命令产物已生成，等待上传");
                    if (!aVarB2.f2037b.exists()) {
                        aVarB2.f2037b.mkdirs();
                    }
                    String str2 = (String) aVar.f1949e;
                    File file3 = new File(aVarB2.f2037b, str2);
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file.renameTo(file3);
                    long jA = F3.a.a(file3);
                    boolean z11 = ((JSONObject) aVar.f1946b).optBoolean("wifiOnly") && jA > 2097152;
                    aVarB2.f2036a.put(str2, Boolean.valueOf(z11));
                    if (!z11 || Q3.a.a(aVarB2.f2038c.f2835c)) {
                        File[] fileArrListFiles = file3.listFiles(new B2.c(1));
                        int length = fileArrListFiles.length;
                        int i9 = 0;
                        boolean z12 = true;
                        while (i9 < length) {
                            File file4 = fileArrListFiles[i9];
                            String str3 = aVarB2.f2038c.f2833a;
                            String str4 = "正在上传:" + file4.getName();
                            if (A1.b.f1427z) {
                                A1.b.Z("postFile: commandId=" + str2, "postFile=" + file4.getAbsolutePath(), ", uploadMessage=" + str4, ", fileType=log_agile");
                            }
                            boolean zA = I3.a.a(I3.a.f2571a, file4, 1, "log_agile", str2, str4, System.currentTimeMillis(), null);
                            StringBuilder sb = new StringBuilder();
                            sb.append("文件上传");
                            sb.append(zA ? "成功" : "失败");
                            sb.append(Constants.COLON_SEPARATOR);
                            sb.append(file4.getName());
                            A1.b.x(0, aVarB2.f2038c.f2833a, (String) aVar.f1949e, sb.toString());
                            if (!zA) {
                                z12 = false;
                            }
                            i9++;
                            z9 = z9;
                        }
                        z8 = z9;
                        if (z12) {
                            A1.b.x(2, aVarB2.f2038c.f2833a, str2, "上传成功");
                        }
                    } else {
                        A1.b.x(0, aVarB2.f2038c.f2833a, (String) aVar.f1949e, "产物超过阈值，等待WiFi环境执行. fileTotalSize=" + jA);
                        z8 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z8;
    }
}

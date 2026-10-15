package p152t4;

import W5.e;
import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.entity.Header;
import com.apm.insight.f;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p056h5.C0598e;
import p142s2.j;
import p159u4.d;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static p f21453e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f21454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f21455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f21456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f21457d;

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21458a;

        public a(String str) {
            this.f21458a = str;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.endsWith(this.f21458a);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f21459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f21460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final File f21461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f21462d = null;

        public b(File file) {
            long j;
            this.f21461c = file;
            String name = file.getName();
            int iIndexOf = name.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (iIndexOf > 0) {
                this.f21459a = Long.parseLong(name.substring(0, iIndexOf));
                j = Long.parseLong(name.substring(iIndexOf + 1, name.lastIndexOf(".")));
            } else {
                j = 0;
                this.f21459a = 0L;
            }
            this.f21460b = j;
        }
    }

    public static p b() {
        if (f21453e == null) {
            Context context = f.f11853a;
            p pVar = new p();
            pVar.f21457d = null;
            File file = new File(C0598e.w(context), "apminsight/RuntimeContext");
            if (!file.exists() || (!file.isDirectory() && file.delete())) {
                file.mkdirs();
                d.f21686x = true;
            }
            pVar.f21454a = file;
            pVar.f21455b = new File(file, "did");
            pVar.f21456c = new File(file, "device_uuid");
            f21453e = pVar;
        }
        return f21453e;
    }

    public final JSONObject a(long j) {
        JSONObject jSONObject;
        File file;
        boolean z8;
        String strD;
        Iterator<b> it = f(".ctx").iterator();
        while (true) {
            jSONObject = null;
            if (!it.hasNext()) {
                file = null;
                break;
            }
            b next = it.next();
            if (j >= next.f21459a && j <= next.f21460b) {
                file = next.f21461c;
                break;
            }
        }
        if (file == null) {
            b bVar = null;
            for (b bVar2 : f(".ctx")) {
                if (bVar == null || Math.abs(bVar.f21460b - j) > Math.abs(bVar2.f21460b - j)) {
                    bVar = bVar2;
                }
            }
            file = bVar == null ? null : bVar.f21461c;
            z8 = true;
        } else {
            z8 = false;
        }
        if (file != null) {
            try {
                strD = p144s4.d.d(file.getAbsolutePath());
                try {
                    jSONObject = new JSONObject(strD);
                } catch (Throwable th) {
                    th = th;
                    int i9 = com.apm.insight.b.f11841a;
                    p027d5.a.k("NPTH_CATCH", new IOException(e.l("content :", strD), th));
                }
            } catch (Throwable th2) {
                th = th2;
                strD = null;
            }
        }
        if (jSONObject != null && z8) {
            try {
                jSONObject.put("unauthentic_version", 1);
            } catch (JSONException e9) {
                int i10 = com.apm.insight.b.f11841a;
                p027d5.a.k("NPTH_CATCH", e9);
            }
        }
        return jSONObject;
    }

    public final void c(long j, long j8, JSONObject jSONObject, JSONArray jSONArray) {
        File file = this.f21454a;
        File file2 = new File(file, e.m(defpackage.f.h(j, "", Constants.ACCEPT_TIME_SEPARATOR_SERVER), j8, ".ctx"));
        File file3 = new File(file, e.m(defpackage.f.h(j, "", Constants.ACCEPT_TIME_SEPARATOR_SERVER), j8, ".allData"));
        try {
            p144s4.d.k(file2, jSONObject);
            p144s4.d.j(file3, jSONArray);
            this.f21457d = new b(file2);
        } catch (Exception e9) {
            int i9 = com.apm.insight.b.f11841a;
            p027d5.a.k("NPTH_CATCH", e9);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    public final void d(Map<String, Object> map, JSONArray jSONArray) {
        char c5;
        JSONObject jSONObjectC = Header.a().c(map);
        if (Header.h(jSONObjectC)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f21457d == null) {
            f(".ctx");
        }
        b bVar = this.f21457d;
        if (bVar == null) {
            c(jCurrentTimeMillis, jCurrentTimeMillis, jSONObjectC, jSONArray);
            return;
        }
        JSONObject jSONObject = bVar.f21462d;
        File file = bVar.f21461c;
        if (jSONObject == null) {
            try {
                bVar.f21462d = new JSONObject(p144s4.d.d(file.getAbsolutePath()));
            } catch (Throwable unused) {
            }
            if (bVar.f21462d == null) {
                bVar.f21462d = new JSONObject();
            }
        }
        JSONObject jSONObject2 = bVar.f21462d;
        if (Header.h(jSONObject2)) {
            c5 = 2;
        } else if (Header.h(jSONObjectC)) {
            c5 = 0;
        } else if (String.valueOf(jSONObjectC.opt("update_version_code")).equals(String.valueOf(jSONObject2.opt("update_version_code")))) {
            if (jSONObject2.length() != 0) {
                String strOptString = jSONObject2.optString("aid");
                if (!TextUtils.isEmpty(strOptString)) {
                    try {
                        if (Integer.parseInt(strOptString) > 0) {
                            c5 = 2;
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
            c5 = 1;
        } else {
            c5 = 2;
        }
        if (c5 == 1) {
            c(bVar.f21459a, jCurrentTimeMillis, jSONObjectC, jSONArray);
            jCurrentTimeMillis = jCurrentTimeMillis;
            p144s4.d.p(file);
        } else if (c5 == 2) {
            c(jCurrentTimeMillis, jCurrentTimeMillis, jSONObjectC, jSONArray);
        } else if (c5 == 3) {
            bVar.f21460b = jCurrentTimeMillis;
            String parent = file.getParent();
            StringBuilder sb = new StringBuilder();
            sb.append(bVar.f21459a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            file.renameTo(new File(parent, e.m(sb, bVar.f21460b, ".ctx")));
        }
        try {
            ArrayList<b> arrayListF = f("");
            if (arrayListF.size() <= 6) {
                return;
            }
            for (b bVar2 : arrayListF) {
                long j = bVar2.f21459a;
                File file2 = bVar2.f21461c;
                if (j <= jCurrentTimeMillis || j - jCurrentTimeMillis <= 604800000) {
                    long j8 = bVar2.f21460b;
                    if ((j8 >= jCurrentTimeMillis || jCurrentTimeMillis - j8 <= 604800000) && (file2.lastModified() >= jCurrentTimeMillis || jCurrentTimeMillis - file2.lastModified() <= 604800000)) {
                    }
                }
                file2.delete();
            }
        } catch (Throwable th) {
            int i9 = com.apm.insight.b.f11841a;
            p027d5.a.k("NPTH_CATCH", th);
        }
    }

    public final JSONArray e(long j) {
        File file;
        String strD;
        Iterator<b> it = f(".allData").iterator();
        while (true) {
            if (!it.hasNext()) {
                file = null;
                break;
            }
            b next = it.next();
            if (j >= next.f21459a && j <= next.f21460b) {
                file = next.f21461c;
                break;
            }
        }
        if (file == null) {
            b bVar = null;
            for (b bVar2 : f(".allData")) {
                if (bVar == null || Math.abs(bVar.f21460b - j) > Math.abs(bVar2.f21460b - j)) {
                    bVar = bVar2;
                }
            }
            file = bVar == null ? null : bVar.f21461c;
        }
        if (file != null) {
            try {
                strD = p144s4.d.d(file.getAbsolutePath());
                try {
                    return new JSONArray(strD);
                } catch (Throwable th) {
                    th = th;
                    int i9 = com.apm.insight.b.f11841a;
                    p027d5.a.k("NPTH_CATCH", new IOException(e.l("content :", strD), th));
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                strD = null;
            }
        }
        return null;
    }

    public final ArrayList<b> f(String str) {
        File[] fileArrListFiles = this.f21454a.listFiles(new a(str));
        ArrayList<b> arrayList = new ArrayList<>();
        if (fileArrListFiles != null) {
            j.d("foundRuntimeContextFiles " + fileArrListFiles.length);
            b bVar = null;
            for (File file : fileArrListFiles) {
                try {
                    b bVar2 = new b(file);
                    arrayList.add(bVar2);
                    if (this.f21457d == null && ".ctx".equals(str) && (bVar == null || bVar2.f21460b >= bVar.f21460b)) {
                        bVar = bVar2;
                    }
                } catch (Throwable th) {
                    int i9 = com.apm.insight.b.f11841a;
                    p027d5.a.k("NPTH_CATCH", th);
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.f21457d == null && bVar != null) {
                this.f21457d = bVar;
            }
        }
        return arrayList;
    }
}

package p144s4;

import W5.e;
import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.b;
import com.apm.insight.entity.Header;
import com.apm.insight.f;
import com.apm.insight.nativecrash.NativeImpl;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p142s2.j;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f21240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21241b;

        public a(InputStream inputStream, String str) {
            this.f21240a = inputStream;
            this.f21241b = str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x021d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0224  */
    /* JADX WARN: Code duplicated, block: B:109:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x01bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00e5 A[PHI: r7
  0x00e5: PHI (r7v7 java.lang.StringBuilder) = (r7v4 java.lang.StringBuilder), (r7v8 java.lang.StringBuilder) binds: [B:58:0x00f4, B:53:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x013e  */
    /* JADX WARN: Code duplicated, block: B:81:0x017b  */
    /* JADX WARN: Code duplicated, block: B:82:0x017e  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:89:0x01af A[Catch: all -> 0x01c3, TryCatch #0 {all -> 0x01c3, blocks: (B:87:0x01a9, B:89:0x01af, B:91:0x01bb), top: B:107:0x01a9 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:75:0x013e, please report this as an issue */
    public static h4.d a(File file, CrashType crashType) {
        String strD;
        int i9;
        String str;
        String str2;
        String string;
        StringBuilder sbC;
        int i10;
        String str3;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject;
        Iterator<String> itKeys;
        String next;
        String strSubstring;
        JSONObject jSONObjectOptJSONObject2;
        String javaCrashUploadUrl;
        File file2;
        int i11 = 1;
        File file3 = new File(file, "logEventStack");
        boolean zContains = file.getName().contains("oom");
        h4.a aVar = new h4.a();
        String str4 = "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 且不是OOM.\n";
        if (file3.exists()) {
            try {
                strD = d(file3.getAbsolutePath());
            } catch (IOException unused) {
                strD = null;
            }
            if (TextUtils.isEmpty(strD)) {
                str4 = zContains ? "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 是OOM.\n" : "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 且不是OOM.\n";
                str2 = null;
                i9 = 0;
            } else {
                String[] strArrSplit = strD.split("\n");
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                boolean z8 = false;
                boolean z9 = false;
                for (String str5 : strArrSplit) {
                    if (!z8 && str5.startsWith("stack:")) {
                        z8 = true;
                    } else if (!z9 && str5.startsWith("err:")) {
                        z9 = true;
                    } else if (z9) {
                        sb2.append(str5);
                        sb2.append("\n");
                    } else if (z8) {
                        sb.append(str5);
                        sb.append("\n");
                    } else {
                        arrayList.add(str5);
                    }
                }
                if (arrayList.size() >= 1) {
                    i9 = 0;
                    str = (String) arrayList.get(0);
                } else {
                    i9 = 0;
                    str = null;
                }
                String str6 = arrayList.size() >= 2 ? (String) arrayList.get(1) : null;
                String str7 = arrayList.size() >= 3 ? (String) arrayList.get(2) : null;
                i11 = 1;
                str2 = arrayList.size() >= 4 ? (String) arrayList.get(3) : null;
                if (z8 && sb.length() > 0) {
                    string = sb.toString();
                } else if (str7 != null) {
                    sbC = p171w.a.c(str7, "\nCaused by: ");
                    if (zContains) {
                        str4 = "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 是OOM.\n";
                    }
                    sbC.append(str4);
                    string = sbC.toString();
                } else if (str6 != null) {
                    sbC = p171w.a.c(str6, "\nCaused by: ");
                    if (zContains) {
                        str4 = "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 是OOM.\n";
                    }
                    sbC.append(str4);
                    string = sbC.toString();
                } else {
                    string = zContains ? "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 是OOM.\n" : "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 且不是OOM.\n";
                }
                if (z9 && sb2.length() > 0) {
                    string = string + "\nCaused by: InvalidStack.CrashWhenWriteStack: Npth在抓取堆栈时发生如下错误:\n" + ((Object) sb2);
                }
                str4 = string;
            }
            aVar.e(str4, "data");
            aVar.e(str, "process_name");
            aVar.e(str2, "crash_thread_name");
            aVar.e(Boolean.valueOf(zContains), "isOOM");
            for (i10 = i9; i10 < 6; i10++) {
                file2 = new File(file, file.getName() + e.i(i10, "."));
                if (file2.exists()) {
                    try {
                        h4.a.o(aVar.f19034a, new JSONObject(d(file2.getAbsolutePath())));
                        i9 = i11;
                    } catch (Throwable unused2) {
                    }
                }
            }
            if (i9 != 0) {
                str3 = "step";
            } else {
                str3 = "simple";
            }
            aVar.f(CrashHianalyticsData.CRASH_TYPE, str3);
            jSONObjectOptJSONObject = aVar.f19034a.optJSONObject("header");
            Context context = f.f11853a;
            jSONObject = Header.b(aVar.f19034a.optLong("crash_time", 0L)).f11851a;
            if (jSONObjectOptJSONObject == null) {
                aVar.e(jSONObject, "header");
            } else {
                itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        next = itKeys.next();
                        if (!jSONObjectOptJSONObject.has(next)) {
                            jSONObjectOptJSONObject.put(next, jSONObject.opt(next));
                        }
                    } catch (Throwable unused3) {
                    }
                }
            }
            String name = file.getName();
            strSubstring = name.substring(name.lastIndexOf(95) + 1);
            jSONObjectOptJSONObject2 = aVar.f19034a.optJSONObject("header");
            if (jSONObjectOptJSONObject2.optString("unique_key", null) == null) {
                try {
                    jSONObjectOptJSONObject2.put("unique_key", "android_" + f.e().a() + BundleUtil.UNDERLINE_TAG + strSubstring + BundleUtil.UNDERLINE_TAG + CrashType.LAUNCH);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            h4.d dVar = new h4.d();
            if (crashType == CrashType.LAUNCH) {
                javaCrashUploadUrl = f.f11859g.getLaunchCrashUploadUrl();
            } else {
                javaCrashUploadUrl = f.f11859g.getJavaCrashUploadUrl();
            }
            dVar.f19037a = javaCrashUploadUrl;
            dVar.f19038b = aVar.f19034a;
            return dVar;
        }
        i9 = 0;
        str4 = zContains ? "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 是OOM.\n" : "InvalidStack.NoStackAvailable: 确实发生了崩溃, 但无可用堆栈信息, 且不是OOM.\n";
        str2 = null;
        str = null;
        aVar.e(str4, "data");
        aVar.e(str, "process_name");
        aVar.e(str2, "crash_thread_name");
        aVar.e(Boolean.valueOf(zContains), "isOOM");
        while (i10 < 6) {
            file2 = new File(file, file.getName() + e.i(i10, "."));
            if (file2.exists()) {
                h4.a.o(aVar.f19034a, new JSONObject(d(file2.getAbsolutePath())));
                i9 = i11;
            }
        }
        if (i9 != 0) {
            str3 = "step";
        } else {
            str3 = "simple";
        }
        aVar.f(CrashHianalyticsData.CRASH_TYPE, str3);
        jSONObjectOptJSONObject = aVar.f19034a.optJSONObject("header");
        Context context2 = f.f11853a;
        jSONObject = Header.b(aVar.f19034a.optLong("crash_time", 0L)).f11851a;
        if (jSONObjectOptJSONObject == null) {
            aVar.e(jSONObject, "header");
        } else {
            itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                next = itKeys.next();
                if (!jSONObjectOptJSONObject.has(next)) {
                    jSONObjectOptJSONObject.put(next, jSONObject.opt(next));
                }
            }
        }
        String name2 = file.getName();
        strSubstring = name2.substring(name2.lastIndexOf(95) + 1);
        jSONObjectOptJSONObject2 = aVar.f19034a.optJSONObject("header");
        if (jSONObjectOptJSONObject2.optString("unique_key", null) == null) {
            jSONObjectOptJSONObject2.put("unique_key", "android_" + f.e().a() + BundleUtil.UNDERLINE_TAG + strSubstring + BundleUtil.UNDERLINE_TAG + CrashType.LAUNCH);
        }
        h4.d dVar2 = new h4.d();
        if (crashType == CrashType.LAUNCH) {
            javaCrashUploadUrl = f.f11859g.getLaunchCrashUploadUrl();
        } else {
            javaCrashUploadUrl = f.f11859g.getJavaCrashUploadUrl();
        }
        dVar2.f19037a = javaCrashUploadUrl;
        dVar2.f19038b = aVar.f19034a;
        return dVar2;
    }

    public static String b(File file) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        p027d5.a.g(bufferedReader2);
                        return sb.toString();
                    }
                    if (sb.length() != 0) {
                        sb.append("\n");
                    }
                    sb.append(line);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    p027d5.a.g(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(File file, String str, String str2, String str3, String str4, List<String> list) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", str3);
            jSONObject.put("did", str2);
            jSONObject.put("processName", str4);
            jSONObject.put("alogFiles", new JSONArray((Collection) list));
            k(file2, jSONObject);
        } catch (IOException | JSONException e9) {
            e9.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(new File(str));
    }

    public static JSONArray e(File file, long j) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j > 0) {
                try {
                    bufferedReader2.skip(j);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    p027d5.a.g(bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String line = bufferedReader2.readLine();
                if (line == null) {
                    p027d5.a.g(bufferedReader2);
                    return jSONArray;
                }
                jSONArray.put(line);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void f(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            file2.getParentFile().mkdirs();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i9 = fileInputStream2.read(bArr);
                        if (i9 <= 0) {
                            p027d5.a.g(fileInputStream2);
                            p027d5.a.g(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i9);
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        p027d5.a.g(fileInputStream);
                        p027d5.a.g(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        p027d5.a.g(fileInputStream);
                        p027d5.a.g(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    p027d5.a.g(fileInputStream);
                    p027d5.a.g(fileOutputStream);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e11) {
            e = e11;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static void g(File file, String str, String str2, JSONObject jSONObject) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(RemoteMessageConst.Notification.URL, str2);
            jSONObject2.put("body", jSONObject);
            jSONObject2.put("dump_file", "");
            jSONObject2.put("encrypt", true);
            k(file2, jSONObject2);
        } catch (IOException | JSONException e9) {
            e9.printStackTrace();
        }
        file2.getAbsolutePath();
    }

    public static void h(File file, String str, boolean z8) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z8);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                p027d5.a.g(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                p027d5.a.g(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void i(File file, Map<String, String> map) throws Throwable {
        if (map == null || map.isEmpty()) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                Properties properties = new Properties();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        properties.setProperty(entry.getKey(), entry.getValue());
                    }
                    properties.store(fileOutputStream2, "no");
                    p027d5.a.g(fileOutputStream2);
                } catch (IOException e9) {
                    e = e9;
                    fileOutputStream = fileOutputStream2;
                    j.m(e);
                    p027d5.a.g(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    p027d5.a.g(fileOutputStream);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void j(File file, JSONArray jSONArray) {
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                new f(bufferedWriter2).b(jSONArray);
                bufferedWriter2.flush();
                p027d5.a.g(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                p027d5.a.g(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void k(File file, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                new f(bufferedWriter2).c(jSONObject);
                bufferedWriter2.flush();
                p027d5.a.g(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                p027d5.a.g(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void l(OutputStream outputStream, File... fileArr) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(outputStream);
            try {
                zipOutputStream2.putNextEntry(new ZipEntry("/"));
                for (File file : fileArr) {
                    if (file != null && file.exists()) {
                        File[] fileArrListFiles = file.isDirectory() ? file.listFiles() : new File[]{file};
                        if (fileArrListFiles != null) {
                            for (File file2 : fileArrListFiles) {
                                o(zipOutputStream2, file2, file2.getName());
                            }
                        }
                    }
                }
                p027d5.a.g(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                p027d5.a.g(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void m(OutputStream outputStream, a... aVarArr) throws Throwable {
        InputStream inputStream;
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(outputStream);
            try {
                zipOutputStream2.putNextEntry(new ZipEntry("/"));
                for (a aVar : aVarArr) {
                    if (aVar != null) {
                        zipOutputStream2.putNextEntry(new ZipEntry(aVar.f21241b));
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i9 = aVar.f21240a.read(bArr);
                                if (-1 == i9) {
                                    break;
                                } else {
                                    zipOutputStream2.write(bArr, 0, i9);
                                }
                            }
                            inputStream = aVar.f21240a;
                        } catch (Throwable unused) {
                            inputStream = aVar.f21240a;
                        }
                        p027d5.a.g(inputStream);
                    }
                }
                p027d5.a.g(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                p027d5.a.g(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p(new File(str));
    }

    public static void o(ZipOutputStream zipOutputStream, File file, String str) throws Throwable {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            zipOutputStream.putNextEntry(new ZipEntry(e.u(str, "/")));
            String strConcat = str.length() == 0 ? "" : str.concat("/");
            for (int i9 = 0; i9 < fileArrListFiles.length; i9++) {
                File file2 = fileArrListFiles[i9];
                StringBuilder sbB = p171w.a.b(strConcat);
                sbB.append(fileArrListFiles[i9].getName());
                o(zipOutputStream, file2, sbB.toString());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i10 = fileInputStream2.read(bArr);
                    if (-1 == i10) {
                        p027d5.a.g(fileInputStream2);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, i10);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                p027d5.a.g(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean p(File file) {
        boolean zP;
        boolean z8 = true;
        if (!file.exists()) {
            return true;
        }
        if (!file.canWrite()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        for (int i9 = 0; fileArrListFiles != null && i9 < fileArrListFiles.length; i9++) {
            if (fileArrListFiles[i9].isFile()) {
                if (fileArrListFiles[i9].canWrite()) {
                    zP = fileArrListFiles[i9].delete();
                } else {
                    z8 = false;
                }
            } else {
                zP = p(fileArrListFiles[i9]);
            }
            z8 &= zP;
        }
        return file.delete() & z8;
    }

    public static JSONArray q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return e(new File(str), -1L);
    }

    public static void r(File file, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                new f(bufferedWriter2).c(jSONObject);
                bufferedWriter2.flush();
                p027d5.a.g(bufferedWriter2);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                try {
                    try {
                        jSONObject.put("err_write", th.toString());
                        h4.a.i(jSONObject, "filters", "err_write", th.getLocalizedMessage());
                    } finally {
                        p027d5.a.g(bufferedWriter);
                    }
                } catch (JSONException unused) {
                }
                int i9 = b.f11841a;
                p027d5.a.k("NPTH_CATCH", th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static h4.d s(String str) {
        try {
            String strD = d(str);
            if (strD == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strD);
            h4.d dVar = new h4.d();
            dVar.f19037a = jSONObject.optString(RemoteMessageConst.Notification.URL);
            dVar.f19038b = jSONObject.optJSONObject("body");
            dVar.f19039c = jSONObject.optString("dump_file");
            jSONObject.optBoolean("encrypt", false);
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static h4.d t(String str) {
        try {
            JSONObject jSONObject = new JSONObject(d(str));
            h4.d dVar = new h4.d();
            dVar.f19041e = jSONObject.optString("aid");
            dVar.f19040d = jSONObject.optString("did");
            dVar.f19042f = jSONObject.optString("processName");
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("alogFiles");
            if (jSONArrayOptJSONArray != null) {
                for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i9));
                }
                dVar.f19043g = arrayList;
            }
            return dVar;
        } catch (IOException | JSONException e9) {
            e9.printStackTrace();
            return null;
        }
    }

    public static HashMap u(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    properties.load(fileInputStream);
                    Set<String> setStringPropertyNames = properties.stringPropertyNames();
                    HashMap map = new HashMap();
                    for (String str : setStringPropertyNames) {
                        map.put(str, properties.getProperty(str));
                    }
                    p027d5.a.g(fileInputStream);
                    return map;
                } catch (IOException e9) {
                    e = e9;
                    j.m(e);
                    p027d5.a.g(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                p027d5.a.g(fileInputStream2);
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            p027d5.a.g(fileInputStream2);
            throw th;
        }
    }

    public static void v(File file) {
        File file2 = new File(file, "lock");
        try {
            file2.createNewFile();
            NativeImpl.m(file2.getAbsolutePath());
        } catch (Throwable th) {
            int i9 = b.f11841a;
            p027d5.a.k("NPTH_CATCH", th);
        }
    }
}

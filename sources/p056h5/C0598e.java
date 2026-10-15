package p056h5;

import Q4.InterfaceC0357m;
import S2.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.widget.B;
import com.apm.insight.CrashType;
import com.apm.insight.b;
import com.apm.insight.entity.Header;
import com.apm.insight.f;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.ConfigManager;
import com.google.android.gms.internal.location.zzee;
import com.google.android.gms.location.LastLocationRequest;
import com.huawei.hms.framework.common.BundleUtil;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011b4.h;
import p092m3.c;

/* JADX INFO: renamed from: h5.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class C0598e implements InterfaceC0357m, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C0598e f19059a = new C0598e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f19060b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HashMap f19061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static SimpleDateFormat f19062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f19063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static File f19064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static File f19065g;

    public static File a() {
        File file = f19064f;
        if (file != null) {
            return file;
        }
        Context context = f.f11853a;
        if (f19064f == null) {
            f19064f = new File(w(context), "apminsight/CrashLogNative");
        }
        return f19064f;
    }

    public static File b(int i9, int i10, String str) {
        File file = new File(d(f.f11853a, str), "logcat.txt");
        if (file.exists() && file.length() > 0) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.e(file.getAbsolutePath(), String.valueOf(i9), String.valueOf(i10));
        return file;
    }

    public static File c(Context context) {
        return new File(w(context), "apminsight/CrashLogJava");
    }

    public static File d(Context context, String str) {
        return new File(w(context) + "/apminsight/CrashCommonLog/" + str);
    }

    public static String f() {
        return f.f11853a.getFilesDir() + "/apminsight/selflib/libapminsightb.so";
    }

    public static String g(byte[] bArr, String str) {
        try {
            byte[] bArrDecode = Base64.decode(bArr, 0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            String str2 = new String(cipher.doFinal(bArrDecode));
            try {
                int iIndexOf = str2.indexOf("$");
                if (iIndexOf != -1) {
                    return str2.substring(0, iIndexOf);
                }
            } catch (Exception unused) {
            }
            return str2;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static DateFormat h() {
        if (f19062d == null) {
            f19062d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        }
        return f19062d;
    }

    public static JSONArray i(long j, String str) {
        ConfigManager configManager = f.f11859g;
        try {
            String absolutePath = b(configManager.getLogcatDumpCount(), configManager.getLogcatLevel(), str).getAbsolutePath();
            if (j > 0) {
                SystemClock.sleep(j);
            }
            return j(absolutePath);
        } catch (Throwable th) {
            int i9 = b.f11841a;
            p027d5.a.k("NPTH_CATCH", th);
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0031: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:50), block:B:10:0x0031 */
    public static JSONArray j(String str) throws Throwable {
        Closeable closeable;
        BufferedReader bufferedReader;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                bufferedReader = new BufferedReader(new FileReader(str));
                try {
                    File file = new File(str);
                    if (file.length() > 512000) {
                        bufferedReader.skip(file.length() - 512000);
                    }
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            p027d5.a.g(bufferedReader);
                            return jSONArray;
                        }
                        jSONArray.put(line);
                    }
                } catch (IOException e9) {
                    e = e9;
                    e.printStackTrace();
                    p027d5.a.g(bufferedReader);
                    return null;
                }
            } catch (IOException e10) {
                e = e10;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                p027d5.a.g(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    public static void k() {
        try {
            ConfigManager configManager = f.f11859g;
            b(configManager.getLogcatDumpCount(), configManager.getLogcatLevel(), f.g());
            if (f.f11873w) {
                File file = new File(r(f.f11853a), "maps.txt");
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    try {
                        file.createNewFile();
                    } catch (IOException unused) {
                    }
                    NativeImpl.u(file.getAbsolutePath());
                }
                File file2 = new File(r(f.f11853a), "fds.txt");
                if (!file2.exists()) {
                    file2.getParentFile().mkdirs();
                    try {
                        file2.createNewFile();
                    } catch (IOException unused2) {
                    }
                    NativeImpl.s(file2.getAbsolutePath());
                }
                File file3 = new File(r(f.f11853a), "meminfo.txt");
                if (!file3.exists()) {
                    file3.getParentFile().mkdirs();
                    try {
                        file3.createNewFile();
                    } catch (IOException unused3) {
                    }
                    NativeImpl.q(file3.getAbsolutePath());
                }
                File file4 = new File(r(f.f11853a), "threads.txt");
                if (file4.exists()) {
                    return;
                }
                file4.getParentFile().mkdirs();
                try {
                    file4.createNewFile();
                } catch (IOException unused4) {
                }
                NativeImpl.v(file4.getAbsolutePath());
            }
        } catch (Throwable unused5) {
        }
    }

    public static void m(h4.a aVar, Header header, CrashType crashType) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.f19034a) == null || crashType == null) {
            return;
        }
        long jOptLong = jSONObject.optLong("crash_time");
        String strA = f.e().a();
        if (jOptLong <= 0 || TextUtils.isEmpty(crashType.getName())) {
            return;
        }
        try {
            String str = "android__" + strA + BundleUtil.UNDERLINE_TAG + jOptLong + BundleUtil.UNDERLINE_TAG + crashType;
            if (header == null || (jSONObject = header.f11851a) != null) {
                jSONObject.put("unique_key", str);
            }
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
    }

    public static void n(Exception exc, String str, Object... objArr) {
        String str2 = String.format(str, objArr) + '\n' + Log.getStackTraceString(exc);
        Object[] objArr2 = new Object[0];
        if (h.f8543c) {
            String str3 = String.format(str2, objArr2);
            if (str3.length() < 4000) {
                Log.d("ApmInsight:memory", str3);
                return;
            }
            for (String str4 : str3.split("\n", -1)) {
                Log.d("ApmInsight:memory", str4);
            }
        }
    }

    public static void o(String str, Object... objArr) {
        if (h.f8543c) {
            String str2 = String.format(str, objArr);
            if (str2.length() < 4000) {
                Log.d("ApmInsight:memory", str2);
                return;
            }
            for (String str3 : str2.split("\n", -1)) {
                Log.d("ApmInsight:memory", str3);
            }
        }
    }

    public static File p(Context context, String str) {
        return new File(w(context) + "/apminsight/CustomFile/" + str);
    }

    public static p204z7.a q(p204z7.a aVar) {
        aVar.l();
        aVar.f22518c = true;
        return aVar.f22517b > 0 ? aVar : p204z7.a.f22515d;
    }

    public static File r(Context context) {
        if (f19065g == null) {
            f19065g = new File(w(context) + "/apminsight/CrashCommonLog/" + f.g());
        }
        return f19065g;
    }

    public static void t(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("Bundle must contain ".concat(str));
        }
    }

    public static File u() throws Throwable {
        BufferedWriter bufferedWriter;
        File file = new File(r(f.f11853a), "anr_trace.txt");
        if (!file.exists() && p152t4.a.a("custom_event_settings", "npth_simple_setting", "anr_with_traces_txt") == 1) {
            File file2 = new File("/data/anr/traces.txt");
            if (file2.exists()) {
                BufferedReader bufferedReader = null;
                try {
                    file.getParentFile().mkdirs();
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                    try {
                        bufferedWriter = new BufferedWriter(new FileWriter(file));
                        int length = 0;
                        do {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                bufferedWriter.write(line);
                                bufferedWriter.write(10);
                                length += line.length();
                            } catch (IOException unused) {
                                bufferedReader = bufferedReader2;
                                p027d5.a.g(bufferedReader);
                                p027d5.a.g(bufferedWriter);
                                return file;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                p027d5.a.g(bufferedReader);
                                p027d5.a.g(bufferedWriter);
                                throw th;
                            }
                        } while (length < 1048576);
                        p027d5.a.g(bufferedReader2);
                        p027d5.a.g(bufferedWriter);
                        return file;
                    } catch (IOException unused2) {
                        bufferedWriter = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = null;
                    }
                } catch (IOException unused3) {
                    bufferedWriter = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = null;
                }
            }
        }
        return file;
    }

    public static Drawable v(Context context, int i9) {
        return B.b().c(context, i9);
    }

    public static String w(Context context) {
        if (TextUtils.isEmpty(f19063e)) {
            try {
                f19063e = context.getFilesDir().getAbsolutePath();
            } catch (Exception e9) {
                f19063e = "/sdcard/";
                e9.printStackTrace();
            }
        }
        return f19063e;
    }

    public static File x(Context context) {
        return new File(w(context) + "/apminsight/CustomFile/" + f.g());
    }

    public static List y(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        k.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static void z(io.flutter.embedding.engine.a aVar) {
        try {
            GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", io.flutter.embedding.engine.a.class).invoke(null, aVar);
        } catch (Exception e9) {
            Log.e("GeneratedPluginsRegister", "Tried to automatically register plugins with FlutterEngine (" + aVar + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.e("GeneratedPluginsRegister", "Received exception while registering", e9);
        }
    }

    @Override // Q4.InterfaceC0357m
    public void e(Object obj, Object obj2) {
        p094m5.f fVar = (p094m5.f) obj2;
        r rVar = (r) obj;
        LastLocationRequest lastLocationRequest = new LastLocationRequest(Long.MAX_VALUE, 0, false, null);
        rVar.getClass();
        if (rVar.y(p071j5.B.f19859b)) {
            ((N) rVar.r()).w(lastLocationRequest, new zzee(4, null, new BinderC0604k(fVar), null, null));
        } else if (rVar.y(p071j5.B.f19858a)) {
            ((N) rVar.r()).A(lastLocationRequest, new BinderC0604k(fVar));
        } else {
            fVar.a(((N) rVar.r()).z());
        }
    }

    public void l(int i9, c cVar) {
        throw null;
    }

    public String s(List list) throws IOException {
        k.e(list, "list");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.flush();
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        k.d(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}

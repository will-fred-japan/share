package p142s2;

import A1.b;
import K7.l;
import T.G;
import T.L;
import V7.d;
import V7.m;
import V7.n;
import W5.e;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.apm.insight.CrashType;
import com.apm.insight.MonitorCrash;
import com.apm.insight.f;
import h4.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.y;
import org.json.JSONObject;
import p090m1.a;
import p127q4.p;
import p144s4.h;
import p188x7.g;
import y7.r;
import y7.t;

/* JADX INFO: compiled from: Apm.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements a, p116p2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f21188a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f21189b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f21190c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f21191d = 120000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f21192e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f21193f = 240000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f21194g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f21195h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f21196i = 120000;
    public static int j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f21197k = 240000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f21198l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f21199m = "";

    public static boolean A(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr.length >= bArr2.length) {
            for (int i9 = 0; i9 < bArr2.length; i9++) {
                if (bArr[i9] == bArr2[i9]) {
                }
            }
            return true;
        }
        return false;
    }

    public static void d(String str) {
        if (f.f11859g.isDebugMode()) {
            Log.i("npth", String.valueOf(str));
        }
    }

    public static void e(String str, String str2) {
        if (f.f11859g.isDebugMode()) {
            Log.i("npth", str + " " + ((Object) str2));
        }
    }

    public static void f(Throwable th) {
        if (f.f11859g.isDebugMode()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    public static void g(List list, String str) throws Throwable {
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    i(zipOutputStream, file, file.getName());
                }
                b.q0(zipOutputStream);
            } catch (Throwable th) {
                th = th;
                b.q0(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream = null;
        }
    }

    public static void h(Map map, c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
                cVar.e(jSONObject, "custom");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    public static void i(ZipOutputStream zipOutputStream, File file, String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            zipOutputStream.putNextEntry(new ZipEntry(e.u(str, "/")));
            String strConcat = str.length() == 0 ? "" : str.concat("/");
            for (int i9 = 0; i9 < fileArrListFiles.length; i9++) {
                File file2 = fileArrListFiles[i9];
                StringBuilder sbB = p171w.a.b(strConcat);
                sbB.append(fileArrListFiles[i9].getName());
                i(zipOutputStream, file2, sbB.toString());
            }
            return;
        }
        ?? r8 = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                zipOutputStream.putNextEntry(new ZipEntry((String) str));
                str = new FileInputStream(file);
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(str);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i10 = bufferedInputStream3.read(bArr, 0, 8192);
                            if (i10 == -1) {
                                b.R0(bufferedInputStream3);
                                b.R0(str);
                                return;
                            }
                            zipOutputStream.write(bArr, 0, i10);
                        }
                    } catch (Exception e9) {
                        e = e9;
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream3;
                        bufferedInputStream = bufferedInputStream2;
                        r8 = str;
                        b.R0(bufferedInputStream);
                        b.R0(r8);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            b.R0(bufferedInputStream);
            b.R0(r8);
            throw th;
        }
    }

    public static void j(StringBuilder sb, String str, String str2) {
        sb.append(str);
        com.starburst.sdk.utils.j.f(str2, sb.toString());
    }

    public static void k(StringBuilder sb, Object obj, l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static void l(String str) {
        if (f.f11859g.isDebugMode()) {
            Log.d("npth", String.valueOf(str));
        }
    }

    public static void m(Throwable th) {
        if (f.f11859g.isDebugMode()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }

    public static void n(MonitorCrash monitorCrash, Throwable th, String str, Map map, String str2) {
        StackTraceElement[] stackTrace;
        StackTraceElement stackTraceElement;
        try {
            if (p.a(monitorCrash)) {
                l("[reportException]upload limit all.");
                return;
            }
            if (th != null && (stackTraceElement = (stackTrace = th.getStackTrace())[0]) != null) {
                String strB = h.b(th);
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                c cVarV = c.v(stackTraceElement, strB, str, Thread.currentThread().getName(), str2);
                if (monitorCrash != null) {
                    cVarV.e(h4.b.a(monitorCrash, th, stackTrace), "exception_line_num");
                }
                h(map, cVarV);
                p159u4.h.e().a(CrashType.ENSURE, cVarV);
                p127q4.j.b(monitorCrash, cVarV);
                l("[reportException] " + str);
                p002a4.a aVarA = p002a4.a.a();
                JSONObject jSONObject = cVarV.f19034a;
                aVarA.getClass();
                p002a4.a.f(jSONObject);
            }
        } catch (Throwable th2) {
            m(th2);
        }
    }

    public static final void o(P7.c cVar, Object obj) {
        if (cVar.c(obj)) {
            k.c(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
        } else {
            throw new ClassCastException("Value cannot be cast to " + cVar.a());
        }
    }

    public static void p(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e9) {
                throw e9;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] q(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i9 = 0; i9 < iArr.length; i9++) {
            jArr[i9] = iArr[i9];
        }
        return jArr;
    }

    public static void r(g0.a.b bVar, g0.a.c cVar, int i9) throws IOException {
        byte[] bArr = new byte[8192];
        while (i9 > 0) {
            int iMin = Math.min(i9, 8192);
            int i10 = bVar.read(bArr, 0, iMin);
            if (i10 != iMin) {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
            i9 -= i10;
            cVar.write(bArr, 0, i10);
        }
    }

    public static void s(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i9 = inputStream.read(bArr);
            if (i9 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i9);
            }
        }
    }

    public static b t(int i9) {
        if (i9 != 0) {
            return i9 != 1 ? new H5.k() : new H5.e();
        }
        return new H5.k();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object u(d dVar, D7.c cVar) {
        n nVar;
        y yVar;
        W7.a e9;
        m mVar;
        if (cVar instanceof n) {
            nVar = (n) cVar;
            int i9 = nVar.f4963d;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                nVar.f4963d = i9 - Integer.MIN_VALUE;
            } else {
                nVar = new n(cVar);
            }
        } else {
            nVar = new n(cVar);
        }
        Object obj = nVar.f4962c;
        Object obj2 = C7.a.f1806a;
        int i10 = nVar.f4963d;
        if (i10 == 0) {
            g.b(obj);
            y yVar2 = new y();
            m mVar2 = new m(yVar2);
            try {
                nVar.f4960a = yVar2;
                nVar.f4961b = mVar2;
                nVar.f4963d = 1;
                if (dVar.c(mVar2, nVar) == obj2) {
                    return obj2;
                }
                yVar = yVar2;
            } catch (W7.a e10) {
                yVar = yVar2;
                e9 = e10;
                mVar = mVar2;
                if (e9.f5076a != mVar) {
                    throw e9;
                }
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mVar = nVar.f4961b;
            yVar = nVar.f4960a;
            try {
                g.b(obj);
            } catch (W7.a e11) {
                e9 = e11;
                if (e9.f5076a != mVar) {
                    throw e9;
                }
            }
        }
        return yVar.f20008a;
    }

    public static B7.e v(B7.e eVar) {
        B7.e<Object> eVarIntercepted;
        k.e(eVar, "<this>");
        D7.c cVar = eVar instanceof D7.c ? (D7.c) eVar : null;
        return (cVar == null || (eVarIntercepted = cVar.intercepted()) == null) ? eVar : eVarIntercepted;
    }

    public static void w(ViewGroup viewGroup, float f6) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof H5.h) {
            ((H5.h) background).j(f6);
        }
    }

    public static Set x(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return r.f22410a;
        }
        if (length == 1) {
            Set setSingleton = Collections.singleton(objArr[0]);
            k.d(setSingleton, "singleton(...)");
            return setSingleton;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(t.A(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static void y(View view, H5.h hVar) {
        p195y5.a aVar = hVar.f2420a.f2443b;
        if (aVar == null || !aVar.f22388a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            elevation += ((View) parent).getElevation();
        }
        H5.h.b bVar = hVar.f2420a;
        if (bVar.f2452l != elevation) {
            bVar.f2452l = elevation;
            hVar.n();
        }
    }

    public static void z(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof H5.h) {
            y(viewGroup, (H5.h) background);
        }
    }

    @Override // p090m1.a
    public String a() {
        return null;
    }

    @Override // p090m1.a
    public String b() {
        return null;
    }

    @Override // p090m1.a
    public String c() {
        return null;
    }

    @Override // p090m1.a
    public String getDid() {
        return null;
    }

    @Override // p116p2.a
    public boolean getLogTypeSwitch(String str) {
        return false;
    }

    @Override // p116p2.a
    public boolean getServiceSwitch(String str) {
        return false;
    }

    @Override // p090m1.a
    public String getUserId() {
        return null;
    }

    @Override // p116p2.a
    public boolean a(String str) {
        return false;
    }

    @Override // p116p2.a
    public boolean b(String str) {
        return false;
    }

    @Override // p116p2.a
    public boolean c(String str) {
        return false;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f21199m)) {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStreamOpen = null;
            try {
                inputStreamOpen = context.getAssets().open("apmplus_hybrid/apmplus.hybrid.cn.js");
                while (true) {
                    int i9 = inputStreamOpen.read(bArr);
                    if (i9 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i9);
                }
            } catch (Exception unused) {
                if (inputStreamOpen != null) {
                    break;
                }
                String string = byteArrayOutputStream.toString();
                f21199m = string;
                f21199m = string.replace("apm_web_cdn_name", "https://apm.volccdn.com/mars-web/apmplus/web/browser.cn.js?aid=0&globalName=");
                return A.a.j(new StringBuilder(" javascript:(  function(){ "), f21199m, " }  )() ");
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
            inputStreamOpen.close();
            String string2 = byteArrayOutputStream.toString();
            f21199m = string2;
            f21199m = string2.replace("apm_web_cdn_name", "https://apm.volccdn.com/mars-web/apmplus/web/browser.cn.js?aid=0&globalName=");
        }
        return A.a.j(new StringBuilder(" javascript:(  function(){ "), f21199m, " }  )() ");
    }

    @Override // p116p2.a
    public boolean a(String str, String str2) {
        return false;
    }
}

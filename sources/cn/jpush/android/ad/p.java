package cn.jpush.android.ad;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11184a = e.b(new byte[]{85, 118, 97, 33, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, 44});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f11185b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f11186c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicReference<Context> f11187d = new AtomicReference<>();

    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11188a;

        public a(String str) {
            this.f11188a = str;
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f11188a, Locale.ENGLISH);
        }
    }

    public static double a(double d9, double d10, double d11, double d12) {
        double d13 = d10 * 0.008726646259971648d;
        double d14 = d12 * 0.008726646259971648d;
        return Math.round((Math.asin(Math.sqrt((Math.pow(Math.sin((d9 - d11) * 0.008726646259971648d), 2.0d) * (Math.cos(d14 * 2.0d) * Math.cos(d13 * 2.0d))) + Math.pow(Math.sin(d13 - d14), 2.0d))) * 1.2756274E7d) * 10000.0d) / 10000;
    }

    public static int b(Context context, int i9) {
        return (int) ((i9 / 375.0f) * a(context).widthPixels);
    }

    public static int c(Context context, int i9) {
        return (int) ((i9 / 667.0f) * a(context).heightPixels);
    }

    private static Object d() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Object e() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(Context context, int i9) {
        return context == null ? i9 : (int) TypedValue.applyDimension(1, i9, context.getResources().getDisplayMetrics());
    }

    public static int b(String str) {
        try {
            return Integer.valueOf(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim()).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static Object c() {
        Object objD = d();
        return objD != null ? objD : e();
    }

    public static Context a() {
        return b((Context) null);
    }

    private static Application b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(c(), new Object[0]);
            if (objInvoke == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static LinkedList<String> c(String str) {
        try {
            LinkedList<String> linkedList = new LinkedList<>();
            if (str != null && str.length() > 0) {
                for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (!TextUtils.isEmpty(str2)) {
                        linkedList.add(str2);
                    }
                }
            }
            return linkedList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static DisplayMetrics a(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static Context b(Context context) {
        Context contextB;
        Context appContext = f11187d.get();
        if (appContext != null) {
            return appContext;
        }
        if (context != null) {
            contextB = context.getApplicationContext();
        } else {
            try {
                appContext = JPushConstants.getAppContext(context);
            } catch (Throwable unused) {
            }
            contextB = appContext == null ? b() : appContext;
        }
        AtomicReference<Context> atomicReference = f11187d;
        while (!atomicReference.compareAndSet(null, contextB)) {
            if (atomicReference.get() != null) {
                return f11187d.get();
            }
        }
        return contextB;
    }

    public static ViewGroup.LayoutParams a(Context context, View view, boolean z8, int i9, int i10, int i11, int i12) {
        if (context == null || view == null) {
            return null;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : new ViewGroup.MarginLayoutParams(layoutParams);
            if (z8) {
                i9 = a(context, i9);
                i11 = a(context, i11);
                i10 = a(context, i10);
                i12 = a(context, i12);
            }
            marginLayoutParams.setMargins(i9, i10, i11, i12);
            view.setLayoutParams(marginLayoutParams);
            return marginLayoutParams;
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("[setViewMargin] failed. err: "), "Utils");
            return null;
        }
    }

    public static byte[] b(InputStream inputStream) throws Throwable {
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i9 = inputStream.read(bArr);
                    if (i9 == -1) {
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        a(byteArrayOutputStream2);
                        return byteArray;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i9);
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> aVar = f11186c.get(str);
        if (aVar == null) {
            synchronized (f11185b) {
                try {
                    aVar = f11186c.get(str);
                    if (aVar == null) {
                        aVar = new a(str);
                        f11186c.put(str, aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aVar.get();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                String strOptString = jSONArray.optString(i9);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
        }
        return arrayList;
    }

    public static void a(Context context, List<String> list) {
        if (!JCoreHelper.isIpv6Priority(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        return bArr;
    }

    public static byte[] a(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int i9 = gZIPInputStream.read(bArr2);
                    if (i9 < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a(byteArrayOutputStream);
                        a((Closeable) byteArrayInputStream);
                        a((Closeable) gZIPInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i9);
                }
            } catch (Throwable th2) {
                th = th2;
                a(byteArrayOutputStream);
                a((Closeable) byteArrayInputStream);
                a((Closeable) gZIPInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            gZIPInputStream = null;
            th = th3;
        }
    }
}

package com.engagelab.privates.common.utils;

import H2.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    private static final String TAG = "Utils";
    private static final String regEx = "[^0-9]";
    private static List<String> supportImageType;
    private static final Object dateLock = new Object();
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> sdfMap = new ConcurrentHashMap<>();
    private static HashMap<Integer, WeakReference<WindowManager>> windowManagerMap = new HashMap<>();
    private static LinkedHashMap<String, String> cacheCurrentType = new LinkedHashMap<>();

    static {
        ArrayList arrayList = new ArrayList();
        supportImageType = arrayList;
        arrayList.add("image/png");
        supportImageType.add("image/jpg");
        supportImageType.add("image/jpeg");
    }

    public static boolean checkValidImageUrl(String str, boolean z8) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                String contentType = httpURLConnection.getContentType();
                if (isSupportType(contentType)) {
                    if (z8) {
                        saveCurrentType(str, contentType);
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused) {
                    }
                    return true;
                }
            } catch (Throwable unused2) {
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection = httpURLConnection2;
                }
                return false;
            }
        } catch (Throwable unused3) {
        }
        try {
            httpURLConnection.disconnect();
        } catch (Throwable unused4) {
        }
        return false;
    }

    public static void clearWindowManagerForActivity(String str) {
        windowManagerMap.remove(Integer.valueOf(str.hashCode()));
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int dpToPx(Context context, int i9) {
        return context == null ? i9 : (int) TypedValue.applyDimension(1, i9, context.getResources().getDisplayMetrics());
    }

    private static float getBasicHeight(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? 375.0f : 667.0f;
    }

    private static float getBasicWidth(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? 667.0f : 375.0f;
    }

    public static double getDistance(double d9, double d10, double d11, double d12) {
        double d13 = d10 * 0.008726646259971648d;
        double d14 = d12 * 0.008726646259971648d;
        return Math.round((Math.asin(Math.sqrt((Math.pow(Math.sin((d9 - d11) * 0.008726646259971648d), 2.0d) * (Math.cos(d14 * 2.0d) * Math.cos(d13 * 2.0d))) + Math.pow(Math.sin(d13 - d14), 2.0d))) * 1.2756274E7d) * 10000.0d) / 10000;
    }

    public static int getHeight(Context context, int i9) {
        return (int) ((i9 / getBasicHeight(context)) * providesDisplayMetrics(context).heightPixels);
    }

    public static int getNumber(String str) {
        try {
            return Integer.valueOf(Pattern.compile(regEx).matcher(str).replaceAll("").trim()).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getTypeFromUrl(String str) {
        try {
            String str2 = cacheCurrentType.get(str);
            cacheCurrentType.remove(str);
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int getWidth(Context context, int i9) {
        return (int) ((i9 / getBasicWidth(context)) * providesDisplayMetrics(context).widthPixels);
    }

    public static WindowManager getWindowManagerForActivity(String str) {
        WeakReference<WindowManager> weakReference = windowManagerMap.get(Integer.valueOf(str.hashCode()));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Object objInvoke;
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new IllegalArgumentException("argClasses' size is not equal to args' size");
        }
        Method method = obj.getClass().getMethod(str, clsArr);
        boolean zIsAccessible = method.isAccessible();
        if (!zIsAccessible) {
            method.setAccessible(true);
        }
        Exception exc = null;
        try {
            objInvoke = method.invoke(obj, objArr);
        } catch (Exception e9) {
            exc = e9;
            objInvoke = null;
        }
        if (!zIsAccessible) {
            method.setAccessible(false);
        }
        if (exc == null) {
            return objInvoke;
        }
        throw exc;
    }

    private static boolean isSupportType(String str) {
        try {
            return supportImageType.contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static ArrayList<String> jsonArray2StringList(JSONArray jSONArray) {
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

    public static String listToString(Collection<String> collection, String str) {
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

    public static DisplayMetrics providesDisplayMetrics(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static byte[] read1024(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i9 = inputStream.read(bArr);
                    if (i9 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i9);
                }
            } catch (Throwable th) {
                th = th;
                closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] readAvailable(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        return bArr;
    }

    private static void saveCurrentType(String str, String str2) {
        try {
            if (cacheCurrentType.containsKey(str)) {
                return;
            }
            cacheCurrentType.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static ViewGroup.LayoutParams setViewMargin(Context context, View view, boolean z8, int i9, int i10, int i11, int i12) {
        if (context == null || view == null) {
            return null;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : new ViewGroup.MarginLayoutParams(layoutParams);
            if (z8) {
                i9 = dpToPx(context, i9);
                i11 = dpToPx(context, i11);
                i10 = dpToPx(context, i10);
                i12 = dpToPx(context, i12);
            }
            marginLayoutParams.setMargins(i9, i10, i11, i12);
            view.setLayoutParams(marginLayoutParams);
            return marginLayoutParams;
        } catch (Throwable th) {
            a.k(th, new StringBuilder("[setViewMargin] failed. err: "), TAG);
            return null;
        }
    }

    public static void setWindowManager(String str, WindowManager windowManager) {
        int iHashCode = str.hashCode();
        Iterator<Map.Entry<Integer, WeakReference<WindowManager>>> it = windowManagerMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, WeakReference<WindowManager>> next = it.next();
            int iIntValue = next.getKey().intValue();
            WeakReference<WindowManager> value = next.getValue();
            if (iIntValue != iHashCode) {
                if (value != null) {
                    value.clear();
                }
                it.remove();
            }
        }
        windowManagerMap.put(Integer.valueOf(iHashCode), new WeakReference<>(windowManager));
    }
}

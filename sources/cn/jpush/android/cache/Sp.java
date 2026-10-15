package cn.jpush.android.cache;

import W5.f;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.h;
import cn.jpush.android.ad.n;
import cn.jpush.android.ad.p;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, SharedPreferences> f11272a = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Handler f11275a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Context f11279e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f11276b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final LinkedList<Runnable> f11277c = new LinkedList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f11278d = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Object f11280f = new Object();

        /* JADX INFO: renamed from: cn.jpush.android.cache.Sp$a$a, reason: collision with other inner class name */
        public static class HandlerC0140a extends Handler {
            public HandlerC0140a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JCoreHelper.futureExecutor(a.f11279e, new h() { // from class: cn.jpush.android.cache.Sp.a.a.1
                        @Override // cn.jpush.android.ad.h
                        public void a() {
                            a.c(a.f11279e);
                        }
                    });
                }
            }
        }

        private static Handler b(Context context) {
            f11279e = context != null ? context.getApplicationContext() : JPushConstants.getAppContext(null);
            if (f11275a == null) {
                synchronized (f11276b) {
                    try {
                        if (f11275a == null) {
                            f11275a = new HandlerC0140a(Looper.getMainLooper());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f11275a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            LinkedList linkedList;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                synchronized (f11280f) {
                    try {
                        synchronized (f11276b) {
                            try {
                                LinkedList<Runnable> linkedList2 = f11277c;
                                linkedList = (LinkedList) linkedList2.clone();
                                linkedList2.clear();
                                Handler handlerB = b(context);
                                if (handlerB != null) {
                                    handlerB.removeMessages(1);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (linkedList.size() > 0) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                ((Runnable) it.next()).run();
                            }
                            if (JConstants.DEBUG_MODE) {
                                Logger.d("Sp", "sp processing " + linkedList.size() + " items took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                f.r(th3, new StringBuilder("sp commit task error, "), "Sp");
            }
        }

        public static void a(Context context, Runnable runnable, boolean z8) {
            try {
                Handler handlerB = b(context);
                if (handlerB != null) {
                    synchronized (f11276b) {
                        try {
                            f11277c.add(runnable);
                            if (z8 && f11278d) {
                                handlerB.sendEmptyMessageDelayed(1, 100L);
                            } else {
                                handlerB.sendEmptyMessage(1);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                f.r(th2, new StringBuilder("sp task add queue failed, "), "Sp");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences b(Context context, String str) {
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = f11272a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || (appContext = JPushConstants.getAppContext(context)) == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = appContext.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        c(appContext, str);
        return sharedPreferences2;
    }

    public static void clear(Context context, String str) {
        SharedPreferences sharedPreferencesB = b(context, str);
        if (sharedPreferencesB != null) {
            sharedPreferencesB.edit().clear().apply();
        }
    }

    public static <T> T get(Context context, Key<T> key) {
        T t = (T) getWithNull(context, key);
        return t != null ? t : key.f11269c;
    }

    public static <T> T getWithNull(Context context, Key<T> key) {
        Object objA = a(b(context, key.f11267a), key.f11268b, key.f11269c);
        if (objA == null && key.f11270d) {
            objA = (T) a(reload(context, key.f11267a), key.f11268b, key.f11269c);
        }
        if (objA == null) {
            return null;
        }
        if (key.f11271e && (objA instanceof String)) {
            String str = objA;
            if (str.length() > 0) {
                objA = (T) n.b(str, p.f11184a);
            }
        }
        key.set(objA);
        return (T) objA;
    }

    public static void read(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        for (Key<?> key : keyArr) {
            get(context, key);
        }
    }

    public static SharedPreferences reload(Context context, String str) {
        Context appContext = JPushConstants.getAppContext(context);
        if (appContext == null) {
            return null;
        }
        appContext.getSharedPreferences(str, 4);
        return appContext.getSharedPreferences(str, 0);
    }

    public static void set(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        if (!a()) {
            sync_set(context, keyArr);
        } else {
            Logger.d("Sp", "main thread, async sp set");
            a(context, true, keyArr);
        }
    }

    public static void sync_set(Context context, Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        a(context, false, keyArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(SharedPreferences sharedPreferences, String str, T t) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t instanceof Boolean) {
                    return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
                }
                if (t instanceof String) {
                    return (T) sharedPreferences.getString(str, (String) t);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t).intValue()));
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(sharedPreferences.getLong(str, ((Long) t).longValue()));
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t, boolean z8) {
        ?? r8;
        if (editor != null) {
            if (t == 0) {
                editor.remove(str);
                return;
            }
            if (t instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
                return;
            }
            if (!(t instanceof String)) {
                if (t instanceof Integer) {
                    editor.putInt(str, ((Integer) t).intValue());
                    return;
                } else if (t instanceof Long) {
                    editor.putLong(str, ((Long) t).longValue());
                    return;
                } else {
                    if (t instanceof Float) {
                        editor.putFloat(str, ((Float) t).floatValue());
                        return;
                    }
                    return;
                }
            }
            String str2 = (String) t;
            if (z8 && str2.length() > 0) {
                r8 = t;
                r8 = t;
                r8 = (T) n.a(str2, p.f11184a);
            }
            r8 = t;
            r8 = t;
            r8 = t;
            editor.putString(str, (String) r8);
        }
    }

    private static void a(final Context context, boolean z8, final Key<?>... keyArr) {
        h hVar = new h() { // from class: cn.jpush.android.cache.Sp.1
            @Override // cn.jpush.android.ad.h
            public void a() {
                SharedPreferences sharedPreferencesB;
                try {
                    HashMap map = new HashMap();
                    for (Key key : keyArr) {
                        SharedPreferences.Editor editorEdit = (SharedPreferences.Editor) map.get(key.f11267a);
                        if (editorEdit == null && (sharedPreferencesB = Sp.b(context, key.f11267a)) != null) {
                            editorEdit = sharedPreferencesB.edit();
                            map.put(key.f11267a, editorEdit);
                        }
                        Sp.b(editorEdit, key.f11268b, key.f11269c, key.f11271e);
                    }
                    for (String str : map.keySet()) {
                        SharedPreferences.Editor editor = (SharedPreferences.Editor) map.get(str);
                        if (editor != null && !editor.commit()) {
                            Logger.w("Sp", "sp commit failed, sp_file: " + str);
                        }
                    }
                } catch (Throwable th) {
                    f.r(th, new StringBuilder("sp commit failed, "), "Sp");
                }
            }
        };
        try {
            if (z8) {
                a.a(context, hVar, false);
            } else {
                hVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    private static void c(Context context, String str) {
    }
}

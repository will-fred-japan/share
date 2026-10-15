package cn.jiguang.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.aw.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, SharedPreferences> f10504a = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile Handler f10507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f10508b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final LinkedList<Runnable> f10509c = new LinkedList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f10510d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Object f10511e = new Object();

        /* JADX INFO: renamed from: cn.jiguang.e.f$a$a, reason: collision with other inner class name */
        public static class HandlerC0131a extends Handler {
            public HandlerC0131a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    cn.jiguang.av.d.a("FUTURE_TASK", (Runnable) new cn.jiguang.av.b() { // from class: cn.jiguang.e.f.a.a.1
                        @Override // cn.jiguang.av.b
                        public void a() {
                            a.c();
                        }
                    }, false);
                }
            }
        }

        private static Handler b() {
            if (f10507a == null) {
                synchronized (f10508b) {
                    try {
                        if (f10507a == null) {
                            f10507a = new HandlerC0131a(Looper.getMainLooper());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f10507a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c() {
            LinkedList linkedList;
            try {
                System.currentTimeMillis();
                synchronized (f10511e) {
                    try {
                        synchronized (f10508b) {
                            try {
                                LinkedList<Runnable> linkedList2 = f10509c;
                                linkedList = (LinkedList) linkedList2.clone();
                                linkedList2.clear();
                                Handler handlerB = b();
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
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                W5.e.t(th3, new StringBuilder("sp commit task error, "), "Sp");
            }
        }

        public static void a(Runnable runnable, boolean z8) {
            try {
                Handler handlerB = b();
                if (handlerB != null) {
                    synchronized (f10508b) {
                        try {
                            f10509c.add(runnable);
                            if (z8 && f10510d) {
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
                W5.e.t(th2, new StringBuilder("sp task add queue failed, "), "Sp");
            }
        }
    }

    public static <T> T b(Context context, d<T> dVar) {
        T t = (T) a(d(context, dVar.f10492b), dVar.f10493c, dVar.f10494d, dVar.f10496f);
        if (t == null && dVar.f10495e) {
            t = (T) a(c(context, dVar.f10492b), dVar.f10493c, dVar.f10494d, dVar.f10496f);
        }
        if (t == null) {
            return null;
        }
        dVar.a(t);
        return t;
    }

    private static SharedPreferences c(Context context, String str) {
        if (context == null) {
            return null;
        }
        context.getSharedPreferences(str, 4);
        return context.getSharedPreferences(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (context == null) {
            context = cn.jiguang.aw.d.a();
        }
        Map<String, SharedPreferences> map = f10504a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || context == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        b(context, str);
        return sharedPreferences2;
    }

    public static <T> T a(Context context, d<T> dVar) {
        T t = (T) b(context, dVar);
        return t != null ? t : dVar.f10494d;
    }

    private static void b(Context context, String str) {
        String str2 = (String) a(context, d.am());
        if (!TextUtils.isEmpty(str2)) {
            str2.startsWith("1.");
        }
        if (((Integer) a(context, d.al())).intValue() == 0) {
            a(context, d.a.C0130a.a(), d.a.C0130a.b());
            a(context, d.a.C0130a.c(), d.a.C0130a.d());
        }
        a(context, (d<?>[]) new d[]{d.al().a(1)});
    }

    private static <T> T a(SharedPreferences sharedPreferences, String str, T t) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                String str2 = (T) sharedPreferences.getString(str, null);
                Object obj = str2;
                if (str2 != null && str2.length() > 0) {
                    obj = str2;
                    obj = (T) t.b(str2, cn.jiguang.a.a.j);
                }
                if (obj == null) {
                    return t;
                }
                if (t instanceof Boolean) {
                    return (T) Boolean.valueOf((String) obj);
                }
                if (t instanceof String) {
                    return (T) obj;
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf((String) obj);
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf((String) obj);
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf((String) obj);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void b(Context context, d<?>... dVarArr) {
        if (dVarArr == null || dVarArr.length <= 0) {
            return;
        }
        a(context, false, dVarArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(SharedPreferences sharedPreferences, String str, T t, boolean z8) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (z8) {
                    return (T) a(sharedPreferences, str, t);
                }
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
    public static <T> void b(SharedPreferences.Editor editor, String str, T t, boolean z8) {
        if (editor != null) {
            if (t == 0) {
                editor.remove(str);
                return;
            }
            if (z8) {
                String strValueOf = String.valueOf(t);
                if (strValueOf.length() > 0) {
                    strValueOf = t.a(strValueOf, cn.jiguang.a.a.j);
                }
                editor.putString(str, strValueOf);
                return;
            }
            if (t instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
                return;
            }
            if (t instanceof String) {
                editor.putString(str, (String) t);
                return;
            }
            if (t instanceof Integer) {
                editor.putInt(str, ((Integer) t).intValue());
            } else if (t instanceof Long) {
                editor.putLong(str, ((Long) t).longValue());
            } else if (t instanceof Float) {
                editor.putFloat(str, ((Float) t).floatValue());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(Context context, d<T> dVar, d<T> dVar2) {
        Object objB;
        if (b(context, dVar) != null || (objB = b(context, dVar2)) == null) {
            return;
        }
        a(context, (d<?>[]) new d[]{dVar.a(objB)});
        a(context, (d<?>[]) new d[]{dVar2.a((Object) null)});
    }

    private static void a(final Context context, boolean z8, final d<?>... dVarArr) {
        try {
            cn.jiguang.av.b bVar = new cn.jiguang.av.b() { // from class: cn.jiguang.e.f.1
                @Override // cn.jiguang.av.b
                public void a() {
                    SharedPreferences sharedPreferencesD;
                    try {
                        HashMap map = new HashMap();
                        for (d dVar : dVarArr) {
                            SharedPreferences.Editor editorEdit = (SharedPreferences.Editor) map.get(dVar.f10492b);
                            if (editorEdit == null && (sharedPreferencesD = f.d(context, dVar.f10492b)) != null) {
                                editorEdit = sharedPreferencesD.edit();
                                map.put(dVar.f10492b, editorEdit);
                            }
                            f.b(editorEdit, dVar.f10493c, dVar.f10494d, dVar.f10496f);
                        }
                        for (Map.Entry entry : map.entrySet()) {
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) entry.getValue();
                            if (editor != null) {
                                editor.apply();
                            }
                        }
                    } catch (Throwable th) {
                        W5.e.t(th, new StringBuilder("sp commit failed, "), "Sp");
                    }
                }
            };
            if (z8) {
                a.a(bVar, false);
            } else {
                bVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, d<?>... dVarArr) {
        if (dVarArr == null || dVarArr.length <= 0) {
            return;
        }
        if (!a()) {
            b(context, dVarArr);
        } else {
            cn.jiguang.x.f.c("Sp", "main thread, async sp set");
            a(context, true, dVarArr);
        }
    }

    private static boolean a() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("[isMainThread] failed:"), "Sp");
            return true;
        }
    }
}

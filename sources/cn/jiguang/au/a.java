package cn.jiguang.au;

import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, g> f9446a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<String, JAction> f9447b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HashMap<String, JActionExtra> f9448c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f9449d = new Object();

    /* JADX INFO: renamed from: cn.jiguang.au.a$a, reason: collision with other inner class name */
    public static final class C0126a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f9450a = new a();
    }

    private a() {
    }

    public JAction a(String str) {
        if (f9447b.containsKey(str)) {
            return f9447b.get(str);
        }
        return null;
    }

    public JActionExtra b(String str) {
        if (f9448c.containsKey(str)) {
            return f9448c.get(str);
        }
        return null;
    }

    public static a a() {
        return C0126a.f9450a;
    }

    public void b(String str, String str2) {
        d.a("DispacthManager", "addActionExtra type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f9446a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f9446a.put(str, gVar);
        }
        if (f9448c.containsKey(str)) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(str2).newInstance();
            if (objNewInstance instanceof JActionExtra) {
                f9448c.put(str, (JActionExtra) objNewInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public void a(String str, String str2) {
        d.a("DispacthManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f9446a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f9446a.put(str, gVar);
        }
        if (f9447b.containsKey(str)) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(str2).newInstance();
            if (objNewInstance instanceof JAction) {
                f9447b.put(str, (JAction) objNewInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }
}

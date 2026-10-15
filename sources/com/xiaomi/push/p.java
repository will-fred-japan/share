package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile p f18131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f928a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, Map<String, String>> f929a = new HashMap();

    private p(Context context) {
        this.f927a = context;
    }

    private synchronized void b(String str, String str2, String str3) {
        try {
            if (this.f929a == null) {
                this.f929a = new HashMap();
            }
            Map<String, String> map = this.f929a.get(str);
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(str2, str3);
            this.f929a.put(str, map);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static p a(Context context) {
        if (f18131a == null) {
            synchronized (p.class) {
                try {
                    if (f18131a == null) {
                        f18131a = new p(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18131a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m660a(final String str, final String str2, final String str3) {
        b(str, str2, str3);
        this.f928a.post(new Runnable() { // from class: com.xiaomi.push.p.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = p.this.f927a.getSharedPreferences(str, 4).edit();
                editorEdit.putString(str2, str3);
                editorEdit.commit();
            }
        });
    }

    private synchronized String a(String str, String str2) {
        if (this.f929a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Map<String, String> map = this.f929a.get(str);
                if (map != null) {
                    return map.get(str2);
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return "";
    }

    public synchronized String a(String str, String str2, String str3) {
        String strA = a(str, str2);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        return this.f927a.getSharedPreferences(str, 4).getString(str2, str3);
    }
}

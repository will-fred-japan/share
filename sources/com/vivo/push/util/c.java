package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: BaseSharePreference.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f16858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile SharedPreferences f16860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f16861d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, Long> f16862e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f16863f = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<String, Boolean> f16864g = new HashMap<>();

    public final void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.f16859b = str;
        this.f16860c = context.getSharedPreferences(str, 0);
        this.f16858a = context;
    }

    public final String b(String str, String str2) {
        String string = this.f16861d.get(str);
        if (string != null) {
            return string;
        }
        c();
        if (this.f16860c != null) {
            string = this.f16860c.getString(str, str2);
            if (!TextUtils.isEmpty(string) && !string.equals(str2)) {
                this.f16861d.put(str, string);
            }
        }
        return string;
    }

    public final void c(String str) {
        this.f16862e.remove(str);
        this.f16863f.remove(str);
        this.f16864g.remove(str);
        this.f16861d.remove(str);
        c();
        if (this.f16860c != null) {
            SharedPreferences.Editor editorEdit = this.f16860c.edit();
            if (this.f16860c.contains(str)) {
                editorEdit.remove(str);
                a(editorEdit);
            }
        }
    }

    public final SharedPreferences a() {
        c();
        return this.f16860c;
    }

    public final boolean b(String str) {
        Boolean bool = this.f16864g.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        c();
        Boolean bool2 = Boolean.FALSE;
        if (this.f16860c != null) {
            Boolean boolValueOf = Boolean.valueOf(this.f16860c.getBoolean(str, false));
            if (!boolValueOf.equals(bool2)) {
                this.f16864g.put(str, boolValueOf);
            }
            bool2 = boolValueOf;
        }
        return bool2.booleanValue();
    }

    public final void a(String str, String str2) {
        this.f16861d.put(str, str2);
        c();
        if (this.f16860c != null) {
            SharedPreferences.Editor editorEdit = this.f16860c.edit();
            editorEdit.putString(str, str2);
            a(editorEdit);
        }
    }

    private synchronized void c() {
        try {
            if (this.f16860c == null) {
                Context context = this.f16858a;
                if (context != null) {
                    this.f16860c = context.getSharedPreferences(this.f16859b, 0);
                } else {
                    throw new RuntimeException("SharedPreferences is not init", new Throwable());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(String str, int i9) {
        this.f16863f.put(str, Integer.valueOf(i9));
        c();
        if (this.f16860c != null) {
            SharedPreferences.Editor editorEdit = this.f16860c.edit();
            editorEdit.putInt(str, i9);
            a(editorEdit);
        }
    }

    public final int b(String str, int i9) {
        Integer numValueOf = this.f16863f.get(str);
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        c();
        if (this.f16860c != null) {
            numValueOf = Integer.valueOf(this.f16860c.getInt(str, i9));
            if (!numValueOf.equals(Integer.valueOf(i9))) {
                this.f16863f.put(str, numValueOf);
            }
        }
        return numValueOf.intValue();
    }

    public final void a(String str, long j) {
        this.f16862e.put(str, Long.valueOf(j));
        c();
        if (this.f16860c != null) {
            SharedPreferences.Editor editorEdit = this.f16860c.edit();
            editorEdit.putLong(str, j);
            a(editorEdit);
        }
    }

    public final long b(String str, long j) {
        Long lValueOf = this.f16862e.get(str);
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        c();
        if (this.f16860c != null) {
            lValueOf = Long.valueOf(this.f16860c.getLong(str, j));
            if (!lValueOf.equals(Long.valueOf(j))) {
                this.f16862e.put(str, lValueOf);
            }
        }
        return lValueOf.longValue();
    }

    public final void a(String str) {
        this.f16864g.put(str, Boolean.TRUE);
        c();
        if (this.f16860c != null) {
            SharedPreferences.Editor editorEdit = this.f16860c.edit();
            editorEdit.putBoolean(str, true);
            a(editorEdit);
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void b() {
        this.f16862e.clear();
        this.f16863f.clear();
        this.f16864g.clear();
        this.f16861d.clear();
        c();
        if (this.f16860c != null) {
            SharedPreferences.Editor editorEdit = this.f16860c.edit();
            editorEdit.clear();
            a(editorEdit);
        }
    }
}

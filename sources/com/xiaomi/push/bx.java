package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bx f17107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f157a;

    private bx(Context context) {
        this.f157a = context;
    }

    public static bx a(Context context) {
        if (f17107a == null) {
            synchronized (bx.class) {
                try {
                    if (f17107a == null) {
                        f17107a = new bx(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17107a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m138a(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.f157a.getSharedPreferences(str, 4).edit();
        editorEdit.putString(str2, str3);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m137a(String str, String str2, long j) {
        SharedPreferences.Editor editorEdit = this.f157a.getSharedPreferences(str, 4).edit();
        editorEdit.putLong(str2, j);
        editorEdit.commit();
    }

    public synchronized String a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f157a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized long a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f157a.getSharedPreferences(str, 4).getLong(str2, j);
    }
}

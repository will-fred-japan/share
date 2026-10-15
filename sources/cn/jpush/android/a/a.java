package cn.jpush.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f11015a;

    public static void a(Context context) {
        if (f11015a == null) {
            f11015a = context.getSharedPreferences("asus_push_sdk_preferences", 0);
        }
    }

    public static Boolean b(String str, boolean z8) {
        SharedPreferences sharedPreferences = f11015a;
        return sharedPreferences != null ? Boolean.valueOf(sharedPreferences.getBoolean(str, true)) : Boolean.TRUE;
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f11015a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        }
    }

    public static String b(String str, String str2) {
        SharedPreferences sharedPreferences = f11015a;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public static void a(String str, boolean z8) {
        SharedPreferences sharedPreferences = f11015a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, false);
            editorEdit.apply();
        }
    }
}

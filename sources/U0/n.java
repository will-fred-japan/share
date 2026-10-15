package U0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: SharedPreferenceCacheHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class n extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f4653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f4654c;

    public n(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.f4653b = context.getSharedPreferences("snssdk_openudid", 0);
        this.f4654c = context.getSharedPreferences(str, 0);
    }

    @Override // U0.d
    public final void c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = f(str).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    @Override // U0.d
    public final String d(String str) {
        return f(str).getString(str, null);
    }

    public final SharedPreferences f(String str) {
        return "device_id".equals(str) ? this.f4654c : this.f4653b;
    }
}

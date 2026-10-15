package p049g6;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: NamespacedConfigSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f18973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f18974b;

    public q(Context context, String str) {
        this.f18973a = context.getSharedPreferences("FlutterSecureStorageConfiguration:" + str, 0);
        this.f18974b = context.getSharedPreferences("FlutterSecureStorageConfiguration", 0);
    }

    public final String a(String str) {
        String string = this.f18973a.getString(str, null);
        return string != null ? string : this.f18974b.getString(str, null);
    }
}

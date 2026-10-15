package T5;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: compiled from: SharedPrefKeysetWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences.Editor f4564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4565b;

    public e(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.f4565b = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.f4564a = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.f4564a = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }
}

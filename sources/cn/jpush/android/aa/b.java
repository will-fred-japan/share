package cn.jpush.android.aa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f11021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f11022b;

    public b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jpush.statistics", 0);
        this.f11021a = sharedPreferences;
        this.f11022b = sharedPreferences.edit();
    }

    public Map<String, Integer> a() {
        return this.f11021a.getAll();
    }

    public void b() {
        this.f11022b.clear();
        this.f11022b.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a(String str) {
        this.f11022b.putInt(str, this.f11021a.getInt(str, 0) + 1);
        this.f11022b.apply();
    }
}

package com.huawei.hms.hatool;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15262a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15263b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.315" + p.a();
    }

    public void b(int i9, String str, String str2) {
        a(i9, "FormalHASDK", p171w.a.a(str, "=> ", str2));
    }

    public void a(int i9) {
        Log.i("FormalHASDK", System.lineSeparator() + "======================================= " + System.lineSeparator() + a() + "" + System.lineSeparator() + "=======================================");
        this.f15263b = i9;
        this.f15262a = true;
    }

    public void a(int i9, String str, String str2) {
        if (i9 == 3) {
            Log.d(str, str2);
            return;
        }
        if (i9 == 5) {
            Log.w(str, str2);
        } else if (i9 != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public boolean b(int i9) {
        return this.f15262a && i9 >= this.f15263b;
    }
}

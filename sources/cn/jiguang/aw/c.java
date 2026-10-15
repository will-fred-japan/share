package cn.jiguang.aw;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static Bundle a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.isEmpty() ? new Bundle() : new Bundle(bundle);
        } catch (Throwable th) {
            defpackage.f.l("copy bundle failed, fallback to copy constructor: ", "BundleUtils", th);
            try {
                return new Bundle(bundle);
            } catch (Throwable th2) {
                cn.jiguang.x.f.i("BundleUtils", "copy bundle fallback failed: " + th2);
                return new Bundle();
            }
        }
    }

    public static Bundle b(Bundle bundle) {
        Bundle bundleA = a(bundle);
        return bundleA == null ? new Bundle() : bundleA;
    }
}

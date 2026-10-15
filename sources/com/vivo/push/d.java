package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: BundleWapper.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f16553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16555c;

    public d(String str, String str2, Bundle bundle) {
        this.f16554b = str;
        this.f16555c = str2;
        this.f16553a = bundle;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    public static d a(Intent intent) {
        String string;
        if (intent == null) {
            com.vivo.push.util.w.a("BundleWapper", "create error : intent is null");
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            string = extras.getString("client_pkgname");
            if (TextUtils.isEmpty(string)) {
                string = null;
            }
        } else {
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            com.vivo.push.util.w.b("BundleWapper", "create warning: pkgName is null");
        }
        String str = intent.getPackage();
        if (TextUtils.isEmpty(str)) {
            String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : null;
            if (TextUtils.isEmpty(packageName)) {
                com.vivo.push.util.w.b("BundleWapper", "create warning: targetPkgName is null");
            }
            str = packageName;
        }
        return new d(string, str, extras);
    }

    public final int b(String str, int i9) {
        Bundle bundle = this.f16553a;
        return bundle == null ? i9 : bundle.getInt(str, i9);
    }

    public final ArrayList<String> c(String str) {
        Bundle bundle = this.f16553a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final Serializable d(String str) {
        Bundle bundle = this.f16553a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean e(String str) {
        Bundle bundle = this.f16553a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    public final byte[] b(String str) {
        Bundle bundle = this.f16553a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    public final long b(String str, long j) {
        Bundle bundle = this.f16553a;
        return bundle == null ? j : bundle.getLong(str, j);
    }

    public final Bundle b() {
        return this.f16553a;
    }

    public final void a(String str, int i9) {
        if (this.f16553a == null) {
            this.f16553a = new Bundle();
        }
        this.f16553a.putInt(str, i9);
    }

    public final void a(String str, long j) {
        if (this.f16553a == null) {
            this.f16553a = new Bundle();
        }
        this.f16553a.putLong(str, j);
    }

    public final void a(String str, String str2) {
        if (this.f16553a == null) {
            this.f16553a = new Bundle();
        }
        this.f16553a.putString(str, str2);
    }

    public final void a(String str, byte[] bArr) {
        if (this.f16553a == null) {
            this.f16553a = new Bundle();
        }
        this.f16553a.putByteArray(str, bArr);
    }

    public final void a(String str, Serializable serializable) {
        if (this.f16553a == null) {
            this.f16553a = new Bundle();
        }
        this.f16553a.putSerializable(str, serializable);
    }

    public final void a(String str, Parcelable parcelable) {
        if (this.f16553a == null) {
            this.f16553a = new Bundle();
        }
        this.f16553a.putParcelable(str, parcelable);
    }

    public final void a(String str, boolean z8) {
        if (this.f16553a == null) {
            this.f16553a = new Bundle();
        }
        this.f16553a.putBoolean(str, z8);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.f16553a == null) {
            this.f16553a = new Bundle();
        }
        this.f16553a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        Bundle bundle = this.f16553a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final String a() {
        return this.f16554b;
    }
}

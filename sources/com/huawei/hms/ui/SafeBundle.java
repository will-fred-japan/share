package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class SafeBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f15575a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f15575a.containsKey(str);
        } catch (Throwable unused) {
            LogUtil.e("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f15575a.get(str);
        } catch (Exception e9) {
            LogUtil.e("SafeBundle", "get exception: " + e9.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f15575a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f15575a.getString(str);
        } catch (Throwable th) {
            LogUtil.e("SafeBundle", "getString exception: " + th.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f15575a.isEmpty();
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f15575a.size();
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f15575a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f15575a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i9) {
        try {
            return this.f15575a.getInt(str, i9);
        } catch (Throwable th) {
            LogUtil.e("SafeBundle", "getInt exception: " + th.getMessage(), true);
            return i9;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f15575a.getString(str, str2);
        } catch (Exception e9) {
            LogUtil.e("SafeBundle", "getString exception: " + e9.getMessage(), true);
            return str2;
        }
    }
}

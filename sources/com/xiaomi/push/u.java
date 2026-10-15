package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18438a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final StringBuilder f1174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18439b;

        public a() {
            this(Constants.COLON_SEPARATOR, Constants.ACCEPT_TIME_SEPARATOR_SP);
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f1174a.length() > 0) {
                    this.f1174a.append(this.f18439b);
                }
                StringBuilder sb = this.f1174a;
                sb.append(str);
                sb.append(this.f18438a);
                sb.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f1174a.toString();
        }

        public a(String str, String str2) {
            this.f1174a = new StringBuilder();
            this.f18438a = str;
            this.f18439b = str2;
        }
    }

    public static int a(String str, int i9) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return i9;
    }

    public static int b(String str, int i9) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i9 : i9;
    }

    public static long a(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
            }
        }
        return j;
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}

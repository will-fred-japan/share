package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static j f15223b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15224a;

    public static class a extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15226b;

        public a(String str, String str2) {
            this.f15225a = str;
            this.f15226b = str2;
        }

        @Override // com.huawei.hms.hatool.e0
        public String a() {
            return z.d(this.f15225a, this.f15226b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String b() {
            return z.g(this.f15225a, this.f15226b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String c() {
            return z.j(this.f15225a, this.f15226b);
        }

        @Override // com.huawei.hms.hatool.e0
        public int d() {
            return (z.k(this.f15225a, this.f15226b) ? 4 : 0) | (z.e(this.f15225a, this.f15226b) ? 2 : 0) | (z.h(this.f15225a, this.f15226b) ? 1 : 0);
        }

        @Override // com.huawei.hms.hatool.e0
        public String a(String str) {
            return SHA.sha256Encrypt(str);
        }
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            try {
                if (f15223b == null) {
                    f15223b = new j();
                }
                jVar = f15223b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    public String b(String str, String str2) {
        return i0.b(this.f15224a, str, str2);
    }

    public i c(String str, String str2) {
        return new a(str, str2).a(this.f15224a);
    }

    public String d(String str, String str2) {
        return f1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (!z.f(str, str2)) {
            return new Pair<>("", "");
        }
        String strP = s.c().b().p();
        String strQ = s.c().b().q();
        if (!TextUtils.isEmpty(strP) && !TextUtils.isEmpty(strQ)) {
            return new Pair<>(strP, strQ);
        }
        Pair<String, String> pairE = x0.e(this.f15224a);
        s.c().b().k((String) pairE.first);
        s.c().b().l((String) pairE.second);
        return pairE;
    }

    public String f(String str, String str2) {
        return f1.a(str, str2);
    }

    public String a(String str, String str2) {
        return i0.a(this.f15224a, str, str2);
    }

    public String a(boolean z8) {
        if (!z8) {
            return "";
        }
        String strE = q0.e();
        if (TextUtils.isEmpty(strE)) {
            strE = d.a(this.f15224a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(strE)) {
                strE = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                d.b(this.f15224a, "global_v2", "uuid", strE);
            }
            q0.h(strE);
        }
        return strE;
    }

    public void a(Context context) {
        if (this.f15224a == null) {
            this.f15224a = context;
        }
    }
}

package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: classes.dex */
public class m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static m1 f15264b = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f15265a = new a();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f15268c = 0;

        public a() {
        }

        public void a(long j) {
            m1.this.f15265a.f15268c = j;
        }

        public void b(String str) {
            m1.this.f15265a.f15266a = str;
        }

        public void a(String str) {
            m1.this.f15265a.f15267b = str;
        }
    }

    public static m1 d() {
        return f15264b;
    }

    public long b() {
        return this.f15265a.f15268c;
    }

    public String c() {
        return this.f15265a.f15266a;
    }

    public String a() {
        return this.f15265a.f15267b;
    }

    public void a(String str, String str2) {
        long jB = b();
        String strC = w0.c(str, str2);
        if (strC == null || strC.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (jB == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
            String strA = h0.a(strC, strGenerateSecureRandomStr);
            this.f15265a.a(jCurrentTimeMillis);
            this.f15265a.b(strGenerateSecureRandomStr);
            this.f15265a.a(strA);
            return;
        }
        if (System.currentTimeMillis() - jB > com.heytap.mcssdk.constant.a.f14246g) {
            String strGenerateSecureRandomStr2 = EncryptUtil.generateSecureRandomStr(16);
            String strA2 = h0.a(strC, strGenerateSecureRandomStr2);
            this.f15265a.a(jB);
            this.f15265a.b(strGenerateSecureRandomStr2);
            this.f15265a.a(strA2);
        }
    }
}

package cn.jiguang.aw;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SecureRandom f9560a = new SecureRandom();

    public static int a(int i9) {
        if (i9 > 0) {
            return f9560a.nextInt(i9);
        }
        throw new IllegalArgumentException("bound must be positive");
    }

    public static byte[] b(int i9) {
        byte[] bArr = new byte[i9];
        f9560a.nextBytes(bArr);
        return bArr;
    }
}

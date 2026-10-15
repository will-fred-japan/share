package cn.jiguang.commons.a;

import java.lang.ref.WeakReference;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class jk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<WeakReference<MessageDigest>> f10302a = new jl();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<WeakReference<MessageDigest>> f10303b = new jm();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<WeakReference<MessageDigest>> f10304c = new jn();

    public static String a(String str) {
        byte[] bArrC = c(str);
        return bArrC != null ? a(bArrC, false, (char) 0) : "";
    }

    public static String b(byte[] bArr) {
        byte[] bArrA = a(bArr);
        return bArrA != null ? a(bArrA, false, (char) 0) : "";
    }

    private static byte[] c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(str.getBytes("UTF-8"));
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("md5 encoding error: "), "DigestUtils");
            return null;
        }
    }

    public static String d(byte[] bArr) {
        byte[] bArrC = c(bArr);
        return bArrC != null ? a(bArrC, false, (char) 0) : "";
    }

    public static byte[] e(byte[] bArr) {
        MessageDigest messageDigestB;
        if (bArr == null || (messageDigestB = b(d.f9866h)) == null) {
            return null;
        }
        return messageDigestB.digest(bArr);
    }

    public static String f(byte[] bArr) {
        byte[] bArrE = e(bArr);
        return bArrE != null ? a(bArrE, false, (char) 0) : "";
    }

    public static String a(byte[] bArr, char c5) {
        return a(bArr, true, ':');
    }

    private static MessageDigest b(String str) {
        MessageDigest messageDigest;
        ThreadLocal<WeakReference<MessageDigest>> threadLocal;
        WeakReference<MessageDigest> weakReference;
        try {
            String str2 = d.f9864f;
            if (str2.equals(str)) {
                threadLocal = f10302a;
                WeakReference<MessageDigest> weakReference2 = threadLocal.get();
                messageDigest = weakReference2 != null ? weakReference2.get() : null;
                if (messageDigest == null) {
                    messageDigest = MessageDigest.getInstance(str2);
                    weakReference = new WeakReference<>(messageDigest);
                    threadLocal.set(weakReference);
                }
            } else {
                String str3 = d.f9865g;
                if (str3.equals(str)) {
                    ThreadLocal<WeakReference<MessageDigest>> threadLocal2 = f10303b;
                    WeakReference<MessageDigest> weakReference3 = threadLocal2.get();
                    messageDigest = weakReference3 != null ? weakReference3.get() : null;
                    if (messageDigest == null) {
                        MessageDigest messageDigest2 = MessageDigest.getInstance(str3);
                        threadLocal2.set(new WeakReference<>(messageDigest2));
                        messageDigest = messageDigest2;
                    }
                } else {
                    String str4 = d.f9866h;
                    if (str4.equals(str)) {
                        threadLocal = f10304c;
                        WeakReference<MessageDigest> weakReference4 = threadLocal.get();
                        messageDigest = weakReference4 != null ? weakReference4.get() : null;
                        if (messageDigest == null) {
                            messageDigest = MessageDigest.getInstance(str4);
                            weakReference = new WeakReference<>(messageDigest);
                            threadLocal.set(weakReference);
                        }
                    } else {
                        messageDigest = null;
                    }
                }
            }
            if (messageDigest != null) {
                messageDigest.reset();
            }
            return messageDigest;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("failed to get digest: "), "DigestUtils");
            return null;
        }
    }

    private static String a(byte[] bArr, boolean z8, char c5) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        boolean z9 = c5 != 0;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(z9 ? (length * 3) - 1 : length * 2);
        for (int i9 = 0; i9 < bArr.length; i9++) {
            int i10 = bArr[i9] & 255;
            if (i10 < 16) {
                sb.append('0');
            }
            String hexString = Integer.toHexString(i10);
            if (z8) {
                hexString = hexString.toUpperCase();
            }
            sb.append(hexString);
            if (z9 && i9 < bArr.length - 1) {
                sb.append(c5);
            }
        }
        return sb.toString();
    }

    public static byte[] a(byte[] bArr) {
        MessageDigest messageDigestB;
        if (bArr == null || (messageDigestB = b(d.f9864f)) == null) {
            return null;
        }
        return messageDigestB.digest(bArr);
    }

    public static byte[] c(byte[] bArr) {
        MessageDigest messageDigestB;
        if (bArr == null || (messageDigestB = b(d.f9865g)) == null) {
            return null;
        }
        return messageDigestB.digest(bArr);
    }
}

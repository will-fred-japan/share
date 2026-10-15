package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes.dex */
public class ThreadLocalCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BYTES_CACH_INIT_SIZE = 1024;
    public static final int BYTES_CACH_INIT_SIZE_EXP = 10;
    public static final int BYTES_CACH_MAX_SIZE = 131072;
    public static final int BYTES_CACH_MAX_SIZE_EXP = 17;
    public static final int CHARS_CACH_INIT_SIZE = 1024;
    public static final int CHARS_CACH_INIT_SIZE_EXP = 10;
    public static final int CHARS_CACH_MAX_SIZE = 131072;
    public static final int CHARS_CACH_MAX_SIZE_EXP = 17;
    private static final ThreadLocal<SoftReference<char[]>> charsBufLocal = new ThreadLocal<>();
    private static final ThreadLocal<CharsetDecoder> decoderLocal = new ThreadLocal<>();
    private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = new ThreadLocal<>();

    private static char[] allocate(int i9) {
        if (i9 > 131072) {
            return new char[i9];
        }
        char[] cArr = new char[getAllocateLengthExp(10, 17, i9)];
        charsBufLocal.set(new SoftReference<>(cArr));
        return cArr;
    }

    private static byte[] allocateBytes(int i9) {
        if (i9 > 131072) {
            return new byte[i9];
        }
        byte[] bArr = new byte[getAllocateLengthExp(10, 17, i9)];
        bytesBufLocal.set(new SoftReference<>(bArr));
        return bArr;
    }

    public static void clearBytes() {
        bytesBufLocal.set(null);
    }

    public static void clearChars() {
        charsBufLocal.set(null);
    }

    private static int getAllocateLengthExp(int i9, int i10, int i11) {
        return (i11 >>> i9) <= 0 ? 1 << i9 : 1 << (32 - Integer.numberOfLeadingZeros(i11 - 1));
    }

    public static byte[] getBytes(int i9) {
        SoftReference<byte[]> softReference = bytesBufLocal.get();
        if (softReference == null) {
            return allocateBytes(i9);
        }
        byte[] bArr = softReference.get();
        if (bArr == null) {
            return allocateBytes(i9);
        }
        return bArr.length < i9 ? allocateBytes(i9) : bArr;
    }

    public static char[] getChars(int i9) {
        SoftReference<char[]> softReference = charsBufLocal.get();
        if (softReference == null) {
            return allocate(i9);
        }
        char[] cArr = softReference.get();
        if (cArr == null) {
            return allocate(i9);
        }
        return cArr.length < i9 ? allocate(i9) : cArr;
    }

    public static CharsetDecoder getUTF8Decoder() {
        ThreadLocal<CharsetDecoder> threadLocal = decoderLocal;
        CharsetDecoder charsetDecoder = threadLocal.get();
        if (charsetDecoder != null) {
            return charsetDecoder;
        }
        UTF8Decoder uTF8Decoder = new UTF8Decoder();
        threadLocal.set(uTF8Decoder);
        return uTF8Decoder;
    }
}

package com.huawei.secure.android.common.encrypt.utils;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15797a = "IOUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f15798b = 4096;

    public static void a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void a(Reader reader) {
        a((Closeable) reader);
    }

    public static void a(Writer writer) {
        a((Closeable) writer);
    }

    public static void a(InputStream inputStream) {
        a((Closeable) inputStream);
    }

    public static void a(OutputStream outputStream) {
        a((Closeable) outputStream);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                b.b(f15797a, "closeSecure IOException");
            }
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, new byte[4096]);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int i9 = inputStream.read(bArr);
            if (-1 == i9) {
                return j;
            }
            outputStream.write(bArr, 0, i9);
            j += (long) i9;
        }
    }

    public static InputStream a(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public static void a(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        b.b(f15797a, "deleteSecure exception");
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(new File(str));
    }
}

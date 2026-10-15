package com.huawei.secure.android.common.util;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
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
public class IOUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15947a = "IOUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f15948b = 4096;

    public static void close(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void closeSecure(Reader reader) {
        closeSecure((Closeable) reader);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream, new byte[4096]);
    }

    public static void deleteSecure(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Log.e(f15947a, "deleteSecure exception");
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream toInputStream(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public static void closeSecure(Writer writer) {
        closeSecure((Closeable) writer);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
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

    public static void closeSecure(InputStream inputStream) {
        closeSecure((Closeable) inputStream);
    }

    public static void closeSecure(OutputStream outputStream) {
        closeSecure((Closeable) outputStream);
    }

    public static void deleteSecure(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        deleteSecure(new File(str));
    }

    public static void closeSecure(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e(f15947a, "closeSecure IOException");
            }
        }
    }
}

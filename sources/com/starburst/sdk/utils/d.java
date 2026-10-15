package com.starburst.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static String a(Context context) {
        File externalFilesDir;
        if (context == null) {
            return "";
        }
        if (!Environment.getExternalStorageState().equals("mounted") || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
            return context.getFilesDir().getAbsolutePath() + "/StarBurstSdk";
        }
        return externalFilesDir.getAbsolutePath() + "/StarBurstSdk";
    }

    public static boolean b(String str) {
        String strConcat;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            boolean z8 = file.exists() && file.isFile();
            if (str.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath())) {
                String externalStorageState = Environment.getExternalStorageState();
                strConcat = (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) ? "文件路径为空" : "外部存储未挂载: ".concat(externalStorageState);
            }
            return z8;
        }
        j.f("FileUtils", strConcat);
        return false;
    }

    public static void c(String str, byte[] bArr) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create parent directories: " + parentFile.getAbsolutePath());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}

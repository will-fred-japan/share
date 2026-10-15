package com.xiaomi.push;

import android.text.TextUtils;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f18444a = {"jpg", "png", "bmp", "gif", "webp"};

    public static void a(File file, File file2) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file, false));
                try {
                    a(zipOutputStream2, file2, null, null);
                    a(zipOutputStream2);
                } catch (FileNotFoundException unused) {
                    zipOutputStream = zipOutputStream2;
                    a(zipOutputStream);
                } catch (IOException e9) {
                    e = e9;
                    zipOutputStream = zipOutputStream2;
                    com.xiaomi.channel.commonutils.logger.c.m9a("zip file failure + " + e.getMessage());
                    a(zipOutputStream);
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = zipOutputStream2;
                    a(zipOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused2) {
        } catch (IOException e10) {
            e = e10;
        }
    }

    public static void b(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i9 = fileInputStream2.read(bArr);
                        if (i9 < 0) {
                            fileInputStream2.close();
                            fileOutputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i9);
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) throws Throwable {
        File[] fileArrListFiles;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                if (file.isDirectory()) {
                    if (fileFilter != null) {
                        fileArrListFiles = file.listFiles(fileFilter);
                    } else {
                        fileArrListFiles = file.listFiles();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    String str3 = File.separator;
                    sb.append(str3);
                    zipOutputStream.putNextEntry(new ZipEntry(sb.toString()));
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str + str3;
                    }
                    for (int i9 = 0; i9 < fileArrListFiles.length; i9++) {
                        a(zipOutputStream, fileArrListFiles[i9], str2 + fileArrListFiles[i9].getName(), null);
                    }
                    File[] fileArrListFiles2 = file.listFiles(new FileFilter() { // from class: com.xiaomi.push.y.1
                        @Override // java.io.FileFilter
                        public boolean accept(File file2) {
                            return file2.isDirectory();
                        }
                    });
                    if (fileArrListFiles2 != null) {
                        for (File file2 : fileArrListFiles2) {
                            a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                        }
                    }
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        zipOutputStream.putNextEntry(new ZipEntry(str));
                    } else {
                        zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + ".txt"));
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i10 = fileInputStream2.read(bArr);
                            if (i10 == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, i10);
                            }
                        }
                        fileInputStream = fileInputStream2;
                    } catch (IOException e9) {
                        e = e9;
                        fileInputStream = fileInputStream2;
                        com.xiaomi.channel.commonutils.logger.c.d("zipFiction failed with exception:" + e.toString());
                        a((Closeable) fileInputStream);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        a((Closeable) fileInputStream);
                        throw th;
                    }
                }
                a((Closeable) fileInputStream);
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String a(File file) throws Throwable {
        InputStreamReader inputStreamReader;
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            try {
                try {
                    char[] cArr = new char[OpusCodecConfig.APPLICATION_VOIP];
                    while (true) {
                        int i9 = inputStreamReader.read(cArr);
                        if (i9 != -1) {
                            stringWriter.write(cArr, 0, i9);
                        } else {
                            String string = stringWriter.toString();
                            a(inputStreamReader);
                            a(stringWriter);
                            return string;
                        }
                        th = th;
                        inputStreamReader2 = inputStreamReader;
                        a(inputStreamReader2);
                        a(stringWriter);
                        throw th;
                    }
                } catch (IOException e9) {
                    e = e9;
                    com.xiaomi.channel.commonutils.logger.c.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(inputStreamReader);
                    a(stringWriter);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStreamReader2 = inputStreamReader;
            }
        } catch (IOException e10) {
            e = e10;
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(File file, String str) throws Throwable {
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.c.c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter2.write(str);
                    a(bufferedWriter2);
                } catch (IOException e9) {
                    e = e9;
                    bufferedWriter = bufferedWriter2;
                    com.xiaomi.channel.commonutils.logger.c.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    a(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e = e10;
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int i9 = inputStream.read(bArr, 0, 8192);
                    if (i9 > 0) {
                        byteArrayOutputStream.write(bArr, 0, i9);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a((Closeable) inputStream);
                        a(byteArrayOutputStream);
                        return byteArray;
                    }
                } catch (Exception e9) {
                    e9.printStackTrace();
                    a((Closeable) inputStream);
                    a(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th) {
                a((Closeable) inputStream);
                a(byteArrayOutputStream);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m844a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }
}

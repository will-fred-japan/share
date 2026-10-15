package com.huawei.secure.android.common.zip;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.secure.android.common.zip.config.ZipConfig;
import com.huawei.secure.android.common.zip.exception.UnZipException;
import com.huawei.secure.android.common.zip.exception.ZipParamException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class ZipUtil2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16000a = "ZipUtil2";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f16001b = 4096;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f16002c = {"\\..", "/..", "..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    private static void a(long j, long j8) throws UnZipException {
        if (j8 > j) {
            throw new UnZipException("over than TopSizeThreshold");
        }
    }

    private static List<File> b(ZipConfig zipConfig) throws IOException {
        ArrayList arrayList = new ArrayList();
        ZipFile zipFileA = a(zipConfig.isGbkZipFile(), new File(zipConfig.getZipFile()));
        try {
            a(zipConfig.getTopSizeThreshold(), zipFileA.size());
            Enumeration<? extends ZipEntry> enumerationEntries = zipFileA.entries();
            long j = 0;
            while (enumerationEntries.hasMoreElements()) {
                try {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    a(zipEntryNextElement);
                    a(zipEntryNextElement, zipConfig);
                    File file = new File(zipConfig.getTargetDir(), b(b(zipEntryNextElement)));
                    arrayList.add(file);
                    a(zipConfig.getFileNumThreshold(), arrayList.size());
                    if (zipConfig.isLoadDisk()) {
                        a(zipEntryNextElement, file);
                    }
                    if (!file.isDirectory()) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFileA.getInputStream(zipEntryNextElement));
                        try {
                            FileOutputStream fileOutputStream = zipConfig.isLoadDisk() ? new FileOutputStream(file) : null;
                            try {
                                BufferedOutputStream bufferedOutputStream = zipConfig.isLoadDisk() ? new BufferedOutputStream(fileOutputStream) : null;
                                try {
                                    byte[] bArr = new byte[4096];
                                    while (true) {
                                        int i9 = bufferedInputStream.read(bArr);
                                        if (i9 == -1) {
                                            break;
                                        }
                                        j += (long) i9;
                                        a(zipConfig.getTopSizeThreshold(), j);
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.write(bArr, 0, i9);
                                        }
                                        try {
                                            throw th;
                                        } catch (Throwable th) {
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    bufferedInputStream.close();
                                } catch (Throwable th3) {
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (Throwable th5) {
                                                th3.addSuppressed(th5);
                                            }
                                        }
                                        throw th4;
                                    }
                                }
                            } catch (Throwable th6) {
                                throw th6;
                            }
                        } catch (Throwable th7) {
                            try {
                                throw th7;
                            } catch (Throwable th8) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable th9) {
                                    th7.addSuppressed(th9);
                                }
                                throw th8;
                            }
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    throw new UnZipException("open zip entry error.");
                }
            }
            zipFileA.close();
            return arrayList;
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                if (zipFileA != null) {
                    try {
                        zipFileA.close();
                    } catch (Throwable th12) {
                        th10.addSuppressed(th12);
                    }
                }
                throw th11;
            }
        }
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f16000a, "isContainInvalidStr: name is null");
            return false;
        }
        for (String str2 : f16002c) {
            if (str.toUpperCase(Locale.ROOT).contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String getFileNameLowerSuffix(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        return iLastIndexOf < 0 ? "" : str.substring(iLastIndexOf + 1).toLowerCase(Locale.ROOT);
    }

    public static List<File> unZipOrCheck(ZipConfig zipConfig) throws ZipParamException {
        a(zipConfig);
        return b(zipConfig);
    }

    private static void a(int i9, int i10) throws UnZipException {
        if (i10 > i9) {
            throw new UnZipException("over than FileNumThreshold");
        }
    }

    private static void a(ZipEntry zipEntry, File file) throws IOException {
        if (zipEntry.isDirectory()) {
            if (file.mkdirs()) {
                return;
            }
            throw new IOException("mkdir dir error, path is " + file.getName());
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("mkdir dir error, path is " + file.getName());
        }
        if (file.createNewFile()) {
            return;
        }
        throw new IOException("create file error, name is " + file.getName());
    }

    private static void a(ZipEntry zipEntry, ZipConfig zipConfig) throws UnZipException {
        if (zipEntry.isDirectory()) {
            return;
        }
        if (zipConfig.getWhiteListSuffix() == null && zipConfig.getBlackListSuffix() == null) {
            return;
        }
        String fileNameLowerSuffix = getFileNameLowerSuffix(zipEntry.getName());
        if (zipConfig.getWhiteListSuffix() != null) {
            if (!Arrays.asList(zipConfig.getWhiteListSuffix()).contains(fileNameLowerSuffix)) {
                throw new UnZipException("entry name suffix is not in whitelist suffix");
            }
        } else if (Arrays.asList(zipConfig.getBlackListSuffix()).contains(fileNameLowerSuffix)) {
            throw new UnZipException("entry name suffix is in blacklist suffix");
        }
    }

    private static void a(ZipEntry zipEntry) throws UnZipException {
        if (!TextUtils.isEmpty(zipEntry.getName())) {
            String strB = b(zipEntry);
            if (c(strB)) {
                throw new UnZipException("entry is a invalid path: " + a(strB));
            }
            return;
        }
        throw new UnZipException("entry name is null");
    }

    private static ZipFile a(boolean z8, File file) {
        if (!z8) {
            return new ZipFile(file, StandardCharsets.UTF_8);
        }
        return new ZipFile(file, Charset.forName("GBK"));
    }

    private static void a(ZipConfig zipConfig) throws ZipParamException {
        if (zipConfig != null) {
            if (!TextUtils.isEmpty(zipConfig.getZipFile())) {
                if (!c(zipConfig.getZipFile())) {
                    if (zipConfig.isLoadDisk() && TextUtils.isEmpty(zipConfig.getTargetDir())) {
                        throw new ZipParamException("zipConfig isLoadDisk param is true, but targetDir is null.");
                    }
                    if (zipConfig.isLoadDisk() && c(zipConfig.getTargetDir())) {
                        throw new ZipParamException("zipConfig targetDir path is danger.");
                    }
                    return;
                }
                throw new ZipParamException("zipConfig zipFile path is danger.");
            }
            throw new ZipParamException("zipConfig zipFile is null.");
        }
        throw new ZipParamException("zipConfig is null.");
    }

    private static String b(ZipEntry zipEntry) {
        return Normalizer.normalize(zipEntry.getName(), Normalizer.Form.NFKC);
    }

    private static String a(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(iLastIndexOf + 1);
    }

    private static String b(String str) {
        return str.replaceAll("\\\\", "/");
    }
}

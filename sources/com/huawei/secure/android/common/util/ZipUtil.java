package com.huawei.secure.android.common.util;

import W5.f;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ZipUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15971a = "ZipUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f15972b = 104857600;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f15973c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f15974d = 6000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f15975e = 4096;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f15976f = {"\\..", "/..", "..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    private static void a(boolean z8, File file) {
        if (z8 && file.exists() && file.isFile()) {
            f(file);
        }
    }

    @SuppressLint({"NewApi"})
    private static ZipFile b(boolean z8, File file) {
        if (!z8) {
            return new ZipFile(file);
        }
        LogsUtil.i(f15971a, "not a utf8 zip file, use gbk open zip file : " + file);
        return new ZipFile(file, Charset.forName("GBK"));
    }

    private static boolean c(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!b(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(f15971a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(str);
    }

    private static String e(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(iLastIndexOf + 1);
    }

    private static String f(String str) {
        return str.replaceAll("\\\\", "/");
    }

    private static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f15971a, "isContainInvalidStr: name is null");
            return false;
        }
        for (String str2 : f15976f) {
            if (str.toUpperCase(Locale.ROOT).contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static String h(String str) {
        String str2 = File.separator;
        return (!str.endsWith(str2) || str.length() <= str2.length()) ? str : str.substring(0, str.length() - str2.length());
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z8) {
        return unZip(str, str2, 104857600L, 100, z8);
    }

    public static List<File> unZipNew(String str, String str2, boolean z8) {
        return unZipNew(str, str2, 104857600L, 100, z8);
    }

    public static List<File> unZipWithFilter(String str, String str2, boolean z8, FilenameFilter filenameFilter) {
        return unZipWithFilter(str, str2, 104857600L, 100, z8, filenameFilter, 6000);
    }

    private static void d(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(f15971a, "delete file error");
    }

    private static void f(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            d(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                d(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                f(file2);
            }
            d(file);
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, long j, int i9, boolean z8) throws Throwable {
        Throwable th;
        ZipInputStream zipInputStream;
        IOException iOException;
        boolean zA = a(str, str2, j, i9, (FilenameFilter) null, i9);
        boolean z9 = false;
        if (!zA) {
            return false;
        }
        String strH = h(str2);
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream2));
                long jA = 0;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            z9 = true;
                            break;
                        }
                        String strReplaceAll = nextEntry.getName().replaceAll("\\\\", "/");
                        if (!a(strReplaceAll)) {
                            break;
                        }
                        File file = new File(strH, strReplaceAll);
                        if (z8 || !file.exists() || !file.isFile()) {
                            a(z8, file);
                            if (!a(nextEntry, file, arrayList)) {
                                a(file);
                                jA = a(file, zipInputStream, jA, j, arrayList);
                                zipInputStream.closeEntry();
                                if (jA < 0) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e9) {
                        iOException = e9;
                        fileInputStream = fileInputStream2;
                        try {
                            LogsUtil.e(f15971a, "Unzip IOException : " + iOException.getMessage());
                            a(fileInputStream, zipInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            a(fileInputStream, zipInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream, zipInputStream);
                        throw th;
                    }
                }
                a(fileInputStream2, zipInputStream);
            } catch (IOException e10) {
                iOException = e10;
                zipInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                zipInputStream = null;
            }
        } catch (IOException e11) {
            iOException = e11;
            zipInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            zipInputStream = null;
        }
        if (!z9) {
            a(arrayList);
        }
        return z9;
    }

    public static List<File> unZipNew(String str, String str2, long j, int i9, boolean z8) {
        return unZipWithFilter(str, str2, j, i9, z8, null, i9);
    }

    public static List<File> unZipWithFilter(String str, String str2, long j, int i9, boolean z8, FilenameFilter filenameFilter, int i10) {
        if (!a(str, str2, j, i9, filenameFilter, i10)) {
            return null;
        }
        String str3 = File.separator;
        String strSubstring = (!str2.endsWith(str3) || str2.length() <= str3.length()) ? str2 : str2.substring(0, str2.length() - str3.length());
        File fileD = d(str);
        File fileD2 = d(strSubstring);
        if (fileD == null || fileD2 == null) {
            return null;
        }
        return a(fileD, fileD2, j, z8, false, filenameFilter);
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return;
        }
        e(parentFile);
    }

    private static void b(String str) {
        if (TextUtils.isEmpty(str) || !g(str)) {
            return;
        }
        Log.e(f15971a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static void e(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(f15971a, "mkdirs error , files exists or IOException.");
    }

    private static boolean a(ZipEntry zipEntry, File file, List<File> list) {
        if (!zipEntry.isDirectory()) {
            return false;
        }
        e(file);
        list.add(file);
        return true;
    }

    private static File c(String str) {
        b(str);
        return new File(str);
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isDirectory();
        }
        return file.mkdirs();
    }

    private static boolean a(String str) {
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKC);
        if (!g(strNormalize)) {
            return true;
        }
        f.n(new StringBuilder("zipPath is a invalid path: "), e(strNormalize), f15971a);
        return false;
    }

    private static long a(File file, ZipInputStream zipInputStream, long j, long j8, List<File> list) throws Throwable {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        IOException iOException;
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[4096];
        long j9 = -1;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                long j10 = j;
                while (true) {
                    try {
                        int i9 = zipInputStream.read(bArr, 0, 4096);
                        if (i9 == -1) {
                            break;
                        }
                        j10 += (long) i9;
                        if (j10 > j8) {
                            Log.e(f15971a, "unzip  over than top size");
                            j10 = -1;
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, i9);
                    } catch (IOException e9) {
                        iOException = e9;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            LogsUtil.e(f15971a, "Unzip IOException : " + iOException.getMessage());
                            fileOutputStream = fileOutputStream2;
                        } catch (Throwable th2) {
                            th = th2;
                            IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                            IOUtil.closeSecure((OutputStream) fileOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream2 = fileOutputStream;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                        IOUtil.closeSecure((OutputStream) fileOutputStream2);
                        throw th;
                    }
                }
                list.add(file);
                bufferedOutputStream.flush();
                j9 = j10;
            } catch (IOException e10) {
                iOException = e10;
                bufferedOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
            }
        } catch (IOException e11) {
            iOException = e11;
            bufferedOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
        }
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
        return j9;
    }

    private static String a(ZipEntry zipEntry) {
        return Normalizer.normalize(zipEntry.getName(), Normalizer.Form.NFKC);
    }

    private static int a(ZipEntry zipEntry, List<File> list, File file, boolean z8, FilenameFilter filenameFilter) {
        if (TextUtils.isEmpty(zipEntry.getName())) {
            return 1;
        }
        String strA = a(zipEntry);
        if (g(strA)) {
            f.n(new StringBuilder("zipPath is a invalid path: "), e(strA), f15971a);
            return -1;
        }
        String strF = f(strA);
        if (filenameFilter != null && !filenameFilter.accept(file, strF)) {
            return 1;
        }
        File file2 = new File(file, strF);
        if (!z8 && file2.exists() && file2.isFile()) {
            return 1;
        }
        if (z8 && file2.exists() && file2.isFile()) {
            f(file2);
        }
        list.add(file2);
        return 0;
    }

    private static long a(ZipEntry zipEntry, File file, long j, long j8, ZipFile zipFile) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File file2 = new File(file, f(a(zipEntry)));
        if (zipEntry.isDirectory()) {
            if (b(file2)) {
                return j;
            }
            return 1L;
        }
        if (!c(file2)) {
            return 1L;
        }
        FileOutputStream fileOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i9 = bufferedInputStream.read(bArr);
                            if (i9 == -1) {
                                IOUtil.closeSecure((InputStream) bufferedInputStream);
                                IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                return j;
                            }
                            j += (long) i9;
                            if (j > j8) {
                                Log.e(f15971a, "unzipFileNew: over than top size");
                                IOUtil.closeSecure((InputStream) bufferedInputStream);
                                IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                return -1L;
                            }
                            bufferedOutputStream.write(bArr, 0, i9);
                        }
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                        IOUtil.closeSecure((OutputStream) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    bufferedOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
    }

    private static void a(boolean z8, List<File> list) {
        if (z8) {
            return;
        }
        a(list);
        list.clear();
    }

    private static List<File> a(File file, File file2, long j, boolean z8, boolean z9, FilenameFilter filenameFilter) throws Throwable {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        ZipFile zipFile = null;
        try {
            ZipFile zipFileB = b(z9, file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFileB.entries();
                long jA = 0;
                while (enumerationEntries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        int iA = a(zipEntryNextElement, arrayList, file2, z8, filenameFilter);
                        if (iA != -1) {
                            if (iA != 1) {
                                jA = a(zipEntryNextElement, file2, jA, j, zipFileB);
                                if (jA == 1) {
                                    IOUtil.closeSecure(zipFileB);
                                    a(false, (List<File>) arrayList);
                                    return null;
                                }
                                if (jA == -1) {
                                }
                            }
                        }
                        IOUtil.closeSecure(zipFileB);
                        a(z10, arrayList);
                        return arrayList;
                    } catch (IllegalArgumentException e9) {
                        LogsUtil.i(f15971a, "not a utf8 zip file, IllegalArgumentException : " + e9.getMessage());
                        List<File> listA = a(file, file2, j, z8, true, filenameFilter);
                        IOUtil.closeSecure(zipFileB);
                        a(true, (List<File>) arrayList);
                        return listA;
                    }
                }
                z10 = true;
                IOUtil.closeSecure(zipFileB);
                a(z10, arrayList);
                return arrayList;
            } catch (IOException e10) {
                e = e10;
                zipFile = zipFileB;
                try {
                    Log.e(f15971a, "unzip new IOException : " + e.getMessage());
                    IOUtil.closeSecure(zipFile);
                    a(false, (List<File>) arrayList);
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    IOUtil.closeSecure(zipFile);
                    a(z10, arrayList);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                zipFile = zipFileB;
                IOUtil.closeSecure(zipFile);
                a(z10, arrayList);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
        } catch (Throwable th3) {
            th = th3;
            z10 = true;
        }
    }

    private static boolean a(String str, File file, long j, int i9, boolean z8, FilenameFilter filenameFilter, int i10) throws Throwable {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        boolean zA = false;
        try {
            try {
                try {
                    if (!z8) {
                        zipFile = new ZipFile(str);
                    } else {
                        LogsUtil.i(f15971a, "not a utf8 zip file, use gbk open zip file : " + str);
                        zipFile = new ZipFile(str, Charset.forName("GBK"));
                    }
                    ZipFile zipFile3 = zipFile;
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile3.entries();
                        long j8 = 0;
                        int i11 = 0;
                        int i12 = 0;
                        while (true) {
                            if (!enumerationEntries.hasMoreElements()) {
                                zA = true;
                                break;
                            }
                            try {
                                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                                long size = zipEntryNextElement.getSize();
                                String name = zipEntryNextElement.getName();
                                if (filenameFilter == null || filenameFilter.accept(file, name)) {
                                    j8 += size;
                                    i12++;
                                }
                                i11++;
                                if (!g(name) && i11 < i10 && i12 < i9 && j8 <= j && zipEntryNextElement.getSize() != -1) {
                                }
                                LogsUtil.e(f15971a, "File name is invalid or too many files or too big");
                                break;
                            } catch (IllegalArgumentException e9) {
                                LogsUtil.i(f15971a, "not a utf8 zip file, IllegalArgumentException : " + e9.getMessage());
                                zA = a(str, file, j, i9, true, filenameFilter, i10);
                            }
                        }
                        zipFile3.close();
                    } catch (IOException e10) {
                        e = e10;
                        zipFile2 = zipFile3;
                        LogsUtil.e(f15971a, "not a valid zip file, IOException : " + e.getMessage());
                        if (zipFile2 != null) {
                            zipFile2.close();
                        }
                        return zA;
                    } catch (Throwable th) {
                        th = th;
                        zipFile2 = zipFile3;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException unused) {
                                LogsUtil.e(f15971a, "close zipFile IOException ");
                            }
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
            LogsUtil.e(f15971a, "close zipFile IOException ");
        }
        return zA;
    }

    private static boolean a(String str, String str2, long j, int i9, FilenameFilter filenameFilter, int i10) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !g(str)) {
            if (!TextUtils.isEmpty(str2) && !g(str2)) {
                if (a(str, new File(str2), j, i9, false, filenameFilter, i10)) {
                    return true;
                }
                LogsUtil.e(f15971a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(f15971a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(f15971a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            return true;
        } catch (Exception e9) {
            LogsUtil.e(f15971a, "unzip fail delete file failed" + e9.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, ZipInputStream zipInputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
    }
}

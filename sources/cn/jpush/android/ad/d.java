package cn.jpush.android.ad;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static File a(Context context, String str) {
        File filesDir;
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            return new File(filesDir, str);
        }
        Logger.w("FileUtils", "can't get file :" + str);
        return null;
    }

    public static String b(Context context, String str) {
        try {
            File fileA = a(context, str);
            if (fileA == null) {
                Logger.w("FileUtils", str + " can't be null");
                return "";
            }
            if (fileA.isFile()) {
                fileA.delete();
            }
            if (!fileA.exists()) {
                fileA.mkdirs();
            }
            return fileA.getAbsolutePath() + File.separator;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(Context context, String str) {
        try {
            if (!b.a()) {
                a(context, "rich", 10, (File) null);
                return b(context, "rich" + File.separator + str);
            }
            String absolutePath = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(str);
            sb.append(str2);
            String string = sb.toString();
            File file = new File(string);
            if (!file.exists()) {
                file.mkdirs();
            }
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String d(String str) {
        try {
            return (!TextUtils.isEmpty(str) && b(str)) ? c(str.substring(10)) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String e(Context context, String str) {
        try {
            String str2 = (b.a() ? context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : context.getFilesDir()).getAbsolutePath() + File.separator + str;
            if (new File(str2).exists()) {
                return str2;
            }
            Logger.ww("FileUtils", "Can't find developer picture resource in SDCard.");
            return "";
        } catch (Throwable th) {
            defpackage.f.p("Get developer picture resource failed.", "FileUtils", th);
            return "";
        }
    }

    public static Object a(File file) throws Throwable {
        ObjectInputStream objectInputStream = null;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file));
            try {
                Object object = objectInputStream2.readObject();
                p.a((Closeable) objectInputStream2);
                return object;
            } catch (Throwable th) {
                th = th;
                objectInputStream = objectInputStream2;
                p.a((Closeable) objectInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static String c(File file) {
        byte[] bArrD = d(file);
        if (bArrD == null) {
            return null;
        }
        try {
            return d(new String(bArrD, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static void d(Context context, String str) {
        try {
            e(new File(a(context, "j_in_app_" + str, 0, false)));
        } catch (Throwable th) {
            Logger.ee("FileUtils", "delete file throwable" + th);
        }
    }

    public static String a(Context context, String str, int i9) {
        return a(context, str, i9, true);
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            char[] charArray = str.toCharArray();
            char[] cArr = new char[10];
            if (charArray.length <= 10) {
                return false;
            }
            for (int i9 = 0; i9 < 10; i9++) {
                cArr[i9] = (char) (charArray[i9] ^ 2000);
            }
            return "j-c-o-r-e-".equals(new String(cArr));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                char[] charArray = str.toCharArray();
                for (int i9 = 0; i9 < charArray.length; i9++) {
                    charArray[i9] = (char) (charArray[i9] ^ 2000);
                }
                return new String(charArray);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static byte[] d(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists() && !file.isDirectory()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArrA = p.a((InputStream) fileInputStream);
                    p.a((Closeable) fileInputStream);
                    return bArrA;
                } catch (Throwable unused) {
                    p.a((Closeable) fileInputStream);
                    return null;
                }
            } catch (Throwable unused2) {
                fileInputStream = null;
            }
        }
        return null;
    }

    public static String a(Context context, String str, int i9, boolean z8) {
        String strB;
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            if (b.a()) {
                String absolutePath = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(str);
                sb.append(str2);
                String string = sb.toString();
                File file2 = new File(string);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                strB = string;
                file = file2;
            } else {
                strB = b(context, str + File.separator);
            }
            if (z8) {
                a(context, str, i9, file);
            }
            return strB;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b(String str, String str2) {
        Logger.v("FileUtils", "action:createHtmlFile - filePath:" + str + ", content:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return a(str, str2, false);
    }

    public static String a(String str, boolean z8) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iIndexOf = str.indexOf("?");
        if (iIndexOf > 0) {
            str = str.substring(0, iIndexOf);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
        }
        if (!z8) {
            return str.substring(str.lastIndexOf("/") + 1);
        }
        return "j_in_app_image_" + System.currentTimeMillis();
    }

    private static boolean b(String str, byte[] bArr) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                b(file);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    p.a(fileOutputStream2);
                    return true;
                } catch (Exception e9) {
                    e = e9;
                    fileOutputStream = fileOutputStream2;
                    Logger.w("FileUtils", "save to file exception:" + e + " path = " + str);
                    p.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    p.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(Context context, String str, int i9, File file) {
        File[] fileArrListFiles;
        if (file == null) {
            file = a(context, str);
        }
        if (file != null && file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > i9) {
            Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: cn.jpush.android.ad.d.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(File file2, File file3) {
                    if (file2.lastModified() > file3.lastModified()) {
                        return -1;
                    }
                    return file2.lastModified() < file3.lastModified() ? 1 : 0;
                }
            });
            e(fileArrListFiles[fileArrListFiles.length - 1]);
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Throwable th) {
            defpackage.f.o("FileUtils e:", "FileUtils", th);
            return false;
        }
    }

    private static String e(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(0, "j-c-o-r-e-");
            return c(sb.toString());
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean e(File file) {
        String[] list;
        try {
            if (!file.exists()) {
                return false;
            }
            if (!file.isFile() && (list = file.list()) != null) {
                for (String str : list) {
                    File file2 = new File(file, str);
                    if (file2.isDirectory()) {
                        e(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            return file.delete();
        } catch (Exception unused) {
            Logger.e("FileUtils", "Delete dir error");
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        return a(str, str2, true);
    }

    public static boolean a(String str, String str2, boolean z8) {
        if (z8) {
            try {
                str2 = e(str2);
            } catch (Exception e9) {
                Logger.w("FileUtils", "getBytes exception:" + e9);
                return false;
            }
        }
        return b(str, str2 != null ? str2.getBytes("UTF-8") : null);
    }

    public static boolean a(String str, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return b(str, bArr);
    }
}

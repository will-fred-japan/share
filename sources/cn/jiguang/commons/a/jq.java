package cn.jiguang.commons.a;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class jq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f10318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f10319b = new Object();

    public static String a() {
        String str;
        if (f10318a != null) {
            return f10318a;
        }
        synchronized (f10319b) {
            try {
                if (f10318a == null) {
                    f10318a = c();
                }
                str = f10318a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private static File b(File file) {
        if (file == null) {
            return null;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return null;
            }
            return "0".equals(parentFile.getName()) ? parentFile : b(parentFile);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c() {
        try {
            String strB = b();
            if (TextUtils.isEmpty(strB)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strB);
            String str = File.separator;
            sb.append(str);
            sb.append("Android");
            sb.append(str);
            sb.append("data");
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean d(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && !e(file) && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!d(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String e(String str) {
        FileInputStream fileInputStream;
        if (!d(str)) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8192];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i9 = fileInputStream.read(bArr);
                    if (i9 == -1) {
                        String strB = jk.b(byteArrayOutputStream.toByteArray());
                        jv.a(fileInputStream);
                        return strB;
                    }
                    byteArrayOutputStream.write(bArr, 0, i9);
                }
            } catch (Throwable unused) {
                jv.a(fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    private static File f(String str) {
        File filesDir = jg.a().getFilesDir();
        if (filesDir != null) {
            return new File(filesDir, str);
        }
        return null;
    }

    private static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i9 = 0; i9 < charArray.length; i9++) {
            charArray[i9] = (char) (charArray[i9] ^ 2000);
        }
        return new String(charArray);
    }

    public static String a(int i9) {
        return e.f9923a + (i9 + 4567) + ".cache";
    }

    private static String b() {
        File externalFilesDir;
        File fileB;
        try {
            Context contextA = jg.a();
            return (contextA == null || (externalFilesDir = contextA.getExternalFilesDir(null)) == null || (fileB = b(externalFilesDir)) == null) ? "/storage/emulated/0" : fileB.getAbsolutePath();
        } catch (Throwable unused) {
            return "/storage/emulated/0";
        }
    }

    public static JSONObject c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strA = a(f(str));
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return new JSONObject(strA.trim());
        } catch (Throwable th) {
            StringBuilder sbI = defpackage.f.i("Cannot build ", str, " into JSONObject, give up read: ");
            sbI.append(th.getMessage());
            ee.a("FileUtils", sbI.toString());
            return null;
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.length() > 0;
    }

    private static boolean e(File file) {
        if (file != null && file.exists()) {
            try {
                return ((Boolean) Class.forName("java.nio.file.Files").getMethod("isSymbolicLink", Path.class).invoke(null, file.getClass().getMethod("toPath", new Class[0]).invoke(file, new Object[0]))).booleanValue();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String a(File file) {
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                long length = randomAccessFile.length();
                if (length == 0) {
                    jv.a(randomAccessFile);
                    return "";
                }
                if (length > 655360) {
                    StringBuilder sb = new StringBuilder();
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i9 = randomAccessFile.read(bArr);
                        if (i9 == -1) {
                            String strG = g(sb.toString());
                            jv.a(randomAccessFile);
                            return strG;
                        }
                        sb.append(new String(bArr, 0, i9, "UTF-8"));
                    }
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int iMin = (int) Math.min(Math.max(4096L, randomAccessFile.length() / 4), 65536L);
                    byte[] bArr2 = new byte[iMin];
                    while (true) {
                        int i10 = randomAccessFile.read(bArr2, 0, iMin);
                        if (i10 == -1) {
                            String strG2 = g(new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
                            jv.a(randomAccessFile);
                            return strG2;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i10);
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    ee.d("FileUtils", "Read failed: " + th.getMessage());
                    return null;
                } finally {
                    jv.a(randomAccessFile);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static String b(String str) {
        return a(f(str));
    }

    public static void a(String str) {
        d(f(str));
    }

    public static void b(String str, String str2) {
        FileInputStream fileInputStream;
        try {
            File fileF = f(str);
            if (!fileF.exists()) {
                return;
            }
            File fileF2 = f(str2);
            c(fileF2);
            FileOutputStream fileOutputStream = null;
            try {
                fileInputStream = new FileInputStream(fileF);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(fileF2);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i9 = fileInputStream.read(bArr);
                            if (i9 == -1) {
                                jv.a(fileOutputStream2);
                                jv.a(fileInputStream);
                                return;
                            }
                            fileOutputStream2.write(bArr, 0, i9);
                        }
                    } catch (Throwable unused) {
                        fileOutputStream = fileOutputStream2;
                        jv.a(fileOutputStream);
                        jv.a(fileInputStream);
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
        } catch (Throwable unused4) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable, java.nio.channels.FileChannel] */
    private static boolean a(File file, File file2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        ?? channel;
        try {
            if (!file.exists()) {
                ee.d("FileUtils", "copy failed: source file not exists: " + file.getAbsolutePath());
                return false;
            }
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                ee.d("FileUtils", "copy failed: cannot create dest directory: " + parentFile.getAbsolutePath());
                return false;
            }
            FileChannel fileChannel = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        channel = fileInputStream.getChannel();
                        try {
                            FileChannel channel2 = fileOutputStream.getChannel();
                            try {
                                channel.transferTo(0L, channel.size(), channel2);
                                jv.a(channel2);
                                jv.a((Closeable) channel);
                                jv.a(fileOutputStream);
                                jv.a(fileInputStream);
                                return true;
                            } catch (Throwable unused) {
                                fileChannel = channel2;
                                jv.a(fileChannel);
                                jv.a((Closeable) channel);
                                jv.a(fileOutputStream);
                                jv.a(fileInputStream);
                                return false;
                            }
                        } catch (Throwable unused2) {
                        }
                    } catch (Throwable unused3) {
                        channel = 0;
                    }
                } catch (Throwable unused4) {
                    fileOutputStream = null;
                    channel = fileOutputStream;
                    jv.a(fileChannel);
                    jv.a((Closeable) channel);
                    jv.a(fileOutputStream);
                    jv.a(fileInputStream);
                    return false;
                }
            } catch (Throwable unused5) {
                fileInputStream = null;
                fileOutputStream = null;
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("copy failed: ");
            sb.append(file.getAbsolutePath());
            sb.append(" -> ");
            sb.append(file2.getAbsolutePath());
            sb.append(", error: ");
            defpackage.f.n(th, sb, "FileUtils");
            return false;
        }
    }

    private static void c(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
    }

    public static void c(String str, String str2) {
        FileOutputStream fileOutputStreamOpenFileOutput;
        try {
            fileOutputStreamOpenFileOutput = jg.a().openFileOutput(W5.e.u(str, ".l"), 0);
            try {
                fileOutputStreamOpenFileOutput.write(str2.getBytes());
                jv.a(fileOutputStreamOpenFileOutput);
            } catch (Throwable unused) {
                jv.a(fileOutputStreamOpenFileOutput);
            }
        } catch (Throwable unused2) {
            fileOutputStreamOpenFileOutput = null;
        }
    }

    private static boolean a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return d(file);
        }
        c(file);
        File file2 = new File(file.getParent(), file.getName() + ".tmp." + Thread.currentThread().getId() + "." + System.currentTimeMillis());
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
            try {
                String strG = g(str);
                int i9 = 0;
                while (i9 < strG.length()) {
                    int i10 = 65536 + i9;
                    bufferedOutputStream2.write(strG.substring(i9, Math.min(strG.length(), i10)).getBytes("UTF-8"));
                    bufferedOutputStream2.flush();
                    i9 = i10;
                }
                bufferedOutputStream2.flush();
                boolean zRenameTo = file2.renameTo(file);
                if (!zRenameTo) {
                    ee.a("FileUtils", "rename failed, trying safe copy: " + file2.getAbsolutePath() + " -> " + file.getAbsolutePath());
                    zRenameTo = a(file2, file);
                }
                jv.a(bufferedOutputStream2);
                if (file2.exists() && !file2.delete()) {
                    ee.a("FileUtils", "failed to delete temp file: " + file2.getAbsolutePath());
                }
                return zRenameTo;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    ee.d("FileUtils", "save failed: " + file.getAbsolutePath() + ", error: " + th.getMessage());
                    return false;
                } finally {
                    jv.a(bufferedOutputStream);
                    if (file2.exists() && !file2.delete()) {
                        ee.a("FileUtils", "failed to delete temp file: " + file2.getAbsolutePath());
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(File file, byte[] bArr) {
        File file2;
        if (bArr == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            FileOutputStream fileOutputStream = null;
            try {
                file2 = new File(parentFile, ".tmp." + Process.myPid() + "." + Thread.currentThread().getId());
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        fileOutputStream2.getFD().sync();
                        jv.a(fileOutputStream2);
                        boolean zRenameTo = file2.renameTo(file);
                        jv.a((Closeable) null);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        return zRenameTo;
                    } catch (Throwable unused) {
                        fileOutputStream = fileOutputStream2;
                        jv.a(fileOutputStream);
                        if (file2 != null && file2.exists()) {
                            file2.delete();
                        }
                        return false;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                file2 = null;
            }
        } else {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        return a(f(str), str2);
    }

    public static boolean a(String str, String str2, String str3) {
        boolean zA;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            synchronized (str) {
                try {
                    File file = new File(jg.a().getFilesDir(), str2);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(file, str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    zA = a(file2, str3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zA;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str, JSONObject jSONObject) {
        return a(str, jSONObject != null ? jSONObject.toString() : null);
    }
}

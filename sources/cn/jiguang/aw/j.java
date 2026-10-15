package cn.jiguang.aw;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f9519a = h("j-c-o-r-e-").getBytes(StandardCharsets.UTF_8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ReentrantLock> f9520b = new ConcurrentHashMap<>();

    public static class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9521a = new a(true, false);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f9522b = new a(false, true);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f9523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f9524d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f9525e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f9526f;

        public a(boolean z8, boolean z9) {
            this.f9523c = z8;
            this.f9524d = z9;
            this.f9525e = null;
            this.f9526f = 0;
        }

        public static a a(String str) {
            return new a(false, true, str, 3);
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (this.f9523c && !file.isFile()) {
                return false;
            }
            if (this.f9524d && !file.isDirectory()) {
                return false;
            }
            if (TextUtils.isEmpty(this.f9525e)) {
                return true;
            }
            int i9 = this.f9526f;
            if (i9 == 1) {
                return file.getName().startsWith(this.f9525e);
            }
            if (i9 == 2) {
                return file.getName().endsWith(this.f9525e);
            }
            if (i9 == 3) {
                return file.getName().equals(this.f9525e);
            }
            if (i9 != 4) {
                return false;
            }
            return file.getName().contains(this.f9525e);
        }

        public a(boolean z8, boolean z9, String str, int i9) {
            this.f9525e = str;
            this.f9526f = i9;
            this.f9523c = z8;
            this.f9524d = z9;
        }
    }

    public static File a(File[] fileArr) {
        File file = null;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                if (file2.lastModified() > (file != null ? file.lastModified() : 0L)) {
                    file = file2;
                }
            }
        }
        return file;
    }

    public static JSONArray b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.x.f.c("FileUtils", "file_name is null , give up read ");
                return null;
            }
            String strE = e(str);
            if (v.a(strE)) {
                return null;
            }
            return new JSONArray(strE.trim());
        } catch (Throwable th) {
            cn.jiguang.x.f.i("FileUtils", "can't build " + str + " into JSONArray, give up read :" + th);
            return null;
        }
    }

    public static File c(String str) {
        Context contextA = d.a();
        if (contextA == null) {
            cn.jiguang.x.f.i("FileUtils", "can't get file :" + str + ", context is null");
            return null;
        }
        File filesDir = contextA.getFilesDir();
        if (filesDir != null) {
            return new File(filesDir, str);
        }
        cn.jiguang.x.f.i("FileUtils", "can't get file :" + str);
        return null;
    }

    private static boolean d(File file) {
        if (file != null && file.exists()) {
            try {
                return Files.isSymbolicLink(file.toPath());
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String e(String str) {
        return c(c(str));
    }

    private static ReentrantLock f(String str) {
        ReentrantLock reentrantLockPutIfAbsent;
        ConcurrentHashMap<String, ReentrantLock> concurrentHashMap = f9520b;
        ReentrantLock reentrantLock = concurrentHashMap.get(str);
        return (reentrantLock != null || (reentrantLockPutIfAbsent = concurrentHashMap.putIfAbsent(str, (reentrantLock = new ReentrantLock()))) == null) ? reentrantLock : reentrantLockPutIfAbsent;
    }

    private static void g(String str) {
        ReentrantLock reentrantLock = f9520b.get(str);
        if (reentrantLock != null) {
            if (reentrantLock.isHeldByCurrentThread()) {
                while (reentrantLock.getHoldCount() > 0) {
                    reentrantLock.unlock();
                }
            }
            if (reentrantLock.hasQueuedThreads() || reentrantLock.getHoldCount() != 0) {
                return;
            }
            f9520b.remove(str, reentrantLock);
        }
    }

    private static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i9 = 0; i9 < charArray.length; i9++) {
            charArray[i9] = (char) (charArray[i9] ^ 2000);
        }
        return new String(charArray);
    }

    public static JSONObject a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.x.f.c("FileUtils", "file_name is null , give up read ");
                return null;
            }
            String strE = e(str);
            if (v.a(strE)) {
                return null;
            }
            return new JSONObject(strE.trim());
        } catch (Throwable th) {
            cn.jiguang.x.f.i("FileUtils", "can't build " + str + " into JsonObject, give up read :" + th);
            return null;
        }
    }

    public static boolean b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && !d(file) && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!b(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a3 A[Catch: all -> 0x0092, OutOfMemoryError -> 0x019c, TRY_LEAVE, TryCatch #17 {OutOfMemoryError -> 0x019c, all -> 0x0092, blocks: (B:19:0x006a, B:21:0x007b, B:23:0x008f, B:28:0x0099, B:32:0x00a3, B:45:0x00dc, B:47:0x00fb, B:57:0x0128), top: B:127:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00db  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fb A[Catch: all -> 0x0092, OutOfMemoryError -> 0x019c, TRY_LEAVE, TryCatch #17 {OutOfMemoryError -> 0x019c, all -> 0x0092, blocks: (B:19:0x006a, B:21:0x007b, B:23:0x008f, B:28:0x0099, B:32:0x00a3, B:45:0x00dc, B:47:0x00fb, B:57:0x0128), top: B:127:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0128 A[Catch: all -> 0x0092, OutOfMemoryError -> 0x019c, TRY_ENTER, TRY_LEAVE, TryCatch #17 {OutOfMemoryError -> 0x019c, all -> 0x0092, blocks: (B:19:0x006a, B:21:0x007b, B:23:0x008f, B:28:0x0099, B:32:0x00a3, B:45:0x00dc, B:47:0x00fb, B:57:0x0128), top: B:127:0x006a }] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.nio.channels.spi.AbstractInterruptibleChannel, java.util.concurrent.locks.ReentrantLock] */
    public static String c(File file) {
        FileChannel channel;
        boolean zEquals;
        long length;
        long j;
        String str;
        Charset charset;
        String strConcat;
        if (e(file)) {
            return null;
        }
        if (file.length() > 10485760) {
            cn.jiguang.x.f.i("FileUtils", "File too large to read: " + file.getAbsolutePath() + ", size: " + file.length());
            return null;
        }
        ?? F8 = f(file.getAbsolutePath());
        try {
            try {
                if (!F8.tryLock(10L, TimeUnit.SECONDS)) {
                    cn.jiguang.x.f.i("FileUtils", "read2String Failed to acquire file lock within timeout");
                    g(file.getAbsolutePath());
                    return null;
                }
                channel = new FileInputStream(file).getChannel();
                try {
                    long size = channel.size();
                    byte[] bArr = f9519a;
                    byte[] bArr2 = new byte[bArr.length];
                    if (size >= bArr.length) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
                        channel.read(byteBufferAllocate);
                        byteBufferAllocate.flip();
                        byteBufferAllocate.get(bArr2);
                        zEquals = Arrays.equals(bArr2, bArr);
                        if (zEquals) {
                            length = bArr.length;
                        }
                        j = size - length;
                        if (j <= 0) {
                            if (zEquals) {
                                strConcat = "";
                            } else {
                                strConcat = new String(bArr2, StandardCharsets.UTF_8);
                            }
                            try {
                                channel.close();
                            } catch (Throwable th) {
                                try {
                                    cn.jiguang.x.f.i("FileUtils", "read fail: " + th.getMessage());
                                    return strConcat;
                                } finally {
                                    g(file.getAbsolutePath());
                                }
                            }
                        } else {
                            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((int) j);
                            channel.position(length);
                            channel.read(byteBufferAllocateDirect);
                            byteBufferAllocateDirect.flip();
                            byte[] bArr3 = new byte[byteBufferAllocateDirect.remaining()];
                            byteBufferAllocateDirect.get(bArr3);
                            charset = StandardCharsets.UTF_8;
                            str = new String(bArr3, charset);
                            if (zEquals) {
                                strConcat = h(str);
                                try {
                                    channel.close();
                                } catch (Throwable th2) {
                                    try {
                                        cn.jiguang.x.f.i("FileUtils", "read fail: " + th2.getMessage());
                                        return strConcat;
                                    } finally {
                                        g(file.getAbsolutePath());
                                    }
                                }
                            } else {
                                strConcat = new String(bArr2, charset).concat(str);
                                try {
                                    channel.close();
                                } catch (Throwable th3) {
                                    try {
                                        cn.jiguang.x.f.i("FileUtils", "read fail: " + th3.getMessage());
                                        return strConcat;
                                    } finally {
                                        g(file.getAbsolutePath());
                                    }
                                }
                            }
                        }
                        g(file.getAbsolutePath());
                        return strConcat;
                    }
                    zEquals = false;
                    length = 0;
                    j = size - length;
                    if (j <= 0) {
                        if (zEquals) {
                            strConcat = "";
                        } else {
                            strConcat = new String(bArr2, StandardCharsets.UTF_8);
                        }
                        channel.close();
                    } else {
                        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect((int) j);
                        channel.position(length);
                        channel.read(byteBufferAllocateDirect2);
                        byteBufferAllocateDirect2.flip();
                        byte[] bArr4 = new byte[byteBufferAllocateDirect2.remaining()];
                        byteBufferAllocateDirect2.get(bArr4);
                        charset = StandardCharsets.UTF_8;
                        str = new String(bArr4, charset);
                        if (zEquals) {
                            strConcat = h(str);
                            channel.close();
                        } else {
                            strConcat = new String(bArr2, charset).concat(str);
                            channel.close();
                        }
                    }
                    g(file.getAbsolutePath());
                    return strConcat;
                } catch (OutOfMemoryError unused) {
                    cn.jiguang.x.f.i("FileUtils", "Out of memory reading file: " + file.getAbsolutePath());
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th4) {
                            try {
                                cn.jiguang.x.f.i("FileUtils", "read fail: " + th4.getMessage());
                            } finally {
                                g(file.getAbsolutePath());
                            }
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    cn.jiguang.x.f.i("FileUtils", "read fail: " + th.getMessage());
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th6) {
                            try {
                                cn.jiguang.x.f.i("FileUtils", "read fail: " + th6.getMessage());
                            } finally {
                                g(file.getAbsolutePath());
                            }
                        }
                    }
                    return null;
                }
            } catch (Throwable th7) {
                if (F8 != 0) {
                    try {
                        F8.close();
                    } catch (Throwable th8) {
                        try {
                            cn.jiguang.x.f.i("FileUtils", "read fail: " + th8.getMessage());
                        } finally {
                            g(file.getAbsolutePath());
                        }
                    }
                }
                throw th7;
            }
        } catch (OutOfMemoryError unused2) {
            channel = null;
        } catch (Throwable th9) {
            th = th9;
            channel = null;
        }
    }

    private static boolean d(File file, String str) {
        File file2 = new File(file.getParent(), file.getName() + ".tmp");
        try {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    bufferedOutputStream.write(f9519a);
                    if (file.exists() && file.length() > 0) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[Math.min(65536, (int) file.length())];
                            while (true) {
                                int i9 = fileInputStream.read(bArr);
                                if (i9 == -1) {
                                    break;
                                }
                                Charset charset = StandardCharsets.UTF_8;
                                bufferedOutputStream.write(h(new String(bArr, 0, i9, charset)).getBytes(charset));
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                }
                                throw th;
                            }
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                    bufferedOutputStream.write(h(str).getBytes(StandardCharsets.UTF_8));
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    boolean z8 = file2.renameTo(file) || a(file2, file);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    return z8;
                } catch (Throwable th4) {
                    bufferedOutputStream.close();
                    throw th4;
                }
            } catch (Exception e9) {
                cn.jiguang.x.f.i("FileUtils", "Rebuild file failed: " + e9.getMessage());
                if (file2.exists()) {
                    file2.delete();
                }
                return false;
            }
        } catch (Throwable th5) {
            if (file2.exists()) {
                file2.delete();
            }
            throw th5;
        }
    }

    private static boolean e(File file) {
        return file == null || file.isDirectory() || !file.exists();
    }

    private static void a(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        if (str.length() <= 65536) {
            bufferedOutputStream.write(h(str).getBytes(StandardCharsets.UTF_8));
        } else {
            int i9 = 0;
            while (i9 < str.length()) {
                int i10 = i9 + 65536;
                bufferedOutputStream.write(h(str.substring(i9, Math.min(str.length(), i10))).getBytes(StandardCharsets.UTF_8));
                i9 = i10;
            }
        }
        bufferedOutputStream.flush();
    }

    public static boolean b(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return b(file);
        }
        a(file);
        File file2 = null;
        try {
            try {
                if (!f(file.getAbsolutePath()).tryLock(10L, TimeUnit.SECONDS)) {
                    cn.jiguang.x.f.i("FileUtils", "save Failed to acquire file lock within timeout");
                    g(file.getAbsolutePath());
                    return false;
                }
                File file3 = new File(file.getParent(), file.getName() + ".tmp");
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), 8192);
                    try {
                        bufferedOutputStream.write(f9519a);
                        a(bufferedOutputStream, str);
                        boolean z8 = file3.renameTo(file) || a(file3, file);
                        bufferedOutputStream.close();
                        g(file.getAbsolutePath());
                        if (file3.exists()) {
                            file3.delete();
                        }
                        return z8;
                    } catch (Throwable th) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    file2 = file3;
                    cn.jiguang.x.f.i("FileUtils", "save Thread interrupted while waiting for file lock");
                    g(file.getAbsolutePath());
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    file2 = file3;
                    cn.jiguang.x.f.i("FileUtils", "save fail: " + th.getMessage());
                    g(file.getAbsolutePath());
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    return false;
                }
            } catch (Throwable th4) {
                g(file.getAbsolutePath());
                if (0 != 0 && file2.exists()) {
                    file2.delete();
                }
                throw th4;
            }
        } catch (InterruptedException unused2) {
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static void c(String str, String str2) {
        String str3;
        try {
            File fileC = c(str);
            if (fileC == null || !fileC.exists()) {
                str3 = "Source file does not exist: " + str;
            } else {
                File fileC2 = c(str2);
                if (fileC2 != null) {
                    a(fileC2);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(fileC);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileC2);
                            try {
                                byte[] bArr = new byte[Math.min(65536, (int) fileC.length())];
                                while (true) {
                                    int i9 = fileInputStream.read(bArr);
                                    if (i9 == -1) {
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                        fileInputStream.close();
                                        return;
                                    }
                                    fileOutputStream.write(bArr, 0, i9);
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable th) {
                                        th.addSuppressed(th);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            fileInputStream.close();
                            throw th4;
                        }
                    } catch (IOException e9) {
                        cn.jiguang.x.f.i("FileUtils", "Copy file failed: " + e9.getMessage());
                        if (fileC2.exists()) {
                            fileC2.delete();
                            return;
                        }
                        return;
                    }
                }
                str3 = "Cannot create temp file: " + str2;
            }
            cn.jiguang.x.f.i("FileUtils", str3);
        } catch (Throwable th5) {
            W5.e.t(th5, new StringBuilder("copyFileToTemp error: "), "FileUtils");
        }
    }

    public static boolean d(String str) {
        return b(c(str));
    }

    public static void a(File file) {
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

    public static boolean b(String str, String str2) {
        return c(c(str), str2);
    }

    private static boolean a(File file, File file2) {
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                try {
                    channel.transferTo(0L, channel.size(), channel2);
                    if (channel2 != null) {
                        channel2.close();
                    }
                    channel.close();
                    return true;
                } catch (Throwable th) {
                    if (channel2 == null) {
                        throw th;
                    }
                    try {
                        channel2.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                    cn.jiguang.x.f.i("FileUtils", "Copy failed: " + e.toString());
                    return false;
                }
            } catch (Throwable th3) {
                if (channel == null) {
                    throw th3;
                }
                try {
                    channel.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } catch (IOException e9) {
            cn.jiguang.x.f.i("FileUtils", "Copy failed: " + e9.toString());
            return false;
        }
    }

    public static boolean a(File file, String str) {
        String str2;
        if (file == null || file.isDirectory()) {
            str2 = "File should not be null or a directory";
        } else if (TextUtils.isEmpty(str)) {
            str2 = "Append data should not be empty";
        } else {
            try {
                a(file);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    return true;
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e9) {
                str2 = "Failed to append to file: " + file.getAbsolutePath() + ". Exception: " + e9.getMessage();
            }
        }
        cn.jiguang.x.f.i("FileUtils", str2);
        return false;
    }

    private static boolean a(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        byte[] bArr = f9519a;
        if (length < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        randomAccessFile.seek(0L);
        randomAccessFile.readFully(bArr2);
        return Arrays.equals(bArr2, bArr);
    }

    private static boolean a(RandomAccessFile randomAccessFile, String str) {
        try {
            randomAccessFile.seek(randomAccessFile.length());
            int i9 = 0;
            while (i9 < str.length()) {
                int i10 = 65536 + i9;
                randomAccessFile.write(h(str.substring(i9, Math.min(str.length(), i10))).getBytes(StandardCharsets.UTF_8));
                i9 = i10;
            }
            return true;
        } catch (Exception e9) {
            cn.jiguang.x.f.i("FileUtils", "Append encrypted failed: " + e9.getMessage());
            return false;
        }
    }

    public static boolean c(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a(file);
        String absolutePath = file.getAbsolutePath();
        try {
            if (!f(absolutePath).tryLock(10L, TimeUnit.SECONDS)) {
                cn.jiguang.x.f.i("FileUtils", "append Failed to acquire file lock within timeout");
                g(absolutePath);
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                if (a(randomAccessFile)) {
                    boolean zA = a(randomAccessFile, str);
                    randomAccessFile.close();
                    g(absolutePath);
                    return zA;
                }
                boolean zD = d(file, str);
                randomAccessFile.close();
                g(absolutePath);
                return zD;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                cn.jiguang.x.f.i("FileUtils", "append fail: " + th3.getMessage());
                return false;
            } finally {
                g(absolutePath);
            }
        }
    }

    public static boolean a(String str, String str2) {
        return b(c(str), str2);
    }

    public static boolean a(String str, JSONArray jSONArray) {
        return a(str, jSONArray != null ? jSONArray.toString() : null);
    }

    public static boolean a(String str, JSONObject jSONObject) {
        return a(str, jSONObject != null ? jSONObject.toString() : null);
    }

    public static File[] a(File file, FileFilter... fileFilterArr) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return null;
        }
        if (fileFilterArr == null || fileFilterArr.length == 0 || (fileFilterArr.length == 1 && fileFilterArr[0] == null)) {
            return file.listFiles();
        }
        if (fileFilterArr.length == 1) {
            return file.listFiles(fileFilterArr[0]);
        }
        LinkedList<File> linkedList = new LinkedList();
        linkedList.add(file);
        int length = fileFilterArr.length;
        int i9 = 0;
        while (i9 < length) {
            FileFilter fileFilter = fileFilterArr[i9];
            LinkedList linkedList2 = new LinkedList();
            for (File file2 : linkedList) {
                File[] fileArrListFiles = fileFilter != null ? file2.listFiles(fileFilter) : file2.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    Collections.addAll(linkedList2, fileArrListFiles);
                }
            }
            if (linkedList2.isEmpty()) {
                return null;
            }
            i9++;
            linkedList = linkedList2;
        }
        return (File[]) linkedList.toArray(new File[0]);
    }

    public static File[] a(String str, FileFilter... fileFilterArr) {
        try {
            return a(new File(str), fileFilterArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}

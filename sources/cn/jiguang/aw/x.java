package cn.jiguang.aw;

import android.content.Context;
import android.os.SystemClock;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f9568a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f9569b = new ConcurrentHashMap<>();

    public static long a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String b(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static short c(byte[] bArr) throws Exception {
        int i9;
        if (bArr == 0 || bArr.length == 0) {
            throw new Exception("byte could not be empty");
        }
        if (bArr.length == 1) {
            i9 = bArr[0];
        } else {
            i9 = ((short) (bArr[1] & 255)) | ((short) ((bArr[0] & 255) << 8));
        }
        return (short) i9;
    }

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }

    public static boolean b(long j, long j8) {
        if (j8 <= 0) {
            throw new AssertionError();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return j <= 0 || jElapsedRealtime <= j || jElapsedRealtime > j + j8;
    }

    public static LinkedHashSet<String> a(Context context, LinkedHashSet<String> linkedHashSet) {
        if (b.e(context)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str : linkedHashSet) {
                if (str.contains("ipv6")) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
            linkedHashSet.clear();
            linkedHashSet.addAll(arrayList);
            linkedHashSet.addAll(arrayList2);
        }
        return linkedHashSet;
    }

    public static byte[] b(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int i9 = gZIPInputStream.read(bArr2);
                    if (i9 < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a(byteArrayOutputStream);
                        a((Closeable) byteArrayInputStream);
                        a((Closeable) gZIPInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i9);
                }
            } catch (Throwable th2) {
                th = th2;
                a(byteArrayOutputStream);
                a((Closeable) byteArrayInputStream);
                a((Closeable) gZIPInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            gZIPInputStream = null;
            th = th3;
        }
    }

    public static LinkedList<InetAddress> a(Context context, LinkedList<InetAddress> linkedList) {
        if (!b.e(context)) {
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (InetAddress inetAddress : linkedList) {
            if (inetAddress instanceof Inet6Address) {
                linkedList2.add(inetAddress);
            } else if (inetAddress instanceof Inet4Address) {
                linkedList3.add(inetAddress);
            }
        }
        linkedList.clear();
        linkedList.addAll(linkedList2);
        linkedList.addAll(linkedList3);
        return linkedList;
    }

    public static <T> LinkedList<T> a(Collection<T> collection) {
        LinkedList<T> linkedList = new LinkedList<>();
        int i9 = 0;
        int size = collection != null ? collection.size() : 0;
        if (size != 0) {
            if (size == 1) {
                linkedList.addAll(collection);
                return linkedList;
            }
            SecureRandom secureRandom = new SecureRandom();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                i9++;
                linkedList.add(secureRandom.nextInt(i9), it.next());
            }
        }
        return linkedList;
    }

    public static List<cn.jiguang.ac.g> a(List<cn.jiguang.ac.g> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i9 = 0; i9 < list.size() - 1; i9++) {
            cn.jiguang.ac.g gVar = list.get(i9);
            if (gVar.f8876a.contains("ipv6")) {
                arrayList.add(gVar);
            } else {
                arrayList2.add(gVar);
            }
        }
        list.clear();
        list.addAll(arrayList);
        list.addAll(arrayList2);
        return list;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            try {
                File file = new File(str);
                a(zipOutputStream, file, file.getName());
                zipOutputStream.flush();
                zipOutputStream.close();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    zipOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                fileOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                StringBuilder sbC = p171w.a.c(str, "/");
                sbC.append(file2.getName());
                a(zipOutputStream, file2, sbC.toString());
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            zipOutputStream.putNextEntry(new ZipEntry(str));
            byte[] bArr = new byte[1024];
            while (true) {
                int i9 = fileInputStream.read(bArr);
                if (i9 < 0) {
                    fileInputStream.close();
                    zipOutputStream.closeEntry();
                    return;
                }
                zipOutputStream.write(bArr, 0, i9);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean a(long j, long j8) {
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            calendar2.setTimeInMillis(j8);
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static byte[] a(InputStream inputStream) throws Throwable {
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i9 = inputStream.read(bArr);
                    if (i9 == -1) {
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        a(byteArrayOutputStream2);
                        return byteArray;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i9);
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(byte[] bArr) throws Throwable {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a(byteArrayOutputStream);
                a(gZIPOutputStream2);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                a(byteArrayOutputStream);
                a(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

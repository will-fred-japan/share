package cn.jiguang.commons.a;

import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class gm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Runnable f10101a = new gn();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object[] f10102b = new Object[2];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f10103c = {102, 120, 94, 71, 57, 37, 117, 49, 1, 0, 52, 127, 54, 32, 16};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f10104d = {83, 65, 109, 40, 57, 97, 66, 79, 122, 39, 120, 116, 68, 15, 120, 122, 102};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f10105e = {120, 64, 0, 52, 60, 54, 127, 85, 73, 126, 96, 54, 98, 88, 79, 110};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f10106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f10107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<String> f10108h;

    static {
        byte[] bArr = new byte[30];
        f10106f = bArr;
        Arrays.fill(bArr, (byte) 65);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(50);
        byteBufferAllocate.putInt(2116550656);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.put(new byte[]{32, 67, 75});
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.put(new byte[]{0, 0, 33, 0, 1});
        f10107g = byteBufferAllocate.array();
        f10108h = new HashSet(Arrays.asList("REACHABLE", "STALE", "DELAY", "PROBE", "INCOMPLETE", "FAILED", "PERMANENT", "NOARP", "NONE"));
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("0x")) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        try {
            return (Integer.parseInt(str.substring(2), 16) & 2) != 0 ? "REACHABLE" : "STALE";
        } catch (NumberFormatException unused) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static List<x> b() {
        ey eyVarB;
        int i9;
        x xVar;
        int i10;
        ee.a("JArpUtils", "getArpFromNeigh called");
        try {
            List<String> listA = kp.a(new String[]{jr.a(f10105e)}, 1);
            StringBuilder sb = new StringBuilder("arp neigh lines: ");
            sb.append(listA != null ? listA.size() : 0);
            ee.a("JArpUtils", sb.toString());
            if (listA != null && !listA.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                int i11 = 0;
                for (String str : listA) {
                    if (!TextUtils.isEmpty(str)) {
                        String[] strArrSplit = str.trim().split("\\s+");
                        if (strArrSplit.length < 4) {
                            xVar = null;
                        } else {
                            x xVar2 = new x();
                            xVar2.f10436d = GrsBaseInfo.CountryCodeSource.UNKNOWN;
                            xVar2.f10433a = strArrSplit[0];
                            String str2 = strArrSplit[strArrSplit.length - 1];
                            int i12 = 1;
                            while (i12 < strArrSplit.length) {
                                String str3 = strArrSplit[i12];
                                if (!"dev".equals(str3) || (i10 = i12 + 1) >= strArrSplit.length) {
                                    if (!"lladdr".equals(str3) || (i10 = i12 + 1) >= strArrSplit.length) {
                                        String upperCase = str3.toUpperCase(Locale.US);
                                        if (f10108h.contains(upperCase)) {
                                            xVar2.f10436d = upperCase;
                                        }
                                    } else {
                                        xVar2.f10434b = strArrSplit[i10].toUpperCase(Locale.US);
                                    }
                                    i12++;
                                } else {
                                    xVar2.f10435c = strArrSplit[i10];
                                }
                                i12 = i10;
                                i12++;
                            }
                            if (GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(xVar2.f10436d)) {
                                String upperCase2 = str2.toUpperCase(Locale.US);
                                if (f10108h.contains(upperCase2)) {
                                    xVar2.f10436d = upperCase2;
                                }
                            }
                            xVar = xVar2;
                        }
                        if (xVar != null && a(xVar)) {
                            arrayList.add(xVar);
                            i11++;
                        }
                    }
                }
                ee.a("JArpUtils", "arp neigh parsed, valid: " + i11 + "/" + listA.size());
                if (i11 > 0) {
                    eyVarB = ey.b();
                    i9 = 3033;
                } else {
                    eyVarB = ey.b();
                    i9 = 3034;
                }
                eyVarB.g(i9);
                return arrayList;
            }
            ey.b().g((Object) 3034);
            return Collections.EMPTY_LIST;
        } catch (Throwable unused) {
            return Collections.EMPTY_LIST;
        }
    }

    public static /* synthetic */ void c() {
        String str;
        byte[] bArr;
        Object[] objArr = f10102b;
        synchronized (objArr) {
            str = (String) objArr[0];
            bArr = (byte[]) objArr[1];
        }
        try {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 3);
            for (int i9 = 0; i9 <= 255; i9++) {
                if (i9 != (bArr[3] & 255)) {
                    byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, 4);
                    bArrCopyOf2[3] = (byte) i9;
                    String str2 = bArrCopyOf2.length != 4 ? "" : String.format("%d.%d.%d.%d", Integer.valueOf(bArrCopyOf2[0] & 255), Integer.valueOf(bArrCopyOf2[1] & 255), Integer.valueOf(bArrCopyOf2[2] & 255), Integer.valueOf(255 & bArrCopyOf2[3]));
                    if (!str2.equals(str)) {
                        kp.a(new String[]{jr.a(f10103c) + str2}, 0);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static List<x> a() {
        ey eyVarB;
        int i9;
        ee.a("JArpUtils", "getArpFromCat called");
        try {
            List<String> listA = kp.a(new String[]{jr.a(f10104d)}, 1);
            StringBuilder sb = new StringBuilder("arp cat lines: ");
            sb.append(listA != null ? listA.size() : 0);
            ee.a("JArpUtils", sb.toString());
            if (listA != null && listA.size() > 1) {
                ArrayList arrayList = new ArrayList();
                int i10 = 0;
                for (int i11 = 1; i11 < listA.size(); i11++) {
                    String str = listA.get(i11);
                    if (!TextUtils.isEmpty(str)) {
                        String[] strArrSplit = str.trim().split("\\s+");
                        if (strArrSplit.length >= 6) {
                            x xVar = new x();
                            xVar.f10433a = strArrSplit[0];
                            xVar.f10437e = strArrSplit[1];
                            xVar.f10438f = strArrSplit[2];
                            xVar.f10434b = strArrSplit[3].toUpperCase(Locale.US);
                            xVar.f10435c = strArrSplit[5];
                            xVar.f10436d = a(strArrSplit[2]);
                            if (a(xVar)) {
                                arrayList.add(xVar);
                                i10++;
                            }
                        }
                    }
                }
                ee.a("JArpUtils", "arp cat parsed, valid: " + i10 + "/" + (listA.size() - 1));
                if (i10 > 0) {
                    eyVarB = ey.b();
                    i9 = 3031;
                } else {
                    eyVarB = ey.b();
                    i9 = 3032;
                }
                eyVarB.g(i9);
                return arrayList;
            }
            ee.a("JArpUtils", "arp cat no data");
            ey.b().g((Object) 3032);
            return Collections.EMPTY_LIST;
        } catch (Throwable unused) {
            return Collections.EMPTY_LIST;
        }
    }

    public static void a(int i9) {
        int i10 = i9 & (-256);
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            try {
                datagramSocket.setSoTimeout(1000);
                for (int i11 = 0; i11 < 256; i11++) {
                    if (i11 != (i9 & 255)) {
                        InetAddress byAddress = InetAddress.getByAddress(new byte[]{(byte) (i10 >>> 24), (byte) (i10 >>> 16), (byte) (i10 >>> 8), (byte) i11});
                        byte[] bArr = f10107g;
                        try {
                            datagramSocket.send(new DatagramPacket(bArr, bArr.length, byAddress, 137));
                        } catch (IOException unused) {
                        }
                    }
                }
                datagramSocket.close();
            } catch (Throwable th) {
                try {
                    datagramSocket.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused2) {
        }
    }

    public static void a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length != 4) {
            ee.d("JArpUtils", "ping params invalid");
            return;
        }
        Object[] objArr = f10102b;
        synchronized (objArr) {
            objArr[0] = str;
            objArr[1] = Arrays.copyOf(bArr, 4);
        }
        fe.a().a(f10101a, fl.NETWORK);
    }

    private static boolean a(x xVar) {
        return (TextUtils.isEmpty(xVar.f10433a) || TextUtils.isEmpty(xVar.f10434b) || "00:00:00:00:00:00".equals(xVar.f10434b) || "<incomplete>".equals(xVar.f10434b)) ? false : true;
    }

    public static byte[] a(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)};
    }
}

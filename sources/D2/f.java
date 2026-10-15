package D2;

import android.util.Log;
import com.huawei.hms.framework.common.BundleUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogSender.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements F2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap<h, ConcurrentLinkedQueue<c>> f1887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f1888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1891e;

    /* JADX INFO: compiled from: LogSender.java */
    public class a implements Comparator<File> {
        @Override // java.util.Comparator
        public final int compare(File file, File file2) {
            return file.compareTo(file2);
        }
    }

    /* JADX INFO: compiled from: LogSender.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f1892a;

        static {
            f fVar = new f();
            fVar.f1887a = new LinkedHashMap<>();
            fVar.f1889c = 30000L;
            fVar.f1890d = 0L;
            fVar.f1891e = 1L;
            f1892a = fVar;
        }
    }

    /* JADX INFO: compiled from: LogSender.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f1893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1895c;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0177 */
    /* JADX WARN: Code duplicated, block: B:166:0x023a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x00cd A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(D2.f r19) {
        /*
            Method dump skipped, instruction units count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D2.f.e(D2.f):void");
    }

    public static void f(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2.a aVar = (C2.a) it.next();
            try {
                File file = aVar.f1795d;
                if (file != null) {
                    A1.b.J(file);
                }
            } catch (Exception unused) {
                String str = p199z2.a.f22469a;
                String str2 = "delete LogFile's source File failed. logFile=" + aVar.f1795d;
                if (p010b3.b.f8497a != null && A1.b.f1393A) {
                    Log.w(str, str2);
                }
            }
        }
    }

    @Override // F2.d
    public final String a() {
        return "second_log_dir";
    }

    @Override // F2.d
    public final long b() {
        D2.b bVar = D2.b.a.f1860a;
        bVar.b();
        File file = bVar.f1855c;
        File[] fileArrListFiles = file == null ? null : file.listFiles();
        long length = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            length += file2.length();
        }
        return length;
    }

    @Override // F2.d
    public final void c(long j) {
        long j8;
        D2.b bVar = D2.b.a.f1860a;
        bVar.b();
        File file = bVar.f1855c;
        File[] fileArrListFiles = file == null ? null : file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            try {
                String[] strArrSplit = file2.getName().split(BundleUtil.UNDERLINE_TAG);
                j8 = strArrSplit.length != 2 ? -1L : Long.parseLong(strArrSplit[0]);
            } catch (Throwable unused) {
            }
            if (j8 <= j) {
                A1.b.J(file2);
            }
        }
    }

    public final void d(int i9, ArrayList arrayList) {
        boolean z8;
        boolean zE;
        int i10;
        long j;
        ConcurrentLinkedQueue<c> concurrentLinkedQueue;
        ArrayList arrayListB;
        try {
            d dVar = d.a.f1885a;
            if (dVar.f1884m) {
                long jCurrentTimeMillis = System.currentTimeMillis() - dVar.f1882k.get();
                long j8 = dVar.f1874b > dVar.f1876d ? dVar.f1874b : dVar.f1876d;
                if (j8 <= dVar.f1877e) {
                    j8 = dVar.f1877e;
                }
                z8 = jCurrentTimeMillis <= j8;
            } else {
                z8 = dVar.f1884m;
            }
            if (z8) {
                if (A1.b.f1393A) {
                    p010b3.b.a(p199z2.a.f22469a, "stop collect log");
                }
                Iterator it = arrayList.iterator();
                long j9 = 0;
                long j10 = 0;
                while (it.hasNext()) {
                    C2.a aVar = (C2.a) it.next();
                    j9 += (long) aVar.f1793b;
                    j10 += (long) aVar.f1794c;
                }
                D2.c.a.f1868a.b(j9, j10, System.currentTimeMillis());
                f(arrayList);
                return;
            }
            HashMap mapA = i.a(i9, arrayList);
            if (mapA == null) {
                f(arrayList);
                return;
            }
            boolean zD = A4.b.d(A1.b.f1394B);
            boolean z9 = false;
            for (h hVar : mapA.keySet()) {
                byte[] bArr = (byte[]) mapA.get(hVar);
                if (bArr != null) {
                    if (d.a.f1885a.b() && zD) {
                        if (A1.b.f1393A && (arrayListB = P1.a.b(bArr)) != null) {
                            Iterator it2 = arrayListB.iterator();
                            while (it2.hasNext()) {
                                P1.a.c((JSONObject) it2.next(), "DATA_SEND_BEGIN");
                            }
                        }
                        zE = g.a(hVar).f(bArr);
                        if (A1.b.f1393A) {
                            if (zE) {
                                for (JSONObject jSONObject : P1.a.b(bArr)) {
                                    try {
                                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("DATA_DOCTOR");
                                        if (jSONObjectOptJSONObject != null) {
                                            jSONObjectOptJSONObject.put("DATA_SEND_RESULT", 200);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    P1.a.c(jSONObject, "DATA_SEND_SUCCESS");
                                    P1.a.c(jSONObject, "DATA_SEND_END");
                                }
                            } else {
                                for (JSONObject jSONObject2 : P1.a.b(bArr)) {
                                    P1.a.c(jSONObject2, "DATA_SEND_FAIL");
                                    P1.a.c(jSONObject2, "DATA_SEND_END");
                                }
                            }
                        }
                        this.f1890d = System.currentTimeMillis();
                        z9 |= zE;
                        i10 = 1;
                    } else {
                        zE = false;
                        i10 = 0;
                    }
                    if (A1.b.f1393A) {
                        p010b3.b.a(p199z2.a.f22469a, "sendDirect:isReportLogEnable " + d.a.f1885a.b() + " :sendResult " + zE);
                    }
                    if (!zE) {
                        d.a.f1885a.getClass();
                        long jA = d.a(i10);
                        long jCurrentTimeMillis2 = System.currentTimeMillis() + jA;
                        if (N2.a.C1()) {
                            j = jCurrentTimeMillis2;
                            zE = D2.b.a.f1860a.e(bArr, hVar.a(), i10, j);
                        } else {
                            j = jCurrentTimeMillis2;
                        }
                        if (A1.b.f1393A) {
                            p010b3.b.a(p199z2.a.f22469a, "saveFile:Result:" + zE + ":isMaiProcess:" + N2.a.C1() + " :" + i10 + " " + jA);
                        }
                        if (!zE) {
                            if (this.f1887a.containsKey(hVar)) {
                                concurrentLinkedQueue = this.f1887a.get(hVar);
                            } else {
                                concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                                c cVar = new c();
                                cVar.f1893a = bArr;
                                cVar.f1894b = i10;
                                cVar.f1895c = j;
                                concurrentLinkedQueue.add(cVar);
                            }
                            if (concurrentLinkedQueue.size() > 10) {
                                concurrentLinkedQueue.poll();
                            }
                        }
                    }
                }
            }
            if (z9) {
                this.f1891e = 1L;
                this.f1889c = 30000L;
            }
            f(arrayList);
        } catch (Throwable th) {
            p010b3.b.b(p199z2.a.f22469a, "sendLog", th);
        }
    }

    @Override // F2.d
    public final void b(long j) {
        boolean zDelete;
        D2.b bVar = D2.b.a.f1860a;
        bVar.b();
        File file = bVar.f1855c;
        File[] fileArrListFiles = file == null ? null : file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        Arrays.sort(fileArrListFiles, new a());
        long j8 = 0;
        long length = 0;
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.isFile()) {
                length += file2.length();
            }
        }
        for (File file3 : fileArrListFiles) {
            if (length - j8 <= j) {
                return;
            }
            if (file3.exists() && file3.isFile()) {
                long length2 = file3.length();
                if (file3.exists()) {
                    try {
                        zDelete = file3.delete();
                    } catch (Throwable unused) {
                        zDelete = false;
                    }
                } else {
                    zDelete = false;
                }
                if (zDelete) {
                    j8 += length2;
                }
            }
        }
    }
}

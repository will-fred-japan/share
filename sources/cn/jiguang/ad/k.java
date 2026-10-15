package cn.jiguang.ad;

import cn.jiguang.aw.v;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static k f8993d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f8994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g[] f8995b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8996c = -1;

    static {
        c();
    }

    public k() {
        if (d() || e()) {
            return;
        }
        if (this.f8994a == null || this.f8995b == null) {
            if (System.getProperty("java.vendor").indexOf("Android") != -1) {
                g();
            } else {
                f();
            }
        }
    }

    private void a(int i9) {
        if (this.f8996c >= 0 || i9 <= 0) {
            return;
        }
        this.f8996c = i9;
    }

    private int b(String str) {
        try {
            int i9 = Integer.parseInt(str.substring(6));
            if (i9 >= 0) {
                return i9;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static void c() {
        k kVar = new k();
        synchronized (k.class) {
            f8993d = kVar;
        }
    }

    private boolean d() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, Constants.ACCEPT_TIME_SEPARATOR_SP);
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, Constants.ACCEPT_TIME_SEPARATOR_SP);
            while (stringTokenizer2.hasMoreTokens()) {
                b(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.f8994a == null || this.f8995b == null) ? false : true;
    }

    private boolean e() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class<?>[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object objInvoke = cls.getDeclaredMethod("open", clsArr).invoke(null, objArr);
            List list = (List) cls.getMethod("nameservers", clsArr).invoke(objInvoke, objArr);
            List list2 = (List) cls.getMethod("searchlist", clsArr).invoke(objInvoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    a((String) it.next(), arrayList);
                }
            }
            if (list2.size() > 0) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    b((String) it2.next(), arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void f() {
        a("/etc/resolv.conf");
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
        for (int i9 = 0; i9 < 4; i9++) {
            String strA = v.a(strArr[i9], "");
            if (!strA.isEmpty() && ((strA.matches("^\\d+(\\.\\d+){3}$") || strA.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(strA))) {
                arrayList.add(strA);
            }
        }
        a(arrayList, arrayList2);
    }

    public static synchronized k b() {
        return f8993d;
    }

    public void a(String str) {
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iB = -1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.startsWith("nameserver")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(line);
                        stringTokenizer.nextToken();
                        a(stringTokenizer.nextToken(), arrayList);
                    } else if (line.startsWith("domain")) {
                        StringTokenizer stringTokenizer2 = new StringTokenizer(line);
                        stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                            b(stringTokenizer2.nextToken(), arrayList2);
                        }
                    } else if (line.startsWith("search")) {
                        arrayList2.clear();
                        StringTokenizer stringTokenizer3 = new StringTokenizer(line);
                        stringTokenizer3.nextToken();
                        while (stringTokenizer3.hasMoreTokens()) {
                            b(stringTokenizer3.nextToken(), arrayList2);
                        }
                    } else if (line.startsWith("options")) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(line);
                        stringTokenizer4.nextToken();
                        while (stringTokenizer4.hasMoreTokens()) {
                            String strNextToken = stringTokenizer4.nextToken();
                            if (strNextToken.startsWith("ndots:")) {
                                iB = b(strNextToken);
                            }
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException unused) {
            return;
        } catch (IOException unused2) {
        }
        a(arrayList, arrayList2);
        a(iB);
    }

    private void a(String str, List list) {
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    private void b(String str, List list) {
        try {
            g gVarA = g.a(str, g.f8976a);
            if (list.contains(gVarA)) {
                return;
            }
            list.add(gVarA);
        } catch (Exception unused) {
        }
    }

    private void a(List list, List list2) {
        if (this.f8994a == null && list.size() > 0) {
            this.f8994a = (String[]) list.toArray(new String[0]);
        }
        if (this.f8995b != null || list2.size() <= 0) {
            return;
        }
        this.f8995b = (g[]) list2.toArray(new g[0]);
    }

    public String[] a() {
        return this.f8994a;
    }
}

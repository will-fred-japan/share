package cn.jiguang.ac;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient InetAddress f8878c;

    public g(String str, int i9) {
        this.f8876a = str;
        this.f8877b = i9;
    }

    public static g a(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(Constants.COLON_SEPARATOR)) < 0) {
            return null;
        }
        try {
            int iIntValue = Integer.decode(str.substring(iLastIndexOf + 1)).intValue();
            if (iLastIndexOf == 0) {
                strSubstring = "";
            } else {
                boolean zStartsWith = str.startsWith("[");
                if (str.charAt(iLastIndexOf - 1) == ']') {
                    iLastIndexOf--;
                }
                strSubstring = str.substring(zStartsWith ? 1 : 0, iLastIndexOf);
            }
            return new g(strSubstring, iIntValue);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(String str) {
        try {
            return Math.abs(System.currentTimeMillis() - Long.valueOf(str).longValue()) > 259200000;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static LinkedHashSet<g> c(String str) {
        String str2;
        cn.jiguang.x.f.c("IpPort", " string2Set=" + str);
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("-sis-");
            cn.jiguang.x.f.c("IpPort", " string2Set split=" + Arrays.toString(strArrSplit));
            if (strArrSplit != null) {
                if (strArrSplit.length >= 2) {
                    if (b(strArrSplit[1])) {
                        return linkedHashSet;
                    }
                    str2 = strArrSplit[0];
                } else if (strArrSplit.length >= 1) {
                    str2 = strArrSplit[0];
                }
                a(str2, linkedHashSet);
            }
        }
        cn.jiguang.x.f.c("IpPort", " string2Set list=" + linkedHashSet);
        return linkedHashSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f8877b == gVar.f8877b) {
                String str = this.f8876a;
                String str2 = gVar.f8876a;
                if (str == null ? str2 == null : str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8876a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f8877b;
    }

    public String toString() {
        StringBuilder sb;
        boolean zIsEmpty = TextUtils.isEmpty(this.f8876a);
        String str = Constants.COLON_SEPARATOR;
        if (zIsEmpty || !this.f8876a.contains(Constants.COLON_SEPARATOR)) {
            sb = new StringBuilder();
            sb.append(this.f8876a);
        } else {
            sb = new StringBuilder("[");
            sb.append(this.f8876a);
            str = "]:";
        }
        sb.append(str);
        sb.append(this.f8877b);
        return sb.toString();
    }

    public g(InetAddress inetAddress, int i9) {
        this.f8876a = inetAddress.getHostAddress();
        this.f8877b = i9;
        this.f8878c = inetAddress;
    }

    public static String a(LinkedHashSet<g> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<g> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static LinkedHashSet<g> a(LinkedHashMap<String, Integer> linkedHashMap) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            g gVar = new g(entry.getKey(), entry.getValue().intValue());
            if (gVar.a()) {
                linkedHashSet.add(gVar);
            }
        }
        return linkedHashSet;
    }

    private static void a(String str, LinkedHashSet<g> linkedHashSet) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            g gVarA = a(str2);
            if (gVarA != null && gVarA.a()) {
                linkedHashSet.add(gVarA);
            }
        }
    }

    public boolean a() {
        int i9;
        return !TextUtils.isEmpty(this.f8876a) && (i9 = this.f8877b) > 0 && i9 <= 65535;
    }

    public static boolean a(String str, int i9) {
        return !TextUtils.isEmpty(str) && i9 > 0 && i9 <= 65535;
    }
}

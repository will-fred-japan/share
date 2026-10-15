package R7;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p056h5.C0598e;
import y7.n;
import y7.p;

/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes2.dex */
public class e extends p142s2.j {
    public static String B(String str) {
        List listY;
        int length;
        Comparable comparable;
        String strSubstring;
        kotlin.jvm.internal.k.e(str, "<this>");
        c cVar = new c(str);
        if (cVar.hasNext()) {
            Object next = cVar.next();
            if (cVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (cVar.hasNext()) {
                    arrayList.add(cVar.next());
                }
                listY = arrayList;
            } else {
                listY = C0598e.y(next);
            }
        } else {
            listY = p.f22408a;
        }
        List list = listY;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!l.V((String) obj)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(y7.i.E(arrayList2));
        Iterator it = arrayList2.iterator();
        while (true) {
            length = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length2 = str2.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!p199z2.b.E(str2.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str2.length();
            }
            arrayList3.add(Integer.valueOf(length));
        }
        Iterator it2 = arrayList3.iterator();
        if (it2.hasNext()) {
            comparable = (Comparable) it2.next();
            while (it2.hasNext()) {
                Comparable comparable2 = (Comparable) it2.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listY.size();
        int size = listY.size() - 1;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            int i9 = length + 1;
            if (length < 0) {
                y7.h.D();
                throw null;
            }
            String str3 = (String) obj2;
            if ((length == 0 || length == size) && l.V(str3)) {
                strSubstring = null;
            } else {
                kotlin.jvm.internal.k.e(str3, "<this>");
                if (iIntValue < 0) {
                    throw new IllegalArgumentException(defpackage.f.b(iIntValue, "Requested character count ", " is less than zero.").toString());
                }
                int length4 = str3.length();
                if (iIntValue <= length4) {
                    length4 = iIntValue;
                }
                strSubstring = str3.substring(length4);
                kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
            }
            if (strSubstring != null) {
                arrayList4.add(strSubstring);
            }
            length = i9;
        }
        StringBuilder sb = new StringBuilder(length3);
        n.K(arrayList4, sb, "\n", "", "", "...", null);
        return sb.toString();
    }

    public static String C(String str) {
        List listY;
        kotlin.jvm.internal.k.e(str, "<this>");
        if (l.V(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        c cVar = new c(str);
        if (cVar.hasNext()) {
            Object next = cVar.next();
            if (cVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (cVar.hasNext()) {
                    arrayList.add(cVar.next());
                }
                listY = arrayList;
            } else {
                listY = C0598e.y(next);
            }
        } else {
            listY = p.f22408a;
        }
        int length = str.length();
        listY.size();
        int size = listY.size() - 1;
        ArrayList arrayList2 = new ArrayList();
        int i9 = 0;
        for (Object obj : listY) {
            int i10 = i9 + 1;
            String strSubstring = null;
            if (i9 < 0) {
                y7.h.D();
                throw null;
            }
            String str2 = (String) obj;
            if ((i9 != 0 && i9 != size) || !l.V(str2)) {
                int length2 = str2.length();
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        i11 = -1;
                        break;
                    }
                    if (!p199z2.b.E(str2.charAt(i11))) {
                        break;
                    }
                    i11++;
                }
                if (i11 != -1 && i.M(str2, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, i11, false)) {
                    strSubstring = str2.substring(HiAnalyticsConstant.REPORT_VAL_SEPARATOR.length() + i11);
                    kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList2.add(strSubstring);
            }
            i9 = i10;
        }
        StringBuilder sb = new StringBuilder(length);
        n.K(arrayList2, sb, "\n", "", "", "...", null);
        return sb.toString();
    }
}

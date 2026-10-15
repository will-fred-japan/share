package cn.jiguang.commons.a;

import android.text.TextUtils;
import cn.jpush.android.service.WakedResultReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class ki {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f10360a = {120, 101};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f10361b = Pattern.compile("^zygote[0-9]*$");

    private static int a(LinkedList<String> linkedList, String str, int i9) {
        int iIndexOf = linkedList.indexOf(str);
        if (iIndexOf == -1) {
            iIndexOf = linkedList.indexOf(str.toLowerCase(Locale.ENGLISH));
        }
        return iIndexOf == -1 ? i9 : iIndexOf;
    }

    private static ad a(String str, Map<String, Integer> map) {
        String[] strArrSplit;
        int length;
        String str2;
        if (TextUtils.isEmpty(str) || (length = (strArrSplit = str.split("\\s+")).length) < 3) {
            return null;
        }
        try {
            ad adVar = new ad();
            if (map == null || map.isEmpty()) {
                adVar.f9615a = strArrSplit[0];
                adVar.f9616b = strArrSplit[1];
                adVar.f9617c = strArrSplit[2];
                str2 = strArrSplit[length - 1];
            } else {
                adVar.f9615a = strArrSplit[map.get("USER").intValue()];
                adVar.f9616b = strArrSplit[map.get("PID").intValue()];
                adVar.f9617c = strArrSplit[map.get("PPID").intValue()];
                str2 = strArrSplit[map.get("NAME").intValue()];
            }
            adVar.f9618d = str2;
            return adVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<ad> a(int i9) {
        HashMap map;
        List<ad> list;
        boolean z8;
        try {
            List<String> listA = kp.a(new String[]{jr.a(f10360a)}, 1);
            if (listA == null || listA.isEmpty()) {
                return null;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            String strRemove = listA.remove(0);
            if (TextUtils.isEmpty(strRemove)) {
                map = null;
                list = null;
            } else {
                LinkedList linkedList = new LinkedList();
                Collections.addAll(linkedList, strRemove.split("\\s+"));
                int size = linkedList.size() - 1;
                map = new HashMap();
                int iA = a(linkedList, "USER", 0);
                int iA2 = a(linkedList, "PID", 1);
                list = null;
                try {
                    int iA3 = a(linkedList, "PPID", 2);
                    int iA4 = a(linkedList, "NAME", size);
                    if (iA == 0 && iA2 == 1 && iA3 == 2 && iA4 == size) {
                        map = null;
                    } else {
                        map.put("USER", Integer.valueOf(iA));
                        map.put("PID", Integer.valueOf(iA2));
                        map.put("PPID", Integer.valueOf(iA3));
                        map.put("NAME", Integer.valueOf(iA4));
                    }
                } catch (Throwable unused) {
                    return list;
                }
            }
            Iterator<String> it = listA.iterator();
            while (it.hasNext()) {
                ad adVarA = a(it.next(), map);
                if (adVarA != null) {
                    if (i9 != 3) {
                        String str = adVarA.f9617c;
                        if ("0".equals(str) || "1".equals(str) || WakedResultReceiver.WAKE_TYPE_KEY.equals(str)) {
                            if (f10361b.matcher(adVarA.f9618d).matches()) {
                                hashSet.add(adVarA.f9616b);
                            }
                        }
                    }
                    if (!"ps".equals(adVarA.f9618d)) {
                        arrayList.add(adVarA);
                    }
                }
            }
            if (i9 != 1 || hashSet.isEmpty()) {
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            for (boolean z9 = false; !z9; z9 = z8) {
                Iterator it2 = arrayList.iterator();
                z8 = true;
                while (it2.hasNext()) {
                    ad adVar = (ad) it2.next();
                    if (hashSet.contains(adVar.f9617c)) {
                        arrayList2.add(adVar);
                        hashSet.add(adVar.f9616b);
                        it2.remove();
                        z8 = false;
                    }
                }
            }
            return arrayList2;
        } catch (Throwable unused2) {
            return null;
        }
    }
}

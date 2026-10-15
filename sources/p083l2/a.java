package p083l2;

import A1.b;
import R1.c;
import R1.f;
import W5.e;
import android.app.Application;
import android.text.TextUtils;
import com.huawei.agconnect.exception.AGCServerException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import p061i1.h;
import p099n1.d;

/* JADX INFO: compiled from: LocalLogUpload.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, f> f20017b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f20018a;

    public final void a(long j, long j8, boolean z8) {
        f fVar;
        int i9;
        Iterator it;
        String str;
        int i10;
        int size;
        String str2;
        LinkedList linkedList;
        Iterator it2;
        c cVar;
        if (j <= 0 || j8 <= 0 || j8 < j) {
            return;
        }
        if ((!z8 || d.b(this.f20018a)) && d.a(this.f20018a) && h.h()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strM = e.m(new StringBuilder(), j + j8, "");
            if (TextUtils.isEmpty(strM)) {
                fVar = null;
            } else {
                ConcurrentHashMap<String, f> concurrentHashMap = f20017b;
                if (concurrentHashMap.containsKey(strM)) {
                    fVar = concurrentHashMap.get(strM);
                } else {
                    f fVar2 = new f();
                    fVar2.f3985a = 0L;
                    concurrentHashMap.put(strM, fVar2);
                    fVar = fVar2;
                }
            }
            if (fVar != null && jCurrentTimeMillis - fVar.f3985a >= 600000) {
                fVar.f3985a = jCurrentTimeMillis;
                List<String> list = c.f20019D;
                c cVar2 = c.b.f20050a;
                cVar2.getClass();
                if (D4.f.a.f1924a.f1919g) {
                    try {
                        HashMap map = new HashMap(2);
                        List<String> list2 = cVar2.f20023B;
                        if (list2 == null) {
                            return;
                        }
                        for (String str3 : list2) {
                            map.put(str3, c.k(str3));
                        }
                        Iterator it3 = map.entrySet().iterator();
                        int i11 = 0;
                        while (it3.hasNext()) {
                            Map.Entry entry = (Map.Entry) it3.next();
                            List list3 = (List) entry.getValue();
                            String str4 = (String) entry.getKey();
                            int i12 = i11;
                            while (true) {
                                List<c> listG = cVar2.g(j, j8, list3, i12);
                                List list4 = list3;
                                i9 = i12;
                                if (b.d0(listG)) {
                                    it = it3;
                                    str = str4;
                                    i10 = AGCServerException.AUTHENTICATION_INVALID;
                                    size = 0;
                                } else {
                                    size = listG.size();
                                    JSONArray jSONArray = new JSONArray();
                                    LinkedList linkedList2 = new LinkedList();
                                    long j9 = -1;
                                    for (c cVar3 : listG) {
                                        try {
                                            try {
                                                if (j9 == -1) {
                                                    j9 = cVar3.f3976e;
                                                    str2 = str4;
                                                    linkedList = linkedList2;
                                                } else {
                                                    String str5 = str4;
                                                    try {
                                                        if (cVar3.f3976e != j9) {
                                                            cVar = cVar3;
                                                            linkedList = linkedList2;
                                                            jSONArray = jSONArray;
                                                            str2 = str5;
                                                            try {
                                                                if (cVar2.j(str2, jSONArray, null, j9, true)) {
                                                                    c.d(linkedList);
                                                                    linkedList.clear();
                                                                }
                                                                j9 = cVar.f3976e;
                                                                jSONArray = new JSONArray();
                                                            } catch (Exception unused) {
                                                                it2 = it3;
                                                            }
                                                        } else {
                                                            linkedList = linkedList2;
                                                            str2 = str5;
                                                        }
                                                        it2 = it3;
                                                        long j10 = cVar.f3972a;
                                                        linkedList.add(cVar);
                                                        jSONArray.put(cVar.f3975d);
                                                    } catch (Exception unused2) {
                                                        it2 = it3;
                                                        linkedList = linkedList2;
                                                        jSONArray = jSONArray;
                                                        str2 = str5;
                                                    }
                                                    LinkedList linkedList3 = linkedList;
                                                    str4 = str2;
                                                    jSONArray = jSONArray;
                                                    linkedList2 = linkedList3;
                                                    it3 = it2;
                                                }
                                                long j11 = cVar.f3972a;
                                                linkedList.add(cVar);
                                                jSONArray.put(cVar.f3975d);
                                            } catch (Exception unused3) {
                                            }
                                            cVar = cVar3;
                                            it2 = it3;
                                        } catch (Exception unused4) {
                                            LinkedList linkedList4 = linkedList2;
                                            jSONArray = jSONArray;
                                            str2 = str4;
                                            linkedList = linkedList4;
                                        }
                                        LinkedList linkedList5 = linkedList;
                                        str4 = str2;
                                        jSONArray = jSONArray;
                                        linkedList2 = linkedList5;
                                        it3 = it2;
                                    }
                                    LinkedList linkedList6 = linkedList2;
                                    JSONArray jSONArray2 = jSONArray;
                                    str = str4;
                                    it = it3;
                                    if (!cVar2.j(str, jSONArray2, null, j9, true) || c.d(linkedList6) <= 0) {
                                        i10 = AGCServerException.AUTHENTICATION_INVALID;
                                        i9 += AGCServerException.AUTHENTICATION_INVALID;
                                    } else {
                                        i10 = AGCServerException.AUTHENTICATION_INVALID;
                                    }
                                }
                                if (size != i10) {
                                    break;
                                }
                                str4 = str;
                                list3 = list4;
                                i12 = i9;
                                it3 = it;
                            }
                            i11 = i9;
                            it3 = it;
                        }
                    } catch (Throwable unused5) {
                    }
                }
            }
        }
    }
}

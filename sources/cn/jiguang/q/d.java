package cn.jiguang.q;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static List<cn.jiguang.o.c> a(String str, String str2, String str3, int i9) {
        List<cn.jiguang.o.c> arrayList;
        cn.jiguang.o.c cVar = new cn.jiguang.o.c();
        cVar.f10665a = str2;
        cVar.f10666b = str3;
        if (str == null || TextUtils.isEmpty(str)) {
            arrayList = null;
        } else {
            arrayList = c.a(str);
            cn.jiguang.x.f.c("JWakePackageHelper", "cache cmd wakeTargets:" + arrayList);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).f10665a.equals(str2) && arrayList.get(size).f10666b.equals(str3)) {
                    arrayList.remove(size);
                    break;
                }
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (i9 == 1) {
            arrayList.add(cVar);
        }
        return arrayList;
    }
}

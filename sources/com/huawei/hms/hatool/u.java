package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b1> f15318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15321d;

    public u(List<b1> list, String str, String str2, String str3) {
        this.f15318a = list;
        this.f15319b = str;
        this.f15320c = str2;
        this.f15321d = str3;
    }

    public void a() {
        if (!"_default_config_tag".equals(this.f15320c)) {
            a(this.f15318a, this.f15320c, this.f15319b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (b1 b1Var : this.f15318a) {
            String strC = b1Var.c();
            if (TextUtils.isEmpty(strC) || "oper".equals(strC)) {
                arrayList4.add(b1Var);
            } else if ("maint".equals(strC)) {
                arrayList.add(b1Var);
            } else if ("preins".equals(strC)) {
                arrayList2.add(b1Var);
            } else if ("diffprivacy".equals(strC)) {
                arrayList3.add(b1Var);
            }
        }
        a(arrayList4, "oper", "_default_config_tag");
        a(arrayList, "maint", "_default_config_tag");
        a(arrayList2, "preins", "_default_config_tag");
        a(arrayList3, "diffprivacy", "_default_config_tag");
    }

    private void a(List<b1> list, String str, String str2) {
        String str3;
        String str4;
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        int i9 = 0;
        while (i9 < size) {
            int i10 = i9 * 500;
            List<b1> listSubList = list.subList(i10, Math.min(list.size(), i10 + 500));
            String strReplace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jB = ((long) a1.b(str2, str)) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (b1 b1Var : listSubList) {
                if (!c0.a(b1Var.b(), jCurrentTimeMillis, jB)) {
                    arrayList.add(b1Var);
                }
            }
            if (arrayList.size() > 0) {
                str3 = str;
                str4 = str2;
                new l0(str4, str3, this.f15321d, arrayList, strReplace).a();
            } else {
                str3 = str;
                str4 = str2;
                v.e("hmsSdk", "No data to report handler");
            }
            i9++;
            str2 = str4;
            str = str3;
        }
    }
}

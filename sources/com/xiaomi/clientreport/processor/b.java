package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bw;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements IPerfProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f16934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f21a;

    public b(Context context) {
        this.f16934a = context;
    }

    private String c(com.xiaomi.clientreport.data.a aVar) {
        String strB = b(aVar);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        for (int i9 = 0; i9 < 20; i9++) {
            String str = strB + i9;
            if (bw.m135a(this.f16934a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() throws Throwable {
        bw.a(this.f16934a, "perf", "perfUploading");
        File[] fileArrM136a = bw.m136a(this.f16934a, "perfUploading");
        if (fileArrM136a == null || fileArrM136a.length <= 0) {
            return;
        }
        for (File file : fileArrM136a) {
            if (file != null) {
                List<String> listA = e.a(this.f16934a, file.getAbsolutePath());
                file.delete();
                a(listA);
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> map = this.f21a;
        if (map == null) {
            return;
        }
        if (map.size() > 0) {
            Iterator<String> it = this.f21a.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, com.xiaomi.clientreport.data.a> map2 = this.f21a.get(it.next());
                if (map2 != null && map2.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[map2.size()];
                    map2.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f21a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> map) {
        this.f21a = map;
    }

    public void a(List<String> list) {
        bw.a(this.f16934a, list);
    }

    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        String strC = c(aVarArr[0]);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        e.a(strC, aVarArr);
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        String str;
        int i9 = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i9 > 0 && !TextUtils.isEmpty(str2)) {
            str = String.valueOf(i9) + "#" + str2;
        } else {
            str = "";
        }
        File file = new File(this.f16934a.getFilesDir(), "perf");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* JADX INFO: renamed from: a */
    public void mo23a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f21a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String strA = a((com.xiaomi.clientreport.data.a) perfClientReport);
            String strA2 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> map = this.f21a.get(strA);
            if (map == null) {
                map = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) map.get(strA2);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            map.put(strA2, perfClientReport);
            this.f21a.put(strA, map);
        }
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }
}

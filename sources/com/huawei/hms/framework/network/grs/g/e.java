package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f15092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f15093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONArray f15094c;

        public a(long j, ArrayList arrayList, JSONArray jSONArray) {
            this.f15092a = j;
            this.f15093b = arrayList;
            this.f15094c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.framework.network.grs.g.j.a aVar = new com.huawei.hms.framework.network.grs.g.j.a();
            aVar.put("total_time", this.f15092a);
            Iterator it = this.f15093b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (this.f15093b.size() <= 0) {
                        break;
                    }
                    ArrayList arrayList = this.f15093b;
                    d dVar = (d) arrayList.get(arrayList.size() - 1);
                    aVar.put(e.b(dVar));
                    this.f15093b.remove(dVar);
                    break;
                }
                d dVar2 = (d) it.next();
                if (dVar2.o() || dVar2.m()) {
                    aVar.put(e.b(dVar2));
                    it.remove();
                    break;
                }
            }
            if (this.f15093b.size() > 0) {
                Iterator it2 = this.f15093b.iterator();
                while (it2.hasNext()) {
                    this.f15094c.put(new JSONObject(e.b((d) it2.next())));
                }
            }
            if (this.f15094c.length() > 0) {
                aVar.put("failed_info", this.f15094c.toString());
            }
            Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
            HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception excD = dVar.d();
        if (excD != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(excD));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, excD.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(excD.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, dVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.l()).getHost());
        } catch (MalformedURLException e9) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e9);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }

    public static void a(ArrayList<d> arrayList, long j, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReport(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j, arrayList, jSONArray));
    }
}

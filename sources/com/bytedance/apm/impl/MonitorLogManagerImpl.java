package com.bytedance.apm.impl;

import R1.c;
import android.text.TextUtils;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p047g3.b;
import p061i1.h;
import p063i3.a;
import p167v3.d;

/* JADX INFO: loaded from: classes.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    private static a<? extends c> getLogStoreByType(String str) {
        return TextUtils.equals(str, "network") ? (a) b.a.f18871a.f18867b.get(R1.a.class) : (a) b.a.f18871a.f18867b.get(c.class);
    }

    private static String packLog(JSONArray jSONArray, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", jSONArray);
            JSONObject jSONObjectD = h.d();
            if (jSONObjectD == null) {
                return "";
            }
            JSONObject jSONObject2 = new JSONObject(jSONObjectD.toString());
            A1.b.U(jSONObject2, p047g3.a.C0202a.f18865a.a(j));
            jSONObject2.put("debug_fetch", 1);
            jSONObject.put("header", jSONObject2);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String str, String str2) {
        a<? extends c> logStoreByType = getLogStoreByType(str);
        if (logStoreByType != null) {
            logStoreByType.k(str2);
        }
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long j, long j8, String str, d dVar) {
        List<c> listF;
        if (dVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        p055h3.a logStoreByType = getLogStoreByType(str);
        if (logStoreByType == null) {
            dVar.a();
            return;
        }
        synchronized (logStoreByType) {
            if (TextUtils.isEmpty(str)) {
                listF = Collections.EMPTY_LIST;
            } else {
                try {
                    String[] strArr = {String.valueOf(j), String.valueOf(j8), str};
                    String[] strArrSplit = "0,100".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    listF = logStoreByType.f("timestamp >= ? AND timestamp <= ?  AND type2 = ? ", strArr, "_id ASC " + (strArrSplit.length == 2 ? " LIMIT " + strArrSplit[1] + " OFFSET " + strArrSplit[0] : ""), logStoreByType);
                } catch (Throwable unused) {
                    listF = Collections.EMPTY_LIST;
                }
            }
        }
        if (A1.b.d0(listF)) {
            dVar.a();
            return;
        }
        JSONArray jSONArray = new JSONArray();
        LinkedList linkedList = new LinkedList();
        long j9 = -1;
        for (c cVar : listF) {
            try {
                if (j9 == -1) {
                    j9 = cVar.f3976e;
                } else if (cVar.f3976e != j9) {
                    break;
                }
                jSONArray.put(cVar.f3975d);
                linkedList.add(Long.valueOf(cVar.f3972a));
            } catch (Exception unused2) {
            }
        }
        packLog(jSONArray, j9);
        A1.b.m(linkedList, Constants.ACCEPT_TIME_SEPARATOR_SP);
        dVar.a();
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return (LinkedList) p132r1.a.a().f21104a.f20907b;
    }
}

package com.bytedance.apm.impl;

import D1.d;
import N1.e;
import Q.a;
import android.content.Context;
import com.bytedance.services.apm.api.IApmAgent;
import org.json.JSONException;
import org.json.JSONObject;
import p061i1.c;
import p061i1.h;
import p133r2.b;

/* JADX INFO: loaded from: classes.dex */
public class ApmAgentServiceImpl implements IApmAgent {
    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorCommonLog(String str, JSONObject jSONObject) {
        b.f21107i.a(new a(2, str, A1.b.Q0(jSONObject)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        b.f21107i.a(new p061i1.a(str, jSONObject, A1.b.Q0(jSONObject2)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(p167v3.a aVar) {
        String str = aVar.f21891a;
        e eVar = new e();
        eVar.f3160b = str;
        eVar.f3161c = aVar.f21892b;
        eVar.f3159a = aVar.f21893c;
        JSONObject jSONObject = new JSONObject();
        if (jSONObject.isNull("timestamp")) {
            try {
                jSONObject.put("timestamp", System.currentTimeMillis());
            } catch (JSONException e9) {
                e9.printStackTrace();
            }
        }
        b.f21107i.a(new a(3, eVar, jSONObject));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorExceptionLog(String str, JSONObject jSONObject) {
        b.f21107i.a(new d(str, A1.b.Q0(jSONObject), 4, false));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorLog(String str, JSONObject jSONObject) {
        b.f21107i.a(new a(2, str, A1.b.Q0(jSONObject)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusAndDuration(String str, int i9, JSONObject jSONObject, JSONObject jSONObject2) {
        b.f21107i.a(new p061i1.b(str, i9, jSONObject, A1.b.Q0(jSONObject2)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void reportLegacyMonitorLog(Context context, long j, long j8, boolean z8) {
        b.f21107i.d(new c(h.f19229a, j, j8, z8));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        b.f21107i.a(new p061i1.d(str, jSONObject, jSONObject2, A1.b.Q0(jSONObject3)));
    }

    @Override // com.bytedance.services.apm.api.IApmAgent
    public void monitorStatusRate(String str, int i9, JSONObject jSONObject) {
    }
}

package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l1 f15334b;

    public z0(String str) {
        this.f15333a = str;
        this.f15334b = new l1(str);
        s.c().a(this.f15333a, this.f15334b);
    }

    private s0 b(int i9) {
        if (i9 == 0) {
            return this.f15334b.c();
        }
        if (i9 == 1) {
            return this.f15334b.b();
        }
        if (i9 == 2) {
            return this.f15334b.d();
        }
        if (i9 != 3) {
            return null;
        }
        return this.f15334b.a();
    }

    private boolean c(int i9) {
        String str;
        if (i9 != 2) {
            s0 s0VarB = b(i9);
            if (s0VarB != null && !TextUtils.isEmpty(s0VarB.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i9;
        } else {
            if ("_default_config_tag".equals(this.f15333a)) {
                return true;
            }
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        v.e("hmsSdk", str);
        return false;
    }

    public void a(int i9) {
        v.d("hmsSdk", "onReport. TAG: " + this.f15333a + ", TYPE: " + i9);
        g0.a().a(this.f15333a, i9);
    }

    public void a(int i9, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onEvent. TAG: " + this.f15333a + ", TYPE: " + i9 + ", eventId : " + str);
        if (e1.a(str) || !c(i9)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f15333a + ", TYPE: " + i9);
            return;
        }
        if (!e1.a(linkedHashMap)) {
            v.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f15333a + ", TYPE: " + i9);
            linkedHashMap = null;
        }
        g0.a().a(this.f15333a, i9, str, linkedHashMap);
    }

    public void b(int i9, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onStreamEvent. TAG: " + this.f15333a + ", TYPE: " + i9 + ", eventId : " + str);
        if (e1.a(str) || !c(i9)) {
            v.e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f15333a + ", TYPE: " + i9);
            return;
        }
        if (!e1.a(linkedHashMap)) {
            v.e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f15333a + ", TYPE: " + i9);
            linkedHashMap = null;
        }
        g0.a().b(this.f15333a, i9, str, linkedHashMap);
    }

    public void a(Context context, String str, String str2) {
        v.d("hmsSdk", "onEvent(context). TAG: " + this.f15333a + ", eventId : " + str);
        if (context == null) {
            v.e("hmsSdk", "context is null in onevent ");
            return;
        }
        if (e1.a(str) || !c(0)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f15333a);
        } else {
            if (!e1.a("value", str2, 65536)) {
                v.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f15333a);
                str2 = "";
            }
            g0.a().a(this.f15333a, context, str, str2);
        }
    }

    public void b(s0 s0Var) {
        v.a("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f15333a);
        if (s0Var != null) {
            this.f15334b.b(s0Var);
        } else {
            this.f15334b.b(null);
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }

    public void a(s0 s0Var) {
        v.a("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f15333a);
        if (s0Var != null) {
            this.f15334b.a(s0Var);
        } else {
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f15334b.a((s0) null);
        }
    }
}

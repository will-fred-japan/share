package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ClientSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Scope> f14954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f14956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SubAppInfo f14958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f14959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14960i;
    private String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14961k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f14952a = str;
        this.f14953b = str2;
        this.f14954c = list;
        this.f14955d = str3;
        this.f14956e = list2;
    }

    public List<String> getApiName() {
        return this.f14956e;
    }

    public String getAppID() {
        return this.f14955d;
    }

    public String getClientClassName() {
        return this.f14953b;
    }

    public String getClientPackageName() {
        return this.f14952a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f14959h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.f14957f;
    }

    public String getInnerHmsPkg() {
        return this.j;
    }

    public List<Scope> getScopes() {
        return this.f14954c;
    }

    public SubAppInfo getSubAppID() {
        return this.f14958g;
    }

    public boolean isHasActivity() {
        return this.f14960i;
    }

    public boolean isUseInnerHms() {
        return this.f14961k;
    }

    public void setApiName(List<String> list) {
        this.f14956e = list;
    }

    public void setAppID(String str) {
        this.f14955d = str;
    }

    public void setClientClassName(String str) {
        this.f14953b = str;
    }

    public void setClientPackageName(String str) {
        this.f14952a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f14959h = new WeakReference<>(activity);
        this.f14960i = true;
    }

    public void setCpID(String str) {
        this.f14957f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f14954c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f14958g = subAppInfo;
    }

    public void setUseInnerHms(boolean z8) {
        this.f14961k = z8;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f14958g = subAppInfo;
    }
}

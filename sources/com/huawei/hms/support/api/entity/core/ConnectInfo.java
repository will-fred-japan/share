package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConnectInfo implements IMessageEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Packed
    private List<String> f15521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Packed
    private List<Scope> f15522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Packed
    private String f15523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Packed
    private String f15524d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f15521a;
    }

    public String getFingerprint() {
        return this.f15523c;
    }

    public List<Scope> getScopeList() {
        return this.f15522b;
    }

    public String getSubAppID() {
        return this.f15524d;
    }

    public void setApiNameList(List<String> list) {
        this.f15521a = list;
    }

    public void setFingerprint(String str) {
        this.f15523c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f15522b = list;
    }

    public void setSubAppID(String str) {
        this.f15524d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f15521a = list;
        this.f15522b = list2;
        this.f15523c = str;
        this.f15524d = str2;
    }
}

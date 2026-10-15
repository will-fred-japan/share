package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SubscribeResult extends Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<SubscribedItem> f15421b;

    public String getErrorMsg() {
        return this.f15420a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.f15421b;
    }

    public void setErrorMsg(String str) {
        this.f15420a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.f15421b = list;
    }
}

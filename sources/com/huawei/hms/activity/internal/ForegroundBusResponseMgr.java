package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundBusResponseMgr {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ForegroundBusResponseMgr f14733b = new ForegroundBusResponseMgr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, BusResponseCallback> f14734a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return f14733b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f14734a) {
            busResponseCallback = this.f14734a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.f14734a) {
            try {
                if (!this.f14734a.containsKey(str)) {
                    this.f14734a.put(str, busResponseCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f14734a) {
            this.f14734a.remove(str);
        }
    }
}

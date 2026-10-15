package com.huawei.hms.aaid.plugin;

/* JADX INFO: loaded from: classes.dex */
public class ProxyCenter {
    private PushProxy proxy;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ProxyCenter f14711a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return a.f14711a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}

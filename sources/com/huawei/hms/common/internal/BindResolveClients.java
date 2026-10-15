package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class BindResolveClients {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f14949b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<ResolveClientBean> f14950a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final BindResolveClients f14951a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.f14951a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean zContains;
        synchronized (f14949b) {
            zContains = this.f14950a.contains(resolveClientBean);
        }
        return zContains;
    }

    public void notifyClientReconnect() {
        synchronized (f14949b) {
            try {
                ListIterator<ResolveClientBean> listIterator = this.f14950a.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.next().clientReconnect();
                }
                this.f14950a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f14949b) {
            try {
                if (!this.f14950a.contains(resolveClientBean)) {
                    this.f14950a.add(resolveClientBean);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f14949b) {
            try {
                if (this.f14950a.contains(resolveClientBean)) {
                    ListIterator<ResolveClientBean> listIterator = this.f14950a.listIterator();
                    while (listIterator.hasNext()) {
                        if (resolveClientBean.equals(listIterator.next())) {
                            listIterator.remove();
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unRegisterAll() {
        synchronized (f14949b) {
            this.f14950a.clear();
        }
    }

    private BindResolveClients() {
        this.f14950a = new ArrayList<>();
    }
}

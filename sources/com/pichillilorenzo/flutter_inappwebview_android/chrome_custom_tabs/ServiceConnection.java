package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.content.ComponentName;
import java.lang.ref.WeakReference;
import p130r.d;
import p130r.h;

/* JADX INFO: loaded from: classes.dex */
public class ServiceConnection extends h {
    private WeakReference<ServiceConnectionCallback> mConnectionCallback;

    public ServiceConnection(ServiceConnectionCallback serviceConnectionCallback) {
        this.mConnectionCallback = new WeakReference<>(serviceConnectionCallback);
    }

    @Override // p130r.h
    public void onCustomTabsServiceConnected(ComponentName componentName, d dVar) {
        ServiceConnectionCallback serviceConnectionCallback = this.mConnectionCallback.get();
        if (serviceConnectionCallback != null) {
            serviceConnectionCallback.onServiceConnected(dVar);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ServiceConnectionCallback serviceConnectionCallback = this.mConnectionCallback.get();
        if (serviceConnectionCallback != null) {
            serviceConnectionCallback.onServiceDisconnected();
        }
    }
}

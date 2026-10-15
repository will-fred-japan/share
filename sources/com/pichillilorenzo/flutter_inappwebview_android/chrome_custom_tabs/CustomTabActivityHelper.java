package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;
import p130r.b;
import p130r.d;
import p130r.e;
import p130r.h;
import p130r.j;
import p139s.c;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabActivityHelper implements ServiceConnectionCallback {
    private d mClient;
    private h mConnection;
    private ConnectionCallback mConnectionCallback;
    private b mCustomTabsCallback;
    private j mCustomTabsSession;

    public interface ConnectionCallback {
        void onCustomTabsConnected();

        void onCustomTabsDisconnected();
    }

    public static boolean isAvailable(Activity activity) {
        return CustomTabsHelper.getPackageNameToUse(activity) != null;
    }

    public static void openCustomTab(Activity activity, Intent intent, Uri uri, Map<String, String> map, Uri uri2, int i9) {
        intent.setData(uri);
        if (map != null) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            intent.putExtra("com.android.browser.headers", bundle);
        }
        if (uri2 != null) {
            intent.putExtra("android.intent.extra.REFERRER", uri2);
        }
        activity.startActivityForResult(intent, i9);
    }

    public static void openTrustedWebActivity(Activity activity, c cVar, Uri uri, Map<String, String> map, Uri uri2, int i9) {
        openCustomTab(activity, cVar.f21171a, uri, map, uri2, i9);
    }

    public boolean bindCustomTabsService(Activity activity) {
        if (this.mClient != null) {
            return true;
        }
        String packageNameToUse = CustomTabsHelper.getPackageNameToUse(activity);
        if (packageNameToUse == null) {
            return false;
        }
        ServiceConnection serviceConnection = new ServiceConnection(this);
        this.mConnection = serviceConnection;
        serviceConnection.setApplicationContext(activity.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (packageNameToUse.isEmpty()) {
            throw new IllegalArgumentException("Service Intents must be explicit");
        }
        intent.setPackage(packageNameToUse);
        return activity.bindService(intent, serviceConnection, 33);
    }

    public j getSession() {
        d dVar = this.mClient;
        j jVar = null;
        if (dVar == null) {
            this.mCustomTabsSession = null;
        } else if (this.mCustomTabsSession == null) {
            p130r.c cVar = new p130r.c(this.mCustomTabsCallback);
            p006b.d dVar2 = dVar.f21068a;
            try {
                if (dVar2.i(cVar)) {
                    jVar = new j(dVar2, cVar, dVar.f21069b);
                }
            } catch (RemoteException unused) {
            }
            this.mCustomTabsSession = jVar;
        }
        return this.mCustomTabsSession;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        j session;
        if (this.mClient == null || (session = getSession()) == null) {
            return false;
        }
        try {
            return session.f21086b.v(session.f21087c, uri, session.a(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ServiceConnectionCallback
    public void onServiceConnected(d dVar) {
        this.mClient = dVar;
        dVar.getClass();
        try {
            dVar.f21068a.G();
        } catch (RemoteException unused) {
        }
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsConnected();
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ServiceConnectionCallback
    public void onServiceDisconnected() {
        this.mClient = null;
        this.mCustomTabsSession = null;
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsDisconnected();
        }
    }

    public void setConnectionCallback(ConnectionCallback connectionCallback) {
        this.mConnectionCallback = connectionCallback;
    }

    public void setCustomTabsCallback(b bVar) {
        this.mCustomTabsCallback = bVar;
    }

    public void unbindCustomTabsService(Activity activity) {
        h hVar = this.mConnection;
        if (hVar == null) {
            return;
        }
        activity.unbindService(hVar);
        this.mClient = null;
        this.mCustomTabsSession = null;
        this.mConnection = null;
    }

    public static void openCustomTab(Activity activity, e eVar, Uri uri, Map<String, String> map, Uri uri2, int i9) {
        openCustomTab(activity, eVar.f21070a, uri, map, uri2, i9);
    }
}

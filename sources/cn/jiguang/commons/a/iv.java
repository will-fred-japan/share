package cn.jiguang.commons.a;

import android.net.ConnectivityManager;
import android.net.Network;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class iv extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f10229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f10230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ JSONObject f10231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f10232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f10233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ConnectivityManager f10234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ it f10235g;

    public iv(it itVar, String str, String str2, JSONObject jSONObject, String str3, String str4, ConnectivityManager connectivityManager) {
        this.f10235g = itVar;
        this.f10229a = str;
        this.f10230b = str2;
        this.f10231c = jSONObject;
        this.f10232d = str3;
        this.f10233e = str4;
        this.f10234f = connectivityManager;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        try {
            try {
                ee.a("JUaidManager", "net avail");
                ey.b().a((Object) 1049);
                this.f10235g.a(network, this.f10229a, this.f10230b, this.f10231c, this.f10232d, this.f10233e);
            } finally {
                this.f10234f.unregisterNetworkCallback(this);
            }
        } catch (Throwable unused) {
            it itVar = this.f10235g;
            it.e();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        try {
            try {
                ee.a("JUaidManager", "Network unavailable");
                this.f10235g.b(this.f10229a, this.f10230b, this.f10231c, this.f10232d, this.f10233e);
                ey.b().a((Object) 1050);
            } catch (Throwable unused) {
                it itVar = this.f10235g;
                it.e();
            }
        } finally {
            this.f10234f.unregisterNetworkCallback(this);
        }
    }
}

package cn.jiguang.commons.a;

import android.bluetooth.BluetoothAdapter;

/* JADX INFO: loaded from: classes.dex */
final class gv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BluetoothAdapter f10135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ gs f10136c;

    public gv(gs gsVar, long j, BluetoothAdapter bluetoothAdapter) {
        this.f10136c = gsVar;
        this.f10134a = j;
        this.f10135b = bluetoothAdapter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f10136c.f10120a.get()) {
            ee.a("BluetoothScanner", "scan timeout after " + this.f10134a + "ms");
            this.f10136c.a(this.f10135b);
        }
    }
}

package cn.jiguang.commons.a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public final class gs {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f10126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f10127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile int f10128i;
    private final HandlerThread j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Handler f10129k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f10120a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentLinkedQueue<Object> f10121b = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<BroadcastReceiver> f10122c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference<BluetoothAdapter> f10123d = new AtomicReference<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f10124e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f10125f = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ScanCallback f10130l = new gt(this);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final BluetoothAdapter.LeScanCallback f10131m = new gu(this);

    public gs() {
        HandlerThread handlerThread = new HandlerThread("jg_bt_scan");
        this.j = handlerThread;
        handlerThread.start();
        this.f10129k = new Handler(handlerThread.getLooper());
    }

    private void b() {
        BroadcastReceiver andSet;
        Context contextA = jg.a();
        if (contextA == null || (andSet = this.f10122c.getAndSet(null)) == null) {
            return;
        }
        contextA.unregisterReceiver(andSet);
    }

    public final ConcurrentLinkedQueue<Object> a() {
        return this.f10121b;
    }

    public final void a(BluetoothAdapter bluetoothAdapter) {
        if (this.f10120a.compareAndSet(true, false)) {
            Runnable runnable = this.f10126g;
            if (runnable != null) {
                this.f10129k.removeCallbacks(runnable);
            }
            try {
                BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    try {
                        bluetoothLeScanner.flushPendingScanResults(this.f10130l);
                    } catch (Throwable th) {
                        ee.d("BluetoothScanner", "flush failed:" + th.getMessage());
                    }
                    bluetoothLeScanner.stopScan(this.f10130l);
                }
                if (bluetoothAdapter.isDiscovering()) {
                    bluetoothAdapter.cancelDiscovery();
                }
                b();
                ee.a("BluetoothScanner", "all scans stopped, results:" + this.f10121b.size());
                synchronized (this.f10124e) {
                    this.f10125f = true;
                    this.f10124e.notifyAll();
                }
            } catch (Throwable th2) {
                try {
                    ee.d("BluetoothScanner", "stop scan failed:" + th2.getMessage());
                } finally {
                    synchronized (this.f10124e) {
                        this.f10125f = true;
                        this.f10124e.notifyAll();
                    }
                }
            }
        }
    }

    public final boolean a(long j) {
        synchronized (this.f10124e) {
            if (this.f10125f) {
                return true;
            }
            try {
                this.f10124e.wait(32000L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            return this.f10125f;
        }
    }

    public final boolean a(BluetoothAdapter bluetoothAdapter, long j, boolean z8, boolean z9) {
        Context contextA;
        if (!this.f10120a.compareAndSet(false, true)) {
            ee.d("BluetoothScanner", "scan already in progress");
            return false;
        }
        try {
            this.f10123d.set(bluetoothAdapter);
            this.f10121b.clear();
            this.f10127h = 0L;
            this.f10128i = -1;
            synchronized (this.f10124e) {
                this.f10125f = false;
            }
            if (!z8 && !z9) {
                ee.a("BluetoothScanner", "no scan sources enabled, skip");
                this.f10120a.set(false);
                synchronized (this.f10124e) {
                    this.f10125f = true;
                    this.f10124e.notifyAll();
                }
                return true;
            }
            if (z9 && (contextA = jg.a()) != null && this.f10122c.get() == null) {
                gw gwVar = new gw(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.device.action.FOUND");
                intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
                try {
                    kj.a(contextA, gwVar, intentFilter, null, this.f10129k, true);
                    this.f10122c.set(gwVar);
                } catch (Throwable th) {
                    ee.d("BluetoothScanner", "register receiver failed:" + th.getMessage());
                }
            }
            if (z8) {
                BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    ScanSettings.Builder reportDelay = new ScanSettings.Builder().setScanMode(2).setReportDelay(1000L);
                    reportDelay.setMatchMode(1).setNumOfMatches(3);
                    reportDelay.setLegacy(false).setPhy(255);
                    bluetoothLeScanner.startScan((List<ScanFilter>) null, reportDelay.build(), this.f10130l);
                    ee.a("BluetoothScanner", "ble scan started");
                } else {
                    ee.d("BluetoothScanner", "ble scanner is null");
                }
            }
            if (z9) {
                if (bluetoothAdapter.isDiscovering()) {
                    bluetoothAdapter.cancelDiscovery();
                }
                bluetoothAdapter.startDiscovery();
                ee.a("BluetoothScanner", "classic scan started");
            }
            gv gvVar = new gv(this, 30000L, bluetoothAdapter);
            this.f10126g = gvVar;
            this.f10129k.postDelayed(gvVar, 30000L);
            return true;
        } catch (Throwable th2) {
            ee.d("BluetoothScanner", "start scan failed:" + th2.getMessage());
            a(bluetoothAdapter);
            return false;
        }
        ee.d("BluetoothScanner", "start scan failed:" + th2.getMessage());
        a(bluetoothAdapter);
        return false;
    }
}

package cn.jiguang.commons.a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public final class gp {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile CountDownLatch f10117c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<BluetoothA2dp> f10115a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<BluetoothHeadset> f10116b = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BluetoothProfile.ServiceListener f10118d = new gq(this);

    public final int a(BluetoothDevice bluetoothDevice) {
        BluetoothA2dp bluetoothA2dp = this.f10115a.get();
        if (bluetoothA2dp == null || bluetoothDevice == null) {
            return 0;
        }
        try {
            return bluetoothA2dp.getConnectionState(bluetoothDevice);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("get A2DP state failed: "), "BluetoothProfileManager");
            return 0;
        }
    }

    public final int b(BluetoothDevice bluetoothDevice) {
        BluetoothHeadset bluetoothHeadset = this.f10116b.get();
        if (bluetoothHeadset == null || bluetoothDevice == null) {
            return 0;
        }
        try {
            return bluetoothHeadset.getConnectionState(bluetoothDevice);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("get headset state failed: "), "BluetoothProfileManager");
            return 0;
        }
    }

    public final List<BluetoothDevice> a() {
        ArrayList arrayList = new ArrayList();
        BluetoothA2dp bluetoothA2dp = this.f10115a.get();
        if (bluetoothA2dp != null) {
            try {
                List<BluetoothDevice> connectedDevices = bluetoothA2dp.getConnectedDevices();
                if (connectedDevices != null) {
                    arrayList.addAll(connectedDevices);
                }
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("get A2DP connected devices failed: "), "BluetoothProfileManager");
            }
        }
        BluetoothHeadset bluetoothHeadset = this.f10116b.get();
        if (bluetoothHeadset != null) {
            try {
                List<BluetoothDevice> connectedDevices2 = bluetoothHeadset.getConnectedDevices();
                if (connectedDevices2 != null) {
                    for (BluetoothDevice bluetoothDevice : connectedDevices2) {
                        if (!arrayList.contains(bluetoothDevice)) {
                            arrayList.add(bluetoothDevice);
                        }
                    }
                }
            } catch (Throwable th2) {
                defpackage.f.n(th2, new StringBuilder("get headset connected devices failed: "), "BluetoothProfileManager");
            }
        }
        return arrayList;
    }

    public final void a(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter != null) {
            BluetoothA2dp andSet = this.f10115a.getAndSet(null);
            if (andSet != null) {
                try {
                    bluetoothAdapter.closeProfileProxy(2, andSet);
                } catch (Throwable th) {
                    defpackage.f.n(th, new StringBuilder("close A2DP proxy failed: "), "BluetoothProfileManager");
                }
            }
            BluetoothHeadset andSet2 = this.f10116b.getAndSet(null);
            if (andSet2 != null) {
                try {
                    bluetoothAdapter.closeProfileProxy(1, andSet2);
                } catch (Throwable th2) {
                    defpackage.f.n(th2, new StringBuilder("close headset proxy failed: "), "BluetoothProfileManager");
                }
            }
            ee.a("BluetoothProfileManager", "profile proxies closed");
        }
    }

    public final void a(Context context, BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter == null || context == null) {
            return;
        }
        this.f10117c = new CountDownLatch(2);
        bluetoothAdapter.getProfileProxy(context, this.f10118d, 2);
        bluetoothAdapter.getProfileProxy(context, this.f10118d, 1);
        ee.a("BluetoothProfileManager", "profile proxies requested");
        try {
            ee.a("BluetoothProfileManager", "profile proxies ready: " + this.f10117c.await(3000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            ee.d("BluetoothProfileManager", "profile wait interrupted");
        }
    }
}

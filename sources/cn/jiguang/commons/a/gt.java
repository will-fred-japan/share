package cn.jiguang.commons.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import androidx.datastore.preferences.protobuf.C0524s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class gt extends ScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ gs f10132a;

    public gt(gs gsVar) {
        this.f10132a = gsVar;
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List<ScanResult> list) {
        if (!this.f10132a.f10120a.get() || list == null || list.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int size = list.size();
        if (size != this.f10132a.f10128i || jCurrentTimeMillis - this.f10132a.f10127h >= 200) {
            this.f10132a.f10127h = jCurrentTimeMillis;
            this.f10132a.f10128i = size;
            int i9 = 0;
            for (ScanResult scanResult : list) {
                if (scanResult != null && scanResult.getDevice() != null && this.f10132a.f10121b.offer(scanResult)) {
                    i9++;
                }
            }
            StringBuilder sbA = C0524s.a(i9, "batch:", ",total:");
            sbA.append(this.f10132a.f10121b.size());
            ee.a("BluetoothScanner", sbA.toString());
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int i9) {
        ee.d("BluetoothScanner", "ble scan failed:" + i9);
        BluetoothAdapter bluetoothAdapter = (BluetoothAdapter) this.f10132a.f10123d.get();
        if (bluetoothAdapter != null) {
            this.f10132a.a(bluetoothAdapter);
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int i9, ScanResult scanResult) {
        if (!this.f10132a.f10120a.get() || scanResult == null || scanResult.getDevice() == null) {
            return;
        }
        this.f10132a.f10121b.offer(scanResult);
    }
}

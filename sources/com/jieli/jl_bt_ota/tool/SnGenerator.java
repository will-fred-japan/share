package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.rcsp.ICmdSnGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class SnGenerator implements ICmdSnGenerator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Integer> f16223b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16222a = (new Random().nextInt(255) + 1) % 256;

    public synchronized int autoIncSN(BluetoothDevice bluetoothDevice) {
        int cmdSequence = getCmdSequence(bluetoothDevice);
        int i9 = 0;
        if (bluetoothDevice == null) {
            int i10 = cmdSequence + 1;
            this.f16222a = i10 < 256 ? i10 : 0;
            return cmdSequence;
        }
        int i11 = cmdSequence + 1;
        if (i11 < 256) {
            i9 = i11;
        }
        this.f16223b.put(bluetoothDevice.getAddress(), Integer.valueOf(i9));
        return cmdSequence;
    }

    public void destroy() {
        this.f16223b.clear();
    }

    public int getCmdSequence(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return this.f16222a;
        }
        Integer num = this.f16223b.get(bluetoothDevice.getAddress());
        return num == null ? this.f16222a : num.intValue();
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.ICmdSnGenerator
    public int getRcspCmdSeq(BluetoothDevice bluetoothDevice) {
        return autoIncSN(bluetoothDevice);
    }

    public void removeCmdSequence(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || this.f16223b.isEmpty()) {
            return;
        }
        this.f16223b.remove(bluetoothDevice.getAddress());
    }
}

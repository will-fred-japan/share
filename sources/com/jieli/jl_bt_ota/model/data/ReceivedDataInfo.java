package com.jieli.jl_bt_ota.model.data;

import H2.a;
import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.util.CHexConver;

/* JADX INFO: loaded from: classes.dex */
public class ReceivedDataInfo extends DataInfo {
    private final byte[] data;
    private final BluetoothDevice device;
    private int deviceSendMtu;

    public ReceivedDataInfo(BluetoothDevice bluetoothDevice, byte[] bArr) {
        super(1);
        this.deviceSendMtu = 530;
        this.device = bluetoothDevice;
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public int getDeviceSendMtu() {
        return this.deviceSendMtu;
    }

    public void setDeviceSendMtu(int i9) {
        this.deviceSendMtu = i9;
    }

    @Override // com.jieli.jl_bt_ota.model.data.DataInfo
    public String toString() {
        StringBuilder sb = new StringBuilder("ReceivedDataInfo{device=");
        sb.append(this.device);
        sb.append(", data=");
        sb.append(CHexConver.byte2HexStr(this.data));
        sb.append(", deviceSendMtu=");
        return a.a(sb, this.deviceSendMtu, '}');
    }
}

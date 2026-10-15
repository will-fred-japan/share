package com.jieli.jl_bt_ota.model.ble;

import H2.a;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class BleConnectParam {
    private final List<BleCharacteristic> bleCharacteristicList;
    private boolean isNeedChangeBleMtu;
    private int preferredPhy;
    private boolean reconnect;
    private int requestMtu;
    private int retryCount;
    private long retryDelay;
    private int retryLimit;
    private final long timeout;
    private int transport;

    public BleConnectParam() {
        this(40000L);
    }

    public boolean canRetry() {
        int i9 = this.retryCount + 1;
        this.retryCount = i9;
        return i9 <= this.retryLimit;
    }

    public List<BleCharacteristic> getBleCharacteristicList() {
        return this.bleCharacteristicList;
    }

    public List<BleCharacteristic> getBleWriteCharacteristicList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getBleCharacteristicList(4));
        arrayList.addAll(getBleCharacteristicList(8));
        return arrayList;
    }

    public int getPreferredPhy() {
        return this.preferredPhy;
    }

    public int getRequestMtu() {
        return this.requestMtu;
    }

    public long getRetryDelay() {
        return this.retryDelay;
    }

    public int getRetryLimit() {
        return this.retryLimit;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public int getTransport() {
        return this.transport;
    }

    public boolean isNeedChangeBleMtu() {
        return this.isNeedChangeBleMtu;
    }

    public boolean isReconnect() {
        return this.reconnect;
    }

    public boolean isValid() {
        return this.bleCharacteristicList.size() >= 2 && !getBleWriteCharacteristicList().isEmpty();
    }

    public void resetRetryCount() {
        this.retryCount = 0;
    }

    public BleConnectParam setNeedChangeBleMtu(boolean z8) {
        this.isNeedChangeBleMtu = z8;
        return this;
    }

    public BleConnectParam setPreferredPhy(int i9) {
        this.preferredPhy = i9;
        return this;
    }

    public BleConnectParam setReconnect(boolean z8) {
        this.reconnect = z8;
        return this;
    }

    public BleConnectParam setRequestMtu(int i9) {
        this.requestMtu = i9;
        return this;
    }

    public BleConnectParam setRetryDelay(long j) {
        this.retryDelay = j;
        return this;
    }

    public BleConnectParam setRetryLimit(int i9) {
        this.retryLimit = i9;
        return this;
    }

    public BleConnectParam setTransport(int i9) {
        this.transport = i9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BleConnectParam{timeout=");
        sb.append(this.timeout);
        sb.append(", reconnect=");
        sb.append(this.reconnect);
        sb.append(", isNeedChangeBleMtu=");
        sb.append(this.isNeedChangeBleMtu);
        sb.append(", requestMtu=");
        sb.append(this.requestMtu);
        sb.append(", bleCharacteristicList=");
        sb.append(this.bleCharacteristicList);
        sb.append(", preferredPhy=");
        sb.append(this.preferredPhy);
        sb.append(", transport=");
        sb.append(this.transport);
        sb.append(", retryLimit=");
        sb.append(this.retryLimit);
        sb.append(", retryDelay=");
        sb.append(this.retryDelay);
        sb.append(", retryCount=");
        return a.a(sb, this.retryCount, '}');
    }

    public BleConnectParam(long j) {
        this.timeout = j;
        this.reconnect = true;
        ArrayList arrayList = new ArrayList();
        this.bleCharacteristicList = arrayList;
        UUID uuid = BluetoothConstant.UUID_SERVICE;
        arrayList.add(new BleCharacteristic(uuid, BluetoothConstant.UUID_WRITE, 4));
        arrayList.add(new BleCharacteristic(uuid, BluetoothConstant.UUID_NOTIFICATION, 16));
        this.isNeedChangeBleMtu = true;
        this.requestMtu = BluetoothConstant.BLE_MTU_MAX;
        this.preferredPhy = 1;
        this.transport = 2;
        this.retryLimit = 1;
        this.retryDelay = 2000L;
    }

    public List<BleCharacteristic> getBleCharacteristicList(int i9) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(this.bleCharacteristicList);
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            BleCharacteristic bleCharacteristic = (BleCharacteristic) obj;
            if (bleCharacteristic.hasProperty(i9)) {
                arrayList.add(bleCharacteristic);
            }
        }
        return arrayList;
    }
}

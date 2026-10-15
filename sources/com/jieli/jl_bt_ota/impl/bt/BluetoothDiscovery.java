package com.jieli.jl_bt_ota.impl.bt;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.os.SystemClock;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.interfaces.bt.OnBtAssistantCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class BluetoothDiscovery extends BluetoothBase {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f16132m = 4660;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f16133n = 4661;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<BluetoothDevice> f16134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<BluetoothDevice> f16135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BluetoothDiscoveryReceiver f16136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BluetoothLeScanner f16137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile int f16138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f16139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f16140i;
    private final OnBtAssistantCallback j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BluetoothAdapter.LeScanCallback f16141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ScanCallback f16142l;

    public class BluetoothDiscoveryReceiver extends BroadcastReceiver {
        private BluetoothDiscoveryReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            switch (action) {
                case "android.bluetooth.adapter.action.DISCOVERY_FINISHED":
                    JL_Log.d(BluetoothDiscovery.this.TAG, "ACTION_DISCOVERY_FINISHED", "---->");
                    BluetoothDiscovery.this.a(false);
                    break;
                case "android.bluetooth.adapter.action.DISCOVERY_STARTED":
                    JL_Log.d(BluetoothDiscovery.this.TAG, "ACTION_DISCOVERY_STARTED", "---->");
                    if (!BluetoothDiscovery.this.isDeviceScanning()) {
                        BluetoothDiscovery.this.a(true);
                        break;
                    }
                    break;
                case "android.bluetooth.device.action.FOUND":
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice != null && !BluetoothDiscovery.this.a("ACTION_FOUND", true)) {
                        boolean z8 = (BluetoothDiscovery.this.f16138g == 1 && bluetoothDevice.getType() != 2) || (BluetoothDiscovery.this.f16138g == 0 && bluetoothDevice.getType() != 1) || BluetoothDiscovery.this.f16138g == 2;
                        short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
                        if (z8 && !BluetoothDiscovery.this.f16135d.contains(bluetoothDevice)) {
                            JL_Log.d(BluetoothDiscovery.this.TAG, "ACTION_FOUND", "device : " + BluetoothDiscovery.this.printBtDeviceInfo(bluetoothDevice) + ", RSSI : " + ((int) shortExtra));
                            BluetoothDiscovery.this.f16135d.add(bluetoothDevice);
                            BluetoothDiscovery.this.mCallbackManager.onDiscovery(bluetoothDevice, new BleScanMessage().setRssi(shortExtra).setEnableConnect(true));
                            break;
                        }
                    }
                    break;
            }
        }
    }

    public BluetoothDiscovery(Context context) {
        super(context);
        this.f16134c = new ArrayList();
        this.f16135d = new ArrayList();
        this.f16139h = false;
        this.f16140i = false;
        OnBtAssistantCallback onBtAssistantCallback = new OnBtAssistantCallback() { // from class: com.jieli.jl_bt_ota.impl.bt.BluetoothDiscovery.1
            @Override // com.jieli.jl_bt_ota.interfaces.bt.OnBtAssistantCallback, com.jieli.jl_bt_ota.interfaces.bt.IBtAssistantCallback
            public void onAdapterStatus(boolean z8, boolean z9) {
                if (z8) {
                    return;
                }
                if (BluetoothDiscovery.this.isScanning()) {
                    BluetoothDiscovery.this.a(false);
                }
                BluetoothDiscovery.this.c();
            }
        };
        this.j = onBtAssistantCallback;
        this.f16141k = new BluetoothAdapter.LeScanCallback() { // from class: com.jieli.jl_bt_ota.impl.bt.e
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public final void onLeScan(BluetoothDevice bluetoothDevice, int i9, byte[] bArr) {
                this.f16155a.a(bluetoothDevice, i9, bArr);
            }
        };
        this.f16142l = new ScanCallback() { // from class: com.jieli.jl_bt_ota.impl.bt.BluetoothDiscovery.2
            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> list) {
                super.onBatchScanResults(list);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int i9) {
                super.onScanFailed(i9);
                JL_Log.w(BluetoothDiscovery.this.TAG, "onScanFailed", "Failed to scan ble. errorCode = " + i9);
                if (i9 != 1) {
                    BluetoothDiscovery.this.a(false);
                } else {
                    JL_Log.i(BluetoothDiscovery.this.TAG, "onScanFailed", "Repeatedly turn on Bluetooth scanning.");
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int i9, ScanResult scanResult) {
                super.onScanResult(i9, scanResult);
                if (scanResult == null || scanResult.getScanRecord() == null) {
                    return;
                }
                BluetoothDiscovery.this.a(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes(), scanResult.isConnectable());
            }
        };
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            this.f16137f = bluetoothAdapter.getBluetoothLeScanner();
        }
        addOnBtAssistantCallback(onBtAssistantCallback);
    }

    public ArrayList<BluetoothDevice> getDiscoveredBluetoothDevices() {
        return this.f16138g == 0 ? new ArrayList<>(this.f16134c) : new ArrayList<>(this.f16135d);
    }

    public int getScanType() {
        return this.f16138g;
    }

    @Override // com.jieli.jl_bt_ota.impl.bt.BluetoothBase
    public boolean handleMessageEvent(Message message) {
        int i9 = message.what;
        if (i9 == f16132m) {
            JL_Log.i(this.TAG, "MSG_STOP_EDR", "stopDeviceScan");
            stopDeviceScan();
        } else if (i9 == f16133n) {
            JL_Log.i(this.TAG, "MSG_STOP_BLE", "stopBLEScan");
            stopBLEScan();
        }
        return super.handleMessageEvent(message);
    }

    public boolean isBleScanning() {
        return this.f16139h;
    }

    public boolean isDeviceScanning() {
        return this.f16140i;
    }

    public boolean isScanning() {
        return this.f16140i || this.f16139h;
    }

    @Override // com.jieli.jl_bt_ota.impl.bt.BluetoothBase
    public void release() {
        removeOnBtAssistantCallback(this.j);
        b();
        stopDeviceScan();
        stopBLEScan();
        c();
        super.release();
    }

    @SuppressLint({"MissingPermission"})
    public int startBLEScan(long j) {
        if (a("startBLEScan")) {
            return ErrorCode.SUB_ERR_OP_FAILED;
        }
        if (isDeviceScanning()) {
            JL_Log.d(this.TAG, "startBLEScan", "stopDeviceScan");
            if (stopDeviceScan() == 0) {
                int i9 = 0;
                do {
                    SystemClock.sleep(50L);
                    i9 += 50;
                    if (i9 > 1000) {
                        break;
                    }
                } while (this.mBluetoothAdapter.isDiscovering());
            }
        }
        a(0);
        if (j <= 0) {
            j = 8000;
        }
        if (isBleScanning()) {
            JL_Log.i(this.TAG, "startBLEScan", "scanning ble ..... timeout = " + j);
            BluetoothLeScanner bluetoothLeScanner = this.f16137f;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.flushPendingScanResults(this.f16142l);
            }
            executeTimeoutTask(f16133n, null, j);
            a(true);
            return 0;
        }
        if (this.f16137f != null) {
            this.f16137f.startScan(new ArrayList(), new ScanSettings.Builder().setScanMode(getBluetoothOption().getBleScanMode()).setMatchMode(1).setNumOfMatches(3).build(), this.f16142l);
            JL_Log.d(this.TAG, "startBLEScan", "startScan : true");
        } else {
            boolean zStartLeScan = this.mBluetoothAdapter.startLeScan(this.f16141k);
            JL_Log.d(this.TAG, "startBLEScan", "startLeScan : " + zStartLeScan);
            if (!zStartLeScan) {
                return ErrorCode.SUB_ERR_SCAN_DEVICE_FAILED;
            }
        }
        JL_Log.i(this.TAG, "startBLEScan", "Ready to scan, timeout : " + j);
        executeTimeoutTask(f16133n, null, j);
        a(true);
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public int startDeviceScan(long j, int i9) {
        if (i9 == 0) {
            return startBLEScan(j);
        }
        if (a("startDeviceScan")) {
            return ErrorCode.SUB_ERR_OP_FAILED;
        }
        if (isBleScanning()) {
            stopBLEScan();
            JL_Log.i(this.TAG, "startDeviceScan", "stopBLEScan.");
            SystemClock.sleep(100L);
        }
        a(i9);
        long j8 = j <= 0 ? 8000L : j;
        if (isDeviceScanning()) {
            JL_Log.d(this.TAG, "startDeviceScan", "scanning br/edr ..... timeout = " + j);
            executeTimeoutTask(f16132m, null, j8);
            a(true);
            return 0;
        }
        a();
        boolean zStartDiscovery = this.mBluetoothAdapter.startDiscovery();
        JL_Log.d(this.TAG, "startDeviceScan", "startDiscovery : " + zStartDiscovery);
        if (!zStartDiscovery) {
            b();
            return ErrorCode.SUB_ERR_SCAN_DEVICE_FAILED;
        }
        executeTimeoutTask(f16132m, null, j8);
        a(true);
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public int stopBLEScan() {
        if (a("stopBLEScan", true)) {
            return ErrorCode.SUB_ERR_OP_FAILED;
        }
        if (!isBleScanning()) {
            this.mCallbackManager.onDiscoveryStatus(true, false);
            return 0;
        }
        try {
            BluetoothLeScanner bluetoothLeScanner = this.f16137f;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.f16142l);
                JL_Log.d(this.TAG, "stopBLEScan", "stopScan");
            } else {
                this.mBluetoothAdapter.stopLeScan(this.f16141k);
                JL_Log.d(this.TAG, "stopBLEScan", "stopLeScan");
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        removeTimeoutTask(f16133n);
        a(false);
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public int stopDeviceScan() {
        if (a("stopDeviceScan", true)) {
            return ErrorCode.SUB_ERR_OP_FAILED;
        }
        if (!isDeviceScanning()) {
            this.mCallbackManager.onDiscoveryStatus(false, false);
            return 0;
        }
        boolean zCancelDiscovery = this.mBluetoothAdapter.cancelDiscovery();
        JL_Log.w(this.TAG, "stopDeviceScan", "cancelDiscovery = " + zCancelDiscovery);
        if (!zCancelDiscovery) {
            return ErrorCode.SUB_ERR_SCAN_DEVICE_FAILED;
        }
        removeTimeoutTask(f16132m);
        return 0;
    }

    private void b(boolean z8) {
        List<BluetoothDevice> systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(this.mContext);
        if (systemConnectedBtDeviceList == null || systemConnectedBtDeviceList.isEmpty()) {
            return;
        }
        for (BluetoothDevice bluetoothDevice : systemConnectedBtDeviceList) {
            if (z8 && a(bluetoothDevice)) {
                if (!this.f16134c.contains(bluetoothDevice)) {
                    this.f16134c.add(bluetoothDevice);
                    this.mCallbackManager.onDiscovery(bluetoothDevice, new BleScanMessage());
                }
            } else if (!z8 && !a(bluetoothDevice) && !this.f16135d.contains(bluetoothDevice)) {
                this.f16135d.add(bluetoothDevice);
                this.mCallbackManager.onDiscovery(bluetoothDevice, new BleScanMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a(0);
        this.f16139h = false;
        this.f16140i = false;
        this.f16134c.clear();
        this.f16135d.clear();
    }

    private boolean a(String str) {
        return a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, boolean z8) {
        if (!CommonUtil.checkHasScanPermission(this.mContext)) {
            JL_Log.w(this.TAG, str, "Missing bluetooth scan permissions.");
            return true;
        }
        if (!z8 && !CommonUtil.checkHasLocationPermission(this.mContext)) {
            JL_Log.w(this.TAG, str, "Missing location permissions.");
            return true;
        }
        if (this.mBluetoothAdapter == null) {
            JL_Log.w(this.TAG, str, "The device is not supported bluetooth.");
            return true;
        }
        if (BluetoothUtil.isBluetoothEnable()) {
            return false;
        }
        JL_Log.w(this.TAG, str, "Bluetooth is off.");
        return true;
    }

    private void b() {
        Context context;
        BluetoothDiscoveryReceiver bluetoothDiscoveryReceiver = this.f16136e;
        if (bluetoothDiscoveryReceiver == null || (context = this.mContext) == null) {
            return;
        }
        context.unregisterReceiver(bluetoothDiscoveryReceiver);
        this.f16136e = null;
    }

    @SuppressLint({"MissingPermission"})
    private boolean a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(this.mContext)) {
            return false;
        }
        return bluetoothDevice.getType() == 2 || bluetoothDevice.getType() == 3;
    }

    private void a(int i9) {
        this.f16138g = i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void a(BluetoothDevice bluetoothDevice, int i9, byte[] bArr, boolean z8) {
        if (bluetoothDevice == null || a("filterDevice", true) || this.f16134c.contains(bluetoothDevice)) {
            return;
        }
        this.f16134c.add(bluetoothDevice);
        this.mCallbackManager.onDiscovery(bluetoothDevice, new BleScanMessage().setRawData(bArr).setRssi(i9).setEnableConnect(z8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z8) {
        boolean z9 = this.f16138g == 0;
        JL_Log.i(this.TAG, "notifyDiscoveryStatus", "scanType : " + this.f16138g + ", bStart : " + z8);
        if (z8) {
            if (z9) {
                this.f16139h = true;
                this.f16134c.clear();
            } else {
                this.f16140i = true;
                this.f16135d.clear();
            }
        } else if (z9) {
            this.f16139h = false;
            removeTimeoutTask(f16133n);
        } else {
            this.f16140i = false;
            removeTimeoutTask(f16132m);
            b();
        }
        this.mCallbackManager.onDiscoveryStatus(z9, z8);
        if (!z8) {
            a(0);
        } else {
            b(z9);
        }
    }

    private void a() {
        if (this.f16136e != null || this.mContext == null) {
            return;
        }
        this.f16136e = new BluetoothDiscoveryReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        this.mContext.registerReceiver(this.f16136e, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, int i9, byte[] bArr) {
        a(bluetoothDevice, i9, bArr, true);
    }
}

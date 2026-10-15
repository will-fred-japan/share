package cn.jiguang.commons.a;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class gw extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ gs f10137a;

    public gw(gs gsVar) {
        this.f10137a = gsVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.bluetooth.device.action.FOUND".equals(action)) {
            if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                ee.a("BluetoothScanner", "classic scan finished");
                return;
            }
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
        BluetoothClass bluetoothClass = (BluetoothClass) intent.getParcelableExtra("android.bluetooth.device.extra.CLASS");
        String stringExtra = intent.getStringExtra("android.bluetooth.device.extra.NAME");
        if (bluetoothDevice != null) {
            this.f10137a.f10121b.offer(new hc(bluetoothDevice, shortExtra, null, bluetoothClass, stringExtra));
        }
    }
}

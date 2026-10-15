package cn.jiguang.commons.a;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes.dex */
public final class gx {
    public static void a(af afVar, BluetoothDevice bluetoothDevice, BluetoothClass bluetoothClass) {
        int i9;
        if (afVar == null || bluetoothDevice == null || bluetoothClass == null) {
            ee.d("DeviceTypeProcessor", "setDeviceType: one of the parameters is null");
            return;
        }
        int majorDeviceClass = bluetoothClass.getMajorDeviceClass();
        int deviceClass = bluetoothClass.getDeviceClass();
        ee.a("DeviceTypeProcessor", String.format("setting device type: address=%s, major=%d, class=%d, current_type=%d", bluetoothDevice.getAddress(), Integer.valueOf(majorDeviceClass), Integer.valueOf(deviceClass), Integer.valueOf(afVar.b())));
        if (majorDeviceClass != 256) {
            if (majorDeviceClass != 512) {
                if (majorDeviceClass != 1024) {
                    if (majorDeviceClass != 1280) {
                        if (majorDeviceClass == 1536) {
                            i9 = 40;
                        } else if (majorDeviceClass == 1792) {
                            i9 = 50;
                        } else if (majorDeviceClass == 2048) {
                            i9 = 60;
                        } else if (majorDeviceClass == 2304) {
                            i9 = 70;
                        }
                    } else if (deviceClass == 1472) {
                        i9 = 32;
                    } else if (deviceClass == 1344) {
                        i9 = 30;
                    } else if (deviceClass == 1408) {
                        i9 = 31;
                    } else if (deviceClass == 1284 || deviceClass == 1288) {
                        afVar.a(33);
                    } else {
                        i9 = deviceClass == 1292 ? 35 : 36;
                    }
                    ee.a("DeviceTypeProcessor", String.format("device major class: %d, class: %d, type: %d", Integer.valueOf(majorDeviceClass), Integer.valueOf(deviceClass), Integer.valueOf(afVar.b())));
                }
                if (deviceClass == 1048) {
                    i9 = 1;
                } else if (deviceClass == 1028) {
                    i9 = 2;
                } else if (deviceClass == 1032) {
                    i9 = 3;
                } else if (deviceClass == 1040) {
                    i9 = 4;
                } else if (deviceClass == 1052) {
                    i9 = 5;
                } else if (deviceClass == 1056) {
                    i9 = 6;
                } else {
                    i9 = deviceClass == 1044 ? 7 : 8;
                }
            } else if (deviceClass == 524) {
                i9 = 10;
            } else {
                i9 = deviceClass == 516 ? 11 : 12;
            }
        } else if (deviceClass == 268) {
            i9 = 20;
        } else if (deviceClass == 260) {
            i9 = 21;
        } else if (deviceClass == 264) {
            i9 = 22;
        } else {
            i9 = deviceClass == 272 ? 23 : 24;
        }
        afVar.a(i9);
        ee.a("DeviceTypeProcessor", String.format("device major class: %d, class: %d, type: %d", Integer.valueOf(majorDeviceClass), Integer.valueOf(deviceClass), Integer.valueOf(afVar.b())));
    }
}

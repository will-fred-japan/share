package com.jieli.jl_bt_ota.constant;

import W5.e;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothConstant {
    public static final int BLE_MTU_MAX = 509;
    public static final int BLE_MTU_MIN = 20;
    public static final int CONNECT_TIMEOUT = 40000;
    public static final int DEFAULT_SCAN_TIMEOUT = 8000;
    public static final int DEFAULT_SEND_CMD_TIMEOUT = 3000;
    public static final int FLAG_LOADER = 1;
    public static final int FLAG_SDK = 0;
    public static boolean IS_CALLBACK_IN_MAIN = false;
    public static boolean IS_LOG_BLE_SEND = false;
    public static final String JL_AUTH = "jl_ota_auth";
    public static final int PHY_LE_1M_MASK = 1;
    public static final int PHY_LE_2M_MASK = 2;
    public static final int PHY_LE_CODED_MASK = 4;
    public static final int PROTOCOL_TYPE_BLE = 0;
    public static final int PROTOCOL_TYPE_GATT_OVER_BR_EDR = 2;
    public static final int PROTOCOL_TYPE_SPP = 1;
    public static final int RECEIVE_OTA_CMD_TIMEOUT = 20000;
    public static final int SCAN_TYPE_ALL = 2;
    public static final int SCAN_TYPE_BLE = 0;
    public static final int SCAN_TYPE_CLASSIC = 1;
    public static final int SEND_DATA_MAX_TIMEOUT = 6000;
    public static final int TRANSPORT_AUTO = 0;
    public static final int TRANSPORT_BREDR = 1;
    public static final int TRANSPORT_LE = 2;
    public static final int WRITE_TYPE_NONE = 0;
    public static final UUID UUID_SERVICE = UUID.fromString("0000ae00-0000-1000-8000-00805F9B34FB");
    public static final UUID UUID_WRITE = UUID.fromString("0000ae01-0000-1000-8000-00805F9B34FB");
    public static final UUID UUID_NOTIFICATION = UUID.fromString("0000ae02-0000-1000-8000-00805F9B34FB");
    public static final UUID UUID_CLIENT_CHARACTERISTIC_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_HFP = UUID.fromString("0000111e-0000-1000-8000-00805F9B34FB");
    public static final UUID UUID_A2DP = UUID.fromString("0000110b-0000-1000-8000-00805F9B34FB");
    public static final UUID UUID_SPP = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    public static String printProtocolType(int i9) {
        if (i9 == 0) {
            return "PROTOCOL_TYPE_BLE(0)";
        }
        if (i9 != 1) {
            return i9 != 2 ? e.i(i9, "UNKNOWN_PROTOCOL_TYPE : ") : "PROTOCOL_TYPE_GATT_OVER_BR_EDR(2)";
        }
        return "PROTOCOL_TYPE_SPP(1)";
    }
}

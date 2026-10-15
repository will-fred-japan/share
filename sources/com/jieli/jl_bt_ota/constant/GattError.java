package com.jieli.jl_bt_ota.constant;

import defpackage.f;

/* JADX INFO: loaded from: classes.dex */
public class GattError {
    public static final int GATT_CONN_CANCEL = 256;
    public static final int GATT_CONN_FAIL_ESTABLISH = 62;
    public static final int GATT_CONN_L2C_FAILURE = 1;
    public static final int GATT_CONN_LMP_TIMEOUT = 34;
    public static final int GATT_CONN_TERMINATE_LOCAL_HOST = 22;
    public static final int GATT_CONN_TERMINATE_PEER_USER = 19;
    public static final int GATT_CONN_TIMEOUT = 8;
    public static final int GATT_ERROR = 133;
    public static final int GATT_SUCCESS = 0;

    public static String parseConnectionError(int i9) {
        if (i9 == 0) {
            return "SUCCESS";
        }
        if (i9 == 1) {
            return "GATT CONN L2C FAILURE";
        }
        if (i9 == 8) {
            return "GATT CONN TIMEOUT";
        }
        if (i9 == 19) {
            return "GATT CONN TERMINATE PEER USER";
        }
        if (i9 == 22) {
            return "GATT CONN TERMINATE LOCAL HOST";
        }
        if (i9 == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i9 == 62) {
            return "GATT CONN FAIL ESTABLISH";
        }
        if (i9 != 133) {
            return i9 != 256 ? f.b(i9, "UNKNOWN (", ")") : "GATT CONN CANCEL ";
        }
        return "GATT ERROR";
    }
}

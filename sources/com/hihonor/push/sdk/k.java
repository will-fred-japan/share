package com.hihonor.push.sdk;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public enum k {
    SUCCESS(0, "success"),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_NOT_SUPPORT_PUSH(8001000, "device is not support push."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_MAIN_THREAD(8001001, "operation in MAIN thread prohibited."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_NO_TOKEN(8001004, "token missing."),
    ERROR_NO_APPID(8001002, "app id missing."),
    ERROR_NOT_INITIALIZED(8001005, "SDK not initialized"),
    ERROR_CERT_FINGERPRINT_EMPTY(8001003, "certificate fingerprint empty."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_BIND_SERVICE(8002001, "bind service failed."),
    ERROR_SERVICE_DISCONNECTED(8002002, "service disconnected."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_TIME_OUT(8002003, "service connect time out."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_ARGUMENTS_INVALID(8002004, "service arguments invalid."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_NULL_BINDING(8002005, "service being bound has return null."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_INVALID(8002006, "service invalid."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_DISABLED(8002007, "service disabled."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_MISSING(8002008, "service missing."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_OBTAIN_GRS_EMPTY(8003001, "push server error."),
    ERROR_UNKNOWN(8003002, "unknown error."),
    ERROR_INTERNAL_ERROR(8003003, "internal error."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_REQUEST_TIME_OUT(8003004, "arguments invalid."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_OBTAIN_GRS_EMPTY(8003005, "operation too frequently."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_REQUEST_TIME_OUT(8003006, "no network."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_OBTAIN_GRS_EMPTY(8003007, "not statement agreement."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_SERVICE_REQUEST_TIME_OUT(8003008, "service request time out."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_OBTAIN_GRS_EMPTY(8003009, "network error."),
    ERROR_PROFILE_ID_IS_EMPTY(8004001, "profile id is empty."),
    ERROR_PROFILE_ID_LENGTH_TOO_LONG(8004001, "profile id length too long, max is 64 bytes."),
    ERROR_PROFILE_ID_IS_INVALID(8004001, "profile id has invalid character"),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_APP_INFO_MISSING(8004002, "app info missing, should register token first."),
    /* JADX INFO: Fake field, exist only in values array */
    ERROR_HTTP_OPERATION_FREQUENTLY(10214, "http operation too frequently.");


    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final SparseArray<k> f14525m = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14528b;

    static {
        k[] kVarArrValues = values();
        for (int i9 = 0; i9 < 29; i9++) {
            k kVar = kVarArrValues[i9];
            f14525m.put(kVar.f14527a, kVar);
        }
    }

    k(int i9, String str) {
        this.f14527a = i9;
        this.f14528b = str;
    }

    public j a() {
        return new j(this.f14527a, this.f14528b);
    }
}

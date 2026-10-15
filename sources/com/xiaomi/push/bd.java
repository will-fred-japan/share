package com.xiaomi.push;

import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
class bd extends az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicReference<bd> f17076a = new AtomicReference<>();

    private bd() {
        super(4, 10L, TimeUnit.SECONDS, BluetoothConstant.RECEIVE_OTA_CMD_TIMEOUT, "io");
    }

    public static bd a() {
        if (f17076a.get() == null || f17076a.get().isTerminated()) {
            synchronized (bd.class) {
                try {
                    if (f17076a.get() == null || f17076a.get().isTerminated()) {
                        f17076a.set(new bd());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17076a.get();
    }
}

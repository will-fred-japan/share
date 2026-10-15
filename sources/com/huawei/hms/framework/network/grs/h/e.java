package com.huawei.hms.framework.network.grs.h;

import com.huawei.hms.framework.common.Logger;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15127a = "e";

    public static boolean a(Long l8) {
        if (l8 == null) {
            Logger.v(f15127a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l8.longValue() - System.currentTimeMillis() >= 0) {
                Logger.i(f15127a, "isSpExpire false.");
                return false;
            }
            Logger.i(f15127a, "isSpExpire true.");
            return true;
        } catch (NumberFormatException unused) {
            Logger.v(f15127a, "isSpExpire spValue NumberFormatException.");
        }
    }

    public static boolean a(Long l8, long j) {
        if (l8 == null) {
            Logger.v(f15127a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l8.longValue() - (System.currentTimeMillis() + j) >= 0) {
                Logger.v(f15127a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.v(f15127a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}

package com.engagelab.privates.core.global;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.x;
import com.engagelab.privates.core.api.Address;
import com.engagelab.privates.core.constants.MTCoreConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MTCoreGlobal {
    private static volatile Address address = null;
    private static int connectRetryCount = 3;
    private static long heartbeatInterval = 290000;
    private static int loginCode = 0;
    private static boolean onlyBeWakeState = true;
    private static boolean onlyWakeState = true;
    private static String password = null;
    private static int registerCode = -1;
    private static String registrationId = null;
    private static boolean resetOnDeviceChangeEnabled = false;
    private static long rid = 0;
    private static int seedId = 0;
    private static long serverTime = 0;
    private static MTCoreConstants.ServiceNode serviceNode = MTCoreConstants.ServiceNode.REGION_OVERSEAS;
    private static long userId = 0;
    private static boolean wakeAndBeWakeState = true;

    public static int getConnectRetryCount() {
        return connectRetryCount;
    }

    public static long getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public static List<String> getHttpAddress(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getHttpAddressSet(context));
        Collections.shuffle(arrayList);
        return arrayList;
    }

    private static Set<String> getHttpAddressSet(Context context) {
        return x.e(context);
    }

    public static int getLoginCode(Context context) {
        if (loginCode == -1) {
            loginCode = x.f(context);
        }
        return loginCode;
    }

    public static boolean getOnlyBeWakeState() {
        if (MTGlobal.IS_FOR_BINANCE || MTGlobal.IS_FOR_PINGANBANK) {
            return onlyBeWakeState;
        }
        return true;
    }

    public static boolean getOnlyWakeState() {
        if (MTGlobal.IS_FOR_BINANCE || MTGlobal.IS_FOR_PINGANBANK) {
            return onlyWakeState;
        }
        return true;
    }

    public static String getPassword(Context context) {
        if (TextUtils.isEmpty(password)) {
            password = x.h(context);
        }
        return password;
    }

    public static byte getPlatformState(Context context) {
        return x.i(context);
    }

    public static int getRegisterCode(Context context) {
        if (registerCode == -1) {
            registerCode = x.j(context);
        }
        return registerCode;
    }

    public static String getRegistrationId(Context context) {
        if (TextUtils.isEmpty(registrationId)) {
            registrationId = x.k(context);
        }
        return registrationId;
    }

    public static boolean getResetOnDeviceChangeEnabled() {
        return resetOnDeviceChangeEnabled;
    }

    public static synchronized long getRid() {
        long j;
        long j8 = rid;
        j = (j8 + (j8 % 2 == 0 ? 1L : 2L)) % 32767;
        rid = j;
        return j;
    }

    public static int getSeedId(Context context) {
        if (seedId == 0) {
            seedId = x.l(context);
        }
        return seedId;
    }

    public static long getServerTime(Context context) {
        if (serverTime == 0) {
            serverTime = x.m(context);
        }
        return serverTime;
    }

    public static MTCoreConstants.ServiceNode getServiceNode() {
        return serviceNode;
    }

    public static long getUserId(Context context) {
        if (userId == 0) {
            userId = x.s(context);
        }
        return userId;
    }

    public static boolean getWakeAndBeWakeState() {
        return wakeAndBeWakeState;
    }

    public static void setConnectRetryCount(int i9) {
        if (i9 < 3) {
            connectRetryCount = 3;
        } else {
            connectRetryCount = i9;
        }
    }

    public static void setHeartbeatInterval(long j) {
        if (j <= 0) {
            heartbeatInterval = MTCoreConstants.Heartbeat.DEFAULT_VALUE_HEARTBEAT_INTERVAL;
        } else {
            heartbeatInterval = j;
        }
    }

    public static void setLoginCode(int i9) {
        loginCode = i9;
    }

    public static void setOnlyBeWakeState(boolean z8) {
        if (MTGlobal.IS_FOR_BINANCE || MTGlobal.IS_FOR_PINGANBANK) {
            onlyBeWakeState = z8;
        }
    }

    public static void setOnlyWakeState(boolean z8) {
        if (MTGlobal.IS_FOR_BINANCE || MTGlobal.IS_FOR_PINGANBANK) {
            onlyWakeState = z8;
        }
    }

    public static void setPassword(String str) {
        password = str;
    }

    public static void setPlatformState(Context context, byte b9) {
        x.a(context, b9);
    }

    public static void setRegisterCode(int i9) {
        registerCode = i9;
    }

    public static void setRegistrationId(String str) {
        registrationId = str;
    }

    public static void setResetOnDeviceChangeEnabled(boolean z8) {
        resetOnDeviceChangeEnabled = z8;
    }

    public static void setSeedId(int i9) {
        seedId = i9;
    }

    public static void setServerTime(long j) {
        serverTime = j;
    }

    public static void setServiceNode(MTCoreConstants.ServiceNode serviceNode2) {
        serviceNode = serviceNode2;
    }

    public static void setUserId(long j) {
        userId = j;
    }

    public static void setWakeAndBeWakeState(boolean z8) {
        wakeAndBeWakeState = z8;
    }
}

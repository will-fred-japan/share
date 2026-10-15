package com.starburst.sdk.core.auth;

import A.f;
import A1.b;
import W5.e;
import android.content.Context;
import android.text.TextUtils;
import com.starburst.sdk.business.a56;
import com.starburst.sdk.business.b89;
import com.starburst.sdk.common.utils.AesCbcTools;
import com.starburst.sdk.common.utils.ByteTools;
import com.starburst.sdk.common.utils.SignUtils;
import com.starburst.sdk.core.AiAgentSdk;
import com.starburst.sdk.core.auth.api.IAuthApi;
import com.starburst.sdk.core.auth.api.IAuthInfoUpdateCallback;
import com.starburst.sdk.core.auth.api.IConnectCallback;
import com.starburst.sdk.core.auth.callback.IDeviceRegisterCallback;
import com.starburst.sdk.core.auth.callback.IRegisterCallback;
import com.starburst.sdk.core.auth.callback.TokenReceivedCallback;
import com.starburst.sdk.core.auth.model.DeviceRegisterRespBean;
import com.starburst.sdk.core.auth.model.GetTokenResponseBean;
import com.starburst.sdk.core.device.bt.BluetoothDeviceBean;
import com.starburst.sdk.core.device.bt.ConnectedDeviceManager;
import com.starburst.sdk.core.device.bt.domain.FGSInfoConfig;
import com.starburst.sdk.core.device.bt.entity.AuthCache;
import com.starburst.sdk.core.ntp.NtpTimeSync;
import com.starburst.sdk.resp.AuthInfoRes;
import com.starburst.sdk.utils.h;
import com.starburst.sdk.utils.j;
import com.starburst.sdk.utils.k;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AuthApiImpl implements IAuthApi {
    private static final String TAG = "AliLpImpl";
    public static String appId = null;
    public static String businessSign = null;
    public static String deviceName = null;
    public static String deviceSecret = null;
    public static long expireTime = 0;
    private static volatile boolean isAuthSuccess = false;
    private static String ppeEnv;
    public static String productKey;
    public static String productSecret;
    private static final Set<String> sAuthedDeviceIds = Collections.newSetFromMap(new ConcurrentHashMap());
    private static AuthApiImpl sInstance;
    public static String token;
    private IAuthInfoUpdateCallback authInfoUpdateCallback;
    private volatile String authenticatingDeviceName;
    private final List<IConnectCallback> mConnectCallbacks = new ArrayList();
    private Context mContext;

    private AuthApiImpl(Context context) {
        this.mContext = context;
    }

    private static void clearAuthedDevices() {
        sAuthedDeviceIds.clear();
    }

    private void clearAuthenticatingIfMatches(String str) {
        if (TextUtils.isEmpty(this.authenticatingDeviceName)) {
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.authenticatingDeviceName)) {
            clearAuthenticating();
        }
    }

    public static void clearPpeEnv() {
        ppeEnv = null;
    }

    private static long getAuthCacheValidUntil(AuthCache authCache) {
        if (authCache == null) {
            return 0L;
        }
        return authCache.getExpiretime() - 28800000;
    }

    private static String getAuthDeviceKey(BluetoothDeviceBean bluetoothDeviceBean) {
        if (bluetoothDeviceBean == null) {
            return null;
        }
        String deviceId = bluetoothDeviceBean.getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        String deviceName2 = bluetoothDeviceBean.getDeviceName();
        if (TextUtils.isEmpty(deviceName2)) {
            return null;
        }
        return e.l("dn:", deviceName2);
    }

    private List<BluetoothDeviceBean> getDevicesWithDeviceName(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            for (BluetoothDeviceBean bluetoothDeviceBean : ConnectedDeviceManager.getInstance().getDeviceList()) {
                if (bluetoothDeviceBean != null && str.equals(bluetoothDeviceBean.getDeviceName())) {
                    arrayList.add(bluetoothDeviceBean);
                }
            }
        }
        return arrayList;
    }

    public static AuthApiImpl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AuthApiImpl.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new AuthApiImpl(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public static boolean isAuthCacheValid(AuthCache authCache) {
        return (authCache == null || TextUtils.isEmpty(authCache.getToken()) || TextUtils.isEmpty(authCache.getAppId()) || !authCache.isPpeEnvCached() || getAuthCacheValidUntil(authCache) <= NtpTimeSync.getAdjustedTime()) ? false : true;
    }

    public static boolean isAuthSuccess() {
        return isAuthSuccess || !sAuthedDeviceIds.isEmpty();
    }

    private static boolean isAuthedForDevice(BluetoothDeviceBean bluetoothDeviceBean) {
        String authDeviceKey = getAuthDeviceKey(bluetoothDeviceBean);
        return !TextUtils.isEmpty(authDeviceKey) && sAuthedDeviceIds.contains(authDeviceKey);
    }

    private static boolean markAuthedIfFirstTime(BluetoothDeviceBean bluetoothDeviceBean) {
        String authDeviceKey = getAuthDeviceKey(bluetoothDeviceBean);
        if (TextUtils.isEmpty(authDeviceKey)) {
            return true;
        }
        return sAuthedDeviceIds.add(authDeviceKey);
    }

    private void refreshExpiredToken(final IAuthInfoUpdateCallback iAuthInfoUpdateCallback) {
        long adjustedTime = NtpTimeSync.getAdjustedTime();
        String str = productKey;
        String str2 = deviceName;
        StarBurstAuthImpl.getInstance().getTokenInfo(productKey, deviceName, SignUtils.hmacSHA256(deviceSecret, String.format("clientId%s.%sdeviceName%sproductKey%stimestamp%d", str, str2, str2, str, Long.valueOf(adjustedTime))), AuthInfoRes.DEFAULT_SIGN_METHOD, adjustedTime, new TokenReceivedCallback() { // from class: com.starburst.sdk.core.auth.AuthApiImpl.2
            @Override // com.starburst.sdk.core.auth.callback.TokenReceivedCallback
            public void onTokenReceived(GetTokenResponseBean getTokenResponseBean) {
                if (getTokenResponseBean == null || TextUtils.isEmpty(getTokenResponseBean.getToken())) {
                    IAuthInfoUpdateCallback iAuthInfoUpdateCallback2 = iAuthInfoUpdateCallback;
                    if (iAuthInfoUpdateCallback2 != null) {
                        iAuthInfoUpdateCallback2.onUpdateFailed();
                        return;
                    }
                    return;
                }
                AuthApiImpl.token = getTokenResponseBean.getToken();
                AuthApiImpl.expireTime = getTokenResponseBean.getExpireTime();
                String unused = AuthApiImpl.ppeEnv = getTokenResponseBean.getPpeEnv();
                if (!TextUtils.isEmpty(getTokenResponseBean.getAppId())) {
                    AuthApiImpl.appId = getTokenResponseBean.getAppId();
                }
                long adjustedTime2 = NtpTimeSync.getAdjustedTime();
                AliAgentImpl.sGetSignTimestamp = String.valueOf(adjustedTime2);
                AuthApiImpl.businessSign = SignUtils.hmacSHA256(AuthApiImpl.deviceSecret, String.format("appId=%s&token=%s&productKey=%s&deviceName=%s&timestamp=%d", AuthApiImpl.appId, AuthApiImpl.token, AuthApiImpl.productKey, AuthApiImpl.deviceName, Long.valueOf(adjustedTime2)));
                AuthApiImpl.saveAuthCache();
                AuthInfoRes authInfoRes = new AuthInfoRes();
                authInfoRes.setExpireTime(Long.valueOf(AuthApiImpl.expireTime));
                authInfoRes.setToken(AuthApiImpl.token);
                authInfoRes.setAppId(AuthApiImpl.appId);
                authInfoRes.setProductKey(AuthApiImpl.productKey);
                authInfoRes.setDeviceName(AuthApiImpl.deviceName);
                authInfoRes.setBusinessSign(AuthApiImpl.businessSign);
                authInfoRes.setTimestamp(AliAgentImpl.sGetSignTimestamp);
                authInfoRes.setSignMethod(AuthInfoRes.DEFAULT_SIGN_METHOD);
                IAuthInfoUpdateCallback iAuthInfoUpdateCallback3 = iAuthInfoUpdateCallback;
                if (iAuthInfoUpdateCallback3 != null) {
                    iAuthInfoUpdateCallback3.onUpdateSuccess(authInfoRes);
                }
            }

            @Override // com.starburst.sdk.core.auth.callback.TokenReceivedCallback
            public void onTokenReceivedFailed(String str3) {
                j.i(AuthApiImpl.TAG, "refresh expired token failed: " + str3);
                IAuthInfoUpdateCallback iAuthInfoUpdateCallback2 = iAuthInfoUpdateCallback;
                if (iAuthInfoUpdateCallback2 != null) {
                    iAuthInfoUpdateCallback2.onUpdateFailed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveAuthCache() {
        AuthCache authCache = new AuthCache();
        authCache.setDs(deviceSecret);
        authCache.setExpiretime(expireTime);
        authCache.setToken(token);
        authCache.setAppId(appId);
        authCache.setSign2(businessSign);
        authCache.setTimestamp2(AliAgentImpl.sGetSignTimestamp);
        authCache.setPpeEnv(ppeEnv);
        authCache.setPpeEnvCached(true);
        String json = com.starburst.sdk.utils.e.f16447a.toJson(authCache);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(productKey.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            byte[] bArrEncodeByCBC = AesCbcTools.encodeByCBC(bArrDigest, bArrDigest, json.getBytes());
            h.a().c(productKey + "###" + deviceName, ByteTools.byteArrToHex(bArrEncodeByCBC));
        } catch (Exception e9) {
            j.j(TAG, "Save auth cache failed", e9);
        }
    }

    public static void setIsAuthSuccess(boolean z8) {
        isAuthSuccess = z8;
        if (z8) {
            return;
        }
        clearAuthedDevices();
    }

    @Override // com.starburst.sdk.core.auth.api.IAuthApi
    public void addLpConnectStateCallback(IConnectCallback iConnectCallback) {
        j.f(TAG, "addLpConnectStateCallback");
        if (this.mConnectCallbacks.contains(iConnectCallback)) {
            return;
        }
        this.mConnectCallbacks.add(iConnectCallback);
    }

    public void clearAuthenticating() {
        this.authenticatingDeviceName = null;
        j.f(TAG, "clearAuthenticating");
    }

    @Override // com.starburst.sdk.core.auth.api.IAuthApi
    public void disconnect(BluetoothDeviceBean bluetoothDeviceBean) {
        clearAuthenticatingIfMatches(bluetoothDeviceBean != null ? bluetoothDeviceBean.getDeviceName() : null);
        String authDeviceKey = getAuthDeviceKey(bluetoothDeviceBean);
        if (!TextUtils.isEmpty(authDeviceKey)) {
            Set<String> set = sAuthedDeviceIds;
            set.remove(authDeviceKey);
            if (set.isEmpty()) {
                isAuthSuccess = false;
            }
        }
        Iterator<IConnectCallback> it = this.mConnectCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onIotDisconnected(bluetoothDeviceBean);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.starburst.sdk.core.auth.AuthApiImpl] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [long] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.StringBuilder] */
    @Override // com.starburst.sdk.core.auth.api.IAuthApi
    public void doConnect(final BluetoothDeviceBean bluetoothDeviceBean, String str, String str2, String str3) {
        String str4 = str;
        ?? adjustedTime = str2;
        p142s2.j.j(b.g0("doConnect==", adjustedTime, "=="), deviceName, TAG);
        if (!TextUtils.isEmpty(deviceName) && !TextUtils.equals(deviceName, adjustedTime)) {
            setIsAuthSuccess(false);
            token = null;
            expireTime = 0L;
            deviceSecret = null;
            productSecret = null;
        }
        String strB = h.a().b(str4 + "###" + adjustedTime);
        StringBuilder sb = new StringBuilder("auth cache = ");
        sb.append(strB);
        j.u(TAG, sb.toString());
        if (TextUtils.isEmpty(strB)) {
            adjustedTime = adjustedTime;
        } else {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str4.getBytes());
                byte[] bArrDigest = messageDigest.digest();
                String string = ByteTools.getString(AesCbcTools.decodeByCBC(bArrDigest, bArrDigest, ByteTools.hexToByteArr(strB)), "UTF8");
                AuthCache authCache = (AuthCache) com.starburst.sdk.utils.e.b(AuthCache.class, string);
                j.u(TAG, "auth cacheData = " + string);
                j.f(TAG, "outtime--" + getAuthCacheValidUntil(authCache));
                ?? sb2 = new StringBuilder("Systime--");
                adjustedTime = NtpTimeSync.getAdjustedTime();
                sb2.append(adjustedTime);
                j.f(TAG, sb2.toString());
                try {
                    if (isAuthCacheValid(authCache)) {
                        if (TextUtils.isEmpty(authCache.getAppId())) {
                            j.f(TAG, "cache appId empty, fallback to re-auth");
                        } else {
                            ?? r8 = adjustedTime;
                            try {
                                hasAuth(bluetoothDeviceBean, str4, r8, authCache.getDs(), authCache.getExpiretime(), authCache.getSign2(), authCache.getToken(), authCache.getTimestamp2(), authCache.getAppId(), authCache.getPpeEnv());
                                return;
                            } catch (Exception e9) {
                                e = e9;
                                str4 = str4;
                                adjustedTime = r8;
                            }
                        }
                        j.j(TAG, "doConnect: decode auth cache failed", e);
                    } else {
                        k.e(null);
                    }
                } catch (Exception e10) {
                    e = e10;
                    adjustedTime = adjustedTime;
                }
            } catch (Exception e11) {
                e = e11;
                adjustedTime = adjustedTime;
            }
        }
        deviceName = adjustedTime;
        productKey = str4;
        StringBuilder sbJ = f.j("doConnect ==> productKey = ", str4, ", deviceName = ", adjustedTime, " AliAgentImpl.sAuthTimestamp ==> ");
        sbJ.append(AliAgentImpl.sAuthTimestamp);
        sbJ.append(", sign = ");
        sbJ.append(str3);
        j.u(TAG, sbJ.toString());
        StarBurstAuthImpl.getInstance().getTokenInfo(str4, str2, str3, "hmacsha1", Long.parseLong(AliAgentImpl.sAuthTimestamp), new TokenReceivedCallback() { // from class: com.starburst.sdk.core.auth.AuthApiImpl.1
            @Override // com.starburst.sdk.core.auth.callback.TokenReceivedCallback
            public void onTokenReceived(GetTokenResponseBean getTokenResponseBean) {
                j.u(AuthApiImpl.TAG, "getTokenInfo = " + getTokenResponseBean);
                if (TextUtils.isEmpty(getTokenResponseBean.getToken())) {
                    return;
                }
                AuthApiImpl.token = getTokenResponseBean.getToken();
                AuthApiImpl.expireTime = getTokenResponseBean.getExpireTime();
                String unused = AuthApiImpl.ppeEnv = getTokenResponseBean.getPpeEnv();
                if (!TextUtils.isEmpty(getTokenResponseBean.getAppId())) {
                    AuthApiImpl.appId = getTokenResponseBean.getAppId();
                }
                AiAgentSdk.getInstance().getAgent().getSignByTokenFromDevice(bluetoothDeviceBean, getTokenResponseBean.getToken(), String.valueOf(NtpTimeSync.getAdjustedTime()), getTokenResponseBean.getAppId());
            }

            @Override // com.starburst.sdk.core.auth.callback.TokenReceivedCallback
            public void onTokenReceivedFailed(String str5) {
                AuthApiImpl.this.clearAuthenticating();
                Iterator it = AuthApiImpl.this.mConnectCallbacks.iterator();
                while (it.hasNext()) {
                    ((IConnectCallback) it.next()).onIotConnectFailure(bluetoothDeviceBean, str5, -1);
                }
            }
        });
    }

    @Override // com.starburst.sdk.core.auth.api.IAuthApi
    public void doRegister(final BluetoothDeviceBean bluetoothDeviceBean, final String str, String str2, String str3, final String str4, final String str5, final IRegisterCallback iRegisterCallback) {
        StarBurstAuthImpl.getInstance().registerDevice(str, str2, str4, str3, "hmacsha1", new IDeviceRegisterCallback() { // from class: com.starburst.sdk.core.auth.AuthApiImpl.3
            @Override // com.starburst.sdk.core.auth.callback.IDeviceRegisterCallback
            public void onDeviceRegisterFailed(String str6) {
                j.i(AuthApiImpl.TAG, "register failed: " + str6);
                AuthApiImpl.this.clearAuthenticating();
                IRegisterCallback iRegisterCallback2 = iRegisterCallback;
                if (iRegisterCallback2 != null) {
                    iRegisterCallback2.onRegisterFailed(bluetoothDeviceBean, str6, -100);
                }
            }

            @Override // com.starburst.sdk.core.auth.callback.IDeviceRegisterCallback
            public void onDeviceRegisterSuccess(DeviceRegisterRespBean deviceRegisterRespBean) {
                j.u(AuthApiImpl.TAG, "register success ==> " + deviceRegisterRespBean);
                FGSInfoConfig.sDeviceName = deviceRegisterRespBean.getDeviceName();
                FGSInfoConfig.sDeviceSecret = deviceRegisterRespBean.getDeviceSecret();
                FGSInfoConfig.sProductKey = deviceRegisterRespBean.getProductKey();
                String str6 = str4;
                FGSInfoConfig.sTimeStamp = str6;
                FGSInfoConfig.sonce = str5;
                AliAgentImpl.sAuthTimestamp = str6;
                IRegisterCallback iRegisterCallback2 = iRegisterCallback;
                if (iRegisterCallback2 != null) {
                    iRegisterCallback2.onRegisterSuccess(bluetoothDeviceBean, str, deviceRegisterRespBean.getDeviceName(), deviceRegisterRespBean.getDeviceSecret(), str4, str5);
                }
            }
        });
    }

    @Override // com.starburst.sdk.core.auth.api.IAuthApi
    public String getBusinessSign() {
        String str = businessSign;
        return str == null ? "" : str;
    }

    public void hasAuth(BluetoothDeviceBean bluetoothDeviceBean, String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, String str8) {
        productKey = str;
        deviceName = str2;
        deviceSecret = str3;
        expireTime = j;
        businessSign = str4;
        token = str5;
        appId = str7;
        ppeEnv = str8;
        k.e(str8);
        AliAgentImpl.sGetSignTimestamp = str6;
        j.f(TAG, "hasAuth");
        ConnectedDeviceManager.getInstance().addDevice(bluetoothDeviceBean);
        List<BluetoothDeviceBean> devicesWithDeviceName = getDevicesWithDeviceName(str2);
        boolean zIsEmpty = devicesWithDeviceName.isEmpty();
        List<BluetoothDeviceBean> list = devicesWithDeviceName;
        if (zIsEmpty) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bluetoothDeviceBean);
            list = arrayList;
        }
        clearAuthenticating();
        ArrayList<BluetoothDeviceBean> arrayList2 = new ArrayList();
        boolean z8 = false;
        for (BluetoothDeviceBean bluetoothDeviceBean2 : list) {
            if (markAuthedIfFirstTime(bluetoothDeviceBean2)) {
                arrayList2.add(bluetoothDeviceBean2);
                z8 = true;
            }
        }
        if (z8) {
            isAuthSuccess = true;
            for (BluetoothDeviceBean bluetoothDeviceBean3 : arrayList2) {
                for (IConnectCallback iConnectCallback : this.mConnectCallbacks) {
                    iConnectCallback.onIotConnected(bluetoothDeviceBean3);
                    iConnectCallback.onAuthentication(bluetoothDeviceBean3);
                }
            }
            return;
        }
        for (BluetoothDeviceBean bluetoothDeviceBean4 : list) {
            for (IConnectCallback iConnectCallback2 : this.mConnectCallbacks) {
                if (iConnectCallback2.getClass().getSimpleName().equals("AliAgentImpl")) {
                    j.f(TAG, "IConnectCallback ==> AliAgentImpl--".concat(iConnectCallback2.getClass().getSimpleName()));
                    iConnectCallback2.onIotConnected(bluetoothDeviceBean4);
                }
            }
        }
    }

    public boolean isAuthenticatingForDeviceName(String str) {
        return str != null && str.equals(this.authenticatingDeviceName);
    }

    @Override // com.starburst.sdk.core.auth.api.IAuthApi
    public void onSignUpdated(BluetoothDeviceBean bluetoothDeviceBean, String str) {
        j.u(TAG, "(onSignUpdated) sign ==> " + str);
        businessSign = str;
        j.u(TAG, "expireTime = " + expireTime + ", token = " + token + ", appId = " + appId + ", productKey = " + productKey + ", deviceName = " + deviceName + ", businessSign = " + businessSign);
        ConnectedDeviceManager.getInstance().addDevice(bluetoothDeviceBean);
        if (this.authInfoUpdateCallback != null) {
            AuthInfoRes authInfoRes = new AuthInfoRes();
            authInfoRes.setExpireTime(Long.valueOf(expireTime));
            authInfoRes.setToken(token);
            authInfoRes.setAppId(appId);
            authInfoRes.setProductKey(productKey);
            authInfoRes.setDeviceName(deviceName);
            authInfoRes.setBusinessSign(getBusinessSign());
            authInfoRes.setTimestamp(AliAgentImpl.sGetSignTimestamp);
            authInfoRes.setSignMethod(AuthInfoRes.DEFAULT_SIGN_METHOD);
            this.authInfoUpdateCallback.onUpdateSuccess(authInfoRes);
            this.authInfoUpdateCallback = null;
        }
        AuthCache authCache = new AuthCache();
        authCache.setDs(deviceSecret);
        authCache.setExpiretime(expireTime);
        authCache.setToken(token);
        authCache.setAppId(appId);
        authCache.setSign2(businessSign);
        authCache.setTimestamp2(AliAgentImpl.sGetSignTimestamp);
        authCache.setPpeEnv(ppeEnv);
        authCache.setPpeEnvCached(true);
        String json = com.starburst.sdk.utils.e.f16447a.toJson(authCache);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(productKey.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            byte[] bArrEncodeByCBC = AesCbcTools.encodeByCBC(bArrDigest, bArrDigest, json.getBytes());
            h.a().c(productKey + "###" + deviceName, ByteTools.byteArrToHex(bArrEncodeByCBC));
        } catch (Exception e9) {
            j.j(TAG, "onSignUpdated failed", e9);
        }
        List<BluetoothDeviceBean> devicesWithDeviceName = getDevicesWithDeviceName(deviceName);
        boolean zIsEmpty = devicesWithDeviceName.isEmpty();
        List<BluetoothDeviceBean> list = devicesWithDeviceName;
        if (zIsEmpty) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bluetoothDeviceBean);
            list = arrayList;
        }
        clearAuthenticating();
        ArrayList<BluetoothDeviceBean> arrayList2 = new ArrayList();
        for (BluetoothDeviceBean bluetoothDeviceBean2 : list) {
            if (markAuthedIfFirstTime(bluetoothDeviceBean2)) {
                arrayList2.add(bluetoothDeviceBean2);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        isAuthSuccess = true;
        for (BluetoothDeviceBean bluetoothDeviceBean3 : arrayList2) {
            for (IConnectCallback iConnectCallback : this.mConnectCallbacks) {
                if (iConnectCallback.getClass().getSimpleName().equals("AliAgentImpl")) {
                    j.f(TAG, "IConnectCallback ==> AliAgentImpl--".concat(iConnectCallback.getClass().getSimpleName()));
                    iConnectCallback.onIotConnected(bluetoothDeviceBean3);
                    iConnectCallback.onAuthentication(bluetoothDeviceBean3);
                }
            }
        }
        for (BluetoothDeviceBean bluetoothDeviceBean4 : arrayList2) {
            for (IConnectCallback iConnectCallback2 : this.mConnectCallbacks) {
                j.f(TAG, "IConnectCallback ==> ".concat(iConnectCallback2.getClass().getSimpleName()));
                if (!iConnectCallback2.getClass().getSimpleName().equals("AliAgentImpl")) {
                    iConnectCallback2.onIotConnected(bluetoothDeviceBean4);
                    iConnectCallback2.onAuthentication(bluetoothDeviceBean4);
                }
            }
        }
    }

    public void setAuthenticatingDeviceName(String str) {
        this.authenticatingDeviceName = str;
        a56.a56("setAuthenticatingDeviceName ", str, TAG);
    }

    @Override // com.starburst.sdk.core.auth.api.IAuthApi
    public void updateToken(IAuthInfoUpdateCallback iAuthInfoUpdateCallback) {
        String str;
        long adjustedTime = NtpTimeSync.getAdjustedTime();
        boolean z8 = expireTime > adjustedTime;
        StringBuilder sb = new StringBuilder("updateToken() ENTER callbackNull=");
        sb.append(iAuthInfoUpdateCallback == null);
        sb.append(" now=");
        sb.append(adjustedTime);
        sb.append(" expireTime=");
        sb.append(expireTime);
        sb.append(" notExpired=");
        sb.append(z8);
        sb.append(" appId=");
        sb.append(appId);
        sb.append(" productKey=");
        sb.append(productKey);
        sb.append(" deviceName=");
        sb.append(deviceName);
        sb.append(" tokenNull=");
        sb.append(token == null);
        sb.append(" tokenLen=");
        String str2 = token;
        sb.append(str2 == null ? -1 : str2.length());
        sb.append(" deviceSecretEmpty=");
        sb.append(TextUtils.isEmpty(deviceSecret));
        sb.append(" deviceSecretLen=");
        String str3 = deviceSecret;
        b89.a56(sb, str3 != null ? str3.length() : -1, TAG);
        if (z8) {
            j.f(TAG, "updateToken ==> token is not expired, do nothing");
            str = "updateToken() EXIT (not expired)";
        } else {
            j.f(TAG, "updateToken ==> token is expired");
            if (!TextUtils.isEmpty(deviceSecret)) {
                refreshExpiredToken(iAuthInfoUpdateCallback);
                return;
            }
            StringBuilder sb2 = new StringBuilder("deviceSecret is empty => save callback and call deviceConnect() agentSdk=");
            sb2.append(AiAgentSdk.getInstance());
            sb2.append(" agent=");
            sb2.append(AiAgentSdk.getInstance() != null ? AiAgentSdk.getInstance().getAgent() : null);
            j.f(TAG, sb2.toString());
            this.authInfoUpdateCallback = iAuthInfoUpdateCallback;
            try {
                AiAgentSdk.getInstance().getAgent().deviceConnect(ConnectedDeviceManager.getInstance().getMasterDevice());
                j.f(TAG, "deviceConnect() called");
            } catch (Throwable th) {
                j.j(TAG, "deviceConnect() failed", th);
            }
            if (iAuthInfoUpdateCallback != null) {
                iAuthInfoUpdateCallback.onUpdateFailed();
            }
            str = "updateToken() EXIT (deviceConnect path)";
        }
        j.f(TAG, str);
    }
}

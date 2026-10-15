package com.engagelab.privates.common.config;

import H2.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.engagelab.privates.common.cache.MTRemoteConfig;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.https.HttpUtils;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.monitor.tcp.TCPTimeManager;
import com.engagelab.privates.common.utils.AESUtil;
import com.engagelab.privates.common.utils.GZipUtil;
import com.engagelab.privates.common.utils.SM4Util;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MTRemoteConfigHelper {
    private static final String PATH = "/report/config";
    private static final String TAG = "MTRemoteConfigHelper";

    public static class RemoteFeatureConfig {
        private boolean crashCountEnable;
        private boolean initTimeMonitorEnable;
        private long lastUpdateTime;
        private String responseString;
        private boolean sentryCrashLogEnable;
        private int version;

        public RemoteFeatureConfig(boolean z8, boolean z9, boolean z10, int i9, String str, long j) {
            this.sentryCrashLogEnable = z8;
            this.crashCountEnable = z9;
            this.initTimeMonitorEnable = z10;
            this.version = i9;
            this.responseString = str;
            this.lastUpdateTime = j;
        }

        public long getLastUpdateTime() {
            return this.lastUpdateTime;
        }

        public String getResponseString() {
            return this.responseString;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isCrashCountEnable() {
            return this.crashCountEnable;
        }

        public boolean isInitTimeMonitorEnable() {
            return this.initTimeMonitorEnable;
        }

        public boolean isSentryCrashLogEnable() {
            return this.sentryCrashLogEnable;
        }

        public String toString() {
            return "RemoteFeatureConfig{sentryCrashLogEnable=" + this.sentryCrashLogEnable + ", crashCountEnable=" + this.crashCountEnable + ", initTimeMonitorEnable=" + this.initTimeMonitorEnable + ", version=" + this.version + ", lastUpdateTime=" + this.lastUpdateTime + '}';
        }
    }

    public static RemoteFeatureConfig getLocalConfig(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String responseString = MTRemoteConfig.getResponseString(context);
            if (TextUtils.isEmpty(responseString)) {
                MTCommonLog.d(TAG, "getLocalConfig: no saved config found");
                return null;
            }
            RemoteFeatureConfig config = parseConfig(responseString, MTRemoteConfig.getLastUpdateTime(context));
            MTCommonLog.d(TAG, "getLocalConfig: " + config);
            return config;
        } catch (Throwable th) {
            a.k(th, new StringBuilder("getLocalConfig failed: "), TAG);
            return null;
        }
    }

    public static boolean isCrashCountEnabled(Context context) {
        return MTRemoteConfig.isCrashCountEnable(context);
    }

    public static MTRemoteConfig.InitTimeMonitorState isInitTimeMonitorEnabled(Context context) {
        return MTRemoteConfig.isInitTimeMonitorEnable(context);
    }

    public static boolean isSentryCrashLogEnabled(Context context) {
        return MTRemoteConfig.isSentryCrashLogEnable(context);
    }

    private static RemoteFeatureConfig parseConfig(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            MTCommonLog.w(TAG, "parseConfig failed: responseJson is empty");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sentry_crash_log");
            boolean z8 = true;
            boolean z9 = false;
            boolean z10 = jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt("enable", 0) == 1;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("crash_count");
            if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.optInt("enable", 0) != 1) {
                z8 = false;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("init_time_monitor");
            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.optInt(r5, 0) == z8) {
                z9 = true;
            }
            RemoteFeatureConfig remoteFeatureConfig = new RemoteFeatureConfig(z10, z8, z9, jSONObject.optInt("ver", 0), str, j);
            MTCommonLog.d(TAG, "parsed remote config: " + remoteFeatureConfig);
            return remoteFeatureConfig;
        } catch (Throwable th) {
            a.k(th, new StringBuilder("parseConfig failed: "), TAG);
            return null;
        }
    }

    private static void saveConfig(Context context, RemoteFeatureConfig remoteFeatureConfig) {
        if (context == null || remoteFeatureConfig == null) {
            MTCommonLog.w(TAG, "saveConfig failed: context or config is null");
            return;
        }
        try {
            MTRemoteConfig.setSentryCrashLogEnable(context, remoteFeatureConfig.isSentryCrashLogEnable());
            MTRemoteConfig.setCrashCountEnable(context, remoteFeatureConfig.isCrashCountEnable());
            MTRemoteConfig.setInitTimeMonitorEnable(context, remoteFeatureConfig.isInitTimeMonitorEnable());
            MTRemoteConfig.setVersion(context, Integer.toString(remoteFeatureConfig.getVersion()));
            MTRemoteConfig.setLastUpdateTime(context, remoteFeatureConfig.getLastUpdateTime());
            MTRemoteConfig.setResponseString(context, remoteFeatureConfig.getResponseString());
            MTCommonLog.d(TAG, "saved remote config: " + remoteFeatureConfig);
            if (remoteFeatureConfig.isInitTimeMonitorEnable()) {
                return;
            }
            MTCommonLog.d(TAG, "initTimeMonitor disabled, clearing tcp timing cache");
            TCPTimeManager.clearCache(context);
        } catch (Throwable th) {
            a.k(th, new StringBuilder("saveConfig failed: "), TAG);
        }
    }

    public static void start(Context context, List<String> list, long j, String str) {
        if (context == null) {
            MTCommonLog.w(TAG, "start failed: context is null");
            return;
        }
        if (list == null || list.isEmpty()) {
            MTCommonLog.w(TAG, "start failed: urls is null or empty");
            return;
        }
        if (!SystemUtil.isNetworkConnecting(context)) {
            MTCommonLog.d(TAG, "can't get remote config, network is disconnected");
            return;
        }
        if (j == 0) {
            MTCommonLog.d(TAG, "uid is 0, skip remote config request");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", MTGlobal.getAppKey(context));
            String version = MTRemoteConfig.getVersion(context);
            int i9 = 0;
            if (!TextUtils.isEmpty(version)) {
                try {
                    i9 = Integer.parseInt(version);
                } catch (NumberFormatException unused) {
                    MTCommonLog.w(TAG, "failed to parse local version: " + version);
                }
            }
            jSONObject.put("ver", i9);
            jSONObject.put("platform", "a");
            jSONObject.put("itime", System.currentTimeMillis());
            jSONObject.put(HiAnalyticsConstant.BI_KEY_SDK_VER, "5.4.2");
            MTCommonLog.d(TAG, "start jsonObject:" + jSONObject);
            byte[] bArrZip = GZipUtil.zip(jSONObject.toString().getBytes(MTCommonConstants.UTF_8));
            String md5AesKey = AESUtil.getMd5AesKey(AESUtil.generateSeed());
            String iv = AESUtil.getIv(new String("\u000b\r\u0012PRQRVRWRT\u00032\tC".getBytes(), Charset.forName("UTF-8")), 'b');
            int encryptType = MTGlobal.getEncryptType();
            byte[] bArrEncryptBytes = SM4Util.encryptBytes(bArrZip, md5AesKey, iv);
            String str2 = "Basic " + Base64.encodeToString((j + Constants.COLON_SEPARATOR + StringUtil.getBytesSHA1(j + StringUtil.getMD5Utf8(str) + StringUtil.getBytesSHA1(bArrEncryptBytes)) + Constants.COLON_SEPARATOR + md5AesKey).getBytes(), 10);
            HashMap map = new HashMap();
            map.put("Authorization", str2);
            map.put("Charset", MTCommonConstants.UTF_8);
            map.put("Accept", "application/json");
            map.put("Accept-Encoding", "gzip");
            map.put("content-type", "application/octet-stream");
            map.put("Content-Length", String.valueOf(bArrEncryptBytes.length));
            map.put("X-App-Key", MTGlobal.getAppKey(context));
            map.put("Encrypt-Type", encryptType == 2 ? "SM4" : "");
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String str3 = it.next() + PATH;
                MTCommonLog.d(TAG, "requesting remote config from: " + str3);
                Pair<Integer, byte[]> pairPostPair = HttpUtils.postPair(context, str3, map, bArrEncryptBytes, true);
                int iIntValue = ((Integer) pairPostPair.first).intValue();
                byte[] bArr = (byte[]) pairPostPair.second;
                if (iIntValue != 200 || bArr == null) {
                    MTCommonLog.w(TAG, "remote config request failed, code: " + iIntValue + ", url: " + str3);
                } else {
                    MTCommonLog.d(TAG, "remote config request success from: " + str3);
                    String str4 = new String(GZipUtil.unzip(bArr), MTCommonConstants.UTF_8);
                    MTCommonLog.d(TAG, "remote config response: " + str4);
                    if (TextUtils.isEmpty(str4)) {
                        MTCommonLog.w(TAG, "response string is empty");
                    } else {
                        RemoteFeatureConfig config = parseConfig(str4, System.currentTimeMillis());
                        if (config != null) {
                            saveConfig(context, config);
                            MTCommonLog.d(TAG, "remote config saved: " + config);
                            return;
                        }
                        MTCommonLog.w(TAG, "failed to parse remote config");
                    }
                }
            }
            MTCommonLog.w(TAG, "all remote config requests failed");
        } catch (Throwable th) {
            a.k(th, new StringBuilder("start failed: "), TAG);
        }
    }
}

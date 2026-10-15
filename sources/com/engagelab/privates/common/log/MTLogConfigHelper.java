package com.engagelab.privates.common.log;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.engagelab.privates.common.MTCommon;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.cache.MTLogConfig;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.https.HttpUtils;
import com.engagelab.privates.common.utils.AESUtil;
import com.engagelab.privates.common.utils.GZipUtil;
import com.engagelab.privates.common.utils.SM4Util;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MTLogConfigHelper {
    private static final String KEY_CAPACITY = "key_capacity";
    private static final String KEY_ENABLE = "key_enable";
    private static final String KEY_ENABLE_ALL = "key_enable_all";
    private static final String TAG = "MTLogConfigHelper";
    public static final String THREAD_LOG = MTCommonConstants.getLogTag() + "COMMON_LOG";

    public static class Report {

        public static class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f12297a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f12298b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f12299c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f12300d;

            public a(Context context, long j, List list, String str) {
                this.f12297a = context;
                this.f12298b = j;
                this.f12299c = list;
                this.f12300d = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                List<File> allClosedLogFiles = MTCommonLog.getAllClosedLogFiles();
                if (allClosedLogFiles == null || allClosedLogFiles.isEmpty()) {
                    MTCommonLog.d(MTLogConfigHelper.TAG, "no closed log files to upload");
                    return;
                }
                if (!SystemUtil.isNetworkConnecting(this.f12297a)) {
                    MTCommonLog.d(MTLogConfigHelper.TAG, "can't upload log files, network is disconnected");
                    return;
                }
                if (this.f12298b == 0) {
                    MTCommonLog.d(MTLogConfigHelper.TAG, "uid is 0, skip log upload");
                    return;
                }
                List list = this.f12299c;
                if (list == null || list.isEmpty()) {
                    MTCommonLog.w(MTLogConfigHelper.TAG, "report failed: urls is null or empty");
                    return;
                }
                for (File file : allClosedLogFiles) {
                    if (file == null || !file.exists()) {
                        MTCommonLog.w(MTLogConfigHelper.TAG, "log file is null or not exists: " + file);
                    } else {
                        Report.uploadLogFile(this.f12297a, file, this.f12299c, this.f12298b, this.f12300d);
                    }
                }
            }
        }

        private static String decodeFileData(String str, String str2) {
            return new String(GZipUtil.unzip(SM4Util.decryptBytes(Base64.decode(str, 2), StringUtil.get32MD5String("JCKP" + str2), AESUtil.getIv(new String("\u000b\r\u0012PRQRVRWRT\u00032\tC".getBytes(), Charset.forName("UTF-8")), 'b'))));
        }

        private static String getFileData(byte[] bArr, String str) {
            return Base64.encodeToString(SM4Util.encryptBytes(GZipUtil.zip(bArr), StringUtil.get32MD5String("JCKP" + str), AESUtil.getIv(new String("\u000b\r\u0012PRQRVRWRT\u00032\tC".getBytes(), Charset.forName("UTF-8")), 'b')), 2);
        }

        public static void report(Context context, List<String> list, long j, String str) {
            MTCommonPrivatesApi.postMessageDelayed(context, MTLogConfigHelper.THREAD_LOG, new a(context, j, list, str), 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void uploadLogFile(Context context, File file, List<String> list, long j, String str) {
            try {
                MTCommonLog.debugOnly(MTLogConfigHelper.TAG, "uploadLogFile logFile: " + file);
                byte[] fileBytes = MTLogConfigHelper.readFileBytes(file);
                String appKey = MTGlobal.getAppKey(context);
                String fileData = getFileData(fileBytes, appKey);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("file_name", file.getName());
                jSONObject.put("file_data", fileData);
                jSONObject.put("appkey", appKey);
                jSONObject.put("platform", "a");
                String string = jSONObject.toString();
                MTCommonLog.debugOnlyDD(MTLogConfigHelper.TAG, "uploadLogFile request body: " + string);
                byte[] bArrZip = GZipUtil.zip(string.getBytes(MTCommonConstants.UTF_8));
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
                map.put("X-App-Key", appKey);
                map.put("Encrypt-Type", encryptType == 2 ? "SM4" : "");
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String str3 = it.next() + "/log/upload";
                    MTCommonLog.d(MTLogConfigHelper.TAG, "uploading log file to: " + str3);
                    Pair<Integer, byte[]> pairPostPair = HttpUtils.postPair(context, str3, map, bArrEncryptBytes, true);
                    int iIntValue = ((Integer) pairPostPair.first).intValue();
                    if (iIntValue == 200) {
                        MTCommonLog.d(MTLogConfigHelper.TAG, "log file upload success to: " + file);
                        if (file.delete()) {
                            MTCommonLog.d(MTLogConfigHelper.TAG, "deleted uploaded log file: " + file);
                            return;
                        }
                        MTCommonLog.w(MTLogConfigHelper.TAG, "failed to delete uploaded log file: " + file);
                        return;
                    }
                    MTCommonLog.w(MTLogConfigHelper.TAG, "log file upload failed, code: " + iIntValue + ", url: " + file);
                }
                MTCommonLog.w(MTLogConfigHelper.TAG, "all log file upload requests failed for file: " + file);
            } catch (Throwable th) {
                MTCommonLog.w(MTLogConfigHelper.TAG, "uploadLogFile failed for file: " + file.getName() + ", error: " + th.getMessage());
            }
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12301a;

        public a(Context context) {
            this.f12301a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            MTCommonLog.d(MTLogConfigHelper.TAG, "sendReport run");
            MTCommonPrivatesApi.sendMessageToRemoteProcess(this.f12301a, MTCommonConstants.RemoteWhat.ON_LOG_CACHE_REPORT, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readFileBytes(File file) throws Throwable {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                    return bArr;
                } catch (IOException e9) {
                    MTCommonLog.w(TAG, "close file input stream failed: " + e9.getMessage());
                    return bArr;
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e10) {
                        MTCommonLog.w(TAG, "close file input stream failed: " + e10.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static void sendReport(Context context) {
        Ctrl.a localCtrlConfig = Ctrl.getLocalCtrlConfig(context);
        MTCommonLog.d(TAG, "sendReport ctrlConfig: " + localCtrlConfig);
        if (localCtrlConfig != null) {
            if (localCtrlConfig.e()) {
                MTCommonLog.d(TAG, "sendReport isExpired: true");
            } else {
                if (!localCtrlConfig.f()) {
                    MTCommonLog.d(TAG, "sendReport isLogEnable: false");
                    return;
                }
                MTCommonPrivatesApi.postMessageDelayed(context, MTCommon.THREAD_COMMON, new a(context.getApplicationContext()), localCtrlConfig.b() * 1000);
            }
        }
    }

    private static void sendUpdateEnabledAll(Context context, boolean z8) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(KEY_ENABLE_ALL, z8);
        MTCommonPrivatesApi.sendMessageToMainProcess(context, MTCommonConstants.MainWhat.ON_UPDATE_LOG_CACHE_CONFIG, bundle);
    }

    public static void updateLogCacheConfigMain(Context context, Bundle bundle) {
        if (bundle.containsKey(KEY_CAPACITY) && bundle.containsKey(KEY_ENABLE)) {
            long j = bundle.getLong(KEY_CAPACITY);
            boolean z8 = bundle.getBoolean(KEY_ENABLE);
            MTCommonLog.d(TAG, "updateLogCacheConfigMain enable: " + z8);
            MTCommonLog.d(TAG, "updateLogCacheConfigMain maxTotalSize: " + j);
            MTCommonLog.setMaxTotalSize(j);
            MTCommonLog.setLogCacheEnabled(z8);
        }
        if (bundle.containsKey(KEY_ENABLE_ALL)) {
            boolean z9 = bundle.getBoolean(KEY_ENABLE_ALL);
            MTCommonLog.d(TAG, "updateLogCacheConfigMain enableAll: " + z9);
            MTCommonLog.setLogCacheEnabledAll(z9);
        }
    }

    public static void updateLogCtrlConfig(Context context) {
        Ctrl.a localCtrlConfig = Ctrl.getLocalCtrlConfig(context);
        MTCommonLog.d(TAG, "updateLogCtrlConfig ctrlConfig: " + localCtrlConfig);
        if (localCtrlConfig == null) {
            MTCommonLog.setReuseActiveFile(true);
            return;
        }
        boolean zF = localCtrlConfig.f();
        if (localCtrlConfig.e()) {
            zF = false;
        }
        MTCommonLog.setReuseActiveFile(!zF);
        MTCommonLog.setLogCacheEnabledAll(zF);
        sendUpdateEnabledAll(context, zF);
    }

    public static class Ctrl {

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f12292a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12293b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f12294c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f12295d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public long f12296e;

            public a(boolean z8, int i9, int i10, String str, long j) {
                this.f12292a = z8;
                this.f12293b = i9;
                this.f12294c = i10;
                this.f12295d = str;
                this.f12296e = j;
            }

            public String a() {
                return this.f12295d;
            }

            public int b() {
                return this.f12294c;
            }

            public int c() {
                return this.f12293b;
            }

            public long d() {
                return this.f12296e;
            }

            public boolean e() {
                if (this.f12293b <= 0) {
                    return false;
                }
                return System.currentTimeMillis() > (((long) (this.f12293b * RemoteMessageConst.DEFAULT_TTL)) * 1000) + this.f12296e;
            }

            public boolean f() {
                return this.f12292a;
            }

            public String toString() {
                return "CtrlConfig{logEnable=" + this.f12292a + ", expire=" + this.f12293b + ", delayUpload=" + this.f12294c + ", content='" + this.f12295d + "', updateTime=" + this.f12296e + ", isExpired=" + e() + '}';
            }
        }

        public static void ctrl(Context context, int i9, String str) {
            if (context == null) {
                MTCommonLog.w(MTLogConfigHelper.TAG, "ctrl failed: context is null");
                return;
            }
            if (82 == i9) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        MTCommonLog.w(MTLogConfigHelper.TAG, "ctrl: content is empty for cmd 82");
                        return;
                    }
                    MTCommonLog.d(MTLogConfigHelper.TAG, "ctrl: content is valid, parsing and saving");
                    a content = parseContent(str);
                    if (content == null) {
                        MTCommonLog.w(MTLogConfigHelper.TAG, "ctrl: failed to parse content");
                        return;
                    }
                    saveCtrlConfig(context, content);
                    MTLogConfigHelper.updateLogCtrlConfig(context);
                    MTCommonLog.d(MTLogConfigHelper.TAG, "ctrl: saved log config from content - enable: " + content.f() + ", expire: " + content.c() + " days, delayUpload: " + content.b() + " seconds");
                } catch (Throwable th) {
                    H2.a.k(th, new StringBuilder("ctrl failed: "), MTLogConfigHelper.TAG);
                }
            }
        }

        public static a getLocalCtrlConfig(Context context) {
            if (context == null) {
                MTCommonLog.w(MTLogConfigHelper.TAG, "getLocalCtrlConfig failed: context is null");
                return null;
            }
            try {
                String ctrlConfigContent = MTLogConfig.getCtrlConfigContent(context);
                long ctrlConfigUpdateTime = MTLogConfig.getCtrlConfigUpdateTime(context);
                if (TextUtils.isEmpty(ctrlConfigContent)) {
                    MTCommonLog.d(MTLogConfigHelper.TAG, "getLocalCtrlConfig: no saved content found");
                    return null;
                }
                a content = parseContent(ctrlConfigContent, ctrlConfigUpdateTime);
                MTCommonLog.d(MTLogConfigHelper.TAG, "getLocalCtrlConfig: " + content);
                return content;
            } catch (Throwable th) {
                H2.a.k(th, new StringBuilder("getLocalCtrlConfig failed: "), MTLogConfigHelper.TAG);
                return null;
            }
        }

        private static a parseContent(String str, long j) {
            if (TextUtils.isEmpty(str)) {
                MTCommonLog.w(MTLogConfigHelper.TAG, "parseContent failed: content is empty");
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(jSONObject.optInt("log_enable", 0) == 1, jSONObject.optInt("expire", 7), jSONObject.optInt("delay_upload", 10), str, j > 0 ? j : System.currentTimeMillis());
                MTCommonLog.d(MTLogConfigHelper.TAG, "parsed ctrl config: " + aVar);
                return aVar;
            } catch (Throwable th) {
                H2.a.k(th, new StringBuilder("parseContent failed: "), MTLogConfigHelper.TAG);
                return null;
            }
        }

        private static void saveCtrlConfig(Context context, a aVar) {
            if (context == null || aVar == null) {
                MTCommonLog.w(MTLogConfigHelper.TAG, "saveCtrlConfig failed: context or config is null");
                return;
            }
            try {
                MTLogConfig.setCtrlConfigContent(context, aVar.a());
                MTLogConfig.setCtrlConfigUpdateTime(context, aVar.d());
                MTCommonLog.d(MTLogConfigHelper.TAG, "saved ctrl config: " + aVar);
            } catch (Throwable th) {
                H2.a.k(th, new StringBuilder("saveCtrlConfig failed: "), MTLogConfigHelper.TAG);
            }
        }

        private static a parseContent(String str) {
            return parseContent(str, 0L);
        }
    }
}

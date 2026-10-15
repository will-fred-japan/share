package com.engagelab.privates.common.sentry;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.cache.MTRemoteConfig;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.engagelab.privates.common.sentry.entity.Mechanism;
import com.engagelab.privates.common.sentry.entity.Session;
import com.engagelab.privates.common.utils.DateUtil;
import com.engagelab.privates.common.utils.FileUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SentryCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String CRASH_JSON_KEY_TYPE = "type";
    private static final String EVENT = "event";
    public static final String KEY_SENTRY_ENVELOPE_FILE = "sentry_envelope_file";
    public static final String PATH = "sentry";
    private static final String SESSION = "session";
    public static final String SUFFIX_ENVELOPE_FILE = ".envelope";
    private static final String TAG = "SentryCrashHandler";
    private static SentryCrashHandler instance = new SentryCrashHandler();
    private Thread.UncaughtExceptionHandler mDefaultHandler = null;
    private Scope scope = new Scope();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12371a;

        /* JADX INFO: renamed from: com.engagelab.privates.common.sentry.SentryCrashHandler$a$a, reason: collision with other inner class name */
        public class RunnableC0154a implements Runnable {

            /* JADX INFO: renamed from: com.engagelab.privates.common.sentry.SentryCrashHandler$a$a$a, reason: collision with other inner class name */
            public class C0155a implements FilenameFilter {
                public C0155a(RunnableC0154a runnableC0154a) {
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return str.endsWith(SentryCrashHandler.SUFFIX_ENVELOPE_FILE);
                }
            }

            public RunnableC0154a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles;
                String appKey = MTGlobal.getAppKey(a.this.f12371a);
                if (TextUtils.isEmpty(appKey)) {
                    MTCommonLog.w(SentryCrashHandler.TAG, "reportCrashLog appKey empty");
                    return;
                }
                File file = new File(a.this.f12371a.getFilesDir(), A.a.j(p171w.a.b(appKey), File.separator, SentryCrashHandler.PATH));
                if (file.exists() && file.isDirectory() && file.canRead() && (fileArrListFiles = file.listFiles(new C0155a(this))) != null) {
                    for (File file2 : fileArrListFiles) {
                        String str = FileUtils.read2Str(file2);
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                a aVar = a.this;
                                SentryCrashHandler.this.reportCrashLog(aVar.f12371a, jSONObject, file2.getAbsolutePath());
                            } catch (JSONException e9) {
                                MTCommonLog.w(SentryCrashHandler.TAG, "reportCrashLog parse json fail " + e9.getMessage());
                            }
                        }
                    }
                }
            }
        }

        public a(Context context) {
            this.f12371a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            new Thread(new RunnableC0154a(), "SentryCrashReport").start();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f12375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12376c;

        public b(SentryCrashHandler sentryCrashHandler, Context context, JSONObject jSONObject, String str) {
            this.f12374a = context;
            this.f12375b = jSONObject;
            this.f12376c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context applicationContext = this.f12374a.getApplicationContext();
            Bundle bundleBuildReportBundle = SentryCrashHandler.buildReportBundle(this.f12375b, this.f12376c);
            if (bundleBuildReportBundle == null) {
                MTCommonLog.w(SentryCrashHandler.TAG, "reportBundle is null, skip");
            } else {
                MTCommonPrivatesApi.sendMessageToRemoteProcess(applicationContext, MTCommonConstants.RemoteWhat.ON_REPORT, bundleBuildReportBundle);
            }
        }
    }

    private SentryCrashHandler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle buildReportBundle(JSONObject jSONObject, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MTCommonConstants.Protocol.KEY_COMMON_REPORTER, new MTCommonReporter().setType(jSONObject.optString("type", "sentry_crash_log")).setContent(jSONObject.toString()));
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(KEY_SENTRY_ENVELOPE_FILE, str);
        }
        bundle.putBoolean("no_cache", true);
        return bundle;
    }

    private JSONObject generalJSONLog(Context context, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "sentry_crash_log");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject sentryEventEnvelopeItem = ExceptionParseUtils.getSentryEventEnvelopeItem(context, th);
            if (sentryEventEnvelopeItem == null || sentryEventEnvelopeItem.length() == 0) {
                return null;
            }
            jSONObject2.put("sentry_envelope_item_header", ExceptionParseUtils.getSentryEnvelopeItemHeader("event", utf8JsonByteLength(sentryEventEnvelopeItem)));
            jSONObject2.put("sentry_envelope_item", sentryEventEnvelopeItem);
            jSONArray.put(jSONObject2);
            jSONObject.put("sentry_envelope_header", ExceptionParseUtils.getSentryEnvelopeHeader(true));
            Session sessionWithSession = this.scope.withSession();
            if (sessionWithSession != null) {
                sessionWithSession.update(Session.State.Crashed, "", true);
                JSONObject sentrySessionEnvelopeItem = ExceptionParseUtils.getSentrySessionEnvelopeItem(context, sessionWithSession);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sentry_envelope_item_header", ExceptionParseUtils.getSentryEnvelopeItemHeader(SESSION, utf8JsonByteLength(sentrySessionEnvelopeItem)));
                jSONObject3.put("sentry_envelope_item", sentrySessionEnvelopeItem);
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("sentry_envelope_items", jSONArray);
            return jSONObject;
        } catch (Throwable th2) {
            MTCommonLog.e(TAG, "generalJSONLog error : " + th2.getMessage());
            return null;
        }
    }

    public static SentryCrashHandler getInstance() {
        return instance;
    }

    private Throwable getUnhandledThrowable(Thread thread, Throwable th) {
        Mechanism mechanism = new Mechanism();
        mechanism.setHandled(Boolean.FALSE);
        mechanism.setType("UncaughtExceptionHandler");
        return new ExceptionMechanismException(mechanism, th, thread);
    }

    private static int utf8JsonByteLength(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.toString().getBytes(StandardCharsets.UTF_8).length;
    }

    public void deleteSentryEnvelopeIfPresent(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            String string = bundle.getString(KEY_SENTRY_ENVELOPE_FILE);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            File file = new File(string);
            if (file.exists() && file.isFile()) {
                boolean zDelete = file.delete();
                StringBuilder sb = new StringBuilder("sentry envelope file delete ");
                sb.append(zDelete ? "ok" : "fail");
                sb.append(" path=");
                sb.append(string);
                MTCommonLog.d(TAG, sb.toString());
            }
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("deleteSentryEnvelopeIfPresent "), TAG);
        }
    }

    public void handleException(Thread thread, Throwable th) {
        MTCommonLog.d(TAG, "handleException catch exception");
        handleException(th);
    }

    public void init(Context context) {
        MTCommonLog.d(TAG, TCPTimingCache.P_INIT);
        if (SentryEntryHelper.isSentryCrashLogEnabled()) {
            this.scope.startSession();
            try {
                Session sessionWithSession = this.scope.withSession();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sentry_envelope_header", ExceptionParseUtils.getSentryEnvelopeHeader(false));
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject sentrySessionEnvelopeItem = ExceptionParseUtils.getSentrySessionEnvelopeItem(context, sessionWithSession);
                jSONObject2.put("sentry_envelope_item_header", ExceptionParseUtils.getSentryEnvelopeItemHeader(SESSION, utf8JsonByteLength(sentrySessionEnvelopeItem)));
                jSONObject2.put("sentry_envelope_item", sentrySessionEnvelopeItem);
                jSONArray.put(jSONObject2);
                jSONObject.put("sentry_envelope_items", jSONArray);
                jSONObject.put("type", "sentry_crash_log");
                MTCommonLog.d(TAG, "session is " + jSONObject.toString());
                File appKeyFile = FileUtils.getAppKeyFile(context, PATH, DateUtil.defaultFormat() + SUFFIX_ENVELOPE_FILE);
                String absolutePath = appKeyFile.getAbsolutePath();
                FileUtils.save(appKeyFile.getAbsolutePath(), jSONObject.toString());
                reportCrashLog(context, jSONObject, absolutePath);
            } catch (Throwable th) {
                MTCommonLog.e(TAG, "sentry init session error : " + th.getMessage());
            }
        }
    }

    public void reportCrashLog(Context context) {
        if (SentryEntryHelper.isSentryCrashLogEnabled()) {
            new Handler(Looper.getMainLooper()).postDelayed(new a(context.getApplicationContext()), 10000L);
        }
    }

    public void setUncaughtExceptionHandler() {
        MTCommonLog.d(TAG, "setUncaughtExceptionHandler");
        if (this.mDefaultHandler == null) {
            this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        MTCommonLog.d(TAG, "uncaughtException");
        handleException(getUnhandledThrowable(thread, th));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultHandler;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    public void handleException(Throwable th) {
        JSONObject jSONObjectGeneralJSONLog;
        Context context = MTGlobal.context;
        if (context == null) {
            MTCommonLog.w(TAG, "handleException context is null");
            return;
        }
        try {
            if (MTRemoteConfig.isCrashCountEnable(context)) {
                ExceptionParseUtils.sdkExceptionStatistics(context, th);
            }
            if (!SentryEntryHelper.isSentryCrashLogEnabled() || (jSONObjectGeneralJSONLog = generalJSONLog(context, th)) == null) {
                return;
            }
            MTCommonLog.d(TAG, "crash log is : " + jSONObjectGeneralJSONLog.toString());
            File appKeyFile = FileUtils.getAppKeyFile(context, PATH, DateUtil.defaultFormat() + SUFFIX_ENVELOPE_FILE);
            String absolutePath = appKeyFile.getAbsolutePath();
            FileUtils.save(appKeyFile.getAbsolutePath(), jSONObjectGeneralJSONLog.toString());
            reportCrashLog(context, jSONObjectGeneralJSONLog, absolutePath);
        } catch (Throwable th2) {
            H2.a.i("handleException error: ", TAG, th2);
        }
    }

    public void reportCrashLog(Context context, JSONObject jSONObject, String str) {
        if (SentryEntryHelper.isSentryCrashLogEnabled()) {
            if (context == null) {
                MTCommonLog.w(TAG, "Action - reportCrashLog context is null");
            } else {
                if (jSONObject == null) {
                    return;
                }
                try {
                    new Thread(new b(this, context, jSONObject, str), "SentryCrashSend").start();
                } catch (Throwable th) {
                    H2.a.i("report crash e:", TAG, th);
                }
            }
        }
    }
}

package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class HMSBIInitializer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f15608d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HMSBIInitializer f15609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static HiAnalyticsInstance f15610f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f15612b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15613c = HianalyticsExist.isHianalyticsExist();

    public class a implements IQueryUrlCallBack {
        public a() {
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int i9) {
            HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i9);
            HMSBIInitializer.this.f15612b.set(false);
            com.huawei.hms.stats.a.c().a();
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (HMSBIInitializer.this.f15613c) {
                        HMSBIInitializer.this.a(str);
                    } else {
                        HmsHiAnalyticsUtils.init(HMSBIInitializer.this.f15611a, false, false, false, str, "com.huawei.hwid");
                    }
                    HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
                } catch (Throwable th) {
                    HMSLog.e("HMSBIInitializer", "HA Init error, message : " + th.getMessage());
                }
            }
            HMSBIInitializer.this.f15612b.set(false);
            com.huawei.hms.stats.a.c().b();
        }
    }

    public class b extends AsyncTask<String, Integer, Void> {
        private b() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            HMSBIInitializer.this.b(strArr[0]);
            return null;
        }

        public /* synthetic */ b(HMSBIInitializer hMSBIInitializer, a aVar) {
            this();
        }
    }

    private HMSBIInitializer(Context context) {
        this.f15611a = context;
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (f15608d) {
            try {
                if (f15609e == null && context != null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        f15609e = new HMSBIInitializer(applicationContext);
                    } else {
                        f15609e = new HMSBIInitializer(context);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f15609e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f15610f;
    }

    public void initBI() {
        boolean initFlag = !this.f15613c ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + initFlag);
        if (initFlag || AnalyticsSwitchHolder.isAnalyticsDisabled(this.f15611a)) {
            return;
        }
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag : start initHaSDK");
        initHaSDK();
    }

    public void initHaSDK() {
        if (this.f15612b.compareAndSet(false, true)) {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.f15611a);
            if (!TextUtils.isEmpty(issueCountryCode)) {
                issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
            }
            if (!GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(issueCountryCode) && !TextUtils.isEmpty(issueCountryCode)) {
                new b(this, null).execute(issueCountryCode);
            } else {
                HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
                this.f15612b.set(false);
            }
        }
    }

    public boolean isInit() {
        return !this.f15613c ? HmsHiAnalyticsUtils.getInitFlag() : HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag(HiAnalyticsConstant.HA_SERVICE_TAG);
        f15610f = instanceByTag;
        if (instanceByTag != null) {
            instanceByTag.setAppid("com.huawei.hwid");
            return;
        }
        HiAnalyticsConfig hiAnalyticsConfigBuild = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
        HiAnalyticsInstance hiAnalyticsInstanceCreate = new HiAnalyticsInstance.Builder(this.f15611a).setOperConf(hiAnalyticsConfigBuild).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
        f15610f = hiAnalyticsInstanceCreate;
        if (hiAnalyticsInstanceCreate != null) {
            hiAnalyticsInstanceCreate.setAppid("com.huawei.hwid");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.f15611a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new a());
    }
}

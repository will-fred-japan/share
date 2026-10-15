package com.bytedance.apm.insight;

import A1.b;
import Z3.a;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import p061i1.h;

/* JADX INFO: loaded from: classes.dex */
public class ApmInsightInitConfig {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f12067A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f12068B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f12069C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public IActivityLeakListener f12070D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f12077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f12079i;
    public final boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f12080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f12081l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f12082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f12083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f12084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f12085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f12086q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f12087r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f12088s;
    public final JSONObject t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f12089u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<String> f12090v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List<String> f12091w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<String> f12092x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public IDynamicParams f12093y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f12094z;

    public static final class Builder {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public List<String> f12095A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public List<String> f12096B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public IDynamicParams f12097C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public a f12098D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f12104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f12105g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12106h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f12107i;
        public boolean j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f12108k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f12109l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f12110m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f12111n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f12112o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f12113p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f12114q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f12115r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public JSONObject f12116s;
        public boolean t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f12117u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public IActivityLeakListener f12118v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f12119w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f12120x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f12121y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public List<String> f12122z;

        public Builder() {
            this.f12110m = true;
            this.f12111n = true;
            this.f12112o = true;
            this.f12115r = 15000L;
            this.f12116s = new JSONObject();
            this.f12122z = O1.a.f3455b;
            this.f12095A = O1.a.f3456c;
            this.f12096B = O1.a.f3459f;
        }

        public Builder addHeader(JSONObject jSONObject) {
            try {
                b.t0(this.f12116s, jSONObject);
            } catch (Exception unused) {
            }
            return this;
        }

        public Builder aid(String str) {
            this.f12099a = str;
            return this;
        }

        public Builder batteryMonitor(boolean z8) {
            this.j = z8;
            return this;
        }

        public Builder blockDetect(boolean z8) {
            this.f12102d = z8;
            return this;
        }

        public ApmInsightInitConfig build() {
            if (TextUtils.isEmpty(this.f12099a)) {
                throw new IllegalArgumentException("aid must not be empty");
            }
            return new ApmInsightInitConfig(this);
        }

        public Builder channel(String str) {
            this.f12101c = str;
            return this;
        }

        public Builder cpuMonitor(boolean z8) {
            this.f12108k = z8;
            return this;
        }

        public Builder debugMode(boolean z8) {
            this.t = z8;
            return this;
        }

        public Builder defaultReportDomain(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith(JPushConstants.HTTP_PRE)) {
                        h.f19244q = str.replace(JPushConstants.HTTP_PRE, "");
                        p199z2.b.f22481l = JPushConstants.HTTP_PRE;
                    } else if (str.startsWith(p199z2.b.f22481l)) {
                        h.f19244q = str.replace(p199z2.b.f22481l, "");
                    } else {
                        h.f19244q = str;
                    }
                }
                String str2 = h.f19244q;
                List<String> list = this.f12095A;
                String str3 = O1.a.f3454a;
                this.f12095A = a(str2, list, str3);
                this.f12096B = a(h.f19244q, this.f12096B, str3);
                this.f12122z = a(h.f19244q, this.f12122z, str3);
            }
            return this;
        }

        public Builder detectActivityLeak(IActivityLeakListener iActivityLeakListener) {
            this.f12118v = iActivityLeakListener;
            return this;
        }

        public Builder diskMonitor(boolean z8) {
            this.f12109l = z8;
            return this;
        }

        public Builder enableAPMPlusLocalLog(boolean z8) {
            this.f12121y = z8;
            return this;
        }

        public Builder enableHybridMonitor(boolean z8) {
            this.f12105g = z8;
            return this;
        }

        public Builder enableLogRecovery(boolean z8) {
            this.f12117u = z8;
            return this;
        }

        public Builder enableNetTrace(boolean z8) {
            this.f12120x = z8;
            return this;
        }

        @Deprecated
        public Builder enableWebViewMonitor(boolean z8) {
            this.f12104f = z8;
            return this;
        }

        public Builder fpsMonitor(boolean z8) {
            this.f12107i = z8;
            return this;
        }

        public Builder memoryMonitor(boolean z8) {
            this.f12106h = z8;
            return this;
        }

        public Builder netMonitor(boolean z8) {
            this.f12110m = z8;
            return this;
        }

        public Builder operateMonitor(boolean z8) {
            this.f12114q = z8;
            return this;
        }

        public Builder pageMonitor(boolean z8) {
            this.f12112o = z8;
            return this;
        }

        public Builder seriousBlockDetect(boolean z8) {
            this.f12103e = z8;
            return this;
        }

        public Builder setDynamicParams(IDynamicParams iDynamicParams) {
            this.f12097C = iDynamicParams;
            return this;
        }

        public Builder setMaxLaunchTime(long j) {
            this.f12115r = j;
            return this;
        }

        public Builder setNetTraceId(String str) {
            this.f12119w = str;
            return this;
        }

        public Builder setNetworkClient(a aVar) {
            this.f12098D = aVar;
            return this;
        }

        public Builder startMonitor(boolean z8) {
            this.f12111n = z8;
            return this;
        }

        public Builder token(String str) {
            this.f12100b = str;
            return this;
        }

        public Builder trafficMonitor(boolean z8) {
            this.f12113p = z8;
            return this;
        }

        public final List<String> a(String str, List<String> list, String str2) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().replace(str2, p199z2.b.f22481l + str));
                }
            }
            return arrayList;
        }

        public Builder(ApmInsightInitConfig apmInsightInitConfig) {
            this.f12110m = true;
            this.f12111n = true;
            this.f12112o = true;
            this.f12115r = 15000L;
            this.f12102d = apmInsightInitConfig.f12071a;
            this.f12103e = apmInsightInitConfig.f12072b;
            this.f12116s = apmInsightInitConfig.t;
            this.f12122z = apmInsightInitConfig.f12090v;
            this.f12095A = apmInsightInitConfig.f12091w;
            this.f12096B = apmInsightInitConfig.f12092x;
            this.f12120x = apmInsightInitConfig.f12068B;
        }
    }

    public ApmInsightInitConfig(Builder builder) {
        this.f12071a = builder.f12102d;
        this.f12072b = builder.f12103e;
        this.f12073c = builder.f12104f;
        this.f12074d = builder.f12105g;
        this.f12075e = builder.f12106h;
        this.f12076f = builder.f12107i;
        this.f12085p = builder.f12099a;
        this.f12086q = builder.f12100b;
        this.f12087r = builder.f12101c;
        this.t = builder.f12116s;
        this.f12088s = builder.f12115r;
        this.f12089u = builder.t;
        this.f12090v = builder.f12122z;
        this.f12091w = builder.f12095A;
        this.f12092x = builder.f12096B;
        this.f12077g = builder.j;
        this.f12093y = builder.f12097C;
        this.f12094z = builder.f12098D;
        this.f12078h = builder.f12117u;
        this.f12067A = builder.f12119w;
        this.f12079i = builder.f12108k;
        this.j = builder.f12109l;
        this.f12080k = builder.f12113p;
        this.f12068B = builder.f12120x;
        this.f12081l = builder.f12114q;
        this.f12082m = builder.f12110m;
        this.f12083n = builder.f12111n;
        this.f12084o = builder.f12112o;
        this.f12069C = builder.f12121y;
        this.f12070D = builder.f12118v;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean enableAPMPlusLocalLog() {
        return this.f12069C;
    }

    public boolean enableBatteryMonitor() {
        return this.f12077g;
    }

    public boolean enableCpuMonitor() {
        return this.f12079i;
    }

    public boolean enableDiskMonitor() {
        return this.j;
    }

    public boolean enableHybridMonitor() {
        return this.f12074d;
    }

    public boolean enableLogRecovery() {
        return this.f12078h;
    }

    public boolean enableMemoryMonitor() {
        return this.f12075e;
    }

    public boolean enableNetMonitor() {
        return this.f12082m;
    }

    public boolean enableOperateMonitor() {
        return this.f12081l;
    }

    public boolean enablePageMonitor() {
        return this.f12084o;
    }

    public boolean enableStartMonitor() {
        return this.f12083n;
    }

    public boolean enableTrace() {
        return this.f12068B;
    }

    public boolean enableTrafficMonitor() {
        return this.f12080k;
    }

    public boolean enableWebViewMonitor() {
        return this.f12073c;
    }

    public IActivityLeakListener getActivityLeakListener() {
        return this.f12070D;
    }

    public String getAid() {
        return this.f12085p;
    }

    public String getChannel() {
        return this.f12087r;
    }

    public List<String> getDefaultLogReportUrls() {
        return this.f12091w;
    }

    public IDynamicParams getDynamicParams() {
        return this.f12093y;
    }

    public List<String> getExceptionLogReportUrls() {
        return this.f12092x;
    }

    public String getExternalTraceId() {
        return this.f12067A;
    }

    public JSONObject getHeader() {
        return this.t;
    }

    public long getMaxLaunchTime() {
        return this.f12088s;
    }

    public a getNetworkClient() {
        return this.f12094z;
    }

    public List<String> getSlardarConfigUrls() {
        return this.f12090v;
    }

    public String getToken() {
        return this.f12086q;
    }

    public boolean isDebug() {
        return this.f12089u;
    }

    public boolean isWithBlockDetect() {
        return this.f12071a;
    }

    public boolean isWithFpsMonitor() {
        return this.f12076f;
    }

    public boolean isWithSeriousBlockDetect() {
        return this.f12072b;
    }

    public static Builder builder(ApmInsightInitConfig apmInsightInitConfig) {
        return new Builder(apmInsightInitConfig);
    }
}

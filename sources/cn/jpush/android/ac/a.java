package cn.jpush.android.ac;

import cn.jpush.android.data.JPushConfig;

/* JADX INFO: loaded from: classes.dex */
class a extends JPushConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11051d;

    public a() {
    }

    public String a() {
        return this.f11048a;
    }

    public String b() {
        return this.f11049b;
    }

    public String c() {
        return this.f11050c;
    }

    public String d() {
        return this.f11051d;
    }

    public a(JPushConfig jPushConfig) {
        setjAppKey(jPushConfig.getjAppKey());
        setMzAppId(jPushConfig.getMzAppId());
        setMzAppKey(jPushConfig.getMzAppKey());
        setOppoAppId(jPushConfig.getOppoAppId());
        setOppoAppKey(jPushConfig.getOppoAppKey());
        setOppoAppSecret(jPushConfig.getOppoAppSecret());
        setXmAppId(jPushConfig.getXmAppId());
        setXmAppKey(jPushConfig.getXmAppKey());
    }

    public void a(String str) {
        this.f11048a = str;
    }

    public void b(String str) {
        this.f11049b = str;
    }

    public void c(String str) {
        this.f11050c = str;
    }

    public void d(String str) {
        this.f11051d = str;
    }
}

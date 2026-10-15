package cn.jpush.android.data;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class JPushConfig implements Serializable {
    private static final long serialVersionUID = -3135447319267244288L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11356h;

    public String getMzAppId() {
        return this.f11353e;
    }

    public String getMzAppKey() {
        return this.f11354f;
    }

    public String getOppoAppId() {
        return this.f11351c;
    }

    public String getOppoAppKey() {
        return this.f11350b;
    }

    public String getOppoAppSecret() {
        return this.f11352d;
    }

    public String getXmAppId() {
        return this.f11355g;
    }

    public String getXmAppKey() {
        return this.f11356h;
    }

    public String getjAppKey() {
        return this.f11349a;
    }

    public void setMzAppId(String str) {
        this.f11353e = str;
    }

    public void setMzAppKey(String str) {
        this.f11354f = str;
    }

    public void setOppoAppId(String str) {
        this.f11351c = str;
    }

    public void setOppoAppKey(String str) {
        this.f11350b = str;
    }

    public void setOppoAppSecret(String str) {
        this.f11352d = str;
    }

    public void setXmAppId(String str) {
        this.f11355g = str;
    }

    public void setXmAppKey(String str) {
        this.f11356h = str;
    }

    public void setjAppKey(String str) {
        this.f11349a = str;
    }
}

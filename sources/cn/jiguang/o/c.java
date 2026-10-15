package cn.jiguang.o;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Intent f10669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f10670f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10673i;
    public int j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10675l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10671g = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10674k = 0;

    public c() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f10665a;
            String str2 = ((c) obj).f10665a;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "JWakeTargetInfo{packageName='" + this.f10665a + "', serviceName='" + this.f10666b + "', targetVersion=" + this.f10667c + ", providerAuthority='" + this.f10668d + "', activityIntent=" + this.f10669e + ", activityIntentBackup=" + this.f10670f + ", wakeType=" + this.f10671g + ", authenType=" + this.f10672h + ", instrumentationName=" + this.f10673i + ", cmd=" + this.j + ", delaySecTime=" + this.f10674k + ", uExtra=" + this.f10675l + '}';
    }

    public c(String str, String str2, int i9) {
        this.f10665a = str;
        this.f10666b = str2;
        this.f10667c = i9;
    }
}

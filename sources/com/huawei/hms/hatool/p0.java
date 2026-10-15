package com.huawei.hms.hatool;

import com.huawei.hms.framework.common.BundleUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15277a = 1800000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f15278b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f15279c = null;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15280a = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f15281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f15282c;

        public a(long j) {
            this.f15280a += BundleUtil.UNDERLINE_TAG + j;
            this.f15282c = j;
            this.f15281b = true;
            p0.this.f15278b = false;
        }

        private void b(long j) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String string = UUID.randomUUID().toString();
            this.f15280a = string;
            this.f15280a = string.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.f15280a += BundleUtil.UNDERLINE_TAG + j;
            this.f15282c = j;
            this.f15281b = true;
        }

        public void a(long j) {
            if (p0.this.f15278b) {
                p0.this.f15278b = false;
                b(j);
            } else if (b(this.f15282c, j) || a(this.f15282c, j)) {
                b(j);
            } else {
                this.f15282c = j;
                this.f15281b = false;
            }
        }

        private boolean a(long j, long j8) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j8);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private boolean b(long j, long j8) {
            return j8 - j >= p0.this.f15277a;
        }
    }

    public String a() {
        a aVar = this.f15279c;
        if (aVar != null) {
            return aVar.f15280a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    public void a(long j) {
        a aVar = this.f15279c;
        if (aVar != null) {
            aVar.a(j);
        } else {
            v.c("hmsSdk", "Session is first flush");
            this.f15279c = new a(j);
        }
    }

    public boolean b() {
        a aVar = this.f15279c;
        if (aVar != null) {
            return aVar.f15281b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}

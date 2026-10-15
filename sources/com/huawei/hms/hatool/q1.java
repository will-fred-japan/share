package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.UserManager;

/* JADX INFO: loaded from: classes.dex */
public class q1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static q1 f15287c = new q1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15288a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15289b = q0.i();

    private q1() {
    }

    public static q1 b() {
        return f15287c;
    }

    @TargetApi(24)
    public boolean a() {
        if (!this.f15288a) {
            Context context = this.f15289b;
            if (context == null) {
                return false;
            }
            UserManager userManager = (UserManager) context.getSystemService("user");
            if (userManager != null) {
                this.f15288a = userManager.isUserUnlocked();
            } else {
                this.f15288a = false;
            }
        }
        return this.f15288a;
    }
}

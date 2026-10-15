package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class IntentCallable implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Intent f15476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15477c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f15475a = context;
        this.f15476b = intent;
        this.f15477c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.f15475a.sendBroadcast(this.f15476b);
        PushBiUtil.reportExit(this.f15475a, PushNaming.SET_NOTIFY_FLAG, this.f15477c, ErrorEnum.SUCCESS);
        return null;
    }
}

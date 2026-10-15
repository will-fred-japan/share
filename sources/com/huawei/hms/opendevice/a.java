package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.common.ApiException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: AAIDCallable.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Callable<AAIDResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15338a;

    public a(Context context) {
        this.f15338a = context;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AAIDResult call() throws ApiException {
        Context context = this.f15338a;
        if (context == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String strB = b.b(context);
        AAIDResult aAIDResult = new AAIDResult();
        aAIDResult.setId(strB);
        return aAIDResult;
    }
}

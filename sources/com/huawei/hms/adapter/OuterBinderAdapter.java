package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public class OuterBinderAdapter extends BinderAdapter {
    private static final Object j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static BinderAdapter f14777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f14778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f14779m;

    private OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance.");
        synchronized (j) {
            try {
                if (f14777k == null) {
                    f14778l = str;
                    f14779m = str2;
                    f14777k = new OuterBinderAdapter(context, str, str2);
                } else if (!Objects.equal(f14778l, str) || !Objects.equal(f14779m, str2)) {
                    HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance refresh adapter");
                    f14778l = str;
                    f14779m = str2;
                    f14777k.unBind();
                    f14777k = new OuterBinderAdapter(context, str, str2);
                }
                binderAdapter = f14777k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        return 1002;
    }
}

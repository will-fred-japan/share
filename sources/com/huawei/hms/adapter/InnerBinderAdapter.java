package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public class InnerBinderAdapter extends BinderAdapter {
    private static final Object j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static BinderAdapter f14776k;

    private InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (j) {
            try {
                if (f14776k == null) {
                    f14776k = new InnerBinderAdapter(context, str, str2);
                }
                binderAdapter = f14776k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        return 2001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        return 2002;
    }
}

package cn.jpush.android.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jiguang.x.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;

/* JADX INFO: loaded from: classes.dex */
public class DataProvider extends ContentProvider {
    private static final String TAG = "DataProvider";

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            f.c(TAG, "method:" + str + ", arg=" + str2);
            return JCoreInternalHelper.getInstance().directHandle(getContext(), str, str2, bundle);
        } catch (Throwable th) {
            defpackage.f.l("call e:", TAG, th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f.c(TAG, AppAgent.ON_CREATE);
        Context context = getContext();
        JConstants.getAppContext(context);
        JCoreManager.setStartId(context);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

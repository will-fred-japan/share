package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jiguang.x.f;

/* JADX INFO: loaded from: classes.dex */
public class JCommonService extends Service {
    private static final String TAG = "JCommonService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f11554a = 0;
    private static IDataShare.Stub mBinder;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        JConstants.getAppContext(getApplicationContext());
        JCoreManager.setStartId(getApplicationContext());
        if (mBinder == null) {
            mBinder = new DataShare();
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i9) {
        super.onStart(intent, i9);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i9, int i10) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            f.i(TAG, "onStartCommand intent is empty or action is empty");
            return 2;
        }
        JCoreInternalHelper.getInstance().onEvent(this, JConstants.SDK_TYPE, 2, true, intent.getAction(), intent.getExtras(), new Object[0]);
        return 2;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i9) {
        super.onTrimMemory(i9);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}

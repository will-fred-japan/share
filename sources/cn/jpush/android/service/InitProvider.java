package cn.jpush.android.service;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.d.a;
import cn.jiguang.internal.JConstants;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class InitProvider extends ContentProvider {
    private static final String TAG = "InitProvider";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f11553a = 0;
    private Class<?> actionHelperClass;
    private Object actionHelperInstance;
    private Method onJPushMessageReceiveMethod;

    private String getProviderProcessName(Context context) {
        String str;
        try {
            return context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), InitProvider.class.getName()), 0).processName;
        } catch (PackageManager.NameNotFoundException e9) {
            e = e9;
            str = "Provider not found";
            Log.e(TAG, str, e);
            return null;
        } catch (Throwable th) {
            e = th;
            str = "getProviderProcessName error";
            Log.e(TAG, str, e);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            Context context = getContext();
            if (JConstants.isCallInit.get() && context != null) {
                if (context.checkCallingPermission(context.getPackageName() + ".permission.JPUSH_MESSAGE") == 0) {
                    if (this.actionHelperClass == null) {
                        this.actionHelperClass = Class.forName(new String(Base64.decode("Y24uanB1c2guYW5kcm9pZC5sb2NhbC5BY3Rpb25IZWxwZXI=", 2)));
                    }
                    if (this.actionHelperInstance == null) {
                        this.actionHelperInstance = this.actionHelperClass.getMethod(new String(Base64.decode("Z2V0SW5zdGFuY2U=", 2)), new Class[0]).invoke(null, new Object[0]);
                    }
                    if (this.onJPushMessageReceiveMethod == null) {
                        this.onJPushMessageReceiveMethod = this.actionHelperClass.getMethod(new String(Base64.decode("b25KUHVzaE1lc3NhZ2VSZWNlaXZl", 2)), Context.class, String.class, String.class, Bundle.class);
                    }
                    this.onJPushMessageReceiveMethod.invoke(this.actionHelperInstance, context, str, str2, bundle);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
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
        Log.d(TAG, "InitProvider onCreate");
        try {
            Application application = (Application) getContext();
            JConstants.getAppContext(application);
            JCoreManager.setStartId(application);
            String providerProcessName = getProviderProcessName(application);
            Log.d(TAG, "InitProvider process: " + providerProcessName);
            if (application == null || !TextUtils.equals(providerProcessName, application.getPackageName())) {
                Log.w(TAG, "InitProvider is not in main process. processName: " + providerProcessName);
            } else {
                a.a((Context) application, false);
            }
        } catch (Throwable th) {
            Log.e(TAG, "InitProvider onCreate error", th);
        }
        return false;
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

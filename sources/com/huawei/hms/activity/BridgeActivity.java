package com.huawei.hms.activity;

import W5.f;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final String EXTRA_INTENT = "intent.extra.intent";
    public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f14714b = a("ro.build.hw_emui_api_level", 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBridgeActivityDelegate f14715a;

    public class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f14716a;

        public a(ViewGroup viewGroup) {
            this.f14716a = viewGroup;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            try {
                Object objInvoke = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx").getMethod("getDisplaySideRegion", WindowInsets.class).invoke(null, windowInsets);
                if (objInvoke == null) {
                    HMSLog.i("BridgeActivity", "sideRegion is null");
                } else {
                    Rect rect = (Rect) Class.forName("com.huawei.android.view.DisplaySideRegionEx").getMethod("getSafeInsets", new Class[0]).invoke(objInvoke, new Object[0]);
                    ViewGroup viewGroup = this.f14716a;
                    if (viewGroup != null) {
                        viewGroup.setPadding(rect.left, 0, rect.right, 0);
                    }
                }
            } catch (ClassNotFoundException e9) {
                e = e9;
                HMSLog.e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e.getMessage());
            } catch (IllegalAccessException e10) {
                e = e10;
                HMSLog.e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e.getMessage());
            } catch (NoSuchMethodException e11) {
                e = e11;
                HMSLog.e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e.getMessage());
            } catch (InvocationTargetException e12) {
                e = e12;
                HMSLog.e("BridgeActivity", "An exception occurred while reading: onApplyWindowInsets" + e.getMessage());
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    private static void a(Window window, boolean z8) {
        try {
            window.getClass().getMethod("setHwFloating", Boolean.TYPE).invoke(window, Boolean.valueOf(z8));
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e9) {
            f.l(e9, new StringBuilder("In setHwFloating, Failed to call Window.setHwFloating()."), "BridgeActivity");
        }
    }

    private void b() {
        View viewFindViewById = getWindow().findViewById(R.id.content);
        if (viewFindViewById == null || !(viewFindViewById instanceof ViewGroup)) {
            HMSLog.e("BridgeActivity", "rootView is null or not ViewGroup");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) viewFindViewById;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
            cls.getMethod("setDisplaySideMode", Integer.TYPE).invoke(cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 1);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e9) {
            f.l(e9, new StringBuilder("An exception occurred while reading: setDisplaySideMode"), "BridgeActivity");
        }
        getWindow().getDecorView().setOnApplyWindowInsetsListener(new a(viewGroup));
    }

    private boolean c() {
        Intent intent = getIntent();
        if (intent == null) {
            HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        if (intent.getBooleanExtra(EXTRA_IS_FULLSCREEN, false)) {
            getWindow().setFlags(1024, 1024);
        }
        try {
            String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
            if (stringExtra == null) {
                HMSLog.e("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
                return false;
            }
            IBridgeActivityDelegate iBridgeActivityDelegate = (IBridgeActivityDelegate) Class.forName(stringExtra).asSubclass(IBridgeActivityDelegate.class).newInstance();
            this.f14715a = iBridgeActivityDelegate;
            try {
                iBridgeActivityDelegate.onBridgeActivityCreate(this);
                return true;
            } catch (Throwable th) {
                HMSLog.e("BridgeActivity", "onBridgeActivityCreate Exception." + th.getMessage());
                return false;
            }
        } catch (ClassCastException e9) {
            e = e9;
            f.l(e, new StringBuilder("In initialize, Failed to create 'IUpdateWizard' instance."), "BridgeActivity");
            return false;
        } catch (ClassNotFoundException e10) {
            e = e10;
            f.l(e, new StringBuilder("In initialize, Failed to create 'IUpdateWizard' instance."), "BridgeActivity");
            return false;
        } catch (IllegalAccessException e11) {
            e = e11;
            f.l(e, new StringBuilder("In initialize, Failed to create 'IUpdateWizard' instance."), "BridgeActivity");
            return false;
        } catch (IllegalStateException e12) {
            e = e12;
            f.l(e, new StringBuilder("In initialize, Failed to create 'IUpdateWizard' instance."), "BridgeActivity");
            return false;
        } catch (InstantiationException e13) {
            e = e13;
            f.l(e, new StringBuilder("In initialize, Failed to create 'IUpdateWizard' instance."), "BridgeActivity");
            return false;
        } catch (Throwable unused) {
            HMSLog.e("BridgeActivity", "In initialize, Failed to create 'IUpdateWizard' instance, throwable occur.");
            return false;
        }
    }

    private void d() {
        e();
        Window window = getWindow();
        if (f14714b >= 9) {
            window.addFlags(67108864);
            a(window, true);
        }
        window.getDecorView().setSystemUiVisibility(0);
    }

    private void e() {
        try {
            if (getWindow() == null) {
                HMSLog.w("BridgeActivity", "requestHideTitle, window is null.");
            } else {
                requestWindowFeature(1);
            }
        } catch (Throwable th) {
            HMSLog.w("BridgeActivity", "requestWindowFeature " + th.getMessage());
        }
    }

    public static Intent getIntentStartBridgeActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
        return intent;
    }

    public static void setFullScreenWindowLayoutInDisplayCutout(Window window) {
        if (window == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(1280);
            return;
        }
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes2), 65536);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("BridgeActivity", "com.huawei.android.view.LayoutParamsEx fail");
        }
    }

    @Override // android.app.Activity
    public void finish() {
        HMSLog.i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        Intent intentModifyIntentBehaviorsSafe = UIUtil.modifyIntentBehaviorsSafe(super.getIntent());
        if (intentModifyIntentBehaviorsSafe != null) {
            return new SafeIntent(intentModifyIntentBehaviorsSafe);
        }
        return null;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i9, int i10, Intent intent) {
        boolean zOnBridgeActivityResult;
        SafeIntent safeIntent = new SafeIntent(intent);
        super.onActivityResult(i9, i10, safeIntent);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f14715a;
        if (iBridgeActivityDelegate != null) {
            try {
                zOnBridgeActivityResult = iBridgeActivityDelegate.onBridgeActivityResult(i9, i10, safeIntent);
            } catch (Throwable unused) {
                HMSLog.w("BridgeActivity", "onBridgeActivityResult failed, throwable occur.");
                zOnBridgeActivityResult = false;
            }
            if (zOnBridgeActivityResult || isFinishing()) {
                return;
            }
            setResult(i10, UIUtil.modifyIntentBehaviorsSafe(safeIntent));
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f14715a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeConfigurationChanged();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        e();
        super.onCreate(bundle);
        HMSLog.i("BridgeActivity", "BridgeActivity onCreate");
        if (getIntent() == null) {
            setResult(1, null);
            finish();
            return;
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        d();
        b();
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(getApplicationContext());
        }
        setFullScreenWindowLayoutInDisplayCutout(getWindow());
        if (c()) {
            return;
        }
        setResult(1, null);
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            ResolutionFlagUtil.getInstance().removeResolutionFlag(new SafeIntent(getIntent()).getStringExtra(CommonCode.MapKey.TRANSACTION_ID));
        } catch (Throwable th) {
            HMSLog.w("BridgeActivity", "get transaction_id from intent fail: ".concat(th.getClass().getSimpleName()));
        }
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f14715a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
        HMSLog.i("BridgeActivity", "BridgeActivity onDestroy");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i9, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate = this.f14715a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onKeyUp(i9, keyEvent);
        }
        return super.onKeyUp(i9, keyEvent);
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable th) {
            HMSLog.e("BridgeActivity", "super.onResume has an exception", th);
            a();
        }
    }

    public static Intent getIntentStartBridgeActivity(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, str);
        intent.putExtra(EXTRA_IS_FULLSCREEN, false);
        return intent;
    }

    private void a() {
        try {
            if (isFinishing() || isDestroyed()) {
                return;
            }
            setResult(1, null);
            finish();
        } catch (Throwable th) {
            HMSLog.e("BridgeActivity", "finishBridgeActivity has an exception", th);
            throw new IllegalArgumentException("finishBridgeActivity has an exception ", th);
        }
    }

    private static int a(String str, int i9) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i9))).intValue();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
            return i9;
        }
    }
}

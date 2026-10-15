package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.UIUtil;

/* JADX INFO: loaded from: classes.dex */
public class NotInstalledHmsAdapter implements IBridgeActivityDelegate {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f14790c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f14791d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f14792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Dialog f14793b;

    public static class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f14794a;

        public a(Activity activity) {
            this.f14794a = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            SystemManager.getInstance().notifyUpdateResult(13);
            this.f14794a.finish();
        }
    }

    public static class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f14795a;

        public b(Activity activity) {
            this.f14795a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i9) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onClick>");
            SystemManager.getInstance().notifyUpdateResult(30);
            this.f14795a.finish();
        }
    }

    private void a(Activity activity) {
        Dialog dialog = this.f14793b;
        if (dialog != null && dialog.isShowing()) {
            this.f14793b.setOnCancelListener(null);
            this.f14793b.cancel();
        }
        AlertDialog alertDialogCreate = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new b(activity)).setOnCancelListener(new a(activity)).create();
        this.f14793b = alertDialogCreate;
        UIUtil.enableFocusedForButtonsInTV(alertDialogCreate);
        this.f14793b.show();
    }

    public static boolean getShowLock() {
        synchronized (f14790c) {
            try {
                HMSLog.i("NotInstalledHmsAdapter", "<canShowDialog> sIsShowingDialog: " + f14791d);
                if (f14791d) {
                    return false;
                }
                f14791d = true;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
        } else {
            this.f14792a = activity;
            a(activity);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        synchronized (f14790c) {
            f14791d = false;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i9, int i10, Intent intent) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        Activity activity = this.f14792a;
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        } else {
            a(this.f14792a);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i9, KeyEvent keyEvent) {
        HMSLog.i("NotInstalledHmsAdapter", "<onKeyUp>");
    }
}

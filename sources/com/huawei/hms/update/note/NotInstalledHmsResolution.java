package com.huawei.hms.update.note;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.availableupdate.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.UIUtil;

/* JADX INFO: loaded from: classes.dex */
public class NotInstalledHmsResolution implements IBridgeActivityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f15579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f15580b;

    public static class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f15581a;

        public a(Activity activity) {
            this.f15581a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i9) {
            HMSLog.i("NotInstalledHmsResolution", "<Dialog onClick>");
            this.f15581a.finish();
        }
    }

    private void a(Activity activity) {
        a();
        AlertDialog alertDialogCreate = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new a(activity)).create();
        this.f15579a = alertDialogCreate;
        UIUtil.enableFocusedForButtonsInTV(alertDialogCreate);
        this.f15579a.show();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution getRequestCode>");
        return 0;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
            return;
        }
        this.f15580b = activity;
        b.f14860b.a(activity);
        a(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityDestroy>");
        a();
        b.f14860b.b(this.f15580b);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i9, int i10, Intent intent) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityResult>");
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeConfigurationChanged>");
        Activity activity = this.f15580b;
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> mActivity is null or finishing");
        } else {
            a(this.f15580b);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i9, KeyEvent keyEvent) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onKeyUp>");
    }

    private void a() {
        Dialog dialog = this.f15579a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f15579a.cancel();
    }
}

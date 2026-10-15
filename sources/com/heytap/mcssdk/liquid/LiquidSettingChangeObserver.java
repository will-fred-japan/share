package com.heytap.mcssdk.liquid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.mcssdk.utils.e;

/* JADX INFO: loaded from: classes.dex */
public class LiquidSettingChangeObserver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14336a = "LiquidSettingChangeObserver";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OnLiquidSettingChangeListener f14338c;

    public LiquidSettingChangeObserver(Context context, OnLiquidSettingChangeListener onLiquidSettingChangeListener) {
        this.f14337b = context;
        this.f14338c = onLiquidSettingChangeListener;
    }

    private void a(Bundle bundle) {
        String string;
        int i9;
        int i10;
        if (bundle == null) {
            if (e.g()) {
                e.b(f14336a, "parseContent() extras is null .");
                return;
            }
            return;
        }
        try {
            i9 = bundle.getInt(LiquidConstants.keyLiquidSettingChangeType);
            try {
                string = bundle.getString(LiquidConstants.pkgName);
                try {
                    i10 = bundle.getInt(LiquidConstants.switchValue);
                } catch (Exception e9) {
                    e = e9;
                    if (e.g()) {
                        e.b(f14336a, "Error happened in parseContent:" + e.toString());
                    }
                    i10 = -2;
                }
            } catch (Exception e10) {
                e = e10;
                string = "";
            }
        } catch (Exception e11) {
            e = e11;
            string = "";
            i9 = -1;
        }
        if (e.g()) {
            e.b(f14336a, "parseContent() : changeType:" + i9 + " packageName: " + string + " isOpen:" + i10);
        }
        if (i9 == -1) {
            return;
        }
        SettingChangeBean settingChangeBean = new SettingChangeBean();
        settingChangeBean.setChangeType(i9);
        settingChangeBean.setSwitchStatus(i10);
        if (e.g()) {
            e.b(f14336a, "parseContent SettingChangeBean is :" + settingChangeBean);
        }
        if (i9 != 1) {
            if (i9 != 2) {
                return;
            }
            Context context = this.f14337b;
            String packageName = context != null ? context.getPackageName() : "";
            if (!TextUtils.equals(packageName, string) || TextUtils.isEmpty(packageName)) {
                return;
            }
        }
        OnLiquidSettingChangeListener onLiquidSettingChangeListener = this.f14338c;
        if (onLiquidSettingChangeListener != null) {
            onLiquidSettingChangeListener.onSettingChange(settingChangeBean);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (e.g()) {
            e.b(f14336a, "onReceive() :" + this);
        }
        if (intent == null) {
            if (e.g()) {
                e.b(f14336a, "parseContent() intent is null ");
                return;
            }
            return;
        }
        String action = intent.getAction();
        if (e.g()) {
            e.b(f14336a, "parseContent() action :" + action + " -- " + this);
        }
        if (TextUtils.equals(action, LiquidConstants.liquidSwitchChangeThirdAppReceiverAction)) {
            a(intent.getExtras());
        }
    }
}

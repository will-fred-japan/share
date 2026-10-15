package cn.jpush.android.thirdpush.vivo;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.thirdpush.vivo.a.a;

/* JADX INFO: loaded from: classes.dex */
public class VivoPushManager extends JThirdPlatFormInterface {
    private static final String TAG = "VivoPushManager";

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getAppId(Context context) {
        return a.d(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getAppkey(Context context) {
        return a.e(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getRomName() {
        return "VIVO";
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public byte getRomType(Context context) {
        return a.f(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getToken(Context context) {
        return a.g(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public int getVoipSupportStatus(Context context) {
        return a.i(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void init(Context context) {
        a.j(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean isNeedClearToken(Context context) {
        return a.l(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean isSupport(Context context) {
        return a.m(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean needSendToMainProcess() {
        return true;
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void register(Context context, Bundle bundle) {
        a.a(context, bundle);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void clearAllNotification(Context context) {
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void clearNotification(Context context, int i9) {
    }
}

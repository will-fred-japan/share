package cn.jpush.android.thirdpush.honor;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.thirdpush.honor.a.a;
import com.engagelab.privates.push.constants.MTPushConstants;

/* JADX INFO: loaded from: classes.dex */
public class HonorPushManager extends JThirdPlatFormInterface {
    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getAppId(Context context) {
        return a.c(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getAppkey(Context context) {
        return "honor_appkey";
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getRomName() {
        return MTPushConstants.Manufacturer.HONOR;
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public byte getRomType(Context context) {
        return a.d(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getToken(Context context) {
        return a.a(context, true);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public int getVoipSupportStatus(Context context) {
        return a.f(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void init(Context context) {
        a.g(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean isNeedClearToken(Context context) {
        return a.h(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean isSupport(Context context) {
        return a.i(context);
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
    public void resumePush(Context context) {
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void stopPush(Context context) {
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void clearNotification(Context context, int i9) {
    }
}

package cn.jpush.android.thirdpush.huawei;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.thirdpush.huawei.a.a;
import com.engagelab.privates.push.constants.MTPushConstants;

/* JADX INFO: loaded from: classes.dex */
public class HWPushManager extends JThirdPlatFormInterface {
    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getAppId(Context context) {
        return a.c(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getAppkey(Context context) {
        return "huawei_appkey";
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getRomName() {
        return MTPushConstants.Manufacturer.HUAWEI;
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public byte getRomType(Context context) {
        return a.e(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public String getToken(Context context) {
        return a.a(context, true);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public int getVoipSupportStatus(Context context) {
        return a.g(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public void init(Context context) {
        a.h(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean isNeedClearToken(Context context) {
        return a.i(context);
    }

    @Override // cn.jpush.android.api.JThirdPlatFormInterface
    public boolean isSupport(Context context) {
        return a.j(context);
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

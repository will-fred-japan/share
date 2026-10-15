package cn.jiguang.au;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.api.SdkType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class g extends JDispatchAction {
    private JAction a(String str) {
        return a.a().a(str);
    }

    private JActionExtra b(String str) {
        return a.a().b(str);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object beforLogin(Context context, String str, int i9, String str2) {
        JActionExtra jActionExtraB = b(str);
        if (jActionExtraB != null) {
            return jActionExtraB.beforLogin(context, i9, str2);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object beforRegister(Context context, String str, int i9, String str2) {
        JActionExtra jActionExtraB = b(str);
        if (jActionExtraB != null) {
            return jActionExtraB.beforRegister(context, i9, str2);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean checkAction(String str, int i9) {
        JActionExtra jActionExtraB = b(str);
        if (jActionExtraB != null) {
            return jActionExtraB.checkAction(i9);
        }
        return true;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i9, int i10, long j, long j8, ByteBuffer byteBuffer) {
        JAction jActionA = a(str);
        if (jActionA != null) {
            StringBuilder sbG = H2.a.g(i9, i10, "dispatchMessage ,command:", ",ver:", ",rid:");
            sbG.append(j);
            sbG.append(",reuqestId:");
            sbG.append(j8);
            d.b("SupportDispatchAction", sbG.toString());
            jActionA.dispatchMessage(context, 0L, i9, str.equals(SdkType.JMESSAGE.name()) ? new c(false, byteBuffer.limit() + 20, i10, i9, j, JCoreInterface.getSid(), JCoreInterface.getUid()) : new c(false, i10, i9, j8), byteBuffer);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchTimeOutMessage(Context context, String str, long j, int i9) {
        JAction jActionA = a(str);
        if (jActionA != null) {
            jActionA.dispatchTimeOutMessage(context, 0L, j, i9);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 3;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 6;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 7 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 8;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 128;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 32;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 256;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 512;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 1024 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 8;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 128;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 32;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 256;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 512;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 1024 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 0;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 6;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 7 : (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return HiAnalyticsConstant.BI_KEY_SDK_VER;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return "statistics_sdk_ver";
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return "share_sdk_ver";
        }
        if (str.equals(SdkType.JAD.name())) {
            return "ssp_sdk_ver";
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return "im_sdk_ver";
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return "verification_sdk_ver";
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return "mlink_sdk_ver";
        }
        if (str.equals(SdkType.JUNION.name())) {
            return "junion_sdk_ver";
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        JAction jActionA = a(str);
        return jActionA != null ? jActionA.getSdkVersion() : "";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 9;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 10;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 11;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 12 : (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
        d.b("SupportDispatchAction", "handleMessage,sdkType:" + str);
        JAction jActionA = a(str);
        if (jActionA != null) {
            jActionA.handleMessage(context, 0L, obj);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i9) {
        JAction jActionA = a(str);
        if (jActionA != null) {
            return jActionA.isSupportedCMD(i9);
        }
        return false;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        JAction jActionA = a(str);
        if (jActionA != null) {
            jActionA.onActionRun(context, 0L, bundle, null);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onEvent(Context context, String str, int i9, int i10, String str2) {
        JAction jActionA = a(str);
        if (jActionA != null) {
            jActionA.onEvent(context, 0L, i9);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object onSendData(Context context, String str, long j, int i9, int i10) {
        JActionExtra jActionExtraB = b(str);
        if (jActionExtraB != null) {
            return jActionExtraB.onSendData(context, 0L, j, i9, i10);
        }
        return null;
    }
}

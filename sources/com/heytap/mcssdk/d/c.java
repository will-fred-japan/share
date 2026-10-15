package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends d {
    @Override // com.heytap.mcssdk.d.e
    public BaseMode a(Context context, int i9, Intent intent) {
        if (4103 != i9 && 4098 != i9 && 4108 != i9) {
            return null;
        }
        BaseMode baseModeA = a(intent, i9);
        com.heytap.mcssdk.f.a.a(context, com.heytap.mcssdk.constant.c.a.f14309b, (DataMessage) baseModeA);
        return baseModeA;
    }

    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Intent intent, int i9) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14286c)));
            dataMessage.setTaskID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14287d)));
            dataMessage.setGlobalId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14291h)));
            dataMessage.setAppPackage(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14288e)));
            dataMessage.setTitle(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("title")));
            dataMessage.setContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
            dataMessage.setDescription(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14292i)));
            String strD = com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.j));
            int i10 = 0;
            dataMessage.setNotifyID(TextUtils.isEmpty(strD) ? 0 : Integer.parseInt(strD));
            dataMessage.setMiniProgramPkg(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("miniProgramPkg")));
            dataMessage.setMessageType(i9);
            dataMessage.setEventId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14293k)));
            dataMessage.setStatisticsExtra(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14294l)));
            String strD2 = com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14295m));
            dataMessage.setDataExtra(strD2);
            String strA = a(strD2);
            if (!TextUtils.isEmpty(strA)) {
                i10 = Integer.parseInt(strA);
            }
            dataMessage.setMsgCommand(i10);
            dataMessage.setBalanceTime(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14296n)));
            dataMessage.setStartDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14301s)));
            dataMessage.setEndDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.t)));
            dataMessage.setTimeRanges(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14297o)));
            dataMessage.setRule(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14298p)));
            dataMessage.setForcedDelivery(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14299q)));
            dataMessage.setDistinctContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14300r)));
            dataMessage.setAppId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14302u)));
            return dataMessage;
        } catch (Exception e9) {
            com.heytap.mcssdk.utils.e.b("OnHandleIntent--" + e9.getMessage());
            return null;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(com.heytap.mcssdk.constant.b.f14303v);
        } catch (JSONException e9) {
            com.heytap.mcssdk.utils.e.b(e9.getMessage());
            return "";
        }
    }
}

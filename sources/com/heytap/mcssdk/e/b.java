package com.heytap.mcssdk.e;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.utils.e;
import com.heytap.mcssdk.utils.i;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.statis.StatisticUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f14327a = 1;

    private void b(Context context, DataMessage dataMessage) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataMessage);
        map.put(dataMessage.getEventId(), arrayList);
        StatisticUtils.statisticEvent(context, map);
    }

    @Override // com.heytap.mcssdk.e.c
    public void a(final Context context, Intent intent, BaseMode baseMode, final IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4103) {
            final DataMessage dataMessage = (DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                i.b(new Runnable() { // from class: com.heytap.mcssdk.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (dataMessage.getMsgCommand() == 1) {
                            b.this.a(context, dataMessage);
                        } else {
                            iDataMessageCallBackService.processMessage(context, dataMessage);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, DataMessage dataMessage) {
        if (context == null) {
            e.b("context is null");
            return;
        }
        e.b("Receive revokeMessage  extra : " + dataMessage.getStatisticsExtra() + "notifyId :" + dataMessage.getNotifyID() + "messageId : " + dataMessage.getTaskID());
        ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(dataMessage.getNotifyID());
        b(context, dataMessage);
    }
}

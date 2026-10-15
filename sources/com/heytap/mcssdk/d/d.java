package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements e {
    public static int a(Intent intent) {
        int i9 = 4096;
        if (intent == null) {
            return 4096;
        }
        try {
            i9 = Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("type")));
        } catch (Exception e9) {
            com.heytap.mcssdk.utils.e.e("parseMessageType e:" + e9.getMessage());
        }
        com.heytap.mcssdk.utils.e.b("parseMessageType type:" + i9);
        return i9;
    }

    public abstract BaseMode a(Intent intent, int i9);

    public static List<BaseMode> a(Context context, Intent intent, List<e> list) {
        BaseMode baseModeA;
        if (intent == null) {
            return null;
        }
        int iA = a(intent);
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            if (eVar != null && (baseModeA = eVar.a(context, iA, intent)) != null) {
                arrayList.add(baseModeA);
            }
        }
        return arrayList;
    }
}

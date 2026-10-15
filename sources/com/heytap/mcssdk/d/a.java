package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14324a = "a";

    @Override // com.heytap.mcssdk.d.e
    public BaseMode a(Context context, int i9, Intent intent) {
        if (4105 == i9) {
            return a(intent, i9);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00a3: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:11:0x00a3 */
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Intent intent, int i9) {
        com.heytap.mcssdk.b.b bVar;
        Exception e9;
        String str;
        com.heytap.mcssdk.b.b bVar2;
        com.heytap.mcssdk.b.b bVar3 = null;
        try {
            try {
                bVar = new com.heytap.mcssdk.b.b();
                try {
                    bVar.a(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14306y))));
                    bVar.b(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("code"))));
                    bVar.e(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
                    bVar.a(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14307z)));
                    bVar.b(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14275A)));
                    bVar.g(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14288e)));
                    String str2 = f14324a;
                    com.heytap.mcssdk.utils.e.b(str2, "parseMessageByIntent() finally will get miniProgramPkg");
                    try {
                        com.heytap.mcssdk.utils.e.b(str2, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        bVar.f(intent.getStringExtra("miniProgramPkg"));
                        com.heytap.mcssdk.utils.e.b("OnHandleIntent-message:" + bVar.toString());
                        return bVar;
                    } catch (Exception e10) {
                        com.heytap.mcssdk.utils.e.b("OnHandleIntent--" + e10.getMessage() + " ");
                        return bVar;
                    }
                } catch (Exception e11) {
                    e9 = e11;
                    com.heytap.mcssdk.utils.e.b("OnHandleIntent--" + e9.getMessage());
                    String str3 = f14324a;
                    com.heytap.mcssdk.utils.e.b(str3, "parseMessageByIntent() finally will get miniProgramPkg");
                    if (bVar != null) {
                        try {
                            com.heytap.mcssdk.utils.e.b(str3, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                            bVar.f(intent.getStringExtra("miniProgramPkg"));
                            com.heytap.mcssdk.utils.e.b("OnHandleIntent-message:" + bVar.toString());
                        } catch (Exception e12) {
                            com.heytap.mcssdk.utils.e.b("OnHandleIntent--" + e12.getMessage() + " ");
                        }
                    }
                    return bVar;
                }
            } catch (Throwable unused) {
                bVar3 = bVar2;
                str = f14324a;
                com.heytap.mcssdk.utils.e.b(str, "parseMessageByIntent() finally will get miniProgramPkg");
                if (bVar3 != null) {
                    try {
                        com.heytap.mcssdk.utils.e.b(str, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        bVar3.f(intent.getStringExtra("miniProgramPkg"));
                        com.heytap.mcssdk.utils.e.b("OnHandleIntent-message:" + bVar3.toString());
                    } catch (Exception e13) {
                        com.heytap.mcssdk.utils.e.b("OnHandleIntent--" + e13.getMessage() + " ");
                    }
                }
                return bVar3;
            }
        } catch (Exception e14) {
            bVar = null;
            e9 = e14;
        } catch (Throwable unused2) {
            str = f14324a;
            com.heytap.mcssdk.utils.e.b(str, "parseMessageByIntent() finally will get miniProgramPkg");
            if (bVar3 != null) {
                com.heytap.mcssdk.utils.e.b(str, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                bVar3.f(intent.getStringExtra("miniProgramPkg"));
                com.heytap.mcssdk.utils.e.b("OnHandleIntent-message:" + bVar3.toString());
            }
            return bVar3;
        }
    }
}

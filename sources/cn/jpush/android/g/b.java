package cn.jpush.android.g;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.asus.push.DataBuffer;
import cn.jiguang.push.asus.PushMessageReceiver;

/* JADX INFO: loaded from: classes.dex */
public final class b extends cn.asus.push.a {
    @Override // cn.asus.push.b
    public final void call(DataBuffer dataBuffer) {
        try {
            StringBuilder sb = new StringBuilder("[call] data:");
            sb.append(String.valueOf(dataBuffer));
            sb.append(",cmd:");
            String str = dataBuffer.f8781a;
            Bundle bundle = dataBuffer.f8782b;
            sb.append(str);
            cn.jpush.android.i.b.a("ClientAIDLCallBack", sb.toString());
            String str2 = dataBuffer.f8781a;
            long j = bundle.getLong("message_rid", -1L);
            String string = bundle.getString("message_content");
            String strB = cn.jpush.android.f.c.b(cn.jpush.android.f.c.f11378a);
            if (!TextUtils.isEmpty(strB)) {
                ((PushMessageReceiver) Class.forName(strB).newInstance()).a(cn.jpush.android.f.c.f11378a, j, str2, string);
                return;
            }
            Intent intent = new Intent();
            bundle.putString("message_cmd", dataBuffer.f8781a);
            intent.putExtras(bundle);
            intent.setAction("com.ups.push.PUSH_RESPONSE");
            intent.setPackage(cn.jpush.android.f.c.f11380c);
            cn.jpush.android.f.c.f11378a.sendBroadcast(intent);
        } catch (Throwable unused) {
        }
    }
}

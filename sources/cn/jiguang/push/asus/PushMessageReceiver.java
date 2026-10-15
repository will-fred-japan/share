package cn.jiguang.push.asus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.f.c;
import cn.jpush.android.f.f;
import cn.jpush.android.i.b;
import com.vivo.push.sdk.BasePushMessageReceiver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f10688a;

    public void a(Context context, long j, String str, String str2) {
        JSONObject jSONObject;
        b.a(BasePushMessageReceiver.TAG, "receive cmd:" + str + ",rid:" + j + ",content:" + str2);
        if (TextUtils.isEmpty(str2)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e9) {
                e9.printStackTrace();
                jSONObject = null;
            }
        }
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            b.g(BasePushMessageReceiver.TAG, "handle json null");
            return;
        }
        try {
            a(context, str, j, jSONObject2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void a(Context context, cn.jpush.android.c.a aVar);

    public abstract void a(Context context, String str);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (f10688a == null) {
            f10688a = Executors.newSingleThreadExecutor();
        }
        f10688a.execute(new a(this, context, intent));
    }

    public final void a(Context context, Intent intent) {
        if ("com.ups.push.PUSH_RESPONSE".equals(intent.getAction())) {
            a(context, intent.getLongExtra("message_rid", -1L), intent.getStringExtra("message_cmd"), intent.getStringExtra("message_content"));
        }
    }

    private void a(Context context, String str, long j, JSONObject jSONObject) {
        cn.jpush.android.c.a aVar;
        int iOptInt;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject;
        char c5 = 5;
        if (jSONObject3.has("cmd_msg_result")) {
            iOptInt = jSONObject3.optInt("cmd_msg_result");
            if (iOptInt != 0) {
                b.c(BasePushMessageReceiver.TAG, "errorCode:" + iOptInt);
                if (iOptInt == 2) {
                    iOptInt = f.f11393d;
                } else if (iOptInt == 5) {
                    iOptInt = f.f11392c;
                } else if (iOptInt == 1) {
                    iOptInt = f.f11396g;
                }
            }
            aVar = new cn.jpush.android.c.a(str, iOptInt);
        } else {
            aVar = null;
            iOptInt = 3;
        }
        if (jSONObject3.has("cmd_msg_result_content")) {
            try {
                jSONObject2 = new JSONObject(jSONObject3.getString("cmd_msg_result_content"));
            } catch (Throwable unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                jSONObject3 = jSONObject2;
            }
        }
        if (TextUtils.isEmpty(str)) {
            a(context, aVar);
            return;
        }
        str.getClass();
        byte b9 = -1;
        switch (str.hashCode()) {
            case -530269543:
                if (str.equals("ups.register")) {
                    b9 = 0;
                }
                break;
            case -129063684:
                if (str.equals("ups.turnOff")) {
                    b9 = 1;
                }
                break;
            case -76940622:
                if (str.equals("ups.unregister")) {
                    b9 = 2;
                }
                break;
            case 685741602:
                if (str.equals("ups.pushStatus")) {
                    b9 = 3;
                }
                break;
            case 1306253107:
                if (str.equals("ups.login")) {
                    c5 = 4;
                    b9 = c5;
                }
                break;
            case 2074046642:
                if (str.equals("ups.turnOn")) {
                    b9 = c5;
                }
                break;
        }
        switch (b9) {
            case 0:
                String strOptString = jSONObject3.optString("registrationId", "");
                cn.jpush.android.f.b bVar = new cn.jpush.android.f.b(str, j);
                cn.jpush.android.e.a aVarA = cn.jpush.android.f.a.a(bVar);
                if (aVarA != null) {
                    cn.jpush.android.f.a.b(bVar);
                }
                if (!TextUtils.isEmpty(strOptString)) {
                    b.b(BasePushMessageReceiver.TAG, "register succ.");
                    if (aVarA != null) {
                        aVarA.a(new cn.jpush.android.e.b(0, strOptString, "successs"));
                    }
                    a(context, strOptString);
                    cn.jpush.android.a.b.a(strOptString);
                    return;
                }
                if (iOptInt != 1) {
                    a(context, aVar);
                    if (aVarA != null) {
                        aVarA.a(new cn.jpush.android.e.b(aVar.a(), "", "failed"));
                        return;
                    }
                    return;
                }
                return;
            case 1:
            case 5:
                break;
            case 2:
                if (iOptInt == 0) {
                    cn.jpush.android.a.b.a("");
                }
                cn.jpush.android.f.b bVar2 = new cn.jpush.android.f.b(str, j);
                cn.jpush.android.e.a aVarA2 = cn.jpush.android.f.a.a(bVar2);
                if (aVarA2 != null) {
                    cn.jpush.android.f.a.b(bVar2);
                    aVarA2.a(new cn.jpush.android.e.b(iOptInt, "", iOptInt == 0 ? "success" : "failed"));
                    return;
                }
                return;
            case 3:
                Bundle bundle = new Bundle();
                bundle.putBoolean("isPushStopped", jSONObject3.optBoolean("isPushStopped", false));
                if (aVar != null) {
                    aVar.a(bundle);
                }
                break;
            case 4:
                b.b(BasePushMessageReceiver.TAG, "logined");
                if (TextUtils.isEmpty(c.f11379b) || !TextUtils.isEmpty(cn.jpush.android.a.b.b(context))) {
                    return;
                }
                cn.jpush.android.h.a.a(context, c.f11379b, null);
                return;
            default:
                b.d(BasePushMessageReceiver.TAG, "unkown cmd:".concat(str));
                return;
        }
        a(context, aVar);
    }
}

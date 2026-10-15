package p087l6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationCustomButton;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.VoipDataMessage;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JPushEventReceiver.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends JPushMessageReceiver {

    /* JADX INFO: renamed from: l6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class RunnableC0225a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoipDataMessage f20064a;

        public RunnableC0225a(VoipDataMessage voipDataMessage) {
            this.f20064a = voipDataMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("transmitVoipMessage voipDataMessage=");
            VoipDataMessage voipDataMessage = this.f20064a;
            sb.append(voipDataMessage);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put("messageId", voipDataMessage.getMessageId());
            map.put("extraData", voipDataMessage.getExtraData());
            map.put("platform", Integer.valueOf(voipDataMessage.getPlatform()));
            dVar.e("onVoipMessage", map);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationCustomButton f20065a;

        public b(NotificationCustomButton notificationCustomButton) {
            this.f20065a = notificationCustomButton;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("[onNotifyButtonClick] :");
            NotificationCustomButton notificationCustomButton = this.f20065a;
            sb.append(notificationCustomButton);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put(RemoteMessageConst.MSGID, notificationCustomButton.f11205a);
            map.put("platform", Integer.valueOf(notificationCustomButton.f11206b));
            map.put(MTCommonConstants.Network.KEY_NAME, notificationCustomButton.f11207c);
            map.put("actionType", Integer.valueOf(notificationCustomButton.f11208d));
            map.put("action", notificationCustomButton.f11209e);
            map.put("data", notificationCustomButton.f11210f);
            dVar.e("onNotifyButtonClick", map);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JPushMessage f20066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m7.l.d f20067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f20068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f20069d;

        public c(JPushMessage jPushMessage, m7.l.d dVar, JSONObject jSONObject, int i9) {
            this.f20066a = jPushMessage;
            this.f20067b = dVar;
            this.f20068c = jSONObject;
            this.f20069d = i9;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JPushMessage jPushMessage = this.f20066a;
            int errorCode = jPushMessage.getErrorCode();
            m7.l.d dVar = this.f20067b;
            if (errorCode == 0) {
                Set<String> tags = jPushMessage.getTags();
                ArrayList arrayList = tags != null ? new ArrayList(tags) : new ArrayList();
                HashMap map = new HashMap();
                map.put("tags", arrayList);
                dVar.success(map);
            } else {
                try {
                    this.f20068c.put("code", jPushMessage.getErrorCode());
                } catch (JSONException e9) {
                    e9.printStackTrace();
                }
                dVar.error(Integer.toString(jPushMessage.getErrorCode()), "", "");
            }
            l6.d.b.f20103a.f20098g.remove(Integer.valueOf(this.f20069d));
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JPushMessage f20070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m7.l.d f20071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f20072c;

        public d(JPushMessage jPushMessage, m7.l.d dVar, int i9) {
            this.f20070a = jPushMessage;
            this.f20071b = dVar;
            this.f20072c = i9;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JPushMessage jPushMessage = this.f20070a;
            int errorCode = jPushMessage.getErrorCode();
            m7.l.d dVar = this.f20071b;
            if (errorCode == 0) {
                Set<String> tags = jPushMessage.getTags();
                ArrayList arrayList = tags != null ? new ArrayList(tags) : new ArrayList();
                HashMap map = new HashMap();
                map.put("tags", arrayList);
                dVar.success(map);
            } else {
                dVar.error(Integer.toString(jPushMessage.getErrorCode()), "", "");
            }
            l6.d.b.f20103a.f20098g.remove(Integer.valueOf(this.f20072c));
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JPushMessage f20073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m7.l.d f20074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f20075c;

        public e(JPushMessage jPushMessage, m7.l.d dVar, int i9) {
            this.f20073a = jPushMessage;
            this.f20074b = dVar;
            this.f20075c = i9;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JPushMessage jPushMessage = this.f20073a;
            int errorCode = jPushMessage.getErrorCode();
            m7.l.d dVar = this.f20074b;
            if (errorCode == 0) {
                HashMap map = new HashMap();
                map.put(MTPushConstants.Operation.KEY_ALIAS, jPushMessage.getAlias() != null ? jPushMessage.getAlias() : "");
                dVar.success(map);
            } else {
                dVar.error(Integer.toString(jPushMessage.getErrorCode()), "", "");
            }
            l6.d.b.f20103a.f20098g.remove(Integer.valueOf(this.f20075c));
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationMessage f20076a;

        public f(NotificationMessage notificationMessage) {
            this.f20076a = notificationMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("transmitNotificationReceive notificationMessage=");
            NotificationMessage notificationMessage = this.f20076a;
            sb.append(notificationMessage);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put("title", notificationMessage.notificationTitle);
            map.put("alert", notificationMessage.notificationContent);
            map.put("extras", p087l6.d.c(notificationMessage));
            Log.d("| JPUSH | Flutter | Android | ", "transmitNotificationReceive notification=" + map);
            dVar.e("onReceiveNotification", map);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationMessage f20077a;

        public g(NotificationMessage notificationMessage) {
            this.f20077a = notificationMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            Intent launchIntentForPackage;
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("transmitNotificationOpen notificationMessage=");
            NotificationMessage notificationMessage = this.f20077a;
            sb.append(notificationMessage);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put("title", notificationMessage.notificationTitle);
            map.put("alert", notificationMessage.notificationContent);
            map.put("extras", p087l6.d.c(notificationMessage));
            if (1 == notificationMessage.notificationType && (context = dVar.f20099h.get()) != null && (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName())) != null) {
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                launchIntentForPackage.setFlags(805306368);
                context.startActivity(launchIntentForPackage);
            }
            dVar.e("onOpenNotification", map);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomMessage f20078a;

        public h(CustomMessage customMessage) {
            this.f20078a = customMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("transmitMessageReceive customMessage=");
            CustomMessage customMessage = this.f20078a;
            sb.append(customMessage);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put("message", customMessage.message);
            map.put("alert", customMessage.title);
            HashMap map2 = new HashMap();
            map2.put(JPushInterface.EXTRA_EXTRA, p087l6.d.g(customMessage.extra));
            map2.put(JPushInterface.EXTRA_MSG_ID, customMessage.messageId);
            map2.put(JPushInterface.EXTRA_CONTENT_TYPE, customMessage.contentType);
            if (JPushConstants.SDK_VERSION_CODE >= 387) {
                map2.put(JPushInterface.EXTRA_TYPE_PLATFORM, Byte.valueOf(customMessage.platform));
            }
            map.put("extras", map2);
            dVar.e("onReceiveMessage", map);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20079a;

        public i(String str) {
            this.f20079a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("transmitReceiveRegistrationId： ");
            String str = this.f20079a;
            sb.append(str);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            dVar.d().post(new H1.c(2, dVar));
            dVar.b(str);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CmdMessage f20080a;

        public j(CmdMessage cmdMessage) {
            this.f20080a = cmdMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p096m7.k kVar;
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("[onCommandResult] message:");
            CmdMessage cmdMessage = this.f20080a;
            sb.append(cmdMessage);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            if (cmdMessage != null && cmdMessage.cmd == 2003 && (kVar = dVar.f20100i) != null) {
                int i9 = cmdMessage.errorCode;
                boolean z8 = false;
                if (i9 == 0) {
                    i9 = 0;
                } else if (i9 == 1) {
                    i9 = 0;
                    z8 = true;
                }
                HashMap map = new HashMap();
                map.put("code", Integer.valueOf(i9));
                map.put("isStopped", Boolean.valueOf(z8));
                dVar.d().post(new p087l6.b(dVar, kVar, map));
                return;
            }
            HashMap map2 = new HashMap();
            map2.put(MTCoreConstants.Protocol.KEY_CMD, Integer.valueOf(cmdMessage.cmd));
            map2.put("errorCode", Integer.valueOf(cmdMessage.errorCode));
            map2.put("msg", cmdMessage.msg);
            Bundle bundle = cmdMessage.extra;
            HashMap map3 = new HashMap();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (!"intent_component".equals(str) && !"intent_action".equals(str) && !"intent_flags".equals(str)) {
                        try {
                            Object obj = bundle.get(str);
                            if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof String)) {
                                map3.put(str, obj);
                            } else {
                                map3.put(str, String.valueOf(obj));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            map2.put("extras", map3);
            dVar.e("onCommandResult", map2);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationMessage f20081a;

        public k(NotificationMessage notificationMessage) {
            this.f20081a = notificationMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("[onNotifyMessageUnShow] message:");
            NotificationMessage notificationMessage = this.f20081a;
            sb.append(notificationMessage);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put("title", notificationMessage.notificationTitle);
            map.put("alert", notificationMessage.notificationContent);
            map.put("extras", p087l6.d.c(notificationMessage));
            dVar.e("onNotifyMessageUnShow", map);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20082a;

        public l(boolean z8) {
            this.f20082a = z8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("[onConnected] :");
            boolean z8 = this.f20082a;
            sb.append(z8);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put("result", Boolean.valueOf(z8));
            dVar.e("onConnected", map);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationMessage f20083a;

        public m(NotificationMessage notificationMessage) {
            this.f20083a = notificationMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("[onInAppMessageShow] :");
            NotificationMessage notificationMessage = this.f20083a;
            sb.append(notificationMessage);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put("title", notificationMessage.inAppMsgTitle);
            map.put("alert", notificationMessage.inAppMsgContentBody);
            map.put("messageId", notificationMessage.msgId);
            map.put("inAppShowTarget", notificationMessage.inAppShowTarget);
            map.put("inAppClickAction", notificationMessage.inAppClickAction);
            map.put("inAppExtras", p087l6.d.g(notificationMessage.inAppExtras));
            dVar.e("onInAppMessageShow", map);
        }
    }

    /* JADX INFO: compiled from: JPushEventReceiver.java */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationMessage f20084a;

        public n(NotificationMessage notificationMessage) {
            this.f20084a = notificationMessage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p087l6.d dVar = l6.d.b.f20103a;
            dVar.getClass();
            StringBuilder sb = new StringBuilder("[onInAppMessageClick] :");
            NotificationMessage notificationMessage = this.f20084a;
            sb.append(notificationMessage);
            Log.d("| JPUSH | Flutter | Android | ", sb.toString());
            HashMap map = new HashMap();
            map.put("title", notificationMessage.inAppMsgTitle);
            map.put("alert", notificationMessage.inAppMsgContentBody);
            map.put("messageId", notificationMessage.msgId);
            map.put("inAppShowTarget", notificationMessage.inAppShowTarget);
            map.put("inAppClickAction", notificationMessage.inAppClickAction);
            map.put("inAppExtras", p087l6.d.g(notificationMessage.inAppExtras));
            dVar.e("onInAppMessageClick", map);
        }
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onAliasOperatorResult(context, jPushMessage);
        int sequence = jPushMessage.getSequence();
        p087l6.d dVar = l6.d.b.f20103a;
        m7.l.d dVar2 = (m7.l.d) dVar.f20098g.get(Integer.valueOf(sequence));
        if (dVar2 == null) {
            Log.i("JPushPlugin", "Unexpected error, callback is null!");
        } else {
            dVar.d().post(new e(jPushMessage, dVar2, sequence));
        }
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onCheckTagOperatorResult(context, jPushMessage);
        int sequence = jPushMessage.getSequence();
        p087l6.d dVar = l6.d.b.f20103a;
        m7.l.d dVar2 = (m7.l.d) dVar.f20098g.get(Integer.valueOf(sequence));
        if (dVar2 == null) {
            Log.i("JPushPlugin", "Unexpected error, callback is null!");
        } else {
            dVar.d().post(new d(jPushMessage, dVar2, sequence));
        }
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onCommandResult(Context context, CmdMessage cmdMessage) {
        l6.d.b.f20103a.d().post(new j(cmdMessage));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onConnected(Context context, boolean z8) {
        l6.d.b.f20103a.d().post(new l(z8));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        Log.i("JPushPlugin", "[onInAppMessageClick], " + notificationMessage.toString());
        l6.d.b.f20103a.d().post(new n(notificationMessage));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onInAppMessageShow(Context context, NotificationMessage notificationMessage) {
        Log.i("JPushPlugin", "[onInAppMessageShow], " + notificationMessage.toString());
        l6.d.b.f20103a.d().post(new m(notificationMessage));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onMessage(Context context, CustomMessage customMessage) {
        l6.d.b.f20103a.d().post(new h(customMessage));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onNotificationSettingsCheck(Context context, boolean z8, int i9) {
        super.onNotificationSettingsCheck(context, z8, i9);
        HashMap map = new HashMap();
        map.put("isEnabled", Boolean.valueOf(z8));
        l6.d.b.f20103a.f(map, null, "onReceiveNotificationAuthorization");
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onNotifyButtonClick(Context context, NotificationCustomButton notificationCustomButton) {
        super.onNotifyButtonClick(context, notificationCustomButton);
        Log.i("JPushPlugin", "[onNotifyButtonClick], " + notificationCustomButton.toString());
        l6.d.b.f20103a.d().post(new b(notificationCustomButton));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        l6.d.b.f20103a.d().post(new f(notificationMessage));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        l6.d.b.f20103a.d().post(new g(notificationMessage));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onNotifyMessageUnShow(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageUnShow(context, notificationMessage);
        l6.d.b.f20103a.d().post(new k(notificationMessage));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onRegister(Context context, String str) {
        l6.d.b.f20103a.d().post(new i(str));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onTagOperatorResult(context, jPushMessage);
        JSONObject jSONObject = new JSONObject();
        int sequence = jPushMessage.getSequence();
        try {
            jSONObject.put("sequence", sequence);
        } catch (JSONException e9) {
            e9.printStackTrace();
        }
        p087l6.d dVar = l6.d.b.f20103a;
        m7.l.d dVar2 = (m7.l.d) dVar.f20098g.get(Integer.valueOf(sequence));
        if (dVar2 == null) {
            Log.i("JPushPlugin", "Unexpected error, callback is null!");
        } else {
            dVar.d().post(new c(jPushMessage, dVar2, jSONObject, sequence));
        }
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public final void onVoipMessage(Context context, VoipDataMessage voipDataMessage) {
        l6.d.b.f20103a.d().post(new RunnableC0225a(voipDataMessage));
    }
}

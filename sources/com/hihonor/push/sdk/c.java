package com.hihonor.push.sdk;

import G.RunnableC0310a;
import N6.RunnableC0333d;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f14458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Message f14459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Messenger f14460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteNotificationInfo f14461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f14462e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseExtensionService.IExtensionCallback f14463f = new R3.a(6, this);

    public c(Message message, b bVar) {
        this.f14459b = message;
        this.f14458a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        b bVar = this.f14458a;
        if (bVar == null || bVar.a() == null) {
            return;
        }
        this.f14458a.a().onExtensionTimeWillExpire(this.f14461d, this.f14463f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        e1.b().execute(new RunnableC0310a(11, this));
    }

    public void c() {
        Message message = this.f14459b;
        if (message == null) {
            b(null);
            Log.w("ExtMsgProcessor", "process() message is null");
            return;
        }
        Bundle data = message.getData();
        if (data == null) {
            Log.w("ExtMsgProcessor", "process() message data is null");
            b(null);
            return;
        }
        Log.w("ExtMsgProcessor", "process() setClassLoader");
        data.setClassLoader(RemoteNotificationInfo.class.getClassLoader());
        this.f14461d = (RemoteNotificationInfo) data.getParcelable("remoteNotificationInfo");
        this.f14460c = this.f14459b.replyTo;
        Log.w("ExtMsgProcessor", "process()");
        if (this.f14461d == null) {
            Log.w("ExtMsgProcessor", "process() remoteNotificationInfo is null");
            b(null);
            return;
        }
        BaseExtensionService baseExtensionServiceA = this.f14458a.a();
        if (baseExtensionServiceA != null) {
            long extDecTo = this.f14461d.getExtDecTo();
            if (extDecTo <= 0) {
                extDecTo = 10000;
            }
            this.f14458a.postDelayed(new D6.a(19, this), extDecTo);
            e1.b().execute(new RunnableC0333d(5, this, baseExtensionServiceA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseExtensionService baseExtensionService) {
        baseExtensionService.onReceiveRemoteNotification(this.f14461d, this.f14463f);
    }

    public final void b(RemoteNotificationContent remoteNotificationContent) {
        Objects.toString(remoteNotificationContent);
        long msgId = this.f14461d.getMsgId();
        Bundle bundle = new Bundle();
        bundle.putLong(RemoteMessageConst.MSGID, msgId);
        bundle.putInt("code", 0);
        bundle.putString("msg", "SUCCESS");
        bundle.putParcelable("remoteNotificationContent", remoteNotificationContent);
        Message messageObtain = Message.obtain(null, 0, 0, 0, null);
        messageObtain.what = 10000;
        messageObtain.setData(bundle);
        try {
            this.f14460c.send(messageObtain);
        } catch (Exception e9) {
            m.a("ExtMsgProcessor", "onHandleMessage() reply failed! ", e9);
        }
        this.f14459b = null;
        this.f14458a = null;
        this.f14460c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RemoteNotificationContent remoteNotificationContent) {
        Objects.toString(remoteNotificationContent);
        if (this.f14462e.compareAndSet(false, true)) {
            b(remoteNotificationContent);
        }
    }
}

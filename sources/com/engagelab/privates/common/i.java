package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.monitor.tcp.TCPTimeManager;
import com.engagelab.privates.core.MTCore;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile i f12244e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f12245a = p.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f12246b = m.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12247c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12248d = true;

    public static i a() {
        if (f12244e == null) {
            synchronized (i.class) {
                try {
                    if (f12244e == null) {
                        f12244e = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12244e;
    }

    public void b(Context context, Bundle bundle) {
        this.f12246b.a(context, bundle);
    }

    public void c(Context context, Bundle bundle) {
        if (bundle != null && bundle.containsKey("retry")) {
            this.f12248d = bundle.getBoolean("retry");
        }
        f(context);
    }

    public void d(Context context) {
        if (!x.c(context)) {
            MTCommonLog.w("MTConnectBusiness", "connect state is false, can't startConnect");
            return;
        }
        if (!this.f12248d) {
            MTCommonLog.w("MTConnectBusiness", "canReconnect is false, can't startConnect");
            return;
        }
        TCPTimeManager.startInit(context);
        w.f(context);
        MTCommonLog.d("MTConnectBusiness", "startConnect");
        this.f12245a.e(context);
        this.f12246b.g(context);
    }

    public void e(Context context) {
        MTCommonLog.d("MTConnectBusiness", "startHeartbeat");
        String str = MTCore.f12418a;
        MTCommonPrivatesApi.sendMessageDelayed(context, str, MTCoreConstants.RemoteWhat.START_HEARTBEAT, null, MTCoreGlobal.getHeartbeatInterval());
        MTProtocol threadName = new MTProtocol().setCommand(2).setVersion(4).setBody(y.c(context)).setThreadName(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("protocol", threadName);
        b(context, bundle);
    }

    public void f(Context context) {
        MTCommonLog.d("MTConnectBusiness", "stopConnect");
        this.f12245a.g(context);
        this.f12246b.h(context);
    }

    public void g(Context context) {
        MTCommonLog.d("MTConnectBusiness", "stopHeartbeat");
        MTCommonPrivatesApi.removeMessages(context, MTCore.f12418a, MTCoreConstants.RemoteWhat.START_HEARTBEAT);
    }

    public void h(Context context) {
        MTCommonLog.d("MTConnectBusiness", "turnOffConnect");
        x.a(context, false);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.STOP_CONNECT, null);
    }

    public void i(Context context) {
        MTCommonLog.d("MTConnectBusiness", "turnOnConnect");
        x.a(context, true);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.START_CONNECT, null);
    }

    public void b(Context context) {
        MTCommonReceiver commonReceiver = MTGlobal.getCommonReceiver(context);
        if (commonReceiver == null) {
            return;
        }
        commonReceiver.onConnectStatus(context, true);
    }

    public boolean b() {
        return this.f12246b.b();
    }

    public void c(Context context) {
        MTCommonReceiver commonReceiver = MTGlobal.getCommonReceiver(context);
        if (commonReceiver == null) {
            return;
        }
        commonReceiver.onConnectStatus(context, false);
    }

    public void a(Context context, Bundle bundle) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(((MTProtocol) bundle.getParcelable("protocol")).getBody());
        byte b9 = byteBufferWrap.get();
        byte b10 = byteBufferWrap.get();
        byte b11 = byteBufferWrap.get();
        long j = byteBufferWrap.getLong();
        StringBuilder sbG = H2.a.g(b9, b10, "onAckSuccess command:", ", result:", ", code:");
        sbG.append((int) b11);
        sbG.append(", serverTime:");
        sbG.append(j);
        MTCommonLog.d("MTConnectBusiness", sbG.toString());
        if (b9 == 2) {
            MTCommonLog.i("MTConnectBusiness", "onHeartbeatSuccess");
            this.f12247c = 0;
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, 2003, null);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.ON_HEARTBEAT, null);
        }
    }

    public void a(Context context) {
        this.f12247c++;
        MTCommonLog.d("MTConnectBusiness", "onAckFailed :" + this.f12247c);
        if (this.f12247c < 5) {
            g(context);
            e(context);
        } else {
            this.f12247c = 0;
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.STOP_CONNECT, null);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.START_CONNECT, null);
        }
    }
}

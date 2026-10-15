package com.xiaomi.push;

import android.os.Build;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class ev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.a.AbstractBinderC0186a f407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Boolean f408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final CopyOnWriteArraySet<b> f410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private AtomicReference<Integer> f411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17405d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ev f17407a = new ev();
    }

    public interface b {
        void a(String str);
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f410a.add(bVar);
    }

    public boolean b() {
        return this.f411a.get() != null && this.f411a.get().intValue() >= 1;
    }

    private ev() {
        this.f17402a = -1;
        this.f17403b = -2;
        this.f17404c = -3;
        this.f17405d = -4;
        this.f408a = Boolean.FALSE;
        this.f411a = new AtomicReference<>();
        this.f410a = new CopyOnWriteArraySet<>();
        try {
            if (!k.m649a(t.m835a())) {
                com.xiaomi.channel.commonutils.logger.c.m9a("[Proxy] NO XMSF NO Support");
                return;
            }
            if (TextUtils.equals(Build.PRODUCT, "xuanyuan")) {
                return;
            }
            Object objA = bh.a("miui.telephony.TelephonyManagerEx", "getDefault", new Object[0]);
            this.f409a = objA;
            if (objA == null) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Proxy] TelephonyManagerEx does not exist");
                return;
            }
            Object objA2 = bh.a(objA, "isModemTcpKaSupported", new Object[0]);
            if (objA2 instanceof Boolean) {
                this.f408a = (Boolean) objA2;
            }
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Proxy] hardware heartbeat supportability:" + this.f408a);
            if (this.f408a.booleanValue()) {
                com.xiaomi.push.a.AbstractBinderC0186a abstractBinderC0186a = new com.xiaomi.push.a.AbstractBinderC0186a() { // from class: com.xiaomi.push.ev.1
                    @Override // com.xiaomi.push.a
                    public void a(String str) {
                        ev.this.a(str);
                    }
                };
                this.f407a = abstractBinderC0186a;
                bh.a(this.f409a, "registerModemTcpKaCallback", abstractBinderC0186a);
            }
            Object objA3 = bh.a(this.f409a, "getTcpKeepAliveFeatureSupportVersion", new Object[0]);
            if (objA3 instanceof Integer) {
                this.f411a.set((Integer) objA3);
            }
        } catch (Throwable th) {
            defpackage.f.q("[Proxy] exception occurred when proxy TME init, exception: ", "HwKaMgr", th);
        }
    }

    public void a(String str) {
        Iterator<b> it = this.f410a.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    public int b(int i9) {
        try {
            if (!m365a()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Proxy] not support modem keep alive when stop tcp keep alive");
                return -1;
            }
            Object objA = bh.a(this.f409a, "stopTcpKeepAlive", Integer.valueOf(i9));
            if (objA instanceof Integer) {
                return ((Integer) objA).intValue();
            }
            return -3;
        } catch (Throwable th) {
            defpackage.f.q("[Proxy] exception occurred in stopping tcp keep alive, exception: ", "HwKaMgr", th);
            return -4;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m365a() {
        return this.f408a.booleanValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Integer m364a() {
        return this.f411a.get();
    }

    public final int a(String str, int i9, String str2, int i10, int i11) {
        try {
            if (!m365a()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Proxy] not support modem keep alive when start tcp monitor register");
                return -1;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i9 >= 0 && i9 <= 65535 && i10 >= 0 && i10 <= 65535) {
                Object objA = bh.a(this.f409a, "startTcpMonitorRegister", str, Integer.valueOf(i9), str2, Integer.valueOf(i10), Integer.valueOf(i11));
                if (objA instanceof Integer) {
                    return ((Integer) objA).intValue();
                }
                return -3;
            }
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Proxy] illegal ip address/port when start tcp monitor register");
            return -2;
        } catch (Throwable th) {
            defpackage.f.q("[Proxy] exception occurred in starting tcp monitor register, exception: ", "HwKaMgr", th);
            return -4;
        }
    }

    public final int a(int i9) {
        try {
            if (!m365a()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Proxy] not support modem keep alive when stop tcp monitor register");
                return -1;
            }
            Object objA = bh.a(this.f409a, "stopTcpMonitorRegister", Integer.valueOf(i9));
            if (objA instanceof Integer) {
                return ((Integer) objA).intValue();
            }
            return -3;
        } catch (Throwable th) {
            defpackage.f.q("[Proxy] exception occurred in stopping tcp monitor register, exception: ", "HwKaMgr", th);
            return -4;
        }
    }

    public int a(String str, int i9, String str2, int i10, int i11, int i12) {
        try {
            if (!m365a()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Proxy] not support modem keep alive when start tcp keep alive");
                return -1;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i9 >= 0 && i9 <= 65535 && i10 >= 0 && i10 <= 65535) {
                Object objA = bh.a(this.f409a, "startTcpKeepAlive", str, Integer.valueOf(i9), str2, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
                if (objA instanceof Integer) {
                    return ((Integer) objA).intValue();
                }
                return -3;
            }
            com.xiaomi.channel.commonutils.logger.c.m10a("HwKaMgr", "[Proxy] illegal ip address/port when start tcp keep alive");
            return -2;
        } catch (Throwable th) {
            defpackage.f.q("[Proxy] exception occurred in starting tcp keep alive, exception: ", "HwKaMgr", th);
            return -4;
        }
    }

    public static ev a() {
        return a.f17407a;
    }
}

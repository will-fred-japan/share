package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hz;
import com.xiaomi.push.service.aq;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements AbstractPushManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f16970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f56a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PushConfiguration f57a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f59a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<d, AbstractPushManager> f58a = new HashMap();

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.e$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16972a;

        static {
            int[] iArr = new int[d.values().length];
            f16972a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16972a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16972a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16972a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private e(Context context) {
        this.f56a = context.getApplicationContext();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
    
        if (r3 != 4) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(com.xiaomi.mipush.sdk.d r3) {
        /*
            r2 = this;
            int[] r0 = com.xiaomi.mipush.sdk.e.AnonymousClass2.f16972a
            int r3 = r3.ordinal()
            r3 = r0[r3]
            r0 = 1
            r1 = 0
            if (r3 == r0) goto L31
            r0 = 2
            if (r3 == r0) goto L28
            r0 = 3
            if (r3 == r0) goto L16
            r0 = 4
            if (r3 == r0) goto L1e
            goto L3a
        L16:
            com.xiaomi.mipush.sdk.PushConfiguration r3 = r2.f57a
            if (r3 == 0) goto L1e
            boolean r1 = r3.getOpenCOSPush()
        L1e:
            com.xiaomi.mipush.sdk.PushConfiguration r3 = r2.f57a
            if (r3 == 0) goto L27
            boolean r3 = r3.getOpenFTOSPush()
            return r3
        L27:
            return r1
        L28:
            com.xiaomi.mipush.sdk.PushConfiguration r3 = r2.f57a
            if (r3 == 0) goto L3a
            boolean r3 = r3.getOpenFCMPush()
            return r3
        L31:
            com.xiaomi.mipush.sdk.PushConfiguration r3 = r2.f57a
            if (r3 == 0) goto L3a
            boolean r3 = r3.getOpenHmsPush()
            return r3
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.e.b(com.xiaomi.mipush.sdk.d):boolean");
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : assemble push register");
        if (this.f58a.size() <= 0) {
            a();
        }
        if (this.f58a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f58a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            f.m55a(this.f56a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.c.m9a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f58a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f58a.clear();
    }

    public static e a(Context context) {
        if (f16970a == null) {
            synchronized (e.class) {
                try {
                    if (f16970a == null) {
                        f16970a = new e(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f16970a;
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f57a = pushConfiguration;
        this.f59a = aq.a(this.f56a).a(hz.AggregatePushSwitch.a(), true);
        if (this.f57a.getOpenHmsPush() || this.f57a.getOpenFCMPush() || this.f57a.getOpenCOSPush() || this.f57a.getOpenFTOSPush()) {
            aq.a(this.f56a).a(new aq.a(101, "assemblePush") { // from class: com.xiaomi.mipush.sdk.e.1
                @Override // com.xiaomi.push.service.aq.a
                public void onCallback() {
                    boolean zA = aq.a(e.this.f56a).a(hz.AggregatePushSwitch.a(), true);
                    if (e.this.f59a != zA) {
                        e.this.f59a = zA;
                        f.b(e.this.f56a);
                    }
                }
            });
        }
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f58a.containsKey(dVar)) {
                this.f58a.remove(dVar);
            }
            this.f58a.put(dVar, abstractPushManager);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m52a(d dVar) {
        this.f58a.remove(dVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m53a(d dVar) {
        return this.f58a.containsKey(dVar);
    }

    public AbstractPushManager a(d dVar) {
        return this.f58a.get(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0108  */
    /* JADX WARN: Code duplicated, block: B:50:0x0189  */
    private void a() {
        d dVar;
        AbstractPushManager abstractPushManagerA;
        d dVar2;
        AbstractPushManager abstractPushManagerA2;
        d dVar3;
        AbstractPushManager abstractPushManagerA3;
        AbstractPushManager abstractPushManagerA4;
        PushConfiguration pushConfiguration = this.f57a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f57a.getOpenHmsPush() + " HW online switch : " + f.m59a(this.f56a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + h.m63a(this.f56a));
                com.xiaomi.channel.commonutils.logger.c.m9a(sb.toString());
            }
            if (this.f57a.getOpenHmsPush()) {
                Context context = this.f56a;
                d dVar4 = d.ASSEMBLE_PUSH_HUAWEI;
                if (f.m59a(context, dVar4) && h.m63a(this.f56a)) {
                    if (!m53a(dVar4)) {
                        a(dVar4, s.a(this.f56a, dVar4));
                    }
                    com.xiaomi.channel.commonutils.logger.c.c("hw manager add to list");
                } else {
                    dVar = d.ASSEMBLE_PUSH_HUAWEI;
                    if (m53a(dVar) && (abstractPushManagerA = a(dVar)) != null) {
                        m52a(dVar);
                        abstractPushManagerA.unregister();
                    }
                }
            } else {
                dVar = d.ASSEMBLE_PUSH_HUAWEI;
                if (m53a(dVar)) {
                    m52a(dVar);
                    abstractPushManagerA.unregister();
                }
            }
            if (this.f57a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f57a.getOpenFCMPush() + " FCM online switch : " + f.m59a(this.f56a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + h.b(this.f56a));
                com.xiaomi.channel.commonutils.logger.c.m9a(sb2.toString());
            }
            if (this.f57a.getOpenFCMPush()) {
                Context context2 = this.f56a;
                d dVar5 = d.ASSEMBLE_PUSH_FCM;
                if (f.m59a(context2, dVar5) && h.b(this.f56a)) {
                    if (!m53a(dVar5)) {
                        a(dVar5, s.a(this.f56a, dVar5));
                    }
                    com.xiaomi.channel.commonutils.logger.c.c("fcm manager add to list");
                } else {
                    dVar2 = d.ASSEMBLE_PUSH_FCM;
                    if (m53a(dVar2) && (abstractPushManagerA2 = a(dVar2)) != null) {
                        m52a(dVar2);
                        abstractPushManagerA2.unregister();
                    }
                }
            } else {
                dVar2 = d.ASSEMBLE_PUSH_FCM;
                if (m53a(dVar2)) {
                    m52a(dVar2);
                    abstractPushManagerA2.unregister();
                }
            }
            if (this.f57a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f57a.getOpenCOSPush() + " COS online switch : " + f.m59a(this.f56a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + h.c(this.f56a));
                com.xiaomi.channel.commonutils.logger.c.m9a(sb3.toString());
            }
            if (this.f57a.getOpenCOSPush()) {
                Context context3 = this.f56a;
                d dVar6 = d.ASSEMBLE_PUSH_COS;
                if (f.m59a(context3, dVar6) && h.c(this.f56a)) {
                    a(dVar6, s.a(this.f56a, dVar6));
                } else {
                    dVar3 = d.ASSEMBLE_PUSH_COS;
                    if (m53a(dVar3) && (abstractPushManagerA3 = a(dVar3)) != null) {
                        m52a(dVar3);
                        abstractPushManagerA3.unregister();
                    }
                }
            } else {
                dVar3 = d.ASSEMBLE_PUSH_COS;
                if (m53a(dVar3)) {
                    m52a(dVar3);
                    abstractPushManagerA3.unregister();
                }
            }
            if (this.f57a.getOpenFTOSPush()) {
                Context context4 = this.f56a;
                d dVar7 = d.ASSEMBLE_PUSH_FTOS;
                if (f.m59a(context4, dVar7) && h.d(this.f56a)) {
                    a(dVar7, s.a(this.f56a, dVar7));
                    return;
                }
            }
            d dVar8 = d.ASSEMBLE_PUSH_FTOS;
            if (!m53a(dVar8) || (abstractPushManagerA4 = a(dVar8)) == null) {
                return;
            }
            m52a(dVar8);
            abstractPushManagerA4.unregister();
        }
    }
}

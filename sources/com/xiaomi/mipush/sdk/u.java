package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.push.ax;
import com.xiaomi.push.bh;
import com.xiaomi.push.bl;
import com.xiaomi.push.di;
import com.xiaomi.push.eo;
import com.xiaomi.push.hu;
import com.xiaomi.push.hv;
import com.xiaomi.push.hy;
import com.xiaomi.push.hz;
import com.xiaomi.push.ie;
import com.xiaomi.push.ih;
import com.xiaomi.push.iq;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.ja;
import com.xiaomi.push.je;
import com.xiaomi.push.jf;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.ba;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f16997a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ArrayList<a> f73a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f16998b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f74a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f75a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f77a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Messenger f78a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f82a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<Message> f81a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16999c = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f83b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Intent f76a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Integer f79a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f80a = null;

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.u$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17004a;

        static {
            int[] iArr = new int[v.values().length];
            f17004a = iArr;
            try {
                iArr[v.DISABLE_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17004a[v.ENABLE_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17004a[v.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17004a[v.UPLOAD_FCM_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17004a[v.UPLOAD_COS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17004a[v.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class a<T extends jf<T, ?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        hu f17005a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        T f84a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f85a;
    }

    private u(Context context) {
        this.f82a = false;
        this.f77a = null;
        this.f75a = context.getApplicationContext();
        this.f82a = m73c();
        f16998b = m74d();
        this.f77a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.mipush.sdk.u.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message.what != 19) {
                    return;
                }
                String str = (String) message.obj;
                int i9 = message.arg1;
                synchronized (p.class) {
                    try {
                        if (p.a(u.this.f75a).m65a(str)) {
                            if (p.a(u.this.f75a).a(str) < 10) {
                                String string = message.getData() != null ? message.getData().getString("third_sync_reason") : "";
                                v vVar = v.DISABLE_PUSH;
                                if (vVar.ordinal() == i9 && "syncing".equals(p.a(u.this.f75a).a(vVar))) {
                                    u.this.a(str, vVar, true, (HashMap<String, String>) null);
                                } else {
                                    v vVar2 = v.ENABLE_PUSH;
                                    if (vVar2.ordinal() == i9 && "syncing".equals(p.a(u.this.f75a).a(vVar2))) {
                                        u.this.a(str, vVar2, true, (HashMap<String, String>) null);
                                    } else {
                                        v vVar3 = v.UPLOAD_HUAWEI_TOKEN;
                                        if (vVar3.ordinal() == i9 && "syncing".equals(p.a(u.this.f75a).a(vVar3))) {
                                            HashMap<String, String> mapM54a = f.m54a(u.this.f75a, d.ASSEMBLE_PUSH_HUAWEI);
                                            mapM54a.put("third_sync_reason", string);
                                            u.this.a(str, vVar3, false, mapM54a);
                                        } else {
                                            v vVar4 = v.UPLOAD_FCM_TOKEN;
                                            if (vVar4.ordinal() == i9 && "syncing".equals(p.a(u.this.f75a).a(vVar4))) {
                                                u uVar = u.this;
                                                uVar.a(str, vVar4, false, f.m54a(uVar.f75a, d.ASSEMBLE_PUSH_FCM));
                                            } else {
                                                v vVar5 = v.UPLOAD_COS_TOKEN;
                                                if (vVar5.ordinal() == i9 && "syncing".equals(p.a(u.this.f75a).a(vVar5))) {
                                                    HashMap<String, String> mapM54a2 = f.m54a(u.this.f75a, d.ASSEMBLE_PUSH_COS);
                                                    mapM54a2.put("third_sync_reason", string);
                                                    u.this.a(str, vVar5, false, mapM54a2);
                                                } else {
                                                    v vVar6 = v.UPLOAD_FTOS_TOKEN;
                                                    if (vVar6.ordinal() == i9 && "syncing".equals(p.a(u.this.f75a).a(vVar6))) {
                                                        HashMap<String, String> mapM54a3 = f.m54a(u.this.f75a, d.ASSEMBLE_PUSH_FTOS);
                                                        mapM54a3.put("third_sync_reason", string);
                                                        u.this.a(str, vVar6, false, mapM54a3);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                p.a(u.this.f75a).b(str);
                            } else {
                                p.a(u.this.f75a).c(str);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        if (com.xiaomi.push.k.m649a(context)) {
            com.xiaomi.push.service.h.a(new com.xiaomi.push.service.h.b() { // from class: com.xiaomi.mipush.sdk.u.2
                @Override // com.xiaomi.push.service.h.b
                public void a(it itVar, boolean z8) {
                    if (TextUtils.isEmpty(itVar.b()) || TextUtils.isEmpty(itVar.d())) {
                        com.xiaomi.channel.commonutils.logger.c.m9a("cpra no fill ainfo, fill it by default.");
                        itVar.b(b.m35a(u.this.f75a).m36a());
                        itVar.d(u.this.f75a.getPackageName());
                    }
                    u.this.a(itVar, hu.Notification, z8, (ih) null);
                }
            });
        }
        Intent intentB = b();
        if (intentB != null) {
            b(intentB);
        }
    }

    private synchronized void c(int i9) {
        this.f75a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i9).commit();
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f75a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m71a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f75a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f75a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private void g() {
        this.f74a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f75a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f75a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f75a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f75a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final void m82b() {
        Intent intentM68a = m68a();
        intentM68a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(intentM68a);
    }

    public void f() {
        Intent intentM68a = m68a();
        intentM68a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        intentM68a.putExtra(ay.f18280I, this.f75a.getPackageName());
        intentM68a.putExtra(ay.f18285N, bl.b(this.f75a.getPackageName()));
        c(intentM68a);
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f75a.getPackageName())) {
            return c();
        }
        com.xiaomi.channel.commonutils.logger.c.c("pushChannel xmsf create own channel");
        return e();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private boolean m73c() {
        try {
            PackageInfo packageInfo = this.f75a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public void m86e() {
        Intent intentM68a = m68a();
        intentM68a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) bh.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f75a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.c.m9a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        intentM68a.putExtra(ay.f18280I, packageName);
        c(intentM68a);
    }

    private Intent c() {
        if (m80a()) {
            com.xiaomi.channel.commonutils.logger.c.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.c.c("pushChannel app start  own channel");
        return e();
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m85d() {
        ArrayList<a> arrayList = f73a;
        synchronized (arrayList) {
            boolean z8 = Thread.currentThread() == Looper.getMainLooper().getThread();
            for (a aVar : arrayList) {
                a(aVar.f84a, aVar.f17005a, aVar.f85a, false, null, true);
                if (!z8) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f73a.clear();
        }
    }

    public void b(int i9) {
        Intent intentM68a = m68a();
        intentM68a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        intentM68a.putExtra(ay.f18280I, this.f75a.getPackageName());
        intentM68a.putExtra(ay.f18283L, i9);
        intentM68a.putExtra(ay.f18285N, bl.b(this.f75a.getPackageName() + i9));
        c(intentM68a);
    }

    public static synchronized u a(Context context) {
        try {
            if (f16997a == null) {
                f16997a = new u(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f16997a;
    }

    private synchronized int a() {
        return this.f75a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m84c() {
        if (this.f76a != null) {
            g();
            c(this.f76a);
            this.f76a = null;
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    private boolean m74d() {
        if (m80a()) {
            try {
                return this.f75a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m83b() {
        if (!m80a() || !m75e()) {
            return true;
        }
        if (this.f79a == null) {
            Integer numValueOf = Integer.valueOf(ba.a(this.f75a).a());
            this.f79a = numValueOf;
            if (numValueOf.intValue() == 0) {
                this.f75a.getContentResolver().registerContentObserver(ba.a(this.f75a).m769a(), false, new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.mipush.sdk.u.3
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z8) {
                        u uVar = u.this;
                        uVar.f79a = Integer.valueOf(ba.a(uVar.f75a).a());
                        if (u.this.f79a.intValue() != 0) {
                            u.this.f75a.getContentResolver().unregisterContentObserver(this);
                            if (ax.m111a(u.this.f75a)) {
                                u.this.m84c();
                            }
                        }
                    }
                });
            }
        }
        return this.f79a.intValue() != 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m76a() {
        return this.f74a;
    }

    private void c(Intent intent) {
        aq aqVarA = aq.a(this.f75a);
        int iA = hz.ServiceBootMode.a();
        hv hvVar = hv.START;
        int iA2 = aqVarA.a(iA, hvVar.a());
        int iA3 = a();
        hv hvVar2 = hv.BIND;
        boolean z8 = iA2 == hvVar2.a() && f16998b;
        int iA4 = z8 ? hvVar2.a() : hvVar.a();
        if (iA4 != iA3) {
            m81a(iA4);
        }
        if (z8) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    private boolean m75e() {
        String packageName = this.f75a.getPackageName();
        return packageName.contains("miui") || packageName.contains(MTPushConstants.Manufacturer.XIAOMI) || (this.f75a.getApplicationInfo().flags & 1) != 0;
    }

    public final void a(iu iuVar, boolean z8) {
        eo.a(this.f75a.getApplicationContext()).a(this.f75a.getPackageName(), "E100003", iuVar.a(), AuthCode.StatusCode.WAITING_CONNECT, null);
        this.f76a = null;
        b.m35a(this.f75a).f47a = iuVar.a();
        Intent intentM68a = m68a();
        byte[] bArrA = je.a(r.a(this.f75a, iuVar, hu.Registration));
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("register fail, because msgBytes is null.");
            return;
        }
        intentM68a.setAction("com.xiaomi.mipush.REGISTER_APP");
        intentM68a.putExtra("mipush_app_id", b.m35a(this.f75a).m36a());
        intentM68a.putExtra("mipush_payload", bArrA);
        intentM68a.putExtra("mipush_session", this.f80a);
        intentM68a.putExtra("mipush_env_chanage", z8);
        intentM68a.putExtra("mipush_env_type", b.m35a(this.f75a).a());
        if (ax.m111a(this.f75a) && m83b()) {
            g();
            c(intentM68a);
        } else {
            this.f76a = intentM68a;
        }
    }

    private synchronized void d(Intent intent) {
        try {
            if (this.f16999c) {
                Message messageA = a(intent);
                if (this.f81a.size() >= 50) {
                    this.f81a.remove(0);
                }
                this.f81a.add(messageA);
                return;
            }
            if (this.f78a == null) {
                this.f75a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.mipush.sdk.u.4
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        synchronized (u.this) {
                            u.this.f78a = new Messenger(iBinder);
                            u.this.f16999c = false;
                            Iterator it = u.this.f81a.iterator();
                            while (it.hasNext()) {
                                try {
                                    u.this.f78a.send((Message) it.next());
                                } catch (RemoteException e9) {
                                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                                }
                            }
                            u.this.f81a.clear();
                        }
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        u.this.f78a = null;
                        u.this.f16999c = false;
                    }
                }, 1);
                this.f16999c = true;
                this.f81a.clear();
                this.f81a.add(a(intent));
            } else {
                try {
                    this.f78a.send(a(intent));
                } catch (RemoteException unused) {
                    this.f78a = null;
                    this.f16999c = false;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void b(Intent intent) {
        try {
            if (!com.xiaomi.push.k.m648a()) {
                d(intent);
            } else {
                this.f75a.startService(intent);
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m77a() {
        b(m68a());
    }

    public final void a(ja jaVar) {
        byte[] bArrA = je.a(r.a(this.f75a, jaVar, hu.UnRegistration));
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent intentM68a = m68a();
        intentM68a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        intentM68a.putExtra("mipush_app_id", b.m35a(this.f75a).m36a());
        intentM68a.putExtra("mipush_payload", bArrA);
        c(intentM68a);
    }

    public final void a(boolean z8) {
        a(z8, (String) null);
    }

    public final void a(boolean z8, String str) {
        if (z8) {
            p pVarA = p.a(this.f75a);
            v vVar = v.DISABLE_PUSH;
            pVarA.a(vVar, "syncing");
            p.a(this.f75a).a(v.ENABLE_PUSH, "");
            a(str, vVar, true, (HashMap<String, String>) null);
            return;
        }
        p pVarA2 = p.a(this.f75a);
        v vVar2 = v.ENABLE_PUSH;
        pVarA2.a(vVar2, "syncing");
        p.a(this.f75a).a(v.DISABLE_PUSH, "");
        a(str, vVar2, true, (HashMap<String, String>) null);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m78a(Context context) {
        if (com.xiaomi.push.k.m648a()) {
            return;
        }
        q qVarA = h.a(context);
        if (q.HUAWEI.equals(qVarA)) {
            a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (q.OPPO.equals(qVarA)) {
            a((String) null, v.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS, "update");
        }
        if (q.VIVO.equals(qVarA)) {
            a((String) null, v.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    public final void a(String str, v vVar, d dVar, String str2) {
        p.a(this.f75a).a(vVar, "syncing");
        HashMap<String, String> mapM54a = f.m54a(this.f75a, dVar);
        mapM54a.put("third_sync_reason", str2);
        a(str, vVar, false, mapM54a);
    }

    public void a(int i9, String str) {
        Intent intentM68a = m68a();
        intentM68a.setAction("com.xiaomi.mipush.thirdparty");
        intentM68a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i9);
        intentM68a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(intentM68a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x006e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0072  */
    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:36:0x008c  */
    /* JADX WARN: Code duplicated, block: B:38:0x009a  */
    /* JADX WARN: Code duplicated, block: B:42:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:44:0x010e  */
    public void a(String str, v vVar, boolean z8, HashMap<String, String> map) {
        it itVar;
        it itVar2;
        hu huVar;
        Message messageObtain;
        byte[] bArrA;
        if (b.m35a(this.f75a).m42b() && ax.m111a(this.f75a)) {
            it itVar3 = new it();
            itVar3.a(true);
            Intent intentM68a = m68a();
            if (TextUtils.isEmpty(str)) {
                str = as.a();
                itVar3.a(str);
                itVar2 = z8 ? new it(str, true) : null;
                synchronized (p.class) {
                    p.a(this.f75a).m64a(str);
                }
            } else {
                itVar3.a(str);
                if (z8) {
                    itVar2 = new it(str, true);
                } else {
                    itVar = null;
                }
                switch (AnonymousClass5.f17004a[vVar.ordinal()]) {
                    case 1:
                        ie ieVar = ie.DisablePushMessage;
                        itVar3.c(ieVar.f611a);
                        itVar.c(ieVar.f611a);
                        if (map != null) {
                            itVar3.a(map);
                            itVar.a(map);
                        }
                        intentM68a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                        break;
                    case 2:
                        ie ieVar2 = ie.EnablePushMessage;
                        itVar3.c(ieVar2.f611a);
                        itVar.c(ieVar2.f611a);
                        if (map != null) {
                            itVar3.a(map);
                            itVar.a(map);
                        }
                        intentM68a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        itVar3.c(ie.ThirdPartyRegUpdate.f611a);
                        if (map != null) {
                            itVar3.a(map);
                        }
                        break;
                }
                com.xiaomi.channel.commonutils.logger.c.e("type:" + vVar + ", " + str);
                itVar3.b(b.m35a(this.f75a).m36a());
                itVar3.d(this.f75a.getPackageName());
                huVar = hu.Notification;
                a(itVar3, huVar, false, (ih) null);
                if (z8) {
                    itVar.b(b.m35a(this.f75a).m36a());
                    itVar.d(this.f75a.getPackageName());
                    Context context = this.f75a;
                    bArrA = je.a(r.a(context, itVar, huVar, false, context.getPackageName(), b.m35a(this.f75a).m36a()));
                    if (bArrA != null) {
                        di.a(this.f75a.getPackageName(), this.f75a, itVar, huVar, bArrA.length);
                        intentM68a.putExtra("mipush_payload", bArrA);
                        intentM68a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                        intentM68a.putExtra("mipush_app_id", b.m35a(this.f75a).m36a());
                        intentM68a.putExtra("mipush_app_token", b.m35a(this.f75a).b());
                        c(intentM68a);
                    }
                }
                messageObtain = Message.obtain();
                messageObtain.what = 19;
                int iOrdinal = vVar.ordinal();
                messageObtain.obj = str;
                messageObtain.arg1 = iOrdinal;
                if (map != null && map.get("third_sync_reason") != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("third_sync_reason", map.get("third_sync_reason"));
                    messageObtain.setData(bundle);
                }
                this.f77a.sendMessageDelayed(messageObtain, com.heytap.mcssdk.constant.a.f14256r);
            }
            itVar = itVar2;
            switch (AnonymousClass5.f17004a[vVar.ordinal()]) {
                case 1:
                    ie ieVar3 = ie.DisablePushMessage;
                    itVar3.c(ieVar3.f611a);
                    itVar.c(ieVar3.f611a);
                    if (map != null) {
                        itVar3.a(map);
                        itVar.a(map);
                    }
                    intentM68a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    ie ieVar4 = ie.EnablePushMessage;
                    itVar3.c(ieVar4.f611a);
                    itVar.c(ieVar4.f611a);
                    if (map != null) {
                        itVar3.a(map);
                        itVar.a(map);
                    }
                    intentM68a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    itVar3.c(ie.ThirdPartyRegUpdate.f611a);
                    if (map != null) {
                        itVar3.a(map);
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.c.e("type:" + vVar + ", " + str);
            itVar3.b(b.m35a(this.f75a).m36a());
            itVar3.d(this.f75a.getPackageName());
            huVar = hu.Notification;
            a(itVar3, huVar, false, (ih) null);
            if (z8) {
                itVar.b(b.m35a(this.f75a).m36a());
                itVar.d(this.f75a.getPackageName());
                Context context2 = this.f75a;
                bArrA = je.a(r.a(context2, itVar, huVar, false, context2.getPackageName(), b.m35a(this.f75a).m36a()));
                if (bArrA != null) {
                    di.a(this.f75a.getPackageName(), this.f75a, itVar, huVar, bArrA.length);
                    intentM68a.putExtra("mipush_payload", bArrA);
                    intentM68a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    intentM68a.putExtra("mipush_app_id", b.m35a(this.f75a).m36a());
                    intentM68a.putExtra("mipush_app_token", b.m35a(this.f75a).b());
                    c(intentM68a);
                }
            }
            messageObtain = Message.obtain();
            messageObtain.what = 19;
            int iOrdinal2 = vVar.ordinal();
            messageObtain.obj = str;
            messageObtain.arg1 = iOrdinal2;
            if (map != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("third_sync_reason", map.get("third_sync_reason"));
                messageObtain.setData(bundle2);
            }
            this.f77a.sendMessageDelayed(messageObtain, com.heytap.mcssdk.constant.a.f14256r);
        }
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, ih ihVar) {
        a(t, huVar, !huVar.equals(hu.Registration), ihVar);
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8, ih ihVar, boolean z9) {
        a(t, huVar, z8, true, ihVar, z9);
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8, ih ihVar) {
        a(t, huVar, z8, true, ihVar, true);
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8, boolean z9, ih ihVar, boolean z10) {
        a(t, huVar, z8, z9, ihVar, z10, this.f75a.getPackageName(), b.m35a(this.f75a).m36a());
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8, boolean z9, ih ihVar, boolean z10, String str, String str2) {
        a(t, huVar, z8, z9, ihVar, z10, str, str2, true);
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8, boolean z9, ih ihVar, boolean z10, String str, String str2, boolean z11) {
        a(t, huVar, z8, z9, ihVar, z10, str, str2, z11, true);
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8, boolean z9, ih ihVar, boolean z10, String str, String str2, boolean z11, boolean z12) {
        a(t, huVar, z8, z9, ihVar, z10, str, str2, z11, z12, "com.xiaomi.mipush.SEND_MESSAGE");
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8, boolean z9, ih ihVar, boolean z10, String str, String str2, boolean z11, boolean z12, String str3) {
        a(t, huVar, z8, z9, ihVar, ay.a.DEFAULT_CACHE, z10, str, str2, z11, z12, str3);
    }

    public final <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8, boolean z9, ih ihVar, ay.a aVar, boolean z10, String str, String str2, boolean z11, boolean z12, String str3) {
        iq iqVarB;
        if (z12 && !b.m35a(this.f75a).m44c()) {
            if (z9) {
                a(t, huVar, z8);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.c.m9a("drop the message before initialization.");
                return;
            }
        }
        if (z11) {
            iqVarB = r.a(this.f75a, t, huVar, z8, str, str2);
        } else {
            iqVarB = r.b(this.f75a, t, huVar, z8, str, str2);
        }
        if (ihVar != null) {
            iqVarB.a(ihVar);
        }
        byte[] bArrA = je.a(iqVarB);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("send message fail, because msgBytes is null.");
            return;
        }
        di.a(this.f75a.getPackageName(), this.f75a, t, huVar, bArrA.length);
        Intent intentM68a = m68a();
        intentM68a.setAction(str3);
        intentM68a.putExtra("mipush_payload", bArrA);
        intentM68a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z10);
        intentM68a.putExtra("mipush_message_cache_collection", aVar.f1070a);
        c(intentM68a);
    }

    public final void a(hy hyVar) {
        Intent intentM68a = m68a();
        byte[] bArrA = je.a(hyVar);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        intentM68a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        intentM68a.putExtra("mipush_payload", bArrA);
        b(intentM68a);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private Intent m68a() {
        if (m80a() && !"com.xiaomi.xmsf".equals(this.f75a.getPackageName())) {
            return d();
        }
        return e();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m71a() {
        String str = this.f83b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f75a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f83b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.f83b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m80a() {
        return this.f82a && 1 == b.m35a(this.f75a).a();
    }

    public <T extends jf<T, ?>> void a(T t, hu huVar, boolean z8) {
        a aVar = new a();
        aVar.f84a = t;
        aVar.f17005a = huVar;
        aVar.f85a = z8;
        ArrayList<a> arrayList = f73a;
        synchronized (arrayList) {
            try {
                arrayList.add(aVar);
                if (arrayList.size() > 10) {
                    arrayList.remove(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i9) {
        a(i9, 0);
    }

    public void a(int i9, int i10) {
        Intent intentM68a = m68a();
        intentM68a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        intentM68a.putExtra(ay.f18280I, this.f75a.getPackageName());
        intentM68a.putExtra(ay.f18281J, i9);
        intentM68a.putExtra(ay.f18282K, i10);
        c(intentM68a);
    }

    public void a(String str, String str2) {
        Intent intentM68a = m68a();
        intentM68a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        intentM68a.putExtra(ay.f18280I, this.f75a.getPackageName());
        intentM68a.putExtra(ay.O, str);
        intentM68a.putExtra(ay.f18286P, str2);
        c(intentM68a);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m79a(Intent intent) {
        intent.fillIn(m68a(), 24);
        c(intent);
    }

    private Message a(Intent intent) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 17;
        messageObtain.obj = intent;
        return messageObtain;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m81a(int i9) {
        if (!b.m35a(this.f75a).m42b()) {
            return false;
        }
        c(i9);
        it itVar = new it();
        itVar.a(as.a());
        itVar.b(b.m35a(this.f75a).m36a());
        itVar.d(this.f75a.getPackageName());
        itVar.c(ie.ClientABTest.f611a);
        HashMap map = new HashMap();
        itVar.f750a = map;
        map.put("boot_mode", i9 + "");
        a(this.f75a).a(itVar, hu.Notification, false, (ih) null);
        return true;
    }
}

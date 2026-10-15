package cn.jpush.android.f;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.text.TextUtils;
import cn.jiguang.push.asus.PushMessageReceiver;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f11378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f11379b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static cn.jpush.android.g.a f11384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f11385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Boolean f11386i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static AtomicLong f11383f = new AtomicLong(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f11380c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f11381d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f11382e = "com.asus.as";
    private static ExecutorService j = Executors.newSingleThreadExecutor();

    public static long a() {
        long jIncrementAndGet = f11383f.incrementAndGet();
        if (jIncrementAndGet == Long.MAX_VALUE) {
            f11383f.set(0L);
        }
        return jIncrementAndGet;
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f11385h)) {
            return f11385h;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.ups.push.PUSH_RESPONSE");
            intent.setPackage(context.getPackageName());
            ComponentInfo componentInfoA = cn.jpush.android.j.a.a(context, context.getPackageName(), PushMessageReceiver.class);
            if (componentInfoA != null) {
                f11385h = componentInfoA.name;
                cn.jpush.android.i.a.a("ASUS_PUSH", "Gobal", false, 4, "found userServiceClass :" + f11385h + " by getComponentInfo");
            }
        } catch (Throwable th) {
            cn.jpush.android.i.b.e("Gobal", "not found PushMessageReceiver :" + th.getMessage());
        }
        return f11385h;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:23:0x0053, B:25:0x0061), top: B:31:0x0053 }] */
    private static boolean c(Context context) {
        String str;
        NotificationManager notificationManager;
        Boolean bool = f11386i;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            cn.jpush.android.i.b.g("Gobal", "context is null");
            return false;
        }
        cn.jpush.android.g.d dVar = null;
        if (cn.jpush.android.j.a.a(context)) {
            if (cn.jpush.android.g.c.a(context, f11382e)) {
                dVar = new cn.jpush.android.g.d();
            } else {
                str = "cn.jpush.android.service.PushManagerService not exist in system, give up create connection.";
            }
            f11384g = dVar;
            if (dVar == null) {
                cn.jpush.android.i.b.g("Gobal", "unsupport this device.");
                f11386i = Boolean.FALSE;
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            f11378a = applicationContext;
            f11380c = applicationContext.getPackageName();
            cn.jpush.android.a.a.a(context);
            try {
                notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                if (notificationManager.getNotificationChannel("asus_default_channel_id") == null) {
                    cn.jpush.android.i.b.b("Gobal", "create default channel:默认");
                    notificationManager.createNotificationChannel(new NotificationChannel("asus_default_channel_id", "默认", 3));
                }
            } catch (Throwable th) {
                cn.jpush.android.i.b.e("Gobal", "[initNotificationChannel] failed:" + th.getMessage());
            }
            f11386i = Boolean.TRUE;
            return true;
        }
        str = "Manufacturer not match, give up create connection.";
        cn.jpush.android.i.b.f("ConnectionFactory", str);
        f11384g = dVar;
        if (dVar == null) {
            cn.jpush.android.i.b.g("Gobal", "unsupport this device.");
            f11386i = Boolean.FALSE;
            return false;
        }
        Context applicationContext2 = context.getApplicationContext();
        f11378a = applicationContext2;
        f11380c = applicationContext2.getPackageName();
        cn.jpush.android.a.a.a(context);
        notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager.getNotificationChannel("asus_default_channel_id") == null) {
            cn.jpush.android.i.b.b("Gobal", "create default channel:默认");
            notificationManager.createNotificationChannel(new NotificationChannel("asus_default_channel_id", "默认", 3));
        }
        f11386i = Boolean.TRUE;
        return true;
    }

    public static void a(Context context, String str, long j8, JSONObject jSONObject) {
        if (c(context)) {
            j.execute(new d(str, j8, jSONObject));
        }
    }

    public static /* synthetic */ void a(String str, long j8, JSONObject jSONObject) {
        cn.jpush.android.g.a aVar = f11384g;
        if (!(aVar != null ? aVar.b() : false)) {
            cn.jpush.android.i.b.a("Gobal", "connect has disconnect, will reconnect.");
            cn.jpush.android.g.a aVar2 = f11384g;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("JPUSH_PACKAGE", f11380c);
            if (j8 <= 0) {
                j8 = a();
            }
            jSONObject.put("JPUSH_RID", j8);
            String string = jSONObject.toString();
            cn.jpush.android.i.b.c("Gobal", "cmd:" + str + ",data:" + string);
            cn.jpush.android.g.a aVar3 = f11384g;
            if (aVar3 != null) {
                aVar3.a(str, string);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Context context) {
        return cn.jpush.android.g.c.a(context, f11382e);
    }
}

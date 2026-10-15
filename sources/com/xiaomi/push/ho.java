package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes2.dex */
public class ho {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ai f559a = new ai(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f17655a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f558a = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f561a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<a> f563a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f562a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static com.xiaomi.push.providers.a f560a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17657a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f564a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17658b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f566b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f567b;

        public a(String str, long j, int i9, int i10, String str2, long j8) {
            this.f565a = str;
            this.f564a = j;
            this.f17657a = i9;
            this.f17658b = i10;
            this.f567b = str2;
            this.f566b = j8;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f565a, this.f565a) && TextUtils.equals(aVar.f567b, this.f567b) && aVar.f17657a == this.f17657a && aVar.f17658b == this.f17658b && Math.abs(aVar.f564a - this.f564a) <= com.heytap.mcssdk.constant.a.f14256r;
        }
    }

    private static int b(Context context) {
        ay ayVarM104a = ax.m104a();
        if (ayVarM104a == null) {
            return -1;
        }
        return ayVarM104a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f933a) {
                try {
                    SQLiteDatabase writableDatabase = m476a(context).getWritableDatabase();
                    writableDatabase.beginTransaction();
                    try {
                        for (a aVar : list) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(Constants.PACKAGE_NAME, aVar.f565a);
                            contentValues.put("message_ts", Long.valueOf(aVar.f564a));
                            contentValues.put("network_type", Integer.valueOf(aVar.f17657a));
                            contentValues.put("bytes", Long.valueOf(aVar.f566b));
                            contentValues.put("rcv", Integer.valueOf(aVar.f17658b));
                            contentValues.put("imsi", aVar.f567b);
                            writableDatabase.insert("traffic", null, contentValues);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            com.xiaomi.channel.commonutils.logger.c.m12a(th3);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m479a(Context context) {
        f17655a = b(context);
    }

    public static int a(Context context) {
        if (f17655a == -1) {
            f17655a = b(context);
        }
        return f17655a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static synchronized String m477a(Context context) {
        if (!TextUtils.isEmpty(f562a)) {
            return f562a;
        }
        return "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized void m480a(String str) {
        if (!k.m656e() && !TextUtils.isEmpty(str)) {
            f562a = str;
        }
    }

    public static void a(Context context, String str, long j, boolean z8, boolean z9, long j8) {
        a(context, str, a(a(context), j, z8, j8, z9), z8, j8);
    }

    private static void a(final Context context, String str, long j, boolean z8, long j8) {
        int iA;
        boolean zIsEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (iA = a(context))) {
            return;
        }
        synchronized (f561a) {
            try {
                zIsEmpty = f563a.isEmpty();
                a(new a(str, j8, iA, z8 ? 1 : 0, iA == 0 ? m477a(context) : "", j));
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsEmpty) {
            f559a.a(new ai.b() { // from class: com.xiaomi.push.ho.1
                @Override // com.xiaomi.push.ai.b
                public void b() {
                    ArrayList arrayList;
                    synchronized (ho.f561a) {
                        arrayList = new ArrayList(ho.f563a);
                        ho.f563a.clear();
                    }
                    ho.b(context, arrayList);
                }
            }, com.heytap.mcssdk.constant.a.f14256r);
        }
    }

    private static long a(int i9, long j, boolean z8, long j8, boolean z9) {
        if (z8 && z9) {
            long j9 = f558a;
            f558a = j8;
            if (j8 - j9 > 30000 && j > RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
                return j * 2;
            }
        }
        return (j * ((long) (i9 == 0 ? 13 : 11))) / 10;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m476a(Context context) {
        com.xiaomi.push.providers.a aVar = f560a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f560a = aVar2;
        return aVar2;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : f563a) {
            if (aVar2.a(aVar)) {
                aVar2.f566b += aVar.f566b;
                return;
            }
        }
        f563a.add(aVar);
    }
}

package cn.jpush.android.x;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f11779a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Queue<String> f11780b;

    private static JSONArray a(Context context) {
        JSONArray jSONArray;
        String str = (String) Sp.get(context, Key.NotiCancel());
        if (TextUtils.isEmpty(str)) {
            jSONArray = null;
        } else {
            try {
                Logger.d("NotificationRecords", "read=" + str);
                jSONArray = new JSONArray(str);
            } catch (Throwable th) {
                defpackage.f.o("read NotiCancel e:", "NotificationRecords", th);
                jSONArray = null;
            }
        }
        return jSONArray != null ? jSONArray : new JSONArray();
    }

    private static void b(Context context) {
        if (f11780b == null) {
            synchronized (d.class) {
                try {
                    if (f11780b == null) {
                        f11780b = new ConcurrentLinkedQueue();
                        String str = (String) Sp.get(context, Key.NotiShow());
                        if (!TextUtils.isEmpty(str)) {
                            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                                if (!TextUtils.isEmpty(str2)) {
                                    f11780b.offer(str2);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void b(Context context, String str) {
        try {
            b(context);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f11779a) {
                try {
                    if (f11780b.size() >= 70) {
                        f11780b.poll();
                    }
                    f11780b.offer(str);
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = f11780b.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next() + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    Sp.set(context, Key.NotiShow().set(sb.toString()));
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
            Logger.e("NotificationRecords", "saveNotiHistory failed,messageId = " + str);
        }
    }

    public static void a(Context context, List<String> list, int i9) {
        try {
            JSONArray jSONArrayA = a(context);
            JSONArray jSONArray = new JSONArray();
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (int i10 = 0; i10 < jSONArrayA.length(); i10++) {
                JSONObject jSONObject = jSONArrayA.getJSONObject(i10);
                String string = jSONObject.getString("id");
                if (list != null && list.remove(string)) {
                    jSONObject.put(CrashHianalyticsData.TIME, jCurrentTimeMillis);
                }
                if (jCurrentTimeMillis < jSONObject.getLong(CrashHianalyticsData.TIME) + 86400000) {
                    jSONArray.put(jSONObject);
                }
            }
            if (list != null) {
                for (String str : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(CrashHianalyticsData.TIME, jCurrentTimeMillis);
                    jSONObject2.put("id", str);
                    jSONObject2.put("type", i9);
                    jSONArray.put(jSONObject2);
                }
            }
            String string2 = jSONArray.length() > 0 ? jSONArray.toString() : null;
            Logger.d("NotificationRecords", "saveString=" + string2);
            Sp.set(context, Key.NotiCancel().set(string2));
        } catch (Throwable th) {
            defpackage.f.o("save NotiCancel e:", "NotificationRecords", th);
        }
    }

    public static boolean a(Context context, String str) {
        b(context);
        return f11780b.contains(str);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0083  */
    public static boolean a(Context context, String str, String str2, int i9) {
        try {
            JSONArray jSONArrayA = a(context);
            if (jSONArrayA != null && jSONArrayA.length() != 0) {
                JSONArray jSONArray = new JSONArray();
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z8 = false;
                for (int i10 = 0; i10 < jSONArrayA.length(); i10++) {
                    JSONObject jSONObject = jSONArrayA.getJSONObject(i10);
                    long j = jSONObject.getLong(CrashHianalyticsData.TIME);
                    int iOptInt = jSONObject.optInt("type", -1);
                    if (jCurrentTimeMillis < j + 86400000) {
                        jSONArray.put(jSONObject);
                        if (!z8) {
                            String string = jSONObject.getString("id");
                            if (!TextUtils.isEmpty(str) && str.equals(string) && (iOptInt == -1 || i9 == iOptInt)) {
                                cn.jpush.android.helper.d.a(str, 1032L, context);
                            } else if (!TextUtils.isEmpty(str2)) {
                                if (str2.equals(string) && (iOptInt == -1 || i9 == iOptInt)) {
                                    cn.jpush.android.helper.d.a(str, 1033L, context);
                                }
                            }
                            z8 = true;
                        }
                    }
                }
                if (jSONArray.length() != jSONArrayA.length()) {
                    String string2 = jSONArray.length() > 0 ? jSONArray.toString() : null;
                    Logger.d("NotificationRecords", "saveString when check=" + string2);
                    Sp.set(context, Key.NotiCancel().set(string2));
                }
                return z8;
            }
            return false;
        } catch (Throwable th) {
            defpackage.f.o("isAlreadyCancel e:", "NotificationRecords", th);
            return false;
        }
    }
}

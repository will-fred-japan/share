package p087l6;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.NotificationMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import p096m7.k;
import p096m7.l;

/* JADX INFO: compiled from: JPushHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f20092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f20094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f20095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f20096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f20097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap f20098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<Context> f20099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f20100i;

    /* JADX INFO: compiled from: JPushHelper.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f20102b;

        public a(String str, HashMap map) {
            this.f20101a = str;
            this.f20102b = map;
        }
    }

    /* JADX INFO: compiled from: JPushHelper.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f20103a;

        static {
            d dVar = new d();
            dVar.f20092a = new ArrayList();
            dVar.f20093b = false;
            dVar.f20095d = new ArrayList();
            dVar.f20098g = new HashMap();
            f20103a = dVar;
        }
    }

    public static HashMap c(NotificationMessage notificationMessage) {
        HashMap map = new HashMap();
        try {
            map.put(JPushInterface.EXTRA_MSG_ID, notificationMessage.msgId);
            map.put(JPushInterface.EXTRA_NOTIFICATION_ID, Integer.valueOf(notificationMessage.notificationId));
            map.put(JPushInterface.EXTRA_ALERT_TYPE, notificationMessage.notificationAlertType + "");
            map.put(JPushInterface.EXTRA_EXTRA, g(notificationMessage.notificationExtras));
            if (notificationMessage.notificationStyle == 1 && !TextUtils.isEmpty(notificationMessage.notificationBigText)) {
                map.put(JPushInterface.EXTRA_BIG_TEXT, notificationMessage.notificationBigText);
            } else if (notificationMessage.notificationStyle == 2 && !TextUtils.isEmpty(notificationMessage.notificationInbox)) {
                map.put(JPushInterface.EXTRA_INBOX, notificationMessage.notificationInbox);
            } else if (notificationMessage.notificationStyle == 3 && !TextUtils.isEmpty(notificationMessage.notificationBigPicPath)) {
                map.put(JPushInterface.EXTRA_BIG_PIC_PATH, notificationMessage.notificationBigPicPath);
            }
            if (notificationMessage.notificationPriority != 0) {
                map.put(JPushInterface.EXTRA_NOTI_PRIORITY, notificationMessage.notificationPriority + "");
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationCategory)) {
                map.put(JPushInterface.EXTRA_NOTI_CATEGORY, notificationMessage.notificationCategory);
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationSmallIcon)) {
                map.put(JPushInterface.EXTRA_NOTIFICATION_SMALL_ICON, notificationMessage.notificationSmallIcon);
            }
            if (!TextUtils.isEmpty(notificationMessage.notificationLargeIcon)) {
                map.put(JPushInterface.EXTRA_NOTIFICATION_LARGET_ICON, notificationMessage.notificationLargeIcon);
                return map;
            }
        } catch (Throwable th) {
            Log.e("| JPUSH | Flutter | Android | ", "[onNotifyMessageUnShow] e:" + th.getMessage());
        }
        return map;
    }

    public static HashMap g(String str) {
        HashMap map = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        String next = itKeys.next();
                        Object obj = jSONObject.get(next);
                        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof String)) {
                            map.put(next, obj);
                        } else {
                            map.put(next, String.valueOf(obj));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return map;
    }

    public final void a(int i9, k kVar) {
        this.f20098g.put(Integer.valueOf(i9), kVar);
    }

    public final void b(String str) {
        if (str == null || str.isEmpty()) {
            WeakReference<Context> weakReference = this.f20099h;
            if (weakReference == null || weakReference.get() == null) {
                return;
            } else {
                str = JPushInterface.getRegistrationID(this.f20099h.get());
            }
        }
        ArrayList arrayList = new ArrayList();
        if (str == null || str.isEmpty() || !this.f20093b) {
            return;
        }
        arrayList.clear();
        ArrayList<l.d> arrayList2 = this.f20095d;
        for (l.d dVar : arrayList2) {
            Log.d("| JPUSH | Flutter | Android | ", "scheduleCache rid = ".concat(str));
            dVar.success(str);
            arrayList.add(dVar);
        }
        arrayList2.removeAll(arrayList);
        arrayList.clear();
    }

    public final Handler d() {
        if (this.f20094c == null) {
            this.f20094c = new Handler(Looper.getMainLooper());
        }
        return this.f20094c;
    }

    public final void e(String str, HashMap map) {
        boolean z8 = this.f20093b;
        ArrayList<a> arrayList = this.f20092a;
        if (!z8) {
            Log.d("| JPUSH | Flutter | Android | ", "dartIsReady false: " + str);
            if (str != null) {
                arrayList.add(new a(str, map));
                return;
            } else {
                Log.d("| JPUSH | Flutter | Android | ", "skip cache because method is null");
                return;
            }
        }
        if (this.f20096e == null) {
            Log.d("| JPUSH | Flutter | Android | ", "channel is null, cannot invoke " + str);
            if (str != null) {
                arrayList.add(new a(str, map));
                return;
            } else {
                Log.d("| JPUSH | Flutter | Android | ", "skip cache because method is null");
                return;
            }
        }
        if (!arrayList.isEmpty()) {
            for (a aVar : arrayList) {
                String str2 = aVar.f20101a;
                HashMap map2 = aVar.f20102b;
                if (str2 == null) {
                    Log.w("| JPUSH | Flutter | Android | ", "skip invoking cached message because method is null, data=" + map2);
                } else {
                    StringBuilder sb = new StringBuilder("method:");
                    String str3 = aVar.f20101a;
                    sb.append(str3);
                    sb.append(",data:");
                    sb.append(map2);
                    Log.d("| JPUSH | Flutter | Android | ", sb.toString());
                    this.f20096e.a(str3, map2, null);
                }
            }
            arrayList.clear();
        }
        if (str == null) {
            Log.d("| JPUSH | Flutter | Android | ", "skip current invoke because method is null");
            return;
        }
        Log.d("| JPUSH | Flutter | Android | ", "method:" + str + ",msg:" + map);
        this.f20096e.a(str, map, null);
    }

    public final void f(HashMap map, k kVar, String str) {
        Log.d("| JPUSH | Flutter | Android | ", "runMainThread:map = " + map + ",method =" + str);
        d().post(new c(this, kVar, str, map));
    }
}

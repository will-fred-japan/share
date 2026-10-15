package com.heytap.mcssdk.c;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.C0524s;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.c;
import com.heytap.mcssdk.constant.d;
import com.heytap.mcssdk.utils.e;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.constant.ConfigConstant;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.NotificationSortMessage;
import com.heytap.msp.push.notification.ISortListener;
import com.heytap.msp.push.notification.PushNotification;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14234d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private StatusBarNotification f14238h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14231a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<NotificationSortMessage> f14232b = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f14235e = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f14239a = new b();

        private a() {
        }
    }

    private int a(List<NotificationSortMessage> list, int i9) {
        int size = list == null ? 0 : list.size();
        if (i9 <= 0 || size == 0) {
            return i9;
        }
        if (size < i9) {
            int i10 = i9 - size;
            list.clear();
            return i10;
        }
        for (int i11 = 0; i11 < i9; i11++) {
            list.remove((size - 1) - i11);
        }
        return 0;
    }

    private void b() {
        this.f14236f = 0;
        this.f14237g = 0;
        this.f14233c = 0;
        this.f14234d = 0;
        this.f14232b.clear();
        this.f14235e.clear();
        this.f14238h = null;
    }

    public static b a() {
        return a.f14239a;
    }

    private void b(int i9) {
        if (i9 == -1) {
            this.f14237g++;
        } else if (i9 == 1) {
            this.f14236f++;
        }
    }

    private DataMessage a(Context context, NotificationSortMessage notificationSortMessage) {
        DataMessage dataMessage = new DataMessage(context.getPackageName(), notificationSortMessage.getMessageId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.b.f14315a, "false");
            String statisticData = notificationSortMessage.getStatisticData();
            if (!TextUtils.isEmpty(statisticData)) {
                jSONObject.put(d.b.f14316b, statisticData);
            }
            dataMessage.setStatisticsExtra(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return dataMessage;
    }

    private void a(int i9) {
        if (i9 == 7) {
            this.f14233c++;
        } else if (i9 == 5) {
            this.f14234d++;
        }
    }

    private void a(NotificationManager notificationManager, Context context, int i9) {
        a(com.heytap.mcssdk.c.a.a(notificationManager, context.getPackageName()), i9);
    }

    private void a(Context context, NotificationManager notificationManager, int i9) {
        a(this.f14232b, i9);
        a(context, notificationManager, this.f14232b);
    }

    private void a(Context context, NotificationManager notificationManager, List<NotificationSortMessage> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        a(context, notificationManager, jSONArray, list, arrayList);
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(d.b.f14317c, jSONArray);
                HeytapPushManager.cancelNotification(jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (arrayList.size() != 0) {
            HashMap map = new HashMap();
            map.put(c.a.f14311d, arrayList);
            StatisticUtils.statisticEvent(context, map);
        }
    }

    private void a(Context context, NotificationManager notificationManager, JSONArray jSONArray, List<NotificationSortMessage> list, List<DataMessage> list2) {
        for (NotificationSortMessage notificationSortMessage : list) {
            if (notificationSortMessage.isMcs()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_NOTIFY_ID, notificationSortMessage.getNotifyId());
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            } else {
                list2.add(a(context, notificationSortMessage));
                this.f14235e.add(notificationSortMessage.getMessageId());
            }
            notificationManager.cancel(notificationSortMessage.getNotifyId());
        }
    }

    private void a(NotificationSortMessage notificationSortMessage) {
        if (notificationSortMessage.getAutoDelete() != 1) {
            return;
        }
        if (this.f14232b.size() != 0) {
            for (int size = this.f14232b.size() - 1; size >= 0; size--) {
                NotificationSortMessage notificationSortMessage2 = this.f14232b.get(size);
                if (notificationSortMessage.getImportantLevel() >= notificationSortMessage2.getImportantLevel() && notificationSortMessage.getPostTime() >= notificationSortMessage2.getPostTime()) {
                    this.f14232b.add(size + 1, notificationSortMessage2);
                    return;
                }
            }
        }
        this.f14232b.add(0, notificationSortMessage);
    }

    private void a(ISortListener iSortListener, boolean z8, PushNotification.Builder builder) {
        if (iSortListener != null) {
            iSortListener.buildCompleted(z8, builder, this.f14235e);
        }
    }

    private void a(PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, notificationSortMessage.getAutoDelete());
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, notificationSortMessage.getImportantLevel());
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
        bundle.putLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, System.currentTimeMillis());
        bundle.putBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, false);
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA, notificationSortMessage.getStatisticData());
        builder.addExtras(bundle);
        builder.setGroup(notificationSortMessage.getGroup());
    }

    public void a(PushNotification.Builder builder, ISortListener iSortListener) {
        if (builder == null) {
            return;
        }
        a(iSortListener, a(builder, builder.getAutoDelete(), builder.getImportantLevel(), builder.getMessageId(), builder.getStatisticData()), builder);
    }

    private void a(StatusBarNotification[] statusBarNotificationArr, int i9) {
        b();
        if (statusBarNotificationArr != null && statusBarNotificationArr.length != 0) {
            for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
                Bundle bundle = statusBarNotification.getNotification().extras;
                boolean z8 = bundle.getBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, true);
                long j = bundle.getLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, statusBarNotification.getPostTime());
                String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
                int i10 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, 1);
                int i11 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, 5);
                String string2 = bundle.getString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA);
                int id = statusBarNotification.getId();
                if (i9 == id) {
                    this.f14238h = statusBarNotification;
                    return;
                }
                NotificationSortMessage notificationSortMessage = new NotificationSortMessage(string, i11, i10, z8, j, id, string2);
                b(i10);
                a(i11);
                a(notificationSortMessage);
            }
        }
        if (e.g()) {
            e.b("initParams : notDelete:" + this.f14237g + " canDelete : " + this.f14236f + "\n highSize : " + this.f14233c + " normalSize :" + this.f14234d + '\n');
            StringBuilder sb = new StringBuilder("canDeleteList size : ");
            sb.append(this.f14232b.size());
            e.b(sb.toString());
            for (int i12 = 0; i12 < this.f14232b.size(); i12++) {
                NotificationSortMessage notificationSortMessage2 = this.f14232b.get(i12);
                StringBuilder sbA = C0524s.a(i12, "第", "条消息 messageId : ");
                sbA.append(notificationSortMessage2.getMessageId());
                sbA.append(" importanceLevel : ");
                sbA.append(notificationSortMessage2.getImportantLevel());
                sbA.append(" autoDelete : ");
                sbA.append(notificationSortMessage2.getAutoDelete());
                sbA.append(" notifyId: ");
                sbA.append(notificationSortMessage2.getNotifyId());
                sbA.append(" postTime:");
                sbA.append(notificationSortMessage2.getPostTime());
                e.b(sbA.toString());
            }
        }
    }

    private boolean a(NotificationManager notificationManager, Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        if (e.g()) {
            e.b("dealCurrentMessage : deleteNumber" + (this.f14236f + this.f14237g) + " keepNumber : " + this.f14231a);
        }
        boolean zA = true;
        if (this.f14236f + this.f14237g < this.f14231a) {
            StringBuilder sb = notificationSortMessage.getAutoDelete() == -1 ? new StringBuilder(d.a.f14313b) : new StringBuilder(d.a.f14314c);
            sb.append(context.getPackageName());
            notificationSortMessage.setGroup(sb.toString());
        } else if (notificationSortMessage.getAutoDelete() == -1) {
            notificationSortMessage.setGroup(d.a.f14313b + context.getPackageName());
            int i9 = this.f14231a - this.f14237g;
            if (e.g()) {
                e.b("dealCurrentMessage : allowDelete :" + i9);
            }
            if (i9 > 0) {
                a(context, notificationManager, i9 - 1);
            } else {
                Notification notificationA = com.heytap.mcssdk.c.a.a(context, notificationSortMessage.getGroup(), builder);
                if (notificationA != null) {
                    notificationManager.notify(4096, notificationA);
                }
            }
        } else {
            zA = a(context, notificationManager, notificationSortMessage);
        }
        if (e.g()) {
            e.b("dealCurrentMessage : needPost :" + zA);
        }
        if (zA) {
            a(builder, notificationSortMessage);
            return zA;
        }
        com.heytap.mcssdk.f.a.a(context, c.a.f14310c, a(context, notificationSortMessage));
        return zA;
    }

    private boolean a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage) {
        int i9 = this.f14237g;
        int i10 = this.f14231a;
        boolean z8 = false;
        if (i9 >= i10) {
            return false;
        }
        int i11 = i10 - i9;
        if (e.g()) {
            e.b("judgeShowCurrentMessage : allowDelete" + i11);
        }
        if (notificationSortMessage.getImportantLevel() == 7 || (notificationSortMessage.getImportantLevel() != 5 ? this.f14233c + this.f14234d < i11 : this.f14233c < i11)) {
            z8 = true;
        }
        if (z8) {
            a(context, notificationManager, i11 - 1);
        }
        return z8;
    }

    public boolean a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage, PushNotification.Builder builder) {
        if (notificationSortMessage.getAutoDelete() == 0 || Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        if (!com.heytap.mcssdk.c.a.a(notificationManager, context.getPackageName(), 4096)) {
            return true;
        }
        notificationSortMessage.setGroup(d.a.f14313b + context.getPackageName());
        a(builder, notificationSortMessage);
        return false;
    }

    private boolean a(Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Notification notification;
        int verifyNotifyId = builder.getVerifyNotifyId();
        StatusBarNotification statusBarNotification = this.f14238h;
        if (statusBarNotification == null || verifyNotifyId == -1 || (notification = statusBarNotification.getNotification()) == null) {
            return false;
        }
        StringBuilder sb = notificationSortMessage.getAutoDelete() == 1 ? new StringBuilder(d.a.f14314c) : new StringBuilder(d.a.f14313b);
        sb.append(context.getPackageName());
        notificationSortMessage.setGroup(sb.toString());
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
        a(builder, notificationSortMessage);
        this.f14235e.add(string);
        return true;
    }

    private boolean a(PushNotification.Builder builder, int i9, int i10, String str, String str2) {
        Context context = PushService.getInstance().getContext();
        if (builder == null || context == null) {
            return false;
        }
        NotificationManager notificationManagerA = com.heytap.mcssdk.c.a.a(context);
        NotificationSortMessage notificationSortMessage = new NotificationSortMessage(str, i10, i9, false, System.currentTimeMillis(), str2);
        if (!a(context, notificationManagerA, notificationSortMessage, builder)) {
            return true;
        }
        a(notificationManagerA, context, builder.getVerifyNotifyId());
        if (a(context, builder, notificationSortMessage)) {
            return true;
        }
        return a(notificationManagerA, context, builder, notificationSortMessage);
    }
}

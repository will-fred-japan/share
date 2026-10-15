package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f15383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f15384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long[] f15385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Object> f15386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashMap<String, Object> f15387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final HashMap<String, Object> f15388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap<String, Object> f15389i;
    private static final HashMap<String, Object> j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f15390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Notification f15391b;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bundle f15392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, String> f15393b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f15392a = bundle;
            this.f15393b = new HashMap();
            bundle.putString(RemoteMessageConst.TO, str);
        }

        public Builder addData(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("add data failed, key is null.");
            }
            this.f15393b.put(str, str2);
            return this;
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f15393b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String string = jSONObject.toString();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(RemoteMessageConst.COLLAPSE_KEY, this.f15392a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject2.put(RemoteMessageConst.TTL, this.f15392a.getInt(RemoteMessageConst.TTL));
                    jSONObject2.put(RemoteMessageConst.SEND_MODE, this.f15392a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject2.put(RemoteMessageConst.RECEIPT_MODE, this.f15392a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject3.put("data", string);
                    }
                    jSONObject3.put(RemoteMessageConst.MSGID, this.f15392a.getString(RemoteMessageConst.MSGID));
                    jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject3);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject2.toString().getBytes(m.f15432a));
                    bundle.putString(RemoteMessageConst.TO, this.f15392a.getString(RemoteMessageConst.TO));
                    bundle.putString("message_type", this.f15392a.getString("message_type"));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f15393b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f15392a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f15393b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f15393b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f15392a.putString(RemoteMessageConst.MSGID, str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f15392a.putString("message_type", str);
            return this;
        }

        public Builder setReceiptMode(int i9) {
            if (i9 != 1 && i9 != 0) {
                throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.f15392a.putInt(RemoteMessageConst.RECEIPT_MODE, i9);
            return this;
        }

        public Builder setSendMode(int i9) {
            if (i9 != 0 && i9 != 1) {
                throw new IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.f15392a.putInt(RemoteMessageConst.SEND_MODE, i9);
            return this;
        }

        public Builder setTtl(int i9) {
            if (i9 < 1 || i9 > 1296000) {
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.f15392a.putInt(RemoteMessageConst.TTL, i9);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements Serializable {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        private final long[] f15394A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        private final String f15395B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String[] f15398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15400e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String[] f15401f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f15402g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f15403h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f15404i;
        private final String j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f15405k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final String f15406l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final String f15407m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final Uri f15408n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final int f15409o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final String f15410p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final int f15411q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final int f15412r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final int f15413s;
        private final int[] t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final String f15414u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final int f15415v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final String f15416w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f15417x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final String f15418y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final String f15419z;

        public /* synthetic */ Notification(Bundle bundle, a aVar) {
            this(bundle);
        }

        private Integer a(String str) {
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                return null;
            }
        }

        public Integer getBadgeNumber() {
            return a(this.f15416w);
        }

        public String getBody() {
            return this.f15399d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f15401f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f15400e;
        }

        public String getChannelId() {
            return this.f15407m;
        }

        public String getClickAction() {
            return this.f15405k;
        }

        public String getColor() {
            return this.j;
        }

        public String getIcon() {
            return this.f15402g;
        }

        public Uri getImageUrl() {
            String str = this.f15410p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return a(this.f15418y);
        }

        public String getIntentUri() {
            return this.f15406l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f15408n;
        }

        public int getNotifyId() {
            return this.f15409o;
        }

        public String getSound() {
            return this.f15403h;
        }

        public String getTag() {
            return this.f15404i;
        }

        public String getTicker() {
            return this.f15419z;
        }

        public String getTitle() {
            return this.f15396a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f15398c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f15397b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.f15394A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.f15395B);
        }

        public Long getWhen() {
            if (TextUtils.isEmpty(this.f15414u)) {
                return null;
            }
            try {
                return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f15414u));
            } catch (StringIndexOutOfBoundsException unused) {
                HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                return null;
            } catch (ParseException unused2) {
                HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                return null;
            }
        }

        public boolean isAutoCancel() {
            return this.f15417x == 1;
        }

        public boolean isDefaultLight() {
            return this.f15411q == 1;
        }

        public boolean isDefaultSound() {
            return this.f15412r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f15413s == 1;
        }

        public boolean isLocalOnly() {
            return this.f15415v == 1;
        }

        private Notification(Bundle bundle) {
            this.f15396a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f15399d = bundle.getString("content");
            this.f15397b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f15400e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f15398c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f15401f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f15402g = bundle.getString(RemoteMessageConst.Notification.ICON);
            this.j = bundle.getString(RemoteMessageConst.Notification.COLOR);
            this.f15403h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f15404i = bundle.getString("tag");
            this.f15407m = bundle.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f15405k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f15406l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f15409o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString(RemoteMessageConst.Notification.URL);
            this.f15408n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f15410p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f15411q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f15412r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f15413s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f15414u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f15415v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f15416w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.f15417x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f15418y = bundle.getString(RemoteMessageConst.Notification.PRIORITY, null);
            this.f15419z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.f15394A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.f15395B = bundle.getString(RemoteMessageConst.Notification.VISIBILITY, null);
        }
    }

    public class a implements Parcelable.Creator<RemoteMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage[] newArray(int i9) {
            return new RemoteMessage[i9];
        }
    }

    static {
        String[] strArr = new String[0];
        f15383c = strArr;
        int[] iArr = new int[0];
        f15384d = iArr;
        long[] jArr = new long[0];
        f15385e = jArr;
        HashMap<String, Object> map = new HashMap<>(8);
        f15386f = map;
        map.put("from", "");
        map.put(RemoteMessageConst.COLLAPSE_KEY, "");
        map.put(RemoteMessageConst.SEND_TIME, "");
        map.put(RemoteMessageConst.TTL, Integer.valueOf(RemoteMessageConst.DEFAULT_TTL));
        map.put(RemoteMessageConst.URGENCY, 2);
        map.put(RemoteMessageConst.ORI_URGENCY, 2);
        map.put(RemoteMessageConst.SEND_MODE, 0);
        map.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> map2 = new HashMap<>(8);
        f15387g = map2;
        map2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        map2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        map2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        map2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        map2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        map2.put(RemoteMessageConst.Notification.TICKER, "");
        map2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        map2.put("content", "");
        HashMap<String, Object> map3 = new HashMap<>(8);
        f15388h = map3;
        map3.put(RemoteMessageConst.Notification.ICON, "");
        map3.put(RemoteMessageConst.Notification.COLOR, "");
        map3.put(RemoteMessageConst.Notification.SOUND, "");
        map3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        map3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        map3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        map3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        map3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> map4 = new HashMap<>(8);
        f15389i = map4;
        map4.put("tag", "");
        map4.put(RemoteMessageConst.Notification.WHEN, "");
        map4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        map4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        map4.put(RemoteMessageConst.Notification.PRIORITY, "");
        map4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        map4.put(RemoteMessageConst.Notification.VISIBILITY, "");
        map4.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        HashMap<String, Object> map5 = new HashMap<>(3);
        j = map5;
        map5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        map5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        map5.put(RemoteMessageConst.Notification.URL, "");
        CREATOR = new a();
    }

    public RemoteMessage(Bundle bundle) {
        this.f15390a = a(bundle);
    }

    private Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject jSONObjectB = b(bundle);
        JSONObject jSONObjectA = a(jSONObjectB);
        String string = JsonUtil.getString(jSONObjectA, "data", null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(jSONObjectA, RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject jSONObjectD = d(jSONObjectA);
        JSONObject jSONObjectB2 = b(jSONObjectD);
        JSONObject jSONObjectC = c(jSONObjectD);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && d.a(jSONObjectA, jSONObjectD, string)) {
            bundle2.putString("data", com.huawei.hms.push.a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        String string2 = bundle.getString(RemoteMessageConst.TO);
        String string3 = bundle.getString("message_type");
        String string4 = JsonUtil.getString(jSONObjectA, RemoteMessageConst.MSGID, null);
        bundle2.putString(RemoteMessageConst.TO, string2);
        bundle2.putString("data", string);
        bundle2.putString(RemoteMessageConst.MSGID, string4);
        bundle2.putString("message_type", string3);
        JsonUtil.transferJsonObjectToBundle(jSONObjectB, bundle2, f15386f);
        bundle2.putBundle(RemoteMessageConst.NOTIFICATION, a(jSONObjectB, jSONObjectA, jSONObjectD, jSONObjectB2, jSONObjectC));
        return bundle2;
    }

    private static JSONObject b(Bundle bundle) {
        try {
            return new JSONObject(com.huawei.hms.push.a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    private static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    private static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f15390a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap map = new HashMap();
        String string = this.f15390a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String strValueOf = String.valueOf(itKeys.next());
                    map.put(strValueOf, String.valueOf(jSONObject.get(strValueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return map;
    }

    public String getCollapseKey() {
        return this.f15390a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f15390a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap map = new HashMap();
        String string = this.f15390a.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String strValueOf = String.valueOf(itKeys.next());
                    map.put(strValueOf, String.valueOf(jSONObject.get(strValueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return map;
    }

    public String getFrom() {
        return this.f15390a.getString("from");
    }

    public String getMessageId() {
        return this.f15390a.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f15390a.getString("message_type");
    }

    public Notification getNotification() {
        Bundle bundle = this.f15390a.getBundle(RemoteMessageConst.NOTIFICATION);
        a aVar = null;
        if (this.f15391b == null && bundle != null) {
            this.f15391b = new Notification(bundle, aVar);
        }
        if (this.f15391b == null) {
            this.f15391b = new Notification(new Bundle(), aVar);
        }
        return this.f15391b;
    }

    public int getOriginalUrgency() {
        int i9 = this.f15390a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i9 == 1 || i9 == 2) {
            return i9;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f15390a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f15390a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f15390a.getString(RemoteMessageConst.SEND_TIME);
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public String getTo() {
        return this.f15390a.getString(RemoteMessageConst.TO);
    }

    public String getToken() {
        return this.f15390a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f15390a.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i9 = this.f15390a.getInt(RemoteMessageConst.URGENCY);
        if (i9 == 1 || i9 == 2) {
            return i9;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeBundle(this.f15390a);
        parcel.writeSerializable(this.f15391b);
    }

    public RemoteMessage(Parcel parcel) {
        this.f15390a = parcel.readBundle();
        this.f15391b = (Notification) parcel.readSerializable();
    }

    private static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    private Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f15387g);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f15388h);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f15389i);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, j);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}

package cn.jpush.android.data;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JPushLocalNotification implements Serializable {
    private static final long serialVersionUID = 1472982106750878137L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f11365i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11357a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11358b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11359c = "00";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11360d = "00";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f11361e = 0;
    private long j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11366k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f11367l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f11368m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f11369n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f11370o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f11371p = "";

    private void a(String str, String str2, JSONObject jSONObject) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.j == ((JPushLocalNotification) obj).j;
    }

    public long getBroadcastTime() {
        return this.f11361e;
    }

    public long getBuilderId() {
        return this.f11365i;
    }

    public String getCategory() {
        return this.f11370o;
    }

    public String getChannelId() {
        return this.f11371p;
    }

    public String getContent() {
        return this.f11362f;
    }

    public String getExtras() {
        return this.f11364h;
    }

    public long getNotificationId() {
        return this.j;
    }

    public int getPriority() {
        return this.f11369n;
    }

    public String getTitle() {
        return this.f11363g;
    }

    public int hashCode() {
        long j = this.j;
        return (int) (j ^ (j >>> 32));
    }

    public void setBroadcastTime(int i9, int i10, int i11, int i12, int i13, int i14) {
        if (i9 < 0 || i10 < 1 || i10 > 12 || i11 < 1 || i11 > 31 || i12 < 0 || i12 > 23 || i13 < 0 || i13 > 59 || i14 < 0 || i14 > 59) {
            Logger.ee("JPushLocalNotification", "Set time fail! Please check your args!");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i9, i10 - 1, i11, i12, i13, i14);
        Date time = calendar.getTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (time.getTime() < jCurrentTimeMillis) {
            this.f11361e = jCurrentTimeMillis;
        } else {
            this.f11361e = time.getTime();
        }
    }

    public void setBuilderId(long j) {
        this.f11365i = j;
    }

    public void setCategory(String str) {
        this.f11370o = str;
    }

    public void setChannelId(String str) {
        this.f11371p = str;
    }

    public void setContent(String str) {
        this.f11362f = str;
    }

    public void setExtras(String str) {
        this.f11364h = str;
    }

    public void setNotificationId(long j) {
        this.j = (int) j;
    }

    public void setPriority(int i9) {
        this.f11369n = i9;
    }

    public void setTitle(String str) {
        this.f11363g = str;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.f11364h)) {
                jSONObject2.put("n_extras", new JSONObject(this.f11364h));
            }
            jSONObject2.put("n_priority", this.f11369n);
            a("n_category", this.f11370o, jSONObject2);
            a("n_channel_id", this.f11371p, jSONObject2);
            a("n_content", this.f11362f, jSONObject2);
            a("n_title", this.f11363g, jSONObject2);
            a("n_content", this.f11362f, jSONObject2);
            jSONObject2.put("ad_t", 0);
            jSONObject.put("m_content", jSONObject2);
            a("msg_id", "" + this.j, jSONObject);
            a("content_type", this.f11368m, jSONObject);
            a("override_msg_id", this.f11367l, jSONObject);
            jSONObject.put("n_only", this.f11366k);
            jSONObject.put("n_builder_id", this.f11365i);
            jSONObject.put("show_type", 3);
            jSONObject.put("notificaion_type", 1);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public void setBroadcastTime(long j) {
        this.f11361e = j;
    }

    public void setBroadcastTime(Date date) {
        this.f11361e = date.getTime();
    }
}

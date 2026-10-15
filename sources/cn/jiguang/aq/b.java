package cn.jiguang.aq;

import android.content.Context;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9373d;

    public b(Context context, String str) {
        super(context, str);
        this.f9371b = "";
        this.f9372c = "";
        this.f9370a = !cn.jiguang.aa.b.f8825b.get() ? 1 : 0;
    }

    public void b(int i9) {
        this.f9373d = i9;
    }

    public void c(String str) {
        this.f9372c = str;
    }

    @Override // cn.jiguang.aq.k
    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_foreground", this.f9370a);
        jSONObject.put("tcp_id", this.f9371b);
        jSONObject.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, this.f9372c);
        jSONObject.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT, this.f9373d);
        return jSONObject;
    }

    public void b(String str) {
        this.f9371b = str;
    }
}

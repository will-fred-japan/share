package cn.jiguang.aq;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.starburst.sdk.core.device.bt.http.HttpRequestBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9382d;

    public j(Context context) {
        super(context, "NET_HTTP");
    }

    public void a(HttpRequest httpRequest, boolean z8) {
        int length;
        this.f9379a = z8 ? HttpRequestBean.METHOD_POST : HttpRequestBean.METHOD_GET;
        if (!z8) {
            String[] strArrSplit = httpRequest.getUrl().split(" \\?");
            this.f9380b = strArrSplit[0];
            if (strArrSplit.length > 1) {
                length = strArrSplit[1].getBytes().length;
            }
            e();
        }
        this.f9380b = httpRequest.getUrl();
        length = httpRequest.getParas().length;
        this.f9381c = length;
        e();
    }

    @Override // cn.jiguang.aq.k
    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("method", this.f9379a);
        jSONObject.put(RemoteMessageConst.Notification.URL, this.f9380b);
        jSONObject.put("request_byte", this.f9381c);
        jSONObject.put("response_byte", this.f9382d);
        return jSONObject;
    }

    public void a(HttpResponse httpResponse) {
        f();
        d(httpResponse.getStatusCode());
        if (httpResponse.getStatusCode() == -1) {
            c(httpResponse.getResponseCode());
        }
        if (TextUtils.isEmpty(httpResponse.getResponseBody())) {
            return;
        }
        this.f9382d = httpResponse.getResponseBody().getBytes().length;
    }
}

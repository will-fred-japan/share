package com.starburst.sdk.common.okhttp.request;

import com.starburst.sdk.common.okhttp.callback.Callback;
import com.starburst.sdk.common.okhttp.utils.Exceptions;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public abstract class OkHttpRequest {
    protected Request.Builder builder = new Request.Builder();
    protected Map<String, String> headers;
    protected int id;
    protected Map<String, String> params;
    protected Object tag;
    protected String url;

    public OkHttpRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2, int i9) {
        this.url = str;
        this.tag = obj;
        this.params = map;
        this.headers = map2;
        this.id = i9;
        if (str == null) {
            Exceptions.illegalArgument("url can not be null.", new Object[0]);
        }
        initBuilder();
    }

    private void initBuilder() {
        this.builder.url(this.url).tag(this.tag);
        appendHeaders();
    }

    public void appendHeaders() {
        Headers.Builder builder = new Headers.Builder();
        Map<String, String> map = this.headers;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (String str : this.headers.keySet()) {
            builder.add(str, this.headers.get(str));
        }
        this.builder.headers(builder.build());
    }

    public RequestCall build() {
        return new RequestCall(this);
    }

    public abstract Request buildRequest(RequestBody requestBody);

    public abstract RequestBody buildRequestBody();

    public Request generateRequest(Callback callback) {
        return buildRequest(wrapRequestBody(buildRequestBody(), callback));
    }

    public int getId() {
        return this.id;
    }

    public RequestBody wrapRequestBody(RequestBody requestBody, Callback callback) {
        return requestBody;
    }
}

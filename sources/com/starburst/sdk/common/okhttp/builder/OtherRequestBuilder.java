package com.starburst.sdk.common.okhttp.builder;

import com.starburst.sdk.common.okhttp.request.OtherRequest;
import com.starburst.sdk.common.okhttp.request.RequestCall;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public class OtherRequestBuilder extends OkHttpRequestBuilder<OtherRequestBuilder> {
    private String content;
    private String method;
    private RequestBody requestBody;

    public OtherRequestBuilder(String str) {
        this.method = str;
    }

    @Override // com.starburst.sdk.common.okhttp.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new OtherRequest(this.requestBody, this.content, this.method, this.url, this.tag, this.params, this.headers, this.id).build();
    }

    public OtherRequestBuilder requestBody(String str) {
        this.content = str;
        return this;
    }

    public OtherRequestBuilder requestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }
}

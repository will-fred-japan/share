package com.starburst.sdk.common.okhttp.request;

import java.util.Map;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public class GetRequest extends OkHttpRequest {
    public GetRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2, int i9) {
        super(str, obj, map, map2, i9);
    }

    @Override // com.starburst.sdk.common.okhttp.request.OkHttpRequest
    public Request buildRequest(RequestBody requestBody) {
        return this.builder.get().build();
    }

    @Override // com.starburst.sdk.common.okhttp.request.OkHttpRequest
    public RequestBody buildRequestBody() {
        return null;
    }
}

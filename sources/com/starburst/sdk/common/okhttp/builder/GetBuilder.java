package com.starburst.sdk.common.okhttp.builder;

import android.net.Uri;
import com.starburst.sdk.common.okhttp.request.GetRequest;
import com.starburst.sdk.common.okhttp.request.RequestCall;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GetBuilder extends OkHttpRequestBuilder<GetBuilder> implements HasParamsable {
    @Override // com.starburst.sdk.common.okhttp.builder.HasParamsable
    public GetBuilder addParams(String str, String str2) {
        if (this.params == null) {
            this.params = new LinkedHashMap();
        }
        this.params.put(str, str2);
        return this;
    }

    public String appendParams(String str, Map<String, String> map) {
        if (str == null || map == null || map.isEmpty()) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (String str2 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str2, map.get(str2));
        }
        return builderBuildUpon.build().toString();
    }

    @Override // com.starburst.sdk.common.okhttp.builder.OkHttpRequestBuilder
    public RequestCall build() {
        Map<String, String> map = this.params;
        if (map != null) {
            this.url = appendParams(this.url, map);
        }
        return new GetRequest(this.url, this.tag, this.params, this.headers, this.id).build();
    }

    @Override // com.starburst.sdk.common.okhttp.builder.HasParamsable
    public GetBuilder params(Map<String, String> map) {
        this.params = map;
        return this;
    }

    @Override // com.starburst.sdk.common.okhttp.builder.HasParamsable
    public /* bridge */ /* synthetic */ OkHttpRequestBuilder params(Map map) {
        return params((Map<String, String>) map);
    }
}

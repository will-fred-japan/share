package com.starburst.sdk.common.okhttp.builder;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface HasParamsable {
    OkHttpRequestBuilder addParams(String str, String str2);

    OkHttpRequestBuilder params(Map<String, String> map);
}

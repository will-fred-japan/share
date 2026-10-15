package com.starburst.sdk.common.okhttp.builder;

import com.starburst.sdk.common.okhttp.request.OtherRequest;
import com.starburst.sdk.common.okhttp.request.RequestCall;

/* JADX INFO: loaded from: classes.dex */
public class HeadBuilder extends GetBuilder {
    @Override // com.starburst.sdk.common.okhttp.builder.GetBuilder, com.starburst.sdk.common.okhttp.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new OtherRequest(null, null, "HEAD", this.url, this.tag, this.params, this.headers, this.id).build();
    }
}

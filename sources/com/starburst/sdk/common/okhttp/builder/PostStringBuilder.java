package com.starburst.sdk.common.okhttp.builder;

import com.starburst.sdk.common.okhttp.request.PostStringRequest;
import com.starburst.sdk.common.okhttp.request.RequestCall;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder> {
    private String content;
    private MediaType mediaType;

    @Override // com.starburst.sdk.common.okhttp.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new PostStringRequest(this.url, this.tag, this.params, this.headers, this.content, this.mediaType, this.id).build();
    }

    public PostStringBuilder content(String str) {
        this.content = str;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }
}

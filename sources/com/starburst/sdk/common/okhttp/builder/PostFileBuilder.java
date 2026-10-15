package com.starburst.sdk.common.okhttp.builder;

import com.starburst.sdk.common.okhttp.request.PostFileRequest;
import com.starburst.sdk.common.okhttp.request.RequestCall;
import java.io.File;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes.dex */
public class PostFileBuilder extends OkHttpRequestBuilder<PostFileBuilder> {
    private File file;
    private MediaType mediaType;

    @Override // com.starburst.sdk.common.okhttp.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new PostFileRequest(this.url, this.tag, this.params, this.headers, this.file, this.mediaType, this.id).build();
    }

    public PostFileBuilder file(File file) {
        this.file = file;
        return this;
    }

    public PostFileBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }
}

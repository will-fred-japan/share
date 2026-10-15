package com.starburst.sdk.common.okhttp.request;

import com.starburst.sdk.common.okhttp.OkHttpUtils;
import com.starburst.sdk.common.okhttp.callback.Callback;
import com.starburst.sdk.common.okhttp.utils.Exceptions;
import java.io.File;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public class PostFileRequest extends OkHttpRequest {
    private static MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    private File file;
    private MediaType mediaType;

    public PostFileRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2, File file, MediaType mediaType, int i9) {
        super(str, obj, map, map2, i9);
        this.file = file;
        this.mediaType = mediaType;
        if (file == null) {
            Exceptions.illegalArgument("the file can not be null !", new Object[0]);
        }
        if (this.mediaType == null) {
            this.mediaType = MEDIA_TYPE_STREAM;
        }
    }

    @Override // com.starburst.sdk.common.okhttp.request.OkHttpRequest
    public Request buildRequest(RequestBody requestBody) {
        return this.builder.post(requestBody).build();
    }

    @Override // com.starburst.sdk.common.okhttp.request.OkHttpRequest
    public RequestBody buildRequestBody() {
        return RequestBody.create(this.mediaType, this.file);
    }

    @Override // com.starburst.sdk.common.okhttp.request.OkHttpRequest
    public RequestBody wrapRequestBody(RequestBody requestBody, final Callback callback) {
        return callback == null ? requestBody : new CountingRequestBody(requestBody, new CountingRequestBody.Listener() { // from class: com.starburst.sdk.common.okhttp.request.PostFileRequest.1
            @Override // com.starburst.sdk.common.okhttp.request.CountingRequestBody.Listener
            public void onRequestProgress(final long j, final long j8) {
                OkHttpUtils.getInstance().getDelivery().execute(new Runnable() { // from class: com.starburst.sdk.common.okhttp.request.PostFileRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Callback callback2 = callback;
                        float f6 = j * 1.0f;
                        long j9 = j8;
                        callback2.inProgress(f6 / j9, j9, PostFileRequest.this.id);
                    }
                });
            }
        });
    }
}

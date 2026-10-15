package com.starburst.sdk.common.okhttp.request;

import A.a;
import com.starburst.sdk.common.okhttp.OkHttpUtils;
import com.starburst.sdk.common.okhttp.builder.PostFormBuilder;
import com.starburst.sdk.common.okhttp.callback.Callback;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public class PostFormRequest extends OkHttpRequest {
    private List<PostFormBuilder.FileInput> files;

    public PostFormRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2, List<PostFormBuilder.FileInput> list, int i9) {
        super(str, obj, map, map2, i9);
        this.files = list;
    }

    private void addParams(FormBody.Builder builder) {
        Map<String, String> map = this.params;
        if (map != null) {
            for (String str : map.keySet()) {
                builder.add(str, this.params.get(str));
            }
        }
    }

    private String guessMimeType(String str) {
        String contentTypeFor;
        try {
            contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e9) {
            e9.printStackTrace();
            contentTypeFor = null;
        }
        return contentTypeFor == null ? "application/octet-stream" : contentTypeFor;
    }

    @Override // com.starburst.sdk.common.okhttp.request.OkHttpRequest
    public Request buildRequest(RequestBody requestBody) {
        return this.builder.post(requestBody).build();
    }

    @Override // com.starburst.sdk.common.okhttp.request.OkHttpRequest
    public RequestBody buildRequestBody() {
        List<PostFormBuilder.FileInput> list = this.files;
        if (list == null || list.isEmpty()) {
            FormBody.Builder builder = new FormBody.Builder();
            addParams(builder);
            return builder.build();
        }
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        addParams(type);
        for (int i9 = 0; i9 < this.files.size(); i9++) {
            PostFormBuilder.FileInput fileInput = this.files.get(i9);
            type.addFormDataPart(fileInput.key, fileInput.filename, RequestBody.create(MediaType.parse(guessMimeType(fileInput.filename)), fileInput.file));
        }
        return type.build();
    }

    @Override // com.starburst.sdk.common.okhttp.request.OkHttpRequest
    public RequestBody wrapRequestBody(RequestBody requestBody, final Callback callback) {
        return callback == null ? requestBody : new CountingRequestBody(requestBody, new CountingRequestBody.Listener() { // from class: com.starburst.sdk.common.okhttp.request.PostFormRequest.1
            @Override // com.starburst.sdk.common.okhttp.request.CountingRequestBody.Listener
            public void onRequestProgress(final long j, final long j8) {
                OkHttpUtils.getInstance().getDelivery().execute(new Runnable() { // from class: com.starburst.sdk.common.okhttp.request.PostFormRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        Callback callback2 = callback;
                        float f6 = j * 1.0f;
                        long j9 = j8;
                        callback2.inProgress(f6 / j9, j9, PostFormRequest.this.id);
                    }
                });
            }
        });
    }

    private void addParams(MultipartBody.Builder builder) {
        Map<String, String> map = this.params;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (String str : this.params.keySet()) {
            builder.addPart(Headers.of("Content-Disposition", a.i("form-data; name=\"", str, "\"")), RequestBody.create((MediaType) null, this.params.get(str)));
        }
    }
}

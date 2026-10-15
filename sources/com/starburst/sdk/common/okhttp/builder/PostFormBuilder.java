package com.starburst.sdk.common.okhttp.builder;

import com.starburst.sdk.common.okhttp.request.PostFormRequest;
import com.starburst.sdk.common.okhttp.request.RequestCall;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PostFormBuilder extends OkHttpRequestBuilder<PostFormBuilder> implements HasParamsable {
    private List<FileInput> files = new ArrayList();

    public static class FileInput {
        public File file;
        public String filename;
        public String key;

        public FileInput(String str, String str2, File file) {
            this.key = str;
            this.filename = str2;
            this.file = file;
        }

        public String toString() {
            return "FileInput{key='" + this.key + "', filename='" + this.filename + "', file=" + this.file + '}';
        }
    }

    public PostFormBuilder addFile(String str, String str2, File file) {
        this.files.add(new FileInput(str, str2, file));
        return this;
    }

    @Override // com.starburst.sdk.common.okhttp.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new PostFormRequest(this.url, this.tag, this.params, this.headers, this.files, this.id).build();
    }

    public PostFormBuilder files(String str, Map<String, File> map) {
        for (String str2 : map.keySet()) {
            this.files.add(new FileInput(str, str2, map.get(str2)));
        }
        return this;
    }

    @Override // com.starburst.sdk.common.okhttp.builder.HasParamsable
    public /* bridge */ /* synthetic */ OkHttpRequestBuilder params(Map map) {
        return params((Map<String, String>) map);
    }

    @Override // com.starburst.sdk.common.okhttp.builder.HasParamsable
    public PostFormBuilder addParams(String str, String str2) {
        if (this.params == null) {
            this.params = new LinkedHashMap();
        }
        this.params.put(str, str2);
        return this;
    }

    @Override // com.starburst.sdk.common.okhttp.builder.HasParamsable
    public PostFormBuilder params(Map<String, String> map) {
        this.params = map;
        return this;
    }
}

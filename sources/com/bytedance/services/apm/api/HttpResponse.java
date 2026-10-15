package com.bytedance.services.apm.api;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f12134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f12135c;

    public HttpResponse(int i9, byte[] bArr) {
        this.f12133a = i9;
        this.f12135c = bArr;
    }

    public Map<String, String> getHeaders() {
        return this.f12134b;
    }

    public byte[] getResponseBytes() {
        return this.f12135c;
    }

    public int getStatusCode() {
        return this.f12133a;
    }

    public HttpResponse(int i9, Map<String, String> map, byte[] bArr) {
        this.f12133a = i9;
        this.f12134b = map;
        this.f12135c = bArr;
    }
}

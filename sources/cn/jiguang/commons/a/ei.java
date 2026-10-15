package cn.jiguang.commons.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f9962c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9964e = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f9963d = new HashMap();

    public ei() {
    }

    public final String a() {
        return this.f9961b;
    }

    public final byte[] b() {
        return this.f9962c;
    }

    public final int c() {
        return this.f9964e;
    }

    public final Map<String, String> d() {
        return this.f9963d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HttpResponse{responseBody='");
        sb.append(this.f9961b);
        sb.append("', responseCode=");
        return H2.a.a(sb, this.f9964e, '}');
    }

    public ei(String str) {
        this.f9960a = str;
    }

    public final void a(int i9) {
        this.f9964e = i9;
    }

    public final void a(String str) {
        this.f9961b = str;
    }

    public final void a(String str, String str2) {
        Map<String, String> map = this.f9963d;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public final void a(byte[] bArr) {
        this.f9962c = bArr;
    }
}

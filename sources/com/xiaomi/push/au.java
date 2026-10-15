package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class au implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17061b;

    public au(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f17060a = str;
        this.f17061b = str2;
    }

    @Override // com.xiaomi.push.aw
    public String a() {
        return this.f17060a;
    }

    @Override // com.xiaomi.push.aw
    public String b() {
        return this.f17061b;
    }
}

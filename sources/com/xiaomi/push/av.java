package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f132a = new HashMap();

    public String a() {
        return this.f131a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f17062a), this.f132a.toString(), this.f131a);
    }
}

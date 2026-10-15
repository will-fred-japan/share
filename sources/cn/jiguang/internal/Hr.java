package cn.jiguang.internal;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Hr {
    public byte[] body;
    public Map<String, String> headers;
    public int statusCode;

    public Hr(int i9, Map<String, String> map, byte[] bArr) {
        this.statusCode = i9;
        this.headers = map;
        this.body = bArr;
    }
}

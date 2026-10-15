package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JSONSerializable {
    void write(JSONSerializer jSONSerializer, Object obj, Type type, int i9);
}

package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class ArraySerializer implements ObjectSerializer {
    private final ObjectSerializer compObjectSerializer;
    private final Class<?> componentType;

    public ArraySerializer(Class<?> cls, ObjectSerializer objectSerializer) {
        this.componentType = cls;
        this.compObjectSerializer = objectSerializer;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i9) throws Throwable {
        JSONSerializer jSONSerializer2;
        Throwable th;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        SerialContext serialContext = jSONSerializer.context;
        int i10 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.append('[');
            while (i10 < length) {
                if (i10 != 0) {
                    try {
                        serializeWriter.append(',');
                    } catch (Throwable th2) {
                        th = th2;
                        jSONSerializer2 = jSONSerializer;
                        jSONSerializer2.context = serialContext;
                        throw th;
                    }
                }
                Object obj3 = objArr[i10];
                if (obj3 == null) {
                    if (serializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty) && (obj instanceof String[])) {
                        serializeWriter.writeString("");
                    } else {
                        serializeWriter.append((CharSequence) "null");
                    }
                    jSONSerializer2 = jSONSerializer;
                } else if (obj3.getClass() == this.componentType) {
                    jSONSerializer2 = jSONSerializer;
                    this.compObjectSerializer.write(jSONSerializer2, obj3, Integer.valueOf(i10), null, 0);
                } else {
                    jSONSerializer2 = jSONSerializer;
                    jSONSerializer2.getObjectWriter(obj3.getClass()).write(jSONSerializer2, obj3, Integer.valueOf(i10), null, 0);
                }
                try {
                    i10++;
                    jSONSerializer = jSONSerializer2;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    jSONSerializer2.context = serialContext;
                    throw th;
                }
            }
            jSONSerializer2 = jSONSerializer;
            serializeWriter.append(']');
            jSONSerializer2.context = serialContext;
        } catch (Throwable th4) {
            th = th4;
            jSONSerializer2 = jSONSerializer;
        }
    }
}

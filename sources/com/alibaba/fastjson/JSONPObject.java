package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JSONPObject implements JSONSerializable {
    public static String SECURITY_PREFIX = "/**/";
    private String function;
    private final List<Object> parameters = new ArrayList();

    public JSONPObject() {
    }

    public void addParameter(Object obj) {
        this.parameters.add(obj);
    }

    public String getFunction() {
        return this.function;
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public String toJSONString() {
        return toString();
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override // com.alibaba.fastjson.serializer.JSONSerializable
    public void write(JSONSerializer jSONSerializer, Object obj, Type type, int i9) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i10 = SerializerFeature.BrowserSecure.mask;
        if ((i9 & i10) != 0 || serializeWriter.isEnabled(i10)) {
            serializeWriter.write(SECURITY_PREFIX);
        }
        serializeWriter.write(this.function);
        serializeWriter.write(40);
        for (int i11 = 0; i11 < this.parameters.size(); i11++) {
            if (i11 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.write(this.parameters.get(i11));
        }
        serializeWriter.write(41);
    }

    public JSONPObject(String str) {
        this.function = str;
    }
}

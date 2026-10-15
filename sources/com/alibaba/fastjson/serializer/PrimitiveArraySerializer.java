package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class PrimitiveArraySerializer implements ObjectSerializer {
    public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i9) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i10 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i10 < iArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i10]);
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i10 < sArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i10]);
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i10 < jArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i10]);
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i10 < zArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i10]);
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            serializeWriter.write(91);
            while (i10 < fArr.length) {
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                float f6 = fArr[i10];
                if (Float.isNaN(f6)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Float.toString(f6));
                }
                i10++;
            }
            serializeWriter.write(93);
            return;
        }
        if (!(obj instanceof double[])) {
            if (obj instanceof byte[]) {
                serializeWriter.writeByteArray((byte[]) obj);
                return;
            } else {
                serializeWriter.writeString((char[]) obj);
                return;
            }
        }
        double[] dArr = (double[]) obj;
        serializeWriter.write(91);
        while (i10 < dArr.length) {
            if (i10 != 0) {
                serializeWriter.write(44);
            }
            double d9 = dArr[i10];
            if (Double.isNaN(d9)) {
                serializeWriter.writeNull();
            } else {
                serializeWriter.append((CharSequence) Double.toString(d9));
            }
            i10++;
        }
        serializeWriter.write(93);
    }
}

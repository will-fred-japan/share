package R6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GeneratedFileSelectorApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                return Arrays.equals((byte[]) obj, (byte[]) obj2);
            }
            if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                return Arrays.equals((int[]) obj, (int[]) obj2);
            }
            if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                return Arrays.equals((long[]) obj, (long[]) obj2);
            }
            if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                if (dArr.length == dArr2.length) {
                    int length = dArr.length;
                    for (int i9 = 0; i9 < length; i9++) {
                        if (c(dArr[i9], dArr2[i9])) {
                        }
                    }
                    return true;
                }
            } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                float[] fArr = (float[]) obj;
                float[] fArr2 = (float[]) obj2;
                if (fArr.length == fArr2.length) {
                    int length2 = fArr.length;
                    for (int i10 = 0; i10 < length2; i10++) {
                        if (d(fArr[i10], fArr2[i10])) {
                        }
                    }
                    return true;
                }
            } else if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                Object[] objArr2 = (Object[]) obj2;
                if (objArr.length == objArr2.length) {
                    int length3 = objArr.length;
                    for (int i11 = 0; i11 < length3; i11++) {
                        if (a(objArr[i11], objArr2[i11])) {
                        }
                    }
                    return true;
                }
            } else if ((obj instanceof List) && (obj2 instanceof List)) {
                List list = (List) obj;
                List list2 = (List) obj2;
                if (list.size() == list2.size()) {
                    Iterator it = list.iterator();
                    Iterator it2 = list2.iterator();
                    while (it.hasNext() && it2.hasNext()) {
                        if (!a(it.next(), it2.next())) {
                        }
                    }
                    return true;
                }
            } else {
                if (!(obj instanceof Map) || !(obj2 instanceof Map)) {
                    if ((obj instanceof Double) && (obj2 instanceof Double)) {
                        return c(((Number) obj).doubleValue(), ((Number) obj2).doubleValue());
                    }
                    return ((obj instanceof Float) && (obj2 instanceof Float)) ? d(((Number) obj).floatValue(), ((Number) obj2).floatValue()) : obj.equals(obj2);
                }
                Map map = (Map) obj;
                Map map2 = (Map) obj2;
                if (map.size() == map2.size()) {
                    loop4: for (Map.Entry entry : map.entrySet()) {
                        Object key = entry.getKey();
                        for (Map.Entry entry2 : map2.entrySet()) {
                            if (a(key, entry2.getKey())) {
                                if (!a(entry.getValue(), entry2.getValue())) {
                                    break loop4;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static int b(Object obj) {
        int iB = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.hashCode((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.hashCode((long[]) obj);
        }
        int iB2 = 1;
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length;
            while (iB < length) {
                double d9 = dArr[iB];
                int i9 = iB2 * 31;
                if (d9 == 0.0d) {
                    d9 = 0.0d;
                }
                long jDoubleToLongBits = Double.doubleToLongBits(d9);
                iB2 = i9 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                iB++;
            }
            return iB2;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length;
            while (iB < length2) {
                float f6 = fArr[iB];
                int i10 = iB2 * 31;
                if (f6 == 0.0f) {
                    f6 = 0.0f;
                }
                iB2 = i10 + Float.floatToIntBits(f6);
                iB++;
            }
            return iB2;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length3 = objArr.length;
            while (iB < length3) {
                iB2 = (iB2 * 31) + b(objArr[iB]);
                iB++;
            }
            return iB2;
        }
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iB2 = (iB2 * 31) + b(it.next());
            }
            return iB2;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                iB += b(entry.getValue()) ^ (b(entry.getKey()) * 31);
            }
            return iB;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Number) obj).doubleValue();
            long jDoubleToLongBits2 = Double.doubleToLongBits(dDoubleValue != 0.0d ? dDoubleValue : 0.0d);
            return (int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32));
        }
        if (!(obj instanceof Float)) {
            return obj.hashCode();
        }
        float fFloatValue = ((Number) obj).floatValue();
        return Float.floatToIntBits(fFloatValue != 0.0f ? fFloatValue : 0.0f);
    }

    public static boolean c(double d9, double d10) {
        if ((d9 == 0.0d ? 0.0d : d9) == (d10 != 0.0d ? d10 : 0.0d)) {
            return true;
        }
        return Double.isNaN(d9) && Double.isNaN(d10);
    }

    public static boolean d(float f6, float f9) {
        if ((f6 == 0.0f ? 0.0f : f6) == (f9 != 0.0f ? f9 : 0.0f)) {
            return true;
        }
        return Float.isNaN(f6) && Float.isNaN(f9);
    }
}

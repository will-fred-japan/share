package com.huawei.hms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    private static void a(Parcel parcel, int i9, int i10) {
        if (parcel == null) {
            return;
        }
        if (i10 < 65535) {
            parcel.writeInt(i9 | (i10 << 16));
        } else {
            parcel.writeInt(i9 | (-65536));
            parcel.writeInt(i10);
        }
    }

    private static void b(Parcel parcel, int i9) {
        if (parcel == null) {
            return;
        }
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i9 - 4);
        parcel.writeInt(iDataPosition - i9);
        parcel.setDataPosition(iDataPosition);
    }

    public static int beginObjectHeader(Parcel parcel) {
        return a(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i9) {
        b(parcel, i9);
    }

    public static void writeBigDecimal(Parcel parcel, int i9, BigDecimal bigDecimal, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (bigDecimal == null) {
            if (z8) {
                a(parcel, i9, 0);
            }
        } else {
            int iA = a(parcel, i9);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            b(parcel, iA);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i9, BigDecimal[] bigDecimalArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (bigDecimalArr == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i10 = 0; i10 < length; i10++) {
            parcel.writeByteArray(bigDecimalArr[i10].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i10].scale());
        }
        b(parcel, iA);
    }

    public static void writeBigInteger(Parcel parcel, int i9, BigInteger bigInteger, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (bigInteger != null) {
            int iA = a(parcel, i9);
            parcel.writeByteArray(bigInteger.toByteArray());
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i9, BigInteger[] bigIntegerArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (bigIntegerArr == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        b(parcel, iA);
    }

    public static void writeBoolean(Parcel parcel, int i9, boolean z8) {
        if (parcel == null) {
            return;
        }
        a(parcel, i9, 4);
        if (z8) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    public static void writeBooleanArray(Parcel parcel, int i9, boolean[] zArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (zArr != null) {
            int iA = a(parcel, i9);
            parcel.writeBooleanArray(zArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i9, List<Boolean> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(list.get(i10).booleanValue() ? 1 : 0);
        }
        b(parcel, iA);
    }

    public static void writeBooleanObject(Parcel parcel, int i9, Boolean bool, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (bool != null) {
            a(parcel, i9, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i9, Bundle bundle, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (bundle != null) {
            int iA = a(parcel, i9);
            parcel.writeBundle(bundle);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i9, byte b9) {
        if (parcel == null) {
            return;
        }
        a(parcel, i9, 4);
        parcel.writeInt(b9);
    }

    public static void writeByteArray(Parcel parcel, int i9, byte[] bArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (bArr != null) {
            int iA = a(parcel, i9);
            parcel.writeByteArray(bArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i9, byte[][] bArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (bArr == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        b(parcel, iA);
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i9, SparseArray<byte[]> sparseArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseArray.keyAt(i10));
            parcel.writeByteArray(sparseArray.valueAt(i10));
        }
        b(parcel, iA);
    }

    public static void writeChar(Parcel parcel, int i9, char c5) {
        if (parcel == null) {
            return;
        }
        a(parcel, i9, 4);
        parcel.writeInt(c5);
    }

    public static void writeCharArray(Parcel parcel, int i9, char[] cArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (cArr != null) {
            int iA = a(parcel, i9);
            parcel.writeCharArray(cArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i9, double d9) {
        if (parcel == null) {
            return;
        }
        a(parcel, i9, 8);
        parcel.writeDouble(d9);
    }

    public static void writeDoubleArray(Parcel parcel, int i9, double[] dArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (dArr != null) {
            int iA = a(parcel, i9);
            parcel.writeDoubleArray(dArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i9, List<Double> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeDouble(list.get(i10).doubleValue());
        }
        b(parcel, iA);
    }

    public static void writeDoubleObject(Parcel parcel, int i9, Double d9, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (d9 != null) {
            a(parcel, i9, 8);
            parcel.writeDouble(d9.doubleValue());
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i9, SparseArray<Double> sparseArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseArray.keyAt(i10));
            parcel.writeDouble(sparseArray.valueAt(i10).doubleValue());
        }
        b(parcel, iA);
    }

    public static void writeFloat(Parcel parcel, int i9, float f6) {
        if (parcel == null) {
            return;
        }
        a(parcel, i9, 4);
        parcel.writeFloat(f6);
    }

    public static void writeFloatArray(Parcel parcel, int i9, float[] fArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (fArr != null) {
            int iA = a(parcel, i9);
            parcel.writeFloatArray(fArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i9, List<Float> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeFloat(list.get(i10).floatValue());
        }
        b(parcel, iA);
    }

    public static void writeFloatObject(Parcel parcel, int i9, Float f6, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (f6 != null) {
            a(parcel, i9, 4);
            parcel.writeFloat(f6.floatValue());
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i9, SparseArray<Float> sparseArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseArray.keyAt(i10));
            parcel.writeFloat(sparseArray.valueAt(i10).floatValue());
        }
        b(parcel, iA);
    }

    public static void writeIBinder(Parcel parcel, int i9, IBinder iBinder, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (iBinder != null) {
            int iA = a(parcel, i9);
            parcel.writeStrongBinder(iBinder);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i9, IBinder[] iBinderArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (iBinderArr != null) {
            int iA = a(parcel, i9);
            parcel.writeBinderArray(iBinderArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i9, List<IBinder> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int iA = a(parcel, i9);
            parcel.writeBinderList(list);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i9, SparseArray<IBinder> sparseArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseArray.keyAt(i10));
            parcel.writeStrongBinder(sparseArray.valueAt(i10));
        }
        b(parcel, iA);
    }

    public static void writeInt(Parcel parcel, int i9, int i10) {
        if (parcel == null) {
            return;
        }
        a(parcel, i9, 4);
        parcel.writeInt(i10);
    }

    public static void writeIntArray(Parcel parcel, int i9, int[] iArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (iArr != null) {
            int iA = a(parcel, i9);
            parcel.writeIntArray(iArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i9, List<Integer> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(list.get(i10).intValue());
        }
        b(parcel, iA);
    }

    public static void writeIntegerObject(Parcel parcel, int i9, Integer num, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (num != null) {
            a(parcel, i9, 4);
            parcel.writeInt(num.intValue());
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeList(Parcel parcel, int i9, List list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int iA = a(parcel, i9);
            parcel.writeList(list);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i9, long j) {
        if (parcel == null) {
            return;
        }
        a(parcel, i9, 8);
        parcel.writeLong(j);
    }

    public static void writeLongArray(Parcel parcel, int i9, long[] jArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (jArr != null) {
            int iA = a(parcel, i9);
            parcel.writeLongArray(jArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i9, List<Long> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeLong(list.get(i10).longValue());
        }
        b(parcel, iA);
    }

    public static void writeLongObject(Parcel parcel, int i9, Long l8, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (l8 != null) {
            a(parcel, i9, 8);
            parcel.writeLong(l8.longValue());
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i9, Parcel parcel2, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (parcel2 != null) {
            int iA = a(parcel, i9);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i9, Parcel[] parcelArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (parcelArr == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int length = parcelArr.length;
        parcel.writeInt(length);
        for (int i10 = 0; i10 < length; i10++) {
            Parcel parcel2 = parcelArr[i10];
            if (parcel2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcel2.dataSize());
                Parcel parcel3 = parcelArr[i10];
                parcel.appendFrom(parcel3, 0, parcel3.dataSize());
            }
        }
        b(parcel, iA);
    }

    public static void writeParcelList(Parcel parcel, int i9, List<Parcel> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            Parcel parcel2 = list.get(i10);
            if (parcel2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            }
        }
        b(parcel, iA);
    }

    public static void writeParcelSparseArray(Parcel parcel, int i9, SparseArray<Parcel> sparseArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseArray.keyAt(i10));
            Parcel parcelValueAt = sparseArray.valueAt(i10);
            if (parcelValueAt == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcelValueAt.dataSize());
                parcel.appendFrom(parcelValueAt, 0, parcelValueAt.dataSize());
            }
        }
        b(parcel, iA);
    }

    public static void writeParcelable(Parcel parcel, int i9, Parcelable parcelable, int i10, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (parcelable != null) {
            int iA = a(parcel, i9);
            parcelable.writeToParcel(parcel, i10);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i9, short s8) {
        if (parcel == null) {
            return;
        }
        a(parcel, i9, 4);
        parcel.writeInt(s8);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i9, SparseBooleanArray sparseBooleanArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseBooleanArray != null) {
            int iA = a(parcel, i9);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i9, SparseIntArray sparseIntArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseIntArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseIntArray.keyAt(i10));
            parcel.writeInt(sparseIntArray.valueAt(i10));
        }
        b(parcel, iA);
    }

    public static void writeSparseLongArray(Parcel parcel, int i9, SparseLongArray sparseLongArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseLongArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseLongArray.keyAt(i10));
            parcel.writeLong(sparseLongArray.valueAt(i10));
        }
        b(parcel, iA);
    }

    public static void writeString(Parcel parcel, int i9, String str, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (str != null) {
            int iA = a(parcel, i9);
            parcel.writeString(str);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i9, String[] strArr, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (strArr != null) {
            int iA = a(parcel, i9);
            parcel.writeStringArray(strArr);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i9, List<String> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list != null) {
            int iA = a(parcel, i9);
            parcel.writeStringList(list);
            b(parcel, iA);
        } else if (z8) {
            a(parcel, i9, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i9, SparseArray<String> sparseArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseArray.keyAt(i10));
            parcel.writeString(sparseArray.valueAt(i10));
        }
        b(parcel, iA);
    }

    public static <P extends Parcelable> void writeTypedArray(Parcel parcel, int i9, P[] pArr, int i10, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (pArr == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        parcel.writeInt(iA);
        for (P p8 : pArr) {
            if (p8 != null) {
                a(parcel, p8, i10);
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, iA);
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i9, List<T> list, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (list == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            T t = list.get(i10);
            if (t != null) {
                a(parcel, t, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, iA);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i9, SparseArray<T> sparseArray, boolean z8) {
        if (parcel == null) {
            return;
        }
        if (sparseArray == null) {
            if (z8) {
                a(parcel, i9, 0);
                return;
            }
            return;
        }
        int iA = a(parcel, i9);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeInt(sparseArray.keyAt(i10));
            T tValueAt = sparseArray.valueAt(i10);
            if (tValueAt != null) {
                a(parcel, tValueAt, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, iA);
    }

    private static int a(Parcel parcel, int i9) {
        parcel.writeInt(i9 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static <P extends Parcelable> void a(Parcel parcel, P p8, int i9) {
        if (parcel == null) {
            return;
        }
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        p8.writeToParcel(parcel, i9);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}

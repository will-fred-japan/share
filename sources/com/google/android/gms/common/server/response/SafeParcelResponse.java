package com.google.android.gms.common.server.response;

import S4.C0376g;
import W5.e;
import Z4.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.SparseArray;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.xiaomi.mipush.sdk.Constants;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p011b4.h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parcel f12590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zan f12592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12595g;

    public SafeParcelResponse(int i9, Parcel parcel, zan zanVar) {
        this.f12589a = i9;
        C0376g.e(parcel);
        this.f12590b = parcel;
        this.f12591c = 2;
        this.f12592d = zanVar;
        this.f12593e = zanVar == null ? null : zanVar.f12604c;
        this.f12594f = 2;
    }

    public static void m(StringBuilder sb, Map map, Parcel parcel) {
        BigInteger bigInteger;
        Parcel parcelObtain;
        BigInteger[] bigIntegerArr;
        long[] jArrCreateLongArray;
        float[] fArrCreateFloatArray;
        double[] dArrCreateDoubleArray;
        BigDecimal[] bigDecimalArr;
        boolean[] zArrCreateBooleanArray;
        String[] strArrCreateStringArray;
        Parcel[] parcelArr;
        BigInteger bigInteger2;
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).f12585g, entry);
        }
        sb.append('{');
        int iS = T4.a.s(parcel);
        boolean z8 = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            Map.Entry entry2 = (Map.Entry) sparseArray.get((char) i9);
            if (entry2 != null) {
                if (z8) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                StringToIntConverter stringToIntConverter = field.f12588k;
                int i10 = field.f12582d;
                if (stringToIntConverter != null) {
                    switch (i10) {
                        case 0:
                            o(sb, field, FastJsonResponse.j(field, Integer.valueOf(T4.a.n(parcel, i9))));
                            break;
                        case 1:
                            int iQ = T4.a.q(parcel, i9);
                            int iDataPosition = parcel.dataPosition();
                            if (iQ == 0) {
                                bigInteger2 = null;
                            } else {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iQ);
                                bigInteger2 = new BigInteger(bArrCreateByteArray);
                            }
                            o(sb, field, FastJsonResponse.j(field, bigInteger2));
                            break;
                        case 2:
                            o(sb, field, FastJsonResponse.j(field, Long.valueOf(T4.a.o(parcel, i9))));
                            break;
                        case 3:
                            o(sb, field, FastJsonResponse.j(field, Float.valueOf(T4.a.l(parcel, i9))));
                            break;
                        case 4:
                            T4.a.t(parcel, i9, 8);
                            o(sb, field, FastJsonResponse.j(field, Double.valueOf(parcel.readDouble())));
                            break;
                        case 5:
                            o(sb, field, FastJsonResponse.j(field, T4.a.a(parcel, i9)));
                            break;
                        case 6:
                            o(sb, field, FastJsonResponse.j(field, Boolean.valueOf(T4.a.k(parcel, i9))));
                            break;
                        case 7:
                            o(sb, field, FastJsonResponse.j(field, T4.a.f(parcel, i9)));
                            break;
                        case 8:
                        case 9:
                            o(sb, field, FastJsonResponse.j(field, T4.a.c(parcel, i9)));
                            break;
                        case 10:
                            Bundle bundleB = T4.a.b(parcel, i9);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleB.keySet()) {
                                String string = bundleB.getString(str2);
                                C0376g.e(string);
                                map2.put(str2, string);
                            }
                            o(sb, field, FastJsonResponse.j(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(e.i(i10, "Unknown field out type = "));
                    }
                } else {
                    boolean z9 = field.f12583e;
                    String str3 = field.f12587i;
                    if (z9) {
                        sb.append("[");
                        switch (i10) {
                            case 0:
                                int[] iArrD = T4.a.d(parcel, i9);
                                int length = iArrD.length;
                                for (int i11 = 0; i11 < length; i11++) {
                                    if (i11 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(iArrD[i11]);
                                }
                                break;
                            case 1:
                                int iQ2 = T4.a.q(parcel, i9);
                                int iDataPosition2 = parcel.dataPosition();
                                if (iQ2 == 0) {
                                    bigIntegerArr = null;
                                } else {
                                    int i12 = parcel.readInt();
                                    bigIntegerArr = new BigInteger[i12];
                                    for (int i13 = 0; i13 < i12; i13++) {
                                        bigIntegerArr[i13] = new BigInteger(parcel.createByteArray());
                                    }
                                    parcel.setDataPosition(iDataPosition2 + iQ2);
                                }
                                int length2 = bigIntegerArr.length;
                                for (int i14 = 0; i14 < length2; i14++) {
                                    if (i14 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(bigIntegerArr[i14]);
                                }
                                break;
                            case 2:
                                int iQ3 = T4.a.q(parcel, i9);
                                int iDataPosition3 = parcel.dataPosition();
                                if (iQ3 == 0) {
                                    jArrCreateLongArray = null;
                                } else {
                                    jArrCreateLongArray = parcel.createLongArray();
                                    parcel.setDataPosition(iDataPosition3 + iQ3);
                                }
                                int length3 = jArrCreateLongArray.length;
                                for (int i15 = 0; i15 < length3; i15++) {
                                    if (i15 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(jArrCreateLongArray[i15]);
                                }
                                break;
                            case 3:
                                int iQ4 = T4.a.q(parcel, i9);
                                int iDataPosition4 = parcel.dataPosition();
                                if (iQ4 == 0) {
                                    fArrCreateFloatArray = null;
                                } else {
                                    fArrCreateFloatArray = parcel.createFloatArray();
                                    parcel.setDataPosition(iDataPosition4 + iQ4);
                                }
                                int length4 = fArrCreateFloatArray.length;
                                for (int i16 = 0; i16 < length4; i16++) {
                                    if (i16 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(fArrCreateFloatArray[i16]);
                                }
                                break;
                            case 4:
                                int iQ5 = T4.a.q(parcel, i9);
                                int iDataPosition5 = parcel.dataPosition();
                                if (iQ5 == 0) {
                                    dArrCreateDoubleArray = null;
                                } else {
                                    dArrCreateDoubleArray = parcel.createDoubleArray();
                                    parcel.setDataPosition(iDataPosition5 + iQ5);
                                }
                                int length5 = dArrCreateDoubleArray.length;
                                for (int i17 = 0; i17 < length5; i17++) {
                                    if (i17 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(dArrCreateDoubleArray[i17]);
                                }
                                break;
                            case 5:
                                int iQ6 = T4.a.q(parcel, i9);
                                int iDataPosition6 = parcel.dataPosition();
                                if (iQ6 == 0) {
                                    bigDecimalArr = null;
                                } else {
                                    int i18 = parcel.readInt();
                                    bigDecimalArr = new BigDecimal[i18];
                                    for (int i19 = 0; i19 < i18; i19++) {
                                        bigDecimalArr[i19] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
                                    }
                                    parcel.setDataPosition(iDataPosition6 + iQ6);
                                }
                                int length6 = bigDecimalArr.length;
                                for (int i20 = 0; i20 < length6; i20++) {
                                    if (i20 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(bigDecimalArr[i20]);
                                }
                                break;
                            case 6:
                                int iQ7 = T4.a.q(parcel, i9);
                                int iDataPosition7 = parcel.dataPosition();
                                if (iQ7 == 0) {
                                    zArrCreateBooleanArray = null;
                                } else {
                                    zArrCreateBooleanArray = parcel.createBooleanArray();
                                    parcel.setDataPosition(iDataPosition7 + iQ7);
                                }
                                int length7 = zArrCreateBooleanArray.length;
                                for (int i21 = 0; i21 < length7; i21++) {
                                    if (i21 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append(zArrCreateBooleanArray[i21]);
                                }
                                break;
                            case 7:
                                int iQ8 = T4.a.q(parcel, i9);
                                int iDataPosition8 = parcel.dataPosition();
                                if (iQ8 == 0) {
                                    strArrCreateStringArray = null;
                                } else {
                                    strArrCreateStringArray = parcel.createStringArray();
                                    parcel.setDataPosition(iDataPosition8 + iQ8);
                                }
                                int length8 = strArrCreateStringArray.length;
                                for (int i22 = 0; i22 < length8; i22++) {
                                    if (i22 != 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append("\"");
                                    sb.append(strArrCreateStringArray[i22]);
                                    sb.append("\"");
                                }
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                int iQ9 = T4.a.q(parcel, i9);
                                int iDataPosition9 = parcel.dataPosition();
                                if (iQ9 == 0) {
                                    parcelArr = null;
                                } else {
                                    int i23 = parcel.readInt();
                                    Parcel[] parcelArr2 = new Parcel[i23];
                                    for (int i24 = 0; i24 < i23; i24++) {
                                        int i25 = parcel.readInt();
                                        if (i25 != 0) {
                                            int iDataPosition10 = parcel.dataPosition();
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            parcelObtain2.appendFrom(parcel, iDataPosition10, i25);
                                            parcelArr2[i24] = parcelObtain2;
                                            parcel.setDataPosition(iDataPosition10 + i25);
                                        } else {
                                            parcelArr2[i24] = null;
                                        }
                                    }
                                    parcel.setDataPosition(iDataPosition9 + iQ9);
                                    parcelArr = parcelArr2;
                                }
                                int length9 = parcelArr.length;
                                for (int i26 = 0; i26 < length9; i26++) {
                                    if (i26 > 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    parcelArr[i26].setDataPosition(0);
                                    C0376g.e(str3);
                                    C0376g.e(field.j);
                                    Map map3 = (Map) field.j.f12603b.get(str3);
                                    C0376g.e(map3);
                                    m(sb, map3, parcelArr[i26]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        sb.append("]");
                    } else {
                        switch (i10) {
                            case 0:
                                sb.append(T4.a.n(parcel, i9));
                                break;
                            case 1:
                                int iQ10 = T4.a.q(parcel, i9);
                                int iDataPosition11 = parcel.dataPosition();
                                if (iQ10 == 0) {
                                    bigInteger = null;
                                } else {
                                    byte[] bArrCreateByteArray2 = parcel.createByteArray();
                                    parcel.setDataPosition(iDataPosition11 + iQ10);
                                    bigInteger = new BigInteger(bArrCreateByteArray2);
                                }
                                sb.append(bigInteger);
                                break;
                            case 2:
                                sb.append(T4.a.o(parcel, i9));
                                break;
                            case 3:
                                sb.append(T4.a.l(parcel, i9));
                                break;
                            case 4:
                                T4.a.t(parcel, i9, 8);
                                sb.append(parcel.readDouble());
                                break;
                            case 5:
                                sb.append(T4.a.a(parcel, i9));
                                break;
                            case 6:
                                sb.append(T4.a.k(parcel, i9));
                                break;
                            case 7:
                                String strF = T4.a.f(parcel, i9);
                                sb.append("\"");
                                sb.append(b5.b.a(strF));
                                sb.append("\"");
                                break;
                            case 8:
                                byte[] bArrC = T4.a.c(parcel, i9);
                                sb.append("\"");
                                sb.append(bArrC == null ? null : Base64.encodeToString(bArrC, 0));
                                sb.append("\"");
                                break;
                            case 9:
                                byte[] bArrC2 = T4.a.c(parcel, i9);
                                sb.append("\"");
                                sb.append(bArrC2 == null ? null : Base64.encodeToString(bArrC2, 10));
                                sb.append("\"");
                                break;
                            case 10:
                                Bundle bundleB2 = T4.a.b(parcel, i9);
                                Set<String> setKeySet = bundleB2.keySet();
                                sb.append("{");
                                boolean z10 = true;
                                for (String str4 : setKeySet) {
                                    if (!z10) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    sb.append("\"");
                                    sb.append(str4);
                                    sb.append("\":\"");
                                    sb.append(b5.b.a(bundleB2.getString(str4)));
                                    sb.append("\"");
                                    z10 = false;
                                }
                                sb.append("}");
                                break;
                            case 11:
                                int iQ11 = T4.a.q(parcel, i9);
                                int iDataPosition12 = parcel.dataPosition();
                                if (iQ11 == 0) {
                                    parcelObtain = null;
                                } else {
                                    parcelObtain = Parcel.obtain();
                                    parcelObtain.appendFrom(parcel, iDataPosition12, iQ11);
                                    parcel.setDataPosition(iDataPosition12 + iQ11);
                                }
                                parcelObtain.setDataPosition(0);
                                C0376g.e(str3);
                                C0376g.e(field.j);
                                Map map4 = (Map) field.j.f12603b.get(str3);
                                C0376g.e(map4);
                                m(sb, map4, parcelObtain);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                }
                z8 = true;
            }
        }
        if (parcel.dataPosition() != iS) {
            throw new T4.a.C0056a(e.i(iS, "Overread allowed size end="), parcel);
        }
        sb.append('}');
    }

    public static final void n(StringBuilder sb, int i9, Object obj) {
        switch (i9) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                C0376g.e(obj);
                sb.append(b5.b.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                byte[] bArr = (byte[]) obj;
                sb.append(bArr != null ? Base64.encodeToString(bArr, 0) : null);
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                byte[] bArr2 = (byte[]) obj;
                sb.append(bArr2 != null ? Base64.encodeToString(bArr2, 10) : null);
                sb.append("\"");
                return;
            case 10:
                C0376g.e(obj);
                h.H(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(e.i(i9, "Unknown type = "));
        }
    }

    public static final void o(StringBuilder sb, FastJsonResponse.Field field, Object obj) {
        boolean z8 = field.f12581c;
        int i9 = field.f12580b;
        if (!z8) {
            n(sb, i9, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            n(sb, i9, arrayList.get(i10));
        }
        sb.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map<String, FastJsonResponse.Field<?, ?>> a() {
        zan zanVar = this.f12592d;
        if (zanVar == null) {
            return null;
        }
        String str = this.f12593e;
        C0376g.e(str);
        return (Map) zanVar.f12603b.get(str);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final Object c() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean e() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Parcel l() {
        int i9 = this.f12594f;
        Parcel parcel = this.f12590b;
        if (i9 != 0) {
            if (i9 != 1) {
                return parcel;
            }
            p199z2.b.V(parcel, this.f12595g);
            this.f12594f = 2;
            return parcel;
        }
        int iU = p199z2.b.U(parcel, 20293);
        this.f12595g = iU;
        p199z2.b.V(parcel, iU);
        this.f12594f = 2;
        return parcel;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final String toString() {
        zan zanVar = this.f12592d;
        C0376g.f(zanVar, "Cannot convert to JSON on client side.");
        Parcel parcelL = l();
        parcelL.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        String str = this.f12593e;
        C0376g.e(str);
        Map map = (Map) zanVar.f12603b.get(str);
        C0376g.e(map);
        m(sb, map, parcelL);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12589a);
        Parcel parcelL = l();
        if (parcelL != null) {
            int iU2 = p199z2.b.U(parcel, 2);
            parcel.appendFrom(parcelL, 0, parcelL.dataSize());
            p199z2.b.V(parcel, iU2);
        }
        p199z2.b.P(parcel, 3, this.f12591c != 0 ? this.f12592d : null, i9);
        p199z2.b.V(parcel, iU);
    }
}

package com.google.android.gms.common;

import O4.t;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12628d;

    public zzq(boolean z8, String str, int i9, int i10) {
        int i11;
        int i12 = 1;
        this.f12625a = z8;
        this.f12626b = str;
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i13 = 0;
        while (true) {
            if (i13 >= 6) {
                i11 = 1;
                break;
            }
            i11 = iArr[i13];
            int i14 = i11 - 1;
            if (i11 == 0) {
                throw null;
            }
            if (i14 == i9) {
                break;
            } else {
                i13++;
            }
        }
        this.f12627c = i11 - 1;
        int[] iArr2 = {1, 2, 3};
        for (int i15 = 0; i15 < 3; i15++) {
            int i16 = iArr2[i15];
            int i17 = i16 - 1;
            if (i16 == 0) {
                throw null;
            }
            if (i17 == i10) {
                i12 = i16;
                break;
            }
        }
        this.f12628d = i12 - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12625a ? 1 : 0);
        b.Q(parcel, 2, this.f12626b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12627c);
        b.W(parcel, 4, 4);
        parcel.writeInt(this.f12628d);
        b.V(parcel, iU);
    }
}

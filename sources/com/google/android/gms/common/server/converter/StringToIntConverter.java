package com.google.android.gms.common.server.converter;

import Y4.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f12572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f12573c;

    public StringToIntConverter() {
        this.f12571a = 1;
        this.f12572b = new HashMap();
        this.f12573c = new SparseArray();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12571a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f12572b;
        for (String str : map.keySet()) {
            arrayList.add(new zac(str, ((Integer) map.get(str)).intValue()));
        }
        p199z2.b.T(parcel, 2, arrayList);
        p199z2.b.V(parcel, iU);
    }

    public StringToIntConverter(int i9, ArrayList arrayList) {
        this.f12571a = i9;
        this.f12572b = new HashMap();
        this.f12573c = new SparseArray();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zac zacVar = (zac) arrayList.get(i10);
            String str = zacVar.f12577b;
            int i11 = zacVar.f12578c;
            this.f12572b.put(str, Integer.valueOf(i11));
            this.f12573c.put(i11, str);
        }
    }
}

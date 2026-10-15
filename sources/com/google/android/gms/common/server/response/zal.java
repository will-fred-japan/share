package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new Z4.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f12598c;

    public zal(int i9, String str, ArrayList arrayList) {
        this.f12596a = i9;
        this.f12597b = str;
        this.f12598c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12596a);
        p199z2.b.Q(parcel, 2, this.f12597b);
        p199z2.b.T(parcel, 3, this.f12598c);
        p199z2.b.V(parcel, iU);
    }

    public zal(String str, Map map) {
        ArrayList arrayList;
        this.f12596a = 1;
        this.f12597b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse.Field) map.get(str2)));
            }
        }
        this.f12598c = arrayList;
    }
}

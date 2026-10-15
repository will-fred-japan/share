package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class an implements Parcelable.Creator<am> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ am createFromParcel(Parcel parcel) {
        return new am(parcel, (byte) 0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ am[] newArray(int i9) {
        return new am[i9];
    }
}

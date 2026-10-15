package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class o implements Parcelable.Creator<n> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n createFromParcel(Parcel parcel) {
        return new n(parcel, (byte) 0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ n[] newArray(int i9) {
        return new n[i9];
    }
}

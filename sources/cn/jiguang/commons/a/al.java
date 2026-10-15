package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class al implements Parcelable.Creator<ak> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ak createFromParcel(Parcel parcel) {
        return new ak(parcel, (byte) 0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ak[] newArray(int i9) {
        return new ak[i9];
    }
}

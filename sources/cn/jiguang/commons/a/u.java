package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class u implements Parcelable.Creator<t> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t createFromParcel(Parcel parcel) {
        return new t(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ t[] newArray(int i9) {
        return new t[i9];
    }
}

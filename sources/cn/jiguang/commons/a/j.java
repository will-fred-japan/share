package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class j implements Parcelable.Creator<i> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i createFromParcel(Parcel parcel) {
        return new i(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ i[] newArray(int i9) {
        return new i[i9];
    }
}

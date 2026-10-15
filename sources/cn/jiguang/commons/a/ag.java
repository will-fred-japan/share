package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class ag implements Parcelable.Creator<af> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ af createFromParcel(Parcel parcel) {
        return new af(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ af[] newArray(int i9) {
        return new af[i9];
    }
}

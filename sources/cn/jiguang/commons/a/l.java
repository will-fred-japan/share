package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class l implements Parcelable.Creator<k> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k createFromParcel(Parcel parcel) {
        return new k(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ k[] newArray(int i9) {
        return new k[i9];
    }
}

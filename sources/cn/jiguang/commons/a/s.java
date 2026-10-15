package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class s implements Parcelable.Creator<r> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r createFromParcel(Parcel parcel) {
        return new r(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ r[] newArray(int i9) {
        return new r[i9];
    }
}

package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class q implements Parcelable.Creator<p> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p createFromParcel(Parcel parcel) {
        return new p(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ p[] newArray(int i9) {
        return new p[i9];
    }
}

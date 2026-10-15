package cn.asus.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f8782b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8781a);
        parcel.writeBundle(this.f8782b);
    }
}

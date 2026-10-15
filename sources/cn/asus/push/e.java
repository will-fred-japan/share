package cn.asus.push;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator<DataBuffer> {
    @Override // android.os.Parcelable.Creator
    public final DataBuffer createFromParcel(Parcel parcel) {
        DataBuffer dataBuffer = new DataBuffer();
        dataBuffer.f8781a = parcel.readString();
        dataBuffer.f8782b = parcel.readBundle();
        return dataBuffer;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DataBuffer[] newArray(int i9) {
        return new DataBuffer[i9];
    }
}

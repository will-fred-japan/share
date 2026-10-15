package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5779e;

    public class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
            parcelableVolumeInfo.f5775a = parcel.readInt();
            parcelableVolumeInfo.f5777c = parcel.readInt();
            parcelableVolumeInfo.f5778d = parcel.readInt();
            parcelableVolumeInfo.f5779e = parcel.readInt();
            parcelableVolumeInfo.f5776b = parcel.readInt();
            return parcelableVolumeInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo[] newArray(int i9) {
            return new ParcelableVolumeInfo[i9];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f5775a);
        parcel.writeInt(this.f5777c);
        parcel.writeInt(this.f5778d);
        parcel.writeInt(this.f5779e);
        parcel.writeInt(this.f5776b);
    }
}

package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f5769b;

    public class a implements Parcelable.Creator<RatingCompat> {
        @Override // android.os.Parcelable.Creator
        public final RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final RatingCompat[] newArray(int i9) {
            return new RatingCompat[i9];
        }
    }

    public RatingCompat(int i9, float f6) {
        this.f5768a = i9;
        this.f5769b = f6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f5768a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f5768a);
        sb.append(" rating=");
        float f6 = this.f5769b;
        sb.append(f6 < 0.0f ? "unrated" : String.valueOf(f6));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f5768a);
        parcel.writeFloat(this.f5769b);
    }
}

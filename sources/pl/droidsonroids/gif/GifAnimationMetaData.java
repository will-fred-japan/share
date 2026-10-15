package pl.droidsonroids.gif;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class GifAnimationMetaData implements Serializable, Parcelable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new a();
    private static final long serialVersionUID = 5692363926580237325L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f20823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f20824g;

    public class a implements Parcelable.Creator<GifAnimationMetaData> {
        @Override // android.os.Parcelable.Creator
        public final GifAnimationMetaData createFromParcel(Parcel parcel) {
            return new GifAnimationMetaData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GifAnimationMetaData[] newArray(int i9) {
            return new GifAnimationMetaData[i9];
        }
    }

    public GifAnimationMetaData(Parcel parcel) {
        this.f20818a = parcel.readInt();
        this.f20819b = parcel.readInt();
        this.f20820c = parcel.readInt();
        this.f20821d = parcel.readInt();
        this.f20822e = parcel.readInt();
        this.f20824g = parcel.readLong();
        this.f20823f = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        int i9 = this.f20818a;
        String string = i9 == 0 ? "Infinity" : Integer.toString(i9);
        Locale locale = Locale.ENGLISH;
        StringBuilder sb = new StringBuilder("GIF: size: ");
        sb.append(this.f20821d);
        sb.append("x");
        sb.append(this.f20820c);
        sb.append(", frames: ");
        int i10 = this.f20822e;
        sb.append(i10);
        sb.append(", loops: ");
        sb.append(string);
        sb.append(", duration: ");
        int i11 = this.f20819b;
        sb.append(i11);
        String string2 = sb.toString();
        return (i10 <= 1 || i11 <= 0) ? string2 : "Animated ".concat(string2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f20818a);
        parcel.writeInt(this.f20819b);
        parcel.writeInt(this.f20820c);
        parcel.writeInt(this.f20821d);
        parcel.writeInt(this.f20822e);
        parcel.writeLong(this.f20824g);
        parcel.writeLong(this.f20823f);
    }
}

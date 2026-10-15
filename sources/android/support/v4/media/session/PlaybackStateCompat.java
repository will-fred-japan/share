package android.support.v4.media.session;

import W5.e;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f5783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f5786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f5787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f5788i;
    public final long j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f5789k;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f5791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f5793d;

        public class a implements Parcelable.Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            public final CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final CustomAction[] newArray(int i9) {
                return new CustomAction[i9];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f5790a = parcel.readString();
            this.f5791b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f5792c = parcel.readInt();
            this.f5793d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f5791b) + ", mIcon=" + this.f5792c + ", mExtras=" + this.f5793d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            parcel.writeString(this.f5790a);
            TextUtils.writeToParcel(this.f5791b, parcel, i9);
            parcel.writeInt(this.f5792c);
            parcel.writeBundle(this.f5793d);
        }
    }

    public class a implements Parcelable.Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        public final PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PlaybackStateCompat[] newArray(int i9) {
            return new PlaybackStateCompat[i9];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f5780a = parcel.readInt();
        this.f5781b = parcel.readLong();
        this.f5783d = parcel.readFloat();
        this.f5787h = parcel.readLong();
        this.f5782c = parcel.readLong();
        this.f5784e = parcel.readLong();
        this.f5786g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f5788i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.f5789k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f5785f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f5780a);
        sb.append(", position=");
        sb.append(this.f5781b);
        sb.append(", buffered position=");
        sb.append(this.f5782c);
        sb.append(", speed=");
        sb.append(this.f5783d);
        sb.append(", updated=");
        sb.append(this.f5787h);
        sb.append(", actions=");
        sb.append(this.f5784e);
        sb.append(", error code=");
        sb.append(this.f5785f);
        sb.append(", error message=");
        sb.append(this.f5786g);
        sb.append(", custom actions=");
        sb.append(this.f5788i);
        sb.append(", active item id=");
        return e.m(sb, this.j, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f5780a);
        parcel.writeLong(this.f5781b);
        parcel.writeFloat(this.f5783d);
        parcel.writeLong(this.f5787h);
        parcel.writeLong(this.f5782c);
        parcel.writeLong(this.f5784e);
        TextUtils.writeToParcel(this.f5786g, parcel, i9);
        parcel.writeTypedList(this.f5788i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.f5789k);
        parcel.writeInt(this.f5785f);
    }
}

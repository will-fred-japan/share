package android.support.v4.media.session;

import W5.e;
import android.annotation.SuppressLint;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat {

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaDescriptionCompat f5770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f5771b;

        public class a implements Parcelable.Creator<QueueItem> {
            @Override // android.os.Parcelable.Creator
            public final QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final QueueItem[] newArray(int i9) {
                return new QueueItem[i9];
            }
        }

        public QueueItem(Parcel parcel) {
            this.f5770a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f5771b = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
            sb.append(this.f5770a);
            sb.append(", Id=");
            return e.m(sb, this.f5771b, " }");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            this.f5770a.writeToParcel(parcel, i9);
            parcel.writeLong(this.f5771b);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ResultReceiver f5772a;

        public class a implements Parcelable.Creator<ResultReceiverWrapper> {
            @Override // android.os.Parcelable.Creator
            public final ResultReceiverWrapper createFromParcel(Parcel parcel) {
                ResultReceiverWrapper resultReceiverWrapper = new ResultReceiverWrapper();
                resultReceiverWrapper.f5772a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return resultReceiverWrapper;
            }

            @Override // android.os.Parcelable.Creator
            public final ResultReceiverWrapper[] newArray(int i9) {
                return new ResultReceiverWrapper[i9];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            this.f5772a.writeToParcel(parcel, i9);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5773a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Parcelable f5774b;

        public class a implements Parcelable.Creator<Token> {
            @Override // android.os.Parcelable.Creator
            public final Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            public final Token[] newArray(int i9) {
                return new Token[i9];
            }
        }

        public Token(Parcelable parcelable) {
            this.f5774b = parcelable;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Parcelable parcelable = this.f5774b;
            if (parcelable == null) {
                return token.f5774b == null;
            }
            Parcelable parcelable2 = token.f5774b;
            if (parcelable2 == null) {
                return false;
            }
            return parcelable.equals(parcelable2);
        }

        public final int hashCode() {
            Parcelable parcelable = this.f5774b;
            if (parcelable == null) {
                return 0;
            }
            return parcelable.hashCode();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            parcel.writeParcelable(this.f5774b, i9);
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static Bundle b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        a(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }
}

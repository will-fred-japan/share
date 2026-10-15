package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    public static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i9, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.b(bundle);
            }
            if (i9 != 0 || bundle == null || !bundle.containsKey("media_item")) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable != null && !(parcelable instanceof MediaItem)) {
                throw null;
            }
            throw null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaDescriptionCompat f5757b;

        public class a implements Parcelable.Creator<MediaItem> {
            @Override // android.os.Parcelable.Creator
            public final MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final MediaItem[] newArray(int i9) {
                return new MediaItem[i9];
            }
        }

        public MediaItem(Parcel parcel) {
            this.f5756a = parcel.readInt();
            this.f5757b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "MediaItem{mFlags=" + this.f5756a + ", mDescription=" + this.f5757b + '}';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            parcel.writeInt(this.f5756a);
            this.f5757b.writeToParcel(parcel, i9);
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i9, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.b(bundle);
            }
            if (i9 != 0 || bundle == null || !bundle.containsKey("search_results")) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            parcelableArray.getClass();
            ArrayList arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            throw null;
        }
    }

    static {
        Log.isLoggable("MediaBrowserCompat", 3);
    }

    public static class CustomActionResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public final void a(int i9, Bundle bundle) {
        }
    }
}

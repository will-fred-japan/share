package cc.dd.dd.b0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SpPair.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8780b;

    /* JADX INFO: compiled from: SpPair.java */
    public static class a implements Parcelable.Creator<l> {
        @Override // android.os.Parcelable.Creator
        public final l createFromParcel(Parcel parcel) {
            l lVar = new l();
            lVar.f8779a = parcel.readString();
            lVar.f8780b = parcel.readValue(l.class.getClassLoader());
            return lVar;
        }

        @Override // android.os.Parcelable.Creator
        public final l[] newArray(int i9) {
            return new l[i9];
        }
    }

    public l(Object obj, String str) {
        this.f8779a = str;
        this.f8780b = obj;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8779a);
        parcel.writeValue(this.f8780b);
    }
}

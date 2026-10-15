package cc.dd.dd.aa;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SpPair.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8778b;

    /* JADX INFO: compiled from: SpPair.java */
    public class a implements Parcelable.Creator<g> {
        @Override // android.os.Parcelable.Creator
        public final g createFromParcel(Parcel parcel) {
            g gVar = new g();
            gVar.f8777a = parcel.readString();
            gVar.f8778b = parcel.readValue(g.class.getClassLoader());
            return gVar;
        }

        @Override // android.os.Parcelable.Creator
        public final g[] newArray(int i9) {
            return new g[i9];
        }
    }

    public g(Object obj, String str) {
        this.f8777a = str;
        this.f8778b = obj;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f8777a);
        parcel.writeValue(this.f8778b);
    }
}

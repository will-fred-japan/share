package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10397c;

    public p(Parcel parcel) {
        this.f10395a = parcel.readInt();
        this.f10396b = parcel.readString();
        this.f10397c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        return this.f10395a + Constants.COLON_SEPARATOR + this.f10396b + Constants.COLON_SEPARATOR + this.f10397c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f10395a);
        parcel.writeString(this.f10396b);
        parcel.writeString(this.f10397c);
    }

    public p(String str) {
        String[] strArrSplit = str.split(Constants.COLON_SEPARATOR);
        this.f10395a = Integer.parseInt(strArrSplit[0]);
        this.f10396b = strArrSplit[1];
        this.f10397c = strArrSplit[2];
    }
}

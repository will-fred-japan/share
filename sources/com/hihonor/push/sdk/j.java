package com.hihonor.push.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class j extends Exception implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14503b;

    public class a implements Parcelable.Creator<j> {
        @Override // android.os.Parcelable.Creator
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public j[] newArray(int i9) {
            return new j[i9];
        }
    }

    public j(int i9, String str) {
        a(i9, str);
    }

    public final void a(int i9, String str) {
        this.f14502a = i9;
        this.f14503b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f14503b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f14502a);
        parcel.writeString(this.f14503b);
    }

    public j(Parcel parcel) {
        this.f14502a = parcel.readInt();
        this.f14503b = parcel.readString();
    }
}

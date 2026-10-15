package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f14470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f14471c;

    public class a implements Parcelable.Creator<d> {
        @Override // android.os.Parcelable.Creator
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public d[] newArray(int i9) {
            return new d[i9];
        }
    }

    public d(Parcel parcel) {
        this.f14469a = parcel.readString();
        this.f14470b = parcel.readBundle(Bundle.class.getClassLoader());
        this.f14471c = parcel.readBundle(Bundle.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f14469a);
        parcel.writeBundle(this.f14470b);
        parcel.writeBundle(this.f14471c);
    }

    public d(String str, Bundle bundle, Bundle bundle2) {
        this.f14469a = str;
        this.f14470b = bundle;
        this.f14471c = bundle2;
    }
}

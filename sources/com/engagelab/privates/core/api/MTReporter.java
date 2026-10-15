package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.annotation.AllClass;

/* JADX INFO: loaded from: classes.dex */
@AllClass
public class MTReporter implements Parcelable {
    public static final Parcelable.Creator<MTReporter> CREATOR = new a();
    private String appkey;
    private String content;
    private String type;

    public static class a implements Parcelable.Creator<MTReporter> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MTReporter createFromParcel(Parcel parcel) {
            return new MTReporter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MTReporter[] newArray(int i9) {
            return new MTReporter[i9];
        }
    }

    public MTReporter() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public String getContent() {
        return this.content;
    }

    public String getType() {
        return this.type;
    }

    public MTReporter setAppkey(String str) {
        this.appkey = str;
        return this;
    }

    public MTReporter setContent(String str) {
        this.content = str;
        return this;
    }

    public MTReporter setType(String str) {
        this.type = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.type);
        parcel.writeString(this.content);
        parcel.writeString(this.appkey);
    }

    public MTReporter(Parcel parcel) {
        this.type = parcel.readString();
        this.content = parcel.readString();
        this.appkey = parcel.readString();
    }
}

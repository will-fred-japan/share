package com.engagelab.privates.common.sentry;

import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.annotation.AllClass;

/* JADX INFO: loaded from: classes.dex */
@AllClass
public class MTCommonReporter implements Parcelable {
    public static final Parcelable.Creator<MTCommonReporter> CREATOR = new a();
    private String content;
    private String type;

    public static class a implements Parcelable.Creator<MTCommonReporter> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MTCommonReporter createFromParcel(Parcel parcel) {
            return new MTCommonReporter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MTCommonReporter[] newArray(int i9) {
            return new MTCommonReporter[i9];
        }
    }

    public MTCommonReporter() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getType() {
        return this.type;
    }

    public MTCommonReporter setContent(String str) {
        this.content = str;
        return this;
    }

    public MTCommonReporter setType(String str) {
        this.type = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.type);
        parcel.writeString(this.content);
    }

    public MTCommonReporter(Parcel parcel) {
        this.type = parcel.readString();
        this.content = parcel.readString();
    }
}

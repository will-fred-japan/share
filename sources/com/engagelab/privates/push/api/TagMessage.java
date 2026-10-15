package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.annotation.AllClass;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@AllClass
public class TagMessage implements Parcelable {
    public static final Parcelable.Creator<TagMessage> CREATOR = new a();
    private int code;
    private String queryTag;
    private boolean queryTagValid;
    private int sequence;
    private String[] tags;

    public static class a implements Parcelable.Creator<TagMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TagMessage createFromParcel(Parcel parcel) {
            return new TagMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TagMessage[] newArray(int i9) {
            return new TagMessage[i9];
        }
    }

    public TagMessage() {
        this.sequence = 0;
        this.code = -1;
        this.tags = new String[0];
        this.queryTag = "";
        this.queryTagValid = false;
    }

    public static Parcelable.Creator<TagMessage> getCREATOR() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public String getQueryTag() {
        return this.queryTag;
    }

    public int getSequence() {
        return this.sequence;
    }

    public String[] getTags() {
        return this.tags;
    }

    public boolean isQueryTagValid() {
        return this.queryTagValid;
    }

    public TagMessage setCode(int i9) {
        this.code = i9;
        return this;
    }

    public TagMessage setQueryTag(String str) {
        this.queryTag = str;
        return this;
    }

    public TagMessage setQueryTagValid(boolean z8) {
        this.queryTagValid = z8;
        return this;
    }

    public TagMessage setSequence(int i9) {
        this.sequence = i9;
        return this;
    }

    public TagMessage setTags(String[] strArr) {
        this.tags = strArr;
        return this;
    }

    public String toString() {
        return "\n{\n  sequence=" + this.sequence + ",\n  code=" + this.code + ",\n  tag=" + Arrays.toString(this.tags) + ",\n  queryTag=" + this.queryTag + ",\n  queryTagValid=" + this.queryTagValid + "\n}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.sequence);
        parcel.writeInt(this.code);
        parcel.writeStringArray(this.tags);
        parcel.writeString(this.queryTag);
        parcel.writeByte(this.queryTagValid ? (byte) 1 : (byte) 0);
    }

    public TagMessage(Parcel parcel) {
        this.sequence = 0;
        this.code = -1;
        this.tags = new String[0];
        this.queryTag = "";
        this.queryTagValid = false;
        this.sequence = parcel.readInt();
        this.code = parcel.readInt();
        this.tags = parcel.createStringArray();
        this.queryTag = parcel.readString();
        this.queryTagValid = parcel.readByte() != 0;
    }
}

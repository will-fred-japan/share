package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.annotation.AllClass;

/* JADX INFO: loaded from: classes.dex */
@AllClass
public class AliasMessage implements Parcelable {
    public static final Parcelable.Creator<AliasMessage> CREATOR = new a();
    private String alias;
    private int code;
    private int sequence;

    public static class a implements Parcelable.Creator<AliasMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AliasMessage createFromParcel(Parcel parcel) {
            return new AliasMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AliasMessage[] newArray(int i9) {
            return new AliasMessage[i9];
        }
    }

    public AliasMessage() {
        this.sequence = 0;
        this.code = -1;
        this.alias = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.alias;
    }

    public int getCode() {
        return this.code;
    }

    public int getSequence() {
        return this.sequence;
    }

    public AliasMessage setAlias(String str) {
        this.alias = str;
        return this;
    }

    public AliasMessage setCode(int i9) {
        this.code = i9;
        return this;
    }

    public AliasMessage setSequence(int i9) {
        this.sequence = i9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n{\n  sequence=");
        sb.append(this.sequence);
        sb.append(",\n  code=");
        sb.append(this.code);
        sb.append(",\n  alias=");
        return A.a.j(sb, this.alias, "\n}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.sequence);
        parcel.writeInt(this.code);
        parcel.writeString(this.alias);
    }

    public AliasMessage(Parcel parcel) {
        this.sequence = 0;
        this.code = -1;
        this.alias = "";
        this.sequence = parcel.readInt();
        this.code = parcel.readInt();
        this.alias = parcel.readString();
    }
}

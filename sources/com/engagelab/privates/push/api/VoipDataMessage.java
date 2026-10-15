package com.engagelab.privates.push.api;

import A.f;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class VoipDataMessage implements Parcelable {
    public static final Parcelable.Creator<VoipDataMessage> CREATOR = new a();
    private String appkey;
    private String extraData;
    private String messageId;
    private byte platform;

    public static class a implements Parcelable.Creator<VoipDataMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VoipDataMessage createFromParcel(Parcel parcel) {
            return new VoipDataMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VoipDataMessage[] newArray(int i9) {
            return new VoipDataMessage[i9];
        }
    }

    public VoipDataMessage() {
        this.messageId = null;
        this.appkey = null;
        this.extraData = null;
        this.platform = (byte) 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public byte getPlatform() {
        return this.platform;
    }

    public VoipDataMessage setAppkey(String str) {
        this.appkey = str;
        return this;
    }

    public VoipDataMessage setExtraData(String str) {
        this.extraData = str;
        return this;
    }

    public VoipDataMessage setMessageId(String str) {
        this.messageId = str;
        return this;
    }

    public VoipDataMessage setPlatform(byte b9) {
        this.platform = b9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n{\n  messageId=");
        sb.append(this.messageId);
        sb.append(",\n  appkey=");
        sb.append(this.appkey);
        sb.append(",\n  extraData=");
        sb.append(this.extraData);
        sb.append(",\n  platform=");
        return f.i(sb, this.platform, "\n}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.messageId);
        parcel.writeString(this.appkey);
        parcel.writeString(this.extraData);
        parcel.writeByte(this.platform);
    }

    public VoipDataMessage(Parcel parcel) {
        this.messageId = null;
        this.appkey = null;
        this.extraData = null;
        this.platform = (byte) 0;
        this.messageId = parcel.readString();
        this.appkey = parcel.readString();
        this.extraData = parcel.readString();
        this.platform = parcel.readByte();
    }
}

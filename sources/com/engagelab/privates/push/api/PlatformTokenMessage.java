package com.engagelab.privates.push.api;

import A.f;
import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.annotation.AllClass;

/* JADX INFO: loaded from: classes.dex */
@AllClass
public class PlatformTokenMessage implements Parcelable {
    public static final Parcelable.Creator<PlatformTokenMessage> CREATOR = new a();
    private int isUserSettings;
    private byte platform;
    private String region;
    private String token;
    private int voipStatus;

    public static class a implements Parcelable.Creator<PlatformTokenMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlatformTokenMessage createFromParcel(Parcel parcel) {
            return new PlatformTokenMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlatformTokenMessage[] newArray(int i9) {
            return new PlatformTokenMessage[i9];
        }
    }

    public PlatformTokenMessage() {
        this.isUserSettings = 0;
        this.region = "NULL";
        this.voipStatus = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getIsUserSettings() {
        return this.isUserSettings != 0;
    }

    public byte getPlatform() {
        return this.platform;
    }

    public String getRegion() {
        return this.region;
    }

    public String getToken() {
        return this.token;
    }

    public int getVoipStatus() {
        return this.voipStatus;
    }

    public PlatformTokenMessage setIsUserSettings(boolean z8) {
        if (z8) {
            this.isUserSettings = 1;
            return this;
        }
        this.isUserSettings = 0;
        return this;
    }

    public PlatformTokenMessage setPlatform(byte b9) {
        this.platform = b9;
        return this;
    }

    public PlatformTokenMessage setRegion(String str) {
        this.region = str;
        return this;
    }

    public PlatformTokenMessage setToken(String str) {
        this.token = str;
        return this;
    }

    public PlatformTokenMessage setVoipStatus(int i9) {
        this.voipStatus = i9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n{\n  platform=");
        sb.append((int) this.platform);
        sb.append(",\n  token=");
        sb.append(this.token);
        sb.append("\n  region=");
        sb.append(this.region);
        sb.append("\n  isUserSettings=");
        sb.append(getIsUserSettings());
        sb.append(",\n  voipStatus=");
        return f.i(sb, this.voipStatus, "\n}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeByte(this.platform);
        parcel.writeString(this.token);
        parcel.writeString(this.region);
        parcel.writeInt(this.isUserSettings);
        parcel.writeInt(this.voipStatus);
    }

    public PlatformTokenMessage(Parcel parcel) {
        this.isUserSettings = 0;
        this.region = "NULL";
        this.voipStatus = 0;
        this.platform = parcel.readByte();
        this.token = parcel.readString();
        this.region = parcel.readString();
        this.isUserSettings = parcel.readInt();
        this.voipStatus = parcel.readInt();
    }
}

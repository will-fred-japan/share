package com.hihonor.push.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class RemoteNotificationInfo implements Parcelable {
    public static final Parcelable.Creator<RemoteNotificationInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f14441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f14445i;
    public long j;

    public class a implements Parcelable.Creator<RemoteNotificationInfo> {
        @Override // android.os.Parcelable.Creator
        public RemoteNotificationInfo createFromParcel(Parcel parcel) {
            return new RemoteNotificationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RemoteNotificationInfo[] newArray(int i9) {
            return new RemoteNotificationInfo[i9];
        }
    }

    public RemoteNotificationInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBody() {
        return this.f14440d;
    }

    public int getClickType() {
        return this.f14443g;
    }

    public String getClickUrl() {
        return this.f14444h;
    }

    public long getExtDecTo() {
        return this.j;
    }

    public String getExtraData() {
        return this.f14445i;
    }

    public String getImage() {
        return this.f14441e;
    }

    public long getMsgId() {
        return this.f14438b;
    }

    public long getNotifyId() {
        return this.f14442f;
    }

    public String getTitle() {
        return this.f14439c;
    }

    public int getType() {
        return this.f14437a;
    }

    public void setBody(String str) {
        this.f14440d = str;
    }

    public void setClickType(int i9) {
        this.f14443g = i9;
    }

    public void setClickUrl(String str) {
        this.f14444h = str;
    }

    public void setExtDecTo(long j) {
        this.j = j;
    }

    public void setExtraData(String str) {
        this.f14445i = str;
    }

    public void setImage(String str) {
        this.f14441e = str;
    }

    public void setMsgId(long j) {
        this.f14438b = j;
    }

    public void setNotifyId(long j) {
        this.f14442f = j;
    }

    public void setTitle(String str) {
        this.f14439c = str;
    }

    public void setType(int i9) {
        this.f14437a = i9;
    }

    public String toString() {
        return "RemoteNotificationInfo{body='" + this.f14440d + "', type=" + this.f14437a + ", msgId=" + this.f14438b + ", title='" + this.f14439c + "', image='" + this.f14441e + "', notifyId=" + this.f14442f + ", clickType=" + this.f14443g + ", clickUrl='" + this.f14444h + "', extraData='" + this.f14445i + "', extDecTo=" + this.j + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f14437a);
        parcel.writeLong(this.f14438b);
        parcel.writeString(this.f14439c);
        parcel.writeString(this.f14440d);
        parcel.writeString(this.f14441e);
        parcel.writeLong(this.f14442f);
        parcel.writeInt(this.f14443g);
        parcel.writeString(this.f14444h);
        parcel.writeString(this.f14445i);
        parcel.writeLong(this.j);
    }

    public RemoteNotificationInfo(Parcel parcel) {
        this.f14437a = parcel.readInt();
        this.f14438b = parcel.readLong();
        this.f14439c = parcel.readString();
        this.f14440d = parcel.readString();
        this.f14441e = parcel.readString();
        this.f14442f = parcel.readLong();
        this.f14443g = parcel.readInt();
        this.f14444h = parcel.readString();
        this.f14445i = parcel.readString();
        this.j = parcel.readLong();
    }
}

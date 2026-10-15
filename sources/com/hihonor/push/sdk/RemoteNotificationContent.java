package com.hihonor.push.sdk;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class RemoteNotificationContent implements Parcelable {
    public static final Parcelable.Creator<RemoteNotificationContent> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f14432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14436h;

    public class a implements Parcelable.Creator<RemoteNotificationContent> {
        @Override // android.os.Parcelable.Creator
        public RemoteNotificationContent createFromParcel(Parcel parcel) {
            return new RemoteNotificationContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RemoteNotificationContent[] newArray(int i9) {
            return new RemoteNotificationContent[i9];
        }
    }

    public RemoteNotificationContent() {
        this.f14429a = true;
        this.f14433e = -1;
        this.f14434f = -1;
        this.f14435g = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBadgeNum() {
        return this.f14434f;
    }

    public int getBadgeOperateType() {
        return this.f14433e;
    }

    public String getBody() {
        return this.f14431c;
    }

    public int getClickType() {
        return this.f14435g;
    }

    public String getClickUrl() {
        return this.f14436h;
    }

    public Bitmap getImage() {
        return this.f14432d;
    }

    public String getTitle() {
        return this.f14430b;
    }

    public boolean isShowNotification() {
        return this.f14429a;
    }

    public void setBadgeNum(int i9) {
        this.f14434f = i9;
    }

    public void setBadgeOperateType(int i9) {
        this.f14433e = i9;
    }

    public void setBody(String str) {
        this.f14431c = str;
    }

    public void setClickType(int i9) {
        this.f14435g = i9;
    }

    public void setClickUrl(String str) {
        this.f14436h = str;
    }

    public int setImage(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.getHeight() * bitmap.getWidth() > 49152) {
                return -1;
            }
        }
        this.f14432d = bitmap;
        return 0;
    }

    public void setIsShowNotification(boolean z8) {
        this.f14429a = z8;
    }

    public void setTitle(String str) {
        this.f14430b = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RemoteNotificationContent{badgeNum=");
        sb.append(this.f14434f);
        sb.append(", isShowNotification=");
        sb.append(this.f14429a);
        sb.append(", title='");
        sb.append(this.f14430b);
        sb.append("', body='");
        sb.append(this.f14431c);
        sb.append("', image=");
        sb.append(this.f14432d);
        sb.append(", badgeOperateType=");
        sb.append(this.f14433e);
        sb.append(", clickType=");
        sb.append(this.f14435g);
        sb.append(", clickUrl='");
        return A.a.j(sb, this.f14436h, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeByte(this.f14429a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f14430b);
        parcel.writeString(this.f14431c);
        parcel.writeParcelable(this.f14432d, i9);
        parcel.writeInt(this.f14433e);
        parcel.writeInt(this.f14434f);
        parcel.writeInt(this.f14435g);
        parcel.writeString(this.f14436h);
    }

    public RemoteNotificationContent(Parcel parcel) {
        this.f14429a = true;
        this.f14433e = -1;
        this.f14434f = -1;
        this.f14435g = -1;
        this.f14429a = parcel.readByte() != 0;
        this.f14430b = parcel.readString();
        this.f14431c = parcel.readString();
        this.f14432d = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f14433e = parcel.readInt();
        this.f14434f = parcel.readInt();
        this.f14435g = parcel.readInt();
        this.f14436h = parcel.readString();
    }
}

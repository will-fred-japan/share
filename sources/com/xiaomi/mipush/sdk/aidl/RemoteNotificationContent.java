package com.xiaomi.mipush.sdk.aidl;

import A.f;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class RemoteNotificationContent implements Parcelable {
    public static final Parcelable.Creator<RemoteNotificationContent> CREATOR = new Parcelable.Creator<RemoteNotificationContent>() { // from class: com.xiaomi.mipush.sdk.aidl.RemoteNotificationContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteNotificationContent createFromParcel(Parcel parcel) {
            return new RemoteNotificationContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteNotificationContent[] newArray(int i9) {
            return new RemoteNotificationContent[i9];
        }
    };
    private Bitmap mImage;
    private boolean mIsShowNotification = true;
    private String mTitle = "";
    private String mBody = "";
    private int mBadgeOperateType = -1;
    private int mBadgeNum = -1;
    private int mClickType = -1;
    private String mClickUrl = "";

    public RemoteNotificationContent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBadgeNum() {
        return this.mBadgeNum;
    }

    public int getBadgeOperateType() {
        return this.mBadgeOperateType;
    }

    public String getBody() {
        return this.mBody;
    }

    public int getClickType() {
        return this.mClickType;
    }

    public String getClickUrl() {
        return this.mClickUrl;
    }

    public Bitmap getImage() {
        return this.mImage;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isIsShowNotification() {
        return this.mIsShowNotification;
    }

    public void readFromParcel(Parcel parcel) {
        this.mIsShowNotification = parcel.readByte() != 0;
        this.mTitle = parcel.readString();
        this.mBody = parcel.readString();
        this.mImage = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mBadgeOperateType = parcel.readInt();
        this.mBadgeNum = parcel.readInt();
        this.mClickType = parcel.readInt();
        this.mClickUrl = parcel.readString();
    }

    public void setBadgeNum(int i9) {
        this.mBadgeNum = i9;
    }

    public void setBadgeOperateType(int i9) {
        this.mBadgeOperateType = i9;
    }

    public void setBody(String str) {
        this.mBody = str;
    }

    public void setClickType(int i9) {
        this.mClickType = i9;
    }

    public void setClickUrl(String str) {
        this.mClickUrl = str;
    }

    public int setImage(Bitmap bitmap) {
        if (bitmap == null || ((long) bitmap.getWidth()) * ((long) bitmap.getHeight()) >= 49152) {
            return -1;
        }
        this.mImage = bitmap;
        return 0;
    }

    public void setIsShowNotification(boolean z8) {
        this.mIsShowNotification = z8;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RemoteNotificationContent[mIsShowNotification:");
        sb.append(this.mIsShowNotification);
        sb.append(",mTitle:");
        sb.append(this.mTitle);
        sb.append(",mBody:");
        sb.append(this.mBody);
        sb.append(",mImage:");
        sb.append(this.mImage);
        sb.append(",mBadgeOperateType:");
        sb.append(this.mBadgeOperateType);
        sb.append(",mClickType:");
        sb.append(this.mClickType);
        sb.append(",mClickUrl:");
        sb.append(this.mClickUrl);
        sb.append(",mBadgeNum:");
        return f.i(sb, this.mBadgeNum, "]");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeByte(this.mIsShowNotification ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mBody);
        parcel.writeParcelable(this.mImage, i9);
        parcel.writeInt(this.mBadgeOperateType);
        parcel.writeInt(this.mBadgeNum);
        parcel.writeInt(this.mClickType);
        parcel.writeString(this.mClickUrl);
    }

    public RemoteNotificationContent(Parcel parcel) {
        readFromParcel(parcel);
    }
}

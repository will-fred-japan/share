package com.xiaomi.mipush.sdk.aidl;

import A.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.push.iq;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RemoteNotificationInfo implements Parcelable {
    public static final Parcelable.Creator<RemoteNotificationInfo> CREATOR = new Parcelable.Creator<RemoteNotificationInfo>() { // from class: com.xiaomi.mipush.sdk.aidl.RemoteNotificationInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteNotificationInfo createFromParcel(Parcel parcel) {
            return new RemoteNotificationInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteNotificationInfo[] newArray(int i9) {
            return new RemoteNotificationInfo[i9];
        }
    };
    private String mBody;
    private int mClickType;
    private String mClickUrl;
    private String mExtraData;
    private String mImage;
    private String mMsgId;
    private long mNotifyId;
    private String mTitle;
    private String mToken;
    private int mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public String getExtraData() {
        return this.mExtraData;
    }

    public String getImage() {
        return this.mImage;
    }

    public String getMsgId() {
        return this.mMsgId;
    }

    public long getNotifyId() {
        return this.mNotifyId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getToken() {
        return this.mToken;
    }

    public int getType() {
        return this.mType;
    }

    public void readFromParcel(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mToken = parcel.readString();
        this.mTitle = parcel.readString();
        this.mBody = parcel.readString();
        this.mImage = parcel.readString();
        this.mNotifyId = parcel.readLong();
        this.mClickType = parcel.readInt();
        this.mClickUrl = parcel.readString();
        this.mExtraData = parcel.readString();
        this.mMsgId = parcel.readString();
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

    public void setExtraData(String str) {
        this.mExtraData = str;
    }

    public void setImage(String str) {
        this.mImage = str;
    }

    public void setMsgId(String str) {
        this.mMsgId = str;
    }

    public void setNotifyId(long j) {
        this.mNotifyId = j;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setType(int i9) {
        this.mType = i9;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RemoteNotificationInfo[mType:");
        sb.append(this.mType);
        sb.append(",mToken:");
        sb.append(this.mToken);
        sb.append(",mTitle:");
        sb.append(this.mTitle);
        sb.append(",mBody:");
        sb.append(this.mBody);
        sb.append(",mImage:");
        sb.append(this.mImage);
        sb.append(",mNotifyId:");
        sb.append(this.mNotifyId);
        sb.append(",mClickType:");
        sb.append(this.mClickType);
        sb.append(",mClickUrl:");
        sb.append(this.mClickUrl);
        sb.append(",mExtraData:");
        sb.append(this.mExtraData);
        sb.append(",mMsgId:");
        return a.j(sb, this.mMsgId, "]");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.mType);
        parcel.writeString(this.mToken);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mBody);
        parcel.writeString(this.mImage);
        parcel.writeLong(this.mNotifyId);
        parcel.writeInt(this.mClickType);
        parcel.writeString(this.mClickUrl);
        parcel.writeString(this.mExtraData);
        parcel.writeString(this.mMsgId);
    }

    private RemoteNotificationInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public RemoteNotificationInfo(iq iqVar) {
        Map<String, String> mapM519a;
        if (iqVar.m552a() == null || (mapM519a = iqVar.m552a().m519a()) == null) {
            return;
        }
        this.mTitle = iqVar.m552a().m526c();
        this.mBody = iqVar.m552a().d();
        this.mToken = mapM519a.get("_target_name");
        this.mNotifyId = iqVar.m552a().c();
        this.mMsgId = iqVar.m552a().m518a();
        String str = mapM519a.get("notification_large_icon_uri");
        this.mImage = TextUtils.isEmpty(str) ? mapM519a.get("notification_bigPic_uri") : str;
        this.mExtraData = mapM519a.get("hyper_crypt");
        String str2 = mapM519a.get("hyper_click_type");
        if (str2 != null && TextUtils.isDigitsOnly(str2)) {
            this.mClickType = Integer.parseInt(str2);
        }
        int i9 = this.mClickType;
        if (i9 == 1) {
            this.mClickUrl = mapM519a.get("intent_uri");
        } else {
            if (i9 != 2) {
                return;
            }
            this.mClickUrl = mapM519a.get("web_uri");
        }
    }
}

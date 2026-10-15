package com.vivo.push.model;

/* JADX INFO: loaded from: classes.dex */
public class RemoteNotificationInfo {
    private String mBody;
    private int mClickType;
    private String mClickUrl;
    private String mExtraData;
    private String mImage;
    private long mMsgId;
    private long mNotifyId;
    private String mTitle;
    private String mToken;
    private int mType;

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

    public long getMsgId() {
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

    public void setMsgId(long j) {
        this.mMsgId = j;
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
        return "RemoteNotificationInfo{mType=" + this.mType + ", mToken='" + this.mToken + "', mTitle='" + this.mTitle + "', mBody='" + this.mBody + "', mImage='" + this.mImage + "', mNotifyId=" + this.mNotifyId + ", mClickType=" + this.mClickType + ", mClickUrl='" + this.mClickUrl + "', mExtraData='" + this.mExtraData + "', mMsgId=" + this.mMsgId + '}';
    }
}

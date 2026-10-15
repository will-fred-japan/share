package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.annotation.AllClass;
import defpackage.f;

/* JADX INFO: loaded from: classes.dex */
@AllClass
public class InAppMessage implements Parcelable {
    public static final Parcelable.Creator<InAppMessage> CREATOR = new a();
    private String appkey;
    private String click;
    private String content;
    private long delay;
    private long duration;
    private long expired;
    private String extras;
    private String imageUrl;
    private long interval;
    private boolean isNotification;
    private String localImageUrl;
    private String messageId;
    private long msgTime;
    private int priority;
    private String target;
    private String targetEvent;
    private int type;

    public static class a implements Parcelable.Creator<InAppMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InAppMessage createFromParcel(Parcel parcel) {
            return new InAppMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InAppMessage[] newArray(int i9) {
            return new InAppMessage[i9];
        }
    }

    public InAppMessage() {
        this.isNotification = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public String getClick() {
        return this.click;
    }

    public String getContent() {
        return this.content;
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getExpired() {
        return this.expired;
    }

    public String getExtras() {
        return this.extras;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public long getInterval() {
        return this.interval;
    }

    public String getLocalImageUrl() {
        return this.localImageUrl;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getTarget() {
        return this.target;
    }

    public String getTargetEvent() {
        return this.targetEvent;
    }

    public int getType() {
        return this.type;
    }

    public boolean isNotification() {
        return this.isNotification;
    }

    public InAppMessage setAppkey(String str) {
        this.appkey = str;
        return this;
    }

    public InAppMessage setClick(String str) {
        this.click = str;
        return this;
    }

    public InAppMessage setContent(String str) {
        this.content = str;
        return this;
    }

    public InAppMessage setDelay(long j) {
        this.delay = j;
        return this;
    }

    public InAppMessage setDuration(long j) {
        this.duration = j;
        return this;
    }

    public InAppMessage setExpired(long j) {
        this.expired = j;
        return this;
    }

    public InAppMessage setExtras(String str) {
        this.extras = str;
        return this;
    }

    public InAppMessage setImageUrl(String str) {
        this.imageUrl = str;
        return this;
    }

    public InAppMessage setInterval(long j) {
        this.interval = j;
        return this;
    }

    public InAppMessage setIsNotification(boolean z8) {
        this.isNotification = z8;
        return this;
    }

    public InAppMessage setLocalImageUrl(String str) {
        this.localImageUrl = str;
        return this;
    }

    public InAppMessage setMessageId(String str) {
        this.messageId = str;
        return this;
    }

    public InAppMessage setMsgTime(long j) {
        this.msgTime = j;
        return this;
    }

    public InAppMessage setPriority(int i9) {
        this.priority = i9;
        return this;
    }

    public InAppMessage setTarget(String str) {
        this.target = str;
        return this;
    }

    public InAppMessage setTargetEvent(String str) {
        this.targetEvent = str;
        return this;
    }

    public InAppMessage setType(int i9) {
        this.type = i9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InAppMessage{messageId='");
        sb.append(this.messageId);
        sb.append("', appkey='");
        sb.append(this.appkey);
        sb.append("', target='");
        sb.append(this.target);
        sb.append("', targetEvent='");
        sb.append(this.targetEvent);
        sb.append("', imageUrl='");
        sb.append(this.imageUrl);
        sb.append("', click='");
        sb.append(this.click);
        sb.append("', extras='");
        sb.append(this.extras);
        sb.append("', content='");
        sb.append(this.content);
        sb.append("', expired=");
        sb.append(this.expired);
        sb.append(", delay=");
        sb.append(this.delay);
        sb.append(", interval=");
        sb.append(this.interval);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", msgTime=");
        sb.append(this.msgTime);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", priority=");
        sb.append(this.priority);
        sb.append(", isNotification=");
        return f.g(sb, this.isNotification, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.appkey);
        parcel.writeString(this.messageId);
        parcel.writeString(this.target);
        parcel.writeString(this.targetEvent);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.localImageUrl);
        parcel.writeString(this.click);
        parcel.writeString(this.extras);
        parcel.writeString(this.content);
        parcel.writeLong(this.expired);
        parcel.writeLong(this.delay);
        parcel.writeLong(this.interval);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.msgTime);
        parcel.writeInt(this.type);
        parcel.writeInt(this.priority);
        parcel.writeInt(this.isNotification ? 1 : 0);
    }

    public InAppMessage(Parcel parcel) {
        this.isNotification = false;
        this.appkey = parcel.readString();
        this.messageId = parcel.readString();
        this.target = parcel.readString();
        this.targetEvent = parcel.readString();
        this.imageUrl = parcel.readString();
        this.localImageUrl = parcel.readString();
        this.click = parcel.readString();
        this.extras = parcel.readString();
        this.content = parcel.readString();
        this.expired = parcel.readLong();
        this.delay = parcel.readLong();
        this.interval = parcel.readLong();
        this.duration = parcel.readLong();
        this.msgTime = parcel.readLong();
        this.type = parcel.readInt();
        this.priority = parcel.readInt();
        this.isNotification = parcel.readInt() != 0;
    }
}

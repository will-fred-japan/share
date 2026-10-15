package cn.jpush.android.api;

import H2.a;

/* JADX INFO: loaded from: classes.dex */
public class VoipDataMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f11221c;

    public VoipDataMessage() {
    }

    public String getExtraData() {
        return this.f11220b;
    }

    public String getMessageId() {
        return this.f11219a;
    }

    public byte getPlatform() {
        return this.f11221c;
    }

    public void setExtraData(String str) {
        this.f11220b = str;
    }

    public void setMessageId(String str) {
        this.f11219a = str;
    }

    public void setPlatform(byte b9) {
        this.f11221c = b9;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VoipDataMessage{messageId='");
        sb.append(this.f11219a);
        sb.append("', extraData='");
        sb.append(this.f11220b);
        sb.append("', platform=");
        return a.a(sb, this.f11221c, '}');
    }

    public VoipDataMessage(String str, String str2, String str3) {
        this.f11219a = str;
        this.f11220b = str3;
    }
}

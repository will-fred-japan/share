package com.heytap.mcs.liquid.model;

import A.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ActionInfo implements Parcelable {
    public static final Parcelable.Creator<ActionInfo> CREATOR = new Parcelable.Creator<ActionInfo>() { // from class: com.heytap.mcs.liquid.model.ActionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionInfo createFromParcel(Parcel parcel) {
            return new ActionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionInfo[] newArray(int i9) {
            return new ActionInfo[i9];
        }
    };
    public static final int TYPE_ACTION = 1;
    public static final int TYPE_ACTIVITY = 4;
    public static final int TYPE_BROWSER = 2;
    public static final int TYPE_DEEPLINK = 5;
    public static final int TYPE_INTENT_SCHEMA = 20;
    public static final int TYPE_LAUNCH = 0;
    private String actionActivity;
    private String actionParams;
    private String actionUrl;
    private int clickType;
    private String targetPkgName;

    public ActionInfo(int i9, String str, String str2, String str3, String str4) {
        this.clickType = i9;
        this.actionActivity = str;
        this.actionUrl = str2;
        this.actionParams = str3;
        this.targetPkgName = str4;
    }

    public static ActionInfo parseFromJsonStr(String str) {
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActionActivity() {
        return this.actionActivity;
    }

    public String getActionParams() {
        return this.actionParams;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public int getClickType() {
        return this.clickType;
    }

    public String getTargetPkgName() {
        return this.targetPkgName;
    }

    public String jsonString() {
        return toString();
    }

    public void setActionActivity(String str) {
        this.actionActivity = str;
    }

    public void setActionParams(String str) {
        this.actionParams = str;
    }

    public void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public void setClickType(int i9) {
        this.clickType = i9;
    }

    public void setTargetPkgName(String str) {
        this.targetPkgName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ActionInfo{clickType=");
        sb.append(this.clickType);
        sb.append(", actionActivity='");
        sb.append(this.actionActivity);
        sb.append("', actionUrl='");
        sb.append(this.actionUrl);
        sb.append("', actionParams='");
        sb.append(this.actionParams);
        sb.append("', targetPkgName='");
        return a.j(sb, this.targetPkgName, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.clickType);
        parcel.writeString(this.actionActivity);
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.actionParams);
        parcel.writeString(this.targetPkgName);
    }

    public ActionInfo(Parcel parcel) {
        this.clickType = parcel.readInt();
        this.actionActivity = parcel.readString();
        this.actionUrl = parcel.readString();
        this.actionParams = parcel.readString();
        this.targetPkgName = parcel.readString();
    }
}

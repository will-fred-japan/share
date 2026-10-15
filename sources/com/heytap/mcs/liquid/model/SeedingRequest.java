package com.heytap.mcs.liquid.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.mcs.liquid.service.download.result.ILiquidCallback;

/* JADX INFO: loaded from: classes.dex */
public class SeedingRequest implements Parcelable {
    public static final Parcelable.Creator<SeedingRequest> CREATOR = new Parcelable.Creator<SeedingRequest>() { // from class: com.heytap.mcs.liquid.model.SeedingRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeedingRequest createFromParcel(Parcel parcel) {
            return new SeedingRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeedingRequest[] newArray(int i9) {
            return new SeedingRequest[i9];
        }
    };
    private ActionInfo action;
    private ILiquidCallback callback;
    private String callerPackageName;
    private String desc;
    private int loadingType;
    private ActionInfo managerAction;
    private int percent;
    private String requestId;
    private int status;
    private String targetName;
    private String token;
    private String traceId;

    public SeedingRequest() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActionInfo getAction() {
        return this.action;
    }

    public ILiquidCallback getCallback() {
        return this.callback;
    }

    public String getCallerPackageName() {
        return this.callerPackageName;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getLoadingType() {
        return this.loadingType;
    }

    public ActionInfo getManagerAction() {
        return this.managerAction;
    }

    public int getPercent() {
        return this.percent;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTargetName() {
        return this.targetName;
    }

    public String getToken() {
        return this.token;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setAction(ActionInfo actionInfo) {
        this.action = actionInfo;
    }

    public void setCallback(ILiquidCallback iLiquidCallback) {
        this.callback = iLiquidCallback;
    }

    public void setCallerPackageName(String str) {
        this.callerPackageName = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setLoadingType(int i9) {
        this.loadingType = i9;
    }

    public void setManagerAction(ActionInfo actionInfo) {
        this.managerAction = actionInfo;
    }

    public void setPercent(int i9) {
        this.percent = i9;
    }

    public void setStatus(int i9) {
        this.status = i9;
    }

    public void setTargetName(String str) {
        this.targetName = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.requestId);
        parcel.writeString(this.callerPackageName);
        parcel.writeInt(this.loadingType);
        parcel.writeString(this.targetName);
        parcel.writeString(this.traceId);
        parcel.writeString(this.token);
        parcel.writeInt(this.status);
        parcel.writeString(this.desc);
        parcel.writeParcelable(this.action, i9);
        parcel.writeParcelable(this.managerAction, i9);
        parcel.writeInt(this.percent);
        ILiquidCallback iLiquidCallback = this.callback;
        parcel.writeStrongBinder(iLiquidCallback != null ? iLiquidCallback.asBinder() : null);
    }

    public SeedingRequest(Parcel parcel) {
        this.requestId = parcel.readString();
        this.callerPackageName = parcel.readString();
        this.loadingType = parcel.readInt();
        this.targetName = parcel.readString();
        this.traceId = parcel.readString();
        this.token = parcel.readString();
        this.status = parcel.readInt();
        this.desc = parcel.readString();
        this.action = (ActionInfo) parcel.readParcelable(ActionInfo.class.getClassLoader());
        this.managerAction = (ActionInfo) parcel.readParcelable(ActionInfo.class.getClassLoader());
        this.percent = parcel.readInt();
        this.callback = ILiquidCallback.Stub.asInterface(parcel.readStrongBinder());
    }

    public SeedingRequest(String str, String str2, int i9, String str3, String str4, String str5, int i10, String str6, ActionInfo actionInfo, ActionInfo actionInfo2, int i11, ILiquidCallback iLiquidCallback) {
        this.requestId = str;
        this.callerPackageName = str2;
        this.loadingType = i9;
        this.targetName = str3;
        this.traceId = str4;
        this.token = str5;
        this.status = i10;
        this.desc = str6;
        this.action = actionInfo;
        this.managerAction = actionInfo2;
        this.percent = i11;
        this.callback = iLiquidCallback;
    }
}

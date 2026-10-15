package com.heytap.mcs.liquid.model;

import H2.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SeedingRequestResult implements Parcelable {
    public static final Parcelable.Creator<SeedingRequestResult> CREATOR = new Parcelable.Creator<SeedingRequestResult>() { // from class: com.heytap.mcs.liquid.model.SeedingRequestResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeedingRequestResult createFromParcel(Parcel parcel) {
            return new SeedingRequestResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SeedingRequestResult[] newArray(int i9) {
            return new SeedingRequestResult[i9];
        }
    };
    private int currentStatus;
    private boolean isSuccess;
    private String requestId;
    private String traceId;
    private int verifyStatus;

    public SeedingRequestResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentStatus() {
        return this.currentStatus;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public int getVerifyStatus() {
        return this.verifyStatus;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setCurrentStatus(int i9) {
        this.currentStatus = i9;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSuccess(boolean z8) {
        this.isSuccess = z8;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setVerifyStatus(int i9) {
        this.verifyStatus = i9;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SeedingRequestResult{isSuccess=");
        sb.append(this.isSuccess);
        sb.append(", requestId='");
        sb.append(this.requestId);
        sb.append("', traceId='");
        sb.append(this.traceId);
        sb.append("', currentStatus=");
        sb.append(this.currentStatus);
        sb.append(", verifyStatus=");
        return a.a(sb, this.verifyStatus, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeByte(this.isSuccess ? (byte) 1 : (byte) 0);
        parcel.writeString(this.requestId);
        parcel.writeString(this.traceId);
        parcel.writeInt(this.currentStatus);
        parcel.writeInt(this.verifyStatus);
    }

    public SeedingRequestResult(Parcel parcel) {
        this.isSuccess = parcel.readByte() != 0;
        this.requestId = parcel.readString();
        this.traceId = parcel.readString();
        this.currentStatus = parcel.readInt();
        this.verifyStatus = parcel.readInt();
    }

    public SeedingRequestResult(boolean z8, String str, String str2, int i9, int i10) {
        this.isSuccess = z8;
        this.requestId = str;
        this.traceId = str2;
        this.currentStatus = i9;
        this.verifyStatus = i10;
    }
}

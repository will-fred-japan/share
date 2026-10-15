package com.heytap.mcs.liquid.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ActionResult implements Parcelable {
    public static final Parcelable.Creator<ActionResult> CREATOR = new Parcelable.Creator<ActionResult>() { // from class: com.heytap.mcs.liquid.model.ActionResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionResult createFromParcel(Parcel parcel) {
            return new ActionResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionResult[] newArray(int i9) {
            return new ActionResult[i9];
        }
    };
    private int currentStatus;

    public ActionResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.currentStatus);
    }

    public ActionResult(int i9) {
        this.currentStatus = i9;
    }

    public ActionResult(Parcel parcel) {
        this.currentStatus = parcel.readInt();
    }
}

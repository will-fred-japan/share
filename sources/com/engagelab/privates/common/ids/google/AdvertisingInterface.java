package com.engagelab.privates.common.ids.google;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.engagelab.privates.common.ids.GuardConstant;
import com.engagelab.privates.common.log.MTCommonLog;

/* JADX INFO: loaded from: classes.dex */
public class AdvertisingInterface implements IInterface {
    private static final String TAG = "AdvertisingInterface";
    private IBinder binder;
    private String mClsName;

    public AdvertisingInterface(IBinder iBinder) {
        this.mClsName = "";
        this.binder = iBinder;
        this.mClsName = GuardConstant.COM_GOOGLE_ANDROID_GMS_ADS_IDENTIFIER_INTERNAL_IADVERTISINGIDSERVICE;
    }

    public static boolean hasGAIDPermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if ("com.google.android.gms.permission.AD_ID".equals(str)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e9) {
            e9.printStackTrace();
        }
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    public String getId() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.mClsName);
            this.binder.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable th) {
            try {
                MTCommonLog.w(TAG, "getId error: " + th.getMessage());
                string = "";
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
        return string;
    }

    public boolean isLimitAdTrackingEnabled(boolean z8) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.mClsName);
            parcelObtain.writeInt(z8 ? 1 : 0);
            this.binder.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            boolean z9 = parcelObtain2.readInt() != 0;
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return z9;
        } catch (Throwable th) {
            try {
                MTCommonLog.w(TAG, "isLimitAdTrackingEnabled error: " + th.getMessage());
                return false;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}

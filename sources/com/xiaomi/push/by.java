package com.xiaomi.push;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface by extends IInterface {
    void a(Bundle bundle, bz bzVar);

    public static abstract class a extends Binder implements by {
        public a() {
            attachInterface(this, "com.xiaomi.market.IUploadThirdLogService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 != 1) {
                if (i9 != 1598968902) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                parcel2.writeString("com.xiaomi.market.IUploadThirdLogService");
                return true;
            }
            parcel.enforceInterface("com.xiaomi.market.IUploadThirdLogService");
            a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, bz.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}

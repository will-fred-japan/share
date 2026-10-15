package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface IAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLCallback";

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void b(Parcel parcel, T t, int i9) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i9);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    void call(DataBuffer dataBuffer);

    public static abstract class Stub extends Binder implements IAIDLCallback {
        static final int TRANSACTION_call = 1;

        public static class a implements IAIDLCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f14998a;

            public a(IBinder iBinder) {
                this.f14998a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14998a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLCallback
            public void call(DataBuffer dataBuffer) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIDLCallback.DESCRIPTOR);
                    a.b(parcelObtain, dataBuffer, 0);
                    this.f14998a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLCallback.DESCRIPTOR);
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAIDLCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAIDLCallback)) ? new a(iBinder) : (IAIDLCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(IAIDLCallback.DESCRIPTOR);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(IAIDLCallback.DESCRIPTOR);
                return true;
            }
            if (i9 != 1) {
                return super.onTransact(i9, parcel, parcel2, i10);
            }
            call((DataBuffer) a.b(parcel, DataBuffer.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}

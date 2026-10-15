package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface IAIDLInvoke extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLInvoke";

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

    void asyncCall(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback);

    void syncCall(DataBuffer dataBuffer);

    public static abstract class Stub extends Binder implements IAIDLInvoke {

        public static class a implements IAIDLInvoke {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f14999a;

            public a(IBinder iBinder) {
                this.f14999a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14999a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void asyncCall(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIDLInvoke.DESCRIPTOR);
                    a.b(parcelObtain, dataBuffer, 0);
                    parcelObtain.writeStrongInterface(iAIDLCallback);
                    this.f14999a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void syncCall(DataBuffer dataBuffer) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIDLInvoke.DESCRIPTOR);
                    a.b(parcelObtain, dataBuffer, 0);
                    this.f14999a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLInvoke.DESCRIPTOR);
        }

        public static IAIDLInvoke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAIDLInvoke.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAIDLInvoke)) ? new a(iBinder) : (IAIDLInvoke) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(IAIDLInvoke.DESCRIPTOR);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(IAIDLInvoke.DESCRIPTOR);
                return true;
            }
            if (i9 == 1) {
                syncCall((DataBuffer) a.b(parcel, DataBuffer.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i9 != 2) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                asyncCall((DataBuffer) a.b(parcel, DataBuffer.CREATOR), IAIDLCallback.Stub.asInterface(parcel.readStrongBinder()));
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}

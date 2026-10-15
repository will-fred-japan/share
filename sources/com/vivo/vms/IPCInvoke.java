package com.vivo.vms;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface IPCInvoke extends IInterface {
    public static final String DESCRIPTOR = "com.vivo.vms.IPCInvoke";

    public static class Default implements IPCInvoke {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.vivo.vms.IPCInvoke
        public Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback) {
            return null;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i9) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i9);
            }
        }
    }

    Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback);

    public static abstract class Stub extends Binder implements IPCInvoke {
        static final int TRANSACTION_asyncCall = 1;

        public static class Proxy implements IPCInvoke {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.vivo.vms.IPCInvoke
            public Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPCInvoke.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iPCCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IPCInvoke.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IPCInvoke.DESCRIPTOR);
        }

        public static IPCInvoke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPCInvoke.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPCInvoke)) ? new Proxy(iBinder) : (IPCInvoke) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 > 0 && i9 <= 16777215) {
                parcel.enforceInterface(IPCInvoke.DESCRIPTOR);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(IPCInvoke.DESCRIPTOR);
                return true;
            }
            if (i9 != 1) {
                return super.onTransact(i9, parcel, parcel2, i10);
            }
            Bundle bundleAsyncCall = asyncCall((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), IPCCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            _Parcel.writeTypedObject(parcel2, bundleAsyncCall, 1);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}

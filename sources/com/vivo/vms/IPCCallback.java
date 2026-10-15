package com.vivo.vms;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface IPCCallback extends IInterface {
    public static final String DESCRIPTOR = "com.vivo.vms.IPCCallback";

    public static class _Parcel {
        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
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

    void call(Bundle bundle);

    public static abstract class Stub extends Binder implements IPCCallback {
        static final int TRANSACTION_call = 1;

        public static class Proxy implements IPCCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.vivo.vms.IPCCallback
            public void call(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPCCallback.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        bundle.readFromParcel(parcelObtain2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IPCCallback.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IPCCallback.DESCRIPTOR);
        }

        public static IPCCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPCCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPCCallback)) ? new Proxy(iBinder) : (IPCCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 > 0 && i9 <= 16777215) {
                parcel.enforceInterface(IPCCallback.DESCRIPTOR);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(IPCCallback.DESCRIPTOR);
                return true;
            }
            if (i9 != 1) {
                return super.onTransact(i9, parcel, parcel2, i10);
            }
            Bundle bundle = new Bundle();
            call(bundle);
            parcel2.writeNoException();
            _Parcel.writeTypedObject(parcel2, bundle, 1);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class Default implements IPCCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.vivo.vms.IPCCallback
        public void call(Bundle bundle) {
        }
    }
}

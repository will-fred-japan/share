package com.mcs.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface INotifiPermissionCallback extends IInterface {
    void onFail(int i9, String str);

    void onSuccess();

    public static class Default implements INotifiPermissionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mcs.aidl.INotifiPermissionCallback
        public void onSuccess() {
        }

        @Override // com.mcs.aidl.INotifiPermissionCallback
        public void onFail(int i9, String str) {
        }
    }

    public static abstract class Stub extends Binder implements INotifiPermissionCallback {
        private static final String DESCRIPTOR = "com.mcs.aidl.INotifiPermissionCallback";
        static final int TRANSACTION_onFail = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements INotifiPermissionCallback {
            public static INotifiPermissionCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.mcs.aidl.INotifiPermissionCallback
            public void onFail(int i9, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFail(i9, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.mcs.aidl.INotifiPermissionCallback
            public void onSuccess() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INotifiPermissionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INotifiPermissionCallback)) ? new Proxy(iBinder) : (INotifiPermissionCallback) iInterfaceQueryLocalInterface;
        }

        public static INotifiPermissionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(INotifiPermissionCallback iNotifiPermissionCallback) {
            if (Proxy.sDefaultImpl != null || iNotifiPermissionCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iNotifiPermissionCallback;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess();
            } else {
                if (i9 != 2) {
                    if (i9 != 1598968902) {
                        return super.onTransact(i9, parcel, parcel2, i10);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onFail(parcel.readInt(), parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}

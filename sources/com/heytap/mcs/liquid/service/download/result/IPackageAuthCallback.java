package com.heytap.mcs.liquid.service.download.result;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IPackageAuthCallback extends IInterface {
    void onAuthResult(int i9);

    public static abstract class Stub extends Binder implements IPackageAuthCallback {
        private static final String DESCRIPTOR = "com.heytap.mcs.liquid.service.download.result.IPackageAuthCallback";
        static final int TRANSACTION_onAuthResult = 1;

        public static class Proxy implements IPackageAuthCallback {
            public static IPackageAuthCallback sDefaultImpl;
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

            @Override // com.heytap.mcs.liquid.service.download.result.IPackageAuthCallback
            public void onAuthResult(int i9) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i9);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onAuthResult(i9);
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

        public static IPackageAuthCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPackageAuthCallback)) ? new Proxy(iBinder) : (IPackageAuthCallback) iInterfaceQueryLocalInterface;
        }

        public static IPackageAuthCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPackageAuthCallback iPackageAuthCallback) {
            if (Proxy.sDefaultImpl != null || iPackageAuthCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPackageAuthCallback;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 != 1) {
                if (i9 != 1598968902) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onAuthResult(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class Default implements IPackageAuthCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.mcs.liquid.service.download.result.IPackageAuthCallback
        public void onAuthResult(int i9) {
        }
    }
}

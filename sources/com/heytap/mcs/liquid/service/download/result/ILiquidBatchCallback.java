package com.heytap.mcs.liquid.service.download.result;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.mcs.liquid.model.SeedingRequestResult;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ILiquidBatchCallback extends IInterface {
    void onFailed(List<SeedingRequestResult> list);

    public static abstract class Stub extends Binder implements ILiquidBatchCallback {
        private static final String DESCRIPTOR = "com.heytap.mcs.liquid.service.download.result.ILiquidBatchCallback";
        static final int TRANSACTION_onFailed = 1;

        public static class Proxy implements ILiquidBatchCallback {
            public static ILiquidBatchCallback sDefaultImpl;
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

            @Override // com.heytap.mcs.liquid.service.download.result.ILiquidBatchCallback
            public void onFailed(List<SeedingRequestResult> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeTypedList(list);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFailed(list);
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

        public static ILiquidBatchCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILiquidBatchCallback)) ? new Proxy(iBinder) : (ILiquidBatchCallback) iInterfaceQueryLocalInterface;
        }

        public static ILiquidBatchCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ILiquidBatchCallback iLiquidBatchCallback) {
            if (Proxy.sDefaultImpl != null || iLiquidBatchCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLiquidBatchCallback;
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
            onFailed(parcel.createTypedArrayList(SeedingRequestResult.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class Default implements ILiquidBatchCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.mcs.liquid.service.download.result.ILiquidBatchCallback
        public void onFailed(List<SeedingRequestResult> list) {
        }
    }
}

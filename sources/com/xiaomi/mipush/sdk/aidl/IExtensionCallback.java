package com.xiaomi.mipush.sdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IExtensionCallback extends IInterface {
    void onFinish(RemoteNotificationContent remoteNotificationContent);

    public static abstract class Stub extends Binder implements IExtensionCallback {
        private static final String DESCRIPTOR = "com.xiaomi.mipush.sdk.aidl.IExtensionCallback";
        static final int TRANSACTION_onFinish = 1;

        public static class Proxy implements IExtensionCallback {
            public static IExtensionCallback sDefaultImpl;
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

            @Override // com.xiaomi.mipush.sdk.aidl.IExtensionCallback
            public void onFinish(RemoteNotificationContent remoteNotificationContent) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (remoteNotificationContent != null) {
                        parcelObtain.writeInt(1);
                        remoteNotificationContent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFinish(remoteNotificationContent);
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

        public static IExtensionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IExtensionCallback)) ? new Proxy(iBinder) : (IExtensionCallback) iInterfaceQueryLocalInterface;
        }

        public static IExtensionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IExtensionCallback iExtensionCallback) {
            if (Proxy.sDefaultImpl != null || iExtensionCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iExtensionCallback;
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
            onFinish(parcel.readInt() != 0 ? RemoteNotificationContent.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class Default implements IExtensionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.mipush.sdk.aidl.IExtensionCallback
        public void onFinish(RemoteNotificationContent remoteNotificationContent) {
        }
    }
}

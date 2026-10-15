package com.xiaomi.mipush.sdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IExtensionInterface extends IInterface {
    void baseExtensionTimeWillExpire(RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback);

    void baseReceiveRemoteNotification(RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback);

    public static abstract class Stub extends Binder implements IExtensionInterface {
        private static final String DESCRIPTOR = "com.xiaomi.mipush.sdk.aidl.IExtensionInterface";
        static final int TRANSACTION_baseExtensionTimeWillExpire = 2;
        static final int TRANSACTION_baseReceiveRemoteNotification = 1;

        public static class Proxy implements IExtensionInterface {
            public static IExtensionInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.xiaomi.mipush.sdk.aidl.IExtensionInterface
            public void baseExtensionTimeWillExpire(RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (remoteNotificationInfo != null) {
                        parcelObtain.writeInt(1);
                        remoteNotificationInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iExtensionCallback != null ? iExtensionCallback.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().baseExtensionTimeWillExpire(remoteNotificationInfo, iExtensionCallback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.mipush.sdk.aidl.IExtensionInterface
            public void baseReceiveRemoteNotification(RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (remoteNotificationInfo != null) {
                        parcelObtain.writeInt(1);
                        remoteNotificationInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iExtensionCallback != null ? iExtensionCallback.asBinder() : null);
                    if (this.mRemote.transact(1, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().baseReceiveRemoteNotification(remoteNotificationInfo, iExtensionCallback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IExtensionInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IExtensionInterface)) ? new Proxy(iBinder) : (IExtensionInterface) iInterfaceQueryLocalInterface;
        }

        public static IExtensionInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IExtensionInterface iExtensionInterface) {
            if (Proxy.sDefaultImpl != null || iExtensionInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iExtensionInterface;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                baseReceiveRemoteNotification(parcel.readInt() != 0 ? RemoteNotificationInfo.CREATOR.createFromParcel(parcel) : null, IExtensionCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i9 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                baseExtensionTimeWillExpire(parcel.readInt() != 0 ? RemoteNotificationInfo.CREATOR.createFromParcel(parcel) : null, IExtensionCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i9 != 1598968902) {
                return super.onTransact(i9, parcel, parcel2, i10);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class Default implements IExtensionInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.xiaomi.mipush.sdk.aidl.IExtensionInterface
        public void baseExtensionTimeWillExpire(RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback) {
        }

        @Override // com.xiaomi.mipush.sdk.aidl.IExtensionInterface
        public void baseReceiveRemoteNotification(RemoteNotificationInfo remoteNotificationInfo, IExtensionCallback iExtensionCallback) {
        }
    }
}

package com.heytap.mcs.liquid.service.download.result;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.mcs.liquid.model.ActionResult;

/* JADX INFO: loaded from: classes.dex */
public interface ILiquidCallback extends IInterface {
    void onClick(String str, int i9);

    void onDismiss(String str);

    void onFailed(String str, int i9, int i10);

    ActionResult onPauseClick(String str);

    ActionResult onResumeClick(String str);

    void onShow(String str, int i9);

    public static abstract class Stub extends Binder implements ILiquidCallback {
        private static final String DESCRIPTOR = "com.heytap.mcs.liquid.service.download.result.ILiquidCallback";
        static final int TRANSACTION_onClick = 2;
        static final int TRANSACTION_onDismiss = 5;
        static final int TRANSACTION_onFailed = 6;
        static final int TRANSACTION_onPauseClick = 3;
        static final int TRANSACTION_onResumeClick = 4;
        static final int TRANSACTION_onShow = 1;

        public static class Proxy implements ILiquidCallback {
            public static ILiquidCallback sDefaultImpl;
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

            @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
            public void onClick(String str, int i9) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i9);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onClick(str, i9);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
            public void onDismiss(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDismiss(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
            public void onFailed(String str, int i9, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFailed(str, i9, i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
            public ActionResult onPauseClick(String str) {
                ActionResult actionResultCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        actionResultCreateFromParcel = parcelObtain2.readInt() != 0 ? ActionResult.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        actionResultCreateFromParcel = Stub.getDefaultImpl().onPauseClick(str);
                    }
                    return actionResultCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
            public ActionResult onResumeClick(String str) {
                ActionResult actionResultCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        actionResultCreateFromParcel = parcelObtain2.readInt() != 0 ? ActionResult.CREATOR.createFromParcel(parcelObtain2) : null;
                    } else {
                        actionResultCreateFromParcel = Stub.getDefaultImpl().onResumeClick(str);
                    }
                    return actionResultCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
            public void onShow(String str, int i9) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i9);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onShow(str, i9);
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

        public static ILiquidCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILiquidCallback)) ? new Proxy(iBinder) : (ILiquidCallback) iInterfaceQueryLocalInterface;
        }

        public static ILiquidCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ILiquidCallback iLiquidCallback) {
            if (Proxy.sDefaultImpl != null || iLiquidCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLiquidCallback;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i9) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onShow(parcel.readString(), parcel.readInt());
                    break;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onClick(parcel.readString(), parcel.readInt());
                    break;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    ActionResult actionResultOnPauseClick = onPauseClick(parcel.readString());
                    parcel2.writeNoException();
                    if (actionResultOnPauseClick != null) {
                        parcel2.writeInt(1);
                        actionResultOnPauseClick.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    ActionResult actionResultOnResumeClick = onResumeClick(parcel.readString());
                    parcel2.writeNoException();
                    if (actionResultOnResumeClick != null) {
                        parcel2.writeInt(1);
                        actionResultOnResumeClick.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDismiss(parcel.readString());
                    break;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onFailed(parcel.readString(), parcel.readInt(), parcel.readInt());
                    break;
                default:
                    return super.onTransact(i9, parcel, parcel2, i10);
            }
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class Default implements ILiquidCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
        public ActionResult onPauseClick(String str) {
            return null;
        }

        @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
        public ActionResult onResumeClick(String str) {
            return null;
        }

        @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
        public void onDismiss(String str) {
        }

        @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
        public void onClick(String str, int i9) {
        }

        @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
        public void onShow(String str, int i9) {
        }

        @Override // com.heytap.mcs.liquid.service.download.result.ILiquidCallback
        public void onFailed(String str, int i9, int i10) {
        }
    }
}

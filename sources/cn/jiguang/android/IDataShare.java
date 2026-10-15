package cn.jiguang.android;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface IDataShare extends IInterface {
    public static final String DESCRIPTOR = "cn.jiguang.android.IDataShare";

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

    String bind(IDataShare iDataShare, String str);

    Bundle execute(String str, String str2, Bundle bundle);

    IBinder getBinderByType(String str, String str2);

    void onAction(String str, String str2, Bundle bundle);

    public static abstract class Stub extends Binder implements IDataShare {
        static final int TRANSACTION_bind = 4;
        static final int TRANSACTION_execute = 3;
        static final int TRANSACTION_getBinderByType = 1;
        static final int TRANSACTION_onAction = 2;

        public static class a implements IDataShare {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f9366a;

            public a(IBinder iBinder) {
                this.f9366a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9366a;
            }

            @Override // cn.jiguang.android.IDataShare
            public String bind(IDataShare iDataShare, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDataShare.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iDataShare);
                    parcelObtain.writeString(str);
                    this.f9366a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public Bundle execute(String str, String str2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDataShare.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.f9366a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public IBinder getBinderByType(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDataShare.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f9366a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // cn.jiguang.android.IDataShare
            public void onAction(String str, String str2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDataShare.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.f9366a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDataShare.DESCRIPTOR);
        }

        public static IDataShare asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDataShare.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDataShare)) ? new a(iBinder) : (IDataShare) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(IDataShare.DESCRIPTOR);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(IDataShare.DESCRIPTOR);
                return true;
            }
            if (i9 == 1) {
                IBinder binderByType = getBinderByType(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(binderByType);
            } else if (i9 == 2) {
                onAction(parcel.readString(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
            } else if (i9 == 3) {
                Bundle bundleExecute = execute(parcel.readString(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, bundleExecute, 1);
            } else {
                if (i9 != 4) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                String strBind = bind(asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strBind);
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class Default implements IDataShare {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cn.jiguang.android.IDataShare
        public String bind(IDataShare iDataShare, String str) {
            return null;
        }

        @Override // cn.jiguang.android.IDataShare
        public Bundle execute(String str, String str2, Bundle bundle) {
            return null;
        }

        @Override // cn.jiguang.android.IDataShare
        public IBinder getBinderByType(String str, String str2) {
            return null;
        }

        @Override // cn.jiguang.android.IDataShare
        public void onAction(String str, String str2, Bundle bundle) {
        }
    }
}

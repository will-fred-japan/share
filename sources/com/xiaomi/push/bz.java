package com.xiaomi.push;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface bz extends IInterface {
    void a(int i9);

    void a(Uri uri);

    void b(int i9);

    public static abstract class a extends Binder implements bz {
        public static bz a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.market.IUploadThirdLogServiceCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof bz)) ? new C0187a(iBinder) : (bz) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 == 1) {
                parcel.enforceInterface("com.xiaomi.market.IUploadThirdLogServiceCallback");
                a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i9 == 2) {
                parcel.enforceInterface("com.xiaomi.market.IUploadThirdLogServiceCallback");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i9 != 3) {
                if (i9 != 1598968902) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                parcel2.writeString("com.xiaomi.market.IUploadThirdLogServiceCallback");
                return true;
            }
            parcel.enforceInterface("com.xiaomi.market.IUploadThirdLogServiceCallback");
            b(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static bz a() {
            return C0187a.f17108a;
        }

        /* JADX INFO: renamed from: com.xiaomi.push.bz$a$a, reason: collision with other inner class name */
        public static class C0187a implements bz {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static bz f17108a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private IBinder f158a;

            public C0187a(IBinder iBinder) {
                this.f158a = iBinder;
            }

            @Override // com.xiaomi.push.bz
            public void a(Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.market.IUploadThirdLogServiceCallback");
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f158a.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().a(uri);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f158a;
            }

            @Override // com.xiaomi.push.bz
            public void b(int i9) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.market.IUploadThirdLogServiceCallback");
                    parcelObtain.writeInt(i9);
                    if (this.f158a.transact(3, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().b(i9);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.xiaomi.push.bz
            public void a(int i9) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.xiaomi.market.IUploadThirdLogServiceCallback");
                    parcelObtain.writeInt(i9);
                    if (!this.f158a.transact(2, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        a.a().a(i9);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}

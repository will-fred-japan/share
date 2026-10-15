package cn.jiguang.commons.a;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class dy implements dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f9920a;

    public dy(IBinder iBinder) {
        this.f9920a = iBinder;
    }

    @Override // cn.jiguang.commons.a.dw
    public final String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(km.b("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0=", f.f10031c));
            this.f9920a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th) {
            try {
                ee.d("ZTEOAID", "getOAID obtain exception:" + th.getMessage());
                return null;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9920a;
    }

    @Override // cn.jiguang.commons.a.dw
    public final boolean b() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(km.b("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0=", f.f10031c));
            this.f9920a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            boolean z8 = parcelObtain2.readInt() != 0;
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return z8;
        } catch (Throwable th) {
            try {
                ee.d("ZTEOAID", "isSupported obtain exception:" + th.getMessage());
                return false;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}

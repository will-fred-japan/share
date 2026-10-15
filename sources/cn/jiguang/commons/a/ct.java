package cn.jiguang.commons.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class ct implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f9841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9842b;

    public ct(IBinder iBinder) {
        this.f9842b = "";
        this.f9841a = iBinder;
        this.f9842b = km.b("8lAhWp7NB89J3VIJU4lIGfGqvEuhZG7tBjI4IuOrU/y3j/vpb/c+G/Rylr/l3ZwQ", f.f10031c);
    }

    public final String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.f9842b);
            this.f9841a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th) {
            try {
                ee.d("AsusAdvertisingInterface", "get ids-o e: " + th.getMessage());
                return "";
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9841a;
    }
}

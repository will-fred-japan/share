package cn.jiguang.commons.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class dz implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f9921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9922b = km.b("Mpy0fkBSw1N+kug2cBPj2Z07jpK2SYpu9oSV4B2lEuO7ZdtoaGwNjuH9BjHR80mN", f.f10031c);

    public dz(IBinder iBinder) {
        this.f9921a = iBinder;
    }

    public final String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.f9922b);
            this.f9921a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th) {
            try {
                ee.d("ZuiAdvertisingInterface", "get Ids-o error: " + th.getMessage());
                return "";
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }
}

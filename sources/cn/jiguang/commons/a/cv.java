package cn.jiguang.commons.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class cv implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f9844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9845b;

    public cv(IBinder iBinder) {
        this.f9845b = "";
        this.f9844a = iBinder;
        this.f9845b = km.b("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjKewmlEeKVcapnVp59DHSw2ZuSa3pDDty/LQ1R0HbmN4Tu7alH/m3nVMfORBLpozB8=", f.f10031c);
    }

    public final String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.f9845b);
            this.f9844a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th) {
            try {
                ee.d("AdvertisingInterface", "getId error: " + th.getMessage());
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

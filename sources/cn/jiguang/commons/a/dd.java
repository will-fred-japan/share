package cn.jiguang.commons.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class dd implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f9870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9871b = km.b("axDZqud6H+CDQBXA/yBXOryhAsxzPh1PgN4N991nACfTSsXdCfZsE70k+cjPDPVB6dhHsO0zfFF8mVkwxeVKdQ==", f.f10031c);

    public dd(IBinder iBinder) {
        this.f9870a = iBinder;
    }

    public final String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.f9871b);
            this.f9870a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th) {
            try {
                ee.d("HuaweiAdvertisingInterface", "getIds error: " + th.getMessage());
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

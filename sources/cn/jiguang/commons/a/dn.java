package cn.jiguang.commons.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class dn implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f9896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9897b = km.b("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVv4Y6EB33Z8c96zLnz4UMIR2tR6ldXn18NaPke3N1cdFQ==", f.f10031c);

    public dn(IBinder iBinder) {
        this.f9896a = iBinder;
    }

    public final String a(Context context) {
        if (context == null) {
            return "";
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.f9897b);
            this.f9896a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th) {
            try {
                ee.d("SumsungAdvertisingInterface", "get Ids-o error: " + th.getMessage());
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

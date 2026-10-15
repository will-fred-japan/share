package cn.jiguang.commons.a;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
final class db implements da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f9868a;

    public db(IBinder iBinder) {
        this.f9868a = iBinder;
    }

    @Override // cn.jiguang.commons.a.da
    public final void a(cy cyVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(jr.a(cx.f9848a));
            parcelObtain.writeStrongBinder(cyVar.asBinder());
            this.f9868a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            parcelObtain2.recycle();
            parcelObtain.recycle();
        } catch (Throwable th) {
            try {
                throw new RuntimeException(th);
            } catch (Throwable th2) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th2;
            }
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9868a;
    }
}

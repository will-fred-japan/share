package cn.asus.push;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f8786a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f8786a;
    }

    @Override // cn.asus.push.d
    public final void f(DataBuffer dataBuffer, cn.jpush.android.g.b bVar) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("cn.asus.push.IAIDLInvoke");
            parcelObtain.writeInt(1);
            dataBuffer.writeToParcel(parcelObtain, 0);
            parcelObtain.writeStrongBinder(bVar.asBinder());
            if (!this.f8786a.transact(2, parcelObtain, null, 1)) {
                int i9 = c.f8783a;
            }
        } finally {
            parcelObtain.recycle();
        }
    }
}

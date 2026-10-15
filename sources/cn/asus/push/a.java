package cn.asus.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Binder implements b {
    private static final String DESCRIPTOR = "cn.asus.push.IAIDLCallback";
    static final int TRANSACTION_call = 1;

    public a() {
        attachInterface(this, DESCRIPTOR);
    }

    public static b asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof b)) {
            return (b) iInterfaceQueryLocalInterface;
        }
        f fVar = new f();
        fVar.f8785a = iBinder;
        return fVar;
    }

    public static b getDefaultImpl() {
        return f.f8784b;
    }

    public static boolean setDefaultImpl(b bVar) {
        if (f.f8784b != null || bVar == null) {
            return false;
        }
        f.f8784b = bVar;
        return true;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
        if (i9 == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
        if (i9 != 1598968902) {
            return super.onTransact(i9, parcel, parcel2, i10);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}

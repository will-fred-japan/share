package p041f5;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class b extends Binder implements IInterface {
    public b(String str) {
        attachInterface(this, str);
    }

    public boolean O(int i9, Parcel parcel, Parcel parcel2) {
        throw null;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
        if (i9 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i9, parcel, parcel2, i10)) {
            return true;
        }
        return O(i9, parcel, parcel2);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}

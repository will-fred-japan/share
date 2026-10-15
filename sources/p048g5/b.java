package p048g5;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class b extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18878a;

    public b(String str, int i9) {
        this.f18878a = i9;
        switch (i9) {
            case 1:
                attachInterface(this, str);
                break;
            default:
                attachInterface(this, str);
                break;
        }
    }

    public boolean O(Parcel parcel, int i9) {
        throw null;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i9 = this.f18878a;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
        switch (this.f18878a) {
            case 0:
                if (i9 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i9, parcel, parcel2, i10)) {
                    return true;
                }
                return y(i9, parcel, parcel2);
            default:
                if (i9 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i9, parcel, parcel2, i10)) {
                    return true;
                }
                return O(parcel, i9);
        }
    }

    public boolean y(int i9, Parcel parcel, Parcel parcel2) {
        return false;
    }
}

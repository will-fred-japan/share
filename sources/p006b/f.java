package p006b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IPostMessageService.java */
/* JADX INFO: loaded from: classes.dex */
public interface f extends IInterface {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f8477q = "android$support$customtabs$IPostMessageService".replace('$', '.');

    /* JADX INFO: compiled from: IPostMessageService.java */
    public static abstract class a extends Binder implements f {
        @Override // android.os.Binder
        public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            String str = f.f8477q;
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i9 == 2) {
                c.a.y(parcel.readStrongBinder()).D((Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
                parcel2.writeNoException();
                return true;
            }
            if (i9 != 3) {
                return super.onTransact(i9, parcel, parcel2, i10);
            }
            c.a.y(parcel.readStrongBinder()).C(parcel.readString(), (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}

package p006b;

import N6.x;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jieli.jl_bt_ota.impl.d;
import p072j6.k;
import p130r.i;

/* JADX INFO: compiled from: IEngagementSignalsCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f8476p = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    /* JADX INFO: compiled from: IEngagementSignalsCallback.java */
    public static abstract class a extends Binder implements e {
        @Override // android.os.Binder
        public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            String str = e.f8476p;
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i9 == 2) {
                i iVar = (i) this;
                iVar.f21083a.post(new k(iVar.f21084b, parcel.readInt() != 0, (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null)));
                return true;
            }
            if (i9 != 3) {
                if (i9 != 4) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                i iVar2 = (i) this;
                iVar2.f21083a.post(new d(iVar2.f21084b, parcel.readInt() != 0, (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null)));
                return true;
            }
            int i11 = parcel.readInt();
            Object objCreateFromParcel = parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null;
            i iVar3 = (i) this;
            iVar3.f21083a.post(new x(i11, iVar3.f21084b, (Bundle) objCreateFromParcel, 3));
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}

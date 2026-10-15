package H;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.core.content.UnusedAppRestrictionsBackportService;

/* JADX INFO: compiled from: IUnusedAppRestrictionsBackportService.java */
/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f2343k = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    /* JADX INFO: compiled from: IUnusedAppRestrictionsBackportService.java */
    public static abstract class a extends Binder implements c {
        @Override // android.os.Binder
        public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            b bVar;
            String str = c.f2343k;
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i9 != 1) {
                return super.onTransact(i9, parcel, parcel2, i10);
            }
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                bVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(b.j);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) {
                    H.a aVar = new H.a();
                    aVar.f2342a = strongBinder;
                    bVar = aVar;
                } else {
                    bVar = (b) iInterfaceQueryLocalInterface;
                }
            }
            UnusedAppRestrictionsBackportService.a aVar2 = (UnusedAppRestrictionsBackportService.a) this;
            if (bVar == null) {
                return true;
            }
            UnusedAppRestrictionsBackportService.this.a();
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}

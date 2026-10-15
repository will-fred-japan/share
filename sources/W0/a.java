package W0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: ASUSOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b<X0.c> {
    @Override // W0.b
    public final s.b<X0.c, String> b() {
        return new C0066a();
    }

    @Override // W0.b
    public final Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    /* JADX INFO: renamed from: W0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ASUSOaidImpl.java */
    public class C0066a implements s.b<X0.c, String> {
        @Override // W0.s.b
        public final String a(X0.c cVar) {
            X0.c cVar2 = cVar;
            if (cVar2 == null) {
                return null;
            }
            X0.c.a.C0072a c0072a = (X0.c.a.C0072a) cVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0072a.f5124a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // W0.s.b
        public final X0.c a(IBinder iBinder) {
            int i9 = X0.c.a.f5123a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof X0.c)) {
                return (X0.c) iInterfaceQueryLocalInterface;
            }
            X0.c.a.C0072a c0072a = new X0.c.a.C0072a();
            c0072a.f5124a = iBinder;
            return c0072a;
        }
    }
}

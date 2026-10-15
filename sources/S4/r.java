package S4;

import android.os.Parcel;
import com.google.android.gms.common.internal.zax;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends p041f5.a {
    public final p035e5.a y(p035e5.b bVar, zax zaxVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f18706b);
        int i9 = p041f5.c.f18707a;
        parcelObtain.writeStrongBinder(bVar);
        parcelObtain.writeInt(1);
        zaxVar.writeToParcel(parcelObtain, 0);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                this.f18705a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain.recycle();
                p035e5.a aVarP = p035e5.a.AbstractBinderC0196a.P(parcelObtain2.readStrongBinder());
                parcelObtain2.recycle();
                return aVarP;
            } catch (RuntimeException e9) {
                parcelObtain2.recycle();
                throw e9;
            }
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }
}

package W0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Pair;

/* JADX INFO: compiled from: HWOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements s.b<q, Pair<String, Boolean>> {
    @Override // W0.s.b
    public final Pair<String, Boolean> a(q qVar) {
        q qVar2 = qVar;
        if (qVar2 == null) {
            return null;
        }
        IBinder iBinder = ((q.a.C0067a) qVar2).f5030a;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            iBinder.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            Parcel parcelObtain3 = Parcel.obtain();
            Parcel parcelObtain4 = Parcel.obtain();
            try {
                parcelObtain3.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, parcelObtain3, parcelObtain4, 0);
                parcelObtain4.readException();
                return new Pair<>(string, Boolean.valueOf(parcelObtain4.readInt() != 0));
            } finally {
                parcelObtain4.recycle();
                parcelObtain3.recycle();
            }
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // W0.s.b
    public final q a(IBinder iBinder) {
        int i9 = q.a.f5029a;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof q)) {
            return (q) iInterfaceQueryLocalInterface;
        }
        q.a.C0067a c0067a = new q.a.C0067a();
        c0067a.f5030a = iBinder;
        return c0067a;
    }
}

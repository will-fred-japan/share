package W0;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: SamsungOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class r extends b<X0.a> {
    @Override // W0.b
    public final s.b<X0.a, String> b() {
        return new a();
    }

    @Override // W0.b
    public final Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    /* JADX INFO: compiled from: SamsungOaidImpl.java */
    public class a implements s.b<X0.a, String> {
        @Override // W0.s.b
        public final X0.a a(IBinder iBinder) {
            int i9 = X0.a.AbstractBinderC0069a.f5119a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof X0.a)) {
                return (X0.a) iInterfaceQueryLocalInterface;
            }
            X0.a.AbstractBinderC0069a.C0070a c0070a = new X0.a.AbstractBinderC0069a.C0070a();
            c0070a.f5120a = iBinder;
            return c0070a;
        }

        @Override // W0.s.b
        public final String a(X0.a aVar) {
            X0.a.AbstractBinderC0069a.C0070a c0070a = (X0.a.AbstractBinderC0069a.C0070a) aVar;
            c0070a.getClass();
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                c0070a.f5120a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}

package W0;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: LenovoOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends b<X0.b> {
    @Override // W0.b
    public final s.b<X0.b, String> b() {
        return new a();
    }

    @Override // W0.b
    public final Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    /* JADX INFO: compiled from: LenovoOaidImpl.java */
    public class a implements s.b<X0.b, String> {
        @Override // W0.s.b
        public final String a(X0.b bVar) {
            X0.b bVar2 = bVar;
            if (bVar2 == null) {
                return null;
            }
            X0.b.a.C0071a c0071a = (X0.b.a.C0071a) bVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                c0071a.f5122a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // W0.s.b
        public final X0.b a(IBinder iBinder) {
            int i9 = X0.b.a.f5121a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof X0.b)) {
                return (X0.b) iInterfaceQueryLocalInterface;
            }
            X0.b.a.C0071a c0071a = new X0.b.a.C0071a();
            c0071a.f5122a = iBinder;
            return c0071a;
        }
    }
}

package W0;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: CommonOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b<Y0.a> {
    @Override // W0.b, W0.l
    public final l.a a(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        return super.a(context);
    }

    @Override // W0.b
    public final s.b<Y0.a, String> b() {
        return new a();
    }

    @Override // W0.b
    public final Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    /* JADX INFO: compiled from: CommonOaidImpl.java */
    public class a implements s.b<Y0.a, String> {
        @Override // W0.s.b
        public final String a(Y0.a aVar) {
            Y0.a aVar2 = aVar;
            if (aVar2 == null) {
                return null;
            }
            Y0.a.AbstractBinderC0076a.C0077a c0077a = (Y0.a.AbstractBinderC0076a.C0077a) aVar2;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                c0077a.f5221a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // W0.s.b
        public final Y0.a a(IBinder iBinder) {
            int i9 = Y0.a.AbstractBinderC0076a.f5220a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof Y0.a)) {
                return (Y0.a) iInterfaceQueryLocalInterface;
            }
            Y0.a.AbstractBinderC0076a.C0077a c0077a = new Y0.a.AbstractBinderC0076a.C0077a();
            c0077a.f5221a = iBinder;
            return c0077a;
        }
    }
}

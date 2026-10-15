package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IResultReceiver.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f5796l = "android$support$v4$os$IResultReceiver".replace('$', '.');

    void N(int i9, Bundle bundle);

    /* JADX INFO: renamed from: android.support.v4.os.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IResultReceiver.java */
    public static abstract class AbstractBinderC0090a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5797a = 0;

        /* JADX INFO: renamed from: android.support.v4.os.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IResultReceiver.java */
        public static class C0091a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5798a;

            @Override // android.support.v4.os.a
            public final void N(int i9, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f5796l);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeTypedObject(bundle, 0);
                    this.f5798a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5798a;
            }
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            String str = a.f5796l;
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
            ((ResultReceiver.b) this).N(parcel.readInt(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}

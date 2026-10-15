package p006b;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: ICustomTabsCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8471n = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    /* JADX INFO: compiled from: ICustomTabsCallback.java */
    public static class b {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void b(Parcel parcel, Parcelable parcelable, int i9) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i9);
            }
        }
    }

    void C(String str, Bundle bundle);

    void D(Bundle bundle);

    void F(int i9, Uri uri, boolean z8, Bundle bundle);

    void H(Bundle bundle);

    void K(Bundle bundle);

    void c(int i9, int i10, Bundle bundle);

    void l(String str, Bundle bundle);

    void o(int i9, int i10, int i11, int i12, int i13, Bundle bundle);

    void p(Bundle bundle);

    void r(int i9, Bundle bundle);

    Bundle u(String str, Bundle bundle);

    /* JADX INFO: compiled from: ICustomTabsCallback.java */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: b.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ICustomTabsCallback.java */
        public static class C0111a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8472a;

            @Override // p006b.c
            public final void C(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    parcelObtain.writeString(str);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final void D(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final void F(int i9, Uri uri, boolean z8, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    parcelObtain.writeInt(i9);
                    b.b(parcelObtain, uri, 0);
                    parcelObtain.writeInt(z8 ? 1 : 0);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(6, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final void H(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(11, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final void K(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(12, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f8472a;
            }

            @Override // p006b.c
            public final void c(int i9, int i10, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(8, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final void l(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    parcelObtain.writeString(str);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final void o(int i9, int i10, int i11, int i12, int i13, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeInt(i13);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(10, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final void p(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(9, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final void r(int i9, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    parcelObtain.writeInt(i9);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.c
            public final Bundle u(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f8471n);
                    parcelObtain.writeString(str);
                    b.b(parcelObtain, bundle, 0);
                    this.f8472a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) b.a(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static c y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c.f8471n);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof c)) {
                return (c) iInterfaceQueryLocalInterface;
            }
            C0111a c0111a = new C0111a();
            c0111a.f8472a = iBinder;
            return c0111a;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            String str = c.f8471n;
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i9) {
                case 2:
                    ((p130r.c) this).r(parcel.readInt(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    return true;
                case 3:
                    ((p130r.c) this).l(parcel.readString(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    return true;
                case 4:
                    ((p130r.c) this).D((Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    ((p130r.c) this).C(parcel.readString(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    ((p130r.c) this).F(parcel.readInt(), (Uri) b.a(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) b.a(parcel, Bundle.CREATOR));
                    return true;
                case 7:
                    Bundle bundleU = ((p130r.c) this).u(parcel.readString(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.b(parcel2, bundleU, 1);
                    return true;
                case 8:
                    ((p130r.c) this).c(parcel.readInt(), parcel.readInt(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    return true;
                case 9:
                    ((p130r.c) this).p((Bundle) b.a(parcel, Bundle.CREATOR));
                    return true;
                case 10:
                    ((p130r.c) this).o(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    return true;
                case 11:
                    ((p130r.c) this).H((Bundle) b.a(parcel, Bundle.CREATOR));
                    return true;
                case 12:
                    ((p130r.c) this).K((Bundle) b.a(parcel, Bundle.CREATOR));
                    return true;
                default:
                    return super.onTransact(i9, parcel, parcel2, i10);
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}

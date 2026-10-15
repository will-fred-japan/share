package p006b;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.browser.customtabs.CustomTabsService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import p006b.b;
import p122q.a;
import p130r.c;
import p130r.k;
import p130r.m;

/* JADX INFO: compiled from: ICustomTabsService.java */
/* JADX INFO: loaded from: classes.dex */
public interface d extends IInterface {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8473o = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    /* JADX INFO: compiled from: ICustomTabsService.java */
    public static class b {
        public static Object a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void b(Parcel parcel, T t, int i9) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i9);
            }
        }
    }

    boolean G();

    boolean M(c cVar, IBinder iBinder, Bundle bundle);

    boolean b(c cVar, Uri uri);

    boolean g(c cVar, Uri uri, Bundle bundle);

    boolean h(c cVar, Bundle bundle);

    boolean i(c cVar);

    int j(c cVar, String str, Bundle bundle);

    boolean m(c cVar, int i9, Uri uri, Bundle bundle);

    boolean n(c cVar, Bundle bundle);

    boolean v(c cVar, Uri uri, Bundle bundle, List<Bundle> list);

    /* JADX INFO: compiled from: ICustomTabsService.java */
    public static abstract class a extends Binder implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f8474a = 0;

        /* JADX INFO: renamed from: b.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ICustomTabsService.java */
        public static class C0112a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8475a;

            @Override // p006b.d
            public final boolean G() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeLong(0L);
                    this.f8475a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.d
            public final boolean M(c cVar, IBinder iBinder, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    parcelObtain.writeStrongBinder(iBinder);
                    b.b(parcelObtain, bundle, 0);
                    this.f8475a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f8475a;
            }

            @Override // p006b.d
            public final boolean b(c cVar, Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    b.b(parcelObtain, uri, 0);
                    this.f8475a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.d
            public final boolean g(c cVar, Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    b.b(parcelObtain, uri, 0);
                    b.b(parcelObtain, bundle, 0);
                    this.f8475a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.d
            public final boolean h(c cVar, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    b.b(parcelObtain, bundle, 0);
                    this.f8475a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.d
            public final boolean i(c cVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    this.f8475a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.d
            public final int j(c cVar, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    parcelObtain.writeString(str);
                    b.b(parcelObtain, bundle, 0);
                    this.f8475a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.d
            public final boolean m(c cVar, int i9, Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    parcelObtain.writeInt(i9);
                    b.b(parcelObtain, uri, 0);
                    b.b(parcelObtain, bundle, 0);
                    this.f8475a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.d
            public final boolean n(c cVar, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    b.b(parcelObtain, bundle, 0);
                    this.f8475a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // p006b.d
            public final boolean v(c cVar, Uri uri, Bundle bundle, List<Bundle> list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(d.f8473o);
                    parcelObtain.writeStrongInterface(cVar);
                    b.b(parcelObtain, uri, 0);
                    b.b(parcelObtain, bundle, 0);
                    if (list == null) {
                        parcelObtain.writeInt(-1);
                    } else {
                        int size = list.size();
                        parcelObtain.writeInt(size);
                        for (int i9 = 0; i9 < size; i9++) {
                            b.b(parcelObtain, list.get(i9), 0);
                        }
                    }
                    this.f8475a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            String str = d.f8473o;
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            p006b.b bVar = null;
            switch (i9) {
                case 2:
                    parcel.readLong();
                    boolean zI = CustomTabsService.this.i();
                    parcel2.writeNoException();
                    parcel2.writeInt(zI ? 1 : 0);
                    return true;
                case 3:
                    boolean zO = ((CustomTabsService.a) this).O(c.a.y(parcel.readStrongBinder()), null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zO ? 1 : 0);
                    return true;
                case 4:
                    c cVarY = c.a.y(parcel.readStrongBinder());
                    Uri uri = (Uri) b.a(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean zV = ((CustomTabsService.a) this).v(cVarY, uri, (Bundle) b.a(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(zV ? 1 : 0);
                    return true;
                case 5:
                    parcel.readString();
                    Bundle bundleA = CustomTabsService.this.a();
                    parcel2.writeNoException();
                    b.b(parcel2, bundleA, 1);
                    return true;
                case 6:
                    boolean zN = ((CustomTabsService.a) this).n(c.a.y(parcel.readStrongBinder()), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zN ? 1 : 0);
                    return true;
                case 7:
                    boolean zB = ((CustomTabsService.a) this).b(c.a.y(parcel.readStrongBinder()), (Uri) b.a(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                case 8:
                    int iJ = ((CustomTabsService.a) this).j(c.a.y(parcel.readStrongBinder()), parcel.readString(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iJ);
                    return true;
                case 9:
                    boolean zM = ((CustomTabsService.a) this).m(c.a.y(parcel.readStrongBinder()), parcel.readInt(), (Uri) b.a(parcel, Uri.CREATOR), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zM ? 1 : 0);
                    return true;
                case 10:
                    boolean zO2 = ((CustomTabsService.a) this).O(c.a.y(parcel.readStrongBinder()), CustomTabsService.a.y((Bundle) b.a(parcel, Bundle.CREATOR)));
                    parcel2.writeNoException();
                    parcel2.writeInt(zO2 ? 1 : 0);
                    return true;
                case 11:
                    boolean zG = ((CustomTabsService.a) this).g(c.a.y(parcel.readStrongBinder()), (Uri) b.a(parcel, Uri.CREATOR), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zG ? 1 : 0);
                    return true;
                case 12:
                    c cVarY2 = c.a.y(parcel.readStrongBinder());
                    parcel.readInt();
                    new k(cVarY2, CustomTabsService.a.y((Bundle) b.a(parcel, Bundle.CREATOR)));
                    boolean zE = CustomTabsService.this.e();
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 13:
                    ((CustomTabsService.a) this).h(c.a.y(parcel.readStrongBinder()), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
                case 14:
                    ((CustomTabsService.a) this).M(c.a.y(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) b.a(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
                case 15:
                    c cVarY3 = c.a.y(parcel.readStrongBinder());
                    Uri uri2 = (Uri) b.a(parcel, Uri.CREATOR);
                    Bundle bundle = (Bundle) b.a(parcel, Bundle.CREATOR);
                    new k(cVarY3, CustomTabsService.a.y(bundle));
                    Object[] objArr = {uri2};
                    ArrayList arrayList = new ArrayList(1);
                    Object obj = objArr[0];
                    Objects.requireNonNull(obj);
                    arrayList.add(obj);
                    Collections.unmodifiableList(arrayList);
                    m.a(bundle);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    c cVarY4 = c.a.y(parcel.readStrongBinder());
                    parcel.createTypedArrayList(Uri.CREATOR);
                    Bundle bundle2 = (Bundle) b.a(parcel, Bundle.CREATOR);
                    new k(cVarY4, CustomTabsService.a.y(bundle2));
                    m.a(bundle2);
                    parcel2.writeNoException();
                    return true;
                case 17:
                default:
                    return super.onTransact(i9, parcel, parcel2, i10);
                case 18:
                    IBinder strongBinder = parcel.readStrongBinder();
                    if (strongBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(p006b.b.f8470m);
                        if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p006b.b)) {
                            p006b.a aVar = new p006b.a();
                            aVar.f8469a = strongBinder;
                            bVar = aVar;
                        } else {
                            bVar = (p006b.b) iInterfaceQueryLocalInterface;
                        }
                    }
                    Bundle bundle3 = (Bundle) b.a(parcel, Bundle.CREATOR);
                    final CustomTabsService.a aVar2 = (CustomTabsService.a) this;
                    final p122q.a aVar3 = new p122q.a(bVar, CustomTabsService.a.y(bundle3));
                    try {
                        IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: r.g
                            @Override // android.os.IBinder.DeathRecipient
                            public final void binderDied() {
                                CustomTabsService.a aVar4 = aVar2;
                                a aVar5 = aVar3;
                                CustomTabsService customTabsService = CustomTabsService.this;
                                customTabsService.getClass();
                                try {
                                    synchronized (customTabsService.f6739a) {
                                        try {
                                            b bVar2 = aVar5.f20874a;
                                            IBinder iBinderAsBinder = bVar2 == null ? null : bVar2.asBinder();
                                            if (iBinderAsBinder == null) {
                                                return;
                                            }
                                            iBinderAsBinder.unlinkToDeath(customTabsService.f6739a.get(iBinderAsBinder), 0);
                                            customTabsService.f6739a.remove(iBinderAsBinder);
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                } catch (NoSuchElementException unused) {
                                }
                            }
                        };
                        synchronized (CustomTabsService.this.f6739a) {
                            bVar.asBinder().linkToDeath(deathRecipient, 0);
                            CustomTabsService.this.f6739a.put(bVar.asBinder(), deathRecipient);
                            break;
                        }
                    } catch (RemoteException unused) {
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}

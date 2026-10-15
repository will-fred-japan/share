package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public android.support.v4.os.a f5794a;

    public class a implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        public final ResultReceiver createFromParcel(Parcel parcel) {
            android.support.v4.os.a aVar;
            ResultReceiver resultReceiver = new ResultReceiver();
            IBinder strongBinder = parcel.readStrongBinder();
            int i9 = android.support.v4.os.a.AbstractBinderC0090a.f5797a;
            if (strongBinder == null) {
                aVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(android.support.v4.os.a.f5796l);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof android.support.v4.os.a)) {
                    android.support.v4.os.a.AbstractBinderC0090a.C0091a c0091a = new android.support.v4.os.a.AbstractBinderC0090a.C0091a();
                    c0091a.f5798a = strongBinder;
                    aVar = c0091a;
                } else {
                    aVar = (android.support.v4.os.a) iInterfaceQueryLocalInterface;
                }
            }
            resultReceiver.f5794a = aVar;
            return resultReceiver;
        }

        @Override // android.os.Parcelable.Creator
        public final ResultReceiver[] newArray(int i9) {
            return new ResultReceiver[i9];
        }
    }

    public class b extends android.support.v4.os.a.AbstractBinderC0090a {
        public b() {
            attachInterface(this, android.support.v4.os.a.f5796l);
        }

        @Override // android.support.v4.os.a
        public final void N(int i9, Bundle bundle) {
            ResultReceiver.this.a(i9, bundle);
        }
    }

    public final void b(int i9, Bundle bundle) {
        android.support.v4.os.a aVar = this.f5794a;
        if (aVar != null) {
            try {
                aVar.N(i9, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        synchronized (this) {
            try {
                if (this.f5794a == null) {
                    this.f5794a = new b();
                }
                parcel.writeStrongBinder(this.f5794a.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i9, Bundle bundle) {
    }
}

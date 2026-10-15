package p048g5;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f18876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18877c;

    public /* synthetic */ a(IBinder iBinder, String str, int i9) {
        this.f18875a = i9;
        this.f18876b = iBinder;
        this.f18877c = str;
    }

    public Parcel O() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f18877c);
        return parcelObtain;
    }

    public void P(Parcel parcel, int i9) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f18876b.transact(i9, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.f18875a) {
            case 0:
                break;
        }
        return this.f18876b;
    }

    public Parcel y(Parcel parcel, int i9) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f18876b.transact(i9, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e9) {
                parcelObtain.recycle();
                throw e9;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }
}

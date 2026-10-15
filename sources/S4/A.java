package S4;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class A implements InterfaceC0374e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f4118a;

    public A(IBinder iBinder) {
        this.f4118a = iBinder;
    }

    @Override // S4.InterfaceC0374e
    public final void L(G g4, GetServiceRequest getServiceRequest) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(g4);
            parcelObtain.writeInt(1);
            N.a(getServiceRequest, parcelObtain, 0);
            this.f4118a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4118a;
    }
}

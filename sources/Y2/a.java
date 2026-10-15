package Y2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.apm6.traffic.TrafficTransportService;

/* JADX INFO: compiled from: ITrafficTransportInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    void a(String str);

    void a(String str, String str2);

    void a(String str, boolean z8);

    void b(String str);

    void c(String str);

    void q(String str, String str2, String str3, String str4, String str5, long j);

    /* JADX INFO: renamed from: Y2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ITrafficTransportInterface.java */
    public static abstract class AbstractBinderC0078a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5222a = 0;

        @Override // android.os.Binder
        public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 == 1598968902) {
                parcel2.writeString("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                return true;
            }
            switch (i9) {
                case 1:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).q(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).c(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    ((TrafficTransportService.a) this).a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i9, parcel, parcel2, i10);
            }
        }

        /* JADX INFO: renamed from: Y2.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ITrafficTransportInterface.java */
        public static class C0079a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5223a;

            @Override // Y2.a
            public final void a(String str, boolean z8) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z8 ? 1 : 0);
                    if (!this.f5223a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i9 = AbstractBinderC0078a.f5222a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5223a;
            }

            @Override // Y2.a
            public final void b(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    if (!this.f5223a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i9 = AbstractBinderC0078a.f5222a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // Y2.a
            public final void c(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    if (!this.f5223a.transact(5, parcelObtain, parcelObtain2, 0)) {
                        int i9 = AbstractBinderC0078a.f5222a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // Y2.a
            public final void q(String str, String str2, String str3, String str4, String str5, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    if (!this.f5223a.transact(4, parcelObtain, parcelObtain2, 0)) {
                        int i9 = AbstractBinderC0078a.f5222a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // Y2.a
            public final void a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    if (!this.f5223a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i9 = AbstractBinderC0078a.f5222a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // Y2.a
            public final void a(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.apm6.traffic.ITrafficTransportInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f5223a.transact(6, parcelObtain, parcelObtain2, 0)) {
                        int i9 = AbstractBinderC0078a.f5222a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}

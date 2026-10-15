package p021d;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: INotificationSideChannel.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    public static final String t = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* JADX INFO: renamed from: d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: INotificationSideChannel.java */
    public static abstract class AbstractBinderC0191a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f18446a = 0;

        /* JADX INFO: renamed from: d.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: INotificationSideChannel.java */
        public static class C0192a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f18447a;

            @Override // p021d.a
            public final void E(String str, int i9, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.t);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedObject(notification, 0);
                    this.f18447a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f18447a;
            }
        }
    }

    void E(String str, int i9, String str2, Notification notification);
}

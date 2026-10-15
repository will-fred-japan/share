package X0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: IDeviceIdService.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: X0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceIdService.java */
    public static abstract class AbstractBinderC0069a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5119a = 0;

        /* JADX INFO: renamed from: X0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceIdService.java */
        public static class C0070a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5120a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5120a;
            }
        }
    }
}

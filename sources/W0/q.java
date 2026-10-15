package W0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: OpenDeviceIdentifierService.java */
/* JADX INFO: loaded from: classes.dex */
public interface q extends IInterface {

    /* JADX INFO: compiled from: OpenDeviceIdentifierService.java */
    public static abstract class a extends Binder implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5029a = 0;

        /* JADX INFO: renamed from: W0.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpenDeviceIdentifierService.java */
        public static class C0067a implements q {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5030a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5030a;
            }
        }
    }
}

package Y0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: MsaIdInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: Y0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MsaIdInterface.java */
    public static abstract class AbstractBinderC0076a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5220a = 0;

        /* JADX INFO: renamed from: Y0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MsaIdInterface.java */
        public static class C0077a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5221a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5221a;
            }
        }
    }
}

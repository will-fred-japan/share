package Z0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: IOpenID.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: Z0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IOpenID.java */
    public static abstract class AbstractBinderC0082a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5512a = 0;

        /* JADX INFO: renamed from: Z0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IOpenID.java */
        public static class C0083a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5513a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5513a;
            }
        }
    }
}

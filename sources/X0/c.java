package X0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: IDidAidlInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    /* JADX INFO: compiled from: IDidAidlInterface.java */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5123a = 0;

        /* JADX INFO: renamed from: X0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDidAidlInterface.java */
        public static class C0072a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5124a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5124a;
            }
        }
    }
}

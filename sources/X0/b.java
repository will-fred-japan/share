package X0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: IDeviceidInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: IDeviceidInterface.java */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f5121a = 0;

        /* JADX INFO: renamed from: X0.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IDeviceidInterface.java */
        public static class C0071a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f5122a;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f5122a;
            }
        }
    }
}

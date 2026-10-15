package p035e5;

import O4.e;
import S4.C0376g;
import S4.r;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f18619a;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static class a extends Exception {
    }

    public abstract r a(IBinder iBinder);

    public final T b(Context context) throws a {
        Context contextCreatePackageContext;
        if (this.f18619a == null) {
            C0376g.e(context);
            AtomicBoolean atomicBoolean = e.f3476a;
            try {
                contextCreatePackageContext = context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                contextCreatePackageContext = null;
            }
            if (contextCreatePackageContext == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.f18619a = a((IBinder) contextCreatePackageContext.getClassLoader().loadClass("com.google.android.gms.common.ui.SignInButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e9) {
                throw new a("Could not load creator class.", e9);
            } catch (IllegalAccessException e10) {
                throw new a("Could not access creator.", e10);
            } catch (InstantiationException e11) {
                throw new a("Could not instantiate creator.", e11);
            }
        }
        return (T) this.f18619a;
    }
}

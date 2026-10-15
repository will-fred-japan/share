package p130r;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import p006b.d;

/* JADX INFO: compiled from: CustomTabsServiceConnection.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h implements ServiceConnection {
    private Context mApplicationContext;

    /* JADX INFO: compiled from: CustomTabsServiceConnection.java */
    public class a extends d {
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, d dVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d dVar;
        if (this.mApplicationContext == null) {
            throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
        int i9 = d.a.f8474a;
        if (iBinder == null) {
            dVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(d.f8473o);
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) {
                d.a.C0112a c0112a = new d.a.C0112a();
                c0112a.f8475a = iBinder;
                dVar = c0112a;
            } else {
                dVar = (d) iInterfaceQueryLocalInterface;
            }
        }
        onCustomTabsServiceConnected(componentName, new a(dVar, componentName));
    }

    public void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }
}

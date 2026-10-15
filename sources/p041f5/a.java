package p041f5;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f18705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18706b;

    public a(IBinder iBinder, String str) {
        this.f18705a = iBinder;
        this.f18706b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f18705a;
    }
}

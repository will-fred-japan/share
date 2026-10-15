package U4;

import S4.AbstractC0372c;
import S4.C0371b;
import S4.C0378i;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import p041f5.f;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AbstractC0372c {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final C0378i f4665z;

    public d(Context context, Looper looper, C0371b c0371b, C0378i c0378i, P4.d.a aVar, P4.d.b bVar) {
        super(context, looper, 270, c0371b, aVar, bVar);
        this.f4665z = c0378i;
    }

    @Override // S4.AbstractC0370a, P4.a.e
    public final int f() {
        return 203400000;
    }

    @Override // S4.AbstractC0370a
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // S4.AbstractC0370a
    public final Feature[] p() {
        return f.f18709b;
    }

    @Override // S4.AbstractC0370a
    public final Bundle q() {
        this.f4665z.getClass();
        return new Bundle();
    }

    @Override // S4.AbstractC0370a
    public final String s() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // S4.AbstractC0370a
    public final String t() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // S4.AbstractC0370a
    public final boolean u() {
        return true;
    }
}

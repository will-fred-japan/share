package O4;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"HandlerLeak"})
public final class h extends p041f5.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f3483b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b bVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f3483b = bVar;
        this.f3482a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i9 = message.what;
        if (i9 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i9);
            return;
        }
        int i10 = c.f3474a;
        b bVar = this.f3483b;
        Context context = this.f3482a;
        int iB = bVar.b(context, i10);
        AtomicBoolean atomicBoolean = e.f3476a;
        if (iB == 1 || iB == 2 || iB == 3 || iB == 9) {
            Intent intentA = bVar.a(iB, "n", context);
            bVar.f(context, iB, intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, 201326592));
        }
    }
}

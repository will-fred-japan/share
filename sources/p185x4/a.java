package p185x4;

import G.n;
import G.y;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: BackgroundNotification.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f22285b;

    public a(Context context, c cVar) {
        this.f22284a = context;
        n nVar = new n(context, "geolocator_channel_01");
        nVar.f2129k = 1;
        this.f22285b = nVar;
        a(cVar, false);
    }

    public final void a(c cVar, boolean z8) {
        PendingIntent activity;
        q6.a aVar = cVar.f22290d;
        String str = aVar.f20987a;
        Context context = this.f22284a;
        int identifier = context.getResources().getIdentifier(str, aVar.f20988b, context.getPackageName());
        if (identifier == 0) {
            context.getResources().getIdentifier("ic_launcher.png", "mipmap", context.getPackageName());
        }
        n nVar = this.f22285b;
        nVar.getClass();
        nVar.f2124e = n.b(cVar.f22287a);
        nVar.f2117G.icon = identifier;
        nVar.f2125f = n.b(cVar.f22288b);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setPackage(null);
            launchIntentForPackage.setFlags(270532608);
            activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 201326592);
        } else {
            activity = null;
        }
        nVar.f2126g = activity;
        nVar.c(2, cVar.f22293g);
        this.f22285b = nVar;
        Integer num = cVar.f22294h;
        if (num != null) {
            nVar.f2143z = num.intValue();
            this.f22285b = nVar;
        }
        if (z8) {
            new y(context).b(null, 75415, this.f22285b.a());
        }
    }
}

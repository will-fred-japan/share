package Q;

import Q4.C;
import Q4.O;
import S4.C0376g;
import android.graphics.Typeface;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.apm.insight.MonitorCrash;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONObject;
import p056h5.C0598e;

/* JADX INFO: compiled from: CallbackWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3646c;

    public /* synthetic */ a(int i9, Object obj, Object obj2) {
        this.f3644a = i9;
        this.f3645b = obj;
        this.f3646c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Set<Scope> set;
        ScheduledFuture<?> scheduledFuture;
        com.google.android.gms.common.internal.b cVar = null;
        switch (this.f3644a) {
            case 0:
                J.g.c cVar2 = ((K.d.a) this.f3645b).f2753L;
                if (cVar2 != null) {
                    cVar2.c((Typeface) this.f3646c);
                    return;
                }
                return;
            case 1:
                zak zakVar = (zak) this.f3645b;
                ConnectionResult connectionResult = zakVar.f12791b;
                boolean z8 = connectionResult.f12451b == 0;
                O o2 = (O) this.f3646c;
                if (z8) {
                    zav zavVar = zakVar.f12792c;
                    C0376g.e(zavVar);
                    ConnectionResult connectionResult2 = zavVar.f12542c;
                    if (connectionResult2.f12451b != 0) {
                        Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult2)), new Exception());
                        o2.f3785g.b(connectionResult2);
                        o2.f3784f.disconnect();
                        return;
                    }
                    C c5 = o2.f3785g;
                    IBinder iBinder = zavVar.f12541b;
                    if (iBinder != null) {
                        int i9 = com.google.android.gms.common.internal.b.a.f12535b;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        cVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.common.internal.b ? (com.google.android.gms.common.internal.b) iInterfaceQueryLocalInterface : new com.google.android.gms.common.internal.c(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 0);
                    }
                    c5.getClass();
                    if (cVar == null || (set = o2.f3782d) == null) {
                        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        c5.b(new ConnectionResult(4));
                    } else {
                        c5.f3753c = cVar;
                        c5.f3754d = set;
                        if (c5.f3755e) {
                            c5.f3751a.c(cVar, set);
                        }
                    }
                } else {
                    o2.f3785g.b(connectionResult);
                }
                o2.f3784f.disconnect();
                return;
            case 2:
                p115p1.a.g().c(new p124q1.b((String) this.f3645b, (JSONObject) this.f3646c));
                return;
            case 3:
                p115p1.a aVarG = p115p1.a.g();
                N1.e eVar = (N1.e) this.f3645b;
                String str = (String) eVar.f3160b;
                p124q1.c cVar3 = new p124q1.c();
                cVar3.f20886a = str;
                cVar3.f20887b = 0;
                cVar3.f20888c = null;
                cVar3.f20889d = (JSONObject) eVar.f3161c;
                cVar3.f20890e = null;
                cVar3.f20891f = (JSONObject) this.f3646c;
                aVarG.c(cVar3);
                return;
            case 4:
                synchronized (((p094m5.i) this.f3646c).f20359b) {
                    ((p094m5.i) this.f3646c).f20360c.b((p094m5.n) this.f3645b);
                    break;
                }
                return;
            case 5:
                p127q4.j.b((MonitorCrash) this.f3645b, (h4.c) this.f3646c);
                return;
            default:
                u3.a aVar = (u3.a) this.f3646c;
                aVar.f21675d.getClass();
                boolean zB = p126q3.b.a().b();
                if (zB && (scheduledFuture = aVar.f21676e) != null && !scheduledFuture.isCancelled()) {
                    C0598e.o("canAnalyse, so cancel check", new Object[0]);
                    aVar.f21676e.cancel(false);
                    aVar.f21672a = true;
                }
                if (zB || aVar.f21674c || aVar.f21673b) {
                    return;
                }
                aVar.f21675d.getClass();
                if (!p108o3.a.c().a()) {
                    if (System.currentTimeMillis() - p143s3.b.d().e().getLong("lastDumpTime", 0L) < 28800000) {
                        return;
                    }
                }
                if (p027d5.a.e() >= ((p151t3.a) this.f3645b).f21404b) {
                    ((u3.a) this.f3646c).f21674c = true;
                    ((u3.a) this.f3646c).f21675d.getClass();
                    p126q3.c.e().a(System.currentTimeMillis());
                    C0598e.o("begin dumpHeap", new Object[0]);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, int i9, boolean z8) {
        this.f3644a = i9;
        this.f3646c = obj;
        this.f3645b = obj2;
    }
}

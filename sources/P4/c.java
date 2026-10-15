package P4;

import P4.a.c;
import Q4.C0345a;
import Q4.C0348d;
import Q4.C0352h;
import Q4.I;
import Q4.P;
import Q4.T;
import Q4.U;
import S4.C0371b;
import S4.C0376g;
import android.accounts.Account;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.Collection;
import java.util.Collections;
import p094m5.n;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<O extends P4.a.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P4.a f3621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final P4.a.c f3622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0345a f3623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p027d5.a f3625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C0348d f3626h;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f3627b = new a(new p027d5.a(), Looper.getMainLooper());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p027d5.a f3628a;

        public a(p027d5.a aVar, Looper looper) {
            this.f3628a = aVar;
        }
    }

    public c(Context context, P4.a<O> aVar, O o2, a aVar2) {
        C0376g.f(context, "Null context is not permitted.");
        C0376g.f(aVar, "Api must not be null.");
        C0376g.f(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        C0376g.f(applicationContext, "The provided context did not have an application context.");
        this.f3619a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f3620b = attributionTag;
        this.f3621c = aVar;
        this.f3622d = o2;
        this.f3623e = new C0345a(aVar, o2, attributionTag);
        C0348d c0348dF = C0348d.f(applicationContext);
        this.f3626h = c0348dF;
        this.f3624f = c0348dF.f3818h.getAndIncrement();
        this.f3625g = aVar2.f3628a;
        p041f5.h hVar = c0348dF.f3822m;
        hVar.sendMessage(hVar.obtainMessage(7, this));
    }

    public final C0371b.a a() {
        GoogleSignInAccount googleSignInAccountC;
        GoogleSignInAccount googleSignInAccountC2;
        C0371b.a aVar = new C0371b.a();
        P4.a.c cVar = this.f3622d;
        boolean z8 = cVar instanceof P4.a.c.b;
        Account accountA = null;
        if (z8 && (googleSignInAccountC2 = ((P4.a.c.b) cVar).c()) != null) {
            String str = googleSignInAccountC2.f12428d;
            if (str != null) {
                accountA = new Account(str, "com.google");
            }
        } else if (cVar instanceof P4.a.c.InterfaceC0037a) {
            accountA = ((P4.a.c.InterfaceC0037a) cVar).a();
        }
        aVar.f4180a = accountA;
        Collection collectionD = (!z8 || (googleSignInAccountC = ((P4.a.c.b) cVar).c()) == null) ? Collections.EMPTY_SET : googleSignInAccountC.d();
        if (aVar.f4181b == null) {
            aVar.f4181b = new p155u.b(0);
        }
        aVar.f4181b.addAll(collectionD);
        Context context = this.f3619a;
        aVar.f4183d = context.getClass().getName();
        aVar.f4182c = context.getPackageName();
        return aVar;
    }

    @ResultIgnorabilityUnspecified
    public final n b(C0352h.a<?> aVar, int i9) {
        C0376g.f(aVar, "Listener key cannot be null.");
        C0348d c0348d = this.f3626h;
        c0348d.getClass();
        p094m5.f fVar = new p094m5.f();
        c0348d.e(fVar, i9, this);
        I i10 = new I(new U(aVar, fVar), c0348d.f3819i.get(), this);
        p041f5.h hVar = c0348d.f3822m;
        hVar.sendMessage(hVar.obtainMessage(13, i10));
        return fVar.f20355a;
    }

    public final n c(int i9, P p8) {
        p094m5.f fVar = new p094m5.f();
        C0348d c0348d = this.f3626h;
        c0348d.getClass();
        c0348d.e(fVar, p8.f3836c, this);
        I i10 = new I(new T(i9, p8, fVar, this.f3625g), c0348d.f3819i.get(), this);
        p041f5.h hVar = c0348d.f3822m;
        hVar.sendMessage(hVar.obtainMessage(4, i10));
        return fVar.f20355a;
    }
}

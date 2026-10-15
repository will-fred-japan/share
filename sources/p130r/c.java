package p130r;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: CustomTabsClient.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f21033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p130r.b f21034b;

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f21035a;

        public a(Bundle bundle) {
            this.f21035a = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onUnminimized(this.f21035a);
        }
    }

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f21038b;

        public b(int i9, Bundle bundle) {
            this.f21037a = i9;
            this.f21038b = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onNavigationEvent(this.f21037a, this.f21038b);
        }
    }

    /* JADX INFO: renamed from: r.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class RunnableC0246c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f21041b;

        public RunnableC0246c(String str, Bundle bundle) {
            this.f21040a = str;
            this.f21041b = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.extraCallback(this.f21040a, this.f21041b);
        }
    }

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f21043a;

        public d(Bundle bundle) {
            this.f21043a = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onMessageChannelReady(this.f21043a);
        }
    }

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f21046b;

        public e(String str, Bundle bundle) {
            this.f21045a = str;
            this.f21046b = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onPostMessage(this.f21045a, this.f21046b);
        }
    }

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f21049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f21050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bundle f21051d;

        public f(int i9, Uri uri, boolean z8, Bundle bundle) {
            this.f21048a = i9;
            this.f21049b = uri;
            this.f21050c = z8;
            this.f21051d = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onRelationshipValidationResult(this.f21048a, this.f21049b, this.f21050c, this.f21051d);
        }
    }

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bundle f21055c;

        public g(int i9, int i10, Bundle bundle) {
            this.f21053a = i9;
            this.f21054b = i10;
            this.f21055c = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onActivityResized(this.f21053a, this.f21054b, this.f21055c);
        }
    }

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f21057a;

        public h(Bundle bundle) {
            this.f21057a = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onWarmupCompleted(this.f21057a);
        }
    }

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f21061c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f21062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f21063e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Bundle f21064f;

        public i(int i9, int i10, int i11, int i12, int i13, Bundle bundle) {
            this.f21059a = i9;
            this.f21060b = i10;
            this.f21061c = i11;
            this.f21062d = i12;
            this.f21063e = i13;
            this.f21064f = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onActivityLayout(this.f21059a, this.f21060b, this.f21061c, this.f21062d, this.f21063e, this.f21064f);
        }
    }

    /* JADX INFO: compiled from: CustomTabsClient.java */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f21066a;

        public j(Bundle bundle) {
            this.f21066a = bundle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.f21034b.onMinimized(this.f21066a);
        }
    }

    public c(p130r.b bVar) {
        this.f21034b = bVar;
        attachInterface(this, p006b.c.f8471n);
        this.f21033a = new Handler(Looper.getMainLooper());
    }

    @Override // p006b.c
    public final void C(String str, Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new e(str, bundle));
    }

    @Override // p006b.c
    public final void D(Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new d(bundle));
    }

    @Override // p006b.c
    public final void F(int i9, Uri uri, boolean z8, Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new f(i9, uri, z8, bundle));
    }

    @Override // p006b.c
    public final void H(Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new j(bundle));
    }

    @Override // p006b.c
    public final void K(Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new a(bundle));
    }

    @Override // p006b.c
    public final void c(int i9, int i10, Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new g(i9, i10, bundle));
    }

    @Override // p006b.c
    public final void l(String str, Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new RunnableC0246c(str, bundle));
    }

    @Override // p006b.c
    public final void o(int i9, int i10, int i11, int i12, int i13, Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new i(i9, i10, i11, i12, i13, bundle));
    }

    @Override // p006b.c
    public final void p(Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new h(bundle));
    }

    @Override // p006b.c
    public final void r(int i9, Bundle bundle) {
        if (this.f21034b == null) {
            return;
        }
        this.f21033a.post(new b(i9, bundle));
    }

    @Override // p006b.c
    public final Bundle u(String str, Bundle bundle) {
        p130r.b bVar = this.f21034b;
        if (bVar == null) {
            return null;
        }
        return bVar.extraCallbackWithResult(str, bundle);
    }
}

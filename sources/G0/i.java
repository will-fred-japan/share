package G0;

import K7.p;
import U7.r;
import android.app.Activity;

/* JADX INFO: compiled from: WindowInfoTrackerImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H0.a f2233a;

    /* JADX INFO: compiled from: WindowInfoTrackerImpl.kt */
    @D7.e(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2", f = "WindowInfoTrackerImpl.kt", l = {63}, m = "invokeSuspend")
    public final class a extends D7.i implements p<r<? super j>, B7.e<? super p188x7.k>, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f2235c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Activity f2237e;

        /* JADX INFO: renamed from: G0.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WindowInfoTrackerImpl.kt */
        public static final class C0017a extends kotlin.jvm.internal.l implements K7.a<p188x7.k> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f2238a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f2239b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0017a(i iVar, h hVar) {
                super(0);
                this.f2238a = iVar;
                this.f2239b = hVar;
            }

            @Override // K7.a
            public final p188x7.k invoke() {
                this.f2238a.f2233a.b(this.f2239b);
                return p188x7.k.f22364a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Activity activity, B7.e<? super a> eVar) {
            super(2, eVar);
            this.f2237e = activity;
        }

        @Override // D7.a
        public final B7.e<p188x7.k> create(Object obj, B7.e<?> eVar) {
            a aVar = i.this.new a(this.f2237e, eVar);
            aVar.f2235c = obj;
            return aVar;
        }

        @Override // K7.p
        public final Object invoke(r<? super j> rVar, B7.e<? super p188x7.k> eVar) {
            return ((a) create(rVar, eVar)).invokeSuspend(p188x7.k.f22364a);
        }

        @Override // D7.a
        public final Object invokeSuspend(Object obj) {
            C7.a aVar = C7.a.f1806a;
            int i9 = this.f2234b;
            if (i9 == 0) {
                p188x7.g.b(obj);
                r rVar = (r) this.f2235c;
                h hVar = new h(0, rVar);
                i iVar = i.this;
                iVar.f2233a.a(this.f2237e, new p114p0.b(), hVar);
                C0017a c0017a = new C0017a(iVar, hVar);
                this.f2234b = 1;
                if (U7.p.a(rVar, c0017a, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p188x7.g.b(obj);
            }
            return p188x7.k.f22364a;
        }
    }

    public i(m windowMetricsCalculator, H0.a aVar) {
        kotlin.jvm.internal.k.e(windowMetricsCalculator, "windowMetricsCalculator");
        this.f2233a = aVar;
    }
}

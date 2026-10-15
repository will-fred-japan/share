package Q4;

import S4.C0376g;
import android.os.Looper;
import p071j5.AbstractC0609a;

/* JADX INFO: renamed from: Q4.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0352h<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorC0364u f3824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile x4.d.a f3825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile a f3826c;

    /* JADX INFO: renamed from: Q4.h$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static final class a<L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0609a f3827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3828b;

        public a(AbstractC0609a abstractC0609a, String str) {
            this.f3827a = abstractC0609a;
            this.f3828b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3827a == aVar.f3827a && this.f3828b.equals(aVar.f3828b);
        }

        public final int hashCode() {
            return this.f3828b.hashCode() + (System.identityHashCode(this.f3827a) * 31);
        }
    }

    /* JADX INFO: renamed from: Q4.h$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public interface b<L> {
        void a(x4.d.a aVar);
    }

    public C0352h(Looper looper, x4.d.a aVar, String str) {
        this.f3824a = new ExecutorC0364u(looper);
        C0376g.f(aVar, "Listener must not be null");
        this.f3825b = aVar;
        C0376g.d(str);
        this.f3826c = new a(aVar, str);
    }

    public final void a(b<? super L> bVar) {
        this.f3824a.execute(new D1.d(this, bVar, 2, false));
    }
}

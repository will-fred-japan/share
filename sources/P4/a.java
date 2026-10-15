package P4;

import B0.T;
import P4.a.c;
import S4.AbstractC0370a;
import S4.C0371b;
import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a<O extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0036a f3615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3616b;

    /* JADX INFO: renamed from: P4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static abstract class AbstractC0036a<T extends e, O> extends d<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, C0371b c0371b, O o2, P4.d.a aVar, P4.d.b bVar) {
            return (T) b(context, looper, c0371b, o2, aVar, bVar);
        }

        public e b(Context context, Looper looper, C0371b c0371b, Object obj, P4.d.a aVar, P4.d.b bVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static class b<C> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public interface c {

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final C0038c f3617b0 = new C0038c();

        /* JADX INFO: renamed from: P4.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
        public interface InterfaceC0037a extends c {
            Account a();
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
        public interface b extends c {
            GoogleSignInAccount c();
        }

        /* JADX INFO: renamed from: P4.a$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
        public static final class C0038c implements c {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static abstract class d<T, O> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public interface e {
        Set<Scope> b();

        void c(com.google.android.gms.common.internal.b bVar, Set<Scope> set);

        void d(String str);

        void disconnect();

        boolean e();

        int f();

        Feature[] g();

        String h();

        void i(AbstractC0370a.InterfaceC0049a interfaceC0049a);

        boolean isConnected();

        boolean isConnecting();

        String j();

        boolean k();

        void m(T t);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static final class f<C extends e> extends b<C> {
    }

    public <C extends e> a(String str, AbstractC0036a<C, O> abstractC0036a, f<C> fVar) {
        this.f3616b = str;
        this.f3615a = abstractC0036a;
    }
}

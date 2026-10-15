package okhttp3;

import K7.l;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Interceptor.kt */
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request);

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i9, TimeUnit timeUnit);

        Chain withReadTimeout(int i9, TimeUnit timeUnit);

        Chain withWriteTimeout(int i9, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    /* JADX INFO: compiled from: Interceptor.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Interceptor invoke(final l<? super Chain, Response> block) {
            k.e(block, "block");
            return new Interceptor() { // from class: okhttp3.Interceptor$Companion$invoke$1
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain it) {
                    k.e(it, "it");
                    return (Response) block.invoke(it);
                }
            };
        }
    }

    Response intercept(Chain chain);
}

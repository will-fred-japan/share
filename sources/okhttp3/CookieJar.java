package okhttp3;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import y7.p;

/* JADX INFO: compiled from: CookieJar.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface CookieJar {
    public static final Companion Companion = new Companion(null);
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    /* JADX INFO: compiled from: CookieJar.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        /* JADX INFO: compiled from: CookieJar.kt */
        public static final class NoCookies implements CookieJar {
            @Override // okhttp3.CookieJar
            public List<Cookie> loadForRequest(HttpUrl url) {
                k.e(url, "url");
                return p.f22408a;
            }

            @Override // okhttp3.CookieJar
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                k.e(url, "url");
                k.e(cookies, "cookies");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}

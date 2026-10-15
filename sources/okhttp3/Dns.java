package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import y7.g;

/* JADX INFO: compiled from: Dns.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface Dns {
    public static final Companion Companion = new Companion(null);
    public static final Dns SYSTEM = new Companion.DnsSystem();

    /* JADX INFO: compiled from: Dns.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        /* JADX INFO: compiled from: Dns.kt */
        public static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String hostname) throws UnknownHostException {
                k.e(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    k.d(allByName, "InetAddress.getAllByName(hostname)");
                    return g.o(allByName);
                } catch (NullPointerException e9) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostname));
                    unknownHostException.initCause(e9);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    List<InetAddress> lookup(String str);
}

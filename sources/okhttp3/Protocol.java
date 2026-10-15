package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final Companion Companion = new Companion(null);
    private final String protocol;

    /* JADX INFO: compiled from: Protocol.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Protocol get(String protocol) throws IOException {
            k.e(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (protocol.equals(protocol2.protocol)) {
                return protocol2;
            }
            Protocol protocol3 = Protocol.HTTP_1_1;
            if (protocol.equals(protocol3.protocol)) {
                return protocol3;
            }
            Protocol protocol4 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (protocol.equals(protocol4.protocol)) {
                return protocol4;
            }
            Protocol protocol5 = Protocol.HTTP_2;
            if (protocol.equals(protocol5.protocol)) {
                return protocol5;
            }
            Protocol protocol6 = Protocol.SPDY_3;
            if (protocol.equals(protocol6.protocol)) {
                return protocol6;
            }
            Protocol protocol7 = Protocol.QUIC;
            if (protocol.equals(protocol7.protocol)) {
                return protocol7;
            }
            throw new IOException("Unexpected protocol: ".concat(protocol));
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) {
        return Companion.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}

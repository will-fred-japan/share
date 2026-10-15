package okhttp3.internal.http;

import R7.i;
import java.net.ProtocolException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Protocol;
import okhttp3.Response;

/* JADX INFO: compiled from: StatusLine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* JADX INFO: compiled from: StatusLine.kt */
    public static final class Companion {
        private Companion() {
        }

        public final StatusLine get(Response response) {
            k.e(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String statusLine) throws ProtocolException {
            Protocol protocol;
            int i9;
            String strSubstring;
            k.e(statusLine, "statusLine");
            if (i.N(statusLine, "HTTP/1.", false)) {
                i9 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!i.N(statusLine, "ICY ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                protocol = Protocol.HTTP_1_0;
                i9 = 4;
            }
            int i10 = i9 + 3;
            if (statusLine.length() < i10) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            try {
                String strSubstring2 = statusLine.substring(i9, i10);
                k.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int i11 = Integer.parseInt(strSubstring2);
                if (statusLine.length() <= i10) {
                    strSubstring = "";
                } else {
                    if (statusLine.charAt(i10) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    strSubstring = statusLine.substring(i9 + 4);
                    k.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                }
                return new StatusLine(protocol, i11, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public StatusLine(Protocol protocol, int i9, String message) {
        k.e(protocol, "protocol");
        k.e(message, "message");
        this.protocol = protocol;
        this.code = i9;
        this.message = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String string = sb.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}

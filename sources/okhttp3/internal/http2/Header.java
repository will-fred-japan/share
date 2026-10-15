package okhttp3.internal.http2;

import com.xiaomi.mipush.sdk.Constants;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okio.ByteString;

/* JADX INFO: compiled from: Header.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final ByteString PSEUDO_PREFIX;
    public static final ByteString RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    /* JADX INFO: compiled from: Header.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PSEUDO_PREFIX = companion.encodeUtf8(Constants.COLON_SEPARATOR);
        RESPONSE_STATUS = companion.encodeUtf8(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = companion.encodeUtf8(TARGET_METHOD_UTF8);
        TARGET_PATH = companion.encodeUtf8(TARGET_PATH_UTF8);
        TARGET_SCHEME = companion.encodeUtf8(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = companion.encodeUtf8(TARGET_AUTHORITY_UTF8);
    }

    public Header(ByteString name, ByteString value) {
        k.e(name, "name");
        k.e(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = value.size() + name.size() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            byteString = header.name;
        }
        if ((i9 & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    public final ByteString component1() {
        return this.name;
    }

    public final ByteString component2() {
        return this.value;
    }

    public final Header copy(ByteString name, ByteString value) {
        k.e(name, "name");
        k.e(value, "value");
        return new Header(name, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return k.a(this.name, header.name) && k.a(this.value, header.value);
    }

    public int hashCode() {
        ByteString byteString = this.name;
        int iHashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.value;
        return iHashCode + (byteString2 != null ? byteString2.hashCode() : 0);
    }

    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Header(String name, String value) {
        k.e(name, "name");
        k.e(value, "value");
        ByteString.Companion companion = ByteString.Companion;
        this(companion.encodeUtf8(name), companion.encodeUtf8(value));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(ByteString name, String value) {
        this(name, ByteString.Companion.encodeUtf8(value));
        k.e(name, "name");
        k.e(value, "value");
    }
}

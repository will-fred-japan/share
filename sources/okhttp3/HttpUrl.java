package okhttp3;

import R7.i;
import R7.l;
import W5.e;
import com.alibaba.fastjson.asm.Opcodes;
import com.jieli.jl_bt_ota.constant.Command;
import com.starburst.sdk.req.GuiControlRequest;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import okio.Utf8;
import y7.p;
import y7.r;

/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;

        /* JADX INFO: compiled from: HttpUrl.kt */
        public static final class Companion {
            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i9, int i10) {
                try {
                    int i11 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i9, i10, "", false, false, false, false, null, 248, null));
                    if (1 <= i11 && 65535 >= i11) {
                        return i11;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i9, int i10) {
                while (i9 < i10) {
                    char cCharAt = str.charAt(i9);
                    if (cCharAt == ':') {
                        return i9;
                    }
                    if (cCharAt == '[') {
                        do {
                            i9++;
                            if (i9 >= i10) {
                                break;
                            }
                        } while (str.charAt(i9) != ']');
                    }
                    i9++;
                }
                return i10;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i9, int i10) {
                if (i10 - i9 < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i9);
                if ((k.f(cCharAt, 97) >= 0 && k.f(cCharAt, 122) <= 0) || (k.f(cCharAt, 65) >= 0 && k.f(cCharAt, 90) <= 0)) {
                    while (true) {
                        i9++;
                        if (i9 >= i10) {
                            break;
                        }
                        char cCharAt2 = str.charAt(i9);
                        if ('a' > cCharAt2 || 'z' < cCharAt2) {
                            if ('A' > cCharAt2 || 'Z' < cCharAt2) {
                                if ('0' > cCharAt2 || '9' < cCharAt2) {
                                    if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                        if (cCharAt2 == ':') {
                                            return i9;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i9, int i10) {
                int i11 = 0;
                while (i9 < i10) {
                    char cCharAt = str.charAt(i9);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i11++;
                    i9++;
                }
                return i11;
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i9 = this.port;
            if (i9 != -1) {
                return i9;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            k.b(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return k.a(str, ".") || i.H(str, "%2e");
        }

        private final boolean isDotDot(String str) {
            return k.a(str, "..") || i.H(str, "%2e.") || i.H(str, ".%2e") || i.H(str, "%2e%2e");
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        private final void push(String str, int i9, int i10, boolean z8, boolean z9) {
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i9, i10, HttpUrl.PATH_SEGMENT_ENCODE_SET, z9, false, false, false, null, 240, null);
            if (isDot(strCanonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(strCanonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strCanonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(strCanonicalize$okhttp$default);
            }
            if (z8) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            k.b(list);
            O7.f fVarZ = O7.k.Z(new O7.f(list.size() - 2, 0, -1), 2);
            int i9 = fVarZ.f3585a;
            int i10 = fVarZ.f3586b;
            int i11 = fVarZ.f3587c;
            if (i11 >= 0) {
                if (i9 > i10) {
                    return;
                }
            } else if (i9 < i10) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                k.b(list2);
                if (k.a(str, list2.get(i9))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    k.b(list3);
                    list3.remove(i9 + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    k.b(list4);
                    list4.remove(i9);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    k.b(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (i9 == i10) {
                    return;
                } else {
                    i9 += i11;
                }
            }
        }

        private final void resolvePath(String str, int i9, int i10) {
            if (i9 == i10) {
                return;
            }
            char cCharAt = str.charAt(i9);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i9++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i11 = i9;
            while (i11 < i10) {
                int iDelimiterOffset = Util.delimiterOffset(str, "/\\", i11, i10);
                boolean z8 = iDelimiterOffset < i10;
                String str2 = str;
                push(str2, i11, iDelimiterOffset, z8, true);
                if (z8) {
                    iDelimiterOffset++;
                }
                i11 = iDelimiterOffset;
                str = str2;
            }
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            k.e(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments) {
            k.e(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        public final Builder addEncodedQueryParameter(String encodedName, String str) {
            k.e(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            k.b(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            k.b(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null) : null);
            return this;
        }

        public final Builder addPathSegment(String pathSegment) {
            k.e(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            k.e(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addQueryParameter(String name, String str) {
            k.e(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            k.b(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            k.b(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.Companion;
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(y7.i.E(list));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                List<String> list3 = list2;
                arrayList = new ArrayList(y7.i.E(list3));
                for (String str3 : list3) {
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2, iEffectivePort, arrayList2, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null) : null;
            return this;
        }

        public final Builder encodedPassword(String encodedPassword) {
            k.e(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            k.e(encodedPath, "encodedPath");
            if (!i.N(encodedPath, "/", false)) {
                throw new IllegalArgumentException("unexpected encodedPath: ".concat(encodedPath).toString());
            }
            resolvePath(encodedPath, 0, encodedPath.length());
            return this;
        }

        public final Builder encodedQuery(String str) {
            Companion companion;
            String strCanonicalize$okhttp$default;
            this.encodedQueryNamesAndValues = (str == null || (strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default((companion = HttpUrl.Companion), str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null)) == null) ? null : companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
            return this;
        }

        public final Builder encodedUsername(String encodedUsername) {
            k.e(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, Opcodes.NEW, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String host) {
            k.e(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(host));
            }
            this.host = canonicalHost;
            return this;
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int iDelimiterOffset;
            int i9;
            boolean z8;
            int i10;
            boolean z9;
            int i11;
            boolean z10;
            char c5;
            String input = str;
            k.e(input, "input");
            int iIndexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int iIndexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input, iIndexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int iSchemeDelimiterOffset = companion.schemeDelimiterOffset(input, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            boolean z11 = true;
            byte b9 = -1;
            if (iSchemeDelimiterOffset != -1) {
                if (i.M(input, "https:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!i.M(input, "http:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                        StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input.substring(0, iSchemeDelimiterOffset);
                        k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = GuiControlRequest.IMAGE_TYPE_HTTP;
                    iIndexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme();
            }
            int iSlashCount = companion.slashCount(input, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            byte b10 = Utf8.REPLACEMENT_BYTE;
            byte b11 = 35;
            if (iSlashCount >= 2 || httpUrl == null || !k.a(httpUrl.scheme(), this.scheme)) {
                int i12 = iIndexOfFirstNonAsciiWhitespace$default + iSlashCount;
                boolean z12 = false;
                boolean z13 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(input, "@/\\?#", i12, iIndexOfLastNonAsciiWhitespace$default);
                    byte bCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace$default ? input.charAt(iDelimiterOffset) : b9;
                    if (bCharAt == b9 || bCharAt == b11 || bCharAt == 47 || bCharAt == 92 || bCharAt == b10) {
                        break;
                    }
                    if (bCharAt != 64) {
                        z8 = z11;
                        iIndexOfLastNonAsciiWhitespace$default = iIndexOfLastNonAsciiWhitespace$default;
                    } else {
                        if (z12) {
                            z8 = z11;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            input = str;
                            i10 = iDelimiterOffset;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, i12, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb2.toString();
                            z9 = z13;
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(input, ':', i12, iDelimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            z8 = z11;
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i12, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z13) {
                                strCanonicalize$okhttp$default = W5.f.k(new StringBuilder(), this.encodedUsername, "%40", strCanonicalize$okhttp$default);
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                i11 = iDelimiterOffset;
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str, iDelimiterOffset2 + 1, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z10 = z8;
                            } else {
                                i11 = iDelimiterOffset;
                                z10 = z12;
                            }
                            input = str;
                            i10 = i11;
                            z12 = z10;
                            z9 = z8;
                        }
                        i12 = i10 + 1;
                        z13 = z9;
                    }
                    z11 = z8;
                    iIndexOfLastNonAsciiWhitespace$default = iIndexOfLastNonAsciiWhitespace$default;
                    b10 = Utf8.REPLACEMENT_BYTE;
                    b9 = -1;
                    b11 = 35;
                }
                boolean z14 = z11;
                i9 = iIndexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int iPortColonOffset = companion3.portColonOffset(input, i12, iDelimiterOffset);
                int i13 = iPortColonOffset + 1;
                if (i13 < iDelimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, i12, iPortColonOffset, false, 4, null));
                    int port = companion3.parsePort(input, i13, iDelimiterOffset);
                    this.port = port;
                    if (!(port != -1 ? z14 : false)) {
                        StringBuilder sb3 = new StringBuilder("Invalid URL port: \"");
                        String strSubstring2 = input.substring(i13, iDelimiterOffset);
                        k.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb3.append(strSubstring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, input, i12, iPortColonOffset, false, 4, null));
                    String str2 = this.scheme;
                    k.b(str2);
                    this.port = companion4.defaultPort(str2);
                }
                if (!(this.host != null ? z14 : false)) {
                    StringBuilder sb4 = new StringBuilder("Invalid URL host: \"");
                    String strSubstring3 = input.substring(i12, iPortColonOffset);
                    k.d(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb4.append(strSubstring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iIndexOfFirstNonAsciiWhitespace$default = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace$default == iIndexOfLastNonAsciiWhitespace$default || input.charAt(iIndexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i9 = iIndexOfLastNonAsciiWhitespace$default;
            }
            int i14 = i9;
            int iDelimiterOffset3 = Util.delimiterOffset(input, "?#", iIndexOfFirstNonAsciiWhitespace$default, i14);
            resolvePath(input, iIndexOfFirstNonAsciiWhitespace$default, iDelimiterOffset3);
            if (iDelimiterOffset3 >= i14 || input.charAt(iDelimiterOffset3) != '?') {
                c5 = '#';
            } else {
                c5 = '#';
                int iDelimiterOffset4 = Util.delimiterOffset(input, '#', iDelimiterOffset3, i14);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, iDelimiterOffset3 + 1, iDelimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < i14 && input.charAt(iDelimiterOffset3) == c5) {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, iDelimiterOffset3 + 1, i14, "", true, false, false, true, null, Opcodes.ARETURN, null);
            }
            return this;
        }

        public final Builder password(String password) {
            k.e(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final Builder port(int i9) {
            if (!(1 <= i9 && 65535 >= i9)) {
                throw new IllegalArgumentException(e.i(i9, "unexpected port: ").toString());
            }
            this.port = i9;
            return this;
        }

        public final Builder query(String str) {
            Companion companion;
            String strCanonicalize$okhttp$default;
            this.encodedQueryNamesAndValues = (str == null || (strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default((companion = HttpUrl.Companion), str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null)) == null) ? null : companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String strReplaceAll;
            String str = this.host;
            if (str != null) {
                Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
                k.d(patternCompile, "compile(...)");
                strReplaceAll = patternCompile.matcher(str).replaceAll("");
                k.d(strReplaceAll, "replaceAll(...)");
            } else {
                strReplaceAll = null;
            }
            this.host = strReplaceAll;
            int size = this.encodedPathSegments.size();
            for (int i9 = 0; i9 < size; i9++) {
                List<String> list = this.encodedPathSegments;
                list.set(i9, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i9), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, Command.CMD_OTA_ENTER_UPDATE_MODE, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    String str2 = list2.get(i10);
                    list2.set(i10, str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, Command.CMD_ADV_NOTIFY_SETTINGS, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, Opcodes.IF_ICMPGT, null) : null;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            k.e(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            k.e(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final Builder removePathSegment(int i9) {
            this.encodedPathSegments.remove(i9);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String scheme) {
            k.e(scheme, "scheme");
            if (scheme.equalsIgnoreCase(GuiControlRequest.IMAGE_TYPE_HTTP)) {
                this.scheme = GuiControlRequest.IMAGE_TYPE_HTTP;
                return this;
            }
            if (!scheme.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(scheme));
            }
            this.scheme = "https";
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            k.e(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i9, String encodedPathSegment) {
            k.e(encodedPathSegment, "encodedPathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i9, strCanonicalize$okhttp$default);
            if ((isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: ".concat(encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String str) {
            k.e(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            k.e(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i9, String pathSegment) {
            k.e(pathSegment, "pathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (!((isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) ? false : true)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(pathSegment).toString());
            }
            this.encodedPathSegments.set(i9, strCanonicalize$okhttp$default);
            return this;
        }

        public final void setPort$okhttp(int i9) {
            this.port = i9;
        }

        public final Builder setQueryParameter(String name, String str) {
            k.e(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (l.P(str2, ':')) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null || iEffectivePort != HttpUrl.Companion.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                }
            }
            Companion companion = HttpUrl.Companion;
            companion.toPathString$okhttp(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                k.b(list);
                companion.toQueryString$okhttp(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            String string = sb.toString();
            k.d(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public final Builder username(String username) {
            k.e(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z8) {
            int i9 = 0;
            while (true) {
                int iDelimiterOffset = Util.delimiterOffset(str, "/\\", i9, str.length());
                push(str, i9, iDelimiterOffset, iDelimiterOffset < str.length(), z8);
                i9 = iDelimiterOffset + 1;
                if (i9 > str.length()) {
                    return this;
                }
                str = str;
                z8 = z8;
            }
        }
    }

    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i9, int i10, String str2, boolean z8, boolean z9, boolean z10, boolean z11, Charset charset, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i9 = 0;
            }
            if ((i11 & 2) != 0) {
                i10 = str.length();
            }
            if ((i11 & 8) != 0) {
                z8 = false;
            }
            if ((i11 & 16) != 0) {
                z9 = false;
            }
            if ((i11 & 32) != 0) {
                z10 = false;
            }
            if ((i11 & 64) != 0) {
                z11 = false;
            }
            if ((i11 & 128) != 0) {
                charset = null;
            }
            return companion.canonicalize$okhttp(str, i9, i10, str2, z8, z9, z10, z11, charset);
        }

        private final boolean isPercentEncoded(String str, int i9, int i10) {
            int i11 = i9 + 2;
            return i11 < i10 && str.charAt(i9) == '%' && Util.parseHexDigit(str.charAt(i9 + 1)) != -1 && Util.parseHexDigit(str.charAt(i11)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i9, int i10, boolean z8, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i9 = 0;
            }
            if ((i11 & 2) != 0) {
                i10 = str.length();
            }
            if ((i11 & 4) != 0) {
                z8 = false;
            }
            return companion.percentDecode$okhttp(str, i9, i10, z8);
        }

        private final void writeCanonicalized(Buffer buffer, String str, int i9, int i10, String str2, boolean z8, boolean z9, boolean z10, boolean z11, Charset charset) throws EOFException {
            Buffer buffer2 = null;
            int iCharCount = i9;
            while (iCharCount < i10) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z8 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z10) {
                        buffer.writeUtf8(z8 ? "+" : "%2B");
                    } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z11) || l.P(str2, (char) iCodePointAt) || (iCodePointAt == 37 && (!z8 || (z9 && !isPercentEncoded(str, iCharCount, i10)))))) {
                        if (buffer2 == null) {
                            buffer2 = new Buffer();
                        }
                        if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                            buffer2.writeUtf8CodePoint(iCodePointAt);
                        } else {
                            buffer2.writeString(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!buffer2.exhausted()) {
                            byte b9 = buffer2.readByte();
                            buffer.writeByte(37);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[((b9 & 255) >> 4) & 15]);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[b9 & 15]);
                        }
                    } else {
                        buffer.writeUtf8CodePoint(iCodePointAt);
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i9, int i10, boolean z8) {
            int i11;
            while (i9 < i10) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int iCodePointAt = str.codePointAt(i9);
                if (iCodePointAt == 37 && (i11 = i9 + 2) < i10) {
                    int hexDigit = Util.parseHexDigit(str.charAt(i9 + 1));
                    int hexDigit2 = Util.parseHexDigit(str.charAt(i11));
                    if (hexDigit == -1 || hexDigit2 == -1) {
                        buffer.writeUtf8CodePoint(iCodePointAt);
                        i9 += Character.charCount(iCodePointAt);
                    } else {
                        buffer.writeByte((hexDigit << 4) + hexDigit2);
                        i9 = Character.charCount(iCodePointAt) + i11;
                    }
                } else if (iCodePointAt == 43 && z8) {
                    buffer.writeByte(32);
                    i9++;
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                    i9 += Character.charCount(iCodePointAt);
                }
            }
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m919deprecated_get(String url) {
            k.e(url, "url");
            return get(url);
        }

        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m922deprecated_parse(String url) {
            k.e(url, "url");
            return parse(url);
        }

        public final String canonicalize$okhttp(String canonicalize, int i9, int i10, String encodeSet, boolean z8, boolean z9, boolean z10, boolean z11, Charset charset) throws EOFException {
            k.e(canonicalize, "$this$canonicalize");
            k.e(encodeSet, "encodeSet");
            int iCharCount = i9;
            while (iCharCount < i10) {
                int iCodePointAt = canonicalize.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z11) || l.P(encodeSet, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z8 || (z9 && !isPercentEncoded(canonicalize, iCharCount, i10)))) || (iCodePointAt == 43 && z10)))) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(canonicalize, i9, iCharCount);
                    writeCanonicalized(buffer, canonicalize, iCharCount, i10, encodeSet, z8, z9, z10, z11, charset);
                    return buffer.readUtf8();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring = canonicalize.substring(i9, i10);
            k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final int defaultPort(String scheme) {
            k.e(scheme, "scheme");
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3213448) {
                return (iHashCode == 99617003 && scheme.equals("https")) ? 443 : -1;
            }
            return scheme.equals(GuiControlRequest.IMAGE_TYPE_HTTP) ? 80 : -1;
        }

        public final HttpUrl get(String toHttpUrl) {
            k.e(toHttpUrl, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, toHttpUrl).build();
        }

        public final HttpUrl parse(String toHttpUrlOrNull) {
            k.e(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return get(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String percentDecode, int i9, int i10, boolean z8) {
            k.e(percentDecode, "$this$percentDecode");
            for (int i11 = i9; i11 < i10; i11++) {
                char cCharAt = percentDecode.charAt(i11);
                if (cCharAt == '%' || (cCharAt == '+' && z8)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(percentDecode, i9, i11);
                    writePercentDecoded(buffer, percentDecode, i11, i10, z8);
                    return buffer.readUtf8();
                }
            }
            String strSubstring = percentDecode.substring(i9, i10);
            k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void toPathString$okhttp(List<String> toPathString, StringBuilder out) {
            k.e(toPathString, "$this$toPathString");
            k.e(out, "out");
            int size = toPathString.size();
            for (int i9 = 0; i9 < size; i9++) {
                out.append('/');
                out.append(toPathString.get(i9));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String toQueryNamesAndValues) {
            k.e(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i9 = 0;
            while (i9 <= toQueryNamesAndValues.length()) {
                int iS = l.S(toQueryNamesAndValues, '&', i9, 4);
                if (iS == -1) {
                    iS = toQueryNamesAndValues.length();
                }
                int iS2 = l.S(toQueryNamesAndValues, '=', i9, 4);
                if (iS2 == -1 || iS2 > iS) {
                    String strSubstring = toQueryNamesAndValues.substring(i9, iS);
                    k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = toQueryNamesAndValues.substring(i9, iS2);
                    k.d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = toQueryNamesAndValues.substring(iS2 + 1, iS);
                    k.d(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i9 = iS + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> toQueryString, StringBuilder out) {
            k.e(toQueryString, "$this$toQueryString");
            k.e(out, "out");
            O7.f fVarZ = O7.k.Z(O7.k.a0(0, toQueryString.size()), 2);
            int i9 = fVarZ.f3585a;
            int i10 = fVarZ.f3586b;
            int i11 = fVarZ.f3587c;
            if (i11 >= 0) {
                if (i9 > i10) {
                    return;
                }
            } else if (i9 < i10) {
                return;
            }
            while (true) {
                String str = toQueryString.get(i9);
                String str2 = toQueryString.get(i9 + 1);
                if (i9 > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (i9 == i10) {
                    return;
                } else {
                    i9 += i11;
                }
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m921deprecated_get(URL url) {
            k.e(url, "url");
            return get(url);
        }

        public final HttpUrl get(URL toHttpUrlOrNull) {
            k.e(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String string = toHttpUrlOrNull.toString();
            k.d(string, "toString()");
            return parse(string);
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m920deprecated_get(URI uri) {
            k.e(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI toHttpUrlOrNull) {
            k.e(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String string = toHttpUrlOrNull.toString();
            k.d(string, "toString()");
            return parse(string);
        }
    }

    public HttpUrl(String scheme, String username, String password, String host, int i9, List<String> pathSegments, List<String> list, String str, String url) {
        k.e(scheme, "scheme");
        k.e(username, "username");
        k.e(password, "password");
        k.e(host, "host");
        k.e(pathSegments, "pathSegments");
        k.e(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i9;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = k.a(scheme, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* JADX INFO: renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m900deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* JADX INFO: renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m901deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* JADX INFO: renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m902deprecated_encodedPath() {
        return encodedPath();
    }

    /* JADX INFO: renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m903deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* JADX INFO: renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m904deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* JADX INFO: renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m905deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* JADX INFO: renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m906deprecated_fragment() {
        return this.fragment;
    }

    /* JADX INFO: renamed from: -deprecated_host, reason: not valid java name */
    public final String m907deprecated_host() {
        return this.host;
    }

    /* JADX INFO: renamed from: -deprecated_password, reason: not valid java name */
    public final String m908deprecated_password() {
        return this.password;
    }

    /* JADX INFO: renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m909deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* JADX INFO: renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m910deprecated_pathSize() {
        return pathSize();
    }

    /* JADX INFO: renamed from: -deprecated_port, reason: not valid java name */
    public final int m911deprecated_port() {
        return this.port;
    }

    /* JADX INFO: renamed from: -deprecated_query, reason: not valid java name */
    public final String m912deprecated_query() {
        return query();
    }

    /* JADX INFO: renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m913deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* JADX INFO: renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m914deprecated_querySize() {
        return querySize();
    }

    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m915deprecated_scheme() {
        return this.scheme;
    }

    /* JADX INFO: renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m916deprecated_uri() {
        return uri();
    }

    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final URL m917deprecated_url() {
        return url();
    }

    /* JADX INFO: renamed from: -deprecated_username, reason: not valid java name */
    public final String m918deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int iS = l.S(this.url, '#', 0, 6) + 1;
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iS);
        k.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int iS = l.S(this.url, ':', this.scheme.length() + 3, 4) + 1;
        int iS2 = l.S(this.url, '@', 0, 6);
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iS, iS2);
        k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedPath() {
        int iS = l.S(this.url, '/', this.scheme.length() + 3, 4);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, "?#", iS, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iS, iDelimiterOffset);
        k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> encodedPathSegments() {
        int iS = l.S(this.url, '/', this.scheme.length() + 3, 4);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, "?#", iS, str.length());
        ArrayList arrayList = new ArrayList();
        while (iS < iDelimiterOffset) {
            int i9 = iS + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.url, '/', i9, iDelimiterOffset);
            String str2 = this.url;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i9, iDelimiterOffset2);
            k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iS = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iS = l.S(this.url, '?', 0, 6) + 1;
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, '#', iS, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iS, iDelimiterOffset);
        k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iDelimiterOffset);
        k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && k.a(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String name) {
        k.e(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        O7.f fVarZ = O7.k.Z(O7.k.a0(0, list.size()), 2);
        int i9 = fVarZ.f3585a;
        int i10 = fVarZ.f3586b;
        int i11 = fVarZ.f3587c;
        if (i11 < 0 ? i9 >= i10 : i9 <= i10) {
            while (!name.equals(this.queryNamesAndValues.get(i9))) {
                if (i9 != i10) {
                    i9 += i11;
                }
            }
            return this.queryNamesAndValues.get(i9 + 1);
        }
        return null;
    }

    public final String queryParameterName(int i9) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i9 * 2);
        k.b(str);
        return str;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return r.f22410a;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        O7.f fVarZ = O7.k.Z(O7.k.a0(0, this.queryNamesAndValues.size()), 2);
        int i9 = fVarZ.f3585a;
        int i10 = fVarZ.f3586b;
        int i11 = fVarZ.f3587c;
        if (i11 < 0 ? i9 >= i10 : i9 <= i10) {
            while (true) {
                String str = this.queryNamesAndValues.get(i9);
                k.b(str);
                linkedHashSet.add(str);
                if (i9 == i10) {
                    break;
                }
                i9 += i11;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        k.d(setUnmodifiableSet, "Collections.unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final String queryParameterValue(int i9) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i9 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String name) {
        k.e(name, "name");
        if (this.queryNamesAndValues == null) {
            return p.f22408a;
        }
        ArrayList arrayList = new ArrayList();
        O7.f fVarZ = O7.k.Z(O7.k.a0(0, this.queryNamesAndValues.size()), 2);
        int i9 = fVarZ.f3585a;
        int i10 = fVarZ.f3586b;
        int i11 = fVarZ.f3587c;
        if (i11 < 0 ? i9 >= i10 : i9 <= i10) {
            while (true) {
                if (name.equals(this.queryNamesAndValues.get(i9))) {
                    arrayList.add(this.queryNamesAndValues.get(i9 + 1));
                }
                if (i9 == i10) {
                    break;
                }
                i9 += i11;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        k.d(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        k.b(builderNewBuilder);
        return builderNewBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String link) {
        k.e(link, "link");
        Builder builderNewBuilder = newBuilder(link);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String input = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(input);
        } catch (URISyntaxException e9) {
            try {
                Pattern patternCompile = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                k.d(patternCompile, "compile(...)");
                k.e(input, "input");
                String strReplaceAll = patternCompile.matcher(input).replaceAll("");
                k.d(strReplaceAll, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll);
                k.d(uriCreate, "try {\n        val stripp…e) // Unexpected!\n      }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e9);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e9) {
            throw new RuntimeException(e9);
        }
    }

    public final String username() {
        return this.username;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public final Builder newBuilder(String link) {
        k.e(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}

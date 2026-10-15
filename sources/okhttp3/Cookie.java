package okhttp3;

import A.a;
import R7.i;
import R7.l;
import W5.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import y7.p;

/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: compiled from: Cookie.kt */
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String domain) {
            k.e(domain, "domain");
            return domain(domain, false);
        }

        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DatesKt.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String domain) {
            k.e(domain, "domain");
            return domain(domain, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String name) {
            k.e(name, "name");
            if (!k.a(l.d0(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = name;
            return this;
        }

        public final Builder path(String path) {
            k.e(path, "path");
            if (!i.N(path, "/", false)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = path;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String value) {
            k.e(value, "value");
            if (!k.a(l.d0(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = value;
            return this;
        }

        private final Builder domain(String str, boolean z8) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(e.l("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z8;
            return this;
        }
    }

    /* JADX INFO: compiled from: Cookie.kt */
    public static final class Companion {
        private Companion() {
        }

        private final int dateCharacterOffset(String str, int i9, int i10, boolean z8) {
            while (i9 < i10) {
                char cCharAt = str.charAt(i9);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z8)) {
                    return i9;
                }
                i9++;
            }
            return i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            return k.a(str, str2) || (i.G(str, str2, false) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str));
        }

        private final String parseDomain(String str) {
            if (i.G(str, ".", false)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(l.Y(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i9, int i10) {
            int iDateCharacterOffset = dateCharacterOffset(str, i9, i10, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int iT = -1;
            int i14 = -1;
            int i15 = -1;
            while (iDateCharacterOffset < i10) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i10, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i12 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    k.d(strGroup, "matcher.group(1)");
                    i12 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    k.d(strGroup2, "matcher.group(2)");
                    i14 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    k.d(strGroup3, "matcher.group(3)");
                    i15 = Integer.parseInt(strGroup3);
                } else if (i13 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    k.d(strGroup4, "matcher.group(1)");
                    i13 = Integer.parseInt(strGroup4);
                } else if (iT == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    k.d(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    k.d(locale, "Locale.US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    k.d(strPattern, "MONTH_PATTERN.pattern()");
                    iT = l.T(strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i11 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    k.d(strGroup6, "matcher.group(1)");
                    i11 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i10, false);
            }
            if (70 <= i11 && 99 >= i11) {
                i11 += 1900;
            }
            if (i11 >= 0 && 69 >= i11) {
                i11 += 2000;
            }
            if (!(i11 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iT == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i13 || 31 < i13) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i12 < 0 || 23 < i12) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i14 < 0 || 59 < i14) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i15 < 0 || 59 < i15) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i11);
            gregorianCalendar.set(2, iT - 1);
            gregorianCalendar.set(5, i13);
            gregorianCalendar.set(11, i12);
            gregorianCalendar.set(12, i14);
            gregorianCalendar.set(13, i15);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String input) {
            try {
                long j = Long.parseLong(input);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e9) {
                Pattern patternCompile = Pattern.compile("-?\\d+");
                k.d(patternCompile, "compile(...)");
                k.e(input, "input");
                if (patternCompile.matcher(input).matches()) {
                    return i.N(input, Constants.ACCEPT_TIME_SEPARATOR_SERVER, false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e9;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (k.a(strEncodedPath, str)) {
                return true;
            }
            return i.N(strEncodedPath, str, false) && (i.G(str, "/", false) || strEncodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl url, String setCookie) {
            k.e(url, "url");
            k.e(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        public final Cookie parse$okhttp(long j, HttpUrl url, String setCookie) {
            long j8;
            String str;
            k.e(url, "url");
            k.e(setCookie, "setCookie");
            int iDelimiterOffset$default = Util.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int iDelimiterOffset$default2 = Util.delimiterOffset$default(setCookie, '=', 0, iDelimiterOffset$default, 2, (Object) null);
            String domain = null;
            if (iDelimiterOffset$default2 != iDelimiterOffset$default) {
                String strTrimSubstring$default = Util.trimSubstring$default(setCookie, 0, iDelimiterOffset$default2, 1, null);
                if (strTrimSubstring$default.length() != 0 && Util.indexOfControlOrNonAscii(strTrimSubstring$default) == -1) {
                    String strTrimSubstring = Util.trimSubstring(setCookie, iDelimiterOffset$default2 + 1, iDelimiterOffset$default);
                    if (Util.indexOfControlOrNonAscii(strTrimSubstring) == -1) {
                        int i9 = iDelimiterOffset$default + 1;
                        int length = setCookie.length();
                        boolean z8 = false;
                        boolean z9 = false;
                        boolean z10 = false;
                        boolean z11 = true;
                        long maxAge = -1;
                        long expires = DatesKt.MAX_DATE;
                        String str2 = null;
                        while (i9 < length) {
                            int iDelimiterOffset = Util.delimiterOffset(setCookie, ';', i9, length);
                            int iDelimiterOffset2 = Util.delimiterOffset(setCookie, '=', i9, iDelimiterOffset);
                            String strTrimSubstring2 = Util.trimSubstring(setCookie, i9, iDelimiterOffset2);
                            String strTrimSubstring3 = iDelimiterOffset2 < iDelimiterOffset ? Util.trimSubstring(setCookie, iDelimiterOffset2 + 1, iDelimiterOffset) : "";
                            if (i.H(strTrimSubstring2, "expires")) {
                                try {
                                    expires = parseExpires(strTrimSubstring3, 0, strTrimSubstring3.length());
                                    z9 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (i.H(strTrimSubstring2, "max-age")) {
                                maxAge = parseMaxAge(strTrimSubstring3);
                                z9 = true;
                            } else if (i.H(strTrimSubstring2, "domain")) {
                                domain = parseDomain(strTrimSubstring3);
                                z11 = false;
                            } else if (i.H(strTrimSubstring2, "path")) {
                                str2 = strTrimSubstring3;
                            } else if (i.H(strTrimSubstring2, "secure")) {
                                z10 = true;
                            } else if (i.H(strTrimSubstring2, "httponly")) {
                                z8 = true;
                            }
                            i9 = iDelimiterOffset + 1;
                        }
                        if (maxAge == Long.MIN_VALUE) {
                            j8 = Long.MIN_VALUE;
                        } else if (maxAge != -1) {
                            long j9 = j + (maxAge <= 9223372036854775L ? maxAge * ((long) 1000) : Long.MAX_VALUE);
                            j8 = (j9 < j || j9 > DatesKt.MAX_DATE) ? 253402300799999L : j9;
                        } else {
                            j8 = expires;
                        }
                        String strHost = url.host();
                        if (domain == null) {
                            str = strHost;
                        } else {
                            if (!domainMatch(strHost, domain)) {
                                return null;
                            }
                            str = domain;
                        }
                        if (strHost.length() != str.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str) == null) {
                            return null;
                        }
                        String strSubstring = "/";
                        if (str2 == null || !i.N(str2, "/", false)) {
                            String strEncodedPath = url.encodedPath();
                            int iW = l.W(strEncodedPath, '/', 0, 6);
                            if (iW != 0) {
                                if (strEncodedPath == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                                strSubstring = strEncodedPath.substring(0, iW);
                                k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                            str2 = strSubstring;
                        }
                        return new Cookie(strTrimSubstring$default, strTrimSubstring, j8, str, str2, z10, z8, z9, z11, null);
                    }
                }
            }
            return null;
        }

        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            k.e(url, "url");
            k.e(headers, "headers");
            List<String> listValues = headers.values("Set-Cookie");
            int size = listValues.size();
            ArrayList arrayList = null;
            for (int i9 = 0; i9 < size; i9++) {
                Cookie cookie = parse(url, listValues.get(i9));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
            }
            if (arrayList == null) {
                return p.f22408a;
            }
            List<Cookie> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            k.d(listUnmodifiableList, "Collections.unmodifiableList(cookies)");
            return listUnmodifiableList;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z8, boolean z9, boolean z10, boolean z11) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z8;
        this.httpOnly = z9;
        this.persistent = z10;
        this.hostOnly = z11;
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* JADX INFO: renamed from: -deprecated_domain, reason: not valid java name */
    public final String m879deprecated_domain() {
        return this.domain;
    }

    /* JADX INFO: renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m880deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m881deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* JADX INFO: renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m882deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* JADX INFO: renamed from: -deprecated_name, reason: not valid java name */
    public final String m883deprecated_name() {
        return this.name;
    }

    /* JADX INFO: renamed from: -deprecated_path, reason: not valid java name */
    public final String m884deprecated_path() {
        return this.path;
    }

    /* JADX INFO: renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m885deprecated_persistent() {
        return this.persistent;
    }

    /* JADX INFO: renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m886deprecated_secure() {
        return this.secure;
    }

    /* JADX INFO: renamed from: -deprecated_value, reason: not valid java name */
    public final String m887deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return k.a(cookie.name, this.name) && k.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && k.a(cookie.domain, this.domain) && k.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return Boolean.hashCode(this.hostOnly) + ((Boolean.hashCode(this.persistent) + ((Boolean.hashCode(this.httpOnly) + ((Boolean.hashCode(this.secure) + a.g(a.g((Long.hashCode(this.expiresAt) + a.g(a.g(527, 31, this.name), 31, this.value)) * 31, 31, this.domain), 31, this.path)) * 31)) * 31)) * 31);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl url) {
        k.e(url, "url");
        if ((this.hostOnly ? k.a(url.host(), this.domain) : Companion.domainMatch(url.host(), this.domain)) && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z8) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z8) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        k.d(string, "toString()");
        return string;
    }

    public final String value() {
        return this.value;
    }

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z8, boolean z9, boolean z10, boolean z11, f fVar) {
        this(str, str2, j, str3, str4, z8, z9, z10, z11);
    }
}

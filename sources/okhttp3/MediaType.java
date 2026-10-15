package okhttp3;

import R7.i;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import y7.g;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: compiled from: MediaType.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m925deprecated_get(String mediaType) {
            k.e(mediaType, "mediaType");
            return get(mediaType);
        }

        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m926deprecated_parse(String mediaType) {
            k.e(mediaType, "mediaType");
            return parse(mediaType);
        }

        public final MediaType get(String toMediaType) {
            k.e(toMediaType, "$this$toMediaType");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(toMediaType);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
            }
            String strGroup = matcher.group(1);
            k.d(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            k.d(locale, "Locale.US");
            String lowerCase = strGroup.toLowerCase(locale);
            k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            k.d(strGroup2, "typeSubtype.group(2)");
            String lowerCase2 = strGroup2.toLowerCase(locale);
            k.d(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.PARAMETER.matcher(toMediaType);
            int iEnd = matcher.end();
            while (iEnd < toMediaType.length()) {
                matcher2.region(iEnd, toMediaType.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                    String strSubstring = toMediaType.substring(iEnd);
                    k.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(toMediaType);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (i.N(strGroup4, "'", false) && i.G(strGroup4, "'", false) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        k.d(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new MediaType(toMediaType, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final MediaType parse(String toMediaTypeOrNull) {
            k.e(toMediaTypeOrNull, "$this$toMediaTypeOrNull");
            try {
                return get(toMediaTypeOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* JADX INFO: renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m923deprecated_subtype() {
        return this.subtype;
    }

    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final String m924deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && k.a(((MediaType) obj).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String name) {
        k.e(name, "name");
        O7.f fVarZ = O7.k.Z(g.m(this.parameterNamesAndValues), 2);
        int i9 = fVarZ.f3585a;
        int i10 = fVarZ.f3586b;
        int i11 = fVarZ.f3587c;
        if (i11 >= 0) {
            if (i9 > i10) {
                return null;
            }
        } else if (i9 < i10) {
            return null;
        }
        while (!i.H(this.parameterNamesAndValues[i9], name)) {
            if (i9 == i10) {
                return null;
            }
            i9 += i11;
        }
        return this.parameterNamesAndValues[i9 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, f fVar) {
        this(str, str2, str3, strArr);
    }

    public final Charset charset(Charset charset) {
        String strParameter = parameter("charset");
        if (strParameter == null) {
            return charset;
        }
        try {
            return Charset.forName(strParameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}

package okhttp3;

import L7.a;
import O7.f;
import R7.i;
import R7.l;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.jvm.internal.k;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p011b4.h;
import p188x7.e;
import y7.g;
import y7.p;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Headers implements Iterable<e<? extends String, ? extends String>>, a {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    /* JADX INFO: compiled from: Headers.kt */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String line) {
            k.e(line, "line");
            int iS = l.S(line, ':', 0, 6);
            if (iS == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(line).toString());
            }
            String strSubstring = line.substring(0, iS);
            k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String string = l.d0(strSubstring).toString();
            String strSubstring2 = line.substring(iS + 1);
            k.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            add(string, strSubstring2);
            return this;
        }

        public final Builder addAll(Headers headers) {
            k.e(headers, "headers");
            int size = headers.size();
            for (int i9 = 0; i9 < size; i9++) {
                addLenient$okhttp(headers.name(i9), headers.value(i9));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String line) {
            k.e(line, "line");
            int iS = l.S(line, ':', 1, 4);
            if (iS != -1) {
                String strSubstring = line.substring(0, iS);
                k.d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iS + 1);
                k.d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(strSubstring, strSubstring2);
                return this;
            }
            if (line.charAt(0) != ':') {
                addLenient$okhttp("", line);
                return this;
            }
            String strSubstring3 = line.substring(1);
            k.d(strSubstring3, "(this as java.lang.String).substring(startIndex)");
            addLenient$okhttp("", strSubstring3);
            return this;
        }

        public final Builder addUnsafeNonAscii(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            Headers.Companion.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final String get(String name) {
            k.e(name, "name");
            f fVarZ = O7.k.Z(new f(this.namesAndValues.size() - 2, 0, -1), 2);
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
            while (!name.equalsIgnoreCase(this.namesAndValues.get(i9))) {
                if (i9 == i10) {
                    return null;
                }
                i9 += i11;
            }
            return this.namesAndValues.get(i9 + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String name) {
            k.e(name, "name");
            int i9 = 0;
            while (i9 < this.namesAndValues.size()) {
                if (name.equalsIgnoreCase(this.namesAndValues.get(i9))) {
                    this.namesAndValues.remove(i9);
                    this.namesAndValues.remove(i9);
                    i9 -= 2;
                }
                i9 += 2;
            }
            return this;
        }

        public final Builder set(String name, Date value) {
            k.e(name, "name");
            k.e(value, "value");
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String name, Instant value) {
            k.e(name, "name");
            k.e(value, "value");
            return set(name, new Date(value.toEpochMilli()));
        }

        public final Builder set(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Builder add(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Builder add(String name, Date value) {
            k.e(name, "name");
            k.e(value, "value");
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        public final Builder addLenient$okhttp(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(l.d0(value).toString());
            return this;
        }

        @IgnoreJRERequirement
        public final Builder add(String name, Instant value) {
            k.e(name, "name");
            k.e(value, "value");
            add(name, new Date(value.toEpochMilli()));
            return this;
        }
    }

    /* JADX INFO: compiled from: Headers.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i9 = 0; i9 < length; i9++) {
                char cCharAt = str.charAt(i9);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i9), str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i9 = 0; i9 < length; i9++) {
                char cCharAt = str.charAt(i9);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i9), str2));
                    sb.append(Util.isSensitiveHeader(str2) ? "" : ": ".concat(str));
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            f fVarZ = O7.k.Z(new f(strArr.length - 2, 0, -1), 2);
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
            while (!i.H(str, strArr[i9])) {
                if (i9 == i10) {
                    return null;
                }
                i9 += i11;
            }
            return strArr[i9 + 1];
        }

        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m899deprecated_of(String... namesAndValues) {
            k.e(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        public final Headers of(String... namesAndValues) throws CloneNotSupportedException {
            k.e(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            Object objClone = namesAndValues.clone();
            if (objClone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr = (String[]) objClone;
            int length = strArr.length;
            for (int i9 = 0; i9 < length; i9++) {
                String str = strArr[i9];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr[i9] = l.d0(str).toString();
            }
            f fVarZ = O7.k.Z(g.m(strArr), 2);
            int i10 = fVarZ.f3585a;
            int i11 = fVarZ.f3586b;
            int i12 = fVarZ.f3587c;
            if (i12 < 0 ? i10 >= i11 : i10 <= i11) {
                while (true) {
                    String str2 = strArr[i10];
                    String str3 = strArr[i10 + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i10 == i11) {
                        break;
                    }
                    i10 += i12;
                }
            }
            return new Headers(strArr, null);
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m898deprecated_of(Map<String, String> headers) {
            k.e(headers, "headers");
            return of(headers);
        }

        public final Headers of(Map<String, String> toHeaders) {
            k.e(toHeaders, "$this$toHeaders");
            String[] strArr = new String[toHeaders.size() * 2];
            int i9 = 0;
            for (Map.Entry<String, String> entry : toHeaders.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string = l.d0(key).toString();
                if (value != null) {
                    String string2 = l.d0(value).toString();
                    checkName(string);
                    checkValue(string2, string);
                    strArr[i9] = string;
                    strArr[i9 + 1] = string2;
                    i9 += 2;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return new Headers(strArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m897deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i9 = 0; i9 < length2; i9++) {
            length += (long) this.namesAndValues[i9].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String name) {
        k.e(name, "name");
        return Companion.get(this.namesAndValues, name);
    }

    public final Date getDate(String name) {
        k.e(name, "name");
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String name) {
        k.e(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<e<? extends String, ? extends String>> iterator() {
        int size = size();
        e[] eVarArr = new e[size];
        for (int i9 = 0; i9 < size; i9++) {
            eVarArr[i9] = new e(name(i9), value(i9));
        }
        return h.C(eVarArr);
    }

    public final String name(int i9) {
        return this.namesAndValues[i9 * 2];
    }

    public final Set<String> names() {
        i.I();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            treeSet.add(name(i9));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        k.d(setUnmodifiableSet, "Collections.unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        List<String> namesAndValues$okhttp = builder.getNamesAndValues$okhttp();
        String[] elements = this.namesAndValues;
        k.e(namesAndValues$okhttp, "<this>");
        k.e(elements, "elements");
        namesAndValues$okhttp.addAll(y7.f.a(elements));
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        i.I();
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            String strName = name(i9);
            Locale locale = Locale.US;
            k.d(locale, "Locale.US");
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase(locale);
            k.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i9));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            String strName = name(i9);
            String strValue = value(i9);
            sb.append(strName);
            sb.append(": ");
            if (Util.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb.append(strValue);
            sb.append("\n");
        }
        String string = sb.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String value(int i9) {
        return this.namesAndValues[(i9 * 2) + 1];
    }

    public final List<String> values(String name) {
        k.e(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i9 = 0; i9 < size; i9++) {
            if (name.equalsIgnoreCase(name(i9))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i9));
            }
        }
        if (arrayList == null) {
            return p.f22408a;
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        k.d(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    public /* synthetic */ Headers(String[] strArr, kotlin.jvm.internal.f fVar) {
        this(strArr);
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }
}

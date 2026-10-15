package R7;

import java.util.Comparator;

/* JADX INFO: compiled from: StringsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public class i extends h {
    public static String F(char[] cArr, int i9, int i10) {
        y7.b.a aVar = y7.b.Companion;
        int length = cArr.length;
        aVar.getClass();
        if (i9 < 0 || i10 > length) {
            StringBuilder sbG = H2.a.g(i9, i10, "startIndex: ", ", endIndex: ", ", size: ");
            sbG.append(length);
            throw new IndexOutOfBoundsException(sbG.toString());
        }
        if (i9 <= i10) {
            return new String(cArr, i9, i10 - i9);
        }
        throw new IllegalArgumentException(W5.e.h(i9, i10, "startIndex: ", " > endIndex: "));
    }

    public static boolean G(String str, String suffix, boolean z8) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(suffix, "suffix");
        return !z8 ? str.endsWith(suffix) : J(str.length() - suffix.length(), 0, suffix.length(), str, suffix, true);
    }

    public static boolean H(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static void I() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.k.d(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
    }

    public static final boolean J(int i9, int i10, int i11, String str, String other, boolean z8) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        return !z8 ? str.regionMatches(i9, other, i10, i11) : str.regionMatches(z8, i9, other, i10, i11);
    }

    public static String K(char c5, String str, char c9) {
        kotlin.jvm.internal.k.e(str, "<this>");
        String strReplace = str.replace(c5, c9);
        kotlin.jvm.internal.k.d(strReplace, "replace(...)");
        return strReplace;
    }

    public static String L(String str, String str2, String str3) {
        kotlin.jvm.internal.k.e(str, "<this>");
        int iR = l.R(str, str2, 0, false);
        if (iR < 0) {
            return str;
        }
        int length = str2.length();
        int i9 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i10 = 0;
        do {
            sb.append((CharSequence) str, i10, iR);
            sb.append(str3);
            i10 = iR + length;
            if (iR >= str.length()) {
                break;
            }
            iR = l.R(str, str2, iR + i9, false);
        } while (iR > 0);
        sb.append((CharSequence) str, i10, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }

    public static boolean M(String str, String str2, int i9, boolean z8) {
        kotlin.jvm.internal.k.e(str, "<this>");
        return !z8 ? str.startsWith(str2, i9) : J(i9, 0, str2.length(), str, str2, z8);
    }

    public static boolean N(String str, String prefix, boolean z8) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return !z8 ? str.startsWith(prefix) : J(0, 0, prefix.length(), str, prefix, z8);
    }
}

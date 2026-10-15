package R7;

import K7.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p056h5.C0598e;

/* JADX INFO: compiled from: _StringsJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
public class l extends i {
    public static boolean O(String str, String str2, boolean z8) {
        kotlin.jvm.internal.k.e(str, "<this>");
        return T(str, str2, 0, z8, 2) >= 0;
    }

    public static boolean P(CharSequence charSequence, char c5) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return S(charSequence, c5, 0, 2) >= 0;
    }

    public static final int Q(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int R(CharSequence charSequence, String string, int i9, boolean z8) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        if (!z8 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i9);
        }
        int length = charSequence.length();
        if (i9 < 0) {
            i9 = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        O7.h hVar = new O7.h(i9, length, 1);
        boolean z9 = charSequence instanceof String;
        int i10 = hVar.f3587c;
        int i11 = hVar.f3586b;
        int i12 = hVar.f3585a;
        if (!z9 || string == null) {
            boolean z10 = z8;
            if ((i10 <= 0 || i12 > i11) && (i10 >= 0 || i11 > i12)) {
                return -1;
            }
            while (true) {
                CharSequence charSequence2 = charSequence;
                boolean z11 = z10;
                z10 = z11;
                if (X(string, 0, charSequence2, i12, string.length(), z11)) {
                    return i12;
                }
                if (i12 == i11) {
                    return -1;
                }
                i12 += i10;
                charSequence = charSequence2;
            }
        } else {
            if ((i10 <= 0 || i12 > i11) && (i10 >= 0 || i11 > i12)) {
                return -1;
            }
            int i13 = i12;
            while (true) {
                String str = string;
                boolean z12 = z8;
                if (i.J(0, i13, string.length(), str, (String) charSequence, z12)) {
                    return i13;
                }
                if (i13 == i11) {
                    return -1;
                }
                i13 += i10;
                string = str;
                z8 = z12;
            }
        }
    }

    public static int S(CharSequence charSequence, char c5, int i9, int i10) {
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return !(charSequence instanceof String) ? U(charSequence, new char[]{c5}, i9, false) : ((String) charSequence).indexOf(c5, i9);
    }

    public static /* synthetic */ int T(CharSequence charSequence, String str, int i9, boolean z8, int i10) {
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        if ((i10 & 4) != 0) {
            z8 = false;
        }
        return R(charSequence, str, i9, z8);
    }

    public static final int U(CharSequence charSequence, char[] cArr, int i9, boolean z8) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        if (!z8 && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i9);
        }
        if (i9 < 0) {
            i9 = 0;
        }
        int iQ = Q(charSequence);
        if (i9 > iQ) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i9);
            for (char c5 : cArr) {
                if (p199z2.b.y(c5, cCharAt, z8)) {
                    return i9;
                }
            }
            if (i9 == iQ) {
                return -1;
            }
            i9++;
        }
    }

    public static boolean V(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        for (int i9 = 0; i9 < charSequence.length(); i9++) {
            if (!p199z2.b.E(charSequence.charAt(i9))) {
                return false;
            }
        }
        return true;
    }

    public static int W(String str, char c5, int i9, int i10) {
        if ((i10 & 2) != 0) {
            i9 = Q(str);
        }
        kotlin.jvm.internal.k.e(str, "<this>");
        return str.lastIndexOf(c5, i9);
    }

    public static final boolean X(String str, int i9, CharSequence other, int i10, int i11, boolean z8) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (i10 >= 0 && i9 >= 0 && i9 <= str.length() - i11 && i10 <= other.length() - i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                if (p199z2.b.y(str.charAt(i9 + i12), other.charAt(i10 + i12), z8)) {
                }
            }
            return true;
        }
        return false;
    }

    public static String Y(String str, String prefix) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        if (!b0(str, prefix)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final List Z(String str, String str2) {
        int iR = R(str, str2, 0, false);
        if (iR == -1) {
            return C0598e.y(str.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int length = 0;
        do {
            arrayList.add(str.subSequence(length, iR).toString());
            length = str2.length() + iR;
            iR = R(str, str2, length, false);
        } while (iR != -1);
        arrayList.add(str.subSequence(length, str.length()).toString());
        return arrayList;
    }

    public static List a0(String str, final char[] cArr) {
        kotlin.jvm.internal.k.e(str, "<this>");
        if (cArr.length == 1) {
            return Z(str, String.valueOf(cArr[0]));
        }
        Q7.l lVar = new Q7.l(new b(str, new p() { // from class: R7.j
            @Override // K7.p
            public final Object invoke(Object obj, Object obj2) {
                CharSequence DelimitedRangesSequence = (CharSequence) obj;
                int iIntValue = ((Integer) obj2).intValue();
                kotlin.jvm.internal.k.e(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
                int iU = l.U(DelimitedRangesSequence, cArr, iIntValue, false);
                if (iU < 0) {
                    return null;
                }
                return new p188x7.e(Integer.valueOf(iU), 1);
            }
        }));
        ArrayList arrayList = new ArrayList(y7.i.E(lVar));
        Iterator<Object> it = lVar.iterator();
        while (true) {
            b.a aVar = (b.a) it;
            if (!aVar.hasNext()) {
                return arrayList;
            }
            O7.h range = (O7.h) aVar.next();
            kotlin.jvm.internal.k.e(range, "range");
            arrayList.add(str.subSequence(range.f3585a, range.f3586b + 1).toString());
        }
    }

    public static boolean b0(String str, String prefix) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return i.N(str, prefix, false);
    }

    public static String c0(String str, String delimiter) {
        kotlin.jvm.internal.k.e(delimiter, "delimiter");
        int iT = T(str, delimiter, 0, false, 6);
        if (iT == -1) {
            return str;
        }
        String strSubstring = str.substring(delimiter.length() + iT, str.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence d0(String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        int length = str.length() - 1;
        int i9 = 0;
        boolean z8 = false;
        while (i9 <= length) {
            boolean zE = p199z2.b.E(str.charAt(!z8 ? i9 : length));
            if (z8) {
                if (!zE) {
                    break;
                }
                length--;
            } else if (zE) {
                i9++;
            } else {
                z8 = true;
            }
        }
        return str.subSequence(i9, length + 1);
    }
}

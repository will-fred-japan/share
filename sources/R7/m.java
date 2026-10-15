package R7;

/* JADX INFO: compiled from: _Strings.kt */
/* JADX INFO: loaded from: classes2.dex */
public class m extends l {
    public static String e0(int i9, String str) {
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i9 < 0) {
            throw new IllegalArgumentException(defpackage.f.b(i9, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i9 > length) {
            i9 = length;
        }
        String strSubstring = str.substring(0, i9);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}

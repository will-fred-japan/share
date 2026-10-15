package p056h5;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public static void a(int i9, int i10) {
        String strA;
        if (i9 < 0 || i9 >= i10) {
            if (i9 < 0) {
                strA = z.a("%s (%s) must not be negative", "index", Integer.valueOf(i9));
            } else {
                if (i10 < 0) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 15);
                    sb.append("negative size: ");
                    sb.append(i10);
                    throw new IllegalArgumentException(sb.toString());
                }
                strA = z.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i9), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }

    public static void b(int i9, int i10, int i11) {
        String strC;
        if (i9 < 0 || i10 < i9 || i10 > i11) {
            if (i9 < 0 || i9 > i11) {
                strC = c(i9, i11, "start index");
            } else {
                strC = (i10 < 0 || i10 > i11) ? c(i10, i11, "end index") : z.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i10), Integer.valueOf(i9));
            }
            throw new IndexOutOfBoundsException(strC);
        }
    }

    public static String c(int i9, int i10, String str) {
        if (i9 < 0) {
            return z.a("%s (%s) must not be negative", str, Integer.valueOf(i9));
        }
        if (i10 >= 0) {
            return z.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i9), Integer.valueOf(i10));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 15);
        sb.append("negative size: ");
        sb.append(i10);
        throw new IllegalArgumentException(sb.toString());
    }
}

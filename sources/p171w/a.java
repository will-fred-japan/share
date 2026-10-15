package p171w;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    public static String a(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static StringBuilder b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static /* synthetic */ String d(int i9) {
        if (i9 == 1) {
            return "READY";
        }
        if (i9 == 2) {
            return "SENT";
        }
        if (i9 == 3) {
            return "COMPLETE";
        }
        throw null;
    }
}

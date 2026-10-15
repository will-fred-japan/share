package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: TextFormatEscaper.java */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {
    public static String a(AbstractC0513g abstractC0513g) {
        StringBuilder sb = new StringBuilder(abstractC0513g.size());
        for (int i9 = 0; i9 < abstractC0513g.size(); i9++) {
            byte bF = abstractC0513g.f(i9);
            if (bF == 34) {
                sb.append("\\\"");
            } else if (bF == 39) {
                sb.append("\\'");
            } else if (bF != 92) {
                switch (bF) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bF < 32 || bF > 126) {
                            sb.append('\\');
                            sb.append((char) (((bF >>> 6) & 3) + 48));
                            sb.append((char) (((bF >>> 3) & 7) + 48));
                            sb.append((char) ((bF & 7) + 48));
                        } else {
                            sb.append((char) bF);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}

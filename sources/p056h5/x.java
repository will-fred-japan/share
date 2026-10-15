package p056h5;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f19081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StringBuilder f19082b;

    static {
        Locale locale = Locale.ROOT;
        f19081a = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        f19082b = new StringBuilder(33);
    }

    public static void a(long j, StringBuilder sb) {
        if (j == 0) {
            sb.append("0s");
            return;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z8 = false;
        if (j < 0) {
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (j != Long.MIN_VALUE) {
                j = -j;
            } else {
                j = Long.MAX_VALUE;
                z8 = true;
            }
        }
        if (j >= 86400000) {
            sb.append(j / 86400000);
            sb.append("d");
            j %= 86400000;
        }
        if (true == z8) {
            j = 25975808;
        }
        if (j >= 3600000) {
            sb.append(j / 3600000);
            sb.append("h");
            j %= 3600000;
        }
        if (j >= 60000) {
            sb.append(j / 60000);
            sb.append("m");
            j %= 60000;
        }
        if (j >= 1000) {
            sb.append(j / 1000);
            sb.append("s");
            j %= 1000;
        }
        if (j > 0) {
            sb.append(j);
            sb.append("ms");
        }
    }
}

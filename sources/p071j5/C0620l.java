package p071j5;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: renamed from: j5.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0620l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DecimalFormat f19866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DecimalFormat f19867b;

    static {
        Locale locale = Locale.ROOT;
        f19866a = new DecimalFormat(".000000", DecimalFormatSymbols.getInstance(locale));
        DecimalFormat decimalFormat = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(locale));
        f19867b = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
    }
}

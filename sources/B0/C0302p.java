package B0;

import android.graphics.Typeface;
import android.graphics.fonts.FontFamily;
import android.telephony.CellInfo;
import android.telephony.CellInfoNr;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.view.WindowInsets;
import android.webkit.WebViewRenderProcess;

/* JADX INFO: renamed from: B0.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0302p {
    public static /* bridge */ /* synthetic */ boolean B(CellInfo cellInfo) {
        return cellInfo instanceof CellInfoNr;
    }

    public static /* synthetic */ Typeface.CustomFallbackBuilder h(FontFamily fontFamily) {
        return new Typeface.CustomFallbackBuilder(fontFamily);
    }

    public static /* bridge */ /* synthetic */ CellSignalStrengthTdscdma l(Object obj) {
        return (CellSignalStrengthTdscdma) obj;
    }

    public static /* synthetic */ WindowInsets.Builder n(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    public static /* bridge */ /* synthetic */ WebViewRenderProcess p(Object obj) {
        return (WebViewRenderProcess) obj;
    }

    public static /* bridge */ /* synthetic */ Class q() {
        return CellSignalStrengthNr.class;
    }
}

package B0;

import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.telephony.CellInfo;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellSignalStrengthTdscdma;
import android.view.WindowInsets;

/* JADX INFO: renamed from: B0.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0301o {
    public static /* synthetic */ FontFamily.Builder h(Font font) {
        return new FontFamily.Builder(font);
    }

    public static /* bridge */ /* synthetic */ CellInfoTdscdma k(CellInfo cellInfo) {
        return (CellInfoTdscdma) cellInfo;
    }

    public static /* synthetic */ WindowInsets.Builder m() {
        return new WindowInsets.Builder();
    }

    public static /* bridge */ /* synthetic */ Class s() {
        return CellSignalStrengthTdscdma.class;
    }

    public static /* synthetic */ void x() {
    }
}

package B0;

import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellSignalStrengthNr;

/* JADX INFO: renamed from: B0.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0300n {
    public static /* bridge */ /* synthetic */ CellIdentityNr i(Object obj) {
        return (CellIdentityNr) obj;
    }

    public static /* bridge */ /* synthetic */ CellInfoNr k(CellInfo cellInfo) {
        return (CellInfoNr) cellInfo;
    }

    public static /* bridge */ /* synthetic */ CellSignalStrengthNr l(Object obj) {
        return (CellSignalStrengthNr) obj;
    }

    public static /* synthetic */ void q() {
    }

    public static /* bridge */ /* synthetic */ boolean v(CellInfo cellInfo) {
        return cellInfo instanceof CellInfoTdscdma;
    }
}

package cn.jiguang.commons.a;

import B0.C0300n;
import B0.C0301o;
import B0.C0302p;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class je {
    private static int a(int i9) {
        if (i9 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 < -140 || i9 > 0) {
            return 0;
        }
        return i9;
    }

    private static int b(int i9) {
        if (i9 == -1 || i9 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 < 0 || i9 > 65535) {
            return 0;
        }
        return i9;
    }

    private static int c(int i9) {
        if (i9 == Integer.MAX_VALUE || i9 == -1 || i9 <= 0 || i9 > 999) {
            return 0;
        }
        return i9;
    }

    private static int d(int i9) {
        if (i9 == Integer.MAX_VALUE || i9 == -1 || i9 < 0 || i9 > 999) {
            return 0;
        }
        return i9;
    }

    private static long a(long j, boolean z8) {
        if (j == -1 || j == 2147483647L || j == Long.MAX_VALUE || j == -2147483648L || j == Long.MIN_VALUE || j < 0) {
            return 0L;
        }
        if (z8) {
            if (j > 68719476735L) {
                return 0L;
            }
        } else if (j > 268435455) {
            return 0L;
        }
        return j;
    }

    public static z a(CellInfo cellInfo) {
        CharSequence operatorAlphaLong;
        if (cellInfo == null) {
            return null;
        }
        int i9 = Build.VERSION.SDK_INT;
        z zVar = new z();
        try {
            String str = "";
            int i10 = 0;
            if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                CellSignalStrengthGsm cellSignalStrength = cellInfoGsm.getCellSignalStrength();
                CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                zVar.f10455i = a(cellSignalStrength.getDbm());
                zVar.f10447a = a(cellIdentity.getCid(), false);
                zVar.f10448b = b(cellIdentity.getLac());
                if (i9 >= 28) {
                    a(zVar, cellIdentity.getMccString(), cellIdentity.getMncString());
                } else {
                    zVar.f10449c = c(cellIdentity.getMcc());
                    zVar.f10450d = d(cellIdentity.getMnc());
                }
                zVar.f10453g = "2G";
                zVar.f10454h = MTCommonConstants.Network.RADIO_3G;
                if (i9 >= 28) {
                    operatorAlphaLong = cellIdentity.getOperatorAlphaLong();
                    zVar.f10452f = a(operatorAlphaLong);
                }
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                CellSignalStrengthLte cellSignalStrength2 = cellInfoLte.getCellSignalStrength();
                CellIdentityLte cellIdentity2 = cellInfoLte.getCellIdentity();
                zVar.f10455i = a(cellSignalStrength2.getDbm());
                zVar.f10447a = a(cellIdentity2.getCi(), false);
                zVar.f10448b = b(cellIdentity2.getTac());
                if (i9 >= 28) {
                    a(zVar, cellIdentity2.getMccString(), cellIdentity2.getMncString());
                } else {
                    zVar.f10449c = c(cellIdentity2.getMcc());
                    zVar.f10450d = d(cellIdentity2.getMnc());
                }
                zVar.f10453g = "4G";
                zVar.f10454h = MTCommonConstants.Network.RADIO_4G;
                if (i9 >= 28) {
                    operatorAlphaLong = cellIdentity2.getOperatorAlphaLong();
                    zVar.f10452f = a(operatorAlphaLong);
                }
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                CellSignalStrengthWcdma cellSignalStrength3 = cellInfoWcdma.getCellSignalStrength();
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                zVar.f10455i = a(cellSignalStrength3.getDbm());
                zVar.f10447a = a(cellIdentity3.getCid(), false);
                zVar.f10448b = b(cellIdentity3.getLac());
                if (i9 >= 28) {
                    a(zVar, cellIdentity3.getMccString(), cellIdentity3.getMncString());
                } else {
                    zVar.f10449c = c(cellIdentity3.getMcc());
                    zVar.f10450d = d(cellIdentity3.getMnc());
                }
                zVar.f10453g = "3G";
                zVar.f10454h = "wcdma";
                if (i9 >= 28) {
                    operatorAlphaLong = cellIdentity3.getOperatorAlphaLong();
                    zVar.f10452f = a(operatorAlphaLong);
                }
            } else if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellSignalStrengthCdma cellSignalStrength4 = cellInfoCdma.getCellSignalStrength();
                CellIdentityCdma cellIdentity4 = cellInfoCdma.getCellIdentity();
                zVar.f10455i = a(cellSignalStrength4.getDbm());
                zVar.f10447a = a(cellIdentity4.getBasestationId(), false);
                zVar.f10448b = b(cellIdentity4.getNetworkId());
                zVar.f10449c = 0;
                zVar.f10450d = 0;
                zVar.f10453g = "3G";
                zVar.f10454h = "cdma2000";
                if (i9 >= 28) {
                    zVar.f10452f = a(cellIdentity4.getOperatorAlphaLong());
                }
                zVar.f10451e = "";
            } else {
                if (i9 >= 29 && C0302p.B(cellInfo)) {
                    CellInfoNr cellInfoNrK = C0300n.k(cellInfo);
                    CellSignalStrength cellSignalStrength5 = cellInfoNrK.getCellSignalStrength();
                    CellIdentityNr cellIdentityNrI = C0300n.i(cellInfoNrK.getCellIdentity());
                    zVar.f10455i = a(cellSignalStrength5.getDbm());
                    zVar.f10447a = a(cellIdentityNrI.getNci(), true);
                    int tac = cellIdentityNrI.getTac();
                    if (tac != Integer.MAX_VALUE && tac >= 0 && tac <= 16777215) {
                        i10 = tac;
                    }
                    zVar.f10448b = i10;
                    a(zVar, cellIdentityNrI.getMccString(), cellIdentityNrI.getMncString());
                    zVar.f10453g = "5G";
                    zVar.f10454h = MTCommonConstants.Network.RADIO_5G;
                    operatorAlphaLong = cellIdentityNrI.getOperatorAlphaLong();
                } else if (i9 >= 29 && C0300n.v(cellInfo)) {
                    CellInfoTdscdma cellInfoTdscdmaK = C0301o.k(cellInfo);
                    CellSignalStrengthTdscdma cellSignalStrength6 = cellInfoTdscdmaK.getCellSignalStrength();
                    CellIdentityTdscdma cellIdentity5 = cellInfoTdscdmaK.getCellIdentity();
                    zVar.f10455i = a(cellSignalStrength6.getDbm());
                    zVar.f10447a = a(cellIdentity5.getCid(), false);
                    zVar.f10448b = b(cellIdentity5.getLac());
                    a(zVar, cellIdentity5.getMccString(), cellIdentity5.getMncString());
                    zVar.f10453g = "3G";
                    zVar.f10454h = "tdscdma";
                    operatorAlphaLong = cellIdentity5.getOperatorAlphaLong();
                }
                zVar.f10452f = a(operatorAlphaLong);
            }
            if (zVar.f10451e == null) {
                zVar.f10451e = "";
            }
            if (TextUtils.isEmpty(zVar.f10451e)) {
                int i11 = zVar.f10449c;
                int i12 = zVar.f10450d;
                if (i11 > 0 && i12 >= 0) {
                    if (i11 == 460) {
                        str = i12 == 11 ? "46011" : String.format(Locale.US, "%03d%02d", Integer.valueOf(i11), Integer.valueOf(i12));
                    } else {
                        str = String.format(Locale.US, "%03d", Integer.valueOf(i11)) + i12;
                    }
                }
                zVar.f10451e = str;
            }
            if (zVar.f10449c == 0 && zVar.f10450d == 0 && zVar.f10448b == 0 && zVar.f10447a == 0) {
                return null;
            }
            return zVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(CharSequence charSequence) {
        return (charSequence == null || TextUtils.isEmpty(charSequence.toString())) ? "" : charSequence.toString().trim();
    }

    private static void a(z zVar, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                zVar.f10449c = 0;
            } else {
                zVar.f10449c = Integer.parseInt(str);
            }
            if (TextUtils.isEmpty(str2)) {
                zVar.f10450d = 0;
            } else {
                zVar.f10450d = Integer.parseInt(str2);
            }
            zVar.f10451e = (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : str.concat(str2);
        } catch (NumberFormatException unused) {
            zVar.f10449c = 0;
            zVar.f10450d = 0;
        }
    }
}

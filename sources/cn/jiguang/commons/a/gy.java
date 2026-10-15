package cn.jiguang.commons.a;

import android.bluetooth.le.ScanResult;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class gy {
    public static boolean a(ScanResult scanResult, af afVar) {
        byte[] manufacturerSpecificData = null;
        try {
            if (scanResult.getScanRecord() == null || (manufacturerSpecificData = scanResult.getScanRecord().getManufacturerSpecificData(76)) == null || manufacturerSpecificData.length < 23 || (((manufacturerSpecificData[0] & 255) << 8) | (manufacturerSpecificData[1] & 255)) != 533) {
                return false;
            }
            t tVar = new t();
            StringBuilder sb = new StringBuilder();
            for (int i9 = 2; i9 < 18; i9++) {
                sb.append(String.format("%02x", Byte.valueOf(manufacturerSpecificData[i9])));
                if (i9 == 5 || i9 == 7 || i9 == 9 || i9 == 11) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            String upperCase = sb.toString().toUpperCase();
            if (!upperCase.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").matches("^0+$")) {
                tVar.a(upperCase);
                int i10 = ((manufacturerSpecificData[18] & 255) << 8) | (manufacturerSpecificData[19] & 255);
                tVar.a(i10);
                int i11 = ((manufacturerSpecificData[20] & 255) << 8) | (manufacturerSpecificData[21] & 255);
                tVar.b(i11);
                byte b9 = manufacturerSpecificData[22];
                tVar.c(b9);
                afVar.a(tVar);
                ee.a("IBeaconParser", String.format("iBeacon data parsed: UUID=%s, major=%d, minor=%d, power=%d", upperCase, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(b9)));
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e9) {
            ee.d("IBeaconParser", String.format("parse ibeacon data failed: length=%d; error=%s", Integer.valueOf(manufacturerSpecificData != null ? manufacturerSpecificData.length : 0), e9.getMessage()));
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("parse ibeacon data failed: "), "IBeaconParser");
        }
        return false;
    }

    public static boolean a(byte[] bArr, af afVar) {
        int i9;
        if (bArr != null && bArr.length >= 27 && afVar != null) {
            int i10 = 0;
            while (i10 < bArr.length - 1 && (i9 = bArr[i10] & 255) != 0 && i10 + i9 < bArr.length) {
                try {
                    if ((bArr[i10 + 1] & 255) == 255 && i9 >= 26 && (((bArr[i10 + 3] & 255) << 8) | (bArr[i10 + 2] & 255)) == 76 && (((bArr[i10 + 4] & 255) << 8) | (bArr[i10 + 5] & 255)) == 533) {
                        byte[] bArr2 = new byte[16];
                        System.arraycopy(bArr, i10 + 6, bArr2, 0, 16);
                        StringBuilder sb = new StringBuilder();
                        for (int i11 = 0; i11 < 16; i11++) {
                            sb.append(String.format("%02x", Byte.valueOf(bArr2[i11])));
                            if (i11 == 3 || i11 == 5 || i11 == 7 || i11 == 9) {
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            }
                        }
                        String upperCase = sb.toString().toUpperCase();
                        if (!upperCase.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").matches("^0+$")) {
                            t tVar = new t();
                            tVar.a(upperCase);
                            tVar.a(((bArr[i10 + 22] & 255) << 8) | (bArr[i10 + 23] & 255));
                            tVar.b((255 & bArr[i10 + 25]) | ((bArr[i10 + 24] & 255) << 8));
                            tVar.c(bArr[i10 + 26]);
                            afVar.a(tVar);
                            return true;
                        }
                    }
                    i10 += i9 + 1;
                } catch (Throwable th) {
                    defpackage.f.n(th, new StringBuilder("parse ibeacon from bytes failed: "), "IBeaconParser");
                }
            }
        }
        return false;
    }
}

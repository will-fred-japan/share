package com.jieli.jl_bt_ota.util;

import android.os.ParcelUuid;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class UuidUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16346a = "0000-1000-8000-00805F9B34FB";

    private static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static boolean equalUUID(UUID uuid, UUID uuid2) {
        if (uuid == null || uuid2 == null) {
            return false;
        }
        return uuid.toString().equalsIgnoreCase(uuid2.toString());
    }

    public static String getDescriptorName(UUID uuid) {
        String strReplace = read16BitUUID(uuid).replace("0x", "");
        strReplace.getClass();
        switch (strReplace) {
            case "2900":
                return "Characteristic Extended Properties";
            case "2901":
                return "Characteristic User Description";
            case "2902":
                return "Client Characteristic Configuration";
            case "2903":
                return "Server Characteristic Configuration";
            case "2904":
                return "Characteristic Presentation Format";
            case "2905":
                return "Characteristic Aggregate Format";
            default:
                return "Unknown Descriptor";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String getUUIDName(UUID uuid) {
        if (uuid == null) {
            return "";
        }
        String strReplace = read16BitUUID(uuid).replace("0x", "");
        strReplace.getClass();
        byte b9 = -1;
        switch (strReplace.hashCode()) {
            case 1508385:
                if (strReplace.equals("1101")) {
                    b9 = 0;
                }
                break;
            case 1508386:
                if (strReplace.equals("1102")) {
                    b9 = 1;
                }
                break;
            case 1508387:
                if (strReplace.equals("1103")) {
                    b9 = 2;
                }
                break;
            case 1508388:
                if (strReplace.equals("1104")) {
                    b9 = 3;
                }
                break;
            case 1508389:
                if (strReplace.equals("1105")) {
                    b9 = 4;
                }
                break;
            case 1508390:
                if (strReplace.equals("1106")) {
                    b9 = 5;
                }
                break;
            case 1508391:
                if (strReplace.equals("1107")) {
                    b9 = 6;
                }
                break;
            case 1508392:
                if (strReplace.equals("1108")) {
                    b9 = 7;
                }
                break;
            case 1508393:
                if (strReplace.equals("1109")) {
                    b9 = 8;
                }
                break;
            case 1508401:
                if (strReplace.equals("110A")) {
                    b9 = 9;
                }
                break;
            case 1508402:
                if (strReplace.equals("110B")) {
                    b9 = 10;
                }
                break;
            case 1508403:
                if (strReplace.equals("110C")) {
                    b9 = 11;
                }
                break;
            case 1508404:
                if (strReplace.equals("110D")) {
                    b9 = 12;
                }
                break;
            case 1508405:
                if (strReplace.equals("110E")) {
                    b9 = 13;
                }
                break;
            case 1508406:
                if (strReplace.equals("110F")) {
                    b9 = 14;
                }
                break;
            case 1508415:
                if (strReplace.equals("1110")) {
                    b9 = 15;
                }
                break;
            case 1508416:
                if (strReplace.equals("1111")) {
                    b9 = 16;
                }
                break;
            case 1508417:
                if (strReplace.equals("1112")) {
                    b9 = 17;
                }
                break;
            case 1508436:
                if (strReplace.equals("111E")) {
                    b9 = 18;
                }
                break;
            case 1508437:
                if (strReplace.equals("111F")) {
                    b9 = 19;
                }
                break;
            case 1508450:
                if (strReplace.equals("1124")) {
                    b9 = 20;
                }
                break;
            case 1515111:
                if (strReplace.equals("1800")) {
                    b9 = 21;
                }
                break;
            case 1515112:
                if (strReplace.equals("1801")) {
                    b9 = AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER;
                }
                break;
            case 1515119:
                if (strReplace.equals("1808")) {
                    b9 = 23;
                }
                break;
            case 1515120:
                if (strReplace.equals("1809")) {
                    b9 = 24;
                }
                break;
            case 1515128:
                if (strReplace.equals("180A")) {
                    b9 = 25;
                }
                break;
            case 1515131:
                if (strReplace.equals("180D")) {
                    b9 = 26;
                }
                break;
            case 1515133:
                if (strReplace.equals("180F")) {
                    b9 = 27;
                }
                break;
            case 1515142:
                if (strReplace.equals("1810")) {
                    b9 = 28;
                }
                break;
            case 1515143:
                if (strReplace.equals("1811")) {
                    b9 = 29;
                }
                break;
            case 1515144:
                if (strReplace.equals("1812")) {
                    b9 = 30;
                }
                break;
            case 1515146:
                if (strReplace.equals("1814")) {
                    b9 = 31;
                }
                break;
            case 1515148:
                if (strReplace.equals("1816")) {
                    b9 = 32;
                }
                break;
            case 1515159:
                if (strReplace.equals("181A")) {
                    b9 = 33;
                }
                break;
            case 1515173:
                if (strReplace.equals("1820")) {
                    b9 = 34;
                }
                break;
            case 1515179:
                if (strReplace.equals("1826")) {
                    b9 = 35;
                }
                break;
            case 1553551:
                if (strReplace.equals("2A00")) {
                    b9 = 36;
                }
                break;
            case 1553552:
                if (strReplace.equals("2A01")) {
                    b9 = 37;
                }
                break;
            case 1553555:
                if (strReplace.equals("2A04")) {
                    b9 = 38;
                }
                break;
            case 1553556:
                if (strReplace.equals("2A05")) {
                    b9 = 39;
                }
                break;
            case 1553591:
                if (strReplace.equals("2A19")) {
                    b9 = 40;
                }
                break;
            case 1553601:
                if (strReplace.equals("2A1C")) {
                    b9 = 41;
                }
                break;
            case 1553616:
                if (strReplace.equals("2A23")) {
                    b9 = 42;
                }
                break;
            case 1553617:
                if (strReplace.equals("2A24")) {
                    b9 = 43;
                }
                break;
            case 1553618:
                if (strReplace.equals("2A25")) {
                    b9 = 44;
                }
                break;
            case 1553619:
                if (strReplace.equals("2A26")) {
                    b9 = 45;
                }
                break;
            case 1553620:
                if (strReplace.equals("2A27")) {
                    b9 = 46;
                }
                break;
            case 1553621:
                if (strReplace.equals("2A28")) {
                    b9 = 47;
                }
                break;
            case 1553622:
                if (strReplace.equals("2A29")) {
                    b9 = 48;
                }
                break;
            case 1553651:
                if (strReplace.equals("2A37")) {
                    b9 = 49;
                }
                break;
            case 1553724:
                if (strReplace.equals("2A5B")) {
                    b9 = 50;
                }
                break;
            case 1553725:
                if (strReplace.equals("2A5C")) {
                    b9 = 51;
                }
                break;
        }
        switch (b9) {
            case 0:
                return "Serial Port Profile(SPP)";
            case 1:
                return "LAN Access Using PPP Profile";
            case 2:
                return "Dialup Networking Profile";
            case 3:
                return "IrMC Sync Profile";
            case 4:
                return "Object Push Profile(OPP)";
            case 5:
                return "File Transfer Profile(SPP)";
            case 6:
                return "IrMC Sync Command Profile";
            case 7:
                return "Headset Profile";
            case 8:
                return "Cordless Telephony Profile";
            case 9:
                return "Audio Source Profile";
            case 10:
                return "Advanced Audio Distribution Profile(A2DP)";
            case 11:
                return "Audio/Video Remote Control Target Profile";
            case 12:
                return "Advanced Audio Distribution Profile";
            case 13:
                return "Audio/Video Remote Control Profile(AVRCP)";
            case 14:
                return "Video Conferencing Profile";
            case 15:
                return "Intercom Profile";
            case 16:
                return "Fax Profile";
            case 17:
                return "Headset Audio Gateway Profile";
            case 18:
                return "Heads-Free Profile(HFP)";
            case 19:
                return "Hands-Free Audio Gateway Profile(HFP)";
            case 20:
                return "Human Interface Device Profile(HID)";
            case 21:
                return "Generic Access Service";
            case 22:
                return "Generic Attribute Profile";
            case 23:
                return "Glucose Service";
            case 24:
                return "Health Thermometer Service";
            case 25:
                return "Device Information Service";
            case 26:
                return "Heart Rate Service";
            case 27:
                return "Battery Service";
            case 28:
                return "Blood Pressure Service";
            case 29:
                return "Alert Notification Service";
            case 30:
                return "Human Interface Device (HID) Service";
            case 31:
                return "Running Speed and Cadence Service";
            case 32:
                return "Cycling Speed and Cadence Service";
            case 33:
                return "Environmental Sensing Service";
            case 34:
                return "Internet Protocol Support Service";
            case 35:
                return "Fitness Machine Service";
            case 36:
                return "Device Name";
            case 37:
                return "Appearance";
            case 38:
                return "Peripheral Preferred Connection Parameters";
            case 39:
                return "RSSI Characteristic";
            case 40:
                return "Battery Level";
            case 41:
                return "Temperature Measurement";
            case 42:
                return "System ID";
            case 43:
                return "Model Number String";
            case 44:
                return "Serial Number String";
            case 45:
                return "Firmware Revision String";
            case 46:
                return "Hardware Revision String";
            case 47:
                return "Software Revision String";
            case 48:
                return "Manufacturer Name String";
            case 49:
                return "Heart Rate Measurement";
            case 50:
                return "Cycling Speed and Cadence Measurement";
            case 51:
                return "Running Speed and Cadence Measurement";
            default:
                return "Unknown UUID(" + uuid + ")";
        }
    }

    public static String read16BitUUID(UUID uuid) {
        if (uuid == null) {
            return "";
        }
        String[] strArrSplit = uuid.toString().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER, 2);
        if (strArrSplit.length != 2) {
            return uuid.toString();
        }
        if (!strArrSplit[1].equalsIgnoreCase(f16346a)) {
            return uuid.toString();
        }
        String str = strArrSplit[0];
        return str.length() != 8 ? uuid.toString() : a("0x%s", str.substring(4).toUpperCase(Locale.getDefault()));
    }

    public static String read32BitUUID(UUID uuid) {
        if (uuid == null) {
            return "";
        }
        String[] strArrSplit = uuid.toString().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER, 2);
        if (strArrSplit.length != 2) {
            return uuid.toString();
        }
        if (!strArrSplit[1].equalsIgnoreCase(f16346a)) {
            return uuid.toString();
        }
        String str = strArrSplit[0];
        return str.length() != 8 ? uuid.toString() : a("0x%s", str);
    }

    public static UUID to128BitUUID(String str) {
        return UUID.fromString(str);
    }

    public static UUID to16BitUUID(String str) {
        if (str == null || str.isEmpty()) {
            str = "0000";
        }
        return UUID.fromString(a("0000%s-0000-1000-8000-00805F9B34FB", str));
    }

    public static UUID to32BitUUID(String str) {
        if (str == null || str.isEmpty()) {
            str = "00000000";
        }
        return UUID.fromString(a("%s-0000-1000-8000-00805F9B34FB", str));
    }

    public static ParcelUuid toUUID(String str) {
        int length = str.length();
        if (length != 4) {
            return length != 8 ? new ParcelUuid(to128BitUUID(str)) : new ParcelUuid(to32BitUUID(str));
        }
        return new ParcelUuid(to16BitUUID(str));
    }
}

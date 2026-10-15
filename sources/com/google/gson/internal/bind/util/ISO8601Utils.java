package com.google.gson.internal.bind.util;

import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    private ISO8601Utils() {
    }

    private static boolean checkOffset(String str, int i9, char c5) {
        return i9 < str.length() && str.charAt(i9) == c5;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i9) {
        while (i9 < str.length()) {
            char cCharAt = str.charAt(i9);
            if (cCharAt < '0' || cCharAt > '9') {
                return i9;
            }
            i9++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i9, int i10) {
        String string = Integer.toString(i9);
        for (int length = i10 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e8 A[Catch: IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:21:0x0062, B:23:0x0072, B:24:0x0074, B:26:0x0080, B:27:0x0083, B:29:0x0089, B:33:0x0093, B:38:0x00a3, B:40:0x00ab, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:82:0x017f, B:62:0x00ff, B:63:0x0115, B:64:0x0116, B:68:0x0126, B:70:0x0133, B:73:0x013c, B:75:0x014e, B:78:0x015d, B:79:0x017a, B:81:0x017d, B:67:0x0122, B:84:0x01b1, B:85:0x01b8, B:45:0x00c5, B:46:0x00c8), top: B:96:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ee A[Catch: IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:21:0x0062, B:23:0x0072, B:24:0x0074, B:26:0x0080, B:27:0x0083, B:29:0x0089, B:33:0x0093, B:38:0x00a3, B:40:0x00ab, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:82:0x017f, B:62:0x00ff, B:63:0x0115, B:64:0x0116, B:68:0x0126, B:70:0x0133, B:73:0x013c, B:75:0x014e, B:78:0x015d, B:79:0x017a, B:81:0x017d, B:67:0x0122, B:84:0x01b1, B:85:0x01b8, B:45:0x00c5, B:46:0x00c8), top: B:96:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:66:0x0121  */
    /* JADX WARN: Code duplicated, block: B:67:0x0122 A[Catch: IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:21:0x0062, B:23:0x0072, B:24:0x0074, B:26:0x0080, B:27:0x0083, B:29:0x0089, B:33:0x0093, B:38:0x00a3, B:40:0x00ab, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:82:0x017f, B:62:0x00ff, B:63:0x0115, B:64:0x0116, B:68:0x0126, B:70:0x0133, B:73:0x013c, B:75:0x014e, B:78:0x015d, B:79:0x017a, B:81:0x017d, B:67:0x0122, B:84:0x01b1, B:85:0x01b8, B:45:0x00c5, B:46:0x00c8), top: B:96:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:81:0x017d A[Catch: IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:21:0x0062, B:23:0x0072, B:24:0x0074, B:26:0x0080, B:27:0x0083, B:29:0x0089, B:33:0x0093, B:38:0x00a3, B:40:0x00ab, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:82:0x017f, B:62:0x00ff, B:63:0x0115, B:64:0x0116, B:68:0x0126, B:70:0x0133, B:73:0x013c, B:75:0x014e, B:78:0x015d, B:79:0x017a, B:81:0x017d, B:67:0x0122, B:84:0x01b1, B:85:0x01b8, B:45:0x00c5, B:46:0x00c8), top: B:96:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01b1 A[Catch: IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:21:0x0062, B:23:0x0072, B:24:0x0074, B:26:0x0080, B:27:0x0083, B:29:0x0089, B:33:0x0093, B:38:0x00a3, B:40:0x00ab, B:52:0x00e2, B:54:0x00e8, B:56:0x00ee, B:82:0x017f, B:62:0x00ff, B:63:0x0115, B:64:0x0116, B:68:0x0126, B:70:0x0133, B:73:0x013c, B:75:0x014e, B:78:0x015d, B:79:0x017a, B:81:0x017d, B:67:0x0122, B:84:0x01b1, B:85:0x01b8, B:45:0x00c5, B:46:0x00c8), top: B:96:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:88:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:93:0x01dc  */
    /* JADX WARN: Instruction removed from duplicated block: B:88:0x01bd, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:93:0x01dc, please report this as an issue */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        String message;
        int i9;
        int i10;
        int i11;
        int i12;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i13 = index + 4;
            int i14 = parseInt(str, index, i13);
            if (checkOffset(str, i13, '-')) {
                i13 = index + 5;
            }
            int i15 = i13 + 2;
            int i16 = parseInt(str, i13, i15);
            if (checkOffset(str, i15, '-')) {
                i15 = i13 + 3;
            }
            int i17 = i15 + 2;
            int i18 = parseInt(str, i15, i17);
            boolean zCheckOffset = checkOffset(str, i17, 'T');
            if (!zCheckOffset && str.length() <= i17) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i14, i16 - 1, i18);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i17);
                return gregorianCalendar.getTime();
            }
            if (zCheckOffset) {
                int i19 = i15 + 5;
                int i20 = parseInt(str, i15 + 3, i19);
                if (checkOffset(str, i19, ':')) {
                    i19 = i15 + 6;
                }
                int i21 = i19 + 2;
                int i22 = parseInt(str, i19, i21);
                if (checkOffset(str, i21, ':')) {
                    i21 = i19 + 3;
                }
                if (str.length() <= i21 || (cCharAt2 = str.charAt(i21)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i17 = i21;
                    i9 = i20;
                    i10 = i22;
                } else {
                    int i23 = i21 + 2;
                    i12 = parseInt(str, i21, i23);
                    if (i12 > 59 && i12 < 63) {
                        i12 = 59;
                    }
                    if (checkOffset(str, i23, '.')) {
                        int i24 = i21 + 3;
                        int iIndexOfNonDigit = indexOfNonDigit(str, i21 + 4);
                        int iMin = Math.min(iIndexOfNonDigit, i21 + 6);
                        int i25 = parseInt(str, i24, iMin);
                        int i26 = iMin - i24;
                        if (i26 == 1) {
                            i25 *= 100;
                        } else if (i26 == 2) {
                            i25 *= 10;
                        }
                        i9 = i20;
                        i17 = iIndexOfNonDigit;
                        i10 = i22;
                        i11 = i25;
                    } else {
                        i9 = i20;
                        i17 = i23;
                        i10 = i22;
                        i11 = 0;
                    }
                }
                if (str.length() > i17) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i17);
                if (cCharAt == 'Z') {
                    timeZone = TIMEZONE_UTC;
                    length = i17 + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i17);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring.concat("00");
                    }
                    length = i17 + strSubstring.length();
                    if (!strSubstring.equals("+0000") || strSubstring.equals("+00:00")) {
                        timeZone = TIMEZONE_UTC;
                    } else {
                        String strConcat = "GMT".concat(strSubstring);
                        TimeZone timeZone2 = TimeZone.getTimeZone(strConcat);
                        String id = timeZone2.getID();
                        if (!id.equals(strConcat) && !id.replace(Constants.COLON_SEPARATOR, "").equals(strConcat)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + strConcat + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, i14);
                gregorianCalendar2.set(2, i16 - 1);
                gregorianCalendar2.set(5, i18);
                gregorianCalendar2.set(11, i9);
                gregorianCalendar2.set(12, i10);
                gregorianCalendar2.set(13, i12);
                gregorianCalendar2.set(14, i11);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            if (str.length() > i17) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i17);
            if (cCharAt == 'Z') {
                timeZone = TIMEZONE_UTC;
                length = i17 + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i17);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring.concat("00");
                }
                length = i17 + strSubstring.length();
                if (strSubstring.equals("+0000")) {
                    timeZone = TIMEZONE_UTC;
                } else {
                    timeZone = TIMEZONE_UTC;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, i14);
            gregorianCalendar3.set(2, i16 - 1);
            gregorianCalendar3.set(5, i18);
            gregorianCalendar3.set(11, i9);
            gregorianCalendar3.set(12, i10);
            gregorianCalendar3.set(13, i12);
            gregorianCalendar3.set(14, i11);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IllegalArgumentException e9) {
            e = e9;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (IndexOutOfBoundsException e10) {
            e = e10;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        }
    }

    private static int parseInt(String str, int i9, int i10) {
        int i11;
        int i12;
        if (i9 < 0 || i10 > str.length() || i9 > i10) {
            throw new NumberFormatException(str);
        }
        if (i9 < i10) {
            i12 = i9 + 1;
            int iDigit = Character.digit(str.charAt(i9), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i9, i10));
            }
            i11 = -iDigit;
        } else {
            i11 = 0;
            i12 = i9;
        }
        while (i12 < i10) {
            int i13 = i12 + 1;
            int iDigit2 = Character.digit(str.charAt(i12), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i9, i10));
            }
            i11 = (i11 * 10) - iDigit2;
            i12 = i13;
        }
        return -i11;
    }

    public static String format(Date date, boolean z8) {
        return format(date, z8, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z8, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z8 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z8) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i9 = offset / 60000;
            int iAbs = Math.abs(i9 / 60);
            int iAbs2 = Math.abs(i9 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, iAbs, 2);
            sb.append(':');
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}

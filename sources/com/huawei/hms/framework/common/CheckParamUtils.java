package com.huawei.hms.framework.common;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class CheckParamUtils {
    private static final String TAG = "CheckParamUtils";
    private static final String IPV6_REGEX = "(^((([0-9A-Fa-f]{1,4}:){7}(([0-9A-Fa-f]{1,4}){1}|:))|(([0-9A-Fa-f]{1,4}:){6}((:[0-9A-Fa-f]{1,4}){1}|((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){5}((:[0-9A-Fa-f]{1,4}){1,2}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){4}((:[0-9A-Fa-f]{1,4}){1,3}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){3}((:[0-9A-Fa-f]{1,4}){1,4}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){2}((:[0-9A-Fa-f]{1,4}){1,5}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){1}((:[0-9A-Fa-f]{1,4}){1,6}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(:((:[0-9A-Fa-f]{1,4}){1,7}|(:[fF]{4}){0,1}:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:)))$)";
    private static Pattern ipv6Pattern = Pattern.compile(IPV6_REGEX);

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int checkNumParam(int i9, int i10, int i11, int i12, String str) {
        if (i9 > i11 || i9 < i10) {
            return i12;
        }
        Logger.d(TAG, str);
        return i9;
    }

    public static void checkOffsetAndCount(long j, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j || j - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean isIpV4(String str) {
        if (str == null || str.isEmpty() || str.length() > 15 || !str.replace(".", "").matches("[0-9]+")) {
            return false;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 4) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (str2.length() > 4 || Integer.parseInt(str2) > 255) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIpV6(String str) {
        if (str == null || str.isEmpty() || str.length() < 2 || str.length() > 39) {
            return false;
        }
        return ipv6Pattern.matcher(str).matches();
    }

    public static long checkNumParam(long j, long j8, long j9, long j10, String str) {
        if (j > j9 || j < j8) {
            return j10;
        }
        Logger.d(TAG, str);
        return j;
    }
}

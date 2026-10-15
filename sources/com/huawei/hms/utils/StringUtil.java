package com.huawei.hms.utils;

import com.huawei.hms.framework.common.ExceptionCode;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class StringUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f15658a = Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)");

    private StringUtil() {
    }

    public static String addByteForNum(String str, int i9, char c5) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (length == i9) {
            return str;
        }
        if (length > i9) {
            return str.substring(length - i9);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (length < i9) {
            stringBuffer.append(c5);
            length++;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static boolean checkVersion(String str) {
        return f15658a.matcher(str).find();
    }

    public static int convertVersion2Integer(String str) {
        if (!checkVersion(str)) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 3) {
            return 0;
        }
        int i9 = (Integer.parseInt(strArrSplit[2]) * 1000) + (Integer.parseInt(strArrSplit[1]) * 100000) + (Integer.parseInt(strArrSplit[0]) * ExceptionCode.CRASH_EXCEPTION);
        return strArrSplit.length == 4 ? Integer.parseInt(strArrSplit[3]) + i9 : i9;
    }

    public static String objDesc(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }
}

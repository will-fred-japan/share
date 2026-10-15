package com.huawei.hms.push.utils;

import com.huawei.hms.support.log.HMSLog;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DateUtil {
    private DateUtil() {
    }

    public static String parseMilliSecondToString(Long l8) {
        if (l8 == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(l8);
        } catch (Exception e9) {
            HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", e9);
            return null;
        }
    }

    public static long parseUtcToMillisecond(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.parse(str.substring(0, str.indexOf(".")) + (str.substring(str.indexOf(".")).substring(0, 4) + "Z")).getTime();
    }
}

package com.google.gson.internal;

import W5.e;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class PreJava9DateFormatProvider {
    private PreJava9DateFormatProvider() {
    }

    private static String getDatePartOfDateTimePattern(int i9) {
        if (i9 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i9 == 1) {
            return "MMMM d, yyyy";
        }
        if (i9 == 2) {
            return "MMM d, yyyy";
        }
        if (i9 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException(e.i(i9, "Unknown DateFormat style: "));
    }

    private static String getTimePartOfDateTimePattern(int i9) {
        if (i9 == 0 || i9 == 1) {
            return "h:mm:ss a z";
        }
        if (i9 == 2) {
            return "h:mm:ss a";
        }
        if (i9 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException(e.i(i9, "Unknown DateFormat style: "));
    }

    public static DateFormat getUsDateTimeFormat(int i9, int i10) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i9) + " " + getTimePartOfDateTimePattern(i10), Locale.US);
    }
}

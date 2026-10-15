package com.alibaba.fastjson.util;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class ModuleUtil {
    private static boolean hasJavaSql = false;

    static {
        try {
            Class.forName("java.sql.Time");
            hasJavaSql = true;
        } catch (Throwable unused) {
            hasJavaSql = false;
        }
    }

    public static <T> T callWhenHasJavaSql(Callable<T> callable) {
        if (!hasJavaSql) {
            return null;
        }
        try {
            return callable.call();
        } catch (Exception e9) {
            throw new RuntimeException(e9);
        }
    }

    public static <ARG, T> T callWhenHasJavaSql(Function<ARG, T> function, ARG arg) {
        if (hasJavaSql) {
            return function.apply(arg);
        }
        return null;
    }

    public static <T, U, R> R callWhenHasJavaSql(BiFunction<T, U, R> biFunction, T t, U u8) {
        if (hasJavaSql) {
            return biFunction.apply(t, u8);
        }
        return null;
    }
}

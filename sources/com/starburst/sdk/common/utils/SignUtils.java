package com.starburst.sdk.common.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class SignUtils {
    public static String hmacSHA256(String str, String str2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str.getBytes(), "HmacSHA256"));
            return ByteTools.byte2String(mac.doFinal(str2.getBytes()));
        } catch (Exception e9) {
            throw new RuntimeException("Error generating sign", e9);
        }
    }
}

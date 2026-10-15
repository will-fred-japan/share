package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class bk {
    public static String a(String str) {
        try {
            return String.valueOf(bj.a(MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e9) {
            com.xiaomi.channel.commonutils.logger.c.a("CloudCoder.hash4SHA1 ", e9);
            throw new IllegalStateException("failed to SHA1");
        } catch (NoSuchAlgorithmException e10) {
            com.xiaomi.channel.commonutils.logger.c.a("CloudCoder.hash4SHA1 ", e10);
            throw new IllegalStateException("failed to SHA1");
        } catch (Exception e11) {
            com.xiaomi.channel.commonutils.logger.c.a("CloudCoder.hash4SHA1 ", e11);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String a(String str, String str2, Map<String, String> map, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            ArrayList<String> arrayList = new ArrayList();
            if (str != null) {
                arrayList.add(str.toUpperCase());
            }
            if (str2 != null) {
                arrayList.add(Uri.parse(str2).getEncodedPath());
            }
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new TreeMap(map).entrySet()) {
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            arrayList.add(str3);
            StringBuilder sb = new StringBuilder();
            boolean z8 = true;
            for (String str4 : arrayList) {
                if (!z8) {
                    sb.append('&');
                }
                sb.append(str4);
                z8 = false;
            }
            return a(sb.toString());
        }
        throw new InvalidParameterException("security is not nullable");
    }
}

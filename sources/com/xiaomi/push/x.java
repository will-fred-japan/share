package com.xiaomi.push;

import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f18443a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f18443a = map;
        map.put("FFD8FF", "jpg");
        map.put("89504E47", "png");
        map.put("47494638", "gif");
        map.put("474946", "gif");
        map.put("424D", "bmp");
    }

    public static long a(File file) {
        long jA = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i9 = 0; i9 < fileArrListFiles.length; i9++) {
                jA += fileArrListFiles[i9].isDirectory() ? a(fileArrListFiles[i9]) : fileArrListFiles[i9].length();
            }
            return jA;
        } catch (Exception e9) {
            H2.a.h(e9, new StringBuilder("Get folder size error: "), "FileUtils");
            return jA;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m843a(File file) {
        long length;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                length = a(file);
            } else {
                length = file.length();
            }
            return length < 104857600;
        } catch (Exception e9) {
            H2.a.h(e9, new StringBuilder("Check if internal file can be written error :"), "FileUtils");
            return false;
        }
    }
}

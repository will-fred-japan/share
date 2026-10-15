package com.apm.insight.log.a;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f11960a = 9;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f11961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f11962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList<String> f11963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f11964e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f11965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11966b;

        public a(File file, long j) {
            this.f11965a = file;
            this.f11966b = j;
        }
    }

    public static File[] a(String str, String str2, String str3, long j, long j8, int i9) {
        f11961b = j;
        f11962c = j8;
        f11964e = null;
        f11963d = null;
        if (j > j8) {
            f11964e = "time interval is invalid";
            return new File[0];
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            f11964e = "log dir not exists";
            return new File[0];
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replace(':', '-');
        }
        StringBuilder sb = new StringBuilder("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        sb.append(TextUtils.isEmpty(str2) ? "\\S+" : Pattern.quote(str2));
        sb.append("__");
        sb.append(TextUtils.isEmpty(str3) ? "\\S+" : Pattern.quote(str3));
        sb.append("\\.vlog$");
        Pattern patternCompile = Pattern.compile(sb.toString());
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = i9 > 0 ? new ArrayList() : null;
        File[] fileArrListFiles = file.listFiles(new d(arrayList, patternCompile, j8, j, arrayList2));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            f11964e = "log file not found";
            f11963d = arrayList;
        }
        if (i9 <= 0) {
            return fileArrListFiles == null ? new File[0] : fileArrListFiles;
        }
        Collections.sort(arrayList2, new e());
        int iMin = Math.min(i9, arrayList2.size());
        File[] fileArr = new File[iMin];
        for (int i10 = 0; i10 < iMin; i10++) {
            fileArr[i10] = ((a) arrayList2.get(i10)).f11965a;
        }
        return fileArr;
    }

    public static HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>();
        map.put("start", Long.toString(f11961b));
        map.put("end", Long.toString(f11962c));
        map.put("reason", f11964e);
        if (f11963d != null) {
            StringBuilder sb = new StringBuilder();
            for (String strSubstring : f11963d) {
                if (strSubstring.endsWith(".alog.hot")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - f11960a);
                }
                sb.append(strSubstring);
                sb.append(";");
            }
            map.put("file", sb.toString());
        }
        f11964e = null;
        f11963d = null;
        return map;
    }
}

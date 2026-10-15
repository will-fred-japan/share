package com.apm.insight.log.a;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ ArrayList f11967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Pattern f11968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ long f11969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ long f11970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private /* synthetic */ ArrayList f11971e;

    public d(ArrayList arrayList, Pattern pattern, long j, long j8, ArrayList arrayList2) {
        this.f11967a = arrayList;
        this.f11968b = pattern;
        this.f11969c = j;
        this.f11970d = j8;
        this.f11971e = arrayList2;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        String strGroup;
        this.f11967a.add(str);
        Matcher matcher = this.f11968b.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1 || (strGroup = matcher.group(1)) == null) {
            return false;
        }
        long j = Long.parseLong(strGroup);
        if (j > 0 && j <= this.f11969c) {
            File file2 = new File(file, str);
            long jLastModified = file2.lastModified();
            if (jLastModified > 0 && jLastModified >= this.f11970d) {
                ArrayList arrayList = this.f11971e;
                if (arrayList != null) {
                    arrayList.add(new c.a(file2, j));
                }
                return true;
            }
        }
        return false;
    }
}

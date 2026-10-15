package com.apm.insight.log.a;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class b implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ Pattern f11958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ a f11959b;

    public b(a aVar, Pattern pattern) {
        this.f11959b = aVar;
        this.f11958a = pattern;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return this.f11958a.matcher(str).find();
    }
}

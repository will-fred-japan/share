package com.apm.insight.log.a;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class e implements Comparator<c.a> {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(c.a aVar, c.a aVar2) {
        long j = aVar.f11966b;
        long j8 = aVar2.f11966b;
        if (j < j8) {
            return 1;
        }
        return j == j8 ? 0 : -1;
    }
}

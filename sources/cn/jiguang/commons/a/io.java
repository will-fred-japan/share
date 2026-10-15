package cn.jiguang.commons.a;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class io implements Comparator<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ik f10207a;

    private io(ik ikVar) {
        this.f10207a = ikVar;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Long l8, Long l9) {
        Long l10 = l8;
        Long l11 = l9;
        if (l10.longValue() == l11.longValue()) {
            return 0;
        }
        return l10.longValue() > l11.longValue() ? 1 : -1;
    }

    public /* synthetic */ io(ik ikVar, byte b9) {
        this(ikVar);
    }
}

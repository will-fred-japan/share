package cn.jiguang.commons.a;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class ip implements Comparator<ScanResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ik f10208a;

    private ip(ik ikVar) {
        this.f10208a = ikVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }

    public /* synthetic */ ip(ik ikVar, byte b9) {
        this(ikVar);
    }
}

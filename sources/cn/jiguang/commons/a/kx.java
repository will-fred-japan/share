package cn.jiguang.commons.a;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class kx implements Comparator<ScanResult> {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}

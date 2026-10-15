package p087l6;

import android.util.Log;
import java.util.HashMap;
import p096m7.k;

/* JADX INFO: compiled from: JPushHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f20088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HashMap f20090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f20091d;

    public c(d dVar, k kVar, String str, HashMap map) {
        this.f20091d = dVar;
        this.f20088a = kVar;
        this.f20089b = str;
        this.f20090c = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        HashMap map = this.f20090c;
        k kVar = this.f20088a;
        if (kVar != null || (str = this.f20089b) == null) {
            kVar.success(map);
            return;
        }
        d dVar = this.f20091d;
        if (dVar.f20096e != null) {
            dVar.e(str, map);
        } else {
            Log.d("| JPUSH | Flutter | Android | ", "channel is null do nothing");
        }
    }
}

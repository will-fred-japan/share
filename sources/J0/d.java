package J0;

import androidx.window.sidecar.SidecarDisplayFeature;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: SidecarAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends l implements K7.l<SidecarDisplayFeature, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2650a = new d(1);

    @Override // K7.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        k.e(require, "$this$require");
        boolean z8 = true;
        if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
            z8 = false;
        }
        return Boolean.valueOf(z8);
    }
}

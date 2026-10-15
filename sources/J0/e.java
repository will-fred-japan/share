package J0;

import androidx.window.sidecar.SidecarDisplayFeature;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: SidecarAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends l implements K7.l<SidecarDisplayFeature, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f2651a = new e(1);

    @Override // K7.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        k.e(require, "$this$require");
        return Boolean.valueOf(require.getRect().left == 0 || require.getRect().top == 0);
    }
}

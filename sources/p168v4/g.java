package p168v4;

import android.location.Location;
import p096m7.k;
import p179w7.e;
import p185x4.p;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements p, e.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f21910a;

    @Override // w7.e.n
    public void a(boolean z8) {
        k kVar = this.f21910a;
        if (z8) {
            kVar.success(Boolean.TRUE);
        } else {
            kVar.success(Boolean.FALSE);
        }
    }

    @Override // p185x4.p
    public void c(Location location) {
        this.f21910a.success(p185x4.k.a(location));
    }
}

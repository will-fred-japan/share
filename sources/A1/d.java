package A1;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: compiled from: LaunchModeTrigger.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p167v3.b {
    @Override // p167v3.b
    public final void c(Activity activity) {
    }

    @Override // p167v3.b
    public final void e(Bundle bundle) {
        p199z2.b.f22476f = bundle != null;
        p199z2.b.f22477g = true;
    }

    @Override // p167v3.b
    public final void f(Activity activity) {
        p199z2.b.f22475e = true;
        p199z2.b.f22477g = false;
        p199z2.b.f22478h = activity.getComponentName().toShortString();
    }

    @Override // p167v3.b
    public final void onActivityStarted(Activity activity) {
        p199z2.b.f22479i = activity.getComponentName().toShortString();
    }

    @Override // p167v3.b
    /* JADX INFO: renamed from: c */
    public final void mo848c() {
    }
}

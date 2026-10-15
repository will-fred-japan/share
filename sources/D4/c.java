package D4;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeManager;

/* JADX INFO: compiled from: ApmDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements E4.a<IActivityLifeManager> {
    @Override // E4.a
    public final IActivityLifeManager a() {
        return ActivityLifeObserver.getInstance();
    }
}

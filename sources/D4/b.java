package D4;

import com.bytedance.apm.impl.MonitorLogManagerImpl;
import com.bytedance.services.apm.api.IMonitorLogManager;

/* JADX INFO: compiled from: ApmDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements E4.a<IMonitorLogManager> {
    @Override // E4.a
    public final IMonitorLogManager a() {
        return new MonitorLogManagerImpl();
    }
}

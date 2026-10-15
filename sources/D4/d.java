package D4;

import com.bytedance.apm.impl.ApmAgentServiceImpl;
import com.bytedance.services.apm.api.IApmAgent;

/* JADX INFO: compiled from: ApmDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements E4.a<IApmAgent> {
    @Override // E4.a
    public final IApmAgent a() {
        return new ApmAgentServiceImpl();
    }
}

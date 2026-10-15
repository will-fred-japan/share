package org.chromium.support_lib_boundary;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    Set<String> getRequestedWithHeaderOriginAllowList();

    void setAllowContentAccess(boolean z8);

    void setAllowFileAccess(boolean z8);

    void setBlockNetworkLoads(boolean z8);

    void setCacheMode(int i9);

    void setRequestedWithHeaderOriginAllowList(Set<String> set);
}

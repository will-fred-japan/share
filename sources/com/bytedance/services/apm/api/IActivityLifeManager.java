package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import p167v3.b;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityLifeManager extends IService {
    boolean isForeground();

    void register(b bVar);

    void unregister(b bVar);
}

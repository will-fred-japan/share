package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import org.json.JSONObject;
import p167v3.d;

/* JADX INFO: loaded from: classes.dex */
public interface IMonitorLogManager extends IService {
    void deleteLegacyLogByIds(String str, String str2);

    void getLegacyLog(long j, long j8, String str, d dVar);

    List<JSONObject> getRecentUiActionRecords();
}

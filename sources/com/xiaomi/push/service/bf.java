package com.xiaomi.push.service;

import com.xiaomi.push.ih;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class bf {
    public static ih a(ih ihVar) {
        Map<String, String> map;
        if (ihVar != null && (map = ihVar.f650b) != null) {
            map.remove("score_info");
        }
        return ihVar;
    }
}

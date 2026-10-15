package com.pichillilorenzo.flutter_inappwebview_android.tracing;

import A0.j;
import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TracingSettings implements ISettings<j> {
    public static final String LOG_TAG = "TracingSettings";
    public List<Object> categories = new ArrayList();
    public Integer tracingMode;

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<j> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("categories", this.categories);
        map.put("tracingMode", this.tracingMode);
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> getRealSettings(j jVar) {
        return toMap();
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<j> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.getClass();
                if (key.equals("tracingMode")) {
                    this.tracingMode = (Integer) value;
                } else if (key.equals("categories")) {
                    this.categories = (List) value;
                }
            }
        }
        return this;
    }
}

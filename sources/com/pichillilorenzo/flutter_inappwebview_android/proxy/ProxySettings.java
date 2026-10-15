package com.pichillilorenzo.flutter_inappwebview_android.proxy;

import A0.b;
import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.ProxyRuleExt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProxySettings implements ISettings<b> {
    List<String> bypassRules = new ArrayList();
    List<String> directs = new ArrayList();
    List<ProxyRuleExt> proxyRules = new ArrayList();
    Boolean bypassSimpleHostnames = null;
    Boolean removeImplicitRules = null;
    Boolean reverseBypassEnabled = Boolean.FALSE;

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<b> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        ArrayList arrayList = new ArrayList();
        Iterator<ProxyRuleExt> it = this.proxyRules.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toMap());
        }
        HashMap map = new HashMap();
        map.put("bypassRules", this.bypassRules);
        map.put("directs", this.directs);
        map.put("proxyRules", arrayList);
        map.put("bypassSimpleHostnames", this.bypassSimpleHostnames);
        map.put("removeImplicitRules", this.removeImplicitRules);
        map.put("reverseBypassEnabled", this.reverseBypassEnabled);
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> getRealSettings(b bVar) {
        toMap();
        new ArrayList();
        throw null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<b> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.getClass();
                switch (key) {
                    case "bypassSimpleHostnames":
                        this.bypassSimpleHostnames = (Boolean) value;
                        break;
                    case "proxyRules":
                        this.proxyRules = new ArrayList();
                        Iterator it = ((List) value).iterator();
                        while (it.hasNext()) {
                            ProxyRuleExt proxyRuleExtFromMap = ProxyRuleExt.fromMap((Map) it.next());
                            if (proxyRuleExtFromMap != null) {
                                this.proxyRules.add(proxyRuleExtFromMap);
                            }
                        }
                        break;
                    case "reverseBypassEnabled":
                        this.reverseBypassEnabled = (Boolean) value;
                        break;
                    case "removeImplicitRules":
                        this.removeImplicitRules = (Boolean) value;
                        break;
                    case "bypassRules":
                        this.bypassRules = (List) value;
                        break;
                    case "directs":
                        this.directs = (List) value;
                        break;
                }
            }
        }
        return this;
    }
}

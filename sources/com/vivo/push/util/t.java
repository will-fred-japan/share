package com.vivo.push.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class t {
    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.getString(next));
        }
        return map;
    }
}

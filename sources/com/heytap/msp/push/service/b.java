package com.heytap.msp.push.service;

import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.d.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14415a = "ParserFactory";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, e> f14416b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f14417a = new b();
    }

    private b() {
        this.f14416b = new HashMap();
        b();
    }

    private void b() {
        this.f14416b.put(Integer.valueOf(MessageConstant.MessageType.MESSAGE_SPT_ENHANCED_DATA), new com.heytap.msp.push.service.a());
        this.f14416b.put(Integer.valueOf(MessageConstant.MessageType.MESSAGE_SPT_CALLKIT_DATA_BIND), new com.heytap.mcssdk.d.b());
        com.heytap.mcssdk.utils.e.b(f14415a, "Default parsers registered automatically");
    }

    public e a(int i9) {
        e eVar = this.f14416b.get(Integer.valueOf(i9));
        if (eVar == null) {
            com.heytap.mcssdk.utils.e.d(f14415a, "No parser found for message type: " + i9);
        }
        return eVar;
    }

    public static b a() {
        return a.f14417a;
    }
}

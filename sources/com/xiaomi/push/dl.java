package com.xiaomi.push;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17242a = "power_consumption_stats";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17243b = "off_up_ct";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f17244c = "off_dn_ct";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f17245d = "off_ping_ct";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f17246e = "off_pong_ct";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f17247f = "off_dur";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f17248g = "on_up_ct";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f17249h = "on_dn_ct";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f17250i = "on_ping_ct";
    private final String j = "on_pong_ct";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f17251k = "on_dur";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f17252l = "hb_strategy";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f17253m = "start_time";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f17254n = "end_time";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f17255o = "xmsf_vc";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f17256p = "android_vc";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f17257q = "uuid";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f17258r = "push_bundle_vc";

    public void a(Context context, dk dkVar) {
        if (dkVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("off_up_ct", Integer.valueOf(dkVar.a()));
        map.put("off_dn_ct", Integer.valueOf(dkVar.b()));
        map.put("off_ping_ct", Integer.valueOf(dkVar.c()));
        map.put("off_pong_ct", Integer.valueOf(dkVar.d()));
        map.put("off_dur", Long.valueOf(dkVar.m238a()));
        map.put("on_up_ct", Integer.valueOf(dkVar.e()));
        map.put("on_dn_ct", Integer.valueOf(dkVar.f()));
        map.put("on_ping_ct", Integer.valueOf(dkVar.g()));
        map.put("on_pong_ct", Integer.valueOf(dkVar.h()));
        map.put("on_dur", Long.valueOf(dkVar.m240b()));
        map.putAll(dkVar.m239a());
        map.put("start_time", Long.valueOf(dkVar.m241c()));
        map.put("end_time", Long.valueOf(dkVar.m242d()));
        map.put("xmsf_vc", Integer.valueOf(dkVar.i()));
        map.put("android_vc", Integer.valueOf(dkVar.j()));
        map.put("uuid", com.xiaomi.push.service.v.m827a(context));
        map.put("push_bundle_vc", Integer.valueOf(dkVar.k()));
        fw.a().a("power_consumption_stats", map);
    }
}

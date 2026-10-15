package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GrsBaseInfo f15065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f15066c;

    public b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo) {
        this.f15064a = context;
        this.f15065b = grsBaseInfo;
        this.f15066c = aVar;
    }

    public String a(boolean z8) {
        String strA;
        String str = com.huawei.hms.framework.network.grs.a.a(this.f15066c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + str);
        String strA2 = this.f15066c.a().a("geoipCountryCodetime", "0");
        long j = 0;
        if (!TextUtils.isEmpty(strA2) && strA2.matches("\\d+")) {
            try {
                j = Long.parseLong(strA2);
            } catch (NumberFormatException e9) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e9);
            }
        }
        if (TextUtils.isEmpty(str) || com.huawei.hms.framework.network.grs.h.e.a(Long.valueOf(j))) {
            com.huawei.hms.framework.network.grs.g.j.c cVar = new com.huawei.hms.framework.network.grs.g.j.c(this.f15065b, this.f15064a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c cVarC = this.f15066c.c();
            if (cVarC != null) {
                try {
                    strA = h.a(cVarC.a("services", ""), cVar.c());
                } catch (JSONException e10) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e10.getMessage()));
                    strA = null;
                }
                if (!TextUtils.isEmpty(strA)) {
                    cVarC.b("services", strA);
                }
            }
            if (z8) {
                d dVarA = this.f15066c.b().a(cVar, "geoip.countrycode", cVarC, -1);
                if (dVarA != null) {
                    str = com.huawei.hms.framework.network.grs.a.a(dVarA.j(), "geoip.countrycode").get("ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.f15066c.b().a(cVar, null, "geoip.countrycode", cVarC, -1);
            }
        }
        return str;
    }
}

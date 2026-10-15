package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f15078o = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, List<String>> f15079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f15080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f15082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f15085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15087i;
    private String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f15088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f15089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Exception f15090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f15091n;

    public d(int i9, Map<String, List<String>> map, byte[] bArr, long j) {
        this.f15086h = 2;
        this.f15087i = 9001;
        this.j = "";
        this.f15088k = 0L;
        this.f15089l = "";
        this.f15081c = i9;
        this.f15079a = map;
        this.f15080b = ByteBuffer.wrap(bArr).array();
        this.f15082d = j;
        s();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    private void p() {
        int i9;
        if (m()) {
            Logger.i(f15078o, "GRSSDK get httpcode{304} not any changed.");
            c(1);
            return;
        }
        if (!o()) {
            Logger.i(f15078o, "GRSSDK parse server body all failed.");
            c(2);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(StringUtils.byte2Str(this.f15080b));
            if (jSONObject.has("isSuccess")) {
                if (jSONObject.getInt("isSuccess") == 1) {
                    i9 = 1;
                } else {
                    i9 = 2;
                }
            } else if (!jSONObject.has("resultCode")) {
                Logger.e(f15078o, "sth. wrong because server errorcode's key.");
                i9 = -1;
            } else if (jSONObject.getInt("resultCode") == 0) {
                i9 = 1;
            } else {
                i9 = 2;
            }
            if (i9 != 1 && jSONObject.has("services")) {
                i9 = 0;
            }
            c(i9);
            if (i9 == 1 || i9 == 0) {
                f(jSONObject.has("services") ? jSONObject.getJSONObject("services").toString() : "");
                e(jSONObject.has("errorList") ? jSONObject.getJSONObject("errorList").toString() : "");
            } else {
                b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : 9001);
                d(jSONObject.has("errorDesc") ? jSONObject.getString("errorDesc") : "");
            }
        } catch (JSONException e9) {
            Logger.w(f15078o, "GrsResponse GrsResponse(String result) JSONException: %s", StringUtils.anonymizeMessage(e9.getMessage()));
            c(2);
        }
    }

    private void q() {
        if (o() || n() || m()) {
            Map<String, String> mapR = r();
            if (mapR.size() <= 0) {
                Logger.w(f15078o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(mapR);
                    a(mapR);
                }
                if (n()) {
                    c(mapR);
                }
            } catch (JSONException e9) {
                Logger.w(f15078o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e9.getMessage()));
            }
        }
    }

    private Map<String, String> r() {
        HashMap map = new HashMap(16);
        Map<String, List<String>> map2 = this.f15079a;
        if (map2 == null || map2.size() <= 0) {
            Logger.v(f15078o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return map;
        }
        for (Map.Entry<String, List<String>> entry : this.f15079a.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                map.put(key, it.next());
            }
        }
        return map;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.j;
    }

    public int b() {
        return this.f15081c;
    }

    public int c() {
        return this.f15087i;
    }

    public Exception d() {
        return this.f15090m;
    }

    public String e() {
        return this.f15089l;
    }

    public int f() {
        return this.f15086h;
    }

    public long g() {
        return this.f15084f;
    }

    public long h() {
        return this.f15083e;
    }

    public long i() {
        return this.f15082d;
    }

    public String j() {
        return this.f15085g;
    }

    public long k() {
        return this.f15088k;
    }

    public String l() {
        return this.f15091n;
    }

    public boolean m() {
        return this.f15081c == 304;
    }

    public boolean n() {
        return this.f15081c == 503;
    }

    public boolean o() {
        return this.f15081c == 200;
    }

    public d(Exception exc, long j) {
        this.f15081c = 0;
        this.f15086h = 2;
        this.f15087i = 9001;
        this.j = "";
        this.f15088k = 0L;
        this.f15089l = "";
        this.f15090m = exc;
        this.f15082d = j;
    }

    private void b(int i9) {
        this.f15087i = i9;
    }

    private void c(int i9) {
        this.f15086h = i9;
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.f15085g = str;
    }

    public void a(int i9) {
    }

    private void c(long j) {
        this.f15088k = j;
    }

    public void a(long j) {
        this.f15084f = j;
    }

    public void b(long j) {
        this.f15083e = j;
    }

    private void c(String str) {
        this.j = str;
    }

    public void a(String str) {
        this.f15089l = str;
    }

    public void b(String str) {
        this.f15091n = str;
    }

    private void a(Map<String, String> map) {
        if (!map.containsKey("ETag")) {
            Logger.i(f15078o, "Response Heads has not Etag");
            return;
        }
        String str = map.get("ETag");
        if (TextUtils.isEmpty(str)) {
            Logger.i(f15078o, "The Response Heads Etag is Empty");
        } else {
            Logger.i(f15078o, "success get Etag from server");
            a(str);
        }
    }

    private void b(Map<String, String> map) {
        long time;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (TextUtils.isEmpty(str) || !str.contains("max-age=")) {
                time = 0;
            } else {
                try {
                    time = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.v(f15078o, "Cache-Control value{%s}", Long.valueOf(time));
                    } catch (NumberFormatException e9) {
                        e = e9;
                        Logger.w(f15078o, "getExpireTime addHeadersToResult NumberFormatException", e);
                    }
                } catch (NumberFormatException e10) {
                    e = e10;
                    time = 0;
                }
            }
        } else {
            if (map.containsKey("Expires")) {
                String str2 = map.get("Expires");
                Logger.v(f15078o, "expires is{%s}", str2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                String str3 = map.containsKey("Date") ? map.get("Date") : null;
                try {
                    time = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (ParseException e11) {
                    Logger.w(f15078o, "getExpireTime ParseException.", e11);
                    time = 0;
                }
            } else {
                Logger.i(f15078o, "response headers neither contains Cache-Control nor Expires.");
            }
            time = 0;
        }
        if (time <= 0 || time > 2592000) {
            time = 86400;
        }
        long j = time * 1000;
        Logger.i(f15078o, "convert expireTime{%s}", Long.valueOf(j));
        c(String.valueOf(System.currentTimeMillis() + j));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    private void c(Map<String, String> map) {
        long j;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (TextUtils.isEmpty(str)) {
                j = 0;
            } else {
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException e9) {
                    Logger.w(f15078o, "getRetryAfter addHeadersToResult NumberFormatException", e9);
                    j = 0;
                }
            }
        } else {
            j = 0;
        }
        long j8 = j * 1000;
        Logger.v(f15078o, "convert retry-afterTime{%s}", Long.valueOf(j8));
        c(j8);
    }
}

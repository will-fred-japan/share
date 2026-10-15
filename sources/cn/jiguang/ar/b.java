package cn.jiguang.ar;

import android.content.Context;
import cn.jiguang.aw.j;
import cn.jiguang.aw.m;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends cn.jiguang.an.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<Long, Long> f9391g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f9392h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f9393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Object f9394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0124b f9396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f9397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9398f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f9402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f9403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f9404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<String, Integer> f9405e = new HashMap();

        public int a() {
            return this.f9401a;
        }

        public long b() {
            return this.f9402b;
        }

        public long c() {
            return this.f9403c;
        }

        public long d() {
            return this.f9404d;
        }

        public Map<String, Integer> e() {
            return this.f9405e;
        }

        public void b(long j) {
            this.f9403c = j;
        }

        public void c(long j) {
            this.f9404d = j;
        }

        public void a(int i9) {
            this.f9401a = i9;
        }

        public void a(long j) {
            this.f9402b = j;
        }

        public void a(String str) {
            if (this.f9405e == null) {
                this.f9405e = new HashMap();
            }
            Integer num = this.f9405e.get(str);
            if (num == null) {
                num = 0;
            }
            this.f9405e.put(str, Integer.valueOf(num.intValue() + 1));
        }

        public void a(Map<String, Integer> map) {
            this.f9405e = map != null ? new HashMap(map) : new HashMap();
        }
    }

    /* JADX INFO: renamed from: cn.jiguang.ar.b$b, reason: collision with other inner class name */
    public static class C0124b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f9407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f9408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f9409d;

        public int a() {
            return this.f9406a;
        }

        public long b() {
            return this.f9407b;
        }

        public long c() {
            return this.f9408c;
        }

        public long d() {
            return this.f9409d;
        }

        public void b(long j) {
            this.f9408c = j;
        }

        public void c(long j) {
            this.f9409d = j;
        }

        public void a(int i9) {
            this.f9406a = i9;
        }

        public void a(long j) {
            this.f9407b = j;
        }
    }

    public b(Context context, String str, String str2, long j) {
        super(context, str);
        this.f9394b = new Object();
        if (j > 0) {
            this.f9393a = j + BundleUtil.UNDERLINE_TAG + str2;
        } else {
            this.f9393a = str2;
        }
        this.f9398f = "tcp_save_" + this.f9393a + BundleUtil.UNDERLINE_TAG + System.identityHashCode(this);
    }

    private static void m() {
        final m mVarA = m.a();
        if (mVarA.b("tcp_start_time_map_cleanup")) {
            mVarA.a("tcp_start_time_map_cleanup");
        }
        mVarA.a("tcp_start_time_map_cleanup", new Runnable() { // from class: cn.jiguang.ar.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.o();
                synchronized (b.f9391g) {
                    try {
                        if (b.f9391g.isEmpty()) {
                            cn.jiguang.x.f.c("TCPBaseMoniter", "startTimeMap is empty, cleanup task will stop");
                        } else {
                            mVarA.a("tcp_start_time_map_cleanup", this, 300000L);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }, 300000L);
        cn.jiguang.x.f.c("TCPBaseMoniter", "Started cleanup task for startTimeMap");
    }

    private static void n() {
        m mVarA = m.a();
        if (mVarA.b("tcp_start_time_map_cleanup")) {
            mVarA.a("tcp_start_time_map_cleanup");
            cn.jiguang.x.f.c("TCPBaseMoniter", "Stopped cleanup task for startTimeMap");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<Long, Long> map = f9391g;
        synchronized (map) {
            try {
                if (map.isEmpty()) {
                    return;
                }
                Iterator<Map.Entry<Long, Long>> it = map.entrySet().iterator();
                int i9 = 0;
                while (it.hasNext()) {
                    Map.Entry<Long, Long> next = it.next();
                    long jLongValue = jCurrentTimeMillis - next.getValue().longValue();
                    if (jLongValue > 600000) {
                        it.remove();
                        i9++;
                        cn.jiguang.x.f.c("TCPBaseMoniter", "Cleaned expired startTime entry: id=" + next.getKey() + ", elapsed=" + jLongValue + "ms");
                    }
                }
                if (i9 > 0) {
                    cn.jiguang.x.f.c("TCPBaseMoniter", "Cleaned " + i9 + " expired startTime entries");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long a(long j) {
        cn.jiguang.x.f.i("TCPBaseMoniter", "start(long startTime) is not supported for this monitor type");
        return 0L;
    }

    public long b(long j) {
        Long lRemove;
        boolean zIsEmpty;
        if (j <= 0) {
            cn.jiguang.x.f.c("TCPBaseMoniter", "id is invalid, cannot end");
            return 0L;
        }
        Map<Long, Long> map = f9391g;
        synchronized (map) {
            lRemove = map.remove(Long.valueOf(j));
            zIsEmpty = map.isEmpty();
        }
        if (zIsEmpty) {
            n();
        }
        if (lRemove == null) {
            cn.jiguang.x.f.i("TCPBaseMoniter", "start time not found for id: " + j);
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - lRemove.longValue();
        c(jCurrentTimeMillis);
        h();
        return jCurrentTimeMillis;
    }

    public void c(long j) {
        synchronized (this.f9394b) {
            try {
                this.f9395c++;
                if (this.f9396d == null) {
                    this.f9396d = new C0124b();
                }
                int i9 = this.f9396d.f9406a + 1;
                this.f9396d.f9406a = i9;
                long j8 = this.f9396d.f9407b;
                this.f9396d.f9407b = j8 + ((j - j8) / ((long) i9));
                if (i9 == 1 || j < this.f9396d.f9408c) {
                    this.f9396d.f9408c = j;
                }
                if (i9 == 1 || j > this.f9396d.f9409d) {
                    this.f9396d.f9409d = j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long d() {
        long j;
        Map<Long, Long> map = f9391g;
        synchronized (map) {
            try {
                j = f9392h + 1;
                f9392h = j;
                map.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
                if (map.size() == 1) {
                    m();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public int e() {
        return this.f9395c;
    }

    public C0124b f() {
        return this.f9396d;
    }

    public a g() {
        return this.f9397e;
    }

    public boolean h() {
        String str = this.f9393a;
        if (str == null || str.isEmpty()) {
            cn.jiguang.x.f.i("TCPBaseMoniter", "fileName is null or empty, cannot save");
            return false;
        }
        m mVarA = m.a();
        if (mVarA.b(this.f9398f)) {
            mVarA.a(this.f9398f);
            cn.jiguang.x.f.c("TCPBaseMoniter", "Cancelled existing save task for: " + this.f9393a);
        }
        mVarA.a(this.f9398f, new Runnable() { // from class: cn.jiguang.ar.b.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                try {
                    JSONObject jSONObjectB = b.this.b();
                    if (jSONObjectB == null) {
                        str2 = "toJson() returned null, cannot save";
                    } else if (j.a(b.this.f9393a, jSONObjectB)) {
                        cn.jiguang.x.f.c("TCPBaseMoniter", "Successfully saved monitor data to file: " + b.this.f9393a);
                        return;
                    } else {
                        str2 = "Failed to save monitor data to file: " + b.this.f9393a;
                    }
                    cn.jiguang.x.f.i("TCPBaseMoniter", str2);
                } catch (Throwable th) {
                    cn.jiguang.x.f.b("TCPBaseMoniter", "Exception while saving monitor data: " + th.getMessage(), th);
                }
            }
        }, 2000L);
        cn.jiguang.x.f.c("TCPBaseMoniter", "Scheduled save task for: " + this.f9393a + " (delay 2s)");
        return true;
    }

    public boolean i() {
        String str = this.f9393a;
        if (str == null || str.isEmpty()) {
            cn.jiguang.x.f.i("TCPBaseMoniter", "fileName is null or empty, cannot delete");
            return false;
        }
        try {
            boolean zD = j.d(this.f9393a);
            if (zD) {
                cn.jiguang.x.f.c("TCPBaseMoniter", "Successfully deleted monitor data file: " + this.f9393a);
                return zD;
            }
            cn.jiguang.x.f.i("TCPBaseMoniter", "Failed to delete monitor data file: " + this.f9393a);
            return zD;
        } catch (Throwable th) {
            cn.jiguang.x.f.b("TCPBaseMoniter", "Exception while deleting monitor data file: " + th.getMessage(), th);
            return false;
        }
    }

    public boolean j() {
        String str = this.f9393a;
        if (str == null || str.isEmpty()) {
            cn.jiguang.x.f.i("TCPBaseMoniter", "fileName is null or empty, cannot load");
            return false;
        }
        try {
            JSONObject jSONObjectA = j.a(this.f9393a);
            if (jSONObjectA == null) {
                cn.jiguang.x.f.c("TCPBaseMoniter", "No data found in file: " + this.f9393a);
                return false;
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject(JThirdPlatFormInterface.KEY_EXTRA);
            if (jSONObjectOptJSONObject == null) {
                cn.jiguang.x.f.i("TCPBaseMoniter", "No 'extra' field found in file: " + this.f9393a);
                return false;
            }
            this.f9395c = jSONObjectOptJSONObject.optInt("c", 0);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("s");
            if (jSONObjectOptJSONObject2 != null) {
                C0124b c0124b = new C0124b();
                this.f9396d = c0124b;
                c0124b.f9406a = jSONObjectOptJSONObject2.optInt("c", 0);
                this.f9396d.f9407b = jSONObjectOptJSONObject2.optLong("n_avg", 0L);
                this.f9396d.f9408c = jSONObjectOptJSONObject2.optLong("n_min", 0L);
                this.f9396d.f9409d = jSONObjectOptJSONObject2.optLong("n_max", 0L);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("f");
            if (jSONObjectOptJSONObject3 != null) {
                a aVar = new a();
                this.f9397e = aVar;
                aVar.f9401a = jSONObjectOptJSONObject3.optInt("c", 0);
                this.f9397e.f9402b = jSONObjectOptJSONObject3.optLong("n_avg", 0L);
                this.f9397e.f9403c = jSONObjectOptJSONObject3.optLong("n_min", 0L);
                this.f9397e.f9404d = jSONObjectOptJSONObject3.optLong("n_max", 0L);
                String strOptString = jSONObjectOptJSONObject3.optString("t", "");
                if (strOptString == null || strOptString.isEmpty()) {
                    this.f9397e.f9405e = new HashMap();
                } else {
                    this.f9397e.f9405e = a(strOptString);
                }
            }
            cn.jiguang.x.f.c("TCPBaseMoniter", "Successfully loaded monitor data from file: " + this.f9393a);
            return true;
        } catch (Throwable th) {
            cn.jiguang.x.f.b("TCPBaseMoniter", "Exception while loading monitor data: " + th.getMessage(), th);
            return false;
        }
    }

    public long a(long j, int i9, String str) {
        Long lRemove;
        boolean zIsEmpty;
        if (j <= 0) {
            cn.jiguang.x.f.c("TCPBaseMoniter", "id is invalid, cannot end");
            return 0L;
        }
        Map<Long, Long> map = f9391g;
        synchronized (map) {
            lRemove = map.remove(Long.valueOf(j));
            zIsEmpty = map.isEmpty();
        }
        if (zIsEmpty) {
            n();
        }
        if (lRemove == null) {
            cn.jiguang.x.f.i("TCPBaseMoniter", "start time not found for id: " + j);
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - lRemove.longValue();
        a(jCurrentTimeMillis, i9);
        h();
        return jCurrentTimeMillis;
    }

    public String a(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z8 = true;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!z8) {
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
            sb.append(entry.getKey());
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(entry.getValue());
            z8 = false;
        }
        return sb.toString();
    }

    public Map<String, Integer> a(String str) {
        HashMap map = new HashMap();
        if (str != null && !str.isEmpty()) {
            try {
                for (String str2 : str.split("\\|")) {
                    if (str2 != null && !str2.isEmpty()) {
                        String[] strArrSplit = str2.split(Constants.COLON_SEPARATOR);
                        if (strArrSplit.length == 2) {
                            String str3 = strArrSplit[0];
                            try {
                                map.put(str3, Integer.valueOf(Integer.parseInt(strArrSplit[1])));
                            } catch (NumberFormatException unused) {
                                cn.jiguang.x.f.i("TCPBaseMoniter", "Failed to parse count for code: " + str3);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.x.f.b("TCPBaseMoniter", "Failed to parse types string: ".concat(str), th);
            }
        }
        return map;
    }

    @Override // cn.jiguang.an.a
    public JSONObject a() {
        if (this.f9395c <= 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("c", this.f9395c);
            if (this.f9396d != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("c", this.f9396d.f9406a);
                jSONObject2.put("n_avg", this.f9396d.f9407b);
                jSONObject2.put("n_min", this.f9396d.f9408c);
                jSONObject2.put("n_max", this.f9396d.f9409d);
                jSONObject.put("s", jSONObject2);
            }
            if (this.f9397e != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("c", this.f9397e.f9401a);
                jSONObject3.put("n_avg", this.f9397e.f9402b);
                jSONObject3.put("n_min", this.f9397e.f9403c);
                jSONObject3.put("n_max", this.f9397e.f9404d);
                if (this.f9397e.f9405e != null && !this.f9397e.f9405e.isEmpty()) {
                    jSONObject3.put("t", a(this.f9397e.f9405e));
                }
                jSONObject.put("f", jSONObject3);
            }
            return jSONObject;
        } catch (JSONException e9) {
            cn.jiguang.x.f.i("TCPBaseMoniter", "build getExtraJson data failed, " + e9.getMessage());
            return null;
        }
    }

    public void a(int i9) {
        this.f9395c = i9;
    }

    public void a(long j, int i9) {
        synchronized (this.f9394b) {
            try {
                this.f9395c++;
                if (this.f9397e == null) {
                    this.f9397e = new a();
                }
                int i10 = this.f9397e.f9401a + 1;
                this.f9397e.f9401a = i10;
                long j8 = this.f9397e.f9402b;
                this.f9397e.f9402b = j8 + ((j - j8) / ((long) i10));
                if (i10 == 1 || j < this.f9397e.f9403c) {
                    this.f9397e.f9403c = j;
                }
                if (i10 == 1 || j > this.f9397e.f9404d) {
                    this.f9397e.f9404d = j;
                }
                this.f9397e.a(String.valueOf(i9));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(a aVar) {
        this.f9397e = aVar;
    }

    public void a(C0124b c0124b) {
        this.f9396d = c0124b;
    }
}

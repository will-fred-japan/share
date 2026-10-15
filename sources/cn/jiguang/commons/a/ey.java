package cn.jiguang.commons.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10011a = e.f9935n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10012b = e.f9936o;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ThreadLocal<Boolean> f10013o = new ThreadLocal<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final HashMap<Integer, String> f10014r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f10015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f10016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedQueue<fd> f10017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f10018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<HashMap<String, HashMap<String, Integer>>> f10019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicLong f10020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f10021i;
    private volatile ScheduledFuture<?> j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f10022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f10023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicInteger f10024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicInteger f10025n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Runnable f10026p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Runnable f10027q;

    static {
        HashMap<Integer, String> map = new HashMap<>();
        f10014r = map;
        map.put(Integer.valueOf(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH), "11");
        map.put(1500, "6");
        map.put(1502, "7");
        map.put(1505, "9");
        map.put(1501, "8");
        map.put(1614, "14");
        map.put(1104, "18");
        map.put(1112, "19");
    }

    private ey() {
        this.f10016d = new AtomicBoolean(true);
        this.f10017e = new ConcurrentLinkedQueue<>();
        this.f10018f = new AtomicInteger(0);
        this.f10019g = new AtomicReference<>();
        this.f10020h = new AtomicLong(0L);
        this.f10021i = new AtomicInteger(0);
        this.f10022k = new Object();
        this.f10023l = new AtomicBoolean(false);
        this.f10024m = new AtomicInteger(0);
        this.f10025n = new AtomicInteger(0);
        this.f10026p = new ez(this);
        this.f10027q = new fa(this);
        this.f10015c = jg.a();
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                Iterator<String> itKeys = jSONObject.keys();
                boolean z8 = true;
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!z8) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    z8 = false;
                    int iOptInt = jSONObject.optInt(next, 0);
                    sb.append(next);
                    sb.append(BundleUtil.UNDERLINE_TAG);
                    sb.append(iOptInt);
                }
                return sb.toString();
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("convert stats err: "), "JEXS");
            }
        }
        return "";
    }

    public static ey b() {
        return fc.f10037a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this.f10022k) {
            try {
                if ((this.j == null || this.j.isDone()) && !this.f10023l.get()) {
                    this.j = fe.a().a(new fb(this), 100L, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private HashMap<String, HashMap<String, Integer>> k() {
        HashMap<String, HashMap<String, Integer>> map = this.f10019g.get();
        if (map != null) {
            return map;
        }
        try {
            JSONObject jSONObjectC = jq.c(f10011a);
            if (jSONObjectC == null) {
                jSONObjectC = new JSONObject();
            }
            HashMap<String, HashMap<String, Integer>> mapB = b(jSONObjectC);
            this.f10019g.set(mapB);
            return mapB;
        } catch (Throwable th) {
            ee.d("JEXS", "get cache err: " + th.getMessage());
            HashMap<String, HashMap<String, Integer>> map2 = new HashMap<>();
            this.f10019g.set(map2);
            return map2;
        }
    }

    public final void d() {
        if (!this.f10016d.get()) {
            ee.a("JEXS", "stats disabled, skip report");
            return;
        }
        boolean zI = i();
        boolean zJ = j();
        if (zI || zJ) {
            ee.a("JEXS", "start report");
            fe.a().a(this.f10027q, fl.NETWORK);
        }
    }

    public final void i(Object obj) {
        a(String.valueOf(obj), "19");
    }

    public final void j(Object obj) {
        a(String.valueOf(obj), "10");
    }

    public final void l(Object obj) {
        a(String.valueOf(obj), "16");
    }

    public final void m(Object obj) {
        a(String.valueOf(obj), "17");
    }

    public final void n(Object obj) {
        a(String.valueOf(obj), "20");
    }

    public /* synthetic */ ey(byte b9) {
        this();
    }

    private static HashMap<String, HashMap<String, Integer>> b(JSONObject jSONObject) {
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        if (jSONObject != null) {
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                if (jSONArrayOptJSONArray != null) {
                    for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i9);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString(JThirdPlatFormInterface.EXCEPTION_TYPE);
                            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("stats");
                            if (!TextUtils.isEmpty(strOptString) && jSONObjectOptJSONObject2 != null) {
                                HashMap<String, Integer> map2 = new HashMap<>();
                                Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    map2.put(next, Integer.valueOf(jSONObjectOptJSONObject2.optInt(next, 0)));
                                }
                                map.put(strOptString, map2);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("extract data map err: "), "JEXS");
            }
        }
        return map;
    }

    public static void c() {
        f10013o.remove();
    }

    private static boolean i() {
        try {
            aa aaVarA = bl.e().a(3101);
            if (aaVarA == null) {
                return false;
            }
            return Math.abs(System.currentTimeMillis() - AbstractC0552a.d("JEXS")) >= aaVarA.d();
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("check report interval err: "), "JEXS");
            return false;
        }
    }

    private boolean j() {
        try {
            File file = new File(this.f10015c.getFilesDir(), f10011a);
            if (!file.exists() || file.length() <= 524288) {
                return false;
            }
            ee.d("JEXS", "data too large: " + file.length() + " bytes, force report");
            return true;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("check file size err: "), "JEXS");
            return false;
        }
    }

    public final void g(Object obj) {
        a(String.valueOf(obj), "14");
    }

    public final void h(Object obj) {
        a(String.valueOf(obj), "18");
    }

    public final void k(Object obj) {
        a(String.valueOf(obj), "15");
    }

    private static boolean g() {
        Boolean bool = f10013o.get();
        return bool != null && bool.booleanValue();
    }

    public final void c(Object obj) {
        a(String.valueOf(obj), "6");
    }

    public final void d(Object obj) {
        a(String.valueOf(obj), g() ? "16" : "8");
    }

    public final void e(Object obj) {
        a(String.valueOf(obj), g() ? "15" : "9");
    }

    public final void f(Object obj) {
        a(String.valueOf(obj), "11");
    }

    public static /* synthetic */ ScheduledFuture a(ey eyVar, ScheduledFuture scheduledFuture) {
        eyVar.j = null;
        return null;
    }

    private static JSONObject a(HashMap<String, HashMap<String, Integer>> map) {
        JSONObject jSONObject = new JSONObject();
        if (!map.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (Object obj : map.keySet()) {
                    HashMap<String, Integer> map2 = map.get(obj);
                    if (map2 != null && !map2.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(JThirdPlatFormInterface.EXCEPTION_TYPE, obj);
                        JSONObject jSONObject3 = new JSONObject();
                        for (String str : map2.keySet()) {
                            Integer num = map2.get(str);
                            if (num != null && num.intValue() > 0) {
                                jSONObject3.put(str, num);
                            }
                        }
                        jSONObject2.put("stats", jSONObject3);
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("data", jSONArray);
                return jSONObject;
            } catch (Throwable th) {
                defpackage.f.n(th, new StringBuilder("convert map to json err: "), "JEXS");
            }
        }
        return jSONObject;
    }

    public final void b(Object obj) {
        a(String.valueOf(obj), "7");
    }

    public final void a() {
        try {
            this.f10016d.set(bl.e().a(3101) != null);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("update switch err: "), "JEXS");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i9) {
        if (this.f10023l.compareAndSet(false, true)) {
            synchronized (this.f10022k) {
                try {
                    if (this.j != null && !this.j.isDone()) {
                        this.j.cancel(false);
                        this.j = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            fe.a().a(this.f10026p, fl.DEVICE_INFO);
            ee.a("JEXS", "trigger save, qsize:" + i9);
        }
    }

    public final void a(int i9, int i10) {
        HashMap<Integer, String> map = f10014r;
        if (map.containsKey(Integer.valueOf(i9))) {
            a(String.valueOf(i10), map.get(Integer.valueOf(i9)));
        }
    }

    private void a(long j) {
        this.f10021i.set(0);
        this.f10020h.set(j);
    }

    public static /* synthetic */ void a(ey eyVar, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            HashMap<String, HashMap<String, Integer>> mapK = eyVar.k();
            HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
            for (String str : mapK.keySet()) {
                HashMap<String, Integer> map2 = mapK.get(str);
                if (map2 != null && !map2.isEmpty()) {
                    map.put(str, new HashMap<>(map2));
                }
            }
            Iterator it = list.iterator();
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (it.hasNext()) {
                fd fdVar = (fd) it.next();
                if (fdVar != null) {
                    String str2 = fdVar.f10038a;
                    String str3 = fdVar.f10039b;
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                        i10++;
                        HashMap<String, Integer> map3 = map.get(str3);
                        if (map3 == null) {
                            map3 = new HashMap<>();
                            map.put(str3, map3);
                        }
                        Integer num = map3.get(str2);
                        map3.put(str2, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                    }
                }
                i11++;
            }
            if (i10 == 0) {
                return;
            }
            JSONObject jSONObjectA = a(map);
            int size = list.size();
            HashMap map4 = new HashMap();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                fd fdVar2 = (fd) it2.next();
                if (fdVar2 != null && !TextUtils.isEmpty(fdVar2.f10039b)) {
                    Integer num2 = (Integer) map4.get(fdVar2.f10039b);
                    map4.put(fdVar2.f10039b, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                }
            }
            if (jq.a(f10011a, jSONObjectA)) {
                eyVar.f10019g.set(map);
                String str4 = "save ok, poll:" + size + ", valid:" + i10;
                if (i11 > 0) {
                    str4 = str4 + ", invalid:" + i11;
                }
                ee.a("JEXS", str4 + ", final size:" + map.size());
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                fd fdVar3 = (fd) it3.next();
                if (fdVar3 != null && !TextUtils.isEmpty(fdVar3.f10039b) && !TextUtils.isEmpty(fdVar3.f10038a) && eyVar.f10017e.offer(fdVar3)) {
                    i9++;
                    eyVar.f10018f.incrementAndGet();
                }
            }
            String str5 = "save failed, poll:" + size + ", valid:" + i10;
            if (i11 > 0) {
                str5 = str5 + ", invalid:" + i11;
            }
            String str6 = str5 + ", requeued:" + i9;
            if (i9 < i10) {
                str6 = str6 + ", requeue failed:" + (i10 - i9);
            }
            ee.d("JEXS", str6);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("process data err: "), "JEXS");
        }
    }

    public static /* synthetic */ void a(ey eyVar, JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray != null) {
            for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                try {
                    JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i9);
                    if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("stats")) != null && jSONObjectOptJSONObject.length() > 0) {
                        jSONObjectOptJSONObject2.put("result", a(jSONObjectOptJSONObject));
                        jSONObjectOptJSONObject2.remove("stats");
                    }
                } catch (Throwable th) {
                    defpackage.f.n(th, new StringBuilder("convert result err: "), "JEXS");
                    return;
                }
            }
        }
    }

    public final void a(Object obj) {
        a(String.valueOf(obj), "4");
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            if (!this.f10016d.get()) {
                ee.a("JEXS", "stats disabled");
                return;
            }
            if (!this.f10017e.offer(new fd(str, str2))) {
                ee.d("JEXS", "queue offer failed, dropped:" + this.f10024m.incrementAndGet());
                return;
            }
            int iIncrementAndGet = this.f10018f.incrementAndGet();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.f10020h.get();
            int iIncrementAndGet2 = this.f10021i.incrementAndGet();
            if (iIncrementAndGet >= 1000) {
                int i9 = this.f10025n.get();
                if ((iIncrementAndGet == 1000 || (iIncrementAndGet % 5000 == 0 && iIncrementAndGet != i9)) && this.f10025n.compareAndSet(i9, iIncrementAndGet)) {
                    ee.d("JEXS", "queue full, size: " + iIncrementAndGet + ", trigger save");
                }
                a(iIncrementAndGet);
            } else {
                if (iIncrementAndGet < 5 && iIncrementAndGet2 < 30 && j < 1000) {
                    h();
                    return;
                }
                a(iIncrementAndGet);
            }
            a(jCurrentTimeMillis);
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("save data err: "), "JEXS");
        }
    }

    public static void a(boolean z8) {
        f10013o.set(Boolean.TRUE);
    }
}

package cn.jiguang.at;

import W5.e;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.aw.d;
import cn.jiguang.aw.j;
import cn.jiguang.aw.m;
import cn.jiguang.e.f;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.service.WakedResultReceiver;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Bundle f9420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f9421b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static HashMap<Integer, String> f9422i = new HashMap<>();
    private static List<String> j = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f9423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f9424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f9425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConcurrentLinkedQueue<Bundle> f9426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f9427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f9428h;

    /* JADX INFO: renamed from: cn.jiguang.at.a$a, reason: collision with other inner class name */
    public static final class C0125a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f9432a = new a();
    }

    private a() {
        this.f9424d = new AtomicBoolean(true);
        this.f9425e = new AtomicBoolean(false);
        this.f9426f = new ConcurrentLinkedQueue<>();
        this.f9427g = new AtomicInteger(0);
        this.f9428h = new Runnable() { // from class: cn.jiguang.at.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f9425e.get()) {
                    return;
                }
                a.this.c();
            }
        };
        Context contextA = d.a();
        this.f9423c = contextA;
        this.f9424d.set(((Boolean) f.a(contextA, cn.jiguang.e.d.Z())).booleanValue());
        cn.jiguang.x.f.c("ExceptionStatsManager", "default exception_switch=" + this.f9424d.get());
    }

    public static a a() {
        return C0125a.f9432a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<JSONArray> b(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                ArrayList<JSONArray> arrayList = new ArrayList<>();
                int i9 = 0;
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                        int length = jSONObjectOptJSONObject.toString().getBytes("UTF-8").length;
                        i9 += length;
                        if (i9 > 102400) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            jSONArray2 = new JSONArray();
                            jSONArray2.put(jSONObjectOptJSONObject);
                            i9 = length;
                        } else {
                            jSONArray2.put(jSONObjectOptJSONObject);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    arrayList.add(jSONArray2);
                }
                return arrayList;
            } catch (UnsupportedEncodingException e9) {
                cn.jiguang.x.f.i("ExceptionStatsManager", "partition exception:" + e9.getMessage());
            } catch (Throwable th) {
                e.t(th, new StringBuilder("partition throwable:"), "ExceptionStatsManager");
            }
        }
        return null;
    }

    private Bundle c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString(JThirdPlatFormInterface.KEY_EXTRA, bundle.getString(JThirdPlatFormInterface.KEY_EXTRA));
        bundle2.putString(JThirdPlatFormInterface.EXCEPTION_TYPE, bundle.getString(JThirdPlatFormInterface.EXCEPTION_TYPE));
        bundle2.putString("code", bundle.getString("code"));
        return bundle2;
    }

    private void d(Bundle bundle) {
        f9420a = c(bundle);
        f9421b = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        cn.jiguang.av.d.a("FUTURE_TASK", new cn.jiguang.av.b() { // from class: cn.jiguang.at.a.2
            @Override // cn.jiguang.av.b
            public void a() {
                a.this.f9425e.set(true);
                try {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        Bundle bundle = (Bundle) a.this.f9426f.poll();
                        if (bundle == null) {
                            break;
                        }
                        arrayList.add(bundle);
                        a.this.f9427g.decrementAndGet();
                    }
                    if (!arrayList.isEmpty()) {
                        a.this.a(arrayList);
                    }
                } finally {
                    a.this.f9425e.set(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return Math.abs(System.currentTimeMillis() - ((Long) f.a(this.f9423c, cn.jiguang.e.d.ao())).longValue()) >= 3600000;
    }

    private JSONObject a(JSONObject jSONObject, Bundle bundle) {
        JSONObject jSONObject2;
        String string;
        if (jSONObject == null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (Throwable unused) {
                return jSONObject;
            }
        } else {
            jSONObject2 = jSONObject;
        }
        try {
            if (TextUtils.isEmpty(bundle.getString("code"))) {
                return jSONObject2;
            }
            String string2 = bundle.getString("code");
            if (jSONObject2.has("result")) {
                String[] strArrSplit = jSONObject2.optString("result").split(ContainerUtils.FIELD_DELIMITER);
                StringBuilder sb = new StringBuilder();
                boolean z8 = false;
                for (int i9 = 0; i9 < strArrSplit.length; i9++) {
                    String[] strArrSplit2 = strArrSplit[i9].split(BundleUtil.UNDERLINE_TAG);
                    String str = strArrSplit2[0];
                    int iIntValue = Integer.valueOf(strArrSplit2[1]).intValue();
                    sb.append(str);
                    sb.append(BundleUtil.UNDERLINE_TAG);
                    if (string2.equals(str)) {
                        sb.append(iIntValue + 1);
                        z8 = true;
                    } else {
                        sb.append(iIntValue);
                    }
                    if (i9 != strArrSplit.length - 1) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                }
                if (!z8) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    sb.append(string2);
                    sb.append("_1");
                }
                string = sb.toString();
            } else {
                string = string2 + "_1";
            }
            jSONObject2.put("result", string);
            jSONObject2.put(JThirdPlatFormInterface.EXCEPTION_TYPE, bundle.getString(JThirdPlatFormInterface.EXCEPTION_TYPE));
            jSONObject2.put(JThirdPlatFormInterface.KEY_EXTRA, new JSONObject(bundle.getString(JThirdPlatFormInterface.KEY_EXTRA)));
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    public void a(int i9) {
        a(i9 + "", WakedResultReceiver.WAKE_TYPE_KEY);
    }

    public void a(Bundle bundle) {
        m mVarA;
        Runnable runnable;
        long j8;
        if (this.f9424d.get() && bundle != null && this.f9426f.offer(bundle)) {
            if (this.f9427g.incrementAndGet() >= 50) {
                mVarA = m.a();
                runnable = this.f9428h;
                j8 = 0;
            } else {
                mVarA = m.a();
                runnable = this.f9428h;
                j8 = 500;
            }
            mVarA.a("exception_stats_save", runnable, j8);
        }
    }

    public void b() {
        boolean z8 = this.f9424d.get();
        cn.jiguang.x.f.c("ExceptionStatsManager", "startReport exception_switch=" + z8);
        if (z8) {
            cn.jiguang.av.d.a("DELAY_TASK", new cn.jiguang.av.b() { // from class: cn.jiguang.at.a.3
                @Override // cn.jiguang.av.b
                public void a() {
                    String str;
                    try {
                        if (a.this.f9423c == null) {
                            str = "context is null,return";
                        } else if (a.this.d()) {
                            j.c("e_s.catch", "e_s.temp");
                            j.d("e_s.catch");
                            cn.jiguang.x.f.c("ExceptionStatsManager", "start to  report");
                            JSONObject jSONObjectA = j.a("e_s.temp");
                            cn.jiguang.x.f.c("ExceptionStatsManager", "local cache=" + jSONObjectA);
                            if (jSONObjectA == null) {
                                jSONObjectA = new JSONObject();
                            }
                            JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("data");
                            if (jSONArrayOptJSONArray == null) {
                                jSONArrayOptJSONArray = new JSONArray();
                            }
                            if (jSONArrayOptJSONArray.length() != 0) {
                                ArrayList arrayListB = a.b(jSONArrayOptJSONArray);
                                if (arrayListB != null && !arrayListB.isEmpty()) {
                                    int size = arrayListB.size();
                                    int i9 = 0;
                                    while (i9 < size) {
                                        JSONObject jSONObject = new JSONObject();
                                        JSONArray jSONArray = (JSONArray) arrayListB.get(i9);
                                        i9++;
                                        jSONObject.put("slice_index", i9);
                                        jSONObject.put("slice_count", size);
                                        jSONObject.put("data", jSONArray);
                                        jSONObject.put("sequence", UUID.randomUUID().toString());
                                        cn.jiguang.aa.b.a(a.this.f9423c, jSONObject, "exception_stats");
                                    }
                                    f.a(a.this.f9423c, (cn.jiguang.e.d<?>[]) new cn.jiguang.e.d[]{cn.jiguang.e.d.ao().a(Long.valueOf(System.currentTimeMillis()))});
                                    j.d("e_s.temp");
                                    return;
                                }
                                return;
                            }
                            str = " report content is  null";
                        } else {
                            str = "no report";
                        }
                        cn.jiguang.x.f.c("ExceptionStatsManager", str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void a(String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("code", str);
            bundle.putString(JThirdPlatFormInterface.EXCEPTION_TYPE, str2);
            a(bundle);
        } catch (Throwable unused) {
        }
    }

    public void b(int i9) {
        a(i9 + "", "3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Bundle> list) {
        JSONObject jSONObjectA;
        if (this.f9423c == null || list == null || list.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObjectA2 = j.a("e_s.catch");
            if (jSONObjectA2 == null) {
                jSONObjectA2 = new JSONObject();
            }
            for (Bundle bundle : list) {
                if (bundle != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectA2.optJSONArray("data");
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    String string = bundle.getString(JThirdPlatFormInterface.EXCEPTION_TYPE);
                    if (!TextUtils.isEmpty(string) && (!string.equals("1") || !b(bundle))) {
                        int i9 = 0;
                        while (true) {
                            if (i9 >= jSONArrayOptJSONArray.length()) {
                                jSONObjectA = a((JSONObject) null, bundle);
                                break;
                            }
                            JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i9);
                            if (jSONObject != null) {
                                String strOptString = jSONObject.optString(JThirdPlatFormInterface.EXCEPTION_TYPE);
                                if (!TextUtils.isEmpty(strOptString) && strOptString.equals(string)) {
                                    if ("1".equals(string) && jSONObject.has(JThirdPlatFormInterface.KEY_EXTRA)) {
                                        String string2 = bundle.getString(JThirdPlatFormInterface.KEY_EXTRA);
                                        String string3 = jSONObject.getString(JThirdPlatFormInterface.KEY_EXTRA);
                                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && string3.equals(string2)) {
                                            jSONObjectA = a(jSONObject, bundle);
                                        }
                                    } else {
                                        jSONObjectA = a(jSONObject, bundle);
                                    }
                                    jSONArrayOptJSONArray.remove(i9);
                                    break;
                                }
                            }
                            i9++;
                        }
                        jSONArrayOptJSONArray.put(jSONObjectA);
                        jSONObjectA2.put("data", jSONArrayOptJSONArray);
                    }
                }
            }
            j.a("e_s.catch", jSONObjectA2);
            cn.jiguang.x.f.c("ExceptionStatsManager", "saveData success, cache=" + jSONObjectA2);
        } catch (Throwable unused) {
        }
    }

    private boolean b(Bundle bundle) {
        if (f9420a == null) {
            d(bundle);
            return false;
        }
        Bundle bundleC = c(bundle);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (a(f9420a, bundleC) && jCurrentTimeMillis - f9421b < 300) {
            return true;
        }
        d(bundle);
        return false;
    }

    public void a(boolean z8) {
        this.f9424d.set(z8);
        cn.jiguang.x.f.c("ExceptionStatsManager", "updateSwitchState exception_switch=" + this.f9424d.get() + " origin switchState=" + z8);
    }

    private boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null || bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!(obj2 instanceof Bundle) || !a((Bundle) obj, (Bundle) obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }
}

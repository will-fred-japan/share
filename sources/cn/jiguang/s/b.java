package cn.jiguang.s;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.v.g;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10766i;
    private Map<String, Integer> j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f10767k;

    public b() {
    }

    public int a() {
        return this.f10759b;
    }

    public boolean b() {
        Context context;
        if (TextUtils.isEmpty(this.f10767k) || (context = this.f10758a) == null) {
            return false;
        }
        return !this.f10767k.equals(context.getPackageName());
    }

    public void c() {
        this.f10764g++;
    }

    public void d() {
        this.f10765h++;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cl", this.f10760c);
            jSONObject.put("type", this.f10759b);
            jSONObject.put("p_ver", this.f10762e);
            jSONObject.put("plugin_id", this.f10761d);
            jSONObject.put("l_ver", this.f10763f);
            jSONObject.put("cnt_start", this.f10764g);
            jSONObject.put("cnt_suc", this.f10765h);
            jSONObject.put("cnt_fai", this.f10766i);
            jSONObject.put("process_name", this.f10767k);
            Set<Map.Entry<String, Integer>> setEntrySet = this.j.entrySet();
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : setEntrySet) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error_msg", entry.getKey());
                jSONObject2.put(MTPushConstants.Geofence.KEY_COUNT, entry.getValue());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("msg", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (a() != bVar.a() || this.f10762e != bVar.f10762e || this.f10761d != bVar.f10761d || this.f10763f != bVar.f10763f) {
                return false;
            }
            String str = this.f10760c;
            if (str == null ? bVar.f10760c != null : !str.equals(bVar.f10760c)) {
                return false;
            }
            String str2 = this.f10767k;
            String str3 = bVar.f10767k;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f10767k;
    }

    public b(Context context, a aVar, int i9, int i10) {
        if (aVar != null) {
            this.f10759b = aVar.f10756k;
            this.f10760c = aVar.f10757l;
        }
        this.f10758a = context;
        a(i9, i10);
        this.j = new HashMap();
        this.f10767k = g.a(context);
    }

    public void a(int i9, int i10) {
        this.f10761d = i9;
        this.f10762e = i10;
        String strA = cn.jiguang.r.a.a(i9, 4);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            this.f10763f = Integer.parseInt(strA);
        } catch (Throwable unused) {
        }
    }

    public void a(b bVar) {
        if (equals(bVar)) {
            this.f10764g += bVar.f10764g;
            this.f10765h += bVar.f10765h;
            this.f10766i += bVar.f10766i;
            for (String str : bVar.j.keySet()) {
                if (this.j.containsKey(str)) {
                    Integer num = this.j.get(str);
                    Integer num2 = bVar.j.get(str);
                    if (num != null && num2 != null) {
                        this.j.put(str, Integer.valueOf(num2.intValue() + num.intValue()));
                    }
                } else {
                    Integer num3 = bVar.j.get(str);
                    if (num3 != null) {
                        this.j.put(str, num3);
                    }
                }
            }
        }
    }

    public void a(String str) {
        this.f10766i++;
        Integer num = this.j.get(str);
        if (num == null) {
            this.j.put(str, 0);
        } else {
            this.j.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f10759b = jSONObject.optInt("type");
        this.f10760c = jSONObject.optString("cl");
        this.f10762e = jSONObject.optInt("p_ver");
        this.f10761d = jSONObject.optInt("plugin_id");
        this.f10763f = jSONObject.optInt("l_ver");
        this.f10764g = jSONObject.optInt("cnt_start");
        this.f10765h = jSONObject.optInt("cnt_suc");
        this.f10766i = jSONObject.optInt("cnt_fai");
        this.f10767k = jSONObject.optString("process_name");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("msg");
        this.j = new HashMap();
        for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i9);
            if (jSONObjectOptJSONObject != null) {
                this.j.put(jSONObjectOptJSONObject.optString("error_msg"), Integer.valueOf(jSONObjectOptJSONObject.optInt(MTPushConstants.Geofence.KEY_COUNT)));
            }
        }
    }
}

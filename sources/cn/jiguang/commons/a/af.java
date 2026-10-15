package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class af implements Parcelable {
    public static final Parcelable.Creator<af> CREATOR = new ag();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f9646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private r f9647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private t f9648i;
    private int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f9651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9653o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f9654p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9655q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f9656r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f9657s;
    private int t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List<Integer> f9658u;

    public af() {
        this.f9642c = "";
        this.f9643d = "";
        this.f9650l = Integer.MIN_VALUE;
        this.f9651m = "";
        this.f9653o = -1;
        this.f9654p = -1;
        this.f9655q = -1;
        this.f9656r = "";
        this.f9657s = "";
        this.t = -1;
        this.f9646g = new ArrayList();
        this.f9658u = new ArrayList();
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("src", this.j);
        jSONObject.put("type", this.f9640a);
        jSONObject.put("class", this.f9641b);
        Object obj = this.f9642c;
        if (obj == null) {
            obj = "";
        }
        jSONObject.put("address", obj);
        Object obj2 = this.f9643d;
        jSONObject.put(MTCommonConstants.Network.KEY_NAME, obj2 != null ? obj2 : "");
        jSONObject.put("b_state", this.f9644e);
        jSONObject.put("rssi", this.f9645f);
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f9646g;
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
        }
        jSONObject.put("uuids", jSONArray);
        int i9 = this.f9649k;
        if (i9 > 0) {
            jSONObject.put("ble_type", i9);
        }
        int i10 = this.f9650l;
        if (i10 != Integer.MIN_VALUE) {
            jSONObject.put("tx_pow", i10);
        }
        if (!TextUtils.isEmpty(this.f9651m)) {
            jSONObject.put(MTPushConstants.Operation.KEY_ALIAS, this.f9651m);
        }
        int i11 = this.f9652n;
        if (i11 != 0) {
            jSONObject.put("gap_a", i11);
        }
        int i12 = this.f9653o;
        if (i12 >= 0) {
            jSONObject.put("is_leg", i12);
        }
        int i13 = this.f9654p;
        if (i13 >= 0) {
            jSONObject.put("pa_intv", i13);
        }
        int i14 = this.f9655q;
        if (i14 >= 0) {
            jSONObject.put("d_stat", i14);
        }
        if (!TextUtils.isEmpty(this.f9656r) && !"255".equals(this.f9656r) && !"-1".equals(this.f9656r)) {
            jSONObject.put("adv_sid", this.f9656r);
        }
        if (!TextUtils.isEmpty(this.f9657s)) {
            jSONObject.put("mfg_d", this.f9657s);
        }
        int i15 = this.t;
        if (i15 > 0) {
            jSONObject.put("conn_st", i15);
        }
        List<Integer> list2 = this.f9658u;
        if (list2 != null && !list2.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<Integer> it = this.f9658u.iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next());
            }
            jSONObject.put("svc_caps", jSONArray2);
        }
        r rVar = this.f9647h;
        if (rVar != null) {
            jSONObject.put("edd", rVar.a());
        }
        t tVar = this.f9648i;
        if (tVar != null) {
            jSONObject.put("iBe", tVar.a());
        }
        return jSONObject;
    }

    public final int b() {
        return this.f9640a;
    }

    public final int c() {
        return this.f9641b;
    }

    public final String d() {
        return this.f9643d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f9644e;
    }

    public final int f() {
        return this.f9645f;
    }

    public final List<String> g() {
        return this.f9646g;
    }

    public final r h() {
        return this.f9647h;
    }

    public final t i() {
        return this.f9648i;
    }

    public final int j() {
        return this.f9649k;
    }

    public final int k() {
        return this.f9650l;
    }

    public final String l() {
        return this.f9651m;
    }

    public final int m() {
        return this.f9652n;
    }

    public final int n() {
        return this.f9653o;
    }

    public final int o() {
        return this.f9654p;
    }

    public final int p() {
        return this.f9655q;
    }

    public final String q() {
        return this.f9656r;
    }

    public final String r() {
        return this.f9657s;
    }

    public final int s() {
        return this.t;
    }

    public final List<Integer> t() {
        return this.f9658u;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeInt(this.f9640a);
        parcel.writeInt(this.f9641b);
        parcel.writeString(this.f9642c);
        parcel.writeString(this.f9643d);
        parcel.writeInt(this.f9644e);
        parcel.writeInt(this.f9645f);
        parcel.writeStringList(this.f9646g);
        parcel.writeParcelable(this.f9647h, i9);
        parcel.writeParcelable(this.f9648i, i9);
        parcel.writeInt(this.j);
        parcel.writeInt(this.f9649k);
        parcel.writeInt(this.f9650l);
        parcel.writeString(this.f9651m);
        parcel.writeInt(this.f9652n);
        parcel.writeInt(this.f9653o);
        parcel.writeInt(this.f9654p);
        parcel.writeInt(this.f9655q);
        parcel.writeString(this.f9656r);
        parcel.writeString(this.f9657s);
        parcel.writeInt(this.t);
        parcel.writeList(this.f9658u);
    }

    public af(Parcel parcel) {
        this.f9642c = "";
        this.f9643d = "";
        this.f9650l = Integer.MIN_VALUE;
        this.f9651m = "";
        this.f9653o = -1;
        this.f9654p = -1;
        this.f9655q = -1;
        this.f9656r = "";
        this.f9657s = "";
        this.t = -1;
        this.f9640a = parcel.readInt();
        this.f9641b = parcel.readInt();
        this.f9642c = parcel.readString();
        this.f9643d = parcel.readString();
        this.f9644e = parcel.readInt();
        this.f9645f = parcel.readInt();
        this.f9646g = parcel.createStringArrayList();
        this.f9647h = (r) parcel.readParcelable(r.class.getClassLoader());
        this.f9648i = (t) parcel.readParcelable(t.class.getClassLoader());
        this.j = parcel.readInt();
        this.f9649k = parcel.readInt();
        this.f9650l = parcel.readInt();
        this.f9651m = parcel.readString();
        this.f9652n = parcel.readInt();
        this.f9653o = parcel.readInt();
        this.f9654p = parcel.readInt();
        this.f9655q = parcel.readInt();
        this.f9656r = parcel.readString();
        this.f9657s = parcel.readString();
        this.t = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f9658u = arrayList;
        parcel.readList(arrayList, Integer.class.getClassLoader());
    }

    public final void a(int i9) {
        this.f9640a = i9;
    }

    public final void b(int i9) {
        this.f9641b = i9;
    }

    public final void c(int i9) {
        this.f9644e = i9;
    }

    public final void d(int i9) {
        this.f9645f = i9;
    }

    public final void e(int i9) {
        this.j = i9;
    }

    public final void f(int i9) {
        this.f9649k = i9;
    }

    public final void g(int i9) {
        this.f9650l = i9;
    }

    public final void h(int i9) {
        this.f9652n = i9;
    }

    public final void i(int i9) {
        this.f9653o = i9;
    }

    public final void j(int i9) {
        this.f9654p = i9;
    }

    public final void k(int i9) {
        this.f9655q = i9;
    }

    public final void l(int i9) {
        this.t = i9;
    }

    public final void a(r rVar) {
        this.f9647h = rVar;
    }

    public final void b(String str) {
        if (str == null) {
            str = "";
        }
        this.f9643d = str;
    }

    public final void c(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f9646g.add(str);
    }

    public final void d(String str) {
        if (str == null) {
            str = "";
        }
        this.f9651m = str;
    }

    public final void e(String str) {
        if (str == null) {
            str = "";
        }
        this.f9656r = str;
    }

    public final void f(String str) {
        if (str == null) {
            str = "";
        }
        this.f9657s = str;
    }

    public final void a(t tVar) {
        this.f9648i = tVar;
    }

    public final void a(String str) {
        if (str == null) {
            str = "";
        }
        this.f9642c = str;
    }

    public final void a(List<Integer> list) {
        this.f9658u = list;
    }
}

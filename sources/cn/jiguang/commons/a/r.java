package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Integer> f10401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f10403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10406i;
    private int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f10408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List<String> f10409m;

    public r() {
        this.f10398a = "";
        this.f10399b = -1;
        this.f10400c = "";
        this.f10402e = "";
        this.f10404g = Integer.MIN_VALUE;
        this.f10401d = new ArrayList();
        this.f10403f = new ArrayList();
        this.f10408l = new ArrayList();
        this.f10409m = new ArrayList();
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int i9 = this.f10399b;
        if (i9 >= 0) {
            jSONObject.put("adv_f", i9);
        }
        String str = this.f10400c;
        if (str != null && !str.isEmpty()) {
            jSONObject.put(MTCommonConstants.Network.KEY_NAME, this.f10400c);
        }
        List<Integer> list = this.f10401d;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = this.f10401d.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("man_id", jSONArray);
        }
        String str2 = this.f10402e;
        if (str2 != null && !str2.isEmpty()) {
            jSONObject.put("s_data", this.f10402e);
        }
        List<String> list2 = this.f10403f;
        if (list2 != null && !list2.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.f10403f.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("s_uuids", jSONArray2);
        }
        int i10 = this.f10404g;
        if (i10 != Integer.MIN_VALUE) {
            jSONObject.put("tpl", i10);
        }
        int i11 = this.f10406i;
        if (i11 > 0) {
            jSONObject.put("pphy", i11);
        }
        int i12 = this.j;
        if (i12 > 0) {
            jSONObject.put("sphy", i12);
        }
        jSONObject.put("isC", this.f10407k);
        List<String> list3 = this.f10408l;
        if (list3 != null && !list3.isEmpty()) {
            JSONArray jSONArray3 = new JSONArray();
            Iterator<String> it3 = this.f10408l.iterator();
            while (it3.hasNext()) {
                jSONArray3.put(it3.next());
            }
            jSONObject.put("o_uuids_k", jSONArray3);
        }
        List<String> list4 = this.f10409m;
        if (list4 != null && !list4.isEmpty()) {
            JSONArray jSONArray4 = new JSONArray();
            Iterator<String> it4 = this.f10409m.iterator();
            while (it4.hasNext()) {
                jSONArray4.put(it4.next());
            }
            jSONObject.put("s_uuids_k", jSONArray4);
        }
        return jSONObject;
    }

    public final int b() {
        return this.f10399b;
    }

    public final String c() {
        return this.f10400c;
    }

    public final List<Integer> d() {
        return this.f10401d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f10402e;
    }

    public final List<String> f() {
        return this.f10403f;
    }

    public final int g() {
        return this.f10404g;
    }

    public final int h() {
        return this.f10406i;
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.f10407k;
    }

    public final List<String> k() {
        return this.f10408l;
    }

    public final List<String> l() {
        return this.f10409m;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f10398a);
        parcel.writeInt(this.f10399b);
        parcel.writeString(this.f10400c);
        parcel.writeList(this.f10401d);
        parcel.writeString(this.f10402e);
        parcel.writeStringList(this.f10403f);
        parcel.writeInt(this.f10404g);
        parcel.writeInt(this.f10405h);
        parcel.writeInt(this.f10406i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.f10407k);
        parcel.writeStringList(this.f10408l);
        parcel.writeStringList(this.f10409m);
    }

    public r(Parcel parcel) {
        this.f10398a = "";
        this.f10399b = -1;
        this.f10400c = "";
        this.f10402e = "";
        this.f10404g = Integer.MIN_VALUE;
        this.f10398a = parcel.readString();
        this.f10399b = parcel.readInt();
        this.f10400c = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.f10401d = arrayList;
        parcel.readList(arrayList, Integer.class.getClassLoader());
        this.f10402e = parcel.readString();
        this.f10403f = parcel.createStringArrayList();
        this.f10404g = parcel.readInt();
        this.f10405h = parcel.readInt();
        this.f10406i = parcel.readInt();
        this.j = parcel.readInt();
        this.f10407k = parcel.readInt();
        this.f10408l = parcel.createStringArrayList();
        this.f10409m = parcel.createStringArrayList();
    }

    public final void a(int i9) {
        this.f10399b = i9;
    }

    public final void b(int i9) {
        this.f10404g = i9;
    }

    public final void c(int i9) {
        this.f10406i = i9;
    }

    public final void d(int i9) {
        this.j = i9;
    }

    public final void e(int i9) {
        this.f10407k = i9;
    }

    public final void a(String str) {
        if (str == null) {
            str = "";
        }
        this.f10400c = str;
    }

    public final void b(String str) {
        if (str == null) {
            str = "";
        }
        this.f10402e = str;
    }

    public final void c(List<String> list) {
        this.f10409m = list;
    }

    public final void a(List<Integer> list) {
        this.f10401d = list;
    }

    public final void b(List<String> list) {
        this.f10403f = list;
    }
}

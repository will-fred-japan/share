package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.constants.MTCommonConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<af> f10348i;

    public k() {
        this.f10340a = "";
        this.f10341b = "";
        this.f10344e = -1;
        this.f10345f = -1;
        this.f10346g = -1;
        this.f10347h = -1;
        this.f10348i = new ArrayList();
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Object obj = this.f10340a;
        if (obj == null) {
            obj = "";
        }
        jSONObject.put(MTCommonConstants.Network.KEY_NAME, obj);
        Object obj2 = this.f10341b;
        jSONObject.put("address", obj2 != null ? obj2 : "");
        jSONObject.put("scan_m", this.f10342c);
        jSONObject.put("state", this.f10343d);
        int i9 = this.f10344e;
        if (i9 >= 0) {
            jSONObject.put("le_2m", i9);
        }
        int i10 = this.f10345f;
        if (i10 >= 0) {
            jSONObject.put("le_coded", i10);
        }
        int i11 = this.f10346g;
        if (i11 >= 0) {
            jSONObject.put("le_ext_adv", i11);
        }
        int i12 = this.f10347h;
        if (i12 >= 0) {
            jSONObject.put("le_max_adv_len", i12);
        }
        JSONArray jSONArray = new JSONArray();
        List<af> list = this.f10348i;
        if (list != null) {
            for (af afVar : list) {
                if (afVar != null) {
                    JSONObject jSONObjectA = afVar.a();
                    if (jSONObjectA.length() > 0) {
                        jSONArray.put(jSONObjectA);
                    }
                }
            }
        }
        jSONObject.put("pls", jSONArray);
        return jSONObject;
    }

    public final void b(int i9) {
        this.f10343d = i9;
    }

    public final void c(int i9) {
        this.f10344e = i9;
    }

    public final void d(int i9) {
        this.f10345f = i9;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(int i9) {
        this.f10346g = i9;
    }

    public final void f(int i9) {
        this.f10347h = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f10340a);
        parcel.writeString(this.f10341b);
        parcel.writeInt(this.f10342c);
        parcel.writeInt(this.f10343d);
        parcel.writeInt(this.f10344e);
        parcel.writeInt(this.f10345f);
        parcel.writeInt(this.f10346g);
        parcel.writeInt(this.f10347h);
        parcel.writeTypedList(this.f10348i);
    }

    public k(Parcel parcel) {
        this.f10340a = "";
        this.f10341b = "";
        this.f10344e = -1;
        this.f10345f = -1;
        this.f10346g = -1;
        this.f10347h = -1;
        this.f10340a = parcel.readString();
        this.f10341b = parcel.readString();
        this.f10342c = parcel.readInt();
        this.f10343d = parcel.readInt();
        this.f10344e = parcel.readInt();
        this.f10345f = parcel.readInt();
        this.f10346g = parcel.readInt();
        this.f10347h = parcel.readInt();
        this.f10348i = parcel.createTypedArrayList(af.CREATOR);
    }

    public final void a(int i9) {
        this.f10342c = i9;
    }

    public final void b(String str) {
        if (str == null) {
            str = "";
        }
        this.f10341b = str;
    }

    public final void a(af afVar) {
        if (afVar != null) {
            this.f10348i.add(afVar);
        }
    }

    public final void a(String str) {
        if (str == null) {
            str = "";
        }
        this.f10340a = str;
    }
}

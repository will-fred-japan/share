package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Parcelable {
    public static final Parcelable.Creator<t> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10413d;

    public t() {
        this.f10410a = "";
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f10410a;
        if (str == null) {
            str = "";
        }
        jSONObject.put("pUuid", str);
        jSONObject.put("major", this.f10411b);
        jSONObject.put("minor", this.f10412c);
        jSONObject.put("mPo", this.f10413d);
        return jSONObject;
    }

    public final String b() {
        return this.f10410a;
    }

    public final int c() {
        return this.f10411b;
    }

    public final int d() {
        return this.f10412c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f10413d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f10410a);
        parcel.writeInt(this.f10411b);
        parcel.writeInt(this.f10412c);
        parcel.writeInt(this.f10413d);
    }

    public t(Parcel parcel) {
        this.f10410a = "";
        this.f10410a = parcel.readString();
        this.f10411b = parcel.readInt();
        this.f10412c = parcel.readInt();
        this.f10413d = parcel.readInt();
    }

    public final void a(int i9) {
        this.f10411b = i9;
    }

    public final void b(int i9) {
        this.f10412c = i9;
    }

    public final void c(int i9) {
        this.f10413d = i9;
    }

    public final void a(String str) {
        if (str == null) {
            str = "";
        }
        this.f10410a = str;
    }
}

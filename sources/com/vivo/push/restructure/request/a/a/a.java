package com.vivo.push.restructure.request.a.a;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: JsonParcel.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONArray f16781c;

    public a() {
        this.f16779a = 0;
        this.f16781c = new JSONArray();
    }

    public final void a(int i9) {
        this.f16781c.put(i9);
    }

    public final long b() {
        int i9 = this.f16779a;
        if (i9 >= this.f16780b) {
            return 0L;
        }
        JSONArray jSONArray = this.f16781c;
        this.f16779a = i9 + 1;
        return jSONArray.getLong(i9);
    }

    public final String c() {
        int i9 = this.f16779a;
        if (i9 >= this.f16780b) {
            return null;
        }
        JSONArray jSONArray = this.f16781c;
        this.f16779a = i9 + 1;
        return jSONArray.getString(i9);
    }

    public final boolean d() {
        int i9 = this.f16779a;
        if (i9 >= this.f16780b) {
            return false;
        }
        JSONArray jSONArray = this.f16781c;
        this.f16779a = i9 + 1;
        return jSONArray.getBoolean(i9);
    }

    public final String e() {
        JSONArray jSONArray = this.f16781c;
        return jSONArray != null ? jSONArray.toString() : "";
    }

    public final void a(long j) {
        this.f16781c.put(j);
    }

    public final void a(String str) {
        this.f16781c.put(str);
    }

    public a(String str) {
        this.f16779a = 0;
        JSONArray jSONArray = new JSONArray(str);
        this.f16781c = jSONArray;
        this.f16779a = 0;
        this.f16780b = jSONArray.length();
    }

    public final void a(boolean z8) {
        this.f16781c.put(z8);
    }

    public final <T extends c> void a(List<T> list) {
        if (list != null) {
            this.f16781c.put(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.f16781c.put(it.next().a());
            }
            return;
        }
        this.f16781c.put((Object) null);
    }

    public final int a() {
        int i9 = this.f16779a;
        if (i9 >= this.f16780b) {
            return 0;
        }
        JSONArray jSONArray = this.f16781c;
        this.f16779a = i9 + 1;
        return jSONArray.getInt(i9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends c> void a(c.a<T> aVar, List<T> list) throws JSONException {
        c cVarA;
        int i9 = this.f16779a;
        if (i9 < this.f16780b ? this.f16781c.isNull(i9) : true) {
            this.f16779a++;
            return;
        }
        JSONArray jSONArray = this.f16781c;
        int i10 = this.f16779a;
        this.f16779a = i10 + 1;
        int i11 = jSONArray.getInt(i10);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f16779a;
            if (i13 < this.f16780b) {
                JSONArray jSONArray2 = this.f16781c;
                this.f16779a = i13 + 1;
                cVarA = aVar.a(jSONArray2.getString(i13));
            } else {
                cVarA = null;
            }
            list.add(cVarA);
        }
    }
}

package com.xiaomi.push;

import android.text.TextUtils;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ArrayList<cp> f194a = new ArrayList<>();

    public cq(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f17158a = str;
    }

    public synchronized void a(cp cpVar) {
        int i9 = 0;
        while (i9 < this.f194a.size()) {
            try {
                if (this.f194a.get(i9).a(cpVar)) {
                    this.f194a.set(i9, cpVar);
                    break;
                }
                i9++;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i9 >= this.f194a.size()) {
            this.f194a.add(cpVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17158a);
        sb.append("\n");
        Iterator<cp> it = this.f194a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public cq() {
    }

    public synchronized cp a() {
        for (int size = this.f194a.size() - 1; size >= 0; size--) {
            cp cpVar = this.f194a.get(size);
            if (cpVar.m164a()) {
                ct.a().m175a(cpVar.a());
                return cpVar;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ArrayList<cp> m166a() {
        return this.f194a;
    }

    public synchronized void a(boolean z8) {
        try {
            for (int size = this.f194a.size() - 1; size >= 0; size--) {
                cp cpVar = this.f194a.get(size);
                if (z8) {
                    if (cpVar.c()) {
                        this.f194a.remove(size);
                    }
                } else if (!cpVar.b()) {
                    this.f194a.remove(size);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m165a() {
        return this.f17158a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m167a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, this.f17158a);
            JSONArray jSONArray = new JSONArray();
            Iterator<cp> it = this.f194a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m162a());
            }
            jSONObject.put("fbs", jSONArray);
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public synchronized cq a(JSONObject jSONObject) {
        this.f17158a = jSONObject.getString(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i9 = 0; i9 < jSONArray.length(); i9++) {
            this.f194a.add(new cp(this.f17158a).a(jSONArray.getJSONObject(i9)));
        }
        return this;
    }
}

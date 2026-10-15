package com.xiaomi.push;

import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class cw implements Comparable<cw> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f17168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedList<co> f210a;

    public cw() {
        this(null, 0);
    }

    public synchronized void a(co coVar) {
        if (coVar != null) {
            try {
                this.f210a.add(coVar);
                int iA = coVar.a();
                if (iA > 0) {
                    this.f17168a += coVar.a();
                } else {
                    int i9 = 0;
                    for (int size = this.f210a.size() - 1; size >= 0 && this.f210a.get(size).a() < 0; size--) {
                        i9++;
                    }
                    this.f17168a = (iA * i9) + this.f17168a;
                }
                if (this.f210a.size() > 30) {
                    this.f17168a -= this.f210a.remove().a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return this.f209a + Constants.COLON_SEPARATOR + this.f17168a;
    }

    public cw(String str) {
        this(str, 0);
    }

    public cw(String str, int i9) {
        this.f210a = new LinkedList<>();
        this.f208a = 0L;
        this.f209a = str;
        this.f17168a = i9;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(cw cwVar) {
        if (cwVar == null) {
            return 1;
        }
        return cwVar.f17168a - this.f17168a;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("tt", this.f208a);
            jSONObject.put("wt", this.f17168a);
            jSONObject.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, this.f209a);
            JSONArray jSONArray = new JSONArray();
            Iterator<co> it = this.f210a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m160a());
            }
            jSONObject.put("ah", jSONArray);
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public synchronized cw a(JSONObject jSONObject) {
        this.f208a = jSONObject.getLong("tt");
        this.f17168a = jSONObject.getInt("wt");
        this.f209a = jSONObject.getString(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i9 = 0; i9 < jSONArray.length(); i9++) {
            this.f210a.add(new co().a(jSONArray.getJSONObject(i9)));
        }
        return this;
    }
}

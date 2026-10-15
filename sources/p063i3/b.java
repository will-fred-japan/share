package p063i3;

import R1.a;
import R1.c;
import android.content.ContentValues;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApiAllLogLogDao.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a<a> {
    @Override // p055h3.a.InterfaceC0207a
    public final Object a(h3.a.b bVar) {
        int i9;
        long jB = bVar.b("_id");
        String strC = bVar.c("type");
        long jB2 = bVar.b("version_id");
        String strC2 = bVar.c("data");
        try {
            i9 = bVar.f19032a.getInt(bVar.a("hit_rules"));
        } catch (Throwable unused) {
            i9 = -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(strC2);
            jSONObject.put("hit_rules", i9);
            a aVar = new a();
            aVar.f3972a = jB;
            aVar.f3973b = strC;
            aVar.f3975d = jSONObject;
            aVar.f3976e = jB2;
            return aVar;
        } catch (JSONException unused2) {
            return new a(strC, jB, strC2, jB2);
        }
    }

    @Override // p055h3.a
    public final ContentValues e(c cVar) {
        a aVar = (a) cVar;
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", aVar.f3973b);
        contentValues.put("type2", aVar.f3974c);
        contentValues.put("timestamp", (Long) 0L);
        contentValues.put("version_id", Long.valueOf(aVar.f3976e));
        JSONObject jSONObject = aVar.f3975d;
        contentValues.put("data", jSONObject == null ? "" : jSONObject.toString());
        contentValues.put("is_sampled", (Integer) 0);
        contentValues.put("hit_rules", (Integer) 0);
        contentValues.put("front", (Integer) 0);
        contentValues.put("sid", (Long) 0L);
        contentValues.put("network_type", (Integer) 0);
        contentValues.put("traffic_value", (Long) 0L);
        return contentValues;
    }

    @Override // p055h3.a
    public final String[] h() {
        return new String[]{"_id", "type", "version_id", "data", "hit_rules"};
    }

    @Override // p055h3.a
    public final String i() {
        return "t_apiall";
    }
}

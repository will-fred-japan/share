package p096m7;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: JSONMethodCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f20495a = new g();

    @Override // p096m7.m
    public final ByteBuffer a(Object obj) {
        JSONArray jSONArrayPut = new JSONArray().put(h.a(obj));
        if (jSONArrayPut == null) {
            return null;
        }
        Object objA = h.a(jSONArrayPut);
        if (objA instanceof String) {
            t tVar = t.f20513b;
            String strQuote = JSONObject.quote((String) objA);
            tVar.getClass();
            return t.d(strQuote);
        }
        t tVar2 = t.f20513b;
        String string = objA.toString();
        tVar2.getClass();
        return t.d(string);
    }

    @Override // p096m7.m
    public final ByteBuffer b(String str, String str2) {
        JSONArray jSONArrayPut = new JSONArray().put("error").put(h.a(str)).put(JSONObject.NULL).put(h.a(str2));
        if (jSONArrayPut == null) {
            return null;
        }
        Object objA = h.a(jSONArrayPut);
        if (objA instanceof String) {
            t tVar = t.f20513b;
            String strQuote = JSONObject.quote((String) objA);
            tVar.getClass();
            return t.d(strQuote);
        }
        t tVar2 = t.f20513b;
        String string = objA.toString();
        tVar2.getClass();
        return t.d(string);
    }

    @Override // p096m7.m
    public final ByteBuffer c(String str, String str2, Object obj) {
        JSONArray jSONArrayPut = new JSONArray().put(str).put(h.a(str2)).put(h.a(obj));
        if (jSONArrayPut == null) {
            return null;
        }
        Object objA = h.a(jSONArrayPut);
        if (objA instanceof String) {
            t tVar = t.f20513b;
            String strQuote = JSONObject.quote((String) objA);
            tVar.getClass();
            return t.d(strQuote);
        }
        t tVar2 = t.f20513b;
        String string = objA.toString();
        tVar2.getClass();
        return t.d(string);
    }

    @Override // p096m7.m
    public final ByteBuffer d(j jVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", jVar.f20496a);
            jSONObject.put("args", h.a(jVar.f20497b));
            Object objA = h.a(jSONObject);
            if (objA instanceof String) {
                t tVar = t.f20513b;
                String strQuote = JSONObject.quote((String) objA);
                tVar.getClass();
                return t.d(strQuote);
            }
            t tVar2 = t.f20513b;
            String string = objA.toString();
            tVar2.getClass();
            return t.d(string);
        } catch (JSONException e9) {
            throw new IllegalArgumentException("Invalid JSON", e9);
        }
    }

    @Override // p096m7.m
    public final j e(ByteBuffer byteBuffer) {
        Object objNextValue;
        Object obj = null;
        try {
            if (byteBuffer == null) {
                objNextValue = null;
            } else {
                try {
                    t.f20513b.getClass();
                    JSONTokener jSONTokener = new JSONTokener(t.c(byteBuffer));
                    objNextValue = jSONTokener.nextValue();
                    if (jSONTokener.more()) {
                        throw new IllegalArgumentException("Invalid JSON");
                    }
                } catch (JSONException e9) {
                    throw new IllegalArgumentException("Invalid JSON", e9);
                }
            }
            if (objNextValue instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) objNextValue;
                Object obj2 = jSONObject.get("method");
                Object objOpt = jSONObject.opt("args");
                if (objOpt != JSONObject.NULL) {
                    obj = objOpt;
                }
                if (obj2 instanceof String) {
                    return new j(obj, (String) obj2);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + objNextValue);
        } catch (JSONException e10) {
            throw new IllegalArgumentException("Invalid JSON", e10);
        }
    }

    @Override // p096m7.m
    public final Object f(ByteBuffer byteBuffer) {
        try {
            try {
                t.f20513b.getClass();
                JSONTokener jSONTokener = new JSONTokener(t.c(byteBuffer));
                Object objNextValue = jSONTokener.nextValue();
                if (jSONTokener.more()) {
                    throw new IllegalArgumentException("Invalid JSON");
                }
                if (objNextValue instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objNextValue;
                    Object obj = null;
                    if (jSONArray.length() == 1) {
                        Object objOpt = jSONArray.opt(0);
                        if (objOpt == JSONObject.NULL) {
                            return null;
                        }
                        return objOpt;
                    }
                    if (jSONArray.length() == 3) {
                        Object obj2 = jSONArray.get(0);
                        Object objOpt2 = jSONArray.opt(1);
                        Object obj3 = JSONObject.NULL;
                        if (objOpt2 == obj3) {
                            objOpt2 = null;
                        }
                        Object objOpt3 = jSONArray.opt(2);
                        if (objOpt3 != obj3) {
                            obj = objOpt3;
                        }
                        if ((obj2 instanceof String) && (objOpt2 == null || (objOpt2 instanceof String))) {
                            throw new e((String) obj2, (String) objOpt2, obj);
                        }
                    }
                }
                throw new IllegalArgumentException("Invalid envelope: " + objNextValue);
            } catch (JSONException e9) {
                throw new IllegalArgumentException("Invalid JSON", e9);
            }
        } catch (JSONException e10) {
            throw new IllegalArgumentException("Invalid JSON", e10);
        }
    }
}

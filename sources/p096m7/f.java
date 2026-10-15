package p096m7;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: JSONMessageCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements i<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20494a = new f();

    @Override // p096m7.i
    public final ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object objA = h.a(obj);
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

    @Override // p096m7.i
    public final Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            t.f20513b.getClass();
            JSONTokener jSONTokener = new JSONTokener(t.c(byteBuffer));
            Object objNextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return objNextValue;
        } catch (JSONException e9) {
            throw new IllegalArgumentException("Invalid JSON", e9);
        }
    }
}

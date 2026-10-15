package p099n1;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f20548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f20549b = new ArrayList();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: JsonUtils.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f20551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f20552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f20553d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f20554e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f20555f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ a[] f20556g;

        static {
            a aVar = new a("EMPTY_ARRAY", 0);
            f20550a = aVar;
            a aVar2 = new a("NONEMPTY_ARRAY", 1);
            f20551b = aVar2;
            a aVar3 = new a("EMPTY_OBJECT", 2);
            f20552c = aVar3;
            a aVar4 = new a("DANGLING_KEY", 3);
            f20553d = aVar4;
            a aVar5 = new a("NONEMPTY_OBJECT", 4);
            f20554e = aVar5;
            a aVar6 = new a("NULL", 5);
            f20555f = aVar6;
            f20556g = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f20556g.clone();
        }
    }

    public b(c cVar) {
        this.f20548a = cVar;
    }

    public final void a() throws JSONException {
        ArrayList arrayList = this.f20549b;
        if (arrayList.isEmpty()) {
            return;
        }
        a aVarE = e();
        a aVar = a.f20550a;
        a aVar2 = a.f20551b;
        if (aVarE == aVar) {
            arrayList.set(arrayList.size() - 1, aVar2);
            return;
        }
        c cVar = this.f20548a;
        if (aVarE == aVar2) {
            cVar.write(44);
            return;
        }
        if (aVarE != a.f20553d) {
            if (aVarE != a.f20555f) {
                throw new JSONException("Nesting problem");
            }
        } else {
            cVar.write(Constants.COLON_SEPARATOR);
            arrayList.set(arrayList.size() - 1, a.f20554e);
        }
    }

    public final void b(Object obj) throws JSONException {
        boolean z8 = obj instanceof JSONArray;
        c cVar = this.f20548a;
        if (z8) {
            JSONArray jSONArray = (JSONArray) obj;
            a aVar = a.f20550a;
            a();
            ArrayList arrayList = this.f20549b;
            arrayList.add(aVar);
            cVar.write("[");
            for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                b(jSONArray.get(i9));
            }
            e();
            arrayList.remove(arrayList.size() - 1);
            cVar.write("]");
            return;
        }
        if (obj instanceof JSONObject) {
            d((JSONObject) obj);
            return;
        }
        a();
        if (obj == null || obj == JSONObject.NULL) {
            cVar.write("null");
            return;
        }
        if (obj instanceof Boolean) {
            cVar.write(String.valueOf(obj));
        } else if (obj instanceof Number) {
            cVar.write(JSONObject.numberToString((Number) obj));
        } else {
            c(obj.toString());
        }
    }

    public final void c(String str) {
        c cVar = this.f20548a;
        cVar.write("\"");
        int length = str.length();
        for (int i9 = 0; i9 < length; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == '\f') {
                cVar.write("\\f");
            } else if (cCharAt == '\r') {
                cVar.write("\\r");
            } else if (cCharAt != '\"' && cCharAt != '/' && cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        cVar.write("\\b");
                        break;
                    case '\t':
                        cVar.write("\\t");
                        break;
                    case '\n':
                        cVar.write("\\n");
                        break;
                    default:
                        if (cCharAt <= 31) {
                            cVar.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                        } else {
                            cVar.write(cCharAt);
                        }
                        break;
                }
            } else {
                cVar.write(92);
                cVar.write(cCharAt);
            }
        }
        cVar.write("\"");
    }

    public final void d(JSONObject jSONObject) throws JSONException {
        a aVar = a.f20552c;
        a();
        ArrayList arrayList = this.f20549b;
        arrayList.add(aVar);
        c cVar = this.f20548a;
        cVar.write("{");
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            a aVarE = e();
            if (aVarE == a.f20554e) {
                cVar.write(44);
            } else if (aVarE != aVar) {
                throw new JSONException("Nesting problem");
            }
            arrayList.set(arrayList.size() - 1, a.f20553d);
            c(next);
            b(obj);
        }
        e();
        arrayList.remove(arrayList.size() - 1);
        cVar.write("}");
    }

    public final a e() {
        ArrayList arrayList = this.f20549b;
        return (a) arrayList.get(arrayList.size() - 1);
    }

    public final String toString() {
        return "";
    }
}

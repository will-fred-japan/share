package p144s4;

import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedWriter f21243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f21244b = new ArrayList();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f21246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f21247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f21248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f21249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f21250f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ a[] f21251g;

        static {
            a aVar = new a("EMPTY_ARRAY", 0);
            f21245a = aVar;
            a aVar2 = new a("NONEMPTY_ARRAY", 1);
            f21246b = aVar2;
            a aVar3 = new a("EMPTY_OBJECT", 2);
            f21247c = aVar3;
            a aVar4 = new a("DANGLING_KEY", 3);
            f21248d = aVar4;
            a aVar5 = new a("NONEMPTY_OBJECT", 4);
            f21249e = aVar5;
            a aVar6 = new a("NULL", 5);
            f21250f = aVar6;
            f21251g = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f21251g.clone();
        }
    }

    public f(BufferedWriter bufferedWriter) {
        this.f21243a = bufferedWriter;
    }

    public final void a(Object obj) throws JSONException, IOException {
        if (obj instanceof JSONArray) {
            b((JSONArray) obj);
            return;
        }
        if (obj instanceof JSONObject) {
            c((JSONObject) obj);
            return;
        }
        f();
        BufferedWriter bufferedWriter = this.f21243a;
        if (obj == null || obj == JSONObject.NULL) {
            bufferedWriter.write("null");
            return;
        }
        if (obj instanceof Boolean) {
            bufferedWriter.write(String.valueOf(obj));
        } else if (obj instanceof Number) {
            bufferedWriter.write(JSONObject.numberToString((Number) obj));
        } else {
            d(obj.toString());
        }
    }

    public final void b(JSONArray jSONArray) throws JSONException, IOException {
        a aVar = a.f21245a;
        f();
        ArrayList arrayList = this.f21244b;
        arrayList.add(aVar);
        BufferedWriter bufferedWriter = this.f21243a;
        bufferedWriter.write("[");
        for (int i9 = 0; i9 < jSONArray.length(); i9++) {
            a(jSONArray.get(i9));
        }
        e();
        arrayList.remove(arrayList.size() - 1);
        bufferedWriter.write("]");
    }

    public final void c(JSONObject jSONObject) throws JSONException, IOException {
        a aVar = a.f21247c;
        f();
        ArrayList arrayList = this.f21244b;
        arrayList.add(aVar);
        BufferedWriter bufferedWriter = this.f21243a;
        bufferedWriter.write("{");
        Iterator<String> itKeys = jSONObject.keys();
        while (true) {
            boolean zHasNext = itKeys.hasNext();
            a aVar2 = a.f21249e;
            if (!zHasNext) {
                e();
                arrayList.remove(arrayList.size() - 1);
                bufferedWriter.write("}");
                return;
            }
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            a aVarE = e();
            if (aVarE == aVar2) {
                bufferedWriter.write(44);
            } else if (aVarE != aVar) {
                throw new JSONException("Nesting problem");
            }
            arrayList.set(arrayList.size() - 1, a.f21248d);
            d(next);
            a(obj);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0026. Please report as an issue. */
    public final void d(String str) throws IOException {
        String str2;
        BufferedWriter bufferedWriter = this.f21243a;
        bufferedWriter.write("\"");
        int length = str.length();
        for (int i9 = 0; i9 < length; i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == '\f') {
                str2 = "\\f";
            } else if (cCharAt != '\r') {
                if (cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                    bufferedWriter.write(92);
                } else {
                    switch (cCharAt) {
                        case '\b':
                            str2 = "\\b";
                            break;
                        case '\t':
                            str2 = "\\t";
                            break;
                        case '\n':
                            str2 = "\\n";
                            break;
                        default:
                            if (cCharAt <= 31) {
                                str2 = String.format("\\u%04x", Integer.valueOf(cCharAt));
                            }
                            break;
                    }
                }
                bufferedWriter.write(cCharAt);
            } else {
                str2 = "\\r";
            }
            bufferedWriter.write(str2);
        }
        bufferedWriter.write("\"");
    }

    public final a e() {
        ArrayList arrayList = this.f21244b;
        return (a) arrayList.get(arrayList.size() - 1);
    }

    public final void f() throws JSONException, IOException {
        ArrayList arrayList = this.f21244b;
        if (arrayList.isEmpty()) {
            return;
        }
        a aVarE = e();
        a aVar = a.f21245a;
        a aVar2 = a.f21246b;
        if (aVarE == aVar) {
            arrayList.set(arrayList.size() - 1, aVar2);
            return;
        }
        BufferedWriter bufferedWriter = this.f21243a;
        if (aVarE == aVar2) {
            bufferedWriter.write(44);
            return;
        }
        if (aVarE != a.f21248d) {
            if (aVarE != a.f21250f) {
                throw new JSONException("Nesting problem");
            }
        } else {
            bufferedWriter.write(Constants.COLON_SEPARATOR);
            arrayList.set(arrayList.size() - 1, a.f21249e);
        }
    }

    public final String toString() {
        return "";
    }
}

package V0;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4825a;

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        d(jSONObject2, jSONObject);
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("oaid");
            W0.e.a aVar = W0.e.f5000a;
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("id", null) : null;
            if (!TextUtils.isEmpty(strOptString)) {
                jSONObject2.put("oaid", strOptString);
                return jSONObject2;
            }
        } catch (Exception e9) {
            m.b(e9);
        }
        return jSONObject2;
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                m.b(th);
            }
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e9) {
            m.b(e9);
        }
    }

    public static boolean e(String str) {
        boolean z8 = false;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        for (int i9 = 0; i9 < str.length(); i9++) {
            if (str.charAt(i9) != '0') {
                return !z8;
            }
        }
        z8 = true;
        return !z8;
    }

    public static boolean f(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        return str != null && str.equals(str2);
    }

    public static boolean g(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i9 = 0; i9 < length; i9++) {
            char cCharAt = str.charAt(i9);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }
}

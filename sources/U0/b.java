package U0;

import android.content.ContentValues;
import android.database.Cursor;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseData.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Cloneable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SimpleDateFormat f4594k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4603i;
    public String j;

    public b() {
        c(0L);
    }

    public b a(JSONObject jSONObject) {
        this.f4596b = jSONObject.optLong("local_time_ms", 0L);
        this.f4595a = 0L;
        this.f4597c = 0L;
        this.f4603i = 0;
        this.f4599e = 0L;
        this.f4598d = null;
        this.f4600f = null;
        this.f4601g = null;
        this.f4602h = null;
        return this;
    }

    public final String b() {
        List<String> listE = e();
        if (listE == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(j());
        sb.append("(");
        for (int i9 = 0; i9 < listE.size(); i9 += 2) {
            sb.append(listE.get(i9));
            sb.append(" ");
            sb.append(listE.get(i9 + 1));
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public final void c(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.f4596b = j;
    }

    public void d(Cursor cursor) {
        this.f4595a = cursor.getLong(0);
        this.f4596b = cursor.getLong(1);
        this.f4597c = cursor.getLong(2);
        this.f4603i = cursor.getInt(3);
        this.f4599e = cursor.getLong(4);
        this.f4598d = cursor.getString(5);
        this.f4600f = cursor.getString(6);
        this.f4601g = cursor.getString(7);
        this.f4602h = cursor.getString(8);
    }

    public List<String> e() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", MTCoreConstants.Register.KEY_USER_ID, "integer", "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar");
    }

    public void f(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f4596b));
        contentValues.put("tea_event_index", Long.valueOf(this.f4597c));
        contentValues.put("nt", Integer.valueOf(this.f4603i));
        contentValues.put(MTCoreConstants.Register.KEY_USER_ID, Long.valueOf(this.f4599e));
        contentValues.put("session_id", this.f4598d);
        contentValues.put("user_unique_id", this.f4600f);
        contentValues.put("ssid", this.f4601g);
        contentValues.put("ab_sdk_version", this.f4602h);
    }

    public String g() {
        return null;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e9) {
            V0.m.b(e9);
            return null;
        }
    }

    public String i() {
        StringBuilder sbF = p027d5.a.f("sid:");
        sbF.append(this.f4598d);
        return sbF.toString();
    }

    public abstract String j();

    public final JSONObject k() {
        try {
            this.j = f4594k.format(new Date(this.f4596b));
            return l();
        } catch (JSONException e9) {
            V0.m.b(e9);
            return null;
        }
    }

    public abstract JSONObject l();

    public final String toString() {
        String strJ = j();
        if (!getClass().getSimpleName().equalsIgnoreCase(strJ)) {
            StringBuilder sbC = p171w.a.c(strJ, ", ");
            sbC.append(getClass().getSimpleName());
            strJ = sbC.toString();
        }
        String strSubstring = this.f4598d;
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
        } else {
            strSubstring = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        StringBuilder sbI = defpackage.f.i("{", strJ, ", ");
        sbI.append(i());
        sbI.append(", ");
        sbI.append(strSubstring);
        sbI.append(", ");
        return W5.e.m(sbI, this.f4596b, "}");
    }
}

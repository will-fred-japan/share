package Q1;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: DoctorManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f3739a;

    /* JADX INFO: renamed from: Q1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DoctorManager.java */
    public interface InterfaceC0042a {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: DoctorManager.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3740a;

        static {
            a aVar = new a();
            aVar.f3739a = new ArrayList();
            f3740a = aVar;
        }
    }

    public final void a(String str, String str2) {
        ArrayList arrayList = this.f3739a;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InterfaceC0042a) it.next()).b();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            Log.d("ApmInsight", p199z2.b.f(new String[]{str}));
        } else {
            Log.d("ApmInsight", p199z2.b.f(new String[]{p171w.a.a(str, Constants.COLON_SEPARATOR, str2)}));
        }
    }

    public final void b(String str, JSONObject jSONObject) {
        ArrayList arrayList = this.f3739a;
        if (arrayList.size() <= 0 || jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("DATA_DOCTOR");
            jSONObject2.put(str, System.currentTimeMillis());
            jSONObject2.optInt("DATA_ID");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InterfaceC0042a) it.next()).a();
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }
}

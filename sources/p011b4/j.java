package p011b4;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import okhttp3.internal.http2.Settings;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f8550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f8552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f8557i;
    public String j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public k f8558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f8559l;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SystemClock.uptimeMillis();
            j.this.getClass();
            throw null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8565e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8566f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f8567g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f8568h;

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", j.a(this.f8568h));
                jSONObject.put("cpuDuration", this.f8567g);
                jSONObject.put("duration", this.f8566f);
                jSONObject.put("type", this.f8564d);
                jSONObject.put(MTPushConstants.Geofence.KEY_COUNT, this.f8565e);
                jSONObject.put("messageCount", this.f8565e);
                jSONObject.put("lastDuration", this.f8562b - this.f8563c);
                jSONObject.put("start", this.f8561a);
                jSONObject.put("end", this.f8562b);
                jSONObject.put("block_uuid", (Object) null);
                jSONObject.put("sblock_uuid", (Object) null);
                jSONObject.put("belong_frame", false);
                return jSONObject;
            } catch (JSONException e9) {
                e9.printStackTrace();
                return jSONObject;
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f8571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f8572d;

        public final ArrayList a() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f8572d;
            int i9 = 0;
            if (arrayList2.size() == this.f8569a) {
                for (int i10 = this.f8570b; i10 < arrayList2.size(); i10++) {
                    arrayList.add((b) arrayList2.get(i10));
                }
                while (i9 < this.f8570b - 1) {
                    arrayList.add((b) arrayList2.get(i9));
                    i9++;
                }
            } else {
                while (i9 < arrayList2.size()) {
                    arrayList.add(arrayList2.get(i9));
                    i9++;
                }
            }
            return arrayList;
        }
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "unknown message";
        }
        try {
            String[] strArrSplit = str.split(Constants.COLON_SEPARATOR);
            String str3 = strArrSplit.length == 2 ? strArrSplit[1] : "";
            if (str.contains("{") && str.contains("}")) {
                str2 = str.split("\\{")[0];
                try {
                    str = str2 + str.split("\\}")[1];
                } catch (Throwable unused) {
                    return str2;
                }
            } else {
                str2 = str;
            }
            if (str.contains("@")) {
                String[] strArrSplit2 = str.split("@");
                if (strArrSplit2.length > 1) {
                    str = strArrSplit2[0];
                }
            }
            if (str.contains("(") && str.contains(")") && !str.endsWith(" null")) {
                String[] strArrSplit3 = str.split("\\(");
                if (strArrSplit3.length > 1) {
                    str = strArrSplit3[1];
                }
                str = str.replace(")", "");
            }
            if (str.startsWith(" ")) {
                str = str.replace(" ", "");
            }
            return str + str3;
        } catch (Throwable unused2) {
            return str;
        }
    }

    public static void c(j jVar, boolean z8, long j) {
        j jVar2;
        long j8;
        long j9;
        String str;
        boolean z9;
        int i9;
        int i10 = jVar.f8550b + 1;
        jVar.f8550b = i10;
        jVar.f8550b = i10 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (jVar.f8553e < 0) {
            jVar.f8553e = j;
        }
        if (jVar.f8554f < 0) {
            jVar.f8554f = j;
        }
        if (jVar.f8555g < 0) {
            jVar.f8555g = Process.myTid();
            jVar.f8556h = SystemClock.currentThreadTimeMillis();
        }
        long j10 = j - jVar.f8553e;
        long j11 = jVar.f8551c;
        if (j10 > j11) {
            long j12 = jVar.f8554f;
            if (j - j12 > j11) {
                if (!z8) {
                    j8 = j;
                    if (jVar.f8549a == 0) {
                        str = jVar.j;
                        z9 = true;
                        i9 = 8;
                        jVar2 = jVar;
                    } else {
                        j9 = j8;
                        jVar.b(9, j12, jVar.f8557i, false);
                        jVar2 = jVar;
                        str = jVar2.j;
                        z9 = true;
                        i9 = 8;
                    }
                    jVar2.b(i9, j8, str, z9);
                } else if (jVar.f8549a == 0) {
                    jVar.b(1, j, "no message running", true);
                    j8 = j;
                    jVar2 = jVar;
                } else {
                    j9 = j;
                    jVar.b(9, j12, jVar.f8557i, true);
                    jVar2 = jVar;
                    i9 = 1;
                    str = "no message running";
                    z9 = false;
                }
                j8 = j9;
                jVar2.b(i9, j8, str, z9);
            } else {
                jVar2 = jVar;
                j8 = j;
                jVar2.b(9, j8, jVar2.j, true);
            }
        } else {
            jVar2 = jVar;
            j8 = j;
        }
        jVar2.f8554f = j8;
    }

    public final void b(int i9, long j, String str, boolean z8) {
        c cVar = this.f8552d;
        b bVar = cVar.f8571c;
        if (bVar != null) {
            bVar.f8564d = i9;
            cVar.f8571c = null;
        } else {
            bVar = new b();
            bVar.f8564d = i9;
        }
        bVar.f8566f = j - this.f8553e;
        if (z8) {
            long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            bVar.f8567g = jCurrentThreadTimeMillis - this.f8556h;
            this.f8556h = jCurrentThreadTimeMillis;
        } else {
            bVar.f8567g = -1L;
        }
        bVar.f8565e = this.f8549a;
        bVar.f8568h = str;
        bVar.f8561a = this.f8553e;
        bVar.f8562b = j;
        bVar.f8563c = this.f8554f;
        c cVar2 = this.f8552d;
        ArrayList arrayList = cVar2.f8572d;
        int size = arrayList.size();
        int i10 = cVar2.f8569a;
        if (size < i10) {
            arrayList.add(bVar);
            cVar2.f8570b = arrayList.size();
        } else {
            int i11 = cVar2.f8570b % i10;
            cVar2.f8570b = i11;
            b bVar2 = (b) arrayList.set(i11, bVar);
            bVar2.f8564d = -1;
            bVar2.f8565e = -1;
            bVar2.f8566f = -1L;
            bVar2.f8568h = null;
            cVar2.f8571c = bVar2;
            cVar2.f8570b++;
        }
        this.f8549a = 0;
        this.f8553e = j;
    }
}

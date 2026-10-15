package R0;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;

/* JADX INFO: compiled from: ConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f3921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Y3.c f3922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f3923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f3924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedPreferences f3925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<String> f3926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet<String> f3927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3928h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3929i = 27;
    public long j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3930k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f3931l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3932m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f3933n;

    public f(Application application, Y3.c cVar) {
        this.f3932m = null;
        this.f3921a = application;
        this.f3922b = cVar;
        cVar.getClass();
        StringBuilder sbF = p027d5.a.f("applog_stats_");
        sbF.append(cVar.f5241a);
        this.f3925e = application.getSharedPreferences(sbF.toString(), 0);
        StringBuilder sbF2 = p027d5.a.f("header_custom_");
        sbF2.append(cVar.f5241a);
        this.f3923c = application.getSharedPreferences(sbF2.toString(), 0);
        StringBuilder sbF3 = p027d5.a.f("last_sp_session_");
        sbF3.append(cVar.f5241a);
        this.f3924d = application.getSharedPreferences(sbF3.toString(), 0);
        this.f3926f = new HashSet<>();
        this.f3927g = new HashSet<>();
        this.f3932m = cVar.f5251l;
        this.f3933n = cVar.f5252m;
    }

    public final String a() {
        Application application = this.f3921a;
        Y3.c cVar = this.f3922b;
        String str = cVar.f5243c;
        if (TextUtils.isEmpty(str)) {
            cVar.getClass();
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                return application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
            } catch (Throwable th) {
                V0.m.a("getChannel", th);
            }
        }
        return str;
    }

    public final boolean b() {
        Y3.c cVar = this.f3922b;
        if (cVar.f5245e == 0) {
            String str = V0.o.f4825a;
            if (TextUtils.isEmpty(str)) {
                V0.o.f4825a = A4.d.a();
                if (V0.m.f4822b) {
                    StringBuilder sbF = p027d5.a.f("getProcessName, ");
                    sbF.append(V0.o.f4825a);
                    V0.m.a(sbF.toString(), null);
                }
                str = V0.o.f4825a;
            }
            if (TextUtils.isEmpty(str)) {
                cVar.f5245e = 0;
            } else {
                cVar.f5245e = str.contains(Constants.COLON_SEPARATOR) ? 2 : 1;
            }
        }
        return cVar.f5245e == 1;
    }
}

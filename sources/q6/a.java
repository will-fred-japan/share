package q6;

import android.text.TextUtils;
import p152t4.p;

/* JADX INFO: compiled from: RecordConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20988b;

    public /* synthetic */ a(String str, String str2) {
        this.f20987a = str;
        this.f20988b = str2;
    }

    public String a() {
        String strD = "0";
        if (!TextUtils.isEmpty(this.f20987a) && !"0".equals(this.f20987a)) {
            return this.f20987a;
        }
        if (!TextUtils.isEmpty(this.f20988b) && !"0".equals(this.f20988b)) {
            return this.f20988b;
        }
        String strD2 = com.apm.insight.f.a().d();
        this.f20987a = strD2;
        if (!TextUtils.isEmpty(strD2) && !"0".equals(this.f20987a)) {
            return this.f20987a;
        }
        p pVarB = p.b();
        pVarB.getClass();
        try {
            strD = p144s4.d.d(pVarB.f21455b.getAbsolutePath());
        } catch (Throwable unused) {
        }
        this.f20988b = strD;
        return strD;
    }
}

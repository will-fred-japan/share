package R0;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PackageLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class n extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f3956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f3957e;

    public n(Application application, f fVar) {
        super(false, false);
        this.f3956d = application;
        this.f3957e = fVar;
    }

    @Override // R0.c
    public final boolean a(JSONObject jSONObject) throws JSONException {
        int i9;
        Application application = this.f3956d;
        String packageName = application.getPackageName();
        f fVar = this.f3957e;
        fVar.f3922b.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        Y3.c cVar = fVar.f3922b;
        if (zIsEmpty) {
            jSONObject.put("package", packageName);
        } else {
            V0.m.a("has zijie pkg", null);
            cVar.getClass();
            jSONObject.put("package", (Object) null);
            jSONObject.put("real_package_name", packageName);
        }
        try {
            ConcurrentHashMap concurrentHashMap = A4.c.f1475a;
            PackageInfo packageInfoB = A4.c.b(0, application.getPackageName(), application);
            int i10 = packageInfoB != null ? packageInfoB.versionCode : 0;
            if (TextUtils.isEmpty(cVar.f5247g)) {
                jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, A4.c.c(application));
            } else {
                jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, cVar.f5247g);
            }
            if (TextUtils.isEmpty(cVar.j)) {
                jSONObject.put("app_version_minor", "");
            } else {
                jSONObject.put("app_version_minor", cVar.j);
            }
            int i11 = cVar.f5248h;
            if (i11 != 0) {
                jSONObject.put("version_code", i11);
            } else {
                jSONObject.put("version_code", i10);
            }
            int i12 = cVar.f5249i;
            if (i12 != 0) {
                jSONObject.put("update_version_code", i12);
            } else {
                jSONObject.put("update_version_code", i10);
            }
            cVar.getClass();
            jSONObject.put("manifest_version_code", i10);
            cVar.getClass();
            if (!TextUtils.isEmpty(null)) {
                cVar.getClass();
                jSONObject.put("app_name", (Object) null);
            }
            cVar.getClass();
            if (!TextUtils.isEmpty(null)) {
                cVar.getClass();
                jSONObject.put("tweaked_channel", (Object) null);
            }
            if (application.getApplicationInfo() != null && (i9 = application.getApplicationInfo().labelRes) > 0) {
                jSONObject.put("display_name", application.getString(i9));
            }
            return true;
        } catch (Throwable th) {
            V0.m.b(th);
            return true;
        }
    }
}

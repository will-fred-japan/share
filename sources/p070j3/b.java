package p070j3;

import R1.d;
import com.xiaomi.mipush.sdk.Constants;
import p055h3.a;

/* JADX INFO: compiled from: VersionTmpDao.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a<d> implements a.InterfaceC0207a<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f19855f = {"_id", "version_code", "version_name", "manifest_version_code", "update_version_code", Constants.EXTRA_KEY_APP_VERSION};

    @Override // p055h3.a.InterfaceC0207a
    public final d a(a.b bVar) {
        bVar.b("_id");
        String strC = bVar.c("version_code");
        String strC2 = bVar.c("version_name");
        String strC3 = bVar.c("manifest_version_code");
        String strC4 = bVar.c("update_version_code");
        String strC5 = bVar.c(Constants.EXTRA_KEY_APP_VERSION);
        d dVar = new d();
        dVar.f3977a = strC;
        dVar.f3978b = strC2;
        dVar.f3979c = strC3;
        dVar.f3980d = strC4;
        dVar.f3981e = strC5;
        return dVar;
    }

    @Override // p055h3.a
    public final String[] h() {
        return f19855f;
    }

    @Override // p055h3.a
    public final String i() {
        return "local_monitor_version";
    }
}

package O1;

import W5.e;
import com.apm.insight.runtime.ConfigManager;
import java.util.ArrayList;
import p199z2.b;

/* JADX INFO: compiled from: ReportUrl.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f3455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f3456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList f3457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ArrayList f3459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f3460g;

    static {
        String strConcat = b.f22481l.concat("apmplus.volces.com");
        f3454a = strConcat;
        ArrayList arrayList = new ArrayList();
        f3455b = arrayList;
        arrayList.add(strConcat + ConfigManager.CONFIG_URL_SUFFIX);
        ArrayList arrayList2 = new ArrayList();
        f3456c = arrayList2;
        arrayList2.add(strConcat + "/monitor/collect/batch/");
        f3457d = new ArrayList();
        f3458e = e.u(strConcat, ConfigManager.EXCEPTION_URL_SUFFIX);
        ArrayList arrayList3 = new ArrayList();
        f3459f = arrayList3;
        arrayList3.add(strConcat + ConfigManager.EXCEPTION_URL_SUFFIX);
        f3460g = strConcat + ConfigManager.FILE_UPLOAD_URL_SUFFIX;
    }
}

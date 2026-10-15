package M3;

import com.apm.insight.runtime.ConfigManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: CloudConstants.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f2904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f2905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f2906c;

    static {
        String str = O1.a.f3454a;
        ArrayList arrayList = new ArrayList();
        f2904a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f2905b = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        f2906c = arrayList3;
        arrayList.add(str + "/monitor/collect/c/cloudcontrol/get");
        arrayList2.add(str + ConfigManager.ALOG_URL_SUFFIX);
        arrayList3.add(str + ConfigManager.FILE_UPLOAD_URL_SUFFIX);
    }
}

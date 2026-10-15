package cn.jiguang.dy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jiguang.v.f;
import cn.jiguang.v.g;
import cn.jiguang.v.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f10474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f10475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f10476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences f10477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10478e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f10479a = new c();
    }

    private c() {
        this.f10476c = new Object();
        try {
            Object obj = FileLocker.fileLock;
            if (obj != null) {
                this.f10476c = obj;
            }
        } catch (Throwable unused) {
            cn.jiguang.u.b.e("PluginAnalytics", "FileLocker not exist");
        }
    }

    public static c a() {
        return a.f10479a;
    }

    private boolean d(Context context) {
        c(context, g.b(context));
        boolean z8 = f(context).getBoolean("plugin_report_switch", false);
        if (z8) {
            return z8;
        }
        Boolean bool = this.f10474a;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(f(context).getBoolean("need_report", false));
        this.f10474a = boolValueOf;
        return boolValueOf.booleanValue();
    }

    private boolean e(Context context) {
        boolean z8 = f(context).getBoolean("plugin_multi_switch", false);
        if (z8) {
            return z8;
        }
        Boolean bool = this.f10475b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(f(context).getBoolean("multi_process", false));
        this.f10475b = boolValueOf;
        return boolValueOf.booleanValue();
    }

    private SharedPreferences f(Context context) {
        if (this.f10477d == null) {
            this.f10477d = context.getSharedPreferences("cn.jiguang.prefs", 0);
        }
        return this.f10477d;
    }

    private void g(Context context) {
        String str;
        String str2;
        try {
            cn.jiguang.u.b.b("PluginAnalytics", "[reportNow]:" + System.currentTimeMillis());
            File file = new File(cn.jiguang.v.c.a(context), "dy_analysis");
            if (file.exists()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    for (File file2 : fileArrListFiles) {
                        try {
                            if (!file2.getName().endsWith(".tmp")) {
                                cn.jiguang.u.b.b("PluginAnalytics", "read event from file:" + file2.getAbsolutePath());
                                String strA = cn.jiguang.v.c.a(file2);
                                if (!TextUtils.isEmpty(strA)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("itime", System.currentTimeMillis());
                                    jSONObject.put("type", "sdk_stat");
                                    jSONObject.put("events", new JSONArray(strA));
                                    f.a(context, JConstants.SDK_TYPE, 14, null, null, jSONObject.toString());
                                    cn.jiguang.v.c.a(file2, "");
                                }
                            }
                        } catch (Throwable th) {
                            cn.jiguang.u.b.b("PluginAnalytics", "report file failed:" + th.getMessage());
                        }
                    }
                    synchronized (this.f10476c) {
                        try {
                            for (File file3 : fileArrListFiles) {
                                try {
                                    String name = file3.getName();
                                    if (name.endsWith(".tmp")) {
                                        file3.renameTo(new File(file3.getParentFile(), name.substring(0, name.length() - 4)));
                                    }
                                } catch (Throwable th2) {
                                    cn.jiguang.u.b.b("PluginAnalytics", "report file failed:" + th2.getMessage());
                                }
                            }
                            b(context);
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    return;
                }
                str = "PluginAnalytics";
                str2 = "not found child event file to report";
            } else {
                str = "PluginAnalytics";
                str2 = "no event file to report";
            }
            cn.jiguang.u.b.b(str, str2);
        } catch (Throwable th4) {
            cn.jiguang.u.b.g("PluginAnalytics", "report analysis error:" + th4.getMessage());
        }
    }

    private List<cn.jiguang.s.b> h(Context context) {
        ArrayList arrayList = null;
        try {
            cn.jiguang.u.b.b("PluginAnalytics", "loadObjects start");
            String strA = cn.jiguang.v.c.a(context, (!c(context) || this.f10478e) ? i(context) : i(context) + ".tmp");
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                try {
                    JSONArray jSONArray = new JSONArray(strA);
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i9);
                        cn.jiguang.s.b bVar = new cn.jiguang.s.b();
                        bVar.a(jSONObject);
                        arrayList2.add(bVar);
                    }
                } catch (Throwable th) {
                    th = th;
                    arrayList = arrayList2;
                }
            } catch (Throwable unused) {
                cn.jiguang.v.c.a(context, i(context), "");
            }
            return arrayList2;
        } catch (Throwable th2) {
            th = th2;
        }
        cn.jiguang.u.b.e("PluginAnalytics", "[loadObjects] failed:" + th.getMessage());
        cn.jiguang.v.c.a(context, i(context), "");
        return arrayList;
    }

    private String i(Context context) {
        String strD = j.d(g.a(context));
        if (!TextUtils.isEmpty(strD)) {
            return A.a.j(new StringBuilder("dy_analysis"), File.separator, strD);
        }
        return "dy_analysis" + File.separator + Process.myPid();
    }

    public void b(Context context) {
        f(context).edit().putLong("plugin_report_time_", System.currentTimeMillis()).apply();
    }

    public boolean c(Context context) {
        long j = f(context).getLong("plugin_report_time_", 0L);
        boolean z8 = j <= 0 || System.currentTimeMillis() > f(context).getLong("plugin_report_interval_", 86400000L) + j;
        if (!z8) {
            cn.jiguang.u.b.b("PluginAnalytics", "no need report, last is " + cn.jiguang.v.b.a(j));
        }
        return z8;
    }

    private boolean c(Context context, boolean z8) {
        boolean z9 = f(context).getBoolean("first_" + z8, true);
        if (z9) {
            this.f10478e = true;
            f(context).edit().putBoolean("first_" + z8, false).apply();
        }
        return z9;
    }

    public void a(Context context) {
        try {
            cn.jiguang.u.b.b("PluginAnalytics", "will [report]");
            if (d(context)) {
                a(context, null, 1);
            } else {
                cn.jiguang.u.b.b("PluginAnalytics", "need not report");
            }
        } catch (Throwable th) {
            cn.jiguang.u.b.b("PluginAnalytics", "[report] failed:" + th.getMessage());
        }
    }

    public void b(Context context, boolean z8) {
        cn.jiguang.u.b.b("PluginAnalytics", "[setMultiProcessOpen] enable:" + z8);
        this.f10475b = Boolean.valueOf(z8);
        A.f.l(f(context), "multi_process", z8);
    }

    public void a(Context context, int i9, int i10, cn.jiguang.s.a aVar, int i11, String str) {
        String str2;
        int i12;
        try {
            if (d(context)) {
                String strA = cn.jiguang.r.a.a(i9, 4);
                if (TextUtils.isEmpty(strA)) {
                    i12 = Integer.MAX_VALUE;
                } else {
                    try {
                        i12 = Integer.parseInt(strA);
                    } catch (Throwable unused) {
                        i12 = Integer.MAX_VALUE;
                    }
                }
                if (i10 > i12 || aVar.f10756k / 1000 != 1) {
                    if (aVar != null) {
                        cn.jiguang.s.b bVar = new cn.jiguang.s.b(context, aVar, i9, i10);
                        if (bVar.b() && !e(context)) {
                            str2 = "need not save event in sub process:" + bVar.f();
                        }
                        if (i11 == 0) {
                            bVar.c();
                        } else if (i11 == 1) {
                            bVar.d();
                        } else if (i11 == 2) {
                            bVar.a(str);
                        }
                        a(context, bVar, 0);
                        return;
                    }
                    return;
                }
                str2 = "no plugin ,need not save event";
            } else {
                str2 = "need not save event";
            }
            cn.jiguang.u.b.b("PluginAnalytics", str2);
        } catch (Throwable th) {
            cn.jiguang.u.b.b("PluginAnalytics", "onEvent:" + th.getMessage());
        }
    }

    private void a(Context context, cn.jiguang.s.b bVar, int i9) {
        if (context == null) {
            return;
        }
        try {
            if (i9 == 0 && bVar == null) {
                cn.jiguang.u.b.e("PluginAnalytics", "save event info is null");
                return;
            }
            if (i9 == 1) {
                if (this.f10478e) {
                    cn.jiguang.u.b.b("PluginAnalytics", "first need not report");
                    return;
                } else {
                    if (c(context)) {
                        g(context);
                        return;
                    }
                    return;
                }
            }
            synchronized (this.f10476c) {
                try {
                    List<cn.jiguang.s.b> listH = h(context);
                    if (listH == null) {
                        listH = new ArrayList<>();
                    }
                    cn.jiguang.u.b.b("PluginAnalytics", "will save event info:" + bVar.e());
                    if (listH.contains(bVar)) {
                        cn.jiguang.s.b bVar2 = listH.get(listH.indexOf(bVar));
                        bVar2.a(bVar);
                        cn.jiguang.u.b.b("PluginAnalytics", "just update,need not add:" + bVar2.e());
                    } else {
                        listH.add(bVar);
                    }
                    if (listH.size() >= 200) {
                        listH.remove(0);
                    }
                    a(context, listH);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.u.b.e("PluginAnalytics", "saveAction failed:" + th2.getMessage());
        }
    }

    private void a(Context context, List<cn.jiguang.s.b> list) {
        String strI;
        String string;
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i9 = 0; i9 < list.size(); i9++) {
                jSONArray.put(new JSONObject(list.get(i9).e()));
            }
            if (!c(context) || this.f10478e) {
                strI = i(context);
                string = jSONArray.toString();
            } else {
                strI = i(context) + ".tmp";
                string = jSONArray.toString();
            }
            cn.jiguang.v.c.a(context, strI, string);
            cn.jiguang.u.b.b("PluginAnalytics", "saveObjects finished");
        } catch (Throwable th) {
            cn.jiguang.u.b.e("PluginAnalytics", "[saveObjects] failed:" + th.getMessage());
        }
    }

    public void a(Context context, boolean z8) {
        cn.jiguang.u.b.b("PluginAnalytics", "[setNeedReport] enable:" + z8);
        this.f10474a = Boolean.valueOf(z8);
        A.f.l(f(context), "need_report", z8);
    }
}

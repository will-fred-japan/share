package cn.jiguang.ak;

import android.content.Context;
import cn.jiguang.api.ReportCallBack;
import cn.jpush.android.api.InAppSlotParams;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.engagelab.privates.common.sentry.SentryCrashHandler;
import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f9217a = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9219c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f9218b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f9220d = new g();

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return SentryCrashHandler.PATH + File.separator + cn.jiguang.aw.f.a() + SentryCrashHandler.SUFFIX_ENVELOPE_FILE;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        cn.jiguang.x.f.c("SentryCrashHandler", "uncaughtException");
        a(b(thread, th));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f9218b;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    public static h a() {
        return f9217a;
    }

    private Throwable b(Thread thread, Throwable th) {
        cn.jiguang.al.c cVar = new cn.jiguang.al.c();
        cVar.a(Boolean.FALSE);
        cVar.a("UncaughtExceptionHandler");
        return new c(cVar, th, thread);
    }

    public void b() {
        cn.jiguang.x.f.c("SentryCrashHandler", "setUncaughtExceptionHandler");
        if (this.f9218b == null) {
            this.f9218b = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private JSONObject a(Context context, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "sentry_crash_log");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectA = d.a(context, th);
            if (jSONObjectA != null && jSONObjectA.length() != 0) {
                jSONObject2.put("sentry_envelope_item_header", d.a(InAppSlotParams.SLOT_KEY.EVENT));
                jSONObject2.put("sentry_envelope_item", jSONObjectA);
                jSONArray.put(jSONObject2);
                jSONObject.put("sentry_envelope_header", d.a(true));
                JSONObject jSONObject3 = new JSONObject();
                cn.jiguang.al.i iVarA = this.f9220d.a();
                iVarA.a(cn.jiguang.al.i.a.Crashed, "", true);
                jSONObject3.put("sentry_envelope_item_header", d.a("session"));
                jSONObject3.put("sentry_envelope_item", d.a(context, iVarA));
                jSONArray.put(jSONObject3);
                jSONObject.put("sentry_envelope_items", jSONArray);
                return jSONObject;
            }
            return null;
        } catch (Throwable th2) {
            cn.jiguang.x.f.l("SentryCrashHandler", "generalJSONLog error : " + th2.getMessage());
            return null;
        }
    }

    public void b(final Context context) {
        cn.jiguang.av.d.a("DELAY_TASK", new cn.jiguang.av.b() { // from class: cn.jiguang.ak.h.2
            @Override // cn.jiguang.av.b
            public void a() {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getFilesDir().getAbsolutePath());
                File file = new File(A.a.j(sb, File.separator, SentryCrashHandler.PATH));
                if (file.exists() && file.isDirectory() && file.canWrite() && file.canRead()) {
                    for (File file2 : file.listFiles(new FilenameFilter() { // from class: cn.jiguang.ak.h.2.1
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file3, String str) {
                            return str.endsWith(SentryCrashHandler.SUFFIX_ENVELOPE_FILE);
                        }
                    })) {
                        String str = SentryCrashHandler.PATH + File.separator + file2.getName();
                        JSONObject jSONObjectA = cn.jiguang.aw.j.a(str);
                        if (jSONObjectA != null) {
                            h.this.a(context, jSONObjectA, str);
                        }
                    }
                }
            }
        }, 10000L);
    }

    public void a(final Context context) {
        cn.jiguang.x.f.c("SentryCrashHandler", TCPTimingCache.P_INIT);
        this.f9220d.b();
        cn.jiguang.av.d.a("FUTURE_TASK", new cn.jiguang.av.b() { // from class: cn.jiguang.ak.h.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // cn.jiguang.av.b
            public void a() {
                try {
                    cn.jiguang.al.i iVarA = h.this.f9220d.a();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sentry_envelope_header", d.a(false));
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sentry_envelope_item_header", d.a("session"));
                    jSONObject2.put("sentry_envelope_item", d.a(context, iVarA));
                    jSONArray.put(jSONObject2);
                    jSONObject.put("sentry_envelope_items", jSONArray);
                    jSONObject.put("type", "sentry_crash_log");
                    cn.jiguang.x.f.c("SentryCrashHandler", "session is " + jSONObject.toString());
                    h hVar = h.this;
                    hVar.f9219c = hVar.c();
                    cn.jiguang.aw.j.a(h.this.f9219c, jSONObject);
                    h hVar2 = h.this;
                    hVar2.a(context, jSONObject, hVar2.f9219c);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void a(final Context context, final JSONObject jSONObject, final String str) {
        if (context == null) {
            cn.jiguang.x.f.i("SentryCrashHandler", "Action - reportCrashLog context is null");
        } else if (cn.jiguang.d.b.a(context)) {
            try {
                cn.jiguang.av.d.a("FUTURE_TASK", new cn.jiguang.av.b() { // from class: cn.jiguang.ak.h.3
                    @Override // cn.jiguang.av.b
                    public void a() {
                        cn.jiguang.z.g.a(context, jSONObject, new ReportCallBack() { // from class: cn.jiguang.ak.h.3.1
                            @Override // cn.jiguang.api.ReportCallBack
                            public void onFinish(int i9) {
                                if (i9 == 0) {
                                    cn.jiguang.aw.j.d(str);
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                W5.f.m("report crash e:", "SentryCrashHandler", th);
            }
        }
    }

    public void a(Thread thread, Throwable th) {
        cn.jiguang.x.f.c("SentryCrashHandler", "handleException catch exception");
        a(th);
    }

    public void a(Throwable th) {
        Context contextA = cn.jiguang.aw.d.a(null);
        if (contextA == null) {
            cn.jiguang.x.f.i("SentryCrashHandler", "handleException context is null");
            return;
        }
        d.b(contextA, th);
        if (i.a()) {
            try {
                JSONObject jSONObjectA = a(contextA, th);
                if (jSONObjectA == null) {
                    return;
                }
                cn.jiguang.x.f.c("SentryCrashHandler", "crash log is : " + jSONObjectA.toString());
                String strC = c();
                this.f9219c = strC;
                cn.jiguang.aw.j.a(strC, jSONObjectA);
                a(contextA, jSONObjectA, this.f9219c);
            } catch (Throwable unused) {
            }
        }
    }
}

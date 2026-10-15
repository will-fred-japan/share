package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.push.sdk.IPushExtensionService;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.ad;
import com.vivo.push.util.ag;
import com.vivo.push.util.ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n f16690a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f16697h;
    private String j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Boolean f16701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Long f16702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f16703o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f16705q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16691b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16692c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16693d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f16694e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f16695f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f16696g = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16698i = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SparseArray<a> f16699k = new SparseArray<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f16700l = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f16706r = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private IPushClientFactory f16704p = new m();

    private n() {
    }

    public static List<String> c() {
        String strG = com.vivo.push.restructure.a.a().e().g();
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(strG)) {
                Iterator<String> itKeys = new JSONObject(strG).keys();
                while (itKeys.hasNext()) {
                    arrayList.add(itKeys.next());
                }
            }
        } catch (JSONException unused) {
            com.vivo.push.restructure.a.a().e().h();
            arrayList.clear();
            com.vivo.push.util.w.d("PushClientManager", "getTags error");
        }
        return arrayList;
    }

    private boolean m() {
        if (this.f16701m == null) {
            this.f16701m = Boolean.valueOf(l() >= 1230 && ak.d(this.f16697h));
        }
        return this.f16701m.booleanValue();
    }

    public final boolean d() {
        if (this.f16697h == null) {
            com.vivo.push.util.w.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean boolValueOf = Boolean.valueOf(m());
        this.f16701m = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public final void e() {
        this.j = null;
        com.vivo.push.restructure.a.a().e().j();
    }

    public final boolean f() {
        return this.f16703o;
    }

    public final boolean g() {
        return this.f16698i;
    }

    public final Context h() {
        return this.f16697h;
    }

    public final String i() {
        return this.j;
    }

    public final int j() {
        return this.f16705q;
    }

    public final boolean k() {
        return this.f16706r;
    }

    public final long l() {
        Context context = this.f16697h;
        if (context == null) {
            return -1L;
        }
        if (this.f16702n == null) {
            this.f16702n = Long.valueOf(ak.a(context));
        }
        return this.f16702n.longValue();
    }

    public static synchronized n a() {
        try {
            if (f16690a == null) {
                f16690a = new n();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f16690a;
    }

    public final void b() throws VivoPushException {
        Context context = this.f16697h;
        if (context != null) {
            ak.b(context);
        }
    }

    public final void b(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 11);
    }

    /* JADX INFO: compiled from: PushClientManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IPushActionListener f16707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.vivo.push.b.c f16708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private IPushActionListener f16709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Runnable f16710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Object[] f16711e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f16708b = cVar;
            this.f16707a = iPushActionListener;
        }

        public final void a(int i9, Object... objArr) {
            this.f16711e = objArr;
            IPushActionListener iPushActionListener = this.f16709c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i9);
            }
            IPushActionListener iPushActionListener2 = this.f16707a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i9);
            }
        }

        public final Object[] b() {
            return this.f16711e;
        }

        public final void a(Runnable runnable) {
            this.f16710d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f16710d;
            if (runnable == null) {
                com.vivo.push.util.w.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f16709c = iPushActionListener;
        }
    }

    public final synchronized void a(Context context) {
        if (this.f16697h == null) {
            this.f16697h = ContextDelegate.getContext(context);
            this.f16703o = ad.c(context, context.getPackageName());
            ag.c().a(this.f16697h);
            a(new com.vivo.push.b.g());
            this.j = com.vivo.push.restructure.a.a().e().i();
        }
    }

    public final void b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f16697h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.j)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!a(this.f16694e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.f16703o) {
            if (!m()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f16697h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f16694e = SystemClock.elapsedRealtime();
        String strA = a(new a(aVar, iPushActionListener));
        aVar.b(strA);
        a(aVar);
        c(strA);
    }

    public final void c(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 1);
    }

    private static IPushExtensionService c(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            Context contextB = com.vivo.push.restructure.a.a().b();
            if (!"com.vivo.push.sdk.action.receive_extension_message".equals(intent.getAction())) {
                com.vivo.push.util.w.c("PushClientManager", "getPushExtensionCallback return, not extension intent");
                return null;
            }
            String strB = com.vivo.push.restructure.a.a().e().b(contextB, intent.getAction());
            com.vivo.push.util.w.c("PushClientManager", "extensionServiceClassName:".concat(String.valueOf(strB)));
            return (IPushExtensionService) Class.forName(strB).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e9) {
            com.vivo.push.util.w.a("PushClientManager", "getPushExtensionCallback error", e9);
            return null;
        }
    }

    public final void a(List<String> list) {
        if (list.contains(this.j)) {
            e();
        }
    }

    public final void a(boolean z8) {
        this.f16698i = z8;
    }

    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f16697h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        com.vivo.push.restructure.a.a().h().b();
        if (!a(this.f16691b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f16691b = SystemClock.elapsedRealtime();
        String packageName = this.f16697h.getPackageName();
        a aVarA = null;
        if (this.f16697h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.f();
            bVar.c(str);
            bVar.d(str2);
            bVar.b(100);
            if (!this.f16703o || m()) {
                aVarA = a(bVar, iPushActionListener);
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVarA == null) {
            return;
        }
        aVarA.a(new o(this, aVarA, str, str2));
        aVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        u.a(new s(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a b(String str) {
        if (str != null) {
            try {
                int i9 = Integer.parseInt(str);
                a aVar = this.f16699k.get(i9);
                this.f16699k.delete(i9);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f16697h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f16696g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f16696g = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.f16703o) {
            if (!m()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(false, this.f16697h.getPackageName(), arrayList);
        aaVar.b(500);
        aaVar.c(str);
        aaVar.d(str2);
        String strA = a(new a(aaVar, iPushActionListener));
        aaVar.b(strA);
        a(aaVar);
        c(strA);
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String strA = a(aVar);
        bVar.b(strA);
        aVar.a(new p(this, bVar, strA));
        return aVar;
    }

    private void a(IPushActionListener iPushActionListener, String str, String str2, int i9) {
        if (this.f16697h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else {
            if (a(this.f16692c)) {
                this.f16692c = SystemClock.elapsedRealtime();
                a aVarA = a(iPushActionListener, this.f16697h.getPackageName(), str, str2, i9);
                if (aVarA == null) {
                    return;
                }
                aVarA.a(new q(this));
                aVarA.a();
                return;
            }
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        }
    }

    private a a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i9) {
        if (this.f16697h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, str);
        bVar.c(str2);
        bVar.d(str3);
        if (i9 > 0) {
            bVar.a(i9);
        }
        bVar.f();
        bVar.b(100);
        if (this.f16703o) {
            if (!m()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(bVar, iPushActionListener);
            String strA = a(aVar);
            bVar.b(strA);
            aVar.a(new RunnableC0592r(this, bVar, strA));
            return aVar;
        }
        if (bVar.a(this.f16697h) == 2) {
            return a(bVar, iPushActionListener);
        }
        return a(bVar, iPushActionListener);
    }

    private static PushMessageCallback b(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            return (PushMessageCallback) Class.forName(com.vivo.push.restructure.a.a().e().a(com.vivo.push.restructure.a.a().b(), intent.getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e9) {
            com.vivo.push.util.w.b("PushClientManager", "reflect e: ", e9);
            return null;
        }
    }

    public final void b(boolean z8) {
        com.vivo.push.util.w.c("PushClientManager", "setIsOpenVivoPhoneCheck:".concat(String.valueOf(z8)));
        this.f16706r = z8;
    }

    public final void a(String str, int i9, Object... objArr) {
        a aVarB = b(str);
        if (aVarB != null) {
            aVarB.a(i9, objArr);
        } else {
            com.vivo.push.util.w.d("PushClientManager", "notifyApp token is null");
        }
    }

    public final void a(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f16697h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (!com.vivo.push.restructure.a.a().g().f()) {
            if (!TextUtils.isEmpty(this.j) && this.j.equals(str)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                    return;
                }
                return;
            }
            if (str.length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30003);
                    return;
                }
                return;
            } else if (this.f16703o) {
                if (!m()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(30001);
                        return;
                    }
                    return;
                }
            }
        }
        if (!a(this.f16693d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f16697h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f16693d = SystemClock.elapsedRealtime();
        String strA = a(new a(aVar, iPushActionListener));
        aVar.b(strA);
        a(aVar);
        c(strA);
    }

    public static boolean a(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return j == -1 || jElapsedRealtime <= j || jElapsedRealtime >= j + 2000;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public final void a(String str) {
        this.j = str;
        com.vivo.push.restructure.a.a().e().e(str);
    }

    public final void a(String str, int i9) {
        a aVarB = b(str);
        if (aVarB != null) {
            aVarB.a(i9, new Object[0]);
        } else {
            com.vivo.push.util.w.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i9;
        this.f16699k.put(this.f16700l, aVar);
        i9 = this.f16700l;
        this.f16700l = i9 + 1;
        return Integer.toString(i9);
    }

    public final void a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f16697h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f16695f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f16695f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        if (arrayList.size() + c().size() > 500) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20004);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.f16703o) {
            if (!m()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(true, this.f16697h.getPackageName(), arrayList);
        aaVar.b(500);
        aaVar.c(str);
        aaVar.d(str2);
        String strA = a(new a(aaVar, iPushActionListener));
        aaVar.b(strA);
        a(aaVar);
        c(strA);
    }

    public final int a(Intent intent) {
        w wVarCreateReceiverCommand = this.f16704p.createReceiverCommand(intent);
        Context context = a().f16697h;
        if (wVarCreateReceiverCommand == null) {
            com.vivo.push.util.w.a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            com.vivo.push.util.w.c("[执行指令失败]指令空！");
            return 2805;
        }
        com.vivo.push.h.ag agVarCreateReceiveTask = this.f16704p.createReceiveTask(wVarCreateReceiverCommand);
        if (agVarCreateReceiveTask == null) {
            com.vivo.push.util.w.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(wVarCreateReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            com.vivo.push.util.w.c("[执行指令失败]指令" + wVarCreateReceiverCommand + "任务空！");
            return 2806;
        }
        if (context != null && !(wVarCreateReceiverCommand instanceof com.vivo.push.b.o)) {
            com.vivo.push.util.w.a("[接收指令]".concat(String.valueOf(wVarCreateReceiverCommand)));
        }
        com.vivo.push.util.w.c("PushClientManager", "pushReceiveTask:" + agVarCreateReceiveTask.getClass());
        if (agVarCreateReceiveTask instanceof com.vivo.push.h.p) {
            IPushExtensionService iPushExtensionServiceC = c(intent);
            if (iPushExtensionServiceC == null) {
                return 2814;
            }
            ((com.vivo.push.h.p) agVarCreateReceiveTask).a(iPushExtensionServiceC);
        } else {
            PushMessageCallback pushMessageCallbackB = b(intent);
            if (pushMessageCallbackB == null) {
                return 2804;
            }
            agVarCreateReceiveTask.a(pushMessageCallbackB);
        }
        agVarCreateReceiveTask.run();
        return agVarCreateReceiveTask.b();
    }

    public final void a(w wVar) {
        Context context = a().f16697h;
        if (wVar == null) {
            com.vivo.push.util.w.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.w.c("[执行指令失败]指令空！");
                return;
            }
            return;
        }
        t tVarCreateTask = this.f16704p.createTask(wVar);
        if (tVarCreateTask == null) {
            com.vivo.push.util.w.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(wVar)));
            if (context != null) {
                com.vivo.push.util.w.c("[执行指令失败]指令" + wVar + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.w.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(wVar)));
        u.a(tVarCreateTask, w.c());
    }
}

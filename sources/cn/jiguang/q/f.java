package cn.jiguang.q;

import android.content.Context;
import android.os.Message;
import androidx.datastore.preferences.protobuf.C0524s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private cn.jiguang.o.a f10710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private cn.jiguang.p.a f10711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private cn.jiguang.p.b f10712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10713d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f10716a = new f();
    }

    private f() {
        this.f10713d = System.currentTimeMillis();
    }

    public static f a() {
        return a.f10716a;
    }

    private synchronized cn.jiguang.p.a b(Context context) {
        try {
            cn.jiguang.p.b bVar = this.f10712c;
            if (bVar == null || bVar.getState() == Thread.State.TERMINATED) {
                this.f10712c = new cn.jiguang.p.b("jg_wk_thread");
            }
            if (this.f10712c.getState() == Thread.State.NEW) {
                this.f10712c.start();
                this.f10711b = null;
            }
            if (this.f10711b == null) {
                this.f10711b = new cn.jiguang.p.a(context, this.f10712c.getLooper());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10711b;
    }

    private void b(Context context, cn.jiguang.o.c cVar) {
        cn.jiguang.x.f.c("JWakeTaskHelper", "the delay w task time up, start to process it, tPkg: " + cVar.f10665a);
        List<cn.jiguang.o.b> listA = cn.jiguang.n.a.a(context, (List<cn.jiguang.o.c>) new ArrayList<cn.jiguang.o.c>(cVar) { // from class: cn.jiguang.q.f.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ cn.jiguang.o.c f10714a;

            {
                this.f10714a = cVar;
                add(cVar);
            }
        });
        if (listA == null || listA.isEmpty()) {
            return;
        }
        c.a(context, this.f10710a, listA);
        cn.jiguang.o.a aVar = this.f10710a;
        if ((aVar.f10659w || aVar.f10660x) && !listA.isEmpty()) {
            a(context);
        }
    }

    public void a(Context context) {
        String str;
        try {
            if (cn.jiguang.d.a.f(context) <= 0) {
                str = "[First Wake] not registered yet, skip first wake report";
            } else {
                if (!cn.jiguang.i.b.f(context)) {
                    cn.jiguang.x.f.c("JWakeTaskHelper", "[First Wake] first wake detected, trigger immediate report");
                    cn.jiguang.n.d.d().a(context);
                    return;
                }
                str = "[First Wake] first wake already reported, skip";
            }
            cn.jiguang.x.f.c("JWakeTaskHelper", str);
        } catch (Throwable th) {
            W5.e.t(th, new StringBuilder("[First Wake] checkAndTriggerFirstWakeReport error:"), "JWakeTaskHelper");
        }
    }

    public void a(Context context, int i9, Object obj) {
        if (i9 == 1000 && (obj instanceof cn.jiguang.o.c)) {
            b(context, (cn.jiguang.o.c) obj);
        }
    }

    public void a(Context context, cn.jiguang.o.a aVar, List<cn.jiguang.o.c> list) {
        this.f10710a = aVar;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (cn.jiguang.o.c cVar : list) {
                if (a(cVar.f10674k * 1000)) {
                    arrayList.add(cVar);
                    a(context, cVar);
                }
            }
            if (!arrayList.isEmpty()) {
                list.removeAll(arrayList);
            }
        }
        int size = list != null ? list.size() : 0;
        StringBuilder sbA = C0524s.a(size, "start w task, wakeTarget size: ", ", dWakeTarget size: ");
        sbA.append(arrayList.size());
        cn.jiguang.x.f.c("JWakeTaskHelper", sbA.toString());
        if (size > 0) {
            List<cn.jiguang.o.b> listA = cn.jiguang.n.a.a(context, list);
            c.a(context, this.f10710a, listA);
            if (aVar.f10659w || aVar.f10660x) {
                if (listA == null || !listA.isEmpty()) {
                    a(context);
                }
            }
        }
    }

    private void a(Context context, cn.jiguang.o.c cVar) {
        long jMax = Math.max(0L, ((long) (cVar.f10674k * 1000)) - Math.max(0L, System.currentTimeMillis() - this.f10713d));
        Message messageObtain = Message.obtain();
        messageObtain.what = 1000;
        messageObtain.obj = cVar;
        b(context).sendMessageDelayed(messageObtain, jMax);
        cn.jiguang.x.f.c("JWakeTaskHelper", "add delay w task, delayTime: " + jMax + ", tPkg: " + cVar.f10665a);
    }

    public void a(Context context, List<cn.jiguang.o.c> list) {
        cn.jiguang.o.a aVarB = b.b(context);
        a(context, aVarB, cn.jiguang.n.a.a(context, aVarB, list));
    }

    public void a(Context context, boolean z8) {
        if (z8) {
            this.f10713d = System.currentTimeMillis();
        }
    }

    public boolean a(int i9) {
        return cn.jiguang.aa.b.f8825b.get() && i9 > 0 && System.currentTimeMillis() - this.f10713d < ((long) i9);
    }
}

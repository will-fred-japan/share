package cn.jiguang.ak;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f9242a;

    public j(k kVar) {
        this.f9242a = kVar;
    }

    private cn.jiguang.al.d a(Throwable th, cn.jiguang.al.c cVar, Thread thread, boolean z8) {
        Package r8 = th.getClass().getPackage();
        String name = th.getClass().getName();
        cn.jiguang.al.d dVar = new cn.jiguang.al.d();
        String message = th.getMessage();
        if (r8 != null) {
            name = name.replace(r8.getName() + ".", "");
        }
        String name2 = r8 != null ? r8.getName() : null;
        List<cn.jiguang.al.f> listA = this.f9242a.a(th.getStackTrace());
        if (listA != null && !listA.isEmpty()) {
            if (!a(thread) && !a(listA)) {
                return null;
            }
            cn.jiguang.al.g gVar = new cn.jiguang.al.g(listA);
            if (z8) {
                gVar.a(Boolean.TRUE);
            }
            dVar.a(gVar);
        }
        if (thread != null) {
            dVar.a(Long.valueOf(thread.getId()));
        }
        dVar.a(name);
        dVar.a(cVar);
        dVar.c(name2);
        dVar.b(message);
        return dVar;
    }

    public Deque<cn.jiguang.al.d> b(Throwable th) {
        Thread threadCurrentThread;
        boolean zD;
        cn.jiguang.al.c cVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th != null && hashSet.add(th)) {
            if (th instanceof c) {
                c cVar2 = (c) th;
                cn.jiguang.al.c cVarA = cVar2.a();
                Throwable thB = cVar2.b();
                threadCurrentThread = cVar2.c();
                zD = cVar2.d();
                th = thB;
                cVar = cVarA;
            } else {
                threadCurrentThread = Thread.currentThread();
                zD = false;
                cVar = null;
            }
            cn.jiguang.al.d dVarA = a(th, cVar, threadCurrentThread, zD);
            if (dVarA != null) {
                arrayDeque.addFirst(dVarA);
            }
            th = th.getCause();
        }
        return arrayDeque;
    }

    public List<cn.jiguang.al.d> a(Throwable th) {
        return a(b(th));
    }

    private List<cn.jiguang.al.d> a(Deque<cn.jiguang.al.d> deque) {
        return new ArrayList(deque);
    }

    public boolean a(Thread thread) {
        if (thread.getName() != null) {
            return thread.getName().contains("jg");
        }
        return false;
    }

    public boolean a(List<cn.jiguang.al.f> list) {
        Iterator<cn.jiguang.al.f> it = list.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            z8 = z8 || it.next().h().booleanValue();
            if (z8) {
                break;
            }
        }
        return z8;
    }
}

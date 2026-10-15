package cn.jiguang.ak;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f9243a;

    public l(k kVar) {
        this.f9243a = kVar;
    }

    private cn.jiguang.al.h a(boolean z8, StackTraceElement[] stackTraceElementArr, Thread thread) {
        cn.jiguang.al.h hVar = new cn.jiguang.al.h();
        hVar.a(thread.getName());
        hVar.a(Integer.valueOf(thread.getPriority()));
        hVar.a(Long.valueOf(thread.getId()));
        hVar.c(Boolean.valueOf(thread.isDaemon()));
        hVar.b(thread.getState().name());
        hVar.a(Boolean.valueOf(z8));
        hVar.b(Boolean.valueOf(cn.jiguang.as.a.a(thread)));
        cn.jiguang.al.g gVar = new cn.jiguang.al.g(this.f9243a.a(stackTraceElementArr));
        gVar.a(Boolean.TRUE);
        hVar.a(gVar);
        return hVar;
    }

    public List<cn.jiguang.al.h> a(List<Long> list) {
        return a(Thread.getAllStackTraces(), list);
    }

    public List<cn.jiguang.al.h> a(Map<Thread, StackTraceElement[]> map, List<Long> list) {
        Thread threadCurrentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(threadCurrentThread)) {
            map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            Thread key = entry.getKey();
            arrayList.add(a(key == threadCurrentThread || (list != null && list.contains(Long.valueOf(key.getId()))), entry.getValue(), entry.getKey()));
        }
        return arrayList;
    }
}

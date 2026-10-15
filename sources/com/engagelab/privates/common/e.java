package com.engagelab.privates.common;

import com.engagelab.privates.common.sentry.entity.SentryStackTrace;
import com.engagelab.privates.common.sentry.entity.SentryThread;
import com.engagelab.privates.common.sentry.util.MainThreadChecker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f12196a;

    public e(d dVar) {
        this.f12196a = dVar;
    }

    public List<SentryThread> a(List<Long> list) {
        return a(Thread.getAllStackTraces(), list);
    }

    public List<SentryThread> a(Map<Thread, StackTraceElement[]> map, List<Long> list) {
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

    public final SentryThread a(boolean z8, StackTraceElement[] stackTraceElementArr, Thread thread) {
        SentryThread sentryThread = new SentryThread();
        sentryThread.setName(thread.getName());
        sentryThread.setPriority(Integer.valueOf(thread.getPriority()));
        sentryThread.setId(Long.valueOf(thread.getId()));
        sentryThread.setDaemon(Boolean.valueOf(thread.isDaemon()));
        sentryThread.setState(thread.getState().name());
        sentryThread.setCrashed(Boolean.valueOf(z8));
        sentryThread.setCurrent(Boolean.valueOf(MainThreadChecker.isMainThread(thread)));
        SentryStackTrace sentryStackTrace = new SentryStackTrace(this.f12196a.a(stackTraceElementArr));
        sentryStackTrace.setSnapshot(Boolean.TRUE);
        sentryThread.setStacktrace(sentryStackTrace);
        return sentryThread;
    }
}

package com.engagelab.privates.common;

import com.engagelab.privates.common.sentry.ExceptionMechanismException;
import com.engagelab.privates.common.sentry.entity.Mechanism;
import com.engagelab.privates.common.sentry.entity.SentryException;
import com.engagelab.privates.common.sentry.entity.SentryStackFrame;
import com.engagelab.privates.common.sentry.entity.SentryStackTrace;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f12180a;

    public c(d dVar) {
        this.f12180a = dVar;
    }

    public final List<SentryException> a(Deque<SentryException> deque) {
        return new ArrayList(deque);
    }

    public List<SentryException> b(Throwable th) {
        return a(a(th));
    }

    public final SentryException a(Throwable th, Mechanism mechanism, Thread thread, boolean z8) {
        Package r8 = th.getClass().getPackage();
        String name = th.getClass().getName();
        SentryException sentryException = new SentryException();
        String message = th.getMessage();
        if (r8 != null) {
            name = name.replace(r8.getName() + ".", "");
        }
        String name2 = r8 != null ? r8.getName() : null;
        List<SentryStackFrame> listA = this.f12180a.a(th.getStackTrace());
        if (listA != null && !listA.isEmpty()) {
            if (!a(thread) && !a(listA)) {
                return null;
            }
            SentryStackTrace sentryStackTrace = new SentryStackTrace(listA);
            if (z8) {
                sentryStackTrace.setSnapshot(Boolean.TRUE);
            }
            sentryException.setStacktrace(sentryStackTrace);
        }
        if (thread != null) {
            sentryException.setThreadId(Long.valueOf(thread.getId()));
        }
        sentryException.setType(name);
        sentryException.setMechanism(mechanism);
        sentryException.setModule(name2);
        sentryException.setValue(message);
        return sentryException;
    }

    public Deque<SentryException> a(Throwable th) {
        Thread threadCurrentThread;
        boolean zIsSnapshot;
        Mechanism mechanism;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th != null && hashSet.add(th)) {
            if (th instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) th;
                Mechanism exceptionMechanism = exceptionMechanismException.getExceptionMechanism();
                Throwable throwable = exceptionMechanismException.getThrowable();
                threadCurrentThread = exceptionMechanismException.getThread();
                zIsSnapshot = exceptionMechanismException.isSnapshot();
                th = throwable;
                mechanism = exceptionMechanism;
            } else {
                threadCurrentThread = Thread.currentThread();
                zIsSnapshot = false;
                mechanism = null;
            }
            SentryException sentryExceptionA = a(th, mechanism, threadCurrentThread, zIsSnapshot);
            if (sentryExceptionA != null) {
                arrayDeque.addFirst(sentryExceptionA);
            }
            th = th.getCause();
        }
        return arrayDeque;
    }

    public boolean a(List<SentryStackFrame> list) {
        Iterator<SentryStackFrame> it = list.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            z8 = z8 || it.next().isInApp().booleanValue();
            if (z8) {
                break;
            }
        }
        return z8;
    }

    public boolean a(Thread thread) {
        if (thread.getName() != null) {
            return thread.getName().contains("ENGAGELAB-PRIVATES-");
        }
        return false;
    }
}

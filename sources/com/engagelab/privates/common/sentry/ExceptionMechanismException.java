package com.engagelab.privates.common.sentry;

import com.engagelab.privates.common.sentry.entity.Mechanism;

/* JADX INFO: loaded from: classes.dex */
public final class ExceptionMechanismException extends RuntimeException {
    private static final long serialVersionUID = 142345454265713915L;
    private final Mechanism exceptionMechanism;
    private final boolean snapshot;
    private final Thread thread;
    private final Throwable throwable;

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread, boolean z8) {
        this.exceptionMechanism = mechanism;
        this.throwable = th;
        this.thread = thread;
        this.snapshot = z8;
    }

    public Mechanism getExceptionMechanism() {
        return this.exceptionMechanism;
    }

    public Thread getThread() {
        return this.thread;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSnapshot() {
        return this.snapshot;
    }

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread) {
        this(mechanism, th, thread, false);
    }
}

package com.engagelab.privates.common.sentry.entity;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationNotResponding extends RuntimeException {
    private static final long serialVersionUID = 252541144579117016L;
    private final Thread thread;

    public ApplicationNotResponding(String str, Thread thread) {
        super(str);
        this.thread = thread;
        setStackTrace(thread.getStackTrace());
    }

    public Thread getThread() {
        return this.thread;
    }
}

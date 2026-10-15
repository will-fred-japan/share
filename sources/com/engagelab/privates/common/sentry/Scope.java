package com.engagelab.privates.common.sentry;

import com.engagelab.privates.common.sentry.entity.Session;

/* JADX INFO: loaded from: classes.dex */
public final class Scope {
    private volatile Session session;
    private final Object sessionLock = new Object();

    public static final class a {
        public a(Session session, Session session2) {
        }
    }

    public Session endSession() {
        Session session;
        synchronized (this.sessionLock) {
            try {
                session = null;
                if (this.session != null) {
                    this.session.end();
                    Session sessionM4clone = this.session.m4clone();
                    this.session = null;
                    session = sessionM4clone;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return session;
    }

    public a startSession() {
        a aVar;
        synchronized (this.sessionLock) {
            try {
                if (this.session != null) {
                    this.session.end();
                }
                Session session = this.session;
                this.session = new Session();
                aVar = new a(this.session.m4clone(), session != null ? session.m4clone() : null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public Session withSession() {
        Session sessionM4clone;
        synchronized (this.sessionLock) {
            try {
                sessionM4clone = this.session != null ? this.session.m4clone() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionM4clone;
    }
}

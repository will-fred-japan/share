package com.engagelab.privates.common.sentry.entity;

import com.engagelab.privates.common.utils.DateUtil;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class Session {
    private Double duration;
    private final String environment;
    private final AtomicInteger errorCount;
    private Boolean init;
    private final String ipAddress;
    private Long sequence;
    private final UUID sessionId;
    private final Object sessionLock;
    private final Date started;
    private State status;
    private Date timestamp;
    private String userAgent;

    public enum State {
        Ok,
        Exited,
        Crashed
    }

    public Session(State state, Date date, Date date2, int i9, UUID uuid, Boolean bool, Long l8, Double d9, String str, String str2, String str3) {
        this.sessionLock = new Object();
        this.status = state;
        this.started = date;
        this.timestamp = date2;
        this.errorCount = new AtomicInteger(i9);
        this.sessionId = uuid;
        this.init = bool;
        this.sequence = l8;
        this.duration = d9;
        this.ipAddress = str;
        this.userAgent = str2;
        this.environment = str3;
    }

    private double calculateDurationTime(Date date) {
        return Math.abs(date.getTime() - this.started.getTime()) / 1000.0d;
    }

    private long getSequenceTimestamp(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    public void end() {
        end(DateUtil.getCurrentDateTime());
    }

    public int errorCount() {
        return this.errorCount.get();
    }

    public Double getDuration() {
        return this.duration;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public Boolean getInit() {
        return this.init;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public Long getSequence() {
        return this.sequence;
    }

    public UUID getSessionId() {
        return this.sessionId;
    }

    public Date getStarted() {
        Date date = this.started;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public State getStatus() {
        return this.status;
    }

    public Date getTimestamp() {
        Date date = this.timestamp;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setInitAsTrue() {
        this.init = Boolean.TRUE;
    }

    public boolean update(State state, String str, boolean z8) {
        boolean z9;
        boolean z10;
        synchronized (this.sessionLock) {
            z9 = true;
            if (state != null) {
                try {
                    this.status = state;
                    z10 = true;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                z10 = false;
            }
            if (str != null) {
                this.userAgent = str;
                z10 = true;
            }
            if (z8) {
                this.errorCount.addAndGet(1);
            } else {
                z9 = z10;
            }
            if (z9) {
                this.init = null;
                Date currentDateTime = DateUtil.getCurrentDateTime();
                this.timestamp = currentDateTime;
                if (currentDateTime != null) {
                    this.sequence = Long.valueOf(getSequenceTimestamp(currentDateTime));
                }
            }
        }
        return z9;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Session m4clone() {
        return new Session(this.status, this.started, this.timestamp, this.errorCount.get(), this.sessionId, this.init, this.sequence, this.duration, this.ipAddress, this.userAgent, this.environment);
    }

    public void end(Date date) {
        synchronized (this.sessionLock) {
            try {
                this.init = null;
                if (this.status == State.Ok) {
                    this.status = State.Exited;
                }
                if (date != null) {
                    this.timestamp = date;
                } else {
                    this.timestamp = DateUtil.getCurrentDateTime();
                }
                Date date2 = this.timestamp;
                if (date2 != null) {
                    this.duration = Double.valueOf(calculateDurationTime(date2));
                    this.sequence = Long.valueOf(getSequenceTimestamp(this.timestamp));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Session() {
        this(State.Ok, DateUtil.getCurrentDateTime(), DateUtil.getCurrentDateTime(), 0, UUID.randomUUID(), Boolean.TRUE, null, null, null, null, "production");
    }
}

package com.engagelab.privates.common.sentry.entity;

/* JADX INFO: loaded from: classes.dex */
public final class SentryException {
    private Mechanism mechanism;
    private String module;
    private SentryStackTrace stacktrace;
    private Long threadId = -1L;
    private String type;
    private String value;

    public Mechanism getMechanism() {
        return this.mechanism;
    }

    public String getModule() {
        return this.module;
    }

    public SentryStackTrace getStacktrace() {
        return this.stacktrace;
    }

    public Long getThreadId() {
        return this.threadId;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setMechanism(Mechanism mechanism) {
        this.mechanism = mechanism;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setStacktrace(SentryStackTrace sentryStackTrace) {
        this.stacktrace = sentryStackTrace;
    }

    public void setThreadId(Long l8) {
        this.threadId = l8;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}

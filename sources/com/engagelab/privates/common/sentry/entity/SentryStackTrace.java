package com.engagelab.privates.common.sentry.entity;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SentryStackTrace {
    private List<SentryStackFrame> frames;
    private Map<String, String> registers;
    private Boolean snapshot;

    public SentryStackTrace() {
    }

    public List<SentryStackFrame> getFrames() {
        return this.frames;
    }

    public Map<String, String> getRegisters() {
        return this.registers;
    }

    public Boolean getSnapshot() {
        return this.snapshot;
    }

    public void setFrames(List<SentryStackFrame> list) {
        this.frames = list;
    }

    public void setRegisters(Map<String, String> map) {
        this.registers = map;
    }

    public void setSnapshot(Boolean bool) {
        this.snapshot = bool;
    }

    public SentryStackTrace(List<SentryStackFrame> list) {
        this.frames = list;
    }
}

package com.engagelab.privates.common.sentry.entity;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Mechanism {
    private Map<String, Object> data;
    private String description;
    private Boolean handled;
    private String helpLink;
    private Map<String, Object> meta;
    private Boolean synthetic;
    private final transient Thread thread;
    private String type;

    public Mechanism() {
        this(null);
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getDescription() {
        return this.description;
    }

    public String getHelpLink() {
        return this.helpLink;
    }

    public Map<String, Object> getMeta() {
        return this.meta;
    }

    public Boolean getSynthetic() {
        return this.synthetic;
    }

    public Thread getThread() {
        return this.thread;
    }

    public String getType() {
        return this.type;
    }

    public Boolean isHandled() {
        return this.handled;
    }

    public void setData(Map<String, Object> map) {
        this.data = map;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setHandled(Boolean bool) {
        this.handled = bool;
    }

    public void setHelpLink(String str) {
        this.helpLink = str;
    }

    public void setMeta(Map<String, Object> map) {
        this.meta = map;
    }

    public void setSynthetic(Boolean bool) {
        this.synthetic = bool;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Mechanism(Thread thread) {
        this.thread = thread;
    }
}

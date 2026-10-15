package com.jieli.jl_bt_ota.model.base;

import H2.a;

/* JADX INFO: loaded from: classes.dex */
public class ThreadState {
    public static final int STATE_END = 0;
    public static final int STATE_START = 1;
    private final long id;
    private final String name;
    private int state;

    public ThreadState(long j, String str) {
        this.id = j;
        this.name = str;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getState() {
        return this.state;
    }

    public ThreadState setState(int i9) {
        this.state = i9;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ThreadState{id=");
        sb.append(this.id);
        sb.append(", name='");
        sb.append(this.name);
        sb.append("', state=");
        return a.a(sb, this.state, '}');
    }
}

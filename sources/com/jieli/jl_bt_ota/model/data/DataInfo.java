package com.jieli.jl_bt_ota.model.data;

import H2.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class DataInfo {
    public static final int DATA_TYPE_RECEIVE = 1;
    public static final int DATA_TYPE_SEND = 0;
    private final int type;

    public DataInfo(int i9) {
        this.type = i9;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return a.a(new StringBuilder("DataInfo{type="), this.type, '}');
    }
}

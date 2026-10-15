package com.jieli.jl_bt_ota.model;

import H2.a;

/* JADX INFO: loaded from: classes.dex */
public class FileOffset {
    private final int len;
    private final int offset;

    public FileOffset(int i9, int i10) {
        this.offset = i9;
        this.len = i10;
    }

    public int getLen() {
        return this.len;
    }

    public int getOffset() {
        return this.offset;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FileOffset{offset=");
        sb.append(this.offset);
        sb.append(", len=");
        return a.a(sb, this.len, '}');
    }
}

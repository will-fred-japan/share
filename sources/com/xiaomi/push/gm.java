package com.xiaomi.push;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class gm extends gg {
    public gm() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.gg
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo409a(ByteBuffer byteBuffer) {
        return m412a().length == 0 ? byteBuffer : super.mo409a(byteBuffer);
    }

    @Override // com.xiaomi.push.gg
    public int c() {
        if (m412a().length == 0) {
            return 0;
        }
        return super.c();
    }
}

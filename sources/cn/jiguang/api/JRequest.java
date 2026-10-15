package cn.jiguang.api;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class JRequest extends JProtocol {
    public JRequest(int i9, int i10, long j) {
        super(true, i9, i10, j);
    }

    public void setJuid(long j) {
        this.head.a(j);
    }

    public void setSid(int i9) {
        this.head.b(i9);
    }

    public JRequest(Object obj, ByteBuffer byteBuffer) {
        super(true, obj, byteBuffer);
    }
}

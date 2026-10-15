package cn.jiguang.api;

import H2.a;
import cn.jiguang.api.utils.ByteBufferUtils;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class JResponse extends JProtocol {
    public int code;

    public JResponse(int i9, int i10, long j, long j8, int i11, String str) {
        super(false, i9, i10, j, -1, j8);
        this.code = i11;
    }

    @Override // cn.jiguang.api.JProtocol
    public void parseBody() {
        if (isNeedParseeErrorMsg()) {
            this.code = ByteBufferUtils.getShort(this.body, this);
        }
    }

    @Override // cn.jiguang.api.JProtocol
    public String toString() {
        return a.a(new StringBuilder("JResponse{code="), this.code, '}');
    }

    @Override // cn.jiguang.api.JProtocol
    public void writeBody() {
        int i9 = this.code;
        if (i9 >= 0) {
            writeInt2(i9);
        }
    }

    public JResponse(Object obj, ByteBuffer byteBuffer) {
        super(false, obj, byteBuffer);
    }

    public JResponse(ByteBuffer byteBuffer, byte[] bArr) {
        super(false, byteBuffer, bArr);
    }
}

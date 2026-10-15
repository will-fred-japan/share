package cn.jpush.android.local;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class JPushResponse {
    public ByteBuffer body;
    public int cmd;
    public long rid;
    public long rquestId;

    public JPushResponse(int i9, long j, long j8, ByteBuffer byteBuffer) {
        this.cmd = i9;
        this.rid = j;
        this.body = byteBuffer;
        this.rquestId = j8;
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCmd() {
        return this.cmd;
    }

    public long getRid() {
        return this.rid;
    }

    public long getRquestId() {
        return this.rquestId;
    }

    public void setBody(ByteBuffer byteBuffer) {
        this.body = byteBuffer;
    }

    public void setCmd(int i9) {
        this.cmd = i9;
    }

    public void setRid(long j) {
        this.rid = j;
    }

    public void setRquestId(long j) {
        this.rquestId = j;
    }

    public String toString() {
        return "JPushResponse{cmd=" + this.cmd + ", rid=" + this.rid + ", rquestId=" + this.rquestId + '}';
    }

    public void parseBody() {
    }
}

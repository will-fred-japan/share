package com.jieli.jl_bt_ota.model.parameter;

import H2.a;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.util.CHexConver;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class FirmwareUpdateBlockParam extends BaseParameter {
    private int nextUpdateBlockLen;
    private int nextUpdateBlockOffsetAddr;

    public FirmwareUpdateBlockParam() {
    }

    public int getNextUpdateBlockLen() {
        return this.nextUpdateBlockLen;
    }

    public int getNextUpdateBlockOffsetAddr() {
        return this.nextUpdateBlockOffsetAddr;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(6);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(CHexConver.intToBigBytes(this.nextUpdateBlockOffsetAddr));
        byteBufferAllocate.put(CHexConver.int2byte2(this.nextUpdateBlockLen));
        return byteBufferAllocate.array();
    }

    public FirmwareUpdateBlockParam setNextUpdateBlockLen(int i9) {
        this.nextUpdateBlockLen = i9;
        return this;
    }

    public FirmwareUpdateBlockParam setNextUpdateBlockOffsetAddr(int i9) {
        this.nextUpdateBlockOffsetAddr = i9;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        StringBuilder sb = new StringBuilder("FirmwareUpdateBlockParam{nextUpdateBlockOffsetAddr=");
        sb.append(this.nextUpdateBlockOffsetAddr);
        sb.append(", nextUpdateBlockLen=");
        return a.a(sb, this.nextUpdateBlockLen, '}');
    }

    public FirmwareUpdateBlockParam(int i9, int i10) {
        setNextUpdateBlockOffsetAddr(i9).setNextUpdateBlockLen(i10);
    }
}

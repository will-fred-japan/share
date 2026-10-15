package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BasePacket {
    public static final int FALG_HAVE_RESPONSE = 1;
    public static final int FALG_NO_RESPONSE = 0;
    public static final int TYPE_COMMAND = 1;
    public static final int TYPE_RESPONSE = 0;
    private int hasResponse;
    private int opCode;
    private int opCodeSn = -1;
    private byte[] paramData;
    private int paramLen;
    private int status;
    private int type;
    private int unused;
    private int xmOpCode;

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            BasePacket basePacket = (BasePacket) obj;
            if (this.type == basePacket.type && this.opCode == basePacket.opCode && this.opCodeSn == basePacket.opCodeSn) {
                return true;
            }
        }
        return false;
    }

    public int getHasResponse() {
        return this.hasResponse;
    }

    public int getOpCode() {
        return this.opCode;
    }

    public int getOpCodeSn() {
        return this.opCodeSn;
    }

    public byte[] getParamData() {
        return this.paramData;
    }

    public int getParamLen() {
        return this.paramLen;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public int getUnused() {
        return this.unused;
    }

    public int getXmOpCode() {
        return this.xmOpCode;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.type), Integer.valueOf(this.opCode), Integer.valueOf(this.opCodeSn));
    }

    public boolean isCommand() {
        return this.type == 1;
    }

    public BasePacket setHasResponse(int i9) {
        this.hasResponse = i9;
        return this;
    }

    public BasePacket setOpCode(int i9) {
        this.opCode = i9;
        return this;
    }

    public BasePacket setOpCodeSn(int i9) {
        this.opCodeSn = i9;
        return this;
    }

    public BasePacket setParamData(byte[] bArr) {
        this.paramData = bArr;
        return this;
    }

    public BasePacket setParamLen(int i9) {
        this.paramLen = i9;
        return this;
    }

    public BasePacket setStatus(int i9) {
        this.status = i9;
        return this;
    }

    public BasePacket setType(int i9) {
        this.type = i9;
        return this;
    }

    public BasePacket setXmOpCode(int i9) {
        this.xmOpCode = i9;
        return this;
    }

    public String toString() {
        return "BasePacket{type=" + this.type + ", hasResponse=" + this.hasResponse + ", unused=" + this.unused + ", opCode=" + CommonUtil.formatInt(this.opCode) + ", paramLen=" + this.paramLen + ", status=" + this.status + ", opCodeSn=" + CommonUtil.formatInt(this.opCodeSn) + ", xmOpCode=" + CommonUtil.formatInt(this.xmOpCode) + ",\nparamData=" + CHexConver.byte2HexStr(this.paramData) + '}';
    }
}

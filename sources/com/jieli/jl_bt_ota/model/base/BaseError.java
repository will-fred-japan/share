package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.util.CommonUtil;

/* JADX INFO: loaded from: classes.dex */
public class BaseError {
    private int cmdSn;
    private final int code;
    private final String message;
    private int opCode;
    private final int subCode;

    public BaseError(int i9, String str) {
        this(i9, i9, str);
    }

    public int getCmdSn() {
        return this.cmdSn;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public int getOpCode() {
        return this.opCode;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public BaseError setCmdSn(int i9) {
        this.cmdSn = i9;
        return this;
    }

    public BaseError setOpCode(int i9) {
        this.opCode = i9;
        return this;
    }

    public String toString() {
        return "BaseError{subCode=" + this.subCode + ", code=" + this.code + ", message='" + this.message + "', opCode=" + CommonUtil.formatInt(this.opCode) + ", cmdSn=" + CommonUtil.formatInt(this.cmdSn) + '}';
    }

    public BaseError(int i9, int i10, String str) {
        this.opCode = -1;
        this.cmdSn = -1;
        this.code = i9;
        this.subCode = i10;
        this.message = str;
    }
}

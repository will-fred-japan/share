package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.util.CommonUtil;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class CommandBase<P extends BaseParameter, R extends CommonResponse> {
    public static final int FLAG_HAVE_PARAMETER_AND_RESPONSE = 2;
    public static final int FLAG_HAVE_PARAMETER_NO_RESPONSE = 1;
    public static final int FLAG_NO_PARAMETER_AND_RESPONSE = 0;
    public static final int FLAG_NO_PARAMETER_HAVE_RESPONSE = 3;
    private int OpCodeSn;
    private final String name;
    private final int opCode;
    private P param;
    private R response;
    private int status;
    private final int type;

    public CommandBase(int i9, String str) {
        this(i9, str, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CommandBase commandBase = (CommandBase) obj;
            if (this.OpCodeSn == commandBase.OpCodeSn && this.opCode == commandBase.opCode) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return this.opCode;
    }

    public String getName() {
        return this.name;
    }

    public int getOpCodeSn() {
        return this.OpCodeSn;
    }

    public P getParam() {
        return this.param;
    }

    public R getResponse() {
        return this.response;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.OpCodeSn), Integer.valueOf(this.opCode));
    }

    public boolean isResponseCmd() {
        int i9 = this.type;
        if (i9 != 2) {
            return i9 == 3 && this.param == null && this.response != null;
        }
        return (this.param == null || this.response == null) ? false : true;
    }

    public CommandBase setOpCodeSn(int i9) {
        this.OpCodeSn = i9;
        return this;
    }

    public CommandBase setParam(P p8) {
        this.param = p8;
        return this;
    }

    public CommandBase setResponse(R r8) {
        this.response = r8;
        return this;
    }

    public CommandBase setStatus(int i9) {
        this.status = i9;
        return this;
    }

    public String toString() {
        return "CommandBase{OpCodeSn=" + CommonUtil.formatInt(this.OpCodeSn) + ", opCode=" + CommonUtil.formatInt(this.opCode) + ", name='" + this.name + "', type=" + this.type + ", status=" + this.status + ",\n param=" + this.param + ",\n response=" + this.response + '}';
    }

    public CommandBase(int i9, String str, int i10) {
        this.opCode = i9;
        this.name = str;
        this.type = i10;
    }
}

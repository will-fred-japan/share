package com.jieli.jl_bt_ota.model.base;

import H2.a;
import com.jieli.jl_bt_ota.interfaces.command.IParamBase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class BaseParameter implements IParamBase {
    private byte[] paramData;
    private int xmOpCode = -1;

    @Override // com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i9 = this.xmOpCode;
        if (i9 != -1) {
            byteArrayOutputStream.write(i9);
        }
        byte[] bArr = this.paramData;
        if (bArr != null && bArr.length > 0) {
            try {
                byteArrayOutputStream.write(bArr);
            } catch (IOException e9) {
                e9.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getXmOpCode() {
        return this.xmOpCode;
    }

    public BaseParameter setParamData(byte[] bArr) {
        this.paramData = bArr;
        return this;
    }

    public BaseParameter setXmOpCode(int i9) {
        this.xmOpCode = i9;
        return this;
    }

    public String toString() {
        return a.a(new StringBuilder("BaseParameter{xmOpCode="), this.xmOpCode, '}');
    }
}

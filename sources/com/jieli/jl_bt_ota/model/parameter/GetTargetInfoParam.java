package com.jieli.jl_bt_ota.model.parameter;

import H2.a;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class GetTargetInfoParam extends BaseParameter {
    private int mask;
    private byte platform;

    public GetTargetInfoParam(int i9) {
        this.mask = i9;
        setPlatform((byte) 0);
    }

    public int getMask() {
        return this.mask;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(CHexConver.intToBigBytes(this.mask));
            byteArrayOutputStream.write(this.platform);
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte getPlatform() {
        return this.platform;
    }

    public GetTargetInfoParam setMask(int i9) {
        this.mask = i9;
        return this;
    }

    public GetTargetInfoParam setPlatform(byte b9) {
        this.platform = b9;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        StringBuilder sb = new StringBuilder("GetTargetInfoParam{mask=");
        sb.append(this.mask);
        sb.append(", platform=");
        return a.a(sb, this.platform, '}');
    }
}

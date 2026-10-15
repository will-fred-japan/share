package com.jieli.jl_bt_ota.model.parameter;

import A.f;
import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.util.CHexConver;

/* JADX INFO: loaded from: classes.dex */
public class NotifyUpdateContentSizeParam extends BaseParameter {
    private int contentSize;
    private int currentProgress = 0;

    public NotifyUpdateContentSizeParam(int i9) {
        this.contentSize = i9;
    }

    public int getContentSize() {
        return this.contentSize;
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        if (this.currentProgress <= 0) {
            return CHexConver.intToBigBytes(this.contentSize);
        }
        byte[] bArr = new byte[8];
        byte[] bArrIntToBigBytes = CHexConver.intToBigBytes(this.contentSize);
        byte[] bArrIntToBigBytes2 = CHexConver.intToBigBytes(this.currentProgress);
        System.arraycopy(bArrIntToBigBytes, 0, bArr, 0, bArrIntToBigBytes.length);
        System.arraycopy(bArrIntToBigBytes2, 0, bArr, bArrIntToBigBytes.length, bArrIntToBigBytes2.length);
        return bArr;
    }

    public NotifyUpdateContentSizeParam setContentSize(int i9) {
        this.contentSize = i9;
        return this;
    }

    public NotifyUpdateContentSizeParam setCurrentProgress(int i9) {
        this.currentProgress = i9;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        StringBuilder sb = new StringBuilder("NotifyUpdateContentSizeParam{contentSize=");
        sb.append(this.contentSize);
        sb.append(", currentProgress=");
        return f.i(sb, this.currentProgress, "} ");
    }
}

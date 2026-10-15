package com.jieli.jl_bt_ota.model.response;

import H2.a;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* JADX INFO: loaded from: classes.dex */
public class UpdateFileOffsetResponse extends CommonResponse {
    private int updateFileFlagLen;
    private int updateFileFlagOffset;

    public int getUpdateFileFlagLen() {
        return this.updateFileFlagLen;
    }

    public int getUpdateFileFlagOffset() {
        return this.updateFileFlagOffset;
    }

    public UpdateFileOffsetResponse setUpdateFileFlagLen(int i9) {
        this.updateFileFlagLen = i9;
        return this;
    }

    public UpdateFileOffsetResponse setUpdateFileFlagOffset(int i9) {
        this.updateFileFlagOffset = i9;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        StringBuilder sb = new StringBuilder("UpdateFileOffsetResponse{updateFileFlagOffset=");
        sb.append(this.updateFileFlagOffset);
        sb.append(", updateFileFlagLen=");
        return a.a(sb, this.updateFileFlagLen, '}');
    }
}

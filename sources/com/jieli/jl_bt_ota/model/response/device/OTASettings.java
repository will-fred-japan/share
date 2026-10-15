package com.jieli.jl_bt_ota.model.response.device;

import com.jieli.jl_bt_ota.interfaces.command.IDataOp;
import com.jieli.jl_bt_ota.util.CHexConver;
import defpackage.f;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class OTASettings implements IDataOp {
    private boolean isNeedBootLoader;
    private boolean isSupportDoubleBackup;
    private boolean isSupportReuseSpaceOTA;
    private int singleBackupOtaWay;

    public int getSingleBackupOtaWay() {
        return this.singleBackupOtaWay;
    }

    public boolean isNeedBootLoader() {
        return this.isNeedBootLoader;
    }

    public boolean isSupportDoubleBackup() {
        return this.isSupportDoubleBackup;
    }

    public boolean isSupportReuseSpaceOTA() {
        return this.isSupportReuseSpaceOTA;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public int parse(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length >= 1) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                setSupportDoubleBackup(byteBufferWrap.get() == 1);
                if (byteBufferWrap.hasRemaining()) {
                    setNeedBootLoader(byteBufferWrap.get() == 1);
                }
                if (byteBufferWrap.hasRemaining()) {
                    setSingleBackupOtaWay(CHexConver.byteToInt(byteBufferWrap.get()));
                }
                if (byteBufferWrap.hasRemaining()) {
                    setSupportReuseSpaceOTA(CHexConver.checkBitValue(byteBufferWrap.get(), 0));
                }
                return byteBufferWrap.position();
            }
        }
        return 0;
    }

    public void setNeedBootLoader(boolean z8) {
        this.isNeedBootLoader = z8;
    }

    public void setSingleBackupOtaWay(int i9) {
        this.singleBackupOtaWay = i9;
    }

    public void setSupportDoubleBackup(boolean z8) {
        this.isSupportDoubleBackup = z8;
    }

    public void setSupportReuseSpaceOTA(boolean z8) {
        this.isSupportReuseSpaceOTA = z8;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.isSupportDoubleBackup ? 1 : 0);
        byteArrayOutputStream.write(this.isNeedBootLoader ? 1 : 0);
        byteArrayOutputStream.write(this.singleBackupOtaWay);
        byteArrayOutputStream.write(CHexConver.setBitValue((byte) 0, 0, this.isSupportReuseSpaceOTA));
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OTASettings{isSupportDoubleBackup=");
        sb.append(this.isSupportDoubleBackup);
        sb.append(", isNeedBootLoader=");
        sb.append(this.isNeedBootLoader);
        sb.append(", singleBackupOtaWay=");
        sb.append(this.singleBackupOtaWay);
        sb.append(", isSupportReuseSpaceOTA=");
        return f.g(sb, this.isSupportReuseSpaceOTA, '}');
    }
}

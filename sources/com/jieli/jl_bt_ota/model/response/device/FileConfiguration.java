package com.jieli.jl_bt_ota.model.response.device;

import com.jieli.jl_bt_ota.interfaces.command.IDataOp;
import com.jieli.jl_bt_ota.util.CHexConver;
import defpackage.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileConfiguration implements IDataOp {
    private boolean getFileByNameWithDev;
    private boolean isSupportSmallFileTransfer;
    private boolean supportPackageCrc16;

    public boolean isGetFileByNameWithDev() {
        return this.getFileByNameWithDev;
    }

    public boolean isSupportPackageCrc16() {
        return this.supportPackageCrc16;
    }

    public boolean isSupportSmallFileTransfer() {
        return this.isSupportSmallFileTransfer;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public int parse(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return 0;
        }
        byte b9 = bArr[0];
        setSupportPackageCrc16(CHexConver.checkBitValue(b9, 0)).setGetFileByNameWithDev(CHexConver.checkBitValue(b9, 1)).setSupportSmallFileTransfer(CHexConver.checkBitValue(b9, 2));
        return 4;
    }

    public FileConfiguration setGetFileByNameWithDev(boolean z8) {
        this.getFileByNameWithDev = z8;
        return this;
    }

    public FileConfiguration setSupportPackageCrc16(boolean z8) {
        this.supportPackageCrc16 = z8;
        return this;
    }

    public FileConfiguration setSupportSmallFileTransfer(boolean z8) {
        this.isSupportSmallFileTransfer = z8;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[4];
            bArr[0] = CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue((byte) 0, 0, this.supportPackageCrc16), 1, this.getFileByNameWithDev), 2, this.isSupportSmallFileTransfer);
            byteArrayOutputStream.write(bArr);
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FileConfiguration{supportPackageCrc16=");
        sb.append(this.supportPackageCrc16);
        sb.append(", getFileByNameWithDev=");
        sb.append(this.getFileByNameWithDev);
        sb.append(", isSupportSmallFileTransfer=");
        return f.g(sb, this.isSupportSmallFileTransfer, '}');
    }
}

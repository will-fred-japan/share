package com.jieli.jl_bt_ota.model.response.device;

import android.bluetooth.BluetoothAdapter;
import com.jieli.jl_bt_ota.interfaces.command.IDataOp;
import com.jieli.jl_bt_ota.util.CHexConver;
import defpackage.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class BleInfo implements IDataOp {
    private String bleAddr;
    private boolean bleOnly;
    private boolean isBLEToSppWay;

    public String getBleAddr() {
        return this.bleAddr;
    }

    public boolean isBLEToSppWay() {
        return this.isBLEToSppWay;
    }

    public boolean isBleOnly() {
        return this.bleOnly;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public int parse(byte[] bArr) {
        if (bArr == null || bArr.length < 7) {
            return 0;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        setBleOnly(CHexConver.byteToInt(byteBufferWrap.get()) == 1);
        byte[] bArr2 = new byte[6];
        byteBufferWrap.get(bArr2);
        setBleAddr(CHexConver.hexDataCovetToAddress(bArr2));
        if (byteBufferWrap.hasRemaining()) {
            setBLEToSppWay(CHexConver.checkBitValue(byteBufferWrap.get(), 0));
        }
        return byteBufferWrap.position();
    }

    public BleInfo setBLEToSppWay(boolean z8) {
        this.isBLEToSppWay = z8;
        return this;
    }

    public BleInfo setBleAddr(String str) {
        this.bleAddr = str;
        return this;
    }

    public BleInfo setBleOnly(boolean z8) {
        this.bleOnly = z8;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (BluetoothAdapter.checkBluetoothAddress(this.bleAddr)) {
                byteArrayOutputStream.write(this.bleOnly ? 1 : 0);
                byteArrayOutputStream.write(CHexConver.addressCovertToByteArray(this.bleAddr));
                byteArrayOutputStream.write(CHexConver.setBitValue((byte) 0, 0, this.isBLEToSppWay));
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BleInfo{bleOnly=");
        sb.append(this.bleOnly);
        sb.append(", bleAddr='");
        sb.append(this.bleAddr);
        sb.append("', isBLEToSppWay=");
        return f.g(sb, this.isBLEToSppWay, '}');
    }
}

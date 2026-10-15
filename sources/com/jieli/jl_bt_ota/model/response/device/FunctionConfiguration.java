package com.jieli.jl_bt_ota.model.response.device;

import com.jieli.jl_bt_ota.interfaces.command.IDataOp;
import com.jieli.jl_bt_ota.util.CHexConver;
import defpackage.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class FunctionConfiguration implements IDataOp {
    private int curFunction;
    private int functionMask;
    private boolean hideNetRadio;
    private boolean supportOfflineShow;
    private boolean supportUsb = true;
    private boolean supportSd0 = true;
    private boolean supportSd1 = true;

    public int getCurFunction() {
        return this.curFunction;
    }

    public int getFunctionMask() {
        return this.functionMask;
    }

    public boolean isHideNetRadio() {
        return this.hideNetRadio;
    }

    public boolean isSupportOfflineShow() {
        return this.supportOfflineShow;
    }

    public boolean isSupportSd0() {
        return this.supportSd0;
    }

    public boolean isSupportSd1() {
        return this.supportSd1;
    }

    public boolean isSupportUsb() {
        return this.supportUsb;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public int parse(byte[] bArr) {
        if (bArr == null || bArr.length < 5) {
            return 0;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        setFunctionMask(byteBufferWrap.getInt()).setCurFunction(CHexConver.byteToInt(byteBufferWrap.get()));
        if (byteBufferWrap.hasRemaining()) {
            byte b9 = byteBufferWrap.get();
            setSupportOfflineShow(CHexConver.checkBitValue(b9, 0)).setSupportUsb(CHexConver.checkBitValue(b9, 1)).setSupportSd0(CHexConver.checkBitValue(b9, 2)).setSupportSd1(CHexConver.checkBitValue(b9, 3)).setHideNetRadio(CHexConver.checkBitValue(b9, 4));
        }
        return byteBufferWrap.position();
    }

    public FunctionConfiguration setCurFunction(int i9) {
        this.curFunction = i9;
        return this;
    }

    public FunctionConfiguration setFunctionMask(int i9) {
        this.functionMask = i9;
        return this;
    }

    public FunctionConfiguration setHideNetRadio(boolean z8) {
        this.hideNetRadio = z8;
        return this;
    }

    public FunctionConfiguration setSupportOfflineShow(boolean z8) {
        this.supportOfflineShow = z8;
        return this;
    }

    public FunctionConfiguration setSupportSd0(boolean z8) {
        this.supportSd0 = z8;
        return this;
    }

    public FunctionConfiguration setSupportSd1(boolean z8) {
        this.supportSd1 = z8;
        return this;
    }

    public FunctionConfiguration setSupportUsb(boolean z8) {
        this.supportUsb = z8;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(CHexConver.intToBigBytes(this.functionMask));
            byteArrayOutputStream.write(this.curFunction);
            byteArrayOutputStream.write(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue((byte) 0, 0, this.supportOfflineShow), 1, this.supportUsb), 2, this.supportSd0), 3, this.supportSd1), 4, this.hideNetRadio));
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FunctionConfiguration{functionMask=");
        sb.append(this.functionMask);
        sb.append(", curFunction=");
        sb.append(this.curFunction);
        sb.append(", supportOfflineShow=");
        sb.append(this.supportOfflineShow);
        sb.append(", supportUsb=");
        sb.append(this.supportUsb);
        sb.append(", supportSd0=");
        sb.append(this.supportSd0);
        sb.append(", supportSd1=");
        sb.append(this.supportSd1);
        sb.append(", hideNetRadio=");
        return f.g(sb, this.hideNetRadio, '}');
    }
}

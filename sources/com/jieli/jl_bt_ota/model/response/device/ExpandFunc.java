package com.jieli.jl_bt_ota.model.response.device;

import com.jieli.jl_bt_ota.interfaces.command.IDataOp;
import com.jieli.jl_bt_ota.util.CHexConver;
import defpackage.f;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ExpandFunc implements IDataOp {
    private boolean banEq;
    private boolean isGameMode;
    private boolean isSupportMD5;
    private boolean isSupportSearchDevice;
    private boolean supportAdaptiveANC;
    private boolean supportAnc;
    private boolean supportDevConfigure;
    private boolean supportDoubleConnection;
    private boolean supportExternalFlashTransfer;
    private boolean supportHearingAssist;
    private boolean supportReadErrorMSg;
    private boolean supportSceneDenoising;
    private boolean supportSmartNoPick;
    private boolean supportSoundCard;
    private boolean supportVocalBooster;
    private boolean supportWindNoiseDetection;

    public boolean isBanEq() {
        return this.banEq;
    }

    public boolean isGameMode() {
        return this.isGameMode;
    }

    public boolean isSupportAdaptiveANC() {
        return this.supportAdaptiveANC;
    }

    public boolean isSupportAnc() {
        return this.supportAnc;
    }

    public boolean isSupportDevConfigure() {
        return this.supportDevConfigure;
    }

    public boolean isSupportDoubleConnection() {
        return this.supportDoubleConnection;
    }

    public boolean isSupportExternalFlashTransfer() {
        return this.supportExternalFlashTransfer;
    }

    public boolean isSupportHearingAssist() {
        return this.supportHearingAssist;
    }

    public boolean isSupportMD5() {
        return this.isSupportMD5;
    }

    public boolean isSupportReadErrorMSg() {
        return this.supportReadErrorMSg;
    }

    public boolean isSupportSceneDenoising() {
        return this.supportSceneDenoising;
    }

    public boolean isSupportSearchDevice() {
        return this.isSupportSearchDevice;
    }

    public boolean isSupportSmartNoPick() {
        return this.supportSmartNoPick;
    }

    public boolean isSupportSoundCard() {
        return this.supportSoundCard;
    }

    public boolean isSupportVocalBooster() {
        return this.supportVocalBooster;
    }

    public boolean isSupportWindNoiseDetection() {
        return this.supportWindNoiseDetection;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public int parse(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return 0;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte b9 = byteBufferWrap.get();
        setSupportMD5(CHexConver.checkBitValue(b9, 0));
        setGameMode(CHexConver.checkBitValue(b9, 1));
        setSupportSearchDevice(CHexConver.checkBitValue(b9, 2));
        setSupportSoundCard(CHexConver.checkBitValue(b9, 3));
        setBanEq(CHexConver.checkBitValue(b9, 4));
        setSupportExternalFlashTransfer(CHexConver.checkBitValue(b9, 5));
        setSupportAnc(CHexConver.checkBitValue(b9, 6));
        setSupportReadErrorMSg(CHexConver.checkBitValue(b9, 7));
        if (byteBufferWrap.remaining() > 0) {
            byte b10 = byteBufferWrap.get();
            setSupportHearingAssist(CHexConver.checkBitValue(b10, 0));
            setSupportAdaptiveANC(CHexConver.checkBitValue(b10, 1));
            setSupportDevConfigure(CHexConver.checkBitValue(b10, 2));
            setSupportSmartNoPick(CHexConver.checkBitValue(b10, 3));
            setSupportSceneDenoising(CHexConver.checkBitValue(b10, 4));
            setSupportWindNoiseDetection(CHexConver.checkBitValue(b10, 5));
            setSupportVocalBooster(CHexConver.checkBitValue(b10, 6));
            setSupportDoubleConnection(CHexConver.checkBitValue(b10, 7));
        }
        return byteBufferWrap.position();
    }

    public ExpandFunc setBanEq(boolean z8) {
        this.banEq = z8;
        return this;
    }

    public ExpandFunc setGameMode(boolean z8) {
        this.isGameMode = z8;
        return this;
    }

    public ExpandFunc setSupportAdaptiveANC(boolean z8) {
        this.supportAdaptiveANC = z8;
        return this;
    }

    public ExpandFunc setSupportAnc(boolean z8) {
        this.supportAnc = z8;
        return this;
    }

    public ExpandFunc setSupportDevConfigure(boolean z8) {
        this.supportDevConfigure = z8;
        return this;
    }

    public ExpandFunc setSupportDoubleConnection(boolean z8) {
        this.supportDoubleConnection = z8;
        return this;
    }

    public ExpandFunc setSupportExternalFlashTransfer(boolean z8) {
        this.supportExternalFlashTransfer = z8;
        return this;
    }

    public ExpandFunc setSupportHearingAssist(boolean z8) {
        this.supportHearingAssist = z8;
        return this;
    }

    public ExpandFunc setSupportMD5(boolean z8) {
        this.isSupportMD5 = z8;
        return this;
    }

    public ExpandFunc setSupportReadErrorMSg(boolean z8) {
        this.supportReadErrorMSg = z8;
        return this;
    }

    public ExpandFunc setSupportSceneDenoising(boolean z8) {
        this.supportSceneDenoising = z8;
        return this;
    }

    public ExpandFunc setSupportSearchDevice(boolean z8) {
        this.isSupportSearchDevice = z8;
        return this;
    }

    public ExpandFunc setSupportSmartNoPick(boolean z8) {
        this.supportSmartNoPick = z8;
        return this;
    }

    public ExpandFunc setSupportSoundCard(boolean z8) {
        this.supportSoundCard = z8;
        return this;
    }

    public ExpandFunc setSupportVocalBooster(boolean z8) {
        this.supportVocalBooster = z8;
        return this;
    }

    public ExpandFunc setSupportWindNoiseDetection(boolean z8) {
        this.supportWindNoiseDetection = z8;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.command.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue((byte) 0, 0, this.isSupportMD5), 1, this.isGameMode), 2, this.isSupportSearchDevice), 3, this.supportSoundCard), 4, this.banEq), 5, this.supportExternalFlashTransfer), 6, this.supportAnc), 7, this.supportReadErrorMSg));
        byteArrayOutputStream.write(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue(CHexConver.setBitValue((byte) 0, 0, this.supportHearingAssist), 1, this.supportAdaptiveANC), 2, this.supportDevConfigure), 3, this.supportSmartNoPick), 4, this.supportSceneDenoising), 5, this.supportWindNoiseDetection), 6, this.supportVocalBooster), 7, this.supportDoubleConnection));
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ExpandFunc{isSupportMD5=");
        sb.append(this.isSupportMD5);
        sb.append(", isGameMode=");
        sb.append(this.isGameMode);
        sb.append(", isSupportSearchDevice=");
        sb.append(this.isSupportSearchDevice);
        sb.append(", supportSoundCard=");
        sb.append(this.supportSoundCard);
        sb.append(", banEq=");
        sb.append(this.banEq);
        sb.append(", supportExternalFlashTransfer=");
        sb.append(this.supportExternalFlashTransfer);
        sb.append(", supportAnc=");
        sb.append(this.supportAnc);
        sb.append(", supportReadErrorMSg=");
        sb.append(this.supportReadErrorMSg);
        sb.append(", supportHearingAssist=");
        sb.append(this.supportHearingAssist);
        sb.append(", supportAdaptiveANC=");
        sb.append(this.supportAdaptiveANC);
        sb.append(", supportDevConfigure=");
        return f.g(sb, this.supportDevConfigure, '}');
    }
}

package com.huawei.secure.android.common.encrypt.aes;

import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public class CipherConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Cipher f15699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f15700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f15703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15704f;

    public CipherConfig(Cipher cipher, byte[] bArr, int i9, int i10, byte[] bArr2, int i11) {
        this.f15699a = cipher;
        this.f15700b = bArr;
        this.f15701c = i9;
        this.f15702d = i10;
        this.f15703e = bArr2;
        this.f15704f = i11;
    }

    public Cipher getCipher() {
        return this.f15699a;
    }

    public byte[] getInput() {
        return this.f15700b;
    }

    public int getInputLen() {
        return this.f15702d;
    }

    public int getInputOffset() {
        return this.f15701c;
    }

    public byte[] getOutput() {
        return this.f15703e;
    }

    public int getOutputOffset() {
        return this.f15704f;
    }

    public void setCipher(Cipher cipher) {
        this.f15699a = cipher;
    }

    public void setInput(byte[] bArr) {
        this.f15700b = bArr;
    }

    public void setInputLen(int i9) {
        this.f15702d = i9;
    }

    public void setInputOffset(int i9) {
        this.f15701c = i9;
    }

    public void setOutput(byte[] bArr) {
        this.f15703e = bArr;
    }

    public void setOutputOffset(int i9) {
        this.f15704f = i9;
    }
}

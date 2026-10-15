package com.engagelab.privates.core.api;

import com.engagelab.privates.common.annotation.AllClass;

/* JADX INFO: loaded from: classes.dex */
@AllClass
public class Outputer {
    private byte[] array;
    private int pos;
    private int saved_pos;

    public Outputer(int i9) {
        this.array = new byte[i9];
        this.pos = 0;
        this.saved_pos = -1;
    }

    private void need(int i9) {
        byte[] bArr = this.array;
        int length = bArr.length;
        int i10 = this.pos;
        if (length - i10 >= i9) {
            return;
        }
        int length2 = bArr.length * 2;
        int i11 = i9 + i10;
        if (length2 < i11) {
            length2 = i11;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        this.array = bArr2;
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i9) {
        if (i9 > this.pos) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.pos = i9;
    }

    public void restore() {
        int i9 = this.saved_pos;
        if (i9 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.pos = i9;
        this.saved_pos = -1;
    }

    public void save() {
        this.saved_pos = this.pos;
    }

    public byte[] toByteArray() {
        int i9 = this.pos;
        byte[] bArr = new byte[i9];
        System.arraycopy(this.array, 0, bArr, 0, i9);
        return bArr;
    }

    public void writeByteArray(byte[] bArr, int i9, int i10) {
        need(i10);
        System.arraycopy(bArr, i9, this.array, this.pos, i10);
        this.pos += i10;
    }

    public void writeByteArrayIncludeLength(byte[] bArr) {
        writeU16(bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        need(bArr.length + 1);
        byte[] bArr2 = this.array;
        int i9 = this.pos;
        this.pos = i9 + 1;
        bArr2[i9] = (byte) (255 & bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeU16(int i9) {
        check(i9, 16);
        need(2);
        byte[] bArr = this.array;
        int i10 = this.pos;
        int i11 = i10 + 1;
        this.pos = i11;
        bArr[i10] = (byte) ((i9 >>> 8) & 255);
        this.pos = i10 + 2;
        bArr[i11] = (byte) (i9 & 255);
    }

    public void writeU16At(int i9, int i10) {
        check(i9, 16);
        if (i10 > this.pos - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i10] = (byte) ((i9 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (i9 & 255);
    }

    public void writeU32(long j) {
        check(j, 32);
        need(4);
        byte[] bArr = this.array;
        int i9 = this.pos;
        int i10 = i9 + 1;
        this.pos = i10;
        bArr[i9] = (byte) ((j >>> 24) & 255);
        int i11 = i9 + 2;
        this.pos = i11;
        bArr[i10] = (byte) ((j >>> 16) & 255);
        int i12 = i9 + 3;
        this.pos = i12;
        bArr[i11] = (byte) ((j >>> 8) & 255);
        this.pos = i9 + 4;
        bArr[i12] = (byte) (j & 255);
    }

    public void writeU32At(long j, int i9) {
        check(j, 32);
        if (i9 > this.pos - 4) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i9] = (byte) ((j >>> 24) & 255);
        bArr[i9 + 1] = (byte) ((j >>> 16) & 255);
        bArr[i9 + 2] = (byte) ((j >>> 8) & 255);
        bArr[i9 + 3] = (byte) (j & 255);
    }

    public void writeU64(long j) {
        need(8);
        byte[] bArr = this.array;
        int i9 = this.pos;
        int i10 = i9 + 1;
        this.pos = i10;
        bArr[i9] = (byte) ((j >>> 56) & 255);
        int i11 = i9 + 2;
        this.pos = i11;
        bArr[i10] = (byte) ((j >>> 48) & 255);
        int i12 = i9 + 3;
        this.pos = i12;
        bArr[i11] = (byte) ((j >>> 40) & 255);
        int i13 = i9 + 4;
        this.pos = i13;
        bArr[i12] = (byte) ((j >>> 32) & 255);
        int i14 = i9 + 5;
        this.pos = i14;
        bArr[i13] = (byte) ((j >>> 24) & 255);
        int i15 = i9 + 6;
        this.pos = i15;
        bArr[i14] = (byte) ((j >>> 16) & 255);
        int i16 = i9 + 7;
        this.pos = i16;
        bArr[i15] = (byte) ((j >>> 8) & 255);
        this.pos = i9 + 8;
        bArr[i16] = (byte) (j & 255);
    }

    public void writeU64At(long j, int i9) {
        check(j, 64);
        if (i9 > this.pos - 8) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i9] = (byte) ((j >>> 56) & 255);
        bArr[i9 + 1] = (byte) ((j >>> 48) & 255);
        bArr[i9 + 2] = (byte) ((j >>> 40) & 255);
        bArr[i9 + 3] = (byte) ((j >>> 32) & 255);
        bArr[i9 + 4] = (byte) ((j >>> 24) & 255);
        bArr[i9 + 5] = (byte) ((j >>> 16) & 255);
        bArr[i9 + 6] = (byte) ((j >>> 8) & 255);
        bArr[i9 + 7] = (byte) (j & 255);
    }

    public void writeU8(int i9) {
        check(i9, 8);
        need(1);
        byte[] bArr = this.array;
        int i10 = this.pos;
        this.pos = i10 + 1;
        bArr[i10] = (byte) (i9 & 255);
    }

    public void writeU8At(int i9, int i10) {
        check(i9, 8);
        if (i10 > this.pos - 1) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        this.array[i10] = (byte) (i9 & 255);
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public Outputer() {
        this(32);
    }

    private void check(long j, int i9) {
    }
}

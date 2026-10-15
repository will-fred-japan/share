package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class ByteVector {
    public byte[] data;
    public int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    private void enlarge(int i9) {
        byte[] bArr = this.data;
        int length = bArr.length * 2;
        int i10 = this.length;
        int i11 = i9 + i10;
        if (length <= i11) {
            length = i11;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        this.data = bArr2;
    }

    public ByteVector put11(int i9, int i10) {
        int i11 = this.length;
        if (i11 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        bArr[i11] = (byte) i9;
        bArr[i11 + 1] = (byte) i10;
        this.length = i11 + 2;
        return this;
    }

    public ByteVector put12(int i9, int i10) {
        int i11 = this.length;
        if (i11 + 3 > this.data.length) {
            enlarge(3);
        }
        byte[] bArr = this.data;
        bArr[i11] = (byte) i9;
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11 + 2] = (byte) i10;
        this.length = i11 + 3;
        return this;
    }

    public ByteVector putByte(int i9) {
        int i10 = this.length;
        int i11 = i10 + 1;
        if (i11 > this.data.length) {
            enlarge(1);
        }
        this.data[i10] = (byte) i9;
        this.length = i11;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i9, int i10) {
        if (this.length + i10 > this.data.length) {
            enlarge(i10);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i9, this.data, this.length, i10);
        }
        this.length += i10;
        return this;
    }

    public ByteVector putInt(int i9) {
        int i10 = this.length;
        if (i10 + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] bArr = this.data;
        bArr[i10] = (byte) (i9 >>> 24);
        bArr[i10 + 1] = (byte) (i9 >>> 16);
        bArr[i10 + 2] = (byte) (i9 >>> 8);
        bArr[i10 + 3] = (byte) i9;
        this.length = i10 + 4;
        return this;
    }

    public ByteVector putShort(int i9) {
        int i10 = this.length;
        if (i10 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        bArr[i10] = (byte) (i9 >>> 8);
        bArr[i10 + 1] = (byte) i9;
        this.length = i10 + 2;
        return this;
    }

    public ByteVector putUTF8(String str) {
        int length = str.length();
        int i9 = this.length;
        if (i9 + 2 + length > this.data.length) {
            enlarge(length + 2);
        }
        byte[] bArr = this.data;
        int i10 = i9 + 1;
        bArr[i9] = (byte) (length >>> 8);
        int i11 = i9 + 2;
        bArr[i10] = (byte) length;
        int i12 = 0;
        while (i12 < length) {
            char cCharAt = str.charAt(i12);
            if ((cCharAt < 1 || cCharAt > 127) && (cCharAt < 19968 || cCharAt > 40959)) {
                throw new UnsupportedOperationException();
            }
            bArr[i11] = (byte) cCharAt;
            i12++;
            i11++;
        }
        this.length = i11;
        return this;
    }

    public ByteVector(int i9) {
        this.data = new byte[i9];
    }
}

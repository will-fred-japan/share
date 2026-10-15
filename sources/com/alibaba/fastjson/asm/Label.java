package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class Label {
    static final int FORWARD_REFERENCE_HANDLE_MASK = 268435455;
    static final int FORWARD_REFERENCE_TYPE_MASK = -268435456;
    static final int FORWARD_REFERENCE_TYPE_SHORT = 268435456;
    static final int FORWARD_REFERENCE_TYPE_WIDE = 536870912;
    int inputStackTop;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;

    private void addReference(int i9, int i10, int i11) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        int i12 = this.referenceCount;
        int[] iArr = this.srcAndRefPositions;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.srcAndRefPositions = iArr2;
        }
        int[] iArr3 = this.srcAndRefPositions;
        int i13 = this.referenceCount;
        int i14 = i13 + 1;
        this.referenceCount = i14;
        iArr3[i13] = i9;
        this.referenceCount = i13 + 2;
        iArr3[i14] = i10 | i11;
    }

    public void put(MethodWriter methodWriter, ByteVector byteVector, int i9, boolean z8) {
        if ((this.status & 2) != 0) {
            if (z8) {
                byteVector.putInt(this.position - i9);
                return;
            } else {
                byteVector.putShort(this.position - i9);
                return;
            }
        }
        if (z8) {
            addReference(i9, byteVector.length, FORWARD_REFERENCE_TYPE_WIDE);
            byteVector.putInt(-1);
        } else {
            addReference(i9, byteVector.length, FORWARD_REFERENCE_TYPE_SHORT);
            byteVector.putShort(-1);
        }
    }

    public void resolve(MethodWriter methodWriter, int i9, byte[] bArr) {
        this.status |= 2;
        this.position = i9;
        int i10 = 0;
        while (i10 < this.referenceCount) {
            int[] iArr = this.srcAndRefPositions;
            int i11 = i10 + 1;
            int i12 = iArr[i10];
            i10 += 2;
            int i13 = iArr[i11];
            int i14 = FORWARD_REFERENCE_HANDLE_MASK & i13;
            int i15 = i9 - i12;
            if ((i13 & FORWARD_REFERENCE_TYPE_MASK) == FORWARD_REFERENCE_TYPE_SHORT) {
                bArr[i14] = (byte) (i15 >>> 8);
                bArr[i14 + 1] = (byte) i15;
            } else {
                bArr[i14] = (byte) (i15 >>> 24);
                bArr[i14 + 1] = (byte) (i15 >>> 16);
                bArr[i14 + 2] = (byte) (i15 >>> 8);
                bArr[i14 + 3] = (byte) i15;
            }
        }
    }
}

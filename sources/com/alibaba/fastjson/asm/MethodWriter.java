package com.alibaba.fastjson.asm;

import com.jieli.jl_bt_ota.constant.Command;

/* JADX INFO: loaded from: classes.dex */
public class MethodWriter implements MethodVisitor {
    private int access;
    private ByteVector code = new ByteVector();
    final ClassWriter cw;
    private final int desc;
    int exceptionCount;
    int[] exceptions;
    private int maxLocals;
    private int maxStack;
    private final int name;
    MethodWriter next;

    public MethodWriter(ClassWriter classWriter, int i9, String str, String str2, String str3, String[] strArr) {
        if (classWriter.firstMethod == null) {
            classWriter.firstMethod = this;
        } else {
            classWriter.lastMethod.next = this;
        }
        classWriter.lastMethod = this;
        this.cw = classWriter;
        this.access = i9;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.exceptionCount = length;
        this.exceptions = new int[length];
        for (int i10 = 0; i10 < this.exceptionCount; i10++) {
            this.exceptions[i10] = classWriter.newClassItem(strArr[i10]).index;
        }
    }

    public final int getSize() {
        int i9;
        if (this.code.length > 0) {
            this.cw.newUTF8("Code");
            i9 = this.code.length + 26;
        } else {
            i9 = 8;
        }
        if (this.exceptionCount <= 0) {
            return i9;
        }
        this.cw.newUTF8("Exceptions");
        return (this.exceptionCount * 2) + 8 + i9;
    }

    public final void put(ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        int i9 = this.code.length > 0 ? 1 : 0;
        if (this.exceptionCount > 0) {
            i9++;
        }
        byteVector.putShort(i9);
        int i10 = this.code.length;
        if (i10 > 0) {
            byteVector.putShort(this.cw.newUTF8("Code")).putInt(i10 + 12);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            ByteVector byteVectorPutInt = byteVector.putInt(this.code.length);
            ByteVector byteVector2 = this.code;
            byteVectorPutInt.putByteArray(byteVector2.data, 0, byteVector2.length);
            byteVector.putShort(0);
            byteVector.putShort(0);
        }
        if (this.exceptionCount > 0) {
            byteVector.putShort(this.cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + 2);
            byteVector.putShort(this.exceptionCount);
            for (int i11 = 0; i11 < this.exceptionCount; i11++) {
                byteVector.putShort(this.exceptions[i11]);
            }
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitFieldInsn(int i9, String str, String str2, String str3) {
        this.code.put12(i9, this.cw.newFieldItem(str, str2, str3).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIincInsn(int i9, int i10) {
        this.code.putByte(132).put11(i9, i10);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitInsn(int i9) {
        this.code.putByte(i9);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitIntInsn(int i9, int i10) {
        this.code.put11(i9, i10);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitJumpInsn(int i9, Label label) {
        if ((label.status & 2) != 0 && label.position - this.code.length < -32768) {
            throw new UnsupportedOperationException();
        }
        this.code.putByte(i9);
        ByteVector byteVector = this.code;
        label.put(this, byteVector, byteVector.length - 1, i9 == 200);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLabel(Label label) {
        ByteVector byteVector = this.code;
        label.resolve(this, byteVector.length, byteVector.data);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        Item itemNewConstItem = this.cw.newConstItem(obj);
        int i9 = itemNewConstItem.index;
        int i10 = itemNewConstItem.type;
        if (i10 == 5 || i10 == 6) {
            this.code.put12(20, i9);
        } else if (i9 >= 256) {
            this.code.put12(19, i9);
        } else {
            this.code.put11(18, i9);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMaxs(int i9, int i10) {
        this.maxStack = i9;
        this.maxLocals = i10;
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitMethodInsn(int i9, String str, String str2, String str3) {
        boolean z8 = i9 == 185;
        Item itemNewMethodItem = this.cw.newMethodItem(str, str2, str3, z8);
        int argumentsAndReturnSizes = itemNewMethodItem.intVal;
        if (!z8) {
            this.code.put12(i9, itemNewMethodItem.index);
            return;
        }
        if (argumentsAndReturnSizes == 0) {
            argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str3);
            itemNewMethodItem.intVal = argumentsAndReturnSizes;
        }
        this.code.put12(Opcodes.INVOKEINTERFACE, itemNewMethodItem.index).put11(argumentsAndReturnSizes >> 2, 0);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitTypeInsn(int i9, String str) {
        this.code.put12(i9, this.cw.newClassItem(str).index);
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitVarInsn(int i9, int i10) {
        if (i10 < 4 && i9 != 169) {
            this.code.putByte((i9 < 54 ? ((i9 - 21) << 2) + 26 : ((i9 - 54) << 2) + 59) + i10);
        } else if (i10 >= 256) {
            this.code.putByte(Command.CMD_ADV_DEV_REQUEST_OPERATION).put12(i9, i10);
        } else {
            this.code.put11(i9, i10);
        }
    }

    @Override // com.alibaba.fastjson.asm.MethodVisitor
    public void visitEnd() {
    }
}

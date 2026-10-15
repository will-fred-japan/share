package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public interface MethodVisitor {
    void visitEnd();

    void visitFieldInsn(int i9, String str, String str2, String str3);

    void visitIincInsn(int i9, int i10);

    void visitInsn(int i9);

    void visitIntInsn(int i9, int i10);

    void visitJumpInsn(int i9, Label label);

    void visitLabel(Label label);

    void visitLdcInsn(Object obj);

    void visitMaxs(int i9, int i10);

    void visitMethodInsn(int i9, String str, String str2, String str3);

    void visitTypeInsn(int i9, String str);

    void visitVarInsn(int i9, int i10);
}

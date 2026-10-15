package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public class MethodCollector {
    protected boolean debugInfoPresent;
    private final int ignoreCount;
    private final int paramCount;
    private final StringBuilder result = new StringBuilder();
    private int currentParameter = 0;

    public MethodCollector(int i9, int i10) {
        this.ignoreCount = i9;
        this.paramCount = i10;
        this.debugInfoPresent = i10 == 0;
    }

    public String getResult() {
        return this.result.length() != 0 ? this.result.substring(1) : "";
    }

    public void visitLocalVariable(String str, int i9) {
        int i10 = this.ignoreCount;
        if (i9 < i10 || i9 >= i10 + this.paramCount) {
            return;
        }
        if (!str.equals("arg" + this.currentParameter)) {
            this.debugInfoPresent = true;
        }
        this.result.append(',');
        this.result.append(str);
        this.currentParameter++;
    }
}

package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

/* JADX INFO: loaded from: classes.dex */
public class SymbolTable {
    private final int indexMask;
    private final String[] symbols;

    public SymbolTable(int i9) {
        this.indexMask = i9 - 1;
        this.symbols = new String[i9];
        addSymbol("$ref", 0, 4, 1185263);
        String str = JSON.DEFAULT_TYPE_KEY;
        addSymbol(str, 0, str.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public static int hash(char[] cArr, int i9, int i10) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            i12 = (i12 * 31) + cArr[i9];
            i11++;
            i9++;
        }
        return i12;
    }

    private static String subString(String str, int i9, int i10) {
        char[] cArr = new char[i10];
        str.getChars(i9, i10 + i9, cArr, 0);
        return new String(cArr);
    }

    public String addSymbol(char[] cArr, int i9, int i10) {
        return addSymbol(cArr, i9, i10, hash(cArr, i9, i10));
    }

    public String addSymbol(char[] cArr, int i9, int i10, int i11) {
        int i12 = this.indexMask & i11;
        String str = this.symbols[i12];
        if (str != null) {
            if (i11 == str.hashCode() && i10 == str.length()) {
                for (int i13 = 0; i13 < i10; i13++) {
                    if (cArr[i9 + i13] == str.charAt(i13)) {
                    }
                }
                return str;
            }
            return new String(cArr, i9, i10);
        }
        String strIntern = new String(cArr, i9, i10).intern();
        this.symbols[i12] = strIntern;
        return strIntern;
    }

    public String addSymbol(String str, int i9, int i10, int i11) {
        return addSymbol(str, i9, i10, i11, false);
    }

    public String addSymbol(String str, int i9, int i10, int i11, boolean z8) {
        int i12 = this.indexMask & i11;
        String str2 = this.symbols[i12];
        if (str2 != null) {
            if (i11 == str2.hashCode() && i10 == str2.length() && str.startsWith(str2, i9)) {
                return str2;
            }
            String strSubString = subString(str, i9, i10);
            if (z8) {
                this.symbols[i12] = strSubString;
            }
            return strSubString;
        }
        if (i10 != str.length()) {
            str = subString(str, i9, i10);
        }
        String strIntern = str.intern();
        this.symbols[i12] = strIntern;
        return strIntern;
    }
}

package com.alibaba.fastjson.asm;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class Type {
    private final char[] buf;
    private final int len;
    private final int off;
    protected final int sort;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    private Type(int i9, char[] cArr, int i10, int i11) {
        this.sort = i9;
        this.buf = cArr;
        this.off = i10;
        this.len = i11;
    }

    public static Type[] getArgumentTypes(String str) {
        char[] charArray = str.toCharArray();
        int i9 = 1;
        int i10 = 1;
        int i11 = 0;
        while (true) {
            int i12 = i10 + 1;
            char c5 = charArray[i10];
            if (c5 == ')') {
                break;
            }
            if (c5 == 'L') {
                while (true) {
                    i10 = i12 + 1;
                    if (charArray[i12] == ';') {
                        break;
                    }
                    i12 = i10;
                }
                i11++;
            } else {
                if (c5 != '[') {
                    i11++;
                }
                i10 = i12;
            }
        }
        Type[] typeArr = new Type[i11];
        int i13 = 0;
        while (charArray[i9] != ')') {
            Type type = getType(charArray, i9);
            typeArr[i13] = type;
            i9 += type.len + (type.sort == 10 ? 2 : 0);
            i13++;
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i9;
        int i10 = 1;
        int i11 = 1;
        int i12 = 1;
        while (true) {
            i9 = i11 + 1;
            char cCharAt = str.charAt(i11);
            if (cCharAt == ')') {
                break;
            }
            if (cCharAt == 'L') {
                while (true) {
                    i11 = i9 + 1;
                    if (str.charAt(i9) == ';') {
                        break;
                    }
                    i9 = i11;
                }
                i12++;
            } else {
                i12 = (cCharAt == 'D' || cCharAt == 'J') ? i12 + 2 : i12 + 1;
                i11 = i9;
            }
        }
        char cCharAt2 = str.charAt(i9);
        int i13 = i12 << 2;
        if (cCharAt2 == 'V') {
            i10 = 0;
        } else if (cCharAt2 == 'D' || cCharAt2 == 'J') {
            i10 = 2;
        }
        return i13 | i10;
    }

    private int getDimensions() {
        int i9 = 1;
        while (this.buf[this.off + i9] == '[') {
            i9++;
        }
        return i9;
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb = new StringBuilder(getType(this.buf, this.off + getDimensions()).getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                }
                return sb.toString();
            default:
                return new String(this.buf, this.off, this.len).replace('/', '.');
        }
    }

    public String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    private static Type getType(char[] cArr, int i9) {
        char c5;
        char c9 = cArr[i9];
        if (c9 == 'F') {
            return FLOAT_TYPE;
        }
        if (c9 == 'S') {
            return SHORT_TYPE;
        }
        if (c9 == 'V') {
            return VOID_TYPE;
        }
        if (c9 == 'I') {
            return INT_TYPE;
        }
        if (c9 == 'J') {
            return LONG_TYPE;
        }
        if (c9 == 'Z') {
            return BOOLEAN_TYPE;
        }
        if (c9 != '[') {
            switch (c9) {
                case 'B':
                    return BYTE_TYPE;
                case 'C':
                    return CHAR_TYPE;
                case 'D':
                    return DOUBLE_TYPE;
                default:
                    int i10 = 1;
                    while (cArr[i9 + i10] != ';') {
                        i10++;
                    }
                    return new Type(10, cArr, i9 + 1, i10 - 1);
            }
        }
        int i11 = 1;
        while (true) {
            c5 = cArr[i9 + i11];
            if (c5 != '[') {
                break;
            }
            i11++;
        }
        if (c5 == 'L') {
            do {
                i11++;
            } while (cArr[i9 + i11] != ';');
        }
        return new Type(9, cArr, i9, i11 + 1);
    }
}

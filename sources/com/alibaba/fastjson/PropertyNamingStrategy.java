package com.alibaba.fastjson;

/* JADX INFO: loaded from: classes.dex */
public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase,
    NoChange,
    NeverUseThisValueExceptDefaultValue;

    /* JADX INFO: renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;

        static {
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = iArr;
            try {
                iArr[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.NoChange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String translate(String str) {
        char cCharAt;
        int i9 = AnonymousClass1.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
        int i10 = 0;
        if (i9 == 1) {
            StringBuilder sb = new StringBuilder();
            while (i10 < str.length()) {
                char cCharAt2 = str.charAt(i10);
                if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                    sb.append(cCharAt2);
                } else {
                    char c5 = (char) (cCharAt2 + ' ');
                    if (i10 > 0) {
                        sb.append('_');
                    }
                    sb.append(c5);
                }
                i10++;
            }
            return sb.toString();
        }
        if (i9 == 2) {
            StringBuilder sb2 = new StringBuilder();
            while (i10 < str.length()) {
                char cCharAt3 = str.charAt(i10);
                if (cCharAt3 < 'A' || cCharAt3 > 'Z') {
                    sb2.append(cCharAt3);
                } else {
                    char c9 = (char) (cCharAt3 + ' ');
                    if (i10 > 0) {
                        sb2.append('-');
                    }
                    sb2.append(c9);
                }
                i10++;
            }
            return sb2.toString();
        }
        if (i9 != 3) {
            if (i9 != 4 || (cCharAt = str.charAt(0)) < 'A' || cCharAt > 'Z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] + ' ');
            return new String(charArray);
        }
        char cCharAt4 = str.charAt(0);
        if (cCharAt4 < 'a' || cCharAt4 > 'z') {
            return str;
        }
        char[] charArray2 = str.toCharArray();
        charArray2[0] = (char) (charArray2[0] - ' ');
        return new String(charArray2);
    }
}

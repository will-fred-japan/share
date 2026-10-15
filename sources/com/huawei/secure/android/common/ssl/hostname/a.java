package com.huawei.secure.android.common.ssl.hostname;

import com.alibaba.fastjson.asm.Opcodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char[] f15898g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f15892a = name;
        this.f15893b = name.length();
    }

    private String a() {
        int i9;
        int i10;
        char c5;
        int i11 = this.f15894c;
        this.f15895d = i11;
        this.f15896e = i11;
        while (true) {
            int i12 = this.f15894c;
            if (i12 >= this.f15893b) {
                char[] cArr = this.f15898g;
                int i13 = this.f15895d;
                return new String(cArr, i13, this.f15896e - i13);
            }
            char[] cArr2 = this.f15898g;
            char c9 = cArr2[i12];
            if (c9 != ' ') {
                if (c9 != ';') {
                    if (c9 == '\\') {
                        int i14 = this.f15896e;
                        this.f15896e = i14 + 1;
                        cArr2[i14] = b();
                        this.f15894c++;
                    } else if (c9 != '+' && c9 != ',') {
                        int i15 = this.f15896e;
                        this.f15896e = i15 + 1;
                        cArr2[i15] = c9;
                        this.f15894c = i12 + 1;
                    }
                }
                int i16 = this.f15895d;
                return new String(cArr2, i16, this.f15896e - i16);
            }
            int i17 = this.f15896e;
            this.f15897f = i17;
            this.f15894c = i12 + 1;
            this.f15896e = i17 + 1;
            cArr2[i17] = ' ';
            while (true) {
                i9 = this.f15894c;
                i10 = this.f15893b;
                if (i9 >= i10) {
                    break;
                }
                char[] cArr3 = this.f15898g;
                if (cArr3[i9] != ' ') {
                    break;
                }
                int i18 = this.f15896e;
                this.f15896e = i18 + 1;
                cArr3[i18] = ' ';
                this.f15894c = i9 + 1;
            }
            if (i9 == i10 || (c5 = this.f15898g[i9]) == ',' || c5 == '+' || c5 == ';') {
                char[] cArr4 = this.f15898g;
                int i19 = this.f15895d;
                return new String(cArr4, i19, this.f15897f - i19);
            }
        }
    }

    private char b() {
        int i9 = this.f15894c + 1;
        this.f15894c = i9;
        if (i9 == this.f15893b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f15892a);
        }
        char c5 = this.f15898g[i9];
        if (c5 == ' ' || c5 == '%' || c5 == '\\' || c5 == '_' || c5 == '\"' || c5 == '#') {
            return c5;
        }
        switch (c5) {
            case '*':
            case '+':
            case ',':
                return c5;
            default:
                switch (c5) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c5;
                    default:
                        return c();
                }
        }
    }

    private char c() {
        int i9;
        int i10;
        int iA = a(this.f15894c);
        this.f15894c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i9 = iA & 31;
            i10 = 1;
        } else if (iA <= 239) {
            i9 = iA & 15;
            i10 = 2;
        } else {
            i9 = iA & 7;
            i10 = 3;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f15894c;
            int i13 = i12 + 1;
            this.f15894c = i13;
            if (i13 == this.f15893b || this.f15898g[i13] != '\\') {
                return '?';
            }
            int i14 = i12 + 2;
            this.f15894c = i14;
            int iA2 = a(i14);
            this.f15894c++;
            if ((iA2 & Opcodes.CHECKCAST) != 128) {
                return '?';
            }
            i9 = (i9 << 6) + (iA2 & 63);
        }
        return (char) i9;
    }

    private String d() {
        char[] cArr;
        char c5;
        int i9 = this.f15894c;
        if (i9 + 4 >= this.f15893b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f15892a);
        }
        this.f15895d = i9;
        this.f15894c = i9 + 1;
        while (true) {
            int i10 = this.f15894c;
            if (i10 == this.f15893b || (c5 = (cArr = this.f15898g)[i10]) == '+' || c5 == ',' || c5 == ';') {
                this.f15896e = i10;
                break;
            }
            if (c5 == ' ') {
                this.f15896e = i10;
                this.f15894c = i10 + 1;
                while (true) {
                    int i11 = this.f15894c;
                    if (i11 >= this.f15893b || this.f15898g[i11] != ' ') {
                        break;
                    }
                    this.f15894c = i11 + 1;
                }
            } else {
                if (c5 >= 'A' && c5 <= 'F') {
                    cArr[i10] = (char) (c5 + ' ');
                }
                this.f15894c = i10 + 1;
            }
        }
        int i12 = this.f15896e;
        int i13 = this.f15895d;
        int i14 = i12 - i13;
        if (i14 < 5 || (i14 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f15892a);
        }
        int i15 = i14 / 2;
        byte[] bArr = new byte[i15];
        int i16 = i13 + 1;
        for (int i17 = 0; i17 < i15; i17++) {
            bArr[i17] = (byte) a(i16);
            i16 += 2;
        }
        return new String(this.f15898g, this.f15895d, i14);
    }

    private String e() {
        int i9;
        int i10;
        int i11;
        int i12;
        char c5;
        char c9;
        char c10;
        int i13;
        int i14;
        char c11;
        char c12;
        while (true) {
            i9 = this.f15894c;
            i10 = this.f15893b;
            if (i9 >= i10 || this.f15898g[i9] != ' ') {
                break;
            }
            this.f15894c = i9 + 1;
        }
        if (i9 == i10) {
            return null;
        }
        this.f15895d = i9;
        this.f15894c = i9 + 1;
        while (true) {
            i11 = this.f15894c;
            i12 = this.f15893b;
            if (i11 >= i12 || (c12 = this.f15898g[i11]) == '=' || c12 == ' ') {
                break;
            }
            this.f15894c = i11 + 1;
        }
        if (i11 >= i12) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f15892a);
        }
        this.f15896e = i11;
        if (this.f15898g[i11] == ' ') {
            while (true) {
                i13 = this.f15894c;
                i14 = this.f15893b;
                if (i13 >= i14 || (c11 = this.f15898g[i13]) == '=' || c11 != ' ') {
                    break;
                }
                this.f15894c = i13 + 1;
            }
            if (this.f15898g[i13] != '=' || i13 == i14) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f15892a);
            }
        }
        this.f15894c++;
        while (true) {
            int i15 = this.f15894c;
            if (i15 >= this.f15893b || this.f15898g[i15] != ' ') {
                break;
            }
            this.f15894c = i15 + 1;
        }
        int i16 = this.f15896e;
        int i17 = this.f15895d;
        if (i16 - i17 > 4) {
            char[] cArr = this.f15898g;
            if (cArr[i17 + 3] == '.' && (((c5 = cArr[i17]) == 'O' || c5 == 'o') && (((c9 = cArr[i17 + 1]) == 'I' || c9 == 'i') && ((c10 = cArr[i17 + 2]) == 'D' || c10 == 'd')))) {
                this.f15895d = i17 + 4;
            }
        }
        char[] cArr2 = this.f15898g;
        int i18 = this.f15895d;
        return new String(cArr2, i18, i16 - i18);
    }

    private String f() {
        int i9 = this.f15894c + 1;
        this.f15894c = i9;
        this.f15895d = i9;
        this.f15896e = i9;
        while (true) {
            int i10 = this.f15894c;
            if (i10 == this.f15893b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f15892a);
            }
            char[] cArr = this.f15898g;
            char c5 = cArr[i10];
            if (c5 == '\"') {
                this.f15894c = i10 + 1;
                while (true) {
                    int i11 = this.f15894c;
                    if (i11 >= this.f15893b || this.f15898g[i11] != ' ') {
                        break;
                    }
                    this.f15894c = i11 + 1;
                }
                char[] cArr2 = this.f15898g;
                int i12 = this.f15895d;
                return new String(cArr2, i12, this.f15896e - i12);
            }
            if (c5 == '\\') {
                cArr[this.f15896e] = b();
            } else {
                cArr[this.f15896e] = c5;
            }
            this.f15894c++;
            this.f15896e++;
        }
    }

    public List<String> b(String str) {
        String strF;
        this.f15894c = 0;
        this.f15895d = 0;
        this.f15896e = 0;
        this.f15897f = 0;
        this.f15898g = this.f15892a.toCharArray();
        List<String> arrayList = Collections.EMPTY_LIST;
        String strE = e();
        if (strE == null) {
            return arrayList;
        }
        do {
            int i9 = this.f15894c;
            if (i9 >= this.f15893b) {
                return arrayList;
            }
            char c5 = this.f15898g[i9];
            if (c5 == '\"') {
                strF = f();
            } else if (c5 == '#') {
                strF = d();
            } else if (c5 != '+' && c5 != ',' && c5 != ';') {
                strF = a();
            } else {
                strF = "";
            }
            if (str.equalsIgnoreCase(strE)) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(strF);
            }
            int i10 = this.f15894c;
            if (i10 >= this.f15893b) {
                return arrayList;
            }
            char c9 = this.f15898g[i10];
            if (c9 != ',' && c9 != ';' && c9 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f15892a);
            }
            this.f15894c = i10 + 1;
            strE = e();
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.f15892a);
    }

    private int a(int i9) {
        int i10;
        int i11;
        int i12 = i9 + 1;
        if (i12 < this.f15893b) {
            char[] cArr = this.f15898g;
            char c5 = cArr[i9];
            if (c5 >= '0' && c5 <= '9') {
                i10 = c5 - '0';
            } else if (c5 >= 'a' && c5 <= 'f') {
                i10 = c5 - 'W';
            } else {
                if (c5 < 'A' || c5 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f15892a);
                }
                i10 = c5 - '7';
            }
            char c9 = cArr[i12];
            if (c9 >= '0' && c9 <= '9') {
                i11 = c9 - '0';
            } else if (c9 >= 'a' && c9 <= 'f') {
                i11 = c9 - 'W';
            } else {
                if (c9 < 'A' || c9 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f15892a);
                }
                i11 = c9 - '7';
            }
            return (i10 << 4) + i11;
        }
        throw new IllegalStateException("Malformed DN: " + this.f15892a);
    }

    public String a(String str) {
        String strF;
        this.f15894c = 0;
        this.f15895d = 0;
        this.f15896e = 0;
        this.f15897f = 0;
        this.f15898g = this.f15892a.toCharArray();
        String strE = e();
        if (strE == null) {
            return null;
        }
        do {
            int i9 = this.f15894c;
            if (i9 == this.f15893b) {
                return null;
            }
            char c5 = this.f15898g[i9];
            if (c5 == '\"') {
                strF = f();
            } else if (c5 == '#') {
                strF = d();
            } else if (c5 != '+' && c5 != ',' && c5 != ';') {
                strF = a();
            } else {
                strF = "";
            }
            if (str.equalsIgnoreCase(strE)) {
                return strF;
            }
            int i10 = this.f15894c;
            if (i10 >= this.f15893b) {
                return null;
            }
            char c9 = this.f15898g[i10];
            if (c9 != ',' && c9 != ';' && c9 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f15892a);
            }
            this.f15894c = i10 + 1;
            strE = e();
        } while (strE != null);
        throw new IllegalStateException("Malformed DN: " + this.f15892a);
    }
}

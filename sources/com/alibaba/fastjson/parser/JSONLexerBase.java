package com.alibaba.fastjson.parser;

import W5.e;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import defpackage.f;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected int bp;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] digits = new int[103];
    protected Calendar calendar = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;
    protected int nanos = 0;

    static {
        for (int i9 = 48; i9 <= 57; i9++) {
            digits[i9] = i9 - 48;
        }
        for (int i10 = 97; i10 <= 102; i10++) {
            digits[i10] = i10 - 87;
        }
        for (int i11 = 65; i11 <= 70; i11++) {
            digits[i11] = i11 - 55;
        }
    }

    public JSONLexerBase(int i9) {
        this.stringDefaultValue = null;
        this.features = i9;
        if ((i9 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c5) {
        if (c5 <= ' ') {
            return c5 == ' ' || c5 == '\n' || c5 == '\r' || c5 == '\t' || c5 == '\f' || c5 == '\b';
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0103  */
    public static String readString(char[] cArr, int i9) {
        char c5;
        int i10;
        char c9 = 5;
        char[] cArr2 = new char[i9];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            char c10 = cArr[i11];
            if (c10 != '\\') {
                cArr2[i12] = c10;
                c5 = c9;
                i12++;
            } else {
                int i13 = i11 + 1;
                char c11 = cArr[i13];
                if (c11 == '\"') {
                    c5 = c9;
                    i10 = i12 + 1;
                    cArr2[i12] = '\"';
                } else if (c11 == '\'') {
                    c5 = c9;
                    i10 = i12 + 1;
                    cArr2[i12] = '\'';
                } else if (c11 == 'F') {
                    c5 = c9;
                    i10 = i12 + 1;
                    cArr2[i12] = '\f';
                } else if (c11 == '\\') {
                    c5 = c9;
                    i10 = i12 + 1;
                    cArr2[i12] = '\\';
                } else if (c11 == 'b') {
                    c5 = c9;
                    i10 = i12 + 1;
                    cArr2[i12] = '\b';
                } else if (c11 == 'f') {
                    c5 = c9;
                    i10 = i12 + 1;
                    cArr2[i12] = '\f';
                } else if (c11 == 'n') {
                    c5 = c9;
                    i10 = i12 + 1;
                    cArr2[i12] = '\n';
                } else if (c11 == 'r') {
                    c5 = c9;
                    i10 = i12 + 1;
                    cArr2[i12] = '\r';
                } else if (c11 != 'x') {
                    switch (c11) {
                        case '/':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = '/';
                            break;
                        case '0':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = 0;
                            break;
                        case '1':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = 1;
                            break;
                        case '2':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = 2;
                            break;
                        case '3':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = 3;
                            break;
                        case '4':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = 4;
                            break;
                        case '5':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = c5;
                            break;
                        case '6':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = 6;
                            break;
                        case '7':
                            c5 = c9;
                            i10 = i12 + 1;
                            cArr2[i12] = 7;
                            break;
                        default:
                            switch (c11) {
                                case 't':
                                    c5 = c9;
                                    i10 = i12 + 1;
                                    cArr2[i12] = '\t';
                                    break;
                                case 'u':
                                    char c12 = cArr[i11 + 2];
                                    char c13 = cArr[i11 + 3];
                                    char c14 = cArr[i11 + 4];
                                    i11 += c9;
                                    c5 = c9;
                                    cArr2[i12] = (char) Integer.parseInt(new String(new char[]{c12, c13, c14, cArr[i11]}), 16);
                                    i12++;
                                    break;
                                case 'v':
                                    cArr2[i12] = 11;
                                    c5 = c9;
                                    i12++;
                                    i11 = i13;
                                    break;
                                default:
                                    throw new JSONException("unclosed.str.lit");
                            }
                            break;
                    }
                } else {
                    c5 = c9;
                    int[] iArr = digits;
                    int i14 = iArr[cArr[i11 + 2]] * 16;
                    i11 += 3;
                    cArr2[i12] = (char) (i14 + iArr[cArr[i11]]);
                    i12++;
                }
                i12 = i10;
                i11 = i13;
            }
            i11++;
            c9 = c5;
        }
        return new String(cArr2, 0, i12);
    }

    private void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            }
            if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed single-quote string");
                }
                putChar(JSONLexer.EOI);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i9 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i9 > cArr.length) {
                        char[] cArr2 = new char[i9 * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        break;
                                    case '0':
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                boolean z8 = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                boolean z9 = (next4 >= '0' && next4 <= '9') || (next4 >= 'a' && next4 <= 'f') || (next4 >= 'A' && next4 <= 'F');
                                if (!z8 || !z9) {
                                    throw new JSONException("invalid escape character \\x" + next3 + next4);
                                }
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i10 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i10 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i10 + 1;
                    cArr3[i10] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    public abstract String addSymbol(int i9, int i10, int i11, SymbolTable symbolTable);

    public abstract void arrayCopy(int i9, char[] cArr, int i10, int i11);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i9);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z8) {
        int iConfig = Feature.config(this.features, feature, z8);
        this.features = iConfig;
        if ((iConfig & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public abstract void copyTo(int i9, int i10, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z8) {
        char cCharAt = charAt((this.np + this.sp) - 1);
        try {
            if (cCharAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (cCharAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            return z8 ? decimalValue() : Double.valueOf(doubleValue());
        } catch (NumberFormatException e9) {
            throw new JSONException(e9.getMessage() + ", " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        char cCharAt;
        String strNumberString = numberString();
        float f6 = Float.parseFloat(strNumberString);
        if ((f6 == 0.0f || f6 == Float.POSITIVE_INFINITY) && (cCharAt = strNumberString.charAt(0)) > '0' && cCharAt <= '9') {
            throw new JSONException("float overflow : ".concat(strNumberString));
        }
        return f6;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        return this.features;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c5, int i9);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i9;
        boolean z8;
        int i10 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i11 = this.np;
        int i12 = this.sp + i11;
        if (charAt(i11) == '-') {
            i11++;
            i9 = Integer.MIN_VALUE;
            z8 = true;
        } else {
            i9 = -2147483647;
            z8 = false;
        }
        if (i11 < i12) {
            i10 = -(charAt(i11) - '0');
            i11++;
        }
        while (i11 < i12) {
            int i13 = i11 + 1;
            char cCharAt = charAt(i11);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i11 = i13;
                break;
            }
            int i14 = cCharAt - '0';
            if (i10 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i15 = i10 * 10;
            if (i15 < i9 + i14) {
                throw new NumberFormatException(numberString());
            }
            i10 = i15 - i14;
            i11 = i13;
        }
        if (!z8) {
            return -i10;
        }
        if (i11 > this.np + 1) {
            return i10;
        }
        throw new NumberFormatException(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() {
        char c5;
        long j;
        long j8;
        boolean z8 = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i9 = this.np;
        int i10 = this.sp + i9;
        char cCharAt = charAt(i10 - 1);
        if (cCharAt == 'B') {
            i10--;
            c5 = 'B';
        } else if (cCharAt == 'L') {
            i10--;
            c5 = 'L';
        } else if (cCharAt != 'S') {
            c5 = ' ';
        } else {
            i10--;
            c5 = 'S';
        }
        if (charAt(this.np) == '-') {
            i9++;
            j = Long.MIN_VALUE;
            z8 = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i9 < i10) {
            j8 = -(charAt(i9) - '0');
            i9++;
        } else {
            j8 = 0;
        }
        while (i9 < i10) {
            int i11 = i9 + 1;
            int iCharAt = charAt(i9) - '0';
            if (j8 < -922337203685477580L) {
                return new BigInteger(numberString(), 10);
            }
            long j9 = j8 * 10;
            long j10 = iCharAt;
            if (j9 < j + j10) {
                return new BigInteger(numberString(), 10);
            }
            j8 = j9 - j10;
            i9 = i11;
        }
        if (!z8) {
            long j11 = -j8;
            if (j11 > 2147483647L || c5 == 'L') {
                return Long.valueOf(j11);
            }
            if (c5 == 'S') {
                return Short.valueOf((short) j11);
            }
            return c5 == 'B' ? Byte.valueOf((byte) j11) : Integer.valueOf((int) j11);
        }
        if (i9 <= this.np + 1) {
            throw new JSONException("illegal number format : " + numberString());
        }
        if (j8 < -2147483648L || c5 == 'L') {
            return Long.valueOf(j8);
        }
        if (c5 == 'S') {
            return Short.valueOf((short) j8);
        }
        return c5 == 'B' ? Byte.valueOf((byte) j8) : Integer.valueOf((int) j8);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i9 = 0;
        while (true) {
            char cCharAt = charAt(i9);
            if (cCharAt == 26) {
                this.token = 20;
                return true;
            }
            if (!isWhitespace(cCharAt)) {
                return false;
            }
            i9++;
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0034  */
    /* JADX WARN: Code duplicated, block: B:32:0x0075  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005c -> B:11:0x002e). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final long longValue() {
        long j;
        long j8;
        int i9;
        char cCharAt;
        boolean z8 = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i10 = this.np;
        int i11 = this.sp + i10;
        if (charAt(i10) == '-') {
            i10++;
            j = Long.MIN_VALUE;
            z8 = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i10 >= i11) {
            j8 = 0;
            if (i10 < i11) {
                i9 = i10 + 1;
                cCharAt = charAt(i10);
                if (cCharAt != 'L' || cCharAt == 'S' || cCharAt == 'B') {
                    i10 = i9;
                } else {
                    int i12 = cCharAt - '0';
                    if (j8 < -922337203685477580L) {
                        throw new NumberFormatException(numberString());
                    }
                    long j9 = j8 * 10;
                    long j10 = i12;
                    if (j9 < j + j10) {
                        throw new NumberFormatException(numberString());
                    }
                    j8 = j9 - j10;
                }
            }
            if (z8) {
                return -j8;
            }
            if (i10 > this.np + 1) {
                return j8;
            }
            throw new NumberFormatException(numberString());
        }
        i9 = i10 + 1;
        j8 = -(charAt(i10) - '0');
        i10 = i9;
        if (i10 < i11) {
            i9 = i10 + 1;
            cCharAt = charAt(i10);
            if (cCharAt != 'L') {
            }
            i10 = i9;
        }
        if (z8) {
            return -j8;
        }
        if (i10 > this.np + 1) {
            return j8;
        }
        throw new NumberFormatException(numberString());
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.ch)) {
                return false;
            }
            next();
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char cCharAt = charAt(length);
        this.ch = cCharAt;
        if (cCharAt == '{') {
            next();
            this.token = 12;
        } else if (cCharAt == '[') {
            next();
            this.token = 14;
        } else if (cCharAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i9 = this.bp + 3;
            this.bp = i9;
            this.ch = charAt(i9);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(LinkedList.class)) {
            return new LinkedList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e9) {
            throw new JSONException(e9.getMessage(), e9);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c5 = this.ch;
        if (c5 == '_' || c5 == '$' || Character.isLetter(c5)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c5 = this.ch;
            if (c5 == '/') {
                skipComment();
            } else {
                if (c5 == '\"') {
                    scanString();
                    return;
                }
                if (c5 == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (c5 >= '0' && c5 <= '9') {
                    scanNumber();
                    return;
                }
                if (c5 == '-') {
                    scanNumber();
                    return;
                }
                switch (c5) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (!isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("Feature.AllowSingleQuotes is false");
                        }
                        scanStringSingleQuote();
                        return;
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token == 20) {
                                throw new JSONException("EOF error");
                            }
                            this.token = 20;
                            int i9 = this.bp;
                            this.pos = i9;
                            this.eofPos = i9;
                            return;
                        }
                        char c9 = this.ch;
                        if (c9 > 31 && c9 != 127) {
                            lexError("illegal.char", String.valueOf((int) c9));
                            next();
                            return;
                        }
                        next();
                        break;
                        break;
                }
            }
        }
    }

    public final void nextTokenWithChar(char c5) {
        this.sp = 0;
        while (true) {
            char c9 = this.ch;
            if (c9 == c5) {
                next();
                nextToken();
                return;
            }
            if (c9 != ' ' && c9 != '\n' && c9 != '\r' && c9 != '\t' && c9 != '\f' && c9 != '\b') {
                throw new JSONException("not match " + c5 + " - " + this.ch + ", info : " + info());
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    public final void putChar(char c5) {
        int i9 = this.sp;
        char[] cArr = this.sbuf;
        if (i9 >= cArr.length) {
            int length = cArr.length * 2;
            if (length < i9) {
                length = i9 + 1;
            }
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i10 = this.sp;
        this.sp = i10 + 1;
        cArr3[i10] = c5;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ac A[LOOP:0: B:34:0x0096->B:39:0x00ac, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b7 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c5) {
        boolean z8 = false;
        this.matchStat = 0;
        char cCharAt = charAt(this.bp);
        int i9 = 5;
        if (cCharAt != 't') {
            if (cCharAt == 'f') {
                if (charAt(this.bp + 1) != 'a' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 's' || charAt(this.bp + 4) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                cCharAt = charAt(this.bp + 5);
                i9 = 6;
            } else if (cCharAt == '1') {
                cCharAt = charAt(this.bp + 1);
                i9 = 2;
            } else if (cCharAt == '0') {
                cCharAt = charAt(this.bp + 1);
                i9 = 2;
            } else {
                i9 = 1;
            }
            while (cCharAt != c5) {
                if (isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return z8;
                }
                cCharAt = charAt(this.bp + i9);
                i9++;
            }
            int i10 = this.bp + i9;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            return z8;
        }
        if (charAt(this.bp + 1) != 'r' || charAt(this.bp + 2) != 'u' || charAt(this.bp + 3) != 'e') {
            this.matchStat = -1;
            return false;
        }
        cCharAt = charAt(this.bp + 4);
        z8 = true;
        while (cCharAt != c5) {
            if (isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return z8;
            }
            cCharAt = charAt(this.bp + i9);
            i9++;
        }
        int i11 = this.bp + i9;
        this.bp = i11;
        this.ch = charAt(i11);
        this.matchStat = 3;
        return z8;
    }

    public Date scanDate(char c5) {
        char cCharAt;
        int i9;
        long j;
        Date date;
        int i10;
        char cCharAt2;
        boolean z8 = false;
        this.matchStat = 0;
        char cCharAt3 = charAt(this.bp);
        int i11 = 1;
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', this.bp + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i12 = this.bp + 1;
            String strSubString = subString(i12, iIndexOf - i12);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i13 = 0;
                    for (int i14 = iIndexOf - 1; i14 >= 0 && charAt(i14) == '\\'; i14--) {
                        i13++;
                    }
                    if (i13 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i15 = this.bp;
                int i16 = iIndexOf - (i15 + 1);
                strSubString = readString(sub_chars(i15 + 1, i16), i16);
            }
            int i17 = this.bp;
            int i18 = iIndexOf - (i17 + 1);
            int i19 = i18 + 2;
            i9 = i18 + 3;
            cCharAt = charAt(i17 + i19);
            JSONScanner jSONScanner = new JSONScanner(strSubString);
            try {
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    this.matchStat = -1;
                    jSONScanner.close();
                    return null;
                }
                date = jSONScanner.getCalendar().getTime();
                jSONScanner.close();
            } catch (Throwable th) {
                jSONScanner.close();
                throw th;
            }
        } else {
            char c9 = '9';
            if (cCharAt3 == '-' || (cCharAt3 >= '0' && cCharAt3 <= '9')) {
                if (cCharAt3 == '-') {
                    cCharAt3 = charAt(this.bp + 1);
                    z8 = true;
                    i11 = 2;
                }
                if (cCharAt3 < '0' || cCharAt3 > '9') {
                    int i20 = i11;
                    cCharAt = cCharAt3;
                    i9 = i20;
                    j = 0;
                } else {
                    j = cCharAt3 - '0';
                    while (true) {
                        i10 = i11 + 1;
                        cCharAt2 = charAt(this.bp + i11);
                        if (cCharAt2 < '0' || cCharAt2 > c9) {
                            break;
                        }
                        j = (j * 10) + ((long) (cCharAt2 - '0'));
                        i11 = i10;
                        c9 = '9';
                    }
                    cCharAt = cCharAt2;
                    i9 = i10;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z8) {
                    j = -j;
                }
                date = new Date(j);
            } else {
                if (cCharAt3 != 'n' || charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                    this.matchStat = -1;
                    return null;
                }
                i9 = 5;
                this.matchStat = 5;
                cCharAt = charAt(this.bp + 4);
                date = null;
            }
        }
        if (cCharAt == ',') {
            int i21 = this.bp + i9;
            this.bp = i21;
            this.ch = charAt(i21);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        if (cCharAt != ']') {
            this.matchStat = -1;
            return null;
        }
        int i22 = i9 + 1;
        char cCharAt4 = charAt(this.bp + i9);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i23 = this.bp + i22;
            this.bp = i23;
            this.ch = charAt(i23);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i24 = this.bp + i22;
            this.bp = i24;
            this.ch = charAt(i24);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i25 = this.bp + i22;
            this.bp = i25;
            this.ch = charAt(i25);
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i9;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x009e A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00a0 -> B:42:0x0090). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public java.math.BigDecimal scanDecimal(char r18) {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char c5) {
        int i9;
        int i10;
        char cCharAt;
        char cCharAt2;
        long j;
        int i11;
        int iA;
        double d9;
        int i12;
        this.matchStat = 0;
        char cCharAt3 = charAt(this.bp);
        boolean z8 = cCharAt3 == '\"';
        if (z8) {
            cCharAt3 = charAt(this.bp + 1);
            i9 = 2;
        } else {
            i9 = 1;
        }
        boolean z9 = cCharAt3 == '-';
        if (z9) {
            cCharAt3 = charAt(this.bp + i9);
            i9++;
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            if (cCharAt3 != 'n' || charAt(this.bp + i9) != 'u' || e.g(this.bp, i9, 1, this) != 'l' || e.g(this.bp, i9, 2, this) != 'l') {
                this.matchStat = -1;
                return 0.0d;
            }
            this.matchStat = 5;
            int i13 = i9 + 4;
            char cCharAt4 = charAt(this.bp + i9 + 3);
            if (z8 && cCharAt4 == '\"') {
                cCharAt4 = charAt(this.bp + i13);
                i13 = i9 + 5;
            }
            while (cCharAt4 != ',') {
                if (cCharAt4 == ']') {
                    int i14 = this.bp + i13;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0.0d;
                }
                if (!isWhitespace(cCharAt4)) {
                    this.matchStat = -1;
                    return 0.0d;
                }
                cCharAt4 = charAt(this.bp + i13);
                i13++;
            }
            int i15 = this.bp + i13;
            this.bp = i15;
            this.ch = charAt(i15);
            this.matchStat = 5;
            this.token = 16;
            return 0.0d;
        }
        long j8 = cCharAt3 - '0';
        while (true) {
            i10 = i9 + 1;
            cCharAt = charAt(this.bp + i9);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j8 = (j8 * 10) + ((long) (cCharAt - '0'));
            i9 = i10;
        }
        if (cCharAt == '.') {
            int i16 = i9 + 2;
            char cCharAt5 = charAt(this.bp + i10);
            if (cCharAt5 < '0' || cCharAt5 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            j8 = (j8 * 10) + ((long) (cCharAt5 - '0'));
            j = 10;
            while (true) {
                i12 = i16 + 1;
                cCharAt2 = charAt(this.bp + i16);
                if (cCharAt2 < '0' || cCharAt2 > '9') {
                    break;
                }
                j8 = (j8 * 10) + ((long) (cCharAt2 - '0'));
                j *= 10;
                i16 = i12;
            }
            i10 = i12;
        } else {
            cCharAt2 = cCharAt;
            j = 1;
        }
        boolean z10 = cCharAt2 == 'e' || cCharAt2 == 'E';
        if (z10) {
            int i17 = i10 + 1;
            char cCharAt6 = charAt(this.bp + i10);
            if (cCharAt6 == '+' || cCharAt6 == '-') {
                i10 += 2;
                cCharAt2 = charAt(this.bp + i17);
            } else {
                i10 = i17;
                cCharAt2 = cCharAt6;
            }
            while (cCharAt2 >= '0' && cCharAt2 <= '9') {
                cCharAt2 = charAt(this.bp + i10);
                i10++;
            }
        }
        if (!z8) {
            i11 = this.bp;
            iA = f.a(i11, i10, i11, 1);
        } else {
            if (cCharAt2 != '\"') {
                this.matchStat = -1;
                return 0.0d;
            }
            int i18 = i10 + 1;
            cCharAt2 = charAt(this.bp + i10);
            int i19 = this.bp;
            i11 = i19 + 1;
            iA = f.a(i19, i18, i11, 2);
            i10 = i18;
        }
        if (z10 || iA >= 17) {
            d9 = Double.parseDouble(subString(i11, iA));
        } else {
            d9 = j8 / j;
            if (z9) {
                d9 = -d9;
            }
        }
        if (cCharAt2 != c5) {
            this.matchStat = -1;
            return d9;
        }
        int i20 = this.bp + i10;
        this.bp = i20;
        this.ch = charAt(i20);
        this.matchStat = 3;
        this.token = 16;
        return d9;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c5) {
        String strScanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c5);
        if (strScanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, strScanSymbolWithSeperator);
    }

    public long scanEnumSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i9 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i10 = i9 + 1;
            char cCharAt = charAt(this.bp + i9);
            if (cCharAt == '\"') {
                int i11 = i9 + 2;
                char cCharAt2 = charAt(this.bp + i10);
                if (cCharAt2 == ',') {
                    int i12 = this.bp + i11;
                    this.bp = i12;
                    this.ch = charAt(i12);
                    this.matchStat = 3;
                    return j;
                }
                if (cCharAt2 != '}') {
                    this.matchStat = -1;
                    return 0L;
                }
                int i13 = i9 + 3;
                char cCharAt3 = charAt(this.bp + i11);
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i14 = this.bp + i13;
                    this.bp = i14;
                    this.ch = charAt(i14);
                } else if (cCharAt3 == ']') {
                    this.token = 15;
                    int i15 = this.bp + i13;
                    this.bp = i15;
                    this.ch = charAt(i15);
                } else if (cCharAt3 == '}') {
                    this.token = 13;
                    int i16 = this.bp + i13;
                    this.bp = i16;
                    this.ch = charAt(i16);
                } else {
                    if (cCharAt3 != 26) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.token = 20;
                    this.bp = i9 + 2 + this.bp;
                    this.ch = JSONLexer.EOI;
                }
                this.matchStat = 4;
                return j;
            }
            j = (j ^ ((long) ((cCharAt < 'A' || cCharAt > 'Z') ? cCharAt : cCharAt + ' '))) * TypeUtils.fnv1a_64_magic_prime;
            if (cCharAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i9 = i10;
        }
    }

    public final void scanFalse() {
        if (this.ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c5 = this.ch;
        if (c5 != ' ' && c5 != ',' && c5 != '}' && c5 != ']' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != 26 && c5 != '\f' && c5 != '\b' && c5 != ':' && c5 != '/') {
            throw new JSONException("scan false error");
        }
        this.token = 7;
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        int i9;
        char cCharAt;
        boolean z8;
        int length;
        int iA;
        BigInteger bigInteger;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i10 = length2 + 1;
        char cCharAt2 = charAt(this.bp + length2);
        boolean z9 = cCharAt2 == '\"';
        if (z9) {
            cCharAt2 = charAt(this.bp + i10);
            i10 = length2 + 2;
        }
        boolean z10 = cCharAt2 == '-';
        if (z10) {
            cCharAt2 = charAt(this.bp + i10);
            i10++;
        }
        char c5 = '0';
        if (cCharAt2 >= '0') {
            char c9 = '9';
            if (cCharAt2 <= '9') {
                long j = cCharAt2 - '0';
                while (true) {
                    i9 = i10 + 1;
                    cCharAt = charAt(this.bp + i10);
                    if (cCharAt < c5 || cCharAt > c9) {
                        z8 = false;
                        break;
                    }
                    long j8 = (10 * j) + ((long) (cCharAt - '0'));
                    if (j8 < j) {
                        z8 = true;
                        break;
                    }
                    i10 = i9;
                    j = j8;
                    c9 = '9';
                    c5 = '0';
                }
                if (!z9) {
                    int i11 = this.bp;
                    length = cArr.length + i11;
                    iA = f.a(i11, i9, length, 1);
                } else {
                    if (cCharAt != '\"') {
                        this.matchStat = -1;
                        return null;
                    }
                    int i12 = i10 + 2;
                    cCharAt = charAt(this.bp + i9);
                    int i13 = this.bp;
                    length = cArr.length + i13 + 1;
                    iA = f.a(i13, i12, length, 2);
                    i9 = i12;
                }
                if (!z8 && (iA < 20 || (z10 && iA < 21))) {
                    if (z10) {
                        j = -j;
                    }
                    bigInteger = BigInteger.valueOf(j);
                } else {
                    if (iA > 65535) {
                        throw new JSONException("scanInteger overflow");
                    }
                    bigInteger = new BigInteger(subString(length, iA), 10);
                }
                if (cCharAt == ',') {
                    int i14 = this.bp + i9;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigInteger;
                }
                if (cCharAt != '}') {
                    this.matchStat = -1;
                    return null;
                }
                int i15 = i9 + 1;
                char cCharAt3 = charAt(this.bp + i9);
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i16 = this.bp + i15;
                    this.bp = i16;
                    this.ch = charAt(i16);
                } else if (cCharAt3 == ']') {
                    this.token = 15;
                    int i17 = this.bp + i15;
                    this.bp = i17;
                    this.ch = charAt(i17);
                } else if (cCharAt3 == '}') {
                    this.token = 13;
                    int i18 = this.bp + i15;
                    this.bp = i18;
                    this.ch = charAt(i18);
                } else {
                    if (cCharAt3 != 26) {
                        this.matchStat = -1;
                        return null;
                    }
                    this.token = 20;
                    this.bp += i9;
                    this.ch = JSONLexer.EOI;
                }
                this.matchStat = 4;
                return bigInteger;
            }
        }
        if (cCharAt2 != 'n' || charAt(this.bp + i10) != 'u' || e.g(this.bp, i10, 1, this) != 'l' || e.g(this.bp, i10, 2, this) != 'l') {
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 5;
        int i19 = i10 + 4;
        char cCharAt4 = charAt(this.bp + i10 + 3);
        if (z9 && cCharAt4 == '\"') {
            cCharAt4 = charAt(this.bp + i19);
            i19 = i10 + 5;
        }
        while (cCharAt4 != ',') {
            if (cCharAt4 == '}') {
                int i20 = this.bp + i19;
                this.bp = i20;
                this.ch = charAt(i20);
                this.matchStat = 5;
                this.token = 13;
                return null;
            }
            if (!isWhitespace(cCharAt4)) {
                this.matchStat = -1;
                return null;
            }
            cCharAt4 = charAt(this.bp + i19);
            i19++;
        }
        int i21 = this.bp + i19;
        this.bp = i21;
        this.ch = charAt(i21);
        this.matchStat = 5;
        this.token = 16;
        return null;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i9;
        boolean z8;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i10 = length + 1;
        char cCharAt = charAt(this.bp + length);
        if (cCharAt == 't') {
            int i11 = length + 2;
            if (charAt(this.bp + i10) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i12 = length + 3;
            if (charAt(this.bp + i11) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i9 = length + 4;
            if (charAt(this.bp + i12) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z8 = true;
        } else {
            if (cCharAt != 'f') {
                this.matchStat = -1;
                return false;
            }
            int i13 = length + 2;
            if (charAt(this.bp + i10) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i14 = length + 3;
            if (charAt(this.bp + i13) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i15 = length + 4;
            if (charAt(this.bp + i14) != 's') {
                this.matchStat = -1;
                return false;
            }
            i9 = length + 5;
            if (charAt(this.bp + i15) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z8 = false;
        }
        int i16 = i9 + 1;
        char cCharAt2 = charAt(this.bp + i9);
        if (cCharAt2 == ',') {
            int i17 = this.bp + i16;
            this.bp = i17;
            this.ch = charAt(i17);
            this.matchStat = 3;
            this.token = 16;
            return z8;
        }
        if (cCharAt2 != '}') {
            this.matchStat = -1;
            return false;
        }
        int i18 = i9 + 2;
        char cCharAt3 = charAt(this.bp + i16);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i19 = this.bp + i18;
            this.bp = i19;
            this.ch = charAt(i19);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i20 = this.bp + i18;
            this.bp = i20;
            this.ch = charAt(i20);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i21 = this.bp + i18;
            this.bp = i21;
            this.ch = charAt(i21);
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return false;
            }
            this.token = 20;
            this.bp = i9 + 1 + this.bp;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return z8;
    }

    public Date scanFieldDate(char[] cArr) {
        char cCharAt;
        int i9;
        long j;
        Date date;
        int i10;
        char cCharAt2;
        boolean z8 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i11 = length + 1;
        char cCharAt3 = charAt(this.bp + length);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int length2 = this.bp + cArr.length + 1;
            String strSubString = subString(length2, iIndexOf - length2);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i12 = 0;
                    for (int i13 = iIndexOf - 1; i13 >= 0 && charAt(i13) == '\\'; i13--) {
                        i12++;
                    }
                    if (i12 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i14 = this.bp;
                int length3 = iIndexOf - ((cArr.length + i14) + 1);
                strSubString = readString(sub_chars(i14 + cArr.length + 1, length3), length3);
            }
            int i15 = this.bp;
            int length4 = (iIndexOf - ((cArr.length + i15) + 1)) + 1 + i11;
            i9 = length4 + 1;
            cCharAt = charAt(i15 + length4);
            JSONScanner jSONScanner = new JSONScanner(strSubString);
            try {
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    this.matchStat = -1;
                    jSONScanner.close();
                    return null;
                }
                date = jSONScanner.getCalendar().getTime();
                jSONScanner.close();
            } catch (Throwable th) {
                jSONScanner.close();
                throw th;
            }
        } else {
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(this.bp + i11);
                i11 = length + 2;
                z8 = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                cCharAt = cCharAt3;
                i9 = i11;
                j = 0;
            } else {
                j = cCharAt3 - '0';
                while (true) {
                    i10 = i11 + 1;
                    cCharAt2 = charAt(this.bp + i11);
                    if (cCharAt2 < '0' || cCharAt2 > '9') {
                        break;
                    }
                    j = (j * 10) + ((long) (cCharAt2 - '0'));
                    i11 = i10;
                }
                cCharAt = cCharAt2;
                i9 = i10;
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z8) {
                j = -j;
            }
            date = new Date(j);
        }
        if (cCharAt == ',') {
            int i16 = this.bp + i9;
            this.bp = i16;
            this.ch = charAt(i16);
            this.matchStat = 3;
            return date;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i17 = i9 + 1;
        char cCharAt4 = charAt(this.bp + i9);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i18 = this.bp + i17;
            this.bp = i18;
            this.ch = charAt(i18);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i19 = this.bp + i17;
            this.bp = i19;
            this.ch = charAt(i19);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i20 = this.bp + i17;
            this.bp = i20;
            this.ch = charAt(i20);
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i9;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return date;
    }

    public BigDecimal scanFieldDecimal(char[] cArr) {
        int i9;
        char cCharAt;
        int length;
        int i10;
        int iA;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i11 = length2 + 1;
        char cCharAt2 = charAt(this.bp + length2);
        boolean z8 = cCharAt2 == '\"';
        if (z8) {
            cCharAt2 = charAt(this.bp + i11);
            i11 = length2 + 2;
        }
        if (cCharAt2 == '-') {
            cCharAt2 = charAt(this.bp + i11);
            i11++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 != 'n' || charAt(this.bp + i11) != 'u' || e.g(this.bp, i11, 1, this) != 'l' || e.g(this.bp, i11, 2, this) != 'l') {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 5;
            int i12 = i11 + 4;
            char cCharAt3 = charAt(this.bp + i11 + 3);
            if (z8 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.bp + i12);
                i12 = i11 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == '}') {
                    int i13 = this.bp + i12;
                    this.bp = i13;
                    this.ch = charAt(i13);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return null;
                }
                cCharAt3 = charAt(this.bp + i12);
                i12++;
            }
            int i14 = this.bp + i12;
            this.bp = i14;
            this.ch = charAt(i14);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        while (true) {
            i9 = i11 + 1;
            cCharAt = charAt(this.bp + i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i11 = i9;
        }
        if (cCharAt == '.') {
            int i15 = i11 + 2;
            char cCharAt4 = charAt(this.bp + i9);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return null;
            }
            while (true) {
                i9 = i15 + 1;
                cCharAt = charAt(this.bp + i15);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i15 = i9;
            }
        }
        if (cCharAt == 'e' || cCharAt == 'E') {
            int i16 = i9 + 1;
            cCharAt = charAt(this.bp + i9);
            if (cCharAt == '+' || cCharAt == '-') {
                i9 += 2;
                cCharAt = charAt(this.bp + i16);
            } else {
                i9 = i16;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                char cCharAt5 = charAt(this.bp + i9);
                i9++;
                cCharAt = cCharAt5;
            }
        }
        int i17 = i9;
        if (!z8) {
            int i18 = this.bp;
            length = cArr.length + i18;
            int iA2 = f.a(i18, i17, length, 1);
            i10 = i17;
            iA = iA2;
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return null;
            }
            i10 = i17 + 1;
            cCharAt = charAt(this.bp + i17);
            int i19 = this.bp;
            length = cArr.length + i19 + 1;
            iA = f.a(i19, i10, length, 2);
        }
        if (iA > 65535) {
            throw new JSONException("scan decimal overflow");
        }
        char[] cArrSub_chars = sub_chars(length, iA);
        BigDecimal bigDecimal = new BigDecimal(cArrSub_chars, 0, cArrSub_chars.length, MathContext.UNLIMITED);
        if (cCharAt == ',') {
            int i20 = this.bp + i10;
            this.bp = i20;
            this.ch = charAt(i20);
            this.matchStat = 3;
            this.token = 16;
            return bigDecimal;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i21 = i10 + 1;
        char cCharAt6 = charAt(this.bp + i10);
        if (cCharAt6 == ',') {
            this.token = 16;
            int i22 = this.bp + i21;
            this.bp = i22;
            this.ch = charAt(i22);
        } else if (cCharAt6 == ']') {
            this.token = 15;
            int i23 = this.bp + i21;
            this.bp = i23;
            this.ch = charAt(i23);
        } else if (cCharAt6 == '}') {
            this.token = 13;
            int i24 = this.bp + i21;
            this.bp = i24;
            this.ch = charAt(i24);
        } else {
            if (cCharAt6 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i10;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return bigDecimal;
    }

    public final double scanFieldDouble(char[] cArr) {
        int i9;
        char cCharAt;
        boolean z8;
        int i10;
        long j;
        int length;
        int iA;
        double d9;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i11 = length2 + 1;
        char cCharAt2 = charAt(this.bp + length2);
        boolean z9 = cCharAt2 == '\"';
        if (z9) {
            cCharAt2 = charAt(this.bp + i11);
            i11 = length2 + 2;
        }
        boolean z10 = cCharAt2 == '-';
        if (z10) {
            cCharAt2 = charAt(this.bp + i11);
            i11++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            boolean z11 = z9;
            if (cCharAt2 != 'n' || charAt(this.bp + i11) != 'u' || e.g(this.bp, i11, 1, this) != 'l' || e.g(this.bp, i11, 2, this) != 'l') {
                this.matchStat = -1;
                return 0.0d;
            }
            this.matchStat = 5;
            int i12 = i11 + 4;
            char cCharAt3 = charAt(this.bp + i11 + 3);
            if (z11 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.bp + i12);
                i12 = i11 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == '}') {
                    int i13 = this.bp + i12;
                    this.bp = i13;
                    this.ch = charAt(i13);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0d;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return 0.0d;
                }
                cCharAt3 = charAt(this.bp + i12);
                i12++;
            }
            int i14 = this.bp + i12;
            this.bp = i14;
            this.ch = charAt(i14);
            this.matchStat = 5;
            this.token = 16;
            return 0.0d;
        }
        long j8 = cCharAt2 - '0';
        while (true) {
            i9 = i11 + 1;
            cCharAt = charAt(this.bp + i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j8 = (j8 * 10) + ((long) (cCharAt - '0'));
            i11 = i9;
        }
        if (cCharAt == '.') {
            int i15 = i11 + 2;
            char cCharAt4 = charAt(this.bp + i9);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            z8 = z9;
            i10 = 1;
            j8 = (j8 * 10) + ((long) (cCharAt4 - '0'));
            j = 10;
            while (true) {
                i9 = i15 + 1;
                cCharAt = charAt(this.bp + i15);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j8 = (j8 * 10) + ((long) (cCharAt - '0'));
                j *= 10;
                i15 = i9;
            }
        } else {
            z8 = z9;
            i10 = 1;
            j = 1;
        }
        int i16 = (cCharAt == 'e' || cCharAt == 'E') ? i10 : 0;
        if (i16 != 0) {
            int i17 = i9 + 1;
            cCharAt = charAt(this.bp + i9);
            if (cCharAt == '+' || cCharAt == '-') {
                i9 += 2;
                cCharAt = charAt(this.bp + i17);
            } else {
                i9 = i17;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                char cCharAt5 = charAt(this.bp + i9);
                i9++;
                cCharAt = cCharAt5;
            }
        }
        int i18 = i9;
        if (!z8) {
            int i19 = this.bp;
            length = cArr.length + i19;
            iA = f.a(i19, i18, length, i10);
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0.0d;
            }
            int i20 = i18 + 1;
            char cCharAt6 = charAt(this.bp + i18);
            int i21 = this.bp;
            length = cArr.length + i21 + 1;
            iA = f.a(i21, i20, length, 2);
            cCharAt = cCharAt6;
            i18 = i20;
        }
        if (i16 != 0 || iA >= 17) {
            d9 = Double.parseDouble(subString(length, iA));
        } else {
            d9 = j8 / j;
            if (z10) {
                d9 = -d9;
            }
        }
        if (cCharAt == ',') {
            int i22 = this.bp + i18;
            this.bp = i22;
            this.ch = charAt(i22);
            this.matchStat = 3;
            this.token = 16;
            return d9;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i23 = i18 + 1;
        char cCharAt7 = charAt(this.bp + i18);
        if (cCharAt7 == ',') {
            this.token = 16;
            int i24 = this.bp + i23;
            this.bp = i24;
            this.ch = charAt(i24);
        } else if (cCharAt7 == ']') {
            this.token = 15;
            int i25 = this.bp + i23;
            this.bp = i25;
            this.ch = charAt(i25);
        } else if (cCharAt7 == '}') {
            this.token = 13;
            int i26 = this.bp + i23;
            this.bp = i26;
            this.ch = charAt(i26);
        } else {
            if (cCharAt7 != 26) {
                this.matchStat = -1;
                return 0.0d;
            }
            this.token = 20;
            this.bp += i18;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return d9;
    }

    public final float scanFieldFloat(char[] cArr) {
        int i9;
        char cCharAt;
        boolean z8;
        int i10;
        long j;
        int i11;
        int length;
        int iA;
        float f6;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i12 = length2 + 1;
        char cCharAt2 = charAt(this.bp + length2);
        boolean z9 = cCharAt2 == '\"';
        if (z9) {
            cCharAt2 = charAt(this.bp + i12);
            i12 = length2 + 2;
        }
        boolean z10 = cCharAt2 == '-';
        if (z10) {
            cCharAt2 = charAt(this.bp + i12);
            i12++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            boolean z11 = z9;
            if (cCharAt2 != 'n' || charAt(this.bp + i12) != 'u' || e.g(this.bp, i12, 1, this) != 'l' || e.g(this.bp, i12, 2, this) != 'l') {
                this.matchStat = -1;
                return 0.0f;
            }
            this.matchStat = 5;
            int i13 = i12 + 4;
            char cCharAt3 = charAt(this.bp + i12 + 3);
            if (z11 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.bp + i13);
                i13 = i12 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == '}') {
                    int i14 = this.bp + i13;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0f;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return 0.0f;
                }
                cCharAt3 = charAt(this.bp + i13);
                i13++;
            }
            int i15 = this.bp + i13;
            this.bp = i15;
            this.ch = charAt(i15);
            this.matchStat = 5;
            this.token = 16;
            return 0.0f;
        }
        long j8 = cCharAt2 - '0';
        while (true) {
            i9 = i12 + 1;
            cCharAt = charAt(this.bp + i12);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j8 = (j8 * 10) + ((long) (cCharAt - '0'));
            i12 = i9;
        }
        if (cCharAt == '.') {
            int i16 = i12 + 2;
            char cCharAt4 = charAt(this.bp + i9);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            z8 = z9;
            i10 = 1;
            j8 = (j8 * 10) + ((long) (cCharAt4 - '0'));
            j = 10;
            while (true) {
                i9 = i16 + 1;
                cCharAt = charAt(this.bp + i16);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j8 = (j8 * 10) + ((long) (cCharAt - '0'));
                j *= 10;
                i16 = i9;
            }
        } else {
            z8 = z9;
            i10 = 1;
            j = 1;
        }
        int i17 = (cCharAt == 'e' || cCharAt == 'E') ? i10 : 0;
        if (i17 != 0) {
            int i18 = i9 + 1;
            cCharAt = charAt(this.bp + i9);
            i11 = i10;
            if (cCharAt == '+' || cCharAt == '-') {
                i9 += 2;
                cCharAt = charAt(this.bp + i18);
            } else {
                i9 = i18;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                char cCharAt5 = charAt(this.bp + i9);
                i9++;
                cCharAt = cCharAt5;
            }
        } else {
            i11 = i10;
        }
        int i19 = i9;
        if (!z8) {
            int i20 = this.bp;
            length = cArr.length + i20;
            iA = f.a(i20, i19, length, i11);
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0.0f;
            }
            int i21 = i19 + 1;
            char cCharAt6 = charAt(this.bp + i19);
            int i22 = this.bp;
            length = cArr.length + i22 + 1;
            iA = f.a(i22, i21, length, 2);
            cCharAt = cCharAt6;
            i19 = i21;
        }
        if (i17 != 0 || iA >= 17) {
            f6 = Float.parseFloat(subString(length, iA));
        } else {
            f6 = (float) (j8 / j);
            if (z10) {
                f6 = -f6;
            }
        }
        if (cCharAt == ',') {
            int i23 = this.bp + i19;
            this.bp = i23;
            this.ch = charAt(i23);
            this.matchStat = 3;
            this.token = 16;
            return f6;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i24 = i19 + 1;
        char cCharAt7 = charAt(this.bp + i19);
        if (cCharAt7 == ',') {
            this.token = 16;
            int i25 = this.bp + i24;
            this.bp = i25;
            this.ch = charAt(i25);
        } else if (cCharAt7 == ']') {
            this.token = 15;
            int i26 = this.bp + i24;
            this.bp = i26;
            this.ch = charAt(i26);
        } else if (cCharAt7 == '}') {
            this.token = 13;
            int i27 = this.bp + i24;
            this.bp = i27;
            this.ch = charAt(i27);
        } else {
            if (cCharAt7 != 26) {
                this.matchStat = -1;
                return 0.0f;
            }
            this.bp += i19;
            this.token = 20;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return f6;
    }

    public final float[] scanFieldFloatArray(char[] cArr) {
        int i9;
        char cCharAt;
        int i10;
        float f6;
        this.matchStat = 0;
        float[] fArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i11 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i12 = length + 2;
        char cCharAt2 = charAt(this.bp + i11);
        float[] fArr2 = new float[16];
        int i13 = 0;
        while (true) {
            int i14 = this.bp;
            int i15 = (i14 + i12) - 1;
            boolean z8 = cCharAt2 == '-';
            if (z8) {
                cCharAt2 = charAt(i14 + i12);
                i12++;
            }
            if (cCharAt2 < '0' || cCharAt2 > '9') {
                break;
            }
            int i16 = cCharAt2 - '0';
            while (true) {
                i9 = i12 + 1;
                cCharAt = charAt(this.bp + i12);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i16 = (i16 * 10) + (cCharAt - '0');
                i12 = i9;
            }
            float[] fArr3 = fArr;
            if (cCharAt == '.') {
                int i17 = i12 + 2;
                char cCharAt3 = charAt(this.bp + i9);
                if (cCharAt3 < '0' || cCharAt3 > '9') {
                    this.matchStat = -1;
                    return fArr3;
                }
                i16 = (cCharAt3 - '0') + (i16 * 10);
                i10 = 10;
                while (true) {
                    i9 = i17 + 1;
                    cCharAt = charAt(this.bp + i17);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    i16 = (i16 * 10) + (cCharAt - '0');
                    i10 *= 10;
                    i17 = i9;
                }
            } else {
                i10 = 1;
            }
            boolean z9 = cCharAt == 'e' || cCharAt == 'E';
            if (z9) {
                int i18 = i9 + 1;
                cCharAt = charAt(this.bp + i9);
                if (cCharAt == '+' || cCharAt == '-') {
                    i9 += 2;
                    cCharAt = charAt(this.bp + i18);
                } else {
                    i9 = i18;
                }
                while (cCharAt >= '0' && cCharAt <= '9') {
                    cCharAt = charAt(this.bp + i9);
                    i9++;
                }
            }
            int i19 = i9;
            int iA = f.a(this.bp, i19, i15, 1);
            if (z9 || iA >= 10) {
                f6 = Float.parseFloat(subString(i15, iA));
            } else {
                f6 = i16 / i10;
                if (z8) {
                    f6 = -f6;
                }
            }
            if (i13 >= fArr2.length) {
                float[] fArr4 = new float[(fArr2.length * 3) / 2];
                System.arraycopy(fArr2, 0, fArr4, 0, i13);
                fArr2 = fArr4;
            }
            int i20 = i13 + 1;
            fArr2[i13] = f6;
            if (cCharAt == ',') {
                cCharAt = charAt(this.bp + i19);
                i12 = i19 + 1;
            } else {
                if (cCharAt == ']') {
                    int i21 = i19 + 1;
                    char cCharAt4 = charAt(this.bp + i19);
                    if (i20 != fArr2.length) {
                        float[] fArr5 = new float[i20];
                        System.arraycopy(fArr2, 0, fArr5, 0, i20);
                        fArr2 = fArr5;
                    }
                    if (cCharAt4 == ',') {
                        this.bp += i19;
                        next();
                        this.matchStat = 3;
                        this.token = 16;
                        return fArr2;
                    }
                    if (cCharAt4 != '}') {
                        this.matchStat = -1;
                        return fArr3;
                    }
                    char cCharAt5 = charAt(this.bp + i21);
                    if (cCharAt5 == ',') {
                        this.token = 16;
                        this.bp = i19 + 1 + this.bp;
                        next();
                    } else if (cCharAt5 == ']') {
                        this.token = 15;
                        this.bp = i19 + 1 + this.bp;
                        next();
                    } else if (cCharAt5 == '}') {
                        this.token = 13;
                        this.bp = i19 + 1 + this.bp;
                        next();
                    } else {
                        if (cCharAt5 != 26) {
                            this.matchStat = -1;
                            return fArr3;
                        }
                        this.bp = i19 + 1 + this.bp;
                        this.token = 20;
                        this.ch = JSONLexer.EOI;
                    }
                    this.matchStat = 4;
                    return fArr2;
                }
                i12 = i19;
            }
            i13 = i20;
            cCharAt2 = cCharAt;
            fArr = fArr3;
        }
        float[] fArr6 = fArr;
        this.matchStat = -1;
        return fArr6;
    }

    public final float[][] scanFieldFloatArray2(char[] cArr) {
        float[][] fArr;
        int i9;
        int i10;
        char cCharAt;
        int i11;
        int i12;
        float f6;
        int i13;
        int i14;
        int i15;
        char cCharAt2;
        char cCharAt3;
        int i16 = 0;
        this.matchStat = 0;
        float[][] fArr2 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i17 = length + 1;
        char c5 = '[';
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i18 = length + 2;
        char cCharAt4 = charAt(this.bp + i17);
        int i19 = 16;
        float[][] fArr3 = new float[16][];
        int i20 = 0;
        while (true) {
            int i21 = -1;
            if (cCharAt4 != c5) {
                fArr = fArr2;
                i9 = 3;
                break;
            }
            int i22 = i18 + 1;
            char cCharAt5 = charAt(this.bp + i18);
            float[] fArr4 = new float[i19];
            int i23 = i16;
            fArr = fArr2;
            while (true) {
                int i24 = this.bp;
                int i25 = (i24 + i22) - 1;
                int i26 = cCharAt5 == '-' ? 1 : i16;
                if (i26 != 0) {
                    char cCharAt6 = charAt(i24 + i22);
                    i22++;
                    cCharAt5 = cCharAt6;
                }
                if (cCharAt5 >= '0') {
                    i9 = 3;
                    if (cCharAt5 <= '9') {
                        int i27 = cCharAt5 - '0';
                        while (true) {
                            i10 = i22 + 1;
                            cCharAt = charAt(this.bp + i22);
                            if (cCharAt < '0' || cCharAt > '9') {
                                break;
                            }
                            i27 = (i27 * 10) + (cCharAt - '0');
                            i22 = i10;
                        }
                        if (cCharAt == '.') {
                            int i28 = i22 + 2;
                            char cCharAt7 = charAt(this.bp + i10);
                            if (cCharAt7 < '0' || cCharAt7 > '9') {
                                this.matchStat = i21;
                                return fArr;
                            }
                            i27 = (cCharAt7 - '0') + (i27 * 10);
                            int i29 = 10;
                            while (true) {
                                i10 = i28 + 1;
                                cCharAt3 = charAt(this.bp + i28);
                                if (cCharAt3 < '0' || cCharAt3 > '9') {
                                    break;
                                }
                                i27 = (i27 * 10) + (cCharAt3 - '0');
                                i29 *= 10;
                                i28 = i10;
                            }
                            i11 = i29;
                            cCharAt = cCharAt3;
                        } else {
                            i11 = 1;
                        }
                        boolean z8 = cCharAt == 'e' || cCharAt == 'E';
                        if (z8) {
                            int i30 = i10 + 1;
                            cCharAt = charAt(this.bp + i10);
                            if (cCharAt == '+' || cCharAt == '-') {
                                i10 += 2;
                                cCharAt = charAt(this.bp + i30);
                            } else {
                                i10 = i30;
                            }
                            while (cCharAt >= '0' && cCharAt <= '9') {
                                char cCharAt8 = charAt(this.bp + i10);
                                i10++;
                                cCharAt = cCharAt8;
                            }
                        }
                        i12 = i10;
                        int iA = f.a(this.bp, i12, i25, 1);
                        if (z8 || iA >= 10) {
                            f6 = Float.parseFloat(subString(i25, iA));
                        } else {
                            f6 = i27 / i11;
                            if (i26 != 0) {
                                f6 = -f6;
                            }
                        }
                        if (i23 >= fArr4.length) {
                            float[] fArr5 = new float[(fArr4.length * 3) / 2];
                            System.arraycopy(fArr4, 0, fArr5, 0, i23);
                            fArr4 = fArr5;
                        }
                        i13 = i23 + 1;
                        fArr4[i23] = f6;
                        if (cCharAt == ',') {
                            cCharAt2 = charAt(this.bp + i12);
                            i22 = i12 + 1;
                        } else {
                            if (cCharAt == ']') {
                                break;
                            }
                            i22 = i12;
                            cCharAt2 = cCharAt;
                        }
                        i23 = i13;
                        i21 = -1;
                        cCharAt5 = cCharAt2;
                        i16 = 0;
                    }
                }
                this.matchStat = i21;
                return fArr;
            }
            int i31 = i12 + 1;
            char cCharAt9 = charAt(this.bp + i12);
            if (i13 != fArr4.length) {
                float[] fArr6 = new float[i13];
                i14 = 0;
                System.arraycopy(fArr4, 0, fArr6, 0, i13);
                fArr4 = fArr6;
            } else {
                i14 = 0;
            }
            if (i20 >= fArr3.length) {
                fArr3 = new float[(fArr3.length * 3) / 2][];
                System.arraycopy(fArr4, i14, fArr3, i14, i13);
            }
            int i32 = i20 + 1;
            fArr3[i20] = fArr4;
            if (cCharAt9 == ',') {
                i15 = i12 + 2;
                cCharAt9 = charAt(this.bp + i31);
            } else {
                if (cCharAt9 == ']') {
                    i20 = i32;
                    i18 = i12 + 2;
                    cCharAt4 = charAt(this.bp + i31);
                    break;
                }
                i15 = i31;
            }
            cCharAt4 = cCharAt9;
            i20 = i32;
            i18 = i15;
            fArr2 = fArr;
            i16 = 0;
            i19 = 16;
            c5 = '[';
        }
        if (i20 != fArr3.length) {
            float[][] fArr7 = new float[i20][];
            System.arraycopy(fArr3, 0, fArr7, 0, i20);
            fArr3 = fArr7;
        }
        if (cCharAt4 == ',') {
            this.bp = (i18 - 1) + this.bp;
            next();
            this.matchStat = i9;
            this.token = 16;
            return fArr3;
        }
        if (cCharAt4 != '}') {
            this.matchStat = -1;
            return fArr;
        }
        char cCharAt10 = charAt(this.bp + i18);
        if (cCharAt10 == ',') {
            this.token = 16;
            this.bp += i18;
            next();
        } else if (cCharAt10 == ']') {
            this.token = 15;
            this.bp += i18;
            next();
        } else if (cCharAt10 == '}') {
            this.token = 13;
            this.bp += i18;
            next();
        } else {
            if (cCharAt10 != 26) {
                this.matchStat = -1;
                return fArr;
            }
            this.bp += i18;
            this.token = 20;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return fArr3;
    }

    public int scanFieldInt(char[] cArr) {
        int i9;
        char cCharAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i10 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        boolean z8 = cCharAt2 == '-';
        if (z8) {
            cCharAt2 = charAt(this.bp + i10);
            i10 = length + 2;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i11 = cCharAt2 - '0';
        while (true) {
            i9 = i10 + 1;
            cCharAt = charAt(this.bp + i10);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i11 = (i11 * 10) + (cCharAt - '0');
            i10 = i9;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if ((i11 < 0 || i9 > cArr.length + 14) && !(i11 == Integer.MIN_VALUE && i9 == 17 && z8)) {
            this.matchStat = -1;
            return 0;
        }
        if (cCharAt == ',') {
            int i12 = this.bp + i9;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            if (z8) {
                return -i11;
            }
        } else {
            if (cCharAt != '}') {
                this.matchStat = -1;
                return 0;
            }
            int i13 = i10 + 2;
            char cCharAt3 = charAt(this.bp + i9);
            if (cCharAt3 == ',') {
                this.token = 16;
                int i14 = this.bp + i13;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (cCharAt3 == ']') {
                this.token = 15;
                int i15 = this.bp + i13;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (cCharAt3 == '}') {
                this.token = 13;
                int i16 = this.bp + i13;
                this.bp = i16;
                this.ch = charAt(i16);
            } else {
                if (cCharAt3 != 26) {
                    this.matchStat = -1;
                    return 0;
                }
                this.token = 20;
                this.bp = i10 + 1 + this.bp;
                this.ch = JSONLexer.EOI;
            }
            this.matchStat = 4;
            if (z8) {
                return -i11;
            }
        }
        return i11;
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z8;
        int[] iArr;
        int i9;
        char cCharAt;
        int i10;
        char cCharAt2;
        int i11;
        this.matchStat = 0;
        int[] iArr2 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i12 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i13 = length + 2;
        char cCharAt3 = charAt(this.bp + i12);
        int[] iArr3 = new int[16];
        if (cCharAt3 == ']') {
            i11 = length + 3;
            cCharAt2 = charAt(this.bp + i13);
            i10 = 0;
            iArr = null;
        } else {
            int i14 = 0;
            while (true) {
                if (cCharAt3 == '-') {
                    cCharAt3 = charAt(this.bp + i13);
                    i13++;
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (cCharAt3 < '0' || cCharAt3 > '9') {
                    int[] iArr4 = iArr2;
                    this.matchStat = -1;
                    return iArr4;
                }
                int i15 = cCharAt3 - '0';
                iArr = iArr2;
                while (true) {
                    i9 = i13 + 1;
                    cCharAt = charAt(this.bp + i13);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    i15 = (i15 * 10) + (cCharAt - '0');
                    i13 = i9;
                }
                if (i14 >= iArr3.length) {
                    int[] iArr5 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr5, 0, i14);
                    iArr3 = iArr5;
                }
                i10 = i14 + 1;
                if (z8) {
                    i15 = -i15;
                }
                iArr3[i14] = i15;
                if (cCharAt == ',') {
                    i13 += 2;
                    cCharAt3 = charAt(this.bp + i9);
                } else {
                    if (cCharAt == ']') {
                        cCharAt2 = charAt(this.bp + i9);
                        i11 = i13 + 2;
                        break;
                    }
                    cCharAt3 = cCharAt;
                    i13 = i9;
                }
                i14 = i10;
                iArr2 = iArr;
            }
        }
        if (i10 != iArr3.length) {
            int[] iArr6 = new int[i10];
            System.arraycopy(iArr3, 0, iArr6, 0, i10);
            iArr3 = iArr6;
        }
        if (cCharAt2 == ',') {
            this.bp = (i11 - 1) + this.bp;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr3;
        }
        if (cCharAt2 != '}') {
            this.matchStat = -1;
            return iArr;
        }
        char cCharAt4 = charAt(this.bp + i11);
        if (cCharAt4 == ',') {
            this.token = 16;
            this.bp += i11;
            next();
        } else if (cCharAt4 == ']') {
            this.token = 15;
            this.bp += i11;
            next();
        } else if (cCharAt4 == '}') {
            this.token = 13;
            this.bp += i11;
            next();
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return iArr;
            }
            this.bp += i11;
            this.token = 20;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return iArr3;
    }

    public long scanFieldLong(char[] cArr) {
        int i9;
        char cCharAt;
        boolean z8 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i10 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        if (cCharAt2 == '-') {
            cCharAt2 = charAt(this.bp + i10);
            i10 = length + 2;
            z8 = true;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = cCharAt2 - '0';
        while (true) {
            i9 = i10 + 1;
            cCharAt = charAt(this.bp + i10);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j = (j * 10) + ((long) (cCharAt - '0'));
            i10 = i9;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (i9 - cArr.length >= 21 || (j < 0 && !(j == Long.MIN_VALUE && z8))) {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt == ',') {
            int i11 = this.bp + i9;
            this.bp = i11;
            this.ch = charAt(i11);
            this.matchStat = 3;
            this.token = 16;
            if (z8) {
                return -j;
            }
        } else {
            if (cCharAt != '}') {
                this.matchStat = -1;
                return 0L;
            }
            int i12 = i10 + 2;
            char cCharAt3 = charAt(this.bp + i9);
            if (cCharAt3 == ',') {
                this.token = 16;
                int i13 = this.bp + i12;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (cCharAt3 == ']') {
                this.token = 15;
                int i14 = this.bp + i12;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (cCharAt3 == '}') {
                this.token = 13;
                int i15 = this.bp + i12;
                this.bp = i15;
                this.ch = charAt(i15);
            } else {
                if (cCharAt3 != 26) {
                    this.matchStat = -1;
                    return 0L;
                }
                this.token = 20;
                this.bp = i10 + 1 + this.bp;
                this.ch = JSONLexer.EOI;
            }
            this.matchStat = 4;
            if (z8) {
                return -j;
            }
        }
        return j;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i9 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int iIndexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.bp + cArr.length + 1;
        String strSubString = subString(length2, iIndexOf - length2);
        if (strSubString.indexOf(92) != -1) {
            while (true) {
                int i10 = 0;
                for (int i11 = iIndexOf - 1; i11 >= 0 && charAt(i11) == '\\'; i11--) {
                    i10++;
                }
                if (i10 % 2 == 0) {
                    break;
                }
                iIndexOf = indexOf('\"', iIndexOf + 1);
            }
            int i12 = this.bp;
            int length3 = iIndexOf - ((cArr.length + i12) + 1);
            strSubString = readString(sub_chars(i12 + cArr.length + 1, length3), length3);
        }
        int i13 = this.bp;
        int length4 = (iIndexOf - ((cArr.length + i13) + 1)) + 1 + i9;
        int i14 = length4 + 1;
        char cCharAt = charAt(i13 + length4);
        if (cCharAt == ',') {
            int i15 = this.bp + i14;
            this.bp = i15;
            this.ch = charAt(i15);
            this.matchStat = 3;
            return strSubString;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int i16 = length4 + 2;
        char cCharAt2 = charAt(this.bp + i14);
        if (cCharAt2 == ',') {
            this.token = 16;
            int i17 = this.bp + i16;
            this.bp = i17;
            this.ch = charAt(i17);
        } else if (cCharAt2 == ']') {
            this.token = 15;
            int i18 = this.bp + i16;
            this.bp = i18;
            this.ch = charAt(i18);
        } else if (cCharAt2 == '}') {
            this.token = 13;
            int i19 = this.bp + i16;
            this.bp = i19;
            this.ch = charAt(i19);
        } else {
            if (cCharAt2 != 26) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.token = 20;
            this.bp = length4 + 1 + this.bp;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return strSubString;
    }

    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        int i9;
        char cCharAt;
        int i10;
        char cCharAt2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> collectionNewCollectionByType = newCollectionByType(cls);
        int length = cArr.length;
        int i11 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i12 = length + 2;
        char cCharAt3 = charAt(this.bp + i11);
        while (true) {
            if (cCharAt3 == '\"') {
                int iIndexOf = indexOf('\"', this.bp + i12);
                if (iIndexOf == -1) {
                    throw new JSONException("unclosed str");
                }
                int i13 = this.bp + i12;
                String strSubString = subString(i13, iIndexOf - i13);
                if (strSubString.indexOf(92) != -1) {
                    while (true) {
                        int i14 = 0;
                        for (int i15 = iIndexOf - 1; i15 >= 0 && charAt(i15) == '\\'; i15--) {
                            i14++;
                        }
                        if (i14 % 2 == 0) {
                            break;
                        }
                        iIndexOf = indexOf('\"', iIndexOf + 1);
                    }
                    int i16 = this.bp;
                    int i17 = iIndexOf - (i16 + i12);
                    strSubString = readString(sub_chars(i16 + i12, i17), i17);
                }
                int i18 = this.bp;
                int i19 = (iIndexOf - (i18 + i12)) + 1 + i12;
                i10 = i19 + 1;
                cCharAt2 = charAt(i18 + i19);
                collectionNewCollectionByType.add(strSubString);
            } else {
                if (cCharAt3 != 'n' || charAt(this.bp + i12) != 'u' || e.g(this.bp, i12, 1, this) != 'l' || e.g(this.bp, i12, 2, this) != 'l') {
                    if (cCharAt3 != ']' || collectionNewCollectionByType.size() != 0) {
                        throw new JSONException("illega str");
                    }
                    i9 = i12 + 1;
                    cCharAt = charAt(this.bp + i12);
                    break;
                }
                int i20 = i12 + 3;
                i10 = i12 + 4;
                cCharAt2 = charAt(this.bp + i20);
                collectionNewCollectionByType.add(null);
            }
            if (cCharAt2 != ',') {
                if (cCharAt2 != ']') {
                    this.matchStat = -1;
                    return null;
                }
                i9 = i10 + 1;
                cCharAt = charAt(this.bp + i10);
                break;
            }
            cCharAt3 = charAt(this.bp + i10);
            i12 = i10 + 1;
        }
        if (cCharAt == ',') {
            int i21 = this.bp + i9;
            this.bp = i21;
            this.ch = charAt(i21);
            this.matchStat = 3;
            return collectionNewCollectionByType;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i22 = i9 + 1;
        char cCharAt4 = charAt(this.bp + i9);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i23 = this.bp + i22;
            this.bp = i23;
            this.ch = charAt(i23);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i24 = this.bp + i22;
            this.bp = i24;
            this.ch = charAt(i24);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i25 = this.bp + i22;
            this.bp = i25;
            this.ch = charAt(i25);
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.bp += i9;
            this.token = 20;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return collectionNewCollectionByType;
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i9 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i10 = i9 + 1;
            char cCharAt = charAt(this.bp + i9);
            if (cCharAt == '\"') {
                int i11 = i9 + 2;
                char cCharAt2 = charAt(this.bp + i10);
                if (cCharAt2 == ',') {
                    int i12 = this.bp + i11;
                    this.bp = i12;
                    this.ch = charAt(i12);
                    this.matchStat = 3;
                    return j;
                }
                if (cCharAt2 != '}') {
                    this.matchStat = -1;
                    return 0L;
                }
                int i13 = i9 + 3;
                char cCharAt3 = charAt(this.bp + i11);
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i14 = this.bp + i13;
                    this.bp = i14;
                    this.ch = charAt(i14);
                } else if (cCharAt3 == ']') {
                    this.token = 15;
                    int i15 = this.bp + i13;
                    this.bp = i15;
                    this.ch = charAt(i15);
                } else if (cCharAt3 == '}') {
                    this.token = 13;
                    int i16 = this.bp + i13;
                    this.bp = i16;
                    this.ch = charAt(i16);
                } else {
                    if (cCharAt3 != 26) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.token = 20;
                    this.bp = i9 + 2 + this.bp;
                    this.ch = JSONLexer.EOI;
                }
                this.matchStat = 4;
                return j;
            }
            j = (j ^ ((long) cCharAt)) * TypeUtils.fnv1a_64_magic_prime;
            if (cCharAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i9 = i10;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        UUID uuid;
        int i9;
        int i10;
        char cCharAt;
        UUID uuid2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i18 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        if (cCharAt2 != '\"') {
            uuid = null;
            i9 = 4;
            if (cCharAt2 == 'n') {
                int i19 = length + 2;
                if (charAt(this.bp + i18) == 'u') {
                    int i20 = length + 3;
                    if (charAt(this.bp + i19) == 'l') {
                        int i21 = length + 4;
                        if (charAt(this.bp + i20) == 'l') {
                            i10 = length + 5;
                            cCharAt = charAt(this.bp + i21);
                            uuid2 = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        int iIndexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.bp + cArr.length + 1;
        int i22 = iIndexOf - length2;
        char c5 = 'F';
        uuid = null;
        char c9 = 'A';
        char c10 = 'f';
        char c11 = 'a';
        i9 = 4;
        if (i22 == 36) {
            int i23 = 0;
            long j = 0;
            while (i23 < 8) {
                char cCharAt3 = charAt(length2 + i23);
                if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                    i17 = cCharAt3 - '0';
                } else if (cCharAt3 >= 'a' && cCharAt3 <= 'f') {
                    i17 = cCharAt3 - 'W';
                } else {
                    if (cCharAt3 < 'A' || cCharAt3 > c5) {
                        this.matchStat = -2;
                        return null;
                    }
                    i17 = cCharAt3 - '7';
                }
                j = (j << 4) | ((long) i17);
                i23++;
                iIndexOf = iIndexOf;
                c5 = 'F';
            }
            int i24 = iIndexOf;
            int i25 = 9;
            for (int i26 = 13; i25 < i26; i26 = 13) {
                char cCharAt4 = charAt(length2 + i25);
                if (cCharAt4 >= '0' && cCharAt4 <= '9') {
                    i16 = cCharAt4 - '0';
                } else if (cCharAt4 >= 'a' && cCharAt4 <= 'f') {
                    i16 = cCharAt4 - 'W';
                } else {
                    if (cCharAt4 < 'A' || cCharAt4 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i16 = cCharAt4 - '7';
                }
                j = (j << 4) | ((long) i16);
                i25++;
            }
            int i27 = 14;
            long j8 = j;
            while (i27 < 18) {
                char cCharAt5 = charAt(length2 + i27);
                if (cCharAt5 >= '0' && cCharAt5 <= '9') {
                    i15 = cCharAt5 - '0';
                } else if (cCharAt5 >= 'a' && cCharAt5 <= 'f') {
                    i15 = cCharAt5 - 'W';
                } else {
                    if (cCharAt5 < c9 || cCharAt5 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i15 = cCharAt5 - '7';
                }
                j8 = (j8 << 4) | ((long) i15);
                i27++;
                length2 = length2;
                c9 = 'A';
            }
            int i28 = length2;
            int i29 = 19;
            long j9 = 0;
            while (i29 < 23) {
                char cCharAt6 = charAt(i28 + i29);
                if (cCharAt6 >= '0' && cCharAt6 <= '9') {
                    i14 = cCharAt6 - '0';
                } else if (cCharAt6 >= c11 && cCharAt6 <= c10) {
                    i14 = cCharAt6 - 'W';
                } else {
                    if (cCharAt6 < 'A' || cCharAt6 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i14 = cCharAt6 - '7';
                }
                j9 = (j9 << 4) | ((long) i14);
                i29++;
                c10 = 'f';
                c11 = 'a';
            }
            long j10 = j9;
            for (int i30 = 24; i30 < 36; i30++) {
                char cCharAt7 = charAt(i28 + i30);
                if (cCharAt7 >= '0' && cCharAt7 <= '9') {
                    i13 = cCharAt7 - '0';
                } else if (cCharAt7 >= 'a' && cCharAt7 <= 'f') {
                    i13 = cCharAt7 - 'W';
                } else {
                    if (cCharAt7 < 'A' || cCharAt7 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i13 = cCharAt7 - '7';
                }
                j10 = (j10 << 4) | ((long) i13);
            }
            uuid2 = new UUID(j8, j10);
            int i31 = this.bp;
            int length3 = (i24 - ((cArr.length + i31) + 1)) + 1 + i18;
            i10 = length3 + 1;
            cCharAt = charAt(i31 + length3);
        } else {
            if (i22 != 32) {
                this.matchStat = -1;
                return null;
            }
            long j11 = 0;
            for (int i32 = 0; i32 < 16; i32++) {
                char cCharAt8 = charAt(length2 + i32);
                if (cCharAt8 >= '0' && cCharAt8 <= '9') {
                    i12 = cCharAt8 - '0';
                } else if (cCharAt8 >= 'a' && cCharAt8 <= 'f') {
                    i12 = cCharAt8 - 'W';
                } else {
                    if (cCharAt8 < 'A' || cCharAt8 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i12 = cCharAt8 - '7';
                }
                j11 = (j11 << 4) | ((long) i12);
            }
            int i33 = 16;
            long j12 = 0;
            for (int i34 = 32; i33 < i34; i34 = 32) {
                char cCharAt9 = charAt(length2 + i33);
                if (cCharAt9 >= '0' && cCharAt9 <= '9') {
                    i11 = cCharAt9 - '0';
                } else if (cCharAt9 >= 'a' && cCharAt9 <= 'f') {
                    i11 = cCharAt9 - 'W';
                } else {
                    if (cCharAt9 < 'A' || cCharAt9 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i11 = cCharAt9 - '7';
                }
                j12 = (j12 << 4) | ((long) i11);
                i33++;
            }
            uuid2 = new UUID(j11, j12);
            int i35 = this.bp;
            int length4 = (iIndexOf - ((cArr.length + i35) + 1)) + 1 + i18;
            i10 = length4 + 1;
            cCharAt = charAt(i35 + length4);
        }
        if (cCharAt == ',') {
            int i36 = this.bp + i10;
            this.bp = i36;
            this.ch = charAt(i36);
            this.matchStat = 3;
            return uuid2;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return uuid;
        }
        int i37 = i10 + 1;
        char cCharAt10 = charAt(this.bp + i10);
        if (cCharAt10 == ',') {
            this.token = 16;
            int i38 = this.bp + i37;
            this.bp = i38;
            this.ch = charAt(i38);
        } else if (cCharAt10 == ']') {
            this.token = 15;
            int i39 = this.bp + i37;
            this.bp = i39;
            this.ch = charAt(i39);
        } else if (cCharAt10 == '}') {
            this.token = 13;
            int i40 = this.bp + i37;
            this.bp = i40;
            this.ch = charAt(i40);
        } else {
            if (cCharAt10 != 26) {
                this.matchStat = -1;
                return uuid;
            }
            this.token = 20;
            this.bp += i10;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = i9;
        return uuid2;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c6 -> B:50:0x00b4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final float scanFloat(char r24) {
        /*
            Method dump skipped, instruction units count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFloat(char):float");
    }

    public final void scanHex() {
        char next;
        if (this.ch != 'x') {
            throw new JSONException("illegal state. " + this.ch);
        }
        next();
        if (this.ch != '\'') {
            throw new JSONException("illegal state. " + this.ch);
        }
        this.np = this.bp;
        next();
        if (this.ch == '\'') {
            next();
            this.token = 26;
            return;
        }
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.sp++;
            }
        }
        if (next != '\'') {
            throw new JSONException("illegal state. " + next);
        }
        this.sp++;
        next();
        this.token = 26;
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String strStringVal = stringVal();
        if ("null".equalsIgnoreCase(strStringVal)) {
            this.token = 8;
            return;
        }
        if ("new".equals(strStringVal)) {
            this.token = 9;
            return;
        }
        if ("true".equals(strStringVal)) {
            this.token = 6;
            return;
        }
        if ("false".equals(strStringVal)) {
            this.token = 7;
            return;
        }
        if ("undefined".equals(strStringVal)) {
            this.token = 23;
            return;
        }
        if ("Set".equals(strStringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(strStringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c5) {
        int i9;
        int i10;
        char cCharAt;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        boolean z8 = cCharAt2 == '\"';
        if (z8) {
            cCharAt2 = charAt(this.bp + 1);
            i9 = 2;
        } else {
            i9 = 1;
        }
        boolean z9 = cCharAt2 == '-';
        if (z9) {
            cCharAt2 = charAt(this.bp + i9);
            i9++;
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            int i11 = cCharAt2 - '0';
            while (true) {
                i10 = i9 + 1;
                cCharAt = charAt(this.bp + i9);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i11 = (i11 * 10) + (cCharAt - '0');
                i9 = i10;
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (i11 < 0) {
                this.matchStat = -1;
                return 0;
            }
            while (cCharAt != c5) {
                if (!isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    if (z9) {
                        return -i11;
                    }
                    return i11;
                }
                char cCharAt3 = charAt(this.bp + i10);
                i10++;
                cCharAt = cCharAt3;
            }
            int i12 = this.bp + i10;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            if (z9) {
                return -i11;
            }
            return i11;
        }
        if (cCharAt2 != 'n' || charAt(this.bp + i9) != 'u' || e.g(this.bp, i9, 1, this) != 'l' || e.g(this.bp, i9, 2, this) != 'l') {
            this.matchStat = -1;
            return 0;
        }
        this.matchStat = 5;
        int i13 = i9 + 4;
        char cCharAt4 = charAt(this.bp + i9 + 3);
        if (z8 && cCharAt4 == '\"') {
            cCharAt4 = charAt(this.bp + i13);
            i13 = i9 + 5;
        }
        while (cCharAt4 != ',') {
            if (cCharAt4 == ']') {
                int i14 = this.bp + i13;
                this.bp = i14;
                this.ch = charAt(i14);
                this.matchStat = 5;
                this.token = 15;
                return 0;
            }
            if (!isWhitespace(cCharAt4)) {
                this.matchStat = -1;
                return 0;
            }
            cCharAt4 = charAt(this.bp + i13);
            i13++;
        }
        int i15 = this.bp + i13;
        this.bp = i15;
        this.ch = charAt(i15);
        this.matchStat = 5;
        this.token = 16;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c5) {
        int i9;
        int i10;
        char cCharAt;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        boolean z8 = cCharAt2 == '\"';
        if (z8) {
            cCharAt2 = charAt(this.bp + 1);
            i9 = 2;
        } else {
            i9 = 1;
        }
        boolean z9 = cCharAt2 == '-';
        if (z9) {
            cCharAt2 = charAt(this.bp + i9);
            i9++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 != 'n' || charAt(this.bp + i9) != 'u' || e.g(this.bp, i9, 1, this) != 'l' || e.g(this.bp, i9, 2, this) != 'l') {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 5;
            int i11 = i9 + 4;
            char cCharAt3 = charAt(this.bp + i9 + 3);
            if (z8 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.bp + i11);
                i11 = i9 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == ']') {
                    int i12 = this.bp + i11;
                    this.bp = i12;
                    this.ch = charAt(i12);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0L;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return 0L;
                }
                cCharAt3 = charAt(this.bp + i11);
                i11++;
            }
            int i13 = this.bp + i11;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 5;
            this.token = 16;
            return 0L;
        }
        long j = cCharAt2 - '0';
        while (true) {
            i10 = i9 + 1;
            cCharAt = charAt(this.bp + i9);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j = (j * 10) + ((long) (cCharAt - '0'));
            i9 = i10;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (j < 0 && (j != Long.MIN_VALUE || !z9)) {
            throw new NumberFormatException(subString(this.bp, i9));
        }
        if (z8) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0L;
            }
            cCharAt = charAt(this.bp + i10);
            i10 = i9 + 2;
        }
        while (cCharAt != c5) {
            if (!isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return j;
            }
            cCharAt = charAt(this.bp + i10);
            i10++;
        }
        int i14 = this.bp + i10;
        this.bp = i14;
        this.ch = charAt(i14);
        this.matchStat = 3;
        this.token = 16;
        return z9 ? -j : j;
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c6  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanNumber() {
        char c5;
        boolean z8;
        char c9;
        this.np = this.bp;
        boolean z9 = true;
        if (this.ch == '-') {
            this.sp++;
            next();
        }
        while (true) {
            c5 = this.ch;
            if (c5 < '0' || c5 > '9') {
                break;
            }
            this.sp++;
            next();
        }
        if (c5 == '.') {
            this.sp++;
            next();
            while (true) {
                char c10 = this.ch;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                this.sp++;
                next();
            }
            z8 = true;
        } else {
            z8 = false;
        }
        int i9 = this.sp;
        if (i9 > 65535) {
            throw new JSONException("scanNumber overflow");
        }
        char c11 = this.ch;
        if (c11 != 'L' && c11 != 'S' && c11 != 'B') {
            if (c11 == 'F' || c11 == 'D') {
                this.sp = i9 + 1;
                next();
            } else if (c11 == 'e' || c11 == 'E') {
                this.sp = i9 + 1;
                next();
                char c12 = this.ch;
                if (c12 == '+' || c12 == '-') {
                    this.sp++;
                    next();
                }
                while (true) {
                    c9 = this.ch;
                    if (c9 < '0' || c9 > '9') {
                        break;
                    }
                    this.sp++;
                    next();
                }
                if (c9 == 'D' || c9 == 'F') {
                    this.sp++;
                    next();
                }
            }
            if (z9) {
                this.token = 3;
            } else {
                this.token = 2;
            }
        }
        this.sp = i9 + 1;
        next();
        z9 = z8;
        if (z9) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            }
            if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed string : " + next);
                }
                putChar(JSONLexer.EOI);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i9 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i9 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i9 <= length) {
                            i9 = length;
                        }
                        char[] cArr2 = new char[i9];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        break;
                                    case '0':
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                boolean z8 = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                boolean z9 = (next4 >= '0' && next4 <= '9') || (next4 >= 'a' && next4 <= 'f') || (next4 >= 'A' && next4 <= 'F');
                                if (!z8 || !z9) {
                                    throw new JSONException("invalid escape character \\x" + next3 + next4);
                                }
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i10 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i10 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i10 + 1;
                    cArr3[i10] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void scanStringArray(Collection<String> collection, char c5) {
        int i9;
        char cCharAt;
        int i10;
        char cCharAt2;
        this.matchStat = 0;
        char cCharAt3 = charAt(this.bp);
        char c9 = 'u';
        char c10 = 'l';
        int i11 = 2;
        if (cCharAt3 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l' && charAt(this.bp + 4) == c5) {
            int i12 = this.bp + 5;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 5;
            return;
        }
        if (cCharAt3 != '[') {
            this.matchStat = -1;
            return;
        }
        char cCharAt4 = charAt(this.bp + 1);
        int i13 = 2;
        while (true) {
            if (cCharAt4 == 'n' && charAt(this.bp + i13) == c9 && e.g(this.bp, i13, 1, this) == c10 && e.g(this.bp, i13, i11, this) == c10) {
                int i14 = i13 + 3;
                i9 = i13 + 4;
                cCharAt = charAt(this.bp + i14);
                collection.add(null);
            } else {
                if (cCharAt4 == ']' && collection.size() == 0) {
                    i10 = i13 + 1;
                    cCharAt2 = charAt(this.bp + i13);
                    break;
                }
                if (cCharAt4 != '\"') {
                    this.matchStat = -1;
                    return;
                }
                int i15 = this.bp + i13;
                int iIndexOf = indexOf('\"', i15);
                if (iIndexOf == -1) {
                    throw new JSONException("unclosed str");
                }
                String strSubString = subString(this.bp + i13, iIndexOf - i15);
                if (strSubString.indexOf(92) != -1) {
                    while (true) {
                        int i16 = 0;
                        for (int i17 = iIndexOf - 1; i17 >= 0 && charAt(i17) == '\\'; i17--) {
                            i16++;
                        }
                        if (i16 % 2 == 0) {
                            break;
                        } else {
                            iIndexOf = indexOf('\"', iIndexOf + 1);
                        }
                    }
                    int i18 = iIndexOf - i15;
                    strSubString = readString(sub_chars(this.bp + i13, i18), i18);
                }
                int i19 = this.bp;
                int i20 = (iIndexOf - (i19 + i13)) + 1 + i13;
                i9 = i20 + 1;
                cCharAt = charAt(i19 + i20);
                collection.add(strSubString);
            }
            if (cCharAt != ',') {
                if (cCharAt == ']') {
                    i10 = i9 + 1;
                    cCharAt2 = charAt(this.bp + i9);
                    break;
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
            char cCharAt5 = charAt(this.bp + i9);
            i13 = i9 + 1;
            c9 = 'u';
            c10 = 'l';
            i11 = 2;
            cCharAt4 = cCharAt5;
        }
        if (cCharAt2 != c5) {
            this.matchStat = -1;
            return;
        }
        int i21 = this.bp + i10;
        this.bp = i21;
        this.ch = charAt(i21);
        this.matchStat = 3;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c5 = this.ch;
        if (c5 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c5 == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        }
        if (c5 == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c5 == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c5 == 26) {
            this.token = 20;
            return null;
        }
        if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        }
        throw new JSONException("syntax error");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i9 = this.ch;
        if (i9 < zArr.length && !zArr[i9]) {
            throw new JSONException("illegal identifier : " + this.ch + info());
        }
        boolean[] zArr2 = IOUtils.identifierFlags;
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i9 = (i9 * 31) + next;
            this.sp++;
        }
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && i9 == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
            return null;
        }
        return symbolTable == null ? subString(this.np, this.sp) : addSymbol(this.np, this.sp, i9, symbolTable);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c5) {
        int i9 = 0;
        this.matchStat = 0;
        char cCharAt = charAt(this.bp);
        if (cCharAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            if (charAt(this.bp + 4) != c5) {
                this.matchStat = -1;
                return null;
            }
            int i10 = this.bp + 5;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            return null;
        }
        if (cCharAt != '\"') {
            this.matchStat = -1;
            return null;
        }
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char cCharAt2 = charAt(this.bp + i11);
            if (cCharAt2 == '\"') {
                int i13 = this.bp;
                int i14 = i13 + 1;
                String strAddSymbol = addSymbol(i14, f.a(i13, i12, i14, 1), i9, symbolTable);
                int i15 = i11 + 2;
                char cCharAt3 = charAt(this.bp + i12);
                while (cCharAt3 != c5) {
                    if (!isWhitespace(cCharAt3)) {
                        this.matchStat = -1;
                        return strAddSymbol;
                    }
                    cCharAt3 = charAt(this.bp + i15);
                    i15++;
                }
                int i16 = this.bp + i15;
                this.bp = i16;
                this.ch = charAt(i16);
                this.matchStat = 3;
                return strAddSymbol;
            }
            i9 = (i9 * 31) + cCharAt2;
            if (cCharAt2 == '\\') {
                this.matchStat = -1;
                return null;
            }
            i11 = i12;
        }
    }

    public final void scanTrue() {
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c5 = this.ch;
        if (c5 != ' ' && c5 != ',' && c5 != '}' && c5 != ']' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != 26 && c5 != '\f' && c5 != '\b' && c5 != ':' && c5 != '/') {
            throw new JSONException("scan true error");
        }
        this.token = 6;
    }

    public final int scanType(String str) {
        int i9;
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.bp + cArr.length;
        int length2 = str.length();
        for (int i10 = 0; i10 < length2; i10++) {
            if (str.charAt(i10) != charAt(length + i10)) {
                return -1;
            }
        }
        int i11 = length + length2;
        if (charAt(i11) != '\"') {
            return -1;
        }
        int i12 = i11 + 1;
        char cCharAt = charAt(i12);
        this.ch = cCharAt;
        if (cCharAt == ',') {
            int i13 = i11 + 2;
            this.ch = charAt(i13);
            this.bp = i13;
            this.token = 16;
            return 3;
        }
        if (cCharAt == '}') {
            i12 = i11 + 2;
            char cCharAt2 = charAt(i12);
            this.ch = cCharAt2;
            if (cCharAt2 == ',') {
                this.token = 16;
                i9 = i11 + 3;
                this.ch = charAt(i9);
            } else if (cCharAt2 == ']') {
                this.token = 15;
                i9 = i11 + 3;
                this.ch = charAt(i9);
            } else {
                if (cCharAt2 == '}') {
                    this.token = 13;
                    i9 = i11 + 3;
                    this.ch = charAt(i9);
                } else {
                    if (cCharAt2 != 26) {
                        return -1;
                    }
                    this.token = 20;
                }
                this.matchStat = 4;
            }
            i12 = i9;
            this.matchStat = 4;
        }
        this.bp = i12;
        return this.matchStat;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        return null;
    }

    public UUID scanUUID(char c5) {
        UUID uuid;
        int i9;
        int i10;
        char cCharAt;
        int i11;
        UUID uuid2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        if (cCharAt2 == '\"') {
            int iIndexOf = indexOf('\"', this.bp + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i19 = this.bp + 1;
            int i20 = iIndexOf - i19;
            char c9 = 'A';
            uuid = null;
            i9 = 4;
            if (i20 == 36) {
                long j = 0;
                i10 = 3;
                for (int i21 = 0; i21 < 8; i21++) {
                    char cCharAt3 = charAt(i19 + i21);
                    if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                        i18 = cCharAt3 - '0';
                    } else if (cCharAt3 >= 'a' && cCharAt3 <= 'f') {
                        i18 = cCharAt3 - 'W';
                    } else {
                        if (cCharAt3 < 'A' || cCharAt3 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i18 = cCharAt3 - '7';
                    }
                    j = (j << 4) | ((long) i18);
                }
                int i22 = 9;
                for (int i23 = 13; i22 < i23; i23 = 13) {
                    char cCharAt4 = charAt(i19 + i22);
                    if (cCharAt4 >= '0' && cCharAt4 <= '9') {
                        i17 = cCharAt4 - '0';
                    } else if (cCharAt4 >= 'a' && cCharAt4 <= 'f') {
                        i17 = cCharAt4 - 'W';
                    } else {
                        if (cCharAt4 < 'A' || cCharAt4 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i17 = cCharAt4 - '7';
                    }
                    j = (j << 4) | ((long) i17);
                    i22++;
                }
                int i24 = 14;
                long j8 = j;
                while (i24 < 18) {
                    char cCharAt5 = charAt(i19 + i24);
                    if (cCharAt5 >= '0' && cCharAt5 <= '9') {
                        i16 = cCharAt5 - '0';
                    } else if (cCharAt5 >= 'a' && cCharAt5 <= 'f') {
                        i16 = cCharAt5 - 'W';
                    } else {
                        if (cCharAt5 < c9 || cCharAt5 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i16 = cCharAt5 - '7';
                    }
                    j8 = (j8 << 4) | ((long) i16);
                    i24++;
                    iIndexOf = iIndexOf;
                    c9 = 'A';
                }
                int i25 = iIndexOf;
                long j9 = 0;
                for (int i26 = 19; i26 < 23; i26++) {
                    char cCharAt6 = charAt(i19 + i26);
                    if (cCharAt6 >= '0' && cCharAt6 <= '9') {
                        i15 = cCharAt6 - '0';
                    } else if (cCharAt6 >= 'a' && cCharAt6 <= 'f') {
                        i15 = cCharAt6 - 'W';
                    } else {
                        if (cCharAt6 < 'A' || cCharAt6 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i15 = cCharAt6 - '7';
                    }
                    j9 = (j9 << 4) | ((long) i15);
                }
                int i27 = 24;
                long j10 = j9;
                for (int i28 = 36; i27 < i28; i28 = 36) {
                    char cCharAt7 = charAt(i19 + i27);
                    if (cCharAt7 >= '0' && cCharAt7 <= '9') {
                        i14 = cCharAt7 - '0';
                    } else if (cCharAt7 >= 'a' && cCharAt7 <= 'f') {
                        i14 = cCharAt7 - 'W';
                    } else {
                        if (cCharAt7 < 'A' || cCharAt7 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i14 = cCharAt7 - '7';
                    }
                    j10 = (j10 << 4) | ((long) i14);
                    i27++;
                }
                uuid2 = new UUID(j8, j10);
                int i29 = this.bp;
                int i30 = i25 - (i29 + 1);
                int i31 = i30 + 2;
                i11 = i30 + 3;
                cCharAt = charAt(i29 + i31);
            } else {
                i10 = 3;
                if (i20 != 32) {
                    this.matchStat = -1;
                    return null;
                }
                long j11 = 0;
                for (int i32 = 0; i32 < 16; i32++) {
                    char cCharAt8 = charAt(i19 + i32);
                    if (cCharAt8 >= '0' && cCharAt8 <= '9') {
                        i13 = cCharAt8 - '0';
                    } else if (cCharAt8 >= 'a' && cCharAt8 <= 'f') {
                        i13 = cCharAt8 - 'W';
                    } else {
                        if (cCharAt8 < 'A' || cCharAt8 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i13 = cCharAt8 - '7';
                    }
                    j11 = (j11 << 4) | ((long) i13);
                }
                int i33 = 16;
                long j12 = 0;
                for (int i34 = 32; i33 < i34; i34 = 32) {
                    char cCharAt9 = charAt(i19 + i33);
                    if (cCharAt9 < '0' || cCharAt9 > '9') {
                        if (cCharAt9 >= 'a' && cCharAt9 <= 'f') {
                            i12 = cCharAt9 - 'W';
                        } else {
                            if (cCharAt9 < 'A' || cCharAt9 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i12 = cCharAt9 - '7';
                        }
                        j12 = (j12 << 4) | ((long) i12);
                        i33++;
                    } else {
                        i12 = cCharAt9 - '0';
                    }
                    j12 = (j12 << 4) | ((long) i12);
                    i33++;
                }
                uuid2 = new UUID(j11, j12);
                int i35 = this.bp;
                int i36 = iIndexOf - (i35 + 1);
                int i37 = i36 + 2;
                i11 = i36 + 3;
                cCharAt = charAt(i35 + i37);
            }
        } else {
            uuid = null;
            i9 = 4;
            i10 = 3;
            if (cCharAt2 != 'n' || charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            cCharAt = charAt(this.bp + 4);
            i11 = 5;
            uuid2 = null;
        }
        if (cCharAt == ',') {
            int i38 = this.bp + i11;
            this.bp = i38;
            this.ch = charAt(i38);
            this.matchStat = i10;
            return uuid2;
        }
        if (cCharAt != ']') {
            this.matchStat = -1;
            return uuid;
        }
        int i39 = i11 + 1;
        char cCharAt10 = charAt(this.bp + i11);
        if (cCharAt10 == ',') {
            this.token = 16;
            int i40 = this.bp + i39;
            this.bp = i40;
            this.ch = charAt(i40);
        } else if (cCharAt10 == ']') {
            this.token = 15;
            int i41 = this.bp + i39;
            this.bp = i41;
            this.ch = charAt(i41);
        } else if (cCharAt10 == '}') {
            this.token = 13;
            int i42 = this.bp + i39;
            this.bp = i42;
            this.ch = charAt(i42);
        } else {
            if (cCharAt10 != 26) {
                this.matchStat = -1;
                return uuid;
            }
            this.token = 20;
            this.bp += i11;
            this.ch = JSONLexer.EOI;
        }
        this.matchStat = i9;
        return uuid2;
    }

    public boolean seekArrayToItem(int i9) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long j, boolean z8) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToFieldDeepScan(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setFeatures(int i9) {
        this.features = i9;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToken(int i9) {
        this.token = i9;
    }

    public void skipArray() {
        throw new UnsupportedOperationException();
    }

    public void skipComment() {
        char c5;
        next();
        char c9 = this.ch;
        if (c9 == '/') {
            do {
                next();
                c5 = this.ch;
                if (c5 == '\n') {
                    next();
                    return;
                }
            } while (c5 != 26);
            return;
        }
        if (c9 != '*') {
            throw new JSONException("invalid comment");
        }
        next();
        while (true) {
            char c10 = this.ch;
            if (c10 == 26) {
                return;
            }
            if (c10 == '*') {
                next();
                if (this.ch == '/') {
                    next();
                    return;
                }
            } else {
                next();
            }
        }
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c5 = this.ch;
            if (c5 > '/') {
                return;
            }
            if (c5 == ' ' || c5 == '\r' || c5 == '\n' || c5 == '\t' || c5 == '\f' || c5 == '\b') {
                next();
            } else if (c5 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i9, int i10);

    public abstract char[] sub_chars(int i9, int i10);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i9) {
        return (i9 & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i9) {
        nextTokenWithChar(':');
    }

    public final void scanNullOrNew(boolean z8) {
        if (this.ch != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c5 = this.ch;
        if (c5 != 'u') {
            if (c5 != 'e') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            char c9 = this.ch;
            if (c9 != ' ' && c9 != ',' && c9 != '}' && c9 != ']' && c9 != '\n' && c9 != '\r' && c9 != '\t' && c9 != 26 && c9 != '\f' && c9 != '\b') {
                throw new JSONException("scan new error");
            }
            this.token = 9;
            return;
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        char c10 = this.ch;
        if (c10 != ' ' && c10 != ',' && c10 != '}' && c10 != ']' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != 26 && ((c10 != ':' || !z8) && c10 != '\f' && c10 != '\b')) {
            throw new JSONException("scan null error");
        }
        this.token = 8;
    }

    public int seekObjectToField(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    public void skipObject(boolean z8) {
        throw new UnsupportedOperationException();
    }

    public final boolean isEnabled(int i9, int i10) {
        return ((this.features & i10) == 0 && (i9 & i10) == 0) ? false : true;
    }

    public int matchField(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c5) {
        String strAddSymbol;
        char c9;
        this.np = this.bp;
        char c10 = 0;
        this.sp = 0;
        boolean z8 = false;
        int i9 = 0;
        while (true) {
            char next = next();
            if (next == c5) {
                this.token = 4;
                if (!z8) {
                    int i10 = this.np;
                    strAddSymbol = addSymbol(i10 == -1 ? c10 : i10 + 1, this.sp, i9, symbolTable);
                } else {
                    strAddSymbol = symbolTable.addSymbol(this.sbuf, c10, this.sp, i9);
                }
                this.sp = c10;
                next();
                return strAddSymbol;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z8) {
                    int i11 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i11 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i11 <= length) {
                            i11 = length;
                        }
                        char[] cArr2 = new char[i11];
                        System.arraycopy(cArr, c10, cArr2, c10, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.np + 1, this.sbuf, c10, this.sp);
                    z8 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i9 = (i9 * 31) + 34;
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i9 = (i9 * 31) + 92;
                            putChar('\\');
                        } else if (next2 == 'b') {
                            i9 = (i9 * 31) + 8;
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i9 = (i9 * 31) + 10;
                                putChar('\n');
                            } else if (next2 == 'r') {
                                i9 = (i9 * 31) + 13;
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i9 = (i9 * 31) + 47;
                                        putChar('/');
                                        continue;
                                    case '0':
                                        i9 = (i9 * 31) + next2;
                                        putChar(c10);
                                        continue;
                                    case '1':
                                        i9 = (i9 * 31) + next2;
                                        putChar((char) 1);
                                        continue;
                                    case '2':
                                        i9 = (i9 * 31) + next2;
                                        putChar((char) 2);
                                        continue;
                                    case '3':
                                        i9 = (i9 * 31) + next2;
                                        putChar((char) 3);
                                        continue;
                                    case '4':
                                        i9 = (i9 * 31) + next2;
                                        putChar((char) 4);
                                        continue;
                                    case '5':
                                        c9 = c10;
                                        i9 = (i9 * 31) + next2;
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        c9 = c10;
                                        i9 = (i9 * 31) + next2;
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        c9 = c10;
                                        i9 = (i9 * 31) + next2;
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                c9 = c10;
                                                i9 = (i9 * 31) + 9;
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                char next3 = next();
                                                char next4 = next();
                                                char next5 = next();
                                                char next6 = next();
                                                c9 = c10;
                                                char[] cArr3 = new char[4];
                                                cArr3[c9] = next3;
                                                cArr3[1] = next4;
                                                cArr3[2] = next5;
                                                cArr3[3] = next6;
                                                int i12 = Integer.parseInt(new String(cArr3), 16);
                                                i9 = (i9 * 31) + i12;
                                                putChar((char) i12);
                                                break;
                                            case 'v':
                                                i9 = (i9 * 31) + 11;
                                                putChar((char) 11);
                                                continue;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                        break;
                                }
                                c10 = c9;
                            } else {
                                char next7 = next();
                                this.ch = next7;
                                char next8 = next();
                                this.ch = next8;
                                int[] iArr = digits;
                                char c11 = (char) ((iArr[next7] * 16) + iArr[next8]);
                                i9 = (i9 * 31) + c11;
                                putChar(c11);
                            }
                        }
                    }
                    i9 = (i9 * 31) + 12;
                    putChar('\f');
                } else {
                    i9 = (i9 * 31) + 39;
                    putChar('\'');
                }
            } else {
                i9 = (i9 * 31) + next;
                if (!z8) {
                    this.sp++;
                } else {
                    int i13 = this.sp;
                    char[] cArr4 = this.sbuf;
                    if (i13 == cArr4.length) {
                        putChar(next);
                    } else {
                        this.sp = i13 + 1;
                        cArr4[i13] = next;
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:108:0x007b A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i9) {
        this.sp = 0;
        while (true) {
            if (i9 == 2) {
                char c5 = this.ch;
                if (c5 >= '0' && c5 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                if (c5 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c5 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c5 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i9 == 4) {
                char c9 = this.ch;
                if (c9 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                }
                if (c9 >= '0' && c9 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c9 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c9 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i9 != 12) {
                if (i9 == 18) {
                    nextIdent();
                    return;
                }
                if (i9 != 20) {
                    switch (i9) {
                        case 14:
                            char c10 = this.ch;
                            if (c10 == '[') {
                                this.token = 14;
                                next();
                            } else if (c10 == '{') {
                                this.token = 12;
                                next();
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                            }
                            if (this.ch == 26) {
                                this.token = 20;
                            }
                            break;
                        case 16:
                            char c11 = this.ch;
                            if (c11 == ',') {
                                this.token = 16;
                                next();
                            } else if (c11 == '}') {
                                this.token = 13;
                                next();
                            } else if (c11 == ']') {
                                this.token = 15;
                                next();
                            } else if (c11 == 26) {
                                this.token = 20;
                            } else if (c11 == 'n') {
                                scanNullOrNew(false);
                            }
                            break;
                    }
                    return;
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                char c12 = this.ch;
                if (c12 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c12 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            }
            char c13 = this.ch;
            if (c13 != ' ' && c13 != '\n' && c13 != '\r' && c13 != '\t' && c13 != '\f' && c13 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c5) {
        this.matchStat = 0;
        char cCharAt = charAt(this.bp);
        if (cCharAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
                if (charAt(this.bp + 4) == c5) {
                    int i9 = this.bp + 5;
                    this.bp = i9;
                    this.ch = charAt(i9);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        int i10 = 1;
        while (cCharAt != '\"') {
            if (isWhitespace(cCharAt)) {
                cCharAt = charAt(this.bp + i10);
                i10++;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int i11 = this.bp + i10;
        int iIndexOf = indexOf('\"', i11);
        if (iIndexOf != -1) {
            String strSubString = subString(this.bp + i10, iIndexOf - i11);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i12 = 0;
                    for (int i13 = iIndexOf - 1; i13 >= 0 && charAt(i13) == '\\'; i13--) {
                        i12++;
                    }
                    if (i12 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i14 = iIndexOf - i11;
                strSubString = readString(sub_chars(this.bp + 1, i14), i14);
            }
            int i15 = (iIndexOf - i11) + 1 + i10;
            int i16 = i15 + 1;
            char cCharAt2 = charAt(this.bp + i15);
            while (cCharAt2 != c5) {
                if (!isWhitespace(cCharAt2)) {
                    if (cCharAt2 == ']') {
                        int i17 = this.bp + i16;
                        this.bp = i17;
                        this.ch = charAt(i17);
                        this.matchStat = -1;
                    }
                    return strSubString;
                }
                cCharAt2 = charAt(this.bp + i16);
                i16++;
            }
            int i18 = this.bp + i16;
            this.bp = i18;
            this.ch = charAt(i18);
            this.matchStat = 3;
            this.token = 16;
            return strSubString;
        }
        throw new JSONException("unclosed str");
    }

    public String[] scanFieldStringArray(char[] cArr, int i9, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }
}

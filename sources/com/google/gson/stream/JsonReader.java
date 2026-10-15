package com.google.gson.stream;

import W5.e;
import com.google.gson.Strictness;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.bind.JsonTreeReader;
import defpackage.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import p171w.a;

/* JADX INFO: loaded from: classes.dex */
public class JsonReader implements Closeable {
    static final int BUFFER_SIZE = 1024;
    static final int DEFAULT_NESTING_LIMIT = 255;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private Strictness strictness = Strictness.LEGACY_STRICT;
    private int nestingLimit = 255;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    int peeked = 0;
    private int stackSize = 1;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int iDoPeek = jsonReader.peeked;
                if (iDoPeek == 0) {
                    iDoPeek = jsonReader.doPeek();
                }
                if (iDoPeek == 13) {
                    jsonReader.peeked = 9;
                } else if (iDoPeek == 12) {
                    jsonReader.peeked = 8;
                } else {
                    if (iDoPeek != 14) {
                        throw jsonReader.unexpectedTokenError("a name");
                    }
                    jsonReader.peeked = 10;
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    private void checkLenient() throws MalformedJsonException {
        if (this.strictness != Strictness.LENIENT) {
            throw syntaxError("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i9 = this.pos;
        this.pos = i9 - 1;
        if (i9 + 4 <= this.limit || fillBuffer(5)) {
            int i10 = this.pos;
            char[] cArr = this.buffer;
            if (cArr[i10] == ')' && cArr[i10 + 1] == ']' && cArr[i10 + 2] == '}' && cArr[i10 + 3] == '\'' && cArr[i10 + 4] == '\n') {
                this.pos = i10 + 5;
            }
        }
    }

    private boolean fillBuffer(int i9) throws IOException {
        int i10;
        int i11;
        char[] cArr = this.buffer;
        int i12 = this.lineStart;
        int i13 = this.pos;
        this.lineStart = i12 - i13;
        int i14 = this.limit;
        if (i14 != i13) {
            int i15 = i14 - i13;
            this.limit = i15;
            System.arraycopy(cArr, i13, cArr, 0, i15);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i16 = this.limit;
            int i17 = reader.read(cArr, i16, cArr.length - i16);
            if (i17 == -1) {
                return false;
            }
            i10 = this.limit + i17;
            this.limit = i10;
            if (this.lineNumber == 0 && (i11 = this.lineStart) == 0 && i10 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i11 + 1;
                i9++;
            }
        } while (i10 < i9);
        return true;
    }

    private String getPath(boolean z8) {
        StringBuilder sb = new StringBuilder("$");
        int i9 = 0;
        while (true) {
            int i10 = this.stackSize;
            if (i9 >= i10) {
                return sb.toString();
            }
            int i11 = this.stack[i9];
            switch (i11) {
                case 1:
                case 2:
                    int i12 = this.pathIndices[i9];
                    if (z8 && i12 > 0 && i9 == i10 - 1) {
                        i12--;
                    }
                    sb.append('[');
                    sb.append(i12);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.pathNames[i9];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(e.i(i11, "Unknown scope value: "));
            }
            i9++;
        }
    }

    private boolean isLiteral(char c5) throws MalformedJsonException {
        if (c5 == '\t' || c5 == '\n' || c5 == '\f' || c5 == '\r' || c5 == ' ') {
            return false;
        }
        if (c5 != '#') {
            if (c5 == ',') {
                return false;
            }
            if (c5 != '/' && c5 != '=') {
                if (c5 == '{' || c5 == '}' || c5 == ':') {
                    return false;
                }
                if (c5 != ';') {
                    switch (c5) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z8) throws IOException {
        char[] cArr = this.buffer;
        int i9 = this.pos;
        int i10 = this.limit;
        while (true) {
            if (i9 == i10) {
                this.pos = i9;
                if (!fillBuffer(1)) {
                    if (!z8) {
                        return -1;
                    }
                    throw new EOFException("End of input" + locationString());
                }
                i9 = this.pos;
                i10 = this.limit;
            }
            int i11 = i9 + 1;
            char c5 = cArr[i9];
            if (c5 == '\n') {
                this.lineNumber++;
                this.lineStart = i11;
            } else if (c5 != ' ' && c5 != '\r' && c5 != '\t') {
                if (c5 == '/') {
                    this.pos = i11;
                    if (i11 == i10) {
                        this.pos = i9;
                        boolean zFillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!zFillBuffer) {
                        }
                        return c5;
                    }
                    checkLenient();
                    int i12 = this.pos;
                    char c9 = cArr[i12];
                    if (c9 == '*') {
                        this.pos = i12 + 1;
                        if (!skipTo("*/")) {
                            throw syntaxError("Unterminated comment");
                        }
                        i9 = this.pos + 2;
                        i10 = this.limit;
                    } else {
                        if (c9 != '/') {
                            return c5;
                        }
                        this.pos = i12 + 1;
                        skipToEndOfLine();
                        i9 = this.pos;
                        i10 = this.limit;
                    }
                } else {
                    if (c5 != '#') {
                        this.pos = i11;
                        return c5;
                    }
                    this.pos = i11;
                    checkLenient();
                    skipToEndOfLine();
                    i9 = this.pos;
                    i10 = this.limit;
                }
            }
            i9 = i11;
        }
    }

    private String nextQuotedValue(char c5) throws MalformedJsonException {
        int i9;
        char[] cArr = this.buffer;
        StringBuilder sb = null;
        do {
            int i10 = this.pos;
            int i11 = this.limit;
            while (true) {
                int i12 = i11;
                i9 = i10;
                while (true) {
                    if (i10 < i12) {
                        int i13 = i10 + 1;
                        char c9 = cArr[i10];
                        if (this.strictness == Strictness.STRICT && c9 < ' ') {
                            throw syntaxError("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                        }
                        if (c9 == c5) {
                            this.pos = i13;
                            int i14 = (i13 - i9) - 1;
                            if (sb == null) {
                                return new String(cArr, i9, i14);
                            }
                            sb.append(cArr, i9, i14);
                            return sb.toString();
                        }
                        if (c9 == '\\') {
                            this.pos = i13;
                            int i15 = i13 - i9;
                            int i16 = i15 - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max(i15 * 2, 16));
                            }
                            sb.append(cArr, i9, i16);
                            sb.append(readEscapeCharacter());
                            i10 = this.pos;
                            i11 = this.limit;
                        } else {
                            if (c9 == '\n') {
                                this.lineNumber++;
                                this.lineStart = i13;
                            }
                            i10 = i13;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i10 - i9) * 2, 16));
            }
            sb.append(cArr, i9, i10 - i9);
            this.pos = i10;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String nextUnquotedValue() throws MalformedJsonException {
        String string;
        StringBuilder sb = null;
        int i9 = 0;
        while (true) {
            int i10 = 0;
            while (true) {
                int i11 = this.pos;
                if (i11 + i10 < this.limit) {
                    char c5 = this.buffer[i11 + i10];
                    if (c5 != '\t' && c5 != '\n' && c5 != '\f' && c5 != '\r' && c5 != ' ') {
                        if (c5 != '#') {
                            if (c5 != ',') {
                                if (c5 != '/' && c5 != '=') {
                                    if (c5 != '{' && c5 != '}' && c5 != ':') {
                                        if (c5 != ';') {
                                            switch (c5) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i10++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        checkLenient();
                    }
                    i9 = i10;
                } else if (i10 >= this.buffer.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i10, 16));
                    }
                    sb.append(this.buffer, this.pos, i10);
                    this.pos += i10;
                    if (!fillBuffer(1)) {
                    }
                } else if (!fillBuffer(i10 + 1)) {
                    i9 = i10;
                }
                if (sb == null) {
                    string = new String(this.buffer, this.pos, i9);
                } else {
                    sb.append(this.buffer, this.pos, i9);
                    string = sb.toString();
                }
                this.pos += i9;
                return string;
            }
        }
    }

    private int peekKeyword() {
        String str;
        String str2;
        int i9;
        char c5 = this.buffer[this.pos];
        if (c5 == 't' || c5 == 'T') {
            str = "true";
            str2 = "TRUE";
            i9 = 5;
        } else if (c5 == 'f' || c5 == 'F') {
            str = "false";
            str2 = "FALSE";
            i9 = 6;
        } else {
            if (c5 != 'n' && c5 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i9 = 7;
        }
        boolean z8 = this.strictness != Strictness.STRICT;
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (this.pos + i10 >= this.limit && !fillBuffer(i10 + 1)) {
                return 0;
            }
            char c9 = this.buffer[this.pos + i10];
            if (c9 != str.charAt(i10) && (!z8 || c9 != str2.charAt(i10))) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i9;
        return i9;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:85:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x00da  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e1  */
    private int peekNumber() {
        char c5;
        int i9;
        char[] cArr = this.buffer;
        int i10 = this.pos;
        int i11 = this.limit;
        int i12 = 0;
        int i13 = 0;
        char c9 = 0;
        boolean z8 = false;
        int i14 = 1;
        long j = 0;
        while (true) {
            char c10 = 2;
            if (i10 + i13 != i11) {
                c5 = cArr[i10 + i13];
                i9 = i12;
                if (c5 != '+') {
                    if (c5 != 'E' || c5 == 'e') {
                        if (c9 == 2 && c9 != 4) {
                            return i9;
                        }
                        c9 = 5;
                    } else if (c5 == '-') {
                        c10 = 6;
                        if (c9 == 0) {
                            c9 = 1;
                            z8 = true;
                        } else if (c9 != 5) {
                            return i9;
                        }
                    } else if (c5 != '.') {
                        if (c5 < '0' || c5 > '9') {
                            if (!isLiteral(c5)) {
                                break;
                            }
                            return i9;
                        }
                        if (c9 == 1 || c9 == 0) {
                            j = -(c5 - '0');
                        } else if (c9 == 2) {
                            if (j == 0) {
                                return i9;
                            }
                            long j8 = (10 * j) - ((long) (c5 - '0'));
                            i14 &= (j > -922337203685477580L || (j == -922337203685477580L && j8 < j)) ? 1 : i9;
                            j = j8;
                        } else if (c9 == 3) {
                            c9 = 4;
                        } else if (c9 == 5 || c9 == 6) {
                            c9 = 7;
                        }
                    } else {
                        if (c9 != 2) {
                            return i9;
                        }
                        c9 = 3;
                    }
                    i13++;
                    i12 = i9;
                } else {
                    c10 = 6;
                    if (c9 != 5) {
                        return i9;
                    }
                }
                c9 = c10;
                i13++;
                i12 = i9;
            } else {
                if (i13 == cArr.length) {
                    return i12;
                }
                if (!fillBuffer(i13 + 1)) {
                    i9 = i12;
                    break;
                }
                i10 = this.pos;
                i11 = this.limit;
                c5 = cArr[i10 + i13];
                i9 = i12;
                if (c5 != '+') {
                    if (c5 != 'E') {
                        if (c9 == 2) {
                        }
                        c9 = 5;
                    } else {
                        if (c9 == 2) {
                        }
                        c9 = 5;
                    }
                    i13++;
                    i12 = i9;
                } else {
                    c10 = 6;
                    if (c9 != 5) {
                        return i9;
                    }
                }
                c9 = c10;
                i13++;
                i12 = i9;
            }
        }
        if (c9 == 2 && i14 != 0 && ((j != Long.MIN_VALUE || z8) && (j != 0 || !z8))) {
            if (!z8) {
                j = -j;
            }
            this.peekedLong = j;
            this.pos += i13;
            this.peeked = 15;
            return 15;
        }
        if (c9 != 2 && c9 != 4 && c9 != 7) {
            return i9;
        }
        this.peekedNumberLength = i13;
        this.peeked = 16;
        return 16;
    }

    private void push(int i9) throws MalformedJsonException {
        int i10 = this.stackSize;
        if (i10 - 1 >= this.nestingLimit) {
            throw new MalformedJsonException("Nesting limit " + this.nestingLimit + " reached" + locationString());
        }
        int[] iArr = this.stack;
        if (i10 == iArr.length) {
            int i11 = i10 * 2;
            this.stack = Arrays.copyOf(iArr, i11);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i11);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i11);
        }
        int[] iArr2 = this.stack;
        int i12 = this.stackSize;
        this.stackSize = i12 + 1;
        iArr2[i12] = i9;
    }

    private char readEscapeCharacter() throws MalformedJsonException {
        int i9;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i10 = this.pos;
        int i11 = i10 + 1;
        this.pos = i11;
        char c5 = cArr[i10];
        if (c5 != '\n') {
            if (c5 != '\"') {
                if (c5 != '\'') {
                    if (c5 != '/' && c5 != '\\') {
                        if (c5 == 'b') {
                            return '\b';
                        }
                        if (c5 == 'f') {
                            return '\f';
                        }
                        if (c5 == 'n') {
                            return '\n';
                        }
                        if (c5 == 'r') {
                            return '\r';
                        }
                        if (c5 == 't') {
                            return '\t';
                        }
                        if (c5 != 'u') {
                            throw syntaxError("Invalid escape sequence");
                        }
                        if (i10 + 5 > this.limit && !fillBuffer(4)) {
                            throw syntaxError("Unterminated escape sequence");
                        }
                        int i12 = this.pos;
                        int i13 = i12 + 4;
                        int i14 = 0;
                        while (i12 < i13) {
                            char[] cArr2 = this.buffer;
                            char c9 = cArr2[i12];
                            int i15 = i14 << 4;
                            if (c9 >= '0' && c9 <= '9') {
                                i9 = c9 - '0';
                            } else if (c9 >= 'a' && c9 <= 'f') {
                                i9 = c9 - 'W';
                            } else {
                                if (c9 < 'A' || c9 > 'F') {
                                    throw syntaxError("Malformed Unicode escape \\u".concat(new String(cArr2, this.pos, 4)));
                                }
                                i9 = c9 - '7';
                            }
                            i14 = i9 + i15;
                            i12++;
                        }
                        this.pos += 4;
                        return (char) i14;
                    }
                }
            }
            return c5;
        }
        if (this.strictness == Strictness.STRICT) {
            throw syntaxError("Cannot escape a newline character in strict mode");
        }
        this.lineNumber++;
        this.lineStart = i11;
        if (this.strictness == Strictness.STRICT) {
            throw syntaxError("Invalid escaped character \"'\" in strict mode");
        }
        return c5;
    }

    private void skipQuotedValue(char c5) throws MalformedJsonException {
        char[] cArr = this.buffer;
        do {
            int i9 = this.pos;
            int i10 = this.limit;
            while (i9 < i10) {
                int i11 = i9 + 1;
                char c9 = cArr[i9];
                if (c9 == c5) {
                    this.pos = i11;
                    return;
                }
                if (c9 == '\\') {
                    this.pos = i11;
                    readEscapeCharacter();
                    i9 = this.pos;
                    i10 = this.limit;
                } else {
                    if (c9 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i11;
                    }
                    i9 = i11;
                }
            }
            this.pos = i9;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i9 = this.pos;
            if (cArr[i9] != '\n') {
                for (int i10 = 0; i10 < length; i10++) {
                    if (this.buffer[this.pos + i10] == str.charAt(i10)) {
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i9 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() {
        char c5;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i9 = this.pos;
            int i10 = i9 + 1;
            this.pos = i10;
            c5 = cArr[i9];
            if (c5 == '\n') {
                this.lineNumber++;
                this.lineStart = i10;
                return;
            }
        } while (c5 != '\r');
    }

    private void skipUnquotedValue() throws MalformedJsonException {
        do {
            int i9 = 0;
            while (true) {
                int i10 = this.pos;
                if (i10 + i9 < this.limit) {
                    char c5 = this.buffer[i10 + i9];
                    if (c5 != '\t' && c5 != '\n' && c5 != '\f' && c5 != '\r' && c5 != ' ') {
                        if (c5 != '#') {
                            if (c5 != ',') {
                                if (c5 != '/' && c5 != '=') {
                                    if (c5 != '{' && c5 != '}' && c5 != ':') {
                                        if (c5 != ';') {
                                            switch (c5) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i9++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        checkLenient();
                    }
                    this.pos += i9;
                    return;
                }
                this.pos = i10 + i9;
            }
        } while (fillBuffer(1));
    }

    private MalformedJsonException syntaxError(String str) throws MalformedJsonException {
        StringBuilder sbB = a.b(str);
        sbB.append(locationString());
        sbB.append("\nSee ");
        sbB.append(TroubleshootingGuide.createUrl("malformed-json"));
        throw new MalformedJsonException(sbB.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IllegalStateException unexpectedTokenError(String str) {
        String str2 = peek() == JsonToken.NULL ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbI = f.i("Expected ", str, " but was ");
        sbI.append(peek());
        sbI.append(locationString());
        sbI.append("\nSee ");
        sbI.append(TroubleshootingGuide.createUrl(str2));
        return new IllegalStateException(sbI.toString());
    }

    public void beginArray() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 3) {
            throw unexpectedTokenError("BEGIN_ARRAY");
        }
        push(1);
        this.pathIndices[this.stackSize - 1] = 0;
        this.peeked = 0;
    }

    public void beginObject() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 1) {
            throw unexpectedTokenError("BEGIN_OBJECT");
        }
        push(3);
        this.peeked = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public int doPeek() throws IOException {
        int iNextNonWhitespace;
        int[] iArr = this.stack;
        int i9 = this.stackSize;
        int i10 = iArr[i9 - 1];
        if (i10 == 1) {
            iArr[i9 - 1] = 2;
        } else if (i10 == 2) {
            int iNextNonWhitespace2 = nextNonWhitespace(true);
            if (iNextNonWhitespace2 != 44) {
                if (iNextNonWhitespace2 != 59) {
                    if (iNextNonWhitespace2 != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.peeked = 4;
                    return 4;
                }
                checkLenient();
            }
        } else {
            if (i10 == 3 || i10 == 5) {
                iArr[i9 - 1] = 4;
                if (i10 == 5 && (iNextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (iNextNonWhitespace != 59) {
                        if (iNextNonWhitespace != 125) {
                            throw syntaxError("Unterminated object");
                        }
                        this.peeked = 2;
                        return 2;
                    }
                    checkLenient();
                }
                int iNextNonWhitespace3 = nextNonWhitespace(true);
                if (iNextNonWhitespace3 == 34) {
                    this.peeked = 13;
                    return 13;
                }
                if (iNextNonWhitespace3 == 39) {
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                }
                if (iNextNonWhitespace3 == 125) {
                    if (i10 == 5) {
                        throw syntaxError("Expected name");
                    }
                    this.peeked = 2;
                    return 2;
                }
                checkLenient();
                this.pos--;
                if (!isLiteral((char) iNextNonWhitespace3)) {
                    throw syntaxError("Expected name");
                }
                this.peeked = 14;
                return 14;
            }
            if (i10 == 4) {
                iArr[i9 - 1] = 5;
                int iNextNonWhitespace4 = nextNonWhitespace(true);
                if (iNextNonWhitespace4 != 58) {
                    if (iNextNonWhitespace4 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i11 = this.pos;
                        if (cArr[i11] == '>') {
                            this.pos = i11 + 1;
                        }
                    }
                }
            } else if (i10 == 6) {
                if (this.strictness == Strictness.LENIENT) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i10 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 17;
                    return 17;
                }
                checkLenient();
                this.pos--;
            } else if (i10 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iNextNonWhitespace5 = nextNonWhitespace(true);
        if (iNextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        }
        if (iNextNonWhitespace5 == 39) {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
        if (iNextNonWhitespace5 != 44 && iNextNonWhitespace5 != 59) {
            if (iNextNonWhitespace5 == 91) {
                this.peeked = 3;
                return 3;
            }
            if (iNextNonWhitespace5 != 93) {
                if (iNextNonWhitespace5 == 123) {
                    this.peeked = 1;
                    return 1;
                }
                this.pos--;
                int iPeekKeyword = peekKeyword();
                if (iPeekKeyword != 0) {
                    return iPeekKeyword;
                }
                int iPeekNumber = peekNumber();
                if (iPeekNumber != 0) {
                    return iPeekNumber;
                }
                if (!isLiteral(this.buffer[this.pos])) {
                    throw syntaxError("Expected value");
                }
                checkLenient();
                this.peeked = 10;
                return 10;
            }
            if (i10 == 1) {
                this.peeked = 4;
                return 4;
            }
        }
        if (i10 != 1 && i10 != 2) {
            throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.pos--;
        this.peeked = 7;
        return 7;
    }

    public void endArray() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 4) {
            throw unexpectedTokenError("END_ARRAY");
        }
        int i9 = this.stackSize;
        this.stackSize = i9 - 1;
        int[] iArr = this.pathIndices;
        int i10 = i9 - 2;
        iArr[i10] = iArr[i10] + 1;
        this.peeked = 0;
    }

    public void endObject() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 2) {
            throw unexpectedTokenError("END_OBJECT");
        }
        int i9 = this.stackSize;
        int i10 = i9 - 1;
        this.stackSize = i10;
        this.pathNames[i10] = null;
        int[] iArr = this.pathIndices;
        int i11 = i9 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.peeked = 0;
    }

    public final int getNestingLimit() {
        return this.nestingLimit;
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public final Strictness getStrictness() {
        return this.strictness;
    }

    public boolean hasNext() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        return (iDoPeek == 2 || iDoPeek == 4 || iDoPeek == 17) ? false : true;
    }

    public final boolean isLenient() {
        return this.strictness == Strictness.LENIENT;
    }

    public String locationString() {
        StringBuilder sbG = H2.a.g(this.lineNumber + 1, (this.pos - this.lineStart) + 1, " at line ", " column ", " path ");
        sbG.append(getPath());
        return sbG.toString();
    }

    public boolean nextBoolean() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr[i9] = iArr[i9] + 1;
            return true;
        }
        if (iDoPeek != 6) {
            throw unexpectedTokenError("a boolean");
        }
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return false;
    }

    public double nextDouble() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr[i9] = iArr[i9] + 1;
            return this.peekedLong;
        }
        if (iDoPeek == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (iDoPeek == 8 || iDoPeek == 9) {
            this.peekedString = nextQuotedValue(iDoPeek == 8 ? '\'' : '\"');
        } else if (iDoPeek == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (iDoPeek != 11) {
            throw unexpectedTokenError("a double");
        }
        this.peeked = 11;
        double d9 = Double.parseDouble(this.peekedString);
        if (this.strictness != Strictness.LENIENT && (Double.isNaN(d9) || Double.isInfinite(d9))) {
            throw syntaxError("JSON forbids NaN and infinities: " + d9);
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return d9;
    }

    public int nextInt() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 15) {
            long j = this.peekedLong;
            int i9 = (int) j;
            if (j != i9) {
                throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
            }
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i10 = this.stackSize - 1;
            iArr[i10] = iArr[i10] + 1;
            return i9;
        }
        if (iDoPeek == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (iDoPeek != 8 && iDoPeek != 9 && iDoPeek != 10) {
                throw unexpectedTokenError("an int");
            }
            if (iDoPeek == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(iDoPeek == 8 ? '\'' : '\"');
            }
            try {
                int i11 = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i12 = this.stackSize - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return i11;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double d9 = Double.parseDouble(this.peekedString);
        int i13 = (int) d9;
        if (i13 != d9) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i14 = this.stackSize - 1;
        iArr3[i14] = iArr3[i14] + 1;
        return i13;
    }

    public long nextLong() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr[i9] = iArr[i9] + 1;
            return this.peekedLong;
        }
        if (iDoPeek == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (iDoPeek != 8 && iDoPeek != 9 && iDoPeek != 10) {
                throw unexpectedTokenError("a long");
            }
            if (iDoPeek == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(iDoPeek == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i10 = this.stackSize - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double d9 = Double.parseDouble(this.peekedString);
        long j8 = (long) d9;
        if (j8 != d9) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i11 = this.stackSize - 1;
        iArr3[i11] = iArr3[i11] + 1;
        return j8;
    }

    public String nextName() throws IOException {
        String strNextQuotedValue;
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 14) {
            strNextQuotedValue = nextUnquotedValue();
        } else if (iDoPeek == 12) {
            strNextQuotedValue = nextQuotedValue('\'');
        } else {
            if (iDoPeek != 13) {
                throw unexpectedTokenError("a name");
            }
            strNextQuotedValue = nextQuotedValue('\"');
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = strNextQuotedValue;
        return strNextQuotedValue;
    }

    public void nextNull() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 7) {
            throw unexpectedTokenError("null");
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i9 = this.stackSize - 1;
        iArr[i9] = iArr[i9] + 1;
    }

    public String nextString() throws IOException {
        String str;
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 10) {
            str = nextUnquotedValue();
        } else if (iDoPeek == 8) {
            str = nextQuotedValue('\'');
        } else if (iDoPeek == 9) {
            str = nextQuotedValue('\"');
        } else if (iDoPeek == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (iDoPeek == 15) {
            str = Long.toString(this.peekedLong);
        } else {
            if (iDoPeek != 16) {
                throw unexpectedTokenError("a string");
            }
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i9 = this.stackSize - 1;
        iArr[i9] = iArr[i9] + 1;
        return str;
    }

    public JsonToken peek() {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        switch (iDoPeek) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Deprecated
    public final void setLenient(boolean z8) {
        setStrictness(z8 ? Strictness.LENIENT : Strictness.LEGACY_STRICT);
    }

    public final void setNestingLimit(int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException(e.i(i9, "Invalid nesting limit: "));
        }
        this.nestingLimit = i9;
    }

    public final void setStrictness(Strictness strictness) {
        Objects.requireNonNull(strictness);
        this.strictness = strictness;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void skipValue() throws IOException {
        int i9 = 0;
        do {
            int iDoPeek = this.peeked;
            if (iDoPeek == 0) {
                iDoPeek = doPeek();
            }
            switch (iDoPeek) {
                case 1:
                    push(3);
                    i9++;
                    this.peeked = 0;
                    break;
                case 2:
                    if (i9 == 0) {
                        this.pathNames[this.stackSize - 1] = null;
                    }
                    this.stackSize--;
                    i9--;
                    this.peeked = 0;
                    break;
                case 3:
                    push(1);
                    i9++;
                    this.peeked = 0;
                    break;
                case 4:
                    this.stackSize--;
                    i9--;
                    this.peeked = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.peeked = 0;
                    break;
                case 8:
                    skipQuotedValue('\'');
                    this.peeked = 0;
                    break;
                case 9:
                    skipQuotedValue('\"');
                    this.peeked = 0;
                    break;
                case 10:
                    skipUnquotedValue();
                    this.peeked = 0;
                    break;
                case 12:
                    skipQuotedValue('\'');
                    if (i9 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 13:
                    skipQuotedValue('\"');
                    if (i9 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 14:
                    skipUnquotedValue();
                    if (i9 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 16:
                    this.pos += this.peekedNumberLength;
                    this.peeked = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i9 > 0);
        int[] iArr = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr[i10] = iArr[i10] + 1;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}

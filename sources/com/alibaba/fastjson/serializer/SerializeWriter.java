package com.alibaba.fastjson.serializer;

import W5.e;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.RyuDouble;
import com.alibaba.fastjson.util.RyuFloat;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public final class SerializeWriter extends Writer {
    private static int BUFFER_THRESHOLD;
    static final int nonDirectFeatures;
    protected boolean beanToArray;
    protected boolean browserSecure;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected long sepcialBits;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    private static final char[] VALUE_TRUE = ":true".toCharArray();
    private static final char[] VALUE_FALSE = ":false".toCharArray();

    static {
        int i9;
        BUFFER_THRESHOLD = 131072;
        try {
            String stringProperty = IOUtils.getStringProperty("fastjson.serializer_buffer_threshold");
            if (stringProperty != null && stringProperty.length() > 0 && (i9 = Integer.parseInt(stringProperty)) >= 64 && i9 <= 65536) {
                BUFFER_THRESHOLD = i9 * 1024;
            }
        } catch (Throwable unused) {
        }
        nonDirectFeatures = SerializerFeature.UseSingleQuotes.mask | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i9 = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i9 ? new byte[i9] : bArr;
        int iEncodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr2);
        outputStream.write(bArr2, 0, iEncodeUTF8);
        if (bArr2 != bArr && bArr2.length <= BUFFER_THRESHOLD) {
            threadLocal.set(bArr2);
        }
        return iEncodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        int i9 = (int) (((double) this.count) * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i9 ? new byte[i9] : bArr;
        int iEncodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr2);
        byte[] bArr3 = new byte[iEncodeUTF8];
        System.arraycopy(bArr2, 0, bArr3, 0, iEncodeUTF8);
        if (bArr2 != bArr && bArr2.length <= BUFFER_THRESHOLD) {
            threadLocal.set(bArr2);
        }
        return bArr3;
    }

    private void writeEnumFieldValue(char c5, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c5, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c5, str, str2);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int i9;
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        int i10 = 1;
        int i11 = this.count + length + 1;
        if (i11 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        i10 = 0;
                        break;
                    }
                    char cCharAt = str.charAt(i12);
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i10 != 0) {
                    write(39);
                }
                for (int i13 = 0; i13 < length; i13++) {
                    char cCharAt2 = str.charAt(i13);
                    if (cCharAt2 >= bArr.length || bArr[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[cCharAt2]);
                    }
                }
                if (i10 != 0) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i11);
        }
        if (length == 0) {
            int i14 = this.count;
            if (i14 + 3 > this.buf.length) {
                expandCapacity(i14 + 3);
            }
            char[] cArr = this.buf;
            int i15 = this.count;
            int i16 = i15 + 1;
            this.count = i16;
            cArr[i15] = '\'';
            int i17 = i15 + 2;
            this.count = i17;
            cArr[i16] = '\'';
            this.count = i15 + 3;
            cArr[i17] = ':';
            return;
        }
        int i18 = this.count;
        int i19 = i18 + length;
        str.getChars(0, length, this.buf, i18);
        this.count = i11;
        int i20 = i18;
        int i21 = 0;
        while (i20 < i19) {
            char[] cArr2 = this.buf;
            char c5 = cArr2[i20];
            if (c5 >= bArr.length || bArr[c5] == 0) {
                i9 = i10;
            } else if (i21 == 0) {
                i11 += 3;
                if (i11 > cArr2.length) {
                    expandCapacity(i11);
                }
                this.count = i11;
                char[] cArr3 = this.buf;
                int i22 = i20 + 1;
                System.arraycopy(cArr3, i22, cArr3, i20 + 3, (i19 - i20) - i10);
                char[] cArr4 = this.buf;
                System.arraycopy(cArr4, 0, cArr4, i10, i20);
                char[] cArr5 = this.buf;
                cArr5[i18] = '\'';
                cArr5[i22] = '\\';
                i20 += 2;
                cArr5[i20] = IOUtils.replaceChars[c5];
                i19 += 2;
                cArr5[this.count - 2] = '\'';
                i21 = i10;
                i9 = i21;
            } else {
                i11++;
                if (i11 > cArr2.length) {
                    expandCapacity(i11);
                }
                this.count = i11;
                char[] cArr6 = this.buf;
                int i23 = i20 + 1;
                i9 = i10;
                System.arraycopy(cArr6, i23, cArr6, i20 + 2, i19 - i20);
                char[] cArr7 = this.buf;
                cArr7[i20] = '\\';
                cArr7[i23] = IOUtils.replaceChars[c5];
                i19++;
                i20 = i23;
            }
            i20++;
            i10 = i9;
        }
        this.buf[i11 - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= BUFFER_THRESHOLD) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void computeFeatures() {
        long j;
        int i9 = this.features;
        boolean z8 = (SerializerFeature.QuoteFieldNames.mask & i9) != 0;
        this.quoteFieldNames = z8;
        boolean z9 = (SerializerFeature.UseSingleQuotes.mask & i9) != 0;
        this.useSingleQuotes = z9;
        this.sortField = (SerializerFeature.SortField.mask & i9) != 0;
        this.disableCircularReferenceDetect = (SerializerFeature.DisableCircularReferenceDetect.mask & i9) != 0;
        boolean z10 = (SerializerFeature.BeanToArray.mask & i9) != 0;
        this.beanToArray = z10;
        this.writeNonStringValueAsString = (SerializerFeature.WriteNonStringValueAsString.mask & i9) != 0;
        this.notWriteDefaultValue = (SerializerFeature.NotWriteDefaultValue.mask & i9) != 0;
        boolean z11 = (SerializerFeature.WriteEnumUsingName.mask & i9) != 0;
        this.writeEnumUsingName = z11;
        this.writeEnumUsingToString = (SerializerFeature.WriteEnumUsingToString.mask & i9) != 0;
        this.writeDirect = z8 && (nonDirectFeatures & i9) == 0 && (z10 || z11);
        this.keySeperator = z9 ? '\'' : '\"';
        boolean z12 = (SerializerFeature.BrowserSecure.mask & i9) != 0;
        this.browserSecure = z12;
        if (z12) {
            j = 5764610843043954687L;
        } else {
            j = (i9 & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
        }
        this.sepcialBits = j;
    }

    public void config(SerializerFeature serializerFeature, boolean z8) {
        if (z8) {
            int mask = this.features | serializerFeature.getMask();
            this.features = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.features = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    public void expandCapacity(int i9) {
        ThreadLocal<char[]> threadLocal;
        char[] cArr;
        int i10 = this.maxBufSize;
        if (i10 != -1 && i9 >= i10) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i9);
        }
        char[] cArr2 = this.buf;
        int length = cArr2.length + (cArr2.length >> 1) + 1;
        if (length >= i9) {
            i9 = length;
        }
        char[] cArr3 = new char[i9];
        System.arraycopy(cArr2, 0, cArr3, 0, this.count);
        if (this.buf.length < BUFFER_THRESHOLD && ((cArr = (threadLocal = bufLocal).get()) == null || cArr.length < this.buf.length)) {
            threadLocal.set(this.buf);
        }
        this.buf = cArr3;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e9) {
            throw new JSONException(e9.getMessage(), e9);
        }
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public void reset() {
        this.count = 0;
    }

    public void setMaxBufSize(int i9) {
        if (i9 >= this.buf.length) {
            this.maxBufSize = i9;
        } else {
            throw new JSONException("must > " + this.buf.length);
        }
    }

    public int size() {
        return this.count;
    }

    public byte[] toBytes(String str) {
        return toBytes((str == null || "UTF-8".equals(str)) ? IOUtils.UTF8 : Charset.forName(str));
    }

    public char[] toCharArray() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i9 = this.count;
        char[] cArr = new char[i9];
        System.arraycopy(this.buf, 0, cArr, 0, i9);
        return cArr;
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i9 = this.count;
        char[] cArr = new char[i9 - 2];
        System.arraycopy(this.buf, 1, cArr, 0, i9 - 2);
        return cArr;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i9) {
        int i10 = 1;
        int i11 = this.count + 1;
        if (i11 <= this.buf.length) {
            i10 = i11;
        } else if (this.writer == null) {
            expandCapacity(i11);
            i10 = i11;
        } else {
            flush();
        }
        this.buf[this.count] = (char) i9;
        this.count = i10;
    }

    public void writeByteArray(byte[] bArr) {
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr.length;
        boolean z8 = this.useSingleQuotes;
        char c5 = z8 ? '\'' : '\"';
        if (length == 0) {
            write(z8 ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
        int i9 = (length / 3) * 3;
        int i10 = length - 1;
        int i11 = this.count;
        int i12 = (((i10 / 3) + 1) << 2) + i11;
        int i13 = i12 + 2;
        if (i13 > this.buf.length) {
            if (this.writer != null) {
                write(c5);
                int i14 = 0;
                while (i14 < i9) {
                    int i15 = i14 + 2;
                    int i16 = ((bArr[i14 + 1] & 255) << 8) | ((bArr[i14] & 255) << 16);
                    i14 += 3;
                    int i17 = i16 | (bArr[i15] & 255);
                    write(cArr[(i17 >>> 18) & 63]);
                    write(cArr[(i17 >>> 12) & 63]);
                    write(cArr[(i17 >>> 6) & 63]);
                    write(cArr[i17 & 63]);
                }
                int i18 = length - i9;
                if (i18 > 0) {
                    int i19 = ((bArr[i9] & 255) << 10) | (i18 == 2 ? (bArr[i10] & 255) << 2 : 0);
                    write(cArr[i19 >> 12]);
                    write(cArr[(i19 >>> 6) & 63]);
                    write(i18 == 2 ? cArr[i19 & 63] : '=');
                    write(61);
                }
                write(c5);
                return;
            }
            expandCapacity(i13);
        }
        this.count = i13;
        int i20 = i11 + 1;
        this.buf[i11] = c5;
        int i21 = 0;
        while (i21 < i9) {
            int i22 = i21 + 2;
            int i23 = ((bArr[i21 + 1] & 255) << 8) | ((bArr[i21] & 255) << 16);
            i21 += 3;
            int i24 = i23 | (bArr[i22] & 255);
            char[] cArr2 = this.buf;
            cArr2[i20] = cArr[(i24 >>> 18) & 63];
            cArr2[i20 + 1] = cArr[(i24 >>> 12) & 63];
            int i25 = i20 + 3;
            cArr2[i20 + 2] = cArr[(i24 >>> 6) & 63];
            i20 += 4;
            cArr2[i25] = cArr[i24 & 63];
        }
        int i26 = length - i9;
        if (i26 > 0) {
            int i27 = ((bArr[i9] & 255) << 10) | (i26 == 2 ? (bArr[i10] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i12 - 3] = cArr[i27 >> 12];
            cArr3[i12 - 2] = cArr[(i27 >>> 6) & 63];
            cArr3[i12 - 1] = i26 == 2 ? cArr[i27 & 63] : '=';
            cArr3[i12] = '=';
        }
        this.buf[i12 + 1] = c5;
    }

    public void writeDouble(double d9, boolean z8) {
        if (Double.isNaN(d9) || Double.isInfinite(d9)) {
            writeNull();
            return;
        }
        int i9 = this.count + 24;
        if (i9 > this.buf.length) {
            if (this.writer != null) {
                String string = RyuDouble.toString(d9);
                write(string, 0, string.length());
                if (z8 && isEnabled(SerializerFeature.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
            expandCapacity(i9);
        }
        this.count += RyuDouble.toString(d9, this.buf, this.count);
        if (z8 && isEnabled(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public void writeEnum(Enum<?> r8) {
        String string;
        if (r8 == null) {
            writeNull();
            return;
        }
        if (!this.writeEnumUsingName || this.writeEnumUsingToString) {
            string = this.writeEnumUsingToString ? r8.toString() : null;
        } else {
            string = r8.name();
        }
        if (string == null) {
            writeInt(r8.ordinal());
            return;
        }
        int i9 = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        write(i9);
        write(string);
        write(i9);
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i9 = this.count + length;
        int i10 = i9 + 3;
        if (i10 > this.buf.length) {
            expandCapacity(i10);
        }
        int i11 = this.count;
        char[] cArr = this.buf;
        cArr[i11] = '\"';
        str.getChars(0, length, cArr, i11 + 1);
        this.count = i10;
        char[] cArr2 = this.buf;
        cArr2[i9 + 1] = '\"';
        cArr2[i9 + 2] = ':';
    }

    public void writeFieldValue(char c5, String str, char c9) {
        write(c5);
        writeFieldName(str);
        if (c9 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c9));
        }
    }

    public void writeFieldValueStringWithDoubleQuote(char c5, String str, String str2) {
        int length = str.length();
        int i9 = this.count;
        int length2 = str2.length();
        int i10 = length + length2 + 6 + i9;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                write(c5);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i10);
        }
        char[] cArr = this.buf;
        int i11 = this.count;
        cArr[i11] = c5;
        int i12 = i11 + 2;
        int i13 = i12 + length;
        cArr[i11 + 1] = '\"';
        str.getChars(0, length, cArr, i12);
        this.count = i10;
        char[] cArr2 = this.buf;
        cArr2[i13] = '\"';
        cArr2[i13 + 1] = ':';
        cArr2[i13 + 2] = '\"';
        str2.getChars(0, length2, cArr2, i13 + 3);
        this.buf[this.count - 1] = '\"';
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00df  */
    public void writeFieldValueStringWithDoubleQuoteCheck(char c5, String str, String str2) {
        int i9;
        int i10;
        char c9;
        char c10;
        int i11;
        int length = str.length();
        int i12 = this.count;
        if (str2 == null) {
            i9 = length + 8 + i12;
            i10 = 4;
        } else {
            int length2 = str2.length();
            i9 = i12 + length + length2 + 6;
            i10 = length2;
        }
        int i13 = 0;
        if (i9 > this.buf.length) {
            if (this.writer != null) {
                write(c5);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i9);
        }
        char[] cArr = this.buf;
        int i14 = this.count;
        cArr[i14] = c5;
        int i15 = i14 + 2;
        int i16 = i15 + length;
        char c11 = '\"';
        cArr[i14 + 1] = '\"';
        str.getChars(0, length, cArr, i15);
        this.count = i9;
        char[] cArr2 = this.buf;
        cArr2[i16] = '\"';
        int i17 = i16 + 2;
        cArr2[i16 + 1] = ':';
        char c12 = 'u';
        if (str2 == null) {
            cArr2[i17] = 'n';
            cArr2[i16 + 3] = 'u';
            cArr2[i16 + 4] = 'l';
            cArr2[i16 + 5] = 'l';
            return;
        }
        int i18 = i16 + 3;
        cArr2[i17] = '\"';
        int i19 = i18 + i10;
        str2.getChars(0, i10, cArr2, i18);
        int i20 = -1;
        int i21 = -1;
        int i22 = -1;
        char c13 = 0;
        int i23 = i18;
        while (true) {
            c9 = c12;
            c10 = c11;
            if (i23 >= i19) {
                break;
            }
            char c14 = this.buf[i23];
            if (c14 >= ']') {
                if (c14 < 127 || !(c14 == 8232 || c14 == 8233 || c14 < 160)) {
                    i11 = i20;
                } else {
                    if (i21 == i20) {
                        i21 = i23;
                    }
                    i13++;
                    i9 += 4;
                    i11 = i20;
                    i22 = i23;
                    c13 = c14;
                }
            } else if ((c14 >= '@' || (this.sepcialBits & (1 << c14)) == 0) && c14 != '\\') {
                i11 = -1;
            } else {
                i13++;
                if (c14 == '(' || c14 == ')' || c14 == '<' || c14 == '>') {
                    i9 += 4;
                } else {
                    byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                    if (c14 < bArr.length && bArr[c14] == 4) {
                        i9 += 4;
                    }
                }
                i11 = -1;
                if (i21 == -1) {
                    i21 = i23;
                    i22 = i21;
                } else {
                    i22 = i23;
                }
                c13 = c14;
            }
            i23++;
            c12 = c9;
            i20 = i11;
            c11 = c10;
        }
        if (i13 > 0) {
            int i24 = i9 + i13;
            if (i24 > this.buf.length) {
                expandCapacity(i24);
            }
            this.count = i24;
            if (i13 == 1) {
                if (c13 == 8232) {
                    int i25 = i22 + 1;
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i25, cArr3, i22 + 6, (i19 - i22) - 1);
                    char[] cArr4 = this.buf;
                    cArr4[i22] = '\\';
                    cArr4[i25] = c9;
                    cArr4[i22 + 2] = '2';
                    cArr4[i22 + 3] = '0';
                    cArr4[i22 + 4] = '2';
                    cArr4[i22 + 5] = '8';
                } else if (c13 == 8233) {
                    int i26 = i22 + 1;
                    char[] cArr5 = this.buf;
                    System.arraycopy(cArr5, i26, cArr5, i22 + 6, (i19 - i22) - 1);
                    char[] cArr6 = this.buf;
                    cArr6[i22] = '\\';
                    cArr6[i26] = c9;
                    cArr6[i22 + 2] = '2';
                    cArr6[i22 + 3] = '0';
                    cArr6[i22 + 4] = '2';
                    cArr6[i22 + 5] = '9';
                } else if (c13 == '(' || c13 == ')' || c13 == '<' || c13 == '>') {
                    int i27 = i22 + 1;
                    char[] cArr7 = this.buf;
                    System.arraycopy(cArr7, i27, cArr7, i22 + 6, (i19 - i22) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i22] = '\\';
                    cArr8[i27] = c9;
                    char[] cArr9 = IOUtils.DIGITS;
                    cArr8[i22 + 2] = cArr9[(c13 >>> '\f') & 15];
                    cArr8[i22 + 3] = cArr9[(c13 >>> '\b') & 15];
                    cArr8[i22 + 4] = cArr9[(c13 >>> 4) & 15];
                    cArr8[i22 + 5] = cArr9[c13 & 15];
                } else {
                    byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                    if (c13 >= bArr2.length || bArr2[c13] != 4) {
                        int i28 = i22 + 1;
                        char[] cArr10 = this.buf;
                        System.arraycopy(cArr10, i28, cArr10, i22 + 2, (i19 - i22) - 1);
                        char[] cArr11 = this.buf;
                        cArr11[i22] = '\\';
                        cArr11[i28] = IOUtils.replaceChars[c13];
                    } else {
                        int i29 = i22 + 1;
                        char[] cArr12 = this.buf;
                        System.arraycopy(cArr12, i29, cArr12, i22 + 6, (i19 - i22) - 1);
                        char[] cArr13 = this.buf;
                        cArr13[i22] = '\\';
                        cArr13[i29] = c9;
                        char[] cArr14 = IOUtils.DIGITS;
                        cArr13[i22 + 2] = cArr14[(c13 >>> '\f') & 15];
                        cArr13[i22 + 3] = cArr14[(c13 >>> '\b') & 15];
                        cArr13[i22 + 4] = cArr14[(c13 >>> 4) & 15];
                        cArr13[i22 + 5] = cArr14[c13 & 15];
                    }
                }
            } else if (i13 > 1) {
                for (int i30 = i21 - i18; i30 < str2.length(); i30++) {
                    char cCharAt = str2.charAt(i30);
                    if (this.browserSecure) {
                        if (cCharAt != '(' && cCharAt != ')') {
                            if (cCharAt == '<' || cCharAt == '>') {
                            }
                        }
                        char[] cArr15 = this.buf;
                        cArr15[i21] = '\\';
                        cArr15[i21 + 1] = c9;
                        char[] cArr16 = IOUtils.DIGITS;
                        cArr15[i21 + 2] = cArr16[(cCharAt >>> '\f') & 15];
                        cArr15[i21 + 3] = cArr16[(cCharAt >>> '\b') & 15];
                        int i31 = i21 + 5;
                        cArr15[i21 + 4] = cArr16[(cCharAt >>> 4) & 15];
                        i21 += 6;
                        cArr15[i31] = cArr16[cCharAt & 15];
                    }
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if ((cCharAt < bArr3.length && bArr3[cCharAt] != 0) || (cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr17 = this.buf;
                        int i32 = i21 + 1;
                        cArr17[i21] = '\\';
                        if (bArr3[cCharAt] == 4) {
                            cArr17[i32] = c9;
                            char[] cArr18 = IOUtils.DIGITS;
                            cArr17[i21 + 2] = cArr18[(cCharAt >>> '\f') & 15];
                            cArr17[i21 + 3] = cArr18[(cCharAt >>> '\b') & 15];
                            int i33 = i21 + 5;
                            cArr17[i21 + 4] = cArr18[(cCharAt >>> 4) & 15];
                            i21 += 6;
                            cArr17[i33] = cArr18[cCharAt & 15];
                        } else {
                            i21 += 2;
                            cArr17[i32] = IOUtils.replaceChars[cCharAt];
                        }
                    } else if (cCharAt == 8232 || cCharAt == 8233) {
                        char[] cArr19 = this.buf;
                        cArr19[i21] = '\\';
                        cArr19[i21 + 1] = c9;
                        char[] cArr20 = IOUtils.DIGITS;
                        cArr19[i21 + 2] = cArr20[(cCharAt >>> '\f') & 15];
                        cArr19[i21 + 3] = cArr20[(cCharAt >>> '\b') & 15];
                        int i34 = i21 + 5;
                        cArr19[i21 + 4] = cArr20[(cCharAt >>> 4) & 15];
                        i21 += 6;
                        cArr19[i34] = cArr20[cCharAt & 15];
                    } else {
                        this.buf[i21] = cCharAt;
                        i21++;
                    }
                }
            }
        }
        this.buf[this.count - 1] = c10;
    }

    public void writeFloat(float f6, boolean z8) {
        if (f6 != f6 || f6 == Float.POSITIVE_INFINITY || f6 == Float.NEGATIVE_INFINITY) {
            writeNull();
            return;
        }
        int i9 = this.count + 15;
        if (i9 > this.buf.length) {
            if (this.writer != null) {
                String string = RyuFloat.toString(f6);
                write(string, 0, string.length());
                if (z8 && isEnabled(SerializerFeature.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
            expandCapacity(i9);
        }
        this.count += RyuFloat.toString(f6, this.buf, this.count);
        if (z8 && isEnabled(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void writeHex(byte[] bArr) {
        int length = (bArr.length * 2) + this.count + 3;
        if (length > this.buf.length) {
            expandCapacity(length);
        }
        char[] cArr = this.buf;
        int i9 = this.count;
        int i10 = i9 + 1;
        this.count = i10;
        cArr[i9] = 'x';
        this.count = i9 + 2;
        cArr[i10] = '\'';
        for (byte b9 : bArr) {
            int i11 = (b9 & 255) >> 4;
            int i12 = b9 & 15;
            char[] cArr2 = this.buf;
            int i13 = this.count;
            int i14 = i13 + 1;
            this.count = i14;
            int i15 = 55;
            cArr2[i13] = (char) (i11 + (i11 < 10 ? 48 : 55));
            this.count = i13 + 2;
            if (i12 < 10) {
                i15 = 48;
            }
            cArr2[i14] = (char) (i12 + i15);
        }
        char[] cArr3 = this.buf;
        int i16 = this.count;
        this.count = i16 + 1;
        cArr3[i16] = '\'';
    }

    public void writeInt(int i9) {
        if (i9 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iStringSize = i9 < 0 ? IOUtils.stringSize(-i9) + 1 : IOUtils.stringSize(i9);
        int i10 = this.count + iStringSize;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[iStringSize];
                IOUtils.getChars(i9, iStringSize, cArr);
                write(cArr, 0, iStringSize);
                return;
            }
            expandCapacity(i10);
        }
        IOUtils.getChars(i9, i10, this.buf);
        this.count = i10;
    }

    public void writeLong(long j) {
        boolean z8 = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j == Long.MIN_VALUE) {
            if (z8) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int iStringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
        int i9 = this.count + iStringSize;
        if (z8) {
            i9 += 2;
        }
        if (i9 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[iStringSize];
                IOUtils.getChars(j, iStringSize, cArr);
                if (!z8) {
                    write(cArr, 0, iStringSize);
                    return;
                }
                write(34);
                write(cArr, 0, iStringSize);
                write(34);
                return;
            }
            expandCapacity(i9);
        }
        if (z8) {
            char[] cArr2 = this.buf;
            cArr2[this.count] = '\"';
            int i10 = i9 - 1;
            IOUtils.getChars(j, i10, cArr2);
            this.buf[i10] = '\"';
        } else {
            IOUtils.getChars(j, i9, this.buf);
        }
        this.count = i9;
    }

    public void writeLongAndChar(long j, char c5) {
        writeLong(j);
        write(c5);
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str, char c5) {
        if (!this.useSingleQuotes) {
            writeStringWithDoubleQuote(str, c5);
        } else {
            writeStringWithSingleQuote(str);
            write(c5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:168:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:61:0x0155  */
    public void writeStringWithDoubleQuote(String str, char c5) {
        int i9;
        if (str == null) {
            writeNull();
            if (c5 != 0) {
                write(c5);
                return;
            }
            return;
        }
        int length = str.length();
        int i10 = this.count + length;
        int i11 = i10 + 2;
        if (c5 != 0) {
            i11 = i10 + 3;
        }
        char c9 = '\"';
        if (i11 <= this.buf.length) {
            i9 = 1;
        } else {
            if (this.writer != null) {
                write(34);
                for (int i12 = 0; i12 < str.length(); i12++) {
                    char cCharAt = str.charAt(i12);
                    if (isEnabled(SerializerFeature.BrowserSecure) && (cCharAt == '(' || cCharAt == ')' || cCharAt == '<' || cCharAt == '>')) {
                        write(92);
                        write(117);
                        char[] cArr = IOUtils.DIGITS;
                        write(cArr[(cCharAt >>> '\f') & 15]);
                        write(cArr[(cCharAt >>> '\b') & 15]);
                        write(cArr[(cCharAt >>> 4) & 15]);
                        write(cArr[cCharAt & 15]);
                    } else if (!isEnabled(SerializerFeature.BrowserCompatible)) {
                        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                        if ((cCharAt >= bArr.length || bArr[cCharAt] == 0) && !(cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(cCharAt);
                        } else {
                            write(92);
                            if (bArr[cCharAt] == 4) {
                                write(117);
                                char[] cArr2 = IOUtils.DIGITS;
                                write(cArr2[(cCharAt >>> '\f') & 15]);
                                write(cArr2[(cCharAt >>> '\b') & 15]);
                                write(cArr2[(cCharAt >>> 4) & 15]);
                                write(cArr2[cCharAt & 15]);
                            } else {
                                write(IOUtils.replaceChars[cCharAt]);
                            }
                        }
                    } else if (cCharAt == '\b' || cCharAt == '\f' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                        write(92);
                        write(IOUtils.replaceChars[cCharAt]);
                    } else if (cCharAt < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr3 = IOUtils.ASCII_CHARS;
                        int i13 = cCharAt * 2;
                        write(cArr3[i13]);
                        write(cArr3[i13 + 1]);
                    } else if (cCharAt >= 127) {
                        write(92);
                        write(117);
                        char[] cArr4 = IOUtils.DIGITS;
                        write(cArr4[(cCharAt >>> '\f') & 15]);
                        write(cArr4[(cCharAt >>> '\b') & 15]);
                        write(cArr4[(cCharAt >>> 4) & 15]);
                        write(cArr4[cCharAt & 15]);
                    } else {
                        write(cCharAt);
                    }
                }
                write(34);
                if (c5 != 0) {
                    write(c5);
                    return;
                }
                return;
            }
            i9 = 1;
            expandCapacity(i11);
        }
        int i14 = this.count;
        int i15 = i14 + 1;
        int i16 = i15 + length;
        char[] cArr5 = this.buf;
        cArr5[i14] = '\"';
        char c10 = 0;
        str.getChars(0, length, cArr5, i15);
        this.count = i11;
        int i17 = -1;
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            for (int i18 = i15; i18 < i16; i18++) {
                char c11 = this.buf[i18];
                if (c11 == '\"' || c11 == '/' || c11 == '\\' || c11 == '\b' || c11 == '\f' || c11 == '\n' || c11 == '\r' || c11 == '\t') {
                    i11++;
                } else {
                    if (c11 < ' ' || c11 >= 127) {
                        i11 += 5;
                    }
                }
                i17 = i18;
            }
            if (i11 > this.buf.length) {
                expandCapacity(i11);
            }
            this.count = i11;
            while (i17 >= i15) {
                char[] cArr6 = this.buf;
                char c12 = cArr6[i17];
                if (c12 == '\b' || c12 == '\f' || c12 == '\n' || c12 == '\r' || c12 == '\t') {
                    int i19 = i17 + 1;
                    System.arraycopy(cArr6, i19, cArr6, i17 + 2, (i16 - i17) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i17] = '\\';
                    cArr7[i19] = IOUtils.replaceChars[c12];
                } else {
                    if (c12 == '\"' || c12 == '/' || c12 == '\\') {
                        int i20 = i17 + 1;
                        System.arraycopy(cArr6, i20, cArr6, i17 + 2, (i16 - i17) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i17] = '\\';
                        cArr8[i20] = c12;
                    } else {
                        if (c12 < ' ') {
                            int i21 = i17 + 1;
                            System.arraycopy(cArr6, i21, cArr6, i17 + 6, (i16 - i17) - 1);
                            char[] cArr9 = this.buf;
                            cArr9[i17] = '\\';
                            cArr9[i21] = 'u';
                            cArr9[i17 + 2] = '0';
                            cArr9[i17 + 3] = '0';
                            char[] cArr10 = IOUtils.ASCII_CHARS;
                            int i22 = c12 * 2;
                            cArr9[i17 + 4] = cArr10[i22];
                            cArr9[i17 + 5] = cArr10[i22 + 1];
                        } else if (c12 >= 127) {
                            int i23 = i17 + 1;
                            System.arraycopy(cArr6, i23, cArr6, i17 + 6, (i16 - i17) - 1);
                            char[] cArr11 = this.buf;
                            cArr11[i17] = '\\';
                            cArr11[i23] = 'u';
                            char[] cArr12 = IOUtils.DIGITS;
                            cArr11[i17 + 2] = cArr12[(c12 >>> '\f') & 15];
                            cArr11[i17 + 3] = cArr12[(c12 >>> '\b') & 15];
                            cArr11[i17 + 4] = cArr12[(c12 >>> 4) & 15];
                            cArr11[i17 + 5] = cArr12[c12 & 15];
                        }
                        i16 += 5;
                    }
                    i17--;
                }
                i16++;
                i17--;
            }
            if (c5 == 0) {
                this.buf[this.count - 1] = '\"';
                return;
            }
            char[] cArr13 = this.buf;
            int i24 = this.count;
            cArr13[i24 - 2] = '\"';
            cArr13[i24 - 1] = c5;
            return;
        }
        int i25 = 0;
        int i26 = -1;
        int i27 = -1;
        int i28 = i15;
        while (i28 < i16) {
            char c13 = c9;
            char c14 = this.buf[i28];
            if (c14 >= ']') {
                if (c14 >= 127 && (c14 == 8232 || c14 == 8233 || c14 < 160)) {
                    if (i26 == i17) {
                        i26 = i28;
                    }
                    i25++;
                    i11 += 4;
                    i27 = i28;
                    c10 = c14;
                }
            } else if ((c14 >= '@' || (this.sepcialBits & (1 << c14)) == 0) && c14 != '\\') {
                i17 = -1;
            } else {
                i25++;
                if (c14 == '(' || c14 == ')' || c14 == '<' || c14 == '>') {
                    i11 += 4;
                } else {
                    byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                    if (c14 < bArr2.length && bArr2[c14] == 4) {
                        i11 += 4;
                    }
                }
                i17 = -1;
                if (i26 == -1) {
                    i26 = i28;
                    i27 = i26;
                } else {
                    i27 = i28;
                }
                c10 = c14;
            }
            i28++;
            c9 = c13;
        }
        char c15 = c9;
        if (i25 > 0) {
            int i29 = i11 + i25;
            if (i29 > this.buf.length) {
                expandCapacity(i29);
            }
            this.count = i29;
            int i30 = i9;
            if (i25 == i30) {
                if (c10 == 8232) {
                    int i31 = i27 + 1;
                    int i32 = (i16 - i27) - i30;
                    char[] cArr14 = this.buf;
                    System.arraycopy(cArr14, i31, cArr14, i27 + 6, i32);
                    char[] cArr15 = this.buf;
                    cArr15[i27] = '\\';
                    cArr15[i31] = 'u';
                    cArr15[i27 + 2] = '2';
                    cArr15[i27 + 3] = '0';
                    cArr15[i27 + 4] = '2';
                    cArr15[i27 + 5] = '8';
                } else if (c10 == 8233) {
                    int i33 = i27 + 1;
                    char[] cArr16 = this.buf;
                    System.arraycopy(cArr16, i33, cArr16, i27 + 6, (i16 - i27) - 1);
                    char[] cArr17 = this.buf;
                    cArr17[i27] = '\\';
                    cArr17[i33] = 'u';
                    cArr17[i27 + 2] = '2';
                    cArr17[i27 + 3] = '0';
                    cArr17[i27 + 4] = '2';
                    cArr17[i27 + 5] = '9';
                } else if (c10 == '(' || c10 == ')' || c10 == '<' || c10 == '>') {
                    int i34 = i27 + 1;
                    char[] cArr18 = this.buf;
                    System.arraycopy(cArr18, i34, cArr18, i27 + 6, (i16 - i27) - 1);
                    char[] cArr19 = this.buf;
                    cArr19[i27] = '\\';
                    cArr19[i34] = 'u';
                    char[] cArr20 = IOUtils.DIGITS;
                    cArr19[i27 + 2] = cArr20[(c10 >>> '\f') & 15];
                    cArr19[i27 + 3] = cArr20[(c10 >>> '\b') & 15];
                    cArr19[i27 + 4] = cArr20[(c10 >>> 4) & 15];
                    cArr19[i27 + 5] = cArr20[c10 & 15];
                } else {
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if (c10 >= bArr3.length || bArr3[c10] != 4) {
                        int i35 = i27 + 1;
                        char[] cArr21 = this.buf;
                        System.arraycopy(cArr21, i35, cArr21, i27 + 2, (i16 - i27) - 1);
                        char[] cArr22 = this.buf;
                        cArr22[i27] = '\\';
                        cArr22[i35] = IOUtils.replaceChars[c10];
                    } else {
                        int i36 = i27 + 1;
                        char[] cArr23 = this.buf;
                        System.arraycopy(cArr23, i36, cArr23, i27 + 6, (i16 - i27) - 1);
                        char[] cArr24 = this.buf;
                        cArr24[i27] = '\\';
                        cArr24[i36] = 'u';
                        char[] cArr25 = IOUtils.DIGITS;
                        cArr24[i27 + 2] = cArr25[(c10 >>> '\f') & 15];
                        cArr24[i27 + 3] = cArr25[(c10 >>> '\b') & 15];
                        cArr24[i27 + 4] = cArr25[(c10 >>> 4) & 15];
                        cArr24[i27 + 5] = cArr25[c10 & 15];
                    }
                }
            } else if (i25 > i30) {
                for (int i37 = i26 - i15; i37 < str.length(); i37++) {
                    char cCharAt2 = str.charAt(i37);
                    if (this.browserSecure) {
                        if (cCharAt2 != '(' && cCharAt2 != ')') {
                            if (cCharAt2 == '<' || cCharAt2 == '>') {
                            }
                        }
                        char[] cArr26 = this.buf;
                        cArr26[i26] = '\\';
                        cArr26[i26 + 1] = 'u';
                        char[] cArr27 = IOUtils.DIGITS;
                        cArr26[i26 + 2] = cArr27[(cCharAt2 >>> '\f') & 15];
                        cArr26[i26 + 3] = cArr27[(cCharAt2 >>> '\b') & 15];
                        int i38 = i26 + 5;
                        cArr26[i26 + 4] = cArr27[(cCharAt2 >>> 4) & 15];
                        i26 += 6;
                        cArr26[i38] = cArr27[cCharAt2 & 15];
                    }
                    byte[] bArr4 = IOUtils.specicalFlags_doubleQuotes;
                    if ((cCharAt2 < bArr4.length && bArr4[cCharAt2] != 0) || (cCharAt2 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr28 = this.buf;
                        int i39 = i26 + 1;
                        cArr28[i26] = '\\';
                        if (bArr4[cCharAt2] == 4) {
                            cArr28[i39] = 'u';
                            char[] cArr29 = IOUtils.DIGITS;
                            cArr28[i26 + 2] = cArr29[(cCharAt2 >>> '\f') & 15];
                            cArr28[i26 + 3] = cArr29[(cCharAt2 >>> '\b') & 15];
                            int i40 = i26 + 5;
                            cArr28[i26 + 4] = cArr29[(cCharAt2 >>> 4) & 15];
                            i26 += 6;
                            cArr28[i40] = cArr29[cCharAt2 & 15];
                        } else {
                            i26 += 2;
                            cArr28[i39] = IOUtils.replaceChars[cCharAt2];
                        }
                    } else if (cCharAt2 == 8232 || cCharAt2 == 8233) {
                        char[] cArr30 = this.buf;
                        cArr30[i26] = '\\';
                        cArr30[i26 + 1] = 'u';
                        char[] cArr31 = IOUtils.DIGITS;
                        cArr30[i26 + 2] = cArr31[(cCharAt2 >>> '\f') & 15];
                        cArr30[i26 + 3] = cArr31[(cCharAt2 >>> '\b') & 15];
                        int i41 = i26 + 5;
                        cArr30[i26 + 4] = cArr31[(cCharAt2 >>> 4) & 15];
                        i26 += 6;
                        cArr30[i41] = cArr31[cCharAt2 & 15];
                    } else {
                        this.buf[i26] = cCharAt2;
                        i26++;
                    }
                }
            }
        }
        if (c5 == 0) {
            this.buf[this.count - 1] = c15;
            return;
        }
        char[] cArr32 = this.buf;
        int i42 = this.count;
        cArr32[i42 - 2] = c15;
        cArr32[i42 - 1] = c5;
    }

    public void writeStringWithSingleQuote(String str) {
        int i9 = 0;
        if (str == null) {
            int i10 = this.count + 4;
            if (i10 > this.buf.length) {
                expandCapacity(i10);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i10;
            return;
        }
        int length = str.length();
        int i11 = this.count + length + 2;
        if (i11 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i9 < str.length()) {
                    char cCharAt = str.charAt(i9);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(IOUtils.replaceChars[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i9++;
                }
                write(39);
                return;
            }
            expandCapacity(i11);
        }
        int i12 = this.count;
        int i13 = i12 + 1;
        int i14 = i13 + length;
        char[] cArr = this.buf;
        cArr[i12] = '\'';
        str.getChars(0, length, cArr, i13);
        this.count = i11;
        int i15 = -1;
        char c5 = 0;
        for (int i16 = i13; i16 < i14; i16++) {
            char c9 = this.buf[i16];
            if (c9 <= '\r' || c9 == '\\' || c9 == '\'' || (c9 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i9++;
                i15 = i16;
                c5 = c9;
            }
        }
        int i17 = i11 + i9;
        if (i17 > this.buf.length) {
            expandCapacity(i17);
        }
        this.count = i17;
        if (i9 == 1) {
            char[] cArr2 = this.buf;
            int i18 = i15 + 1;
            System.arraycopy(cArr2, i18, cArr2, i15 + 2, (i14 - i15) - 1);
            char[] cArr3 = this.buf;
            cArr3[i15] = '\\';
            cArr3[i18] = IOUtils.replaceChars[c5];
        } else if (i9 > 1) {
            char[] cArr4 = this.buf;
            int i19 = i15 + 1;
            System.arraycopy(cArr4, i19, cArr4, i15 + 2, (i14 - i15) - 1);
            char[] cArr5 = this.buf;
            cArr5[i15] = '\\';
            cArr5[i19] = IOUtils.replaceChars[c5];
            int i20 = i14 + 1;
            for (int i21 = i15 - 1; i21 >= i13; i21--) {
                char c10 = this.buf[i21];
                if (c10 <= '\r' || c10 == '\\' || c10 == '\'' || (c10 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i22 = i21 + 1;
                    System.arraycopy(cArr6, i22, cArr6, i21 + 2, (i20 - i21) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i21] = '\\';
                    cArr7[i22] = IOUtils.replaceChars[c10];
                    i20++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == IOUtils.UTF8) {
            return encodeToUTF8(outputStream);
        }
        byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public boolean isEnabled(int i9) {
        return (i9 & this.features) != 0;
    }

    public void writeFieldName(String str, boolean z8) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.useSingleQuotes) {
            if (!this.quoteFieldNames) {
                writeKeyWithSingleQuoteIfHasSpecial(str);
                return;
            } else {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
        }
        if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ':');
            return;
        }
        int i9 = 0;
        boolean z9 = true;
        boolean z10 = str.length() == 0;
        while (true) {
            if (i9 >= str.length()) {
                z9 = z10;
                break;
            }
            char cCharAt = str.charAt(i9);
            if ((cCharAt < '@' && (this.sepcialBits & (1 << cCharAt)) != 0) || cCharAt == '\\') {
                break;
            } else {
                i9++;
            }
        }
        if (z9) {
            writeStringWithDoubleQuote(str, ':');
        } else {
            write(str);
            write(58);
        }
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public void writeNull(int i9, int i10) {
        if ((i9 & i10) == 0 && (this.features & i10) == 0) {
            writeNull();
            return;
        }
        int i11 = SerializerFeature.WriteMapNullValue.mask;
        if ((i9 & i11) != 0 && (i9 & (~i11) & SerializerFeature.WRITE_MAP_NULL_FEATURES) == 0) {
            writeNull();
            return;
        }
        if (i10 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        if (i10 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
            return;
        }
        if (i10 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i10 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer == null) {
            if (charset == IOUtils.UTF8) {
                return encodeToUTF8Bytes();
            }
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public SerializeWriter(Writer writer, int i9, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.buf = new char[OpusCodecConfig.APPLICATION_VOIP];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i9 |= serializerFeature.getMask();
        }
        this.features = i9;
        computeFeatures();
    }

    public void writeFieldValue(char c5, String str, boolean z8) {
        if (!this.quoteFieldNames) {
            write(c5);
            writeFieldName(str);
            write(z8);
            return;
        }
        int i9 = z8 ? 4 : 5;
        int length = str.length();
        int i10 = this.count + length + 4 + i9;
        if (i10 > this.buf.length) {
            if (this.writer != null) {
                write(c5);
                writeString(str);
                write(58);
                write(z8);
                return;
            }
            expandCapacity(i10);
        }
        int i11 = this.count;
        this.count = i10;
        char[] cArr = this.buf;
        cArr[i11] = c5;
        int i12 = i11 + length;
        cArr[i11 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i11 + 2);
        char[] cArr2 = this.buf;
        cArr2[i12 + 2] = this.keySeperator;
        if (z8) {
            System.arraycopy(VALUE_TRUE, 0, cArr2, i12 + 3, 5);
        } else {
            System.arraycopy(VALUE_FALSE, 0, cArr2, i12 + 3, 6);
        }
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i9, int i10) {
        int i11;
        if (i9 < 0 || i9 > cArr.length || i10 < 0 || (i11 = i9 + i10) > cArr.length || i11 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i10 == 0) {
            return;
        }
        int i12 = this.count + i10;
        if (i12 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i12);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i13 = this.count;
                    int i14 = length - i13;
                    System.arraycopy(cArr, i9, cArr2, i13, i14);
                    this.count = this.buf.length;
                    flush();
                    i10 -= i14;
                    i9 += i14;
                } while (i10 > this.buf.length);
                i12 = i10;
            }
        }
        System.arraycopy(cArr, i9, this.buf, this.count, i10);
        this.count = i12;
    }

    public void writeString(char[] cArr) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(cArr);
        } else {
            writeStringWithDoubleQuote(new String(cArr), (char) 0);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i9, int i10) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i9, i10).toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c5) {
        write(c5);
        return this;
    }

    public SerializeWriter(int i9) {
        this((Writer) null, i9);
    }

    public SerializeWriter(Writer writer, int i9) {
        this.maxBufSize = -1;
        this.writer = writer;
        if (i9 > 0) {
            this.buf = new char[i9];
            computeFeatures();
            return;
        }
        throw new IllegalArgumentException(e.i(i9, "Negative initial size: "));
    }

    @Override // java.io.Writer
    public void write(String str, int i9, int i10) {
        int i11;
        int i12 = this.count + i10;
        if (i12 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i12);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i13 = this.count;
                    int i14 = length - i13;
                    i11 = i9 + i14;
                    str.getChars(i9, i11, cArr, i13);
                    this.count = this.buf.length;
                    flush();
                    i10 -= i14;
                    if (i10 <= this.buf.length) {
                        break;
                    } else {
                        i9 = i11;
                    }
                }
                i12 = i10;
                i9 = i11;
            }
        }
        str.getChars(i9, i10 + i9, this.buf, this.count);
        this.count = i12;
    }

    public void writeFieldValue(char c5, String str, int i9) {
        if (i9 != Integer.MIN_VALUE && this.quoteFieldNames) {
            int iStringSize = i9 < 0 ? IOUtils.stringSize(-i9) + 1 : IOUtils.stringSize(i9);
            int length = str.length();
            int i10 = this.count + length + 4 + iStringSize;
            if (i10 > this.buf.length) {
                if (this.writer != null) {
                    write(c5);
                    writeFieldName(str);
                    writeInt(i9);
                    return;
                }
                expandCapacity(i10);
            }
            int i11 = this.count;
            this.count = i10;
            char[] cArr = this.buf;
            cArr[i11] = c5;
            int i12 = i11 + length;
            cArr[i11 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i11 + 2);
            char[] cArr2 = this.buf;
            cArr2[i12 + 2] = this.keySeperator;
            cArr2[i12 + 3] = ':';
            IOUtils.getChars(i9, this.count, cArr2);
            return;
        }
        write(c5);
        writeFieldName(str);
        writeInt(i9);
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(List<String> list) {
        boolean z8;
        int i9;
        if (list.isEmpty()) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        int i10 = this.count;
        int size = list.size();
        int i11 = i10;
        int i12 = 0;
        while (i12 < size) {
            String str = list.get(i12);
            if (str == null) {
                z8 = true;
            } else {
                int length = str.length();
                z8 = false;
                for (int i13 = 0; i13 < length; i13++) {
                    char cCharAt = str.charAt(i13);
                    z8 = cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\\';
                    if (z8) {
                        break;
                    }
                }
            }
            if (z8) {
                this.count = i10;
                write(91);
                for (int i14 = 0; i14 < list.size(); i14++) {
                    String str2 = list.get(i14);
                    if (i14 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, (char) 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i11;
            int i15 = length2 + 3;
            if (i12 == list.size() - 1) {
                i15 = length2 + 4;
            }
            if (i15 > this.buf.length) {
                this.count = i11;
                expandCapacity(i15);
            }
            if (i12 == 0) {
                i9 = i11 + 1;
                this.buf[i11] = '[';
            } else {
                i9 = i11 + 1;
                this.buf[i11] = ',';
            }
            int i16 = i9 + 1;
            this.buf[i9] = '\"';
            str.getChars(0, str.length(), this.buf, i16);
            int length3 = str.length() + i16;
            this.buf[length3] = '\"';
            i12++;
            i11 = length3 + 1;
        }
        this.buf[i11] = ']';
        this.count = i11 + 1;
    }

    public void writeStringWithSingleQuote(char[] cArr) {
        int i9 = 0;
        if (cArr == null) {
            int i10 = this.count + 4;
            if (i10 > this.buf.length) {
                expandCapacity(i10);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i10;
            return;
        }
        int length = cArr.length;
        int i11 = this.count + length + 2;
        if (i11 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i9 < cArr.length) {
                    char c5 = cArr[i9];
                    if (c5 > '\r' && c5 != '\\' && c5 != '\'' && (c5 != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(c5);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[c5]);
                    }
                    i9++;
                }
                write(39);
                return;
            }
            expandCapacity(i11);
        }
        int i12 = this.count;
        int i13 = i12 + 1;
        int i14 = length + i13;
        char[] cArr2 = this.buf;
        cArr2[i12] = '\'';
        System.arraycopy(cArr, 0, cArr2, i13, cArr.length);
        this.count = i11;
        int i15 = -1;
        char c9 = 0;
        for (int i16 = i13; i16 < i14; i16++) {
            char c10 = this.buf[i16];
            if (c10 <= '\r' || c10 == '\\' || c10 == '\'' || (c10 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i9++;
                i15 = i16;
                c9 = c10;
            }
        }
        int i17 = i11 + i9;
        if (i17 > this.buf.length) {
            expandCapacity(i17);
        }
        this.count = i17;
        if (i9 == 1) {
            char[] cArr3 = this.buf;
            int i18 = i15 + 1;
            System.arraycopy(cArr3, i18, cArr3, i15 + 2, (i14 - i15) - 1);
            char[] cArr4 = this.buf;
            cArr4[i15] = '\\';
            cArr4[i18] = IOUtils.replaceChars[c9];
        } else if (i9 > 1) {
            char[] cArr5 = this.buf;
            int i19 = i15 + 1;
            System.arraycopy(cArr5, i19, cArr5, i15 + 2, (i14 - i15) - 1);
            char[] cArr6 = this.buf;
            cArr6[i15] = '\\';
            cArr6[i19] = IOUtils.replaceChars[c9];
            int i20 = i14 + 1;
            for (int i21 = i15 - 1; i21 >= i13; i21--) {
                char c11 = this.buf[i21];
                if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.buf;
                    int i22 = i21 + 1;
                    System.arraycopy(cArr7, i22, cArr7, i21 + 2, (i20 - i21) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i21] = '\\';
                    cArr8[i22] = IOUtils.replaceChars[c11];
                    i20++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeFieldValue(char c5, String str, long j) {
        if (j != Long.MIN_VALUE && this.quoteFieldNames && !isEnabled(SerializerFeature.BrowserCompatible.mask)) {
            int iStringSize = j < 0 ? IOUtils.stringSize(-j) + 1 : IOUtils.stringSize(j);
            int length = str.length();
            int i9 = this.count + length + 4 + iStringSize;
            if (i9 > this.buf.length) {
                if (this.writer != null) {
                    write(c5);
                    writeFieldName(str);
                    writeLong(j);
                    return;
                }
                expandCapacity(i9);
            }
            int i10 = this.count;
            this.count = i9;
            char[] cArr = this.buf;
            cArr[i10] = c5;
            int i11 = i10 + length;
            cArr[i10 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i10 + 2);
            char[] cArr2 = this.buf;
            cArr2[i11 + 2] = this.keySeperator;
            cArr2[i11 + 3] = ':';
            IOUtils.getChars(j, this.count, cArr2);
            return;
        }
        write(c5);
        writeFieldName(str);
        writeLong(j);
    }

    public void write(boolean z8) {
        if (z8) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c5, String str, float f6) {
        write(c5);
        writeFieldName(str);
        writeFloat(f6, false);
    }

    public void writeFieldValue(char c5, String str, double d9) {
        write(c5);
        writeFieldName(str);
        writeDouble(d9, false);
    }

    public void writeFieldValue(char c5, String str, String str2) {
        if (this.quoteFieldNames) {
            if (this.useSingleQuotes) {
                write(c5);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            }
            if (isEnabled(SerializerFeature.BrowserCompatible)) {
                write(c5);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            writeFieldValueStringWithDoubleQuoteCheck(c5, str, str2);
            return;
        }
        write(c5);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    public void writeFieldValue(char c5, String str, Enum<?> r8) {
        if (r8 == null) {
            write(c5);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c5, str, r8.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c5, str, r8.toString());
        } else {
            writeFieldValue(c5, str, r8.ordinal());
        }
    }

    public void writeFieldValue(char c5, String str, BigDecimal bigDecimal) {
        String string;
        write(c5);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
            return;
        }
        int iScale = bigDecimal.scale();
        if (isEnabled(SerializerFeature.WriteBigDecimalAsPlain) && iScale >= -100 && iScale < 100) {
            string = bigDecimal.toPlainString();
        } else {
            string = bigDecimal.toString();
        }
        write(string);
    }

    /* JADX WARN: Code duplicated, block: B:169:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:61:0x014d  */
    public void writeStringWithDoubleQuote(char[] cArr, char c5) {
        int i9;
        int i10;
        if (cArr == null) {
            writeNull();
            if (c5 != 0) {
                write(c5);
                return;
            }
            return;
        }
        int length = cArr.length;
        int i11 = this.count + length;
        int i12 = i11 + 2;
        if (c5 != 0) {
            i12 = i11 + 3;
        }
        char c9 = '\"';
        if (i12 <= this.buf.length) {
            i9 = 1;
        } else {
            if (this.writer != null) {
                write(34);
                for (char c10 : cArr) {
                    if (isEnabled(SerializerFeature.BrowserSecure) && (c10 == '(' || c10 == ')' || c10 == '<' || c10 == '>')) {
                        write(92);
                        write(117);
                        char[] cArr2 = IOUtils.DIGITS;
                        write(cArr2[(c10 >>> '\f') & 15]);
                        write(cArr2[(c10 >>> '\b') & 15]);
                        write(cArr2[(c10 >>> 4) & 15]);
                        write(cArr2[c10 & 15]);
                    } else if (!isEnabled(SerializerFeature.BrowserCompatible)) {
                        byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                        if ((c10 < bArr.length && bArr[c10] != 0) || (c10 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                            write(92);
                            if (bArr[c10] == 4) {
                                write(117);
                                char[] cArr3 = IOUtils.DIGITS;
                                write(cArr3[(c10 >>> '\f') & 15]);
                                write(cArr3[(c10 >>> '\b') & 15]);
                                write(cArr3[(c10 >>> 4) & 15]);
                                write(cArr3[c10 & 15]);
                            } else {
                                write(IOUtils.replaceChars[c10]);
                            }
                        } else {
                            write(c10);
                        }
                    } else if (c10 == '\b' || c10 == '\f' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\"' || c10 == '/' || c10 == '\\') {
                        write(92);
                        write(IOUtils.replaceChars[c10]);
                    } else if (c10 < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr4 = IOUtils.ASCII_CHARS;
                        int i13 = c10 * 2;
                        write(cArr4[i13]);
                        write(cArr4[i13 + 1]);
                    } else if (c10 >= 127) {
                        write(92);
                        write(117);
                        char[] cArr5 = IOUtils.DIGITS;
                        write(cArr5[(c10 >>> '\f') & 15]);
                        write(cArr5[(c10 >>> '\b') & 15]);
                        write(cArr5[(c10 >>> 4) & 15]);
                        write(cArr5[c10 & 15]);
                    } else {
                        write(c10);
                    }
                }
                write(34);
                if (c5 != 0) {
                    write(c5);
                    return;
                }
                return;
            }
            i9 = 1;
            expandCapacity(i12);
        }
        int i14 = this.count;
        int i15 = i14 + 1;
        int i16 = length + i15;
        char[] cArr6 = this.buf;
        cArr6[i14] = '\"';
        char c11 = 0;
        System.arraycopy(cArr, 0, cArr6, i15, cArr.length);
        this.count = i12;
        int i17 = -1;
        if (isEnabled(SerializerFeature.BrowserCompatible)) {
            for (int i18 = i15; i18 < i16; i18++) {
                char c12 = this.buf[i18];
                if (c12 == '\"' || c12 == '/' || c12 == '\\' || c12 == '\b' || c12 == '\f' || c12 == '\n' || c12 == '\r' || c12 == '\t') {
                    i12++;
                } else {
                    if (c12 < ' ' || c12 >= 127) {
                        i12 += 5;
                    }
                }
                i17 = i18;
            }
            if (i12 > this.buf.length) {
                expandCapacity(i12);
            }
            this.count = i12;
            while (i17 >= i15) {
                char[] cArr7 = this.buf;
                char c13 = cArr7[i17];
                if (c13 == '\b' || c13 == '\f' || c13 == '\n' || c13 == '\r' || c13 == '\t') {
                    int i19 = i17 + 1;
                    System.arraycopy(cArr7, i19, cArr7, i17 + 2, (i16 - i17) - 1);
                    char[] cArr8 = this.buf;
                    cArr8[i17] = '\\';
                    cArr8[i19] = IOUtils.replaceChars[c13];
                } else {
                    if (c13 == '\"' || c13 == '/' || c13 == '\\') {
                        int i20 = i17 + 1;
                        System.arraycopy(cArr7, i20, cArr7, i17 + 2, (i16 - i17) - 1);
                        char[] cArr9 = this.buf;
                        cArr9[i17] = '\\';
                        cArr9[i20] = c13;
                    } else {
                        if (c13 < ' ') {
                            int i21 = i17 + 1;
                            System.arraycopy(cArr7, i21, cArr7, i17 + 6, (i16 - i17) - 1);
                            char[] cArr10 = this.buf;
                            cArr10[i17] = '\\';
                            cArr10[i21] = 'u';
                            cArr10[i17 + 2] = '0';
                            cArr10[i17 + 3] = '0';
                            char[] cArr11 = IOUtils.ASCII_CHARS;
                            int i22 = c13 * 2;
                            cArr10[i17 + 4] = cArr11[i22];
                            cArr10[i17 + 5] = cArr11[i22 + 1];
                        } else if (c13 >= 127) {
                            int i23 = i17 + 1;
                            System.arraycopy(cArr7, i23, cArr7, i17 + 6, (i16 - i17) - 1);
                            char[] cArr12 = this.buf;
                            cArr12[i17] = '\\';
                            cArr12[i23] = 'u';
                            char[] cArr13 = IOUtils.DIGITS;
                            cArr12[i17 + 2] = cArr13[(c13 >>> '\f') & 15];
                            cArr12[i17 + 3] = cArr13[(c13 >>> '\b') & 15];
                            cArr12[i17 + 4] = cArr13[(c13 >>> 4) & 15];
                            cArr12[i17 + 5] = cArr13[c13 & 15];
                        }
                        i16 += 5;
                    }
                    i17--;
                }
                i16++;
                i17--;
            }
            if (c5 != 0) {
                char[] cArr14 = this.buf;
                int i24 = this.count;
                cArr14[i24 - 2] = '\"';
                cArr14[i24 - 1] = c5;
                return;
            }
            this.buf[this.count - 1] = '\"';
            return;
        }
        int i25 = -1;
        int i26 = -1;
        int i27 = 0;
        int i28 = i15;
        while (i28 < i16) {
            char c14 = c9;
            char c15 = this.buf[i28];
            if (c15 >= ']') {
                if (c15 < 127 || !(c15 == 8232 || c15 == 8233 || c15 < 160)) {
                    i10 = i17;
                    c11 = c11;
                } else {
                    if (i25 == i17) {
                        i25 = i28;
                    }
                    i27++;
                    i12 += 4;
                    i26 = i28;
                    i10 = i17;
                    c11 = c15;
                }
            } else if ((c15 >= '@' || (this.sepcialBits & (1 << c15)) == 0) && c15 != '\\') {
                i10 = -1;
                c11 = c11;
            } else {
                i27++;
                if (c15 == '(' || c15 == ')' || c15 == '<' || c15 == '>') {
                    i12 += 4;
                } else {
                    byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                    if (c15 < bArr2.length && bArr2[c15] == 4) {
                        i12 += 4;
                    }
                }
                i10 = -1;
                if (i25 == -1) {
                    i25 = i28;
                    i26 = i25;
                } else {
                    i26 = i28;
                }
                c11 = c15;
            }
            i28++;
            i17 = i10;
            c9 = c14;
        }
        char c16 = c11;
        char c17 = c9;
        if (i27 > 0) {
            int i29 = i12 + i27;
            if (i29 > this.buf.length) {
                expandCapacity(i29);
            }
            this.count = i29;
            int i30 = i9;
            if (i27 == i30) {
                if (c16 == 8232) {
                    int i31 = i26 + 1;
                    int i32 = (i16 - i26) - i30;
                    char[] cArr15 = this.buf;
                    System.arraycopy(cArr15, i31, cArr15, i26 + 6, i32);
                    char[] cArr16 = this.buf;
                    cArr16[i26] = '\\';
                    cArr16[i31] = 'u';
                    cArr16[i26 + 2] = '2';
                    cArr16[i26 + 3] = '0';
                    cArr16[i26 + 4] = '2';
                    cArr16[i26 + 5] = '8';
                } else if (c16 == 8233) {
                    int i33 = i26 + 1;
                    char[] cArr17 = this.buf;
                    System.arraycopy(cArr17, i33, cArr17, i26 + 6, (i16 - i26) - 1);
                    char[] cArr18 = this.buf;
                    cArr18[i26] = '\\';
                    cArr18[i33] = 'u';
                    cArr18[i26 + 2] = '2';
                    cArr18[i26 + 3] = '0';
                    cArr18[i26 + 4] = '2';
                    cArr18[i26 + 5] = '9';
                } else if (c16 != '(' && c16 != ')' && c16 != '<' && c16 != '>') {
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if (c16 < bArr3.length && bArr3[c16] == 4) {
                        int i34 = i26 + 1;
                        char[] cArr19 = this.buf;
                        System.arraycopy(cArr19, i34, cArr19, i26 + 6, (i16 - i26) - 1);
                        char[] cArr20 = this.buf;
                        cArr20[i26] = '\\';
                        cArr20[i34] = 'u';
                        char[] cArr21 = IOUtils.DIGITS;
                        cArr20[i26 + 2] = cArr21[(c16 >>> '\f') & 15];
                        cArr20[i26 + 3] = cArr21[(c16 >>> '\b') & 15];
                        cArr20[i26 + 4] = cArr21[(c16 >>> 4) & 15];
                        cArr20[i26 + 5] = cArr21[c16 & 15];
                    } else {
                        int i35 = i26 + 1;
                        char[] cArr22 = this.buf;
                        System.arraycopy(cArr22, i35, cArr22, i26 + 2, (i16 - i26) - 1);
                        char[] cArr23 = this.buf;
                        cArr23[i26] = '\\';
                        cArr23[i35] = IOUtils.replaceChars[c16];
                    }
                } else {
                    int i36 = i26 + 1;
                    char[] cArr24 = this.buf;
                    System.arraycopy(cArr24, i36, cArr24, i26 + 6, (i16 - i26) - 1);
                    char[] cArr25 = this.buf;
                    cArr25[i26] = '\\';
                    cArr25[i36] = 'u';
                    char[] cArr26 = IOUtils.DIGITS;
                    cArr25[i26 + 2] = cArr26[(c16 >>> '\f') & 15];
                    cArr25[i26 + 3] = cArr26[(c16 >>> '\b') & 15];
                    cArr25[i26 + 4] = cArr26[(c16 >>> 4) & 15];
                    cArr25[i26 + 5] = cArr26[c16 & 15];
                }
            } else if (i27 > i30) {
                for (int i37 = i25 - i15; i37 < cArr.length; i37++) {
                    char c18 = cArr[i37];
                    if (this.browserSecure) {
                        if (c18 != '(' && c18 != ')') {
                            if (c18 == '<' || c18 == '>') {
                            }
                        }
                        char[] cArr27 = this.buf;
                        cArr27[i25] = '\\';
                        cArr27[i25 + 1] = 'u';
                        char[] cArr28 = IOUtils.DIGITS;
                        cArr27[i25 + 2] = cArr28[(c18 >>> '\f') & 15];
                        cArr27[i25 + 3] = cArr28[(c18 >>> '\b') & 15];
                        int i38 = i25 + 5;
                        cArr27[i25 + 4] = cArr28[(c18 >>> 4) & 15];
                        i25 += 6;
                        cArr27[i38] = cArr28[c18 & 15];
                    }
                    byte[] bArr4 = IOUtils.specicalFlags_doubleQuotes;
                    if ((c18 < bArr4.length && bArr4[c18] != 0) || (c18 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr29 = this.buf;
                        int i39 = i25 + 1;
                        cArr29[i25] = '\\';
                        if (bArr4[c18] == 4) {
                            cArr29[i39] = 'u';
                            char[] cArr30 = IOUtils.DIGITS;
                            cArr29[i25 + 2] = cArr30[(c18 >>> '\f') & 15];
                            cArr29[i25 + 3] = cArr30[(c18 >>> '\b') & 15];
                            int i40 = i25 + 5;
                            cArr29[i25 + 4] = cArr30[(c18 >>> 4) & 15];
                            i25 += 6;
                            cArr29[i40] = cArr30[c18 & 15];
                        } else {
                            i25 += 2;
                            cArr29[i39] = IOUtils.replaceChars[c18];
                        }
                    } else if (c18 != 8232 && c18 != 8233) {
                        this.buf[i25] = c18;
                        i25++;
                    } else {
                        char[] cArr31 = this.buf;
                        cArr31[i25] = '\\';
                        cArr31[i25 + 1] = 'u';
                        char[] cArr32 = IOUtils.DIGITS;
                        cArr31[i25 + 2] = cArr32[(c18 >>> '\f') & 15];
                        cArr31[i25 + 3] = cArr32[(c18 >>> '\b') & 15];
                        int i41 = i25 + 5;
                        cArr31[i25 + 4] = cArr32[(c18 >>> 4) & 15];
                        i25 += 6;
                        cArr31[i41] = cArr32[c18 & 15];
                    }
                }
            }
        }
        if (c5 != 0) {
            char[] cArr33 = this.buf;
            int i42 = this.count;
            cArr33[i42 - 2] = c17;
            cArr33[i42 - 1] = c5;
            return;
        }
        this.buf[this.count - 1] = c17;
    }
}

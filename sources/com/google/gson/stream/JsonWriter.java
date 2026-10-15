package com.google.gson.stream;

import com.google.gson.FormattingStyle;
import com.google.gson.Strictness;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private String deferredName;
    private String formattedColon;
    private String formattedComma;
    private FormattingStyle formattingStyle;
    private boolean htmlSafe;
    private final Writer out;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;
    private Strictness strictness;
    private boolean usesEmptyNewlineAndIndent;
    private static final Pattern VALID_JSON_NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] REPLACEMENT_CHARS = new String[128];

    static {
        for (int i9 = 0; i9 <= 31; i9++) {
            REPLACEMENT_CHARS[i9] = String.format("\\u%04x", Integer.valueOf(i9));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        push(6);
        this.strictness = Strictness.LEGACY_STRICT;
        this.serializeNulls = true;
        Objects.requireNonNull(writer, "out == null");
        this.out = writer;
        setFormattingStyle(FormattingStyle.COMPACT);
    }

    private static boolean alwaysCreatesValidJsonNumber(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void beforeName() throws IOException {
        int iPeek = peek();
        if (iPeek == 5) {
            this.out.write(this.formattedComma);
        } else if (iPeek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int iPeek = peek();
        if (iPeek == 1) {
            replaceTop(2);
            newline();
            return;
        }
        if (iPeek == 2) {
            this.out.append((CharSequence) this.formattedComma);
            newline();
        } else {
            if (iPeek == 4) {
                this.out.append((CharSequence) this.formattedColon);
                replaceTop(5);
                return;
            }
            if (iPeek != 6) {
                if (iPeek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.strictness != Strictness.LENIENT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            replaceTop(7);
        }
    }

    private JsonWriter closeScope(int i9, int i10, char c5) throws IOException {
        int iPeek = peek();
        if (iPeek != i10 && iPeek != i9) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        this.stackSize--;
        if (iPeek == i10) {
            newline();
        }
        this.out.write(c5);
        return this;
    }

    private void newline() throws IOException {
        if (this.usesEmptyNewlineAndIndent) {
            return;
        }
        this.out.write(this.formattingStyle.getNewline());
        int i9 = this.stackSize;
        for (int i10 = 1; i10 < i9; i10++) {
            this.out.write(this.formattingStyle.getIndent());
        }
    }

    private JsonWriter openScope(int i9, char c5) throws IOException {
        beforeValue();
        push(i9);
        this.out.write(c5);
        return this;
    }

    private int peek() {
        int i9 = this.stackSize;
        if (i9 != 0) {
            return this.stack[i9 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int i9) {
        int i10 = this.stackSize;
        int[] iArr = this.stack;
        if (i10 == iArr.length) {
            this.stack = Arrays.copyOf(iArr, i10 * 2);
        }
        int[] iArr2 = this.stack;
        int i11 = this.stackSize;
        this.stackSize = i11 + 1;
        iArr2[i11] = i9;
    }

    private void replaceTop(int i9) {
        this.stack[this.stackSize - 1] = i9;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void string(String str) throws IOException {
        String str2;
        String[] strArr = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        this.out.write(34);
        int length = str.length();
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i9 < i10) {
                        this.out.write(str, i9, i10 - i9);
                    }
                    this.out.write(str2);
                    i9 = i10 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i9 < i10) {
                    this.out.write(str, i9, i10 - i9);
                }
                this.out.write(str2);
                i9 = i10 + 1;
            }
        }
        if (i9 < length) {
            this.out.write(str, i9, length - i9);
        }
        this.out.write(34);
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return openScope(1, '[');
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return openScope(3, '{');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i9 = this.stackSize;
        if (i9 > 1 || (i9 == 1 && this.stack[i9 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public JsonWriter endArray() {
        return closeScope(1, 2, ']');
    }

    public JsonWriter endObject() {
        return closeScope(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public final FormattingStyle getFormattingStyle() {
        return this.formattingStyle;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final Strictness getStrictness() {
        return this.strictness;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.strictness == Strictness.LENIENT;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append((CharSequence) str);
        return this;
    }

    public JsonWriter name(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.deferredName != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iPeek = peek();
        if (iPeek != 3 && iPeek != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.deferredName = str;
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            writeDeferredName();
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public final void setFormattingStyle(FormattingStyle formattingStyle) {
        Objects.requireNonNull(formattingStyle);
        this.formattingStyle = formattingStyle;
        this.formattedComma = Constants.ACCEPT_TIME_SEPARATOR_SP;
        if (formattingStyle.usesSpaceAfterSeparators()) {
            this.formattedColon = ": ";
            if (this.formattingStyle.getNewline().isEmpty()) {
                this.formattedComma = ", ";
            }
        } else {
            this.formattedColon = Constants.COLON_SEPARATOR;
        }
        this.usesEmptyNewlineAndIndent = this.formattingStyle.getNewline().isEmpty() && this.formattingStyle.getIndent().isEmpty();
    }

    public final void setHtmlSafe(boolean z8) {
        this.htmlSafe = z8;
    }

    public final void setIndent(String str) {
        if (str.isEmpty()) {
            setFormattingStyle(FormattingStyle.COMPACT);
        } else {
            setFormattingStyle(FormattingStyle.PRETTY.withIndent(str));
        }
    }

    @Deprecated
    public final void setLenient(boolean z8) {
        setStrictness(z8 ? Strictness.LENIENT : Strictness.LEGACY_STRICT);
    }

    public final void setSerializeNulls(boolean z8) {
        this.serializeNulls = z8;
    }

    public final void setStrictness(Strictness strictness) {
        Objects.requireNonNull(strictness);
        this.strictness = strictness;
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public JsonWriter value(boolean z8) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z8 ? "true" : "false");
        return this;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public JsonWriter value(float f6) throws IOException {
        writeDeferredName();
        if (this.strictness != Strictness.LENIENT && (Float.isNaN(f6) || Float.isInfinite(f6))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + f6);
        }
        beforeValue();
        this.out.append((CharSequence) Float.toString(f6));
        return this;
    }

    public JsonWriter value(double d9) throws IOException {
        writeDeferredName();
        if (this.strictness != Strictness.LENIENT && (Double.isNaN(d9) || Double.isInfinite(d9))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d9);
        }
        beforeValue();
        this.out.append((CharSequence) Double.toString(d9));
        return this;
    }

    public JsonWriter value(long j) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!alwaysCreatesValidJsonNumber(cls)) {
            if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
                if (cls != Float.class && cls != Double.class && !VALID_JSON_NUMBER_PATTERN.matcher(string).matches()) {
                    throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
                }
            } else if (this.strictness != Strictness.LENIENT) {
                throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
            }
        }
        beforeValue();
        this.out.append((CharSequence) string);
        return this;
    }
}

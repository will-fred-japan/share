package p099n1;

import java.io.Writer;

/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20557a = 0;

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c5) {
        this.f20557a++;
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i9, int i10) {
        this.f20557a += i10;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c5) {
        this.f20557a++;
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i9) {
        this.f20557a++;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        this.f20557a = charSequence.length() + this.f20557a;
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str) {
        this.f20557a = str.length() + this.f20557a;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        this.f20557a = charSequence.length() + this.f20557a;
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr) {
        this.f20557a += cArr.length;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i9, int i10) {
        this.f20557a = (i10 - i9) + this.f20557a;
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i9, int i10) {
        this.f20557a += i10;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i9, int i10) {
        this.f20557a = (i10 - i9) + this.f20557a;
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}

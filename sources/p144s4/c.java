package p144s4;

import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class c extends PrintWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageDigest f21237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Charset f21238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f21239c;

    public static class a {
        public boolean a(String str) {
            return true;
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(int i9) {
        super.write(i9);
        MessageDigest messageDigest = this.f21237a;
        if (messageDigest != null) {
            messageDigest.update((byte) i9);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(String str, int i9, int i10) {
        super.write(str, i9, i10);
        MessageDigest messageDigest = this.f21237a;
        if (messageDigest != null) {
            a aVar = this.f21239c;
            if (aVar == null || aVar.a(str)) {
                messageDigest.update(this.f21238b.encode(CharBuffer.wrap(str, i9, i10 + i9)).array());
            }
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(char[] cArr, int i9, int i10) {
        super.write(cArr, i9, i10);
        MessageDigest messageDigest = this.f21237a;
        if (messageDigest != null) {
            messageDigest.update(this.f21238b.encode(CharBuffer.wrap(cArr)).array());
        }
    }
}

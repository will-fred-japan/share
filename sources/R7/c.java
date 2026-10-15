package R7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements Iterator<String>, L7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4082e;

    public c(String string) {
        kotlin.jvm.internal.k.e(string, "string");
        this.f4078a = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i9;
        int i10;
        int i11 = this.f4079b;
        if (i11 != 0) {
            return i11 == 1;
        }
        if (this.f4082e < 0) {
            this.f4079b = 2;
            return false;
        }
        String str = this.f4078a;
        int length = str.length();
        int length2 = str.length();
        for (int i12 = this.f4080c; i12 < length2; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i9 = (cCharAt == '\r' && (i10 = i12 + 1) < str.length() && str.charAt(i10) == '\n') ? 2 : 1;
                length = i12;
                this.f4079b = 1;
                this.f4082e = i9;
                this.f4081d = length;
                return true;
            }
        }
        i9 = -1;
        this.f4079b = 1;
        this.f4082e = i9;
        this.f4081d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f4079b = 0;
        int i9 = this.f4081d;
        int i10 = this.f4080c;
        this.f4080c = this.f4082e + i9;
        return this.f4078a.subSequence(i10, i9).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

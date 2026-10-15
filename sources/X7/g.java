package X7;

import B0.N;
import S7.AbstractC0410w;
import S7.C0405q;
import S7.C0408u;
import S7.H;
import S7.X;
import S7.m0;
import S7.o0;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final N f5142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final N f5143b;

    static {
        int i9 = 7;
        f5142a = new N(i9, "UNDEFINED");
        f5143b = new N(i9, "REUSABLE_CLAIMED");
    }

    public static final void a(B7.e eVar, Object obj) {
        if (!(eVar instanceof f)) {
            eVar.resumeWith(obj);
            return;
        }
        f fVar = (f) eVar;
        Throwable thA = p188x7.f.a(obj);
        Object c0405q = thA == null ? obj : new C0405q(thA, false);
        D7.c cVar = fVar.f5139e;
        B7.h context = cVar.getContext();
        AbstractC0410w abstractC0410w = fVar.f5138d;
        if (abstractC0410w.p(context)) {
            fVar.f5140f = c0405q;
            fVar.f4232c = 1;
            abstractC0410w.g(cVar.getContext(), fVar);
            return;
        }
        S7.N nA = m0.a();
        if (nA.f4237c >= 4294967296L) {
            fVar.f5140f = c0405q;
            fVar.f4232c = 1;
            y7.e<H<?>> eVar2 = nA.f4239e;
            if (eVar2 == null) {
                eVar2 = new y7.e<>();
                nA.f4239e = eVar2;
            }
            eVar2.addLast(fVar);
            return;
        }
        nA.z(true);
        try {
            X x8 = (X) cVar.getContext().i(X.a.f4251a);
            if (x8 == null || x8.a()) {
                Object obj2 = fVar.f5141g;
                B7.h context2 = cVar.getContext();
                Object objC = v.c(context2, obj2);
                o0<?> o0VarB = objC != v.f5172a ? C0408u.b(cVar, context2, objC) : null;
                try {
                    cVar.resumeWith(obj);
                    p188x7.k kVar = p188x7.k.f22364a;
                    if (o0VarB == null || o0VarB.j0()) {
                        v.a(context2, objC);
                    }
                } catch (Throwable th) {
                    if (o0VarB == null || o0VarB.j0()) {
                        v.a(context2, objC);
                    }
                    throw th;
                }
            } else {
                fVar.resumeWith(p188x7.g.a(x8.q()));
            }
            while (nA.C()) {
            }
        } catch (Throwable th2) {
            try {
                fVar.g(th2);
            } finally {
                nA.w(true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x0082 A[LOOP:0: B:24:0x0050->B:39:0x0082, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x008a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0080 A[SYNTHETIC] */
    public static final long b(String str, long j, long j8, long j9) {
        String property;
        Long lValueOf;
        int i9;
        boolean z8;
        long j10;
        long j11;
        boolean z9;
        int iDigit;
        long j12;
        long j13;
        int i10 = u.f5171a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j;
        }
        p199z2.b.q(10);
        int length = property.length();
        if (length != 0) {
            int i11 = 0;
            char cCharAt = property.charAt(0);
            long j14 = -9223372036854775807L;
            if (kotlin.jvm.internal.k.f(cCharAt, 48) < 0) {
                if (length != 1) {
                    if (cCharAt == '+') {
                        i9 = 0;
                        i11 = 1;
                        z8 = true;
                        j10 = 0;
                        j11 = -256204778801521550L;
                        while (true) {
                            if (i11 >= length) {
                                if (i9 == 0) {
                                    j10 = -j10;
                                }
                                lValueOf = Long.valueOf(j10);
                                break;
                            }
                            z9 = z8;
                            iDigit = Character.digit((int) property.charAt(i11), 10);
                            if (iDigit >= 0) {
                                if (j10 < j11) {
                                    if (j11 == -256204778801521550L) {
                                        j11 = j14 / ((long) 10);
                                        if (j10 < j11) {
                                        }
                                    }
                                }
                                j12 = j10 * ((long) 10);
                                j13 = iDigit;
                                if (j12 >= j14 + j13) {
                                    j10 = j12 - j13;
                                    i11++;
                                    z8 = z9;
                                    length = length;
                                }
                            }
                        }
                    } else if (cCharAt == '-') {
                        j14 = Long.MIN_VALUE;
                        i11 = 1;
                        i9 = i11;
                        z8 = true;
                        j10 = 0;
                        j11 = -256204778801521550L;
                        while (true) {
                            if (i11 >= length) {
                                if (i9 == 0) {
                                    j10 = -j10;
                                }
                                lValueOf = Long.valueOf(j10);
                                break;
                            }
                            z9 = z8;
                            iDigit = Character.digit((int) property.charAt(i11), 10);
                            if (iDigit >= 0) {
                                if (j10 < j11) {
                                    if (j11 == -256204778801521550L) {
                                        j11 = j14 / ((long) 10);
                                        if (j10 < j11) {
                                        }
                                    }
                                }
                                j12 = j10 * ((long) 10);
                                j13 = iDigit;
                                if (j12 >= j14 + j13) {
                                    j10 = j12 - j13;
                                    i11++;
                                    z8 = z9;
                                    length = length;
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                i9 = i11;
                z8 = true;
                j10 = 0;
                j11 = -256204778801521550L;
                while (true) {
                    if (i11 >= length) {
                        if (i9 == 0) {
                            j10 = -j10;
                        }
                        lValueOf = Long.valueOf(j10);
                        break;
                    }
                    z9 = z8;
                    iDigit = Character.digit((int) property.charAt(i11), 10);
                    if (iDigit >= 0) {
                        if (j10 < j11) {
                            if (j11 == -256204778801521550L) {
                                j11 = j14 / ((long) 10);
                                if (j10 < j11) {
                                }
                            }
                        }
                        j12 = j10 * ((long) 10);
                        j13 = iDigit;
                        if (j12 >= j14 + j13) {
                            j10 = j12 - j13;
                            i11++;
                            z8 = z9;
                            length = length;
                        }
                    }
                }
            }
            lValueOf = null;
            break;
        } else {
            lValueOf = null;
            break;
        }
        if (lValueOf == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lValueOf.longValue();
        if (j8 <= jLongValue && jLongValue <= j9) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j8 + ".." + j9 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int c(int i9, int i10, String str) {
        return (int) b(str, i9, 1, (i10 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }
}

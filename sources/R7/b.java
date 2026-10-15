package R7;

import K7.p;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Q7.e<O7.h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p<CharSequence, Integer, p188x7.e<Integer, Integer>> f4072b;

    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements Iterator<O7.h>, L7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4073a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public O7.h f4076d;

        public a() {
            b.this.getClass();
            int iY = O7.k.Y(0, 0, b.this.f4071a.length());
            this.f4074b = iY;
            this.f4075c = iY;
        }

        public final void a() {
            p188x7.e<Integer, Integer> eVarInvoke;
            int i9 = this.f4075c;
            if (i9 < 0) {
                this.f4073a = 0;
                this.f4076d = null;
                return;
            }
            b bVar = b.this;
            bVar.getClass();
            String str = bVar.f4071a;
            if (i9 <= str.length() && (eVarInvoke = bVar.f4072b.invoke(str, Integer.valueOf(this.f4075c))) != null) {
                int iIntValue = eVarInvoke.f22353a.intValue();
                int iIntValue2 = eVarInvoke.f22354b.intValue();
                this.f4076d = O7.k.a0(this.f4074b, iIntValue);
                int i10 = iIntValue + iIntValue2;
                this.f4074b = i10;
                this.f4075c = i10 + (iIntValue2 == 0 ? 1 : 0);
            } else {
                this.f4076d = new O7.h(this.f4074b, l.Q(str), 1);
                this.f4075c = -1;
            }
            this.f4073a = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f4073a == -1) {
                a();
            }
            return this.f4073a == 1;
        }

        @Override // java.util.Iterator
        public final O7.h next() {
            if (this.f4073a == -1) {
                a();
            }
            if (this.f4073a == 0) {
                throw new NoSuchElementException();
            }
            O7.h hVar = this.f4076d;
            kotlin.jvm.internal.k.c(hVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f4076d = null;
            this.f4073a = -1;
            return hVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(String input, p pVar) {
        kotlin.jvm.internal.k.e(input, "input");
        this.f4071a = input;
        this.f4072b = pVar;
    }

    @Override // Q7.e
    public final Iterator<O7.h> iterator() {
        return new a();
    }
}

package R;

/* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0047c f3905a = new C0047c(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0047c f3906b = new C0047c(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0047c f3907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0047c f3908d;

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3909a = new a();
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f3910a;

        public b(a aVar) {
            this.f3910a = aVar;
        }

        public abstract boolean a();

        /* JADX WARN: Code duplicated, block: B:21:0x0034  */
        public final boolean b(CharSequence charSequence, int i9) {
            if (charSequence == null || i9 < 0 || charSequence.length() - i9 < 0) {
                throw new IllegalArgumentException();
            }
            if (this.f3910a == null) {
                return a();
            }
            char c5 = 0;
            c5 = 2;
            for (int i10 = 0; i10 < i9 && c5 == 2; i10++) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i10));
                C0047c c0047c = c.f3905a;
                if (directionality == 0) {
                    c5 = 1;
                    continue;
                } else if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            c5 = 1;
                            continue;
                        case 16:
                        case 17:
                            break;
                        default:
                            c5 = 2;
                            continue;
                    }
                }
            }
            if (c5 == 0) {
                return true;
            }
            if (c5 != 1) {
                return a();
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: R.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    public static class C0047c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3911b;

        public C0047c(a aVar, boolean z8) {
            super(aVar);
            this.f3911b = z8;
        }

        @Override // R.c.b
        public final boolean a() {
            return this.f3911b;
        }
    }

    static {
        a aVar = a.f3909a;
        f3907c = new C0047c(aVar, false);
        f3908d = new C0047c(aVar, true);
    }
}

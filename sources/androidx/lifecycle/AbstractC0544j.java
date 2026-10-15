package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0544j {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: androidx.lifecycle.j$a */
    /* JADX INFO: compiled from: Lifecycle.kt */
    public static final class a {
        private static final /* synthetic */ a[] $VALUES;
        public static final C0108a Companion;
        public static final a ON_ANY;
        public static final a ON_CREATE;
        public static final a ON_DESTROY;
        public static final a ON_PAUSE;
        public static final a ON_RESUME;
        public static final a ON_START;
        public static final a ON_STOP;

        /* JADX INFO: renamed from: androidx.lifecycle.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Lifecycle.kt */
        public static final class C0108a {
        }

        /* JADX INFO: renamed from: androidx.lifecycle.j$a$b */
        /* JADX INFO: compiled from: Lifecycle.kt */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f7733a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f7733a = iArr;
            }
        }

        static {
            a aVar = new a("ON_CREATE", 0);
            ON_CREATE = aVar;
            a aVar2 = new a("ON_START", 1);
            ON_START = aVar2;
            a aVar3 = new a("ON_RESUME", 2);
            ON_RESUME = aVar3;
            a aVar4 = new a("ON_PAUSE", 3);
            ON_PAUSE = aVar4;
            a aVar5 = new a("ON_STOP", 4);
            ON_STOP = aVar5;
            a aVar6 = new a("ON_DESTROY", 5);
            ON_DESTROY = aVar6;
            a aVar7 = new a("ON_ANY", 6);
            ON_ANY = aVar7;
            $VALUES = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7};
            Companion = new C0108a();
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) $VALUES.clone();
        }

        public final b a() {
            switch (b.f7733a[ordinal()]) {
                case 1:
                case 2:
                    return b.f7736c;
                case 3:
                case 4:
                    return b.f7737d;
                case 5:
                    return b.f7738e;
                case 6:
                    return b.f7734a;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: androidx.lifecycle.j$b */
    /* JADX INFO: compiled from: Lifecycle.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f7735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f7736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f7737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f7738e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ b[] f7739f;

        static {
            b bVar = new b("DESTROYED", 0);
            f7734a = bVar;
            b bVar2 = new b("INITIALIZED", 1);
            f7735b = bVar2;
            b bVar3 = new b("CREATED", 2);
            f7736c = bVar3;
            b bVar4 = new b("STARTED", 3);
            f7737d = bVar4;
            b bVar5 = new b("RESUMED", 4);
            f7738e = bVar5;
            f7739f = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
        }

        public b() {
            throw null;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f7739f.clone();
        }
    }

    public abstract void a(InterfaceC0547m interfaceC0547m);

    public abstract b b();

    public abstract void c(InterfaceC0547m interfaceC0547m);
}

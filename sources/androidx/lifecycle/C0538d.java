package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultLifecycleObserverAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0538d implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultLifecycleObserver f7728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0546l f7729b;

    /* JADX INFO: renamed from: androidx.lifecycle.d$a */
    /* JADX INFO: compiled from: DefaultLifecycleObserverAdapter.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7730a;

        static {
            int[] iArr = new int[AbstractC0544j.a.values().length];
            try {
                iArr[AbstractC0544j.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0544j.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0544j.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0544j.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0544j.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0544j.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0544j.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f7730a = iArr;
        }
    }

    public C0538d(DefaultLifecycleObserver defaultLifecycleObserver, InterfaceC0546l interfaceC0546l) {
        kotlin.jvm.internal.k.e(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f7728a = defaultLifecycleObserver;
        this.f7729b = interfaceC0546l;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        int i9 = a.f7730a[aVar.ordinal()];
        DefaultLifecycleObserver defaultLifecycleObserver = this.f7728a;
        switch (i9) {
            case 1:
                defaultLifecycleObserver.c(interfaceC0548n);
                break;
            case 2:
                defaultLifecycleObserver.f(interfaceC0548n);
                break;
            case 3:
                defaultLifecycleObserver.a(interfaceC0548n);
                break;
            case 4:
                defaultLifecycleObserver.e(interfaceC0548n);
                break;
            case 5:
                defaultLifecycleObserver.g(interfaceC0548n);
                break;
            case 6:
                defaultLifecycleObserver.b(interfaceC0548n);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0546l interfaceC0546l = this.f7729b;
        if (interfaceC0546l != null) {
            interfaceC0546l.d(interfaceC0548n, aVar);
        }
    }
}

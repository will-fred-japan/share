package Q5;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: compiled from: TinkFipsUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f3864a = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f3865b = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: Q5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TinkFipsUtil.java */
    public static abstract class EnumC0044a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0045a f3866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f3867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumC0044a[] f3868c;

        /* JADX INFO: renamed from: Q5.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TinkFipsUtil.java */
        public final enum C0045a extends EnumC0044a {
            public C0045a() {
                super("ALGORITHM_NOT_FIPS", 0);
            }

            @Override // Q5.a.EnumC0044a
            public final boolean a() {
                return !a.a();
            }
        }

        /* JADX INFO: renamed from: Q5.a$a$b */
        /* JADX INFO: compiled from: TinkFipsUtil.java */
        public final enum b extends EnumC0044a {
            public b() {
                super("ALGORITHM_REQUIRES_BORINGCRYPTO", 1);
            }

            @Override // Q5.a.EnumC0044a
            public final boolean a() {
                Boolean bool;
                if (a.a()) {
                    try {
                        bool = (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]);
                    } catch (Exception unused) {
                        a.f3864a.info("Conscrypt is not available or does not support checking for FIPS build.");
                        bool = Boolean.FALSE;
                    }
                    if (!bool.booleanValue()) {
                        return false;
                    }
                }
                return true;
            }
        }

        static {
            C0045a c0045a = new C0045a();
            f3866a = c0045a;
            b bVar = new b();
            f3867b = bVar;
            f3868c = new EnumC0044a[]{c0045a, bVar};
        }

        public EnumC0044a() {
            throw null;
        }

        public static EnumC0044a valueOf(String str) {
            return (EnumC0044a) Enum.valueOf(EnumC0044a.class, str);
        }

        public static EnumC0044a[] values() {
            return (EnumC0044a[]) f3868c.clone();
        }

        public abstract boolean a();
    }

    public static boolean a() {
        return f3865b.get();
    }
}

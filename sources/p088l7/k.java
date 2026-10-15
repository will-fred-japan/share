package p088l7;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PlatformViewCreationRequest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f20151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f20152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f20153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f20154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f20155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f20156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ByteBuffer f20157i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: PlatformViewCreationRequest.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f20159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f20160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a[] f20161d;

        static {
            a aVar = new a("TEXTURE_WITH_VIRTUAL_FALLBACK", 0);
            f20158a = aVar;
            a aVar2 = new a("TEXTURE_WITH_HYBRID_FALLBACK", 1);
            f20159b = aVar2;
            a aVar3 = new a("HYBRID_ONLY", 2);
            f20160c = aVar3;
            f20161d = new a[]{aVar, aVar2, aVar3};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f20161d.clone();
        }
    }

    public k(int i9, String str, double d9, double d10, double d11, double d12, int i10, a aVar, ByteBuffer byteBuffer) {
        this.f20149a = i9;
        this.f20150b = str;
        this.f20153e = d9;
        this.f20154f = d10;
        this.f20151c = d11;
        this.f20152d = d12;
        this.f20155g = i10;
        this.f20156h = aVar;
        this.f20157i = byteBuffer;
    }
}

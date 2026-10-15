package p197z;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Arrays;

/* JADX INFO: compiled from: SolverVariable.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22447a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f22451e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f22455i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22448b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22449c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22450d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22452f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f22453g = new float[9];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f22454h = new float[9];
    public b[] j = new b[16];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22456k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22457l = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SolverVariable.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f22459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f22460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f22461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f22462e;

        static {
            a aVar = new a("UNRESTRICTED", 0);
            f22458a = aVar;
            a aVar2 = new a("CONSTANT", 1);
            a aVar3 = new a("SLACK", 2);
            f22459b = aVar3;
            a aVar4 = new a("ERROR", 3);
            f22460c = aVar4;
            a aVar5 = new a(GrsBaseInfo.CountryCodeSource.UNKNOWN, 4);
            f22461d = aVar5;
            f22462e = new a[]{aVar, aVar2, aVar3, aVar4, aVar5};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f22462e.clone();
        }
    }

    public e(a aVar) {
        this.f22455i = aVar;
    }

    public final void a(b bVar) {
        int i9 = 0;
        while (true) {
            int i10 = this.f22456k;
            if (i9 >= i10) {
                b[] bVarArr = this.j;
                if (i10 >= bVarArr.length) {
                    this.j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.j;
                int i11 = this.f22456k;
                bVarArr2[i11] = bVar;
                this.f22456k = i11 + 1;
                return;
            }
            if (this.j[i9] == bVar) {
                return;
            } else {
                i9++;
            }
        }
    }

    public final void b(b bVar) {
        int i9 = this.f22456k;
        int i10 = 0;
        while (i10 < i9) {
            if (this.j[i10] == bVar) {
                while (i10 < i9 - 1) {
                    b[] bVarArr = this.j;
                    int i11 = i10 + 1;
                    bVarArr[i10] = bVarArr[i11];
                    i10 = i11;
                }
                this.f22456k--;
                return;
            }
            i10++;
        }
    }

    public final void c() {
        this.f22455i = a.f22461d;
        this.f22450d = 0;
        this.f22448b = -1;
        this.f22449c = -1;
        this.f22451e = 0.0f;
        this.f22452f = false;
        int i9 = this.f22456k;
        for (int i10 = 0; i10 < i9; i10++) {
            this.j[i10] = null;
        }
        this.f22456k = 0;
        this.f22457l = 0;
        this.f22447a = false;
        Arrays.fill(this.f22454h, 0.0f);
    }

    public final void d(c cVar, float f6) {
        this.f22451e = f6;
        this.f22452f = true;
        int i9 = this.f22456k;
        this.f22449c = -1;
        for (int i10 = 0; i10 < i9; i10++) {
            this.j[i10].h(cVar, this, false);
        }
        this.f22456k = 0;
    }

    public final void e(c cVar, b bVar) {
        int i9 = this.f22456k;
        for (int i10 = 0; i10 < i9; i10++) {
            this.j[i10].i(cVar, bVar, false);
        }
        this.f22456k = 0;
    }

    public final String toString() {
        return "" + this.f22448b;
    }
}

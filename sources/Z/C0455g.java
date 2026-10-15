package Z;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: Z.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DataMigrationInitializer.kt */
/* JADX INFO: loaded from: classes.dex */
@D7.e(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
public final class C0455g extends D7.i implements K7.p<Object, B7.e<Object>, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Iterator f5382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0452d f5383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ List<InterfaceC0452d<Object>> f5387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ArrayList f5388h;

    /* JADX INFO: renamed from: Z.g$a */
    /* JADX INFO: compiled from: DataMigrationInitializer.kt */
    @D7.e(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
    public static final class a extends D7.i implements K7.l<B7.e<? super p188x7.k>, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0452d<Object> f5390c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0452d<Object> interfaceC0452d, B7.e<? super a> eVar) {
            super(1, eVar);
            this.f5390c = interfaceC0452d;
        }

        @Override // D7.a
        public final B7.e<p188x7.k> create(B7.e<?> eVar) {
            return new a(this.f5390c, eVar);
        }

        @Override // K7.l
        public final Object invoke(B7.e<? super p188x7.k> eVar) {
            return ((a) create(eVar)).invokeSuspend(p188x7.k.f22364a);
        }

        @Override // D7.a
        public final Object invokeSuspend(Object obj) {
            C7.a aVar = C7.a.f1806a;
            int i9 = this.f5389b;
            if (i9 == 0) {
                p188x7.g.b(obj);
                this.f5389b = 1;
                if (this.f5390c.a() == aVar) {
                    return aVar;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p188x7.g.b(obj);
            }
            return p188x7.k.f22364a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0455g(List list, ArrayList arrayList, B7.e eVar) {
        super(2, eVar);
        this.f5387g = list;
        this.f5388h = arrayList;
    }

    @Override // D7.a
    public final B7.e<p188x7.k> create(Object obj, B7.e<?> eVar) {
        C0455g c0455g = new C0455g(this.f5387g, this.f5388h, eVar);
        c0455g.f5386f = obj;
        return c0455g;
    }

    @Override // K7.p
    public final Object invoke(Object obj, B7.e<Object> eVar) {
        return ((C0455g) create(obj, eVar)).invokeSuspend(p188x7.k.f22364a);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0048  */
    /* JADX WARN: Code duplicated, block: B:16:0x0062  */
    /* JADX WARN: Code duplicated, block: B:19:0x006f  */
    /* JADX WARN: Code duplicated, block: B:22:0x008c  */
    /* JADX WARN: Code duplicated, block: B:23:0x008e  */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @Override // D7.a
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            C7.a r0 = C7.a.f1806a
            int r1 = r8.f5385e
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L33
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            java.util.Iterator r1 = r8.f5382b
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r8.f5386f
            java.util.List r4 = (java.util.List) r4
            p188x7.g.b(r9)
            goto L42
        L18:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L20:
            java.lang.Object r1 = r8.f5384d
            Z.d r4 = r8.f5383c
            java.util.Iterator r5 = r8.f5382b
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r8.f5386f
            java.util.List r6 = (java.util.List) r6
            p188x7.g.b(r9)
            r7 = r6
            r6 = r4
            r4 = r7
            goto L67
        L33:
            p188x7.g.b(r9)
            java.lang.Object r9 = r8.f5386f
            java.util.List<Z.d<java.lang.Object>> r1 = r8.f5387g
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            java.util.ArrayList r4 = r8.f5388h
        L42:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L90
            java.lang.Object r5 = r1.next()
            Z.d r5 = (Z.InterfaceC0452d) r5
            r8.f5386f = r4
            r6 = r1
            java.util.Iterator r6 = (java.util.Iterator) r6
            r8.f5382b = r6
            r8.f5383c = r5
            r8.f5384d = r9
            r8.f5385e = r3
            java.lang.Object r6 = r5.b()
            if (r6 != r0) goto L62
            goto L8b
        L62:
            r7 = r1
            r1 = r9
            r9 = r6
            r6 = r5
            r5 = r7
        L67:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L8e
            Z.g$a r9 = new Z.g$a
            r1 = 0
            r9.<init>(r6, r1)
            r4.add(r9)
            r8.f5386f = r4
            r9 = r5
            java.util.Iterator r9 = (java.util.Iterator) r9
            r8.f5382b = r9
            r8.f5383c = r1
            r8.f5384d = r1
            r8.f5385e = r2
            java.lang.Object r9 = r6.c()
            if (r9 != r0) goto L8c
        L8b:
            return r0
        L8c:
            r1 = r5
            goto L42
        L8e:
            r9 = r1
            goto L8c
        L90:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: Z.C0455g.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

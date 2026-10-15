package N6;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3279d;

    public /* synthetic */ D(int i9, Object obj, Object obj2, int i10) {
        this.f3276a = i10;
        this.f3278c = obj;
        this.f3277b = i9;
        this.f3279d = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3276a) {
            case 0:
                p188x7.e eVar = new p188x7.e("code", Integer.valueOf(this.f3277b));
                String str = (String) this.f3279d;
                if (str == null) {
                    str = "";
                }
                ((C0338i) this.f3278c).success(y7.u.D(eVar, new p188x7.e("message", str), new p188x7.e("featureList", y7.p.f22408a)));
                break;
            default:
                T t = ((p051h.a.C0205a) this.f3279d).f18994a;
                e.h.f fVar = (e.h.f) this.f3278c;
                String str2 = (String) fVar.f18729a.get(Integer.valueOf(this.f3277b));
                if (str2 != null) {
                    g.d.a aVar = (g.d.a) fVar.f18733e.get(str2);
                    if ((aVar != null ? aVar.f18736a : null) != null) {
                        p043g.a<O> aVar2 = aVar.f18736a;
                        if (fVar.f18732d.remove(str2)) {
                            aVar2.a(t);
                        }
                    } else {
                        fVar.f18735g.remove(str2);
                        fVar.f18734f.put(str2, t);
                    }
                    break;
                }
                break;
        }
    }
}

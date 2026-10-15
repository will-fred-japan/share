package p007b0;

import androidx.datastore.preferences.protobuf.AbstractC0513g;
import androidx.datastore.preferences.protobuf.AbstractC0528w;
import androidx.datastore.preferences.protobuf.C0530y;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.Z;
import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.d0;
import androidx.datastore.preferences.protobuf.e0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: PreferencesProto.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends AbstractC0528w<e, a> implements S {
    private static final e DEFAULT_INSTANCE;
    private static volatile Z<e> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private C0530y.c<String> strings_ = d0.f7211d;

    /* JADX INFO: compiled from: PreferencesProto.java */
    public static final class a extends AbstractC0528w.a<e, a> implements S {
        public a() {
            super(e.DEFAULT_INSTANCE);
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        AbstractC0528w.p(e.class, eVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void r(e eVar, Iterable iterable) {
        C0530y.c<String> cVar = eVar.strings_;
        if (!cVar.e()) {
            int size = cVar.size();
            eVar.strings_ = cVar.c(size == 0 ? 10 : size * 2);
        }
        List list = eVar.strings_;
        Charset charset = C0530y.f7343a;
        iterable.getClass();
        if (!(iterable instanceof D)) {
            if (iterable instanceof a0) {
                list.addAll((Collection) iterable);
                return;
            }
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size2 = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size2) + " is null.";
                    for (int size3 = list.size() - 1; size3 >= size2; size3--) {
                        list.remove(size3);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
            return;
        }
        List<?> listJ = ((D) iterable).j();
        D d9 = (D) list;
        int size4 = list.size();
        for (Object obj2 : listJ) {
            if (obj2 == null) {
                String str2 = "Element at index " + (d9.size() - size4) + " is null.";
                for (int size5 = d9.size() - 1; size5 >= size4; size5--) {
                    d9.remove(size5);
                }
                throw new NullPointerException(str2);
            }
            if (obj2 instanceof AbstractC0513g) {
                d9.d();
            } else if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                AbstractC0513g.h(0, bArr.length, bArr);
                d9.d();
            } else {
                d9.add((String) obj2);
            }
        }
    }

    public static e s() {
        return DEFAULT_INSTANCE;
    }

    public static a u() {
        return (a) ((AbstractC0528w.a) DEFAULT_INSTANCE.i(AbstractC0528w.f.f7338e));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0528w
    public final Object i(AbstractC0528w.f fVar) {
        Z bVar;
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new e0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new e();
            case 4:
                return new a();
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Z<e> z8 = PARSER;
                if (z8 != null) {
                    return z8;
                }
                synchronized (e.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC0528w.b();
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return bVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final C0530y.c t() {
        return this.strings_;
    }
}

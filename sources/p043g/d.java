package p043g;

import Q7.j;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.InterfaceC0546l;
import defpackage.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ActivityResultRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f18729a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f18730b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f18731c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f18732d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient LinkedHashMap f18733e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f18734f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f18735g = new Bundle();

    /* JADX INFO: compiled from: ActivityResultRegistry.kt */
    public static final class a<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p043g.a<O> f18736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p051h.a<?, O> f18737b;

        public a(p051h.a aVar, p043g.a aVar2) {
            this.f18736a = aVar2;
            this.f18737b = aVar;
        }
    }

    /* JADX INFO: compiled from: ActivityResultRegistry.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0544j f18738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f18739b = new ArrayList();

        public b(AbstractC0544j abstractC0544j) {
            this.f18738a = abstractC0544j;
        }
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
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v3 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final boolean a(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            java.util.LinkedHashMap r0 = r3.f18729a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L10
            r4 = 0
            return r4
        L10:
            java.util.LinkedHashMap r0 = r3.f18733e
            java.lang.Object r0 = r0.get(r4)
            g.d$a r0 = (g.d.a) r0
            if (r0 == 0) goto L1d
            g.a<O> r1 = r0.f18736a
            goto L1e
        L1d:
            r1 = 0
        L1e:
            if (r1 == 0) goto L37
            java.util.ArrayList r1 = r3.f18732d
            boolean r2 = r1.contains(r4)
            if (r2 == 0) goto L37
            g.a<O> r2 = r0.f18736a
            h.a<?, O> r0 = r0.f18737b
            java.lang.Object r5 = r0.c(r5, r6)
            r2.a(r5)
            r1.remove(r4)
            goto L46
        L37:
            java.util.LinkedHashMap r0 = r3.f18734f
            r0.remove(r4)
            androidx.activity.result.ActivityResult r0 = new androidx.activity.result.ActivityResult
            r0.<init>(r5, r6)
            android.os.Bundle r5 = r3.f18735g
            r5.putParcelable(r4, r0)
        L46:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p043g.d.a(int, int, android.content.Intent):boolean");
    }

    public abstract void b(int i9, p051h.a aVar, Parcelable parcelable);

    public final f c(String key, p051h.a aVar, p043g.a aVar2) {
        k.e(key, "key");
        d(key);
        this.f18733e.put(key, new a(aVar, aVar2));
        LinkedHashMap linkedHashMap = this.f18734f;
        if (linkedHashMap.containsKey(key)) {
            Object obj = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            aVar2.a(obj);
        }
        Bundle bundle = this.f18735g;
        ActivityResult activityResult = (ActivityResult) P.b.a(bundle, key, ActivityResult.class);
        if (activityResult != null) {
            bundle.remove(key);
            aVar2.a(aVar.c(activityResult.f5799a, activityResult.f5800b));
        }
        return new f(this, key, aVar);
    }

    public final void d(String str) {
        LinkedHashMap linkedHashMap = this.f18730b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        G6.a aVar = new G6.a(1);
        for (Number number : new Q7.a(new Q7.d(aVar, new j(0, aVar)))) {
            int iIntValue = number.intValue();
            LinkedHashMap linkedHashMap2 = this.f18729a;
            if (!linkedHashMap2.containsKey(Integer.valueOf(iIntValue))) {
                int iIntValue2 = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue2), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue2));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void e(String key) {
        Integer num;
        k.e(key, "key");
        if (!this.f18732d.contains(key) && (num = (Integer) this.f18730b.remove(key)) != null) {
            this.f18729a.remove(num);
        }
        this.f18733e.remove(key);
        LinkedHashMap linkedHashMap = this.f18734f;
        if (linkedHashMap.containsKey(key)) {
            StringBuilder sbI = f.i("Dropping pending result for request ", key, ": ");
            sbI.append(linkedHashMap.get(key));
            Log.w("ActivityResultRegistry", sbI.toString());
            linkedHashMap.remove(key);
        }
        Bundle bundle = this.f18735g;
        if (bundle.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((ActivityResult) P.b.a(bundle, key, ActivityResult.class)));
            bundle.remove(key);
        }
        LinkedHashMap linkedHashMap2 = this.f18731c;
        b bVar = (b) linkedHashMap2.get(key);
        if (bVar != null) {
            ArrayList arrayList = bVar.f18739b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.f18738a.c((InterfaceC0546l) it.next());
            }
            arrayList.clear();
            linkedHashMap2.remove(key);
        }
    }
}

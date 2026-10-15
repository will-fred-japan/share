package D7;

import com.engagelab.privates.common.constants.MTCommonConstants;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p188x7.k;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements B7.e<Object>, d, Serializable {
    private final B7.e<Object> completion;

    public a(B7.e<Object> eVar) {
        this.completion = eVar;
    }

    public B7.e<k> create(B7.e<?> completion) {
        kotlin.jvm.internal.k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // D7.d
    public d getCallerFrame() {
        B7.e<Object> eVar = this.completion;
        if (eVar instanceof d) {
            return (d) eVar;
        }
        return null;
    }

    public final B7.e<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str = null;
        if (eVar == null) {
            return null;
        }
        int iV = eVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i9 = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
        f.a aVar = f.f1940b;
        f.a aVar2 = f.f1939a;
        if (aVar == null) {
            try {
                f.a aVar3 = new f.a(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(MTCommonConstants.Network.KEY_NAME, new Class[0]));
                f.f1940b = aVar3;
                aVar = aVar3;
            } catch (Exception unused2) {
                f.f1940b = aVar2;
                aVar = aVar2;
            }
        }
        if (aVar != aVar2 && (method = aVar.f1941a) != null && (objInvoke = method.invoke(getClass(), new Object[0])) != null && (method2 = aVar.f1942b) != null && (objInvoke2 = method2.invoke(objInvoke, new Object[0])) != null) {
            Method method3 = aVar.f1943c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = eVar.c();
        } else {
            strC = str + '/' + eVar.c();
        }
        return new StackTraceElement(strC, eVar.m(), eVar.f(), i9);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // B7.e
    public final void resumeWith(Object obj) {
        B7.e<Object> eVar = this;
        while (true) {
            a aVar = (a) eVar;
            B7.e<Object> eVar2 = aVar.completion;
            kotlin.jvm.internal.k.b(eVar2);
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == C7.a.f1806a) {
                    return;
                }
            } catch (Throwable th) {
                obj = p188x7.g.a(th);
            }
            aVar.releaseIntercepted();
            if (!(eVar2 instanceof a)) {
                eVar2.resumeWith(obj);
                return;
            }
            eVar = eVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public B7.e<k> create(Object obj, B7.e<?> completion) {
        kotlin.jvm.internal.k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}

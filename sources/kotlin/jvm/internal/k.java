package kotlin.jvm.internal;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: Intrinsics.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        g(nullPointerException, k.class.getName());
        throw nullPointerException;
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        g(nullPointerException, k.class.getName());
        throw nullPointerException;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:130)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        g(nullPointerException, k.class.getName());
        throw nullPointerException;
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = k.class.getName();
            int i9 = 0;
            while (!stackTrace[i9].getClassName().equals(name)) {
                i9++;
            }
            while (stackTrace[i9].getClassName().equals(name)) {
                i9++;
            }
            StackTraceElement stackTraceElement = stackTrace[i9];
            StringBuilder sbJ = A.f.j("Parameter specified as non-null is null: method ", stackTraceElement.getClassName(), ".", stackTraceElement.getMethodName(), ", parameter ");
            sbJ.append(str);
            NullPointerException nullPointerException = new NullPointerException(sbJ.toString());
            g(nullPointerException, k.class.getName());
            throw nullPointerException;
        }
    }

    public static int f(int i9, int i10) {
        if (i9 < i10) {
            return -1;
        }
        return i9 == i10 ? 0 : 1;
    }

    public static void g(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i9 = -1;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(stackTrace[i10].getClassName())) {
                i9 = i10;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i9 + 1, length));
    }

    public static String h(String str, Serializable serializable) {
        return str + serializable;
    }

    public static void i(String str) {
        p140s0.c cVar = new p140s0.c(A.a.i("lateinit property ", str, " has not been initialized"));
        g(cVar, k.class.getName());
        throw cVar;
    }
}

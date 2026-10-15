package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: kotlin.jvm.internal.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CallableReference.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0622b implements P7.b, Serializable {
    public static final Object NO_RECEIVER = a.f19998a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient P7.b reflected;
    private final String signature;

    /* JADX INFO: renamed from: kotlin.jvm.internal.b$a */
    /* JADX INFO: compiled from: CallableReference.java */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19998a = new a();
    }

    public AbstractC0622b() {
        this(NO_RECEIVER);
    }

    @Override // P7.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // P7.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public P7.b compute() {
        P7.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        P7.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract P7.b computeReflected();

    @Override // P7.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public P7.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return z.a(cls);
        }
        z.f20009a.getClass();
        return new p(cls);
    }

    @Override // P7.b
    public List<P7.h> getParameters() {
        return getReflected().getParameters();
    }

    public P7.b getReflected() {
        P7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new J7.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    @Override // P7.b
    public P7.l getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // P7.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // P7.b
    public P7.m getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // P7.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // P7.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // P7.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // P7.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public AbstractC0622b(Object obj) {
        this(obj, null, null, null, false);
    }

    public AbstractC0622b(Object obj, Class cls, String str, String str2, boolean z8) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z8;
    }
}

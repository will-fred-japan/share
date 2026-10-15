package kotlin.jvm.internal;

/* JADX INFO: compiled from: PropertyReference.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends AbstractC0622b implements P7.i {
    private final boolean syntheticJavaProperty;

    public u() {
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.AbstractC0622b
    public P7.b compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            return getOwner().equals(uVar.getOwner()) && getName().equals(uVar.getName()) && getSignature().equals(uVar.getSignature()) && k.a(getBoundReceiver(), uVar.getBoundReceiver());
        }
        if (obj instanceof P7.i) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // P7.i
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // P7.i
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        P7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.AbstractC0622b
    public P7.i getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (P7.i) super.getReflected();
    }

    public u(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    public u(Object obj, Class cls, String str, String str2, int i9) {
        super(obj, cls, str, str2, (i9 & 1) == 1);
        this.syntheticJavaProperty = (i9 & 2) == 2;
    }
}

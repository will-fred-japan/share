package com.google.gson.internal;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements ObjectConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14189b;

    public /* synthetic */ b(String str, int i9) {
        this.f14188a = i9;
        this.f14189b = str;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        switch (this.f14188a) {
            case 0:
                return ConstructorConstructor.lambda$newUnsafeAllocator$20(this.f14189b);
            case 1:
                return ConstructorConstructor.lambda$newDefaultConstructor$8(this.f14189b);
            default:
                return ConstructorConstructor.lambda$get$2(this.f14189b);
        }
    }
}

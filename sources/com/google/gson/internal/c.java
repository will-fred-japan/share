package com.google.gson.internal;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements ObjectConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14191b;

    public /* synthetic */ c(String str, int i9) {
        this.f14190a = i9;
        this.f14191b = str;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        switch (this.f14190a) {
            case 0:
                return ConstructorConstructor.lambda$newDefaultConstructor$7(this.f14191b);
            default:
                return ConstructorConstructor.lambda$get$4(this.f14191b);
        }
    }
}

package com.starburst.sdk.common.okhttp.callback;

import java.lang.reflect.ParameterizedType;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public abstract class GenericsCallback<T> extends Callback<T> {
    IGenericsSerializator mGenericsSerializator;

    public GenericsCallback(IGenericsSerializator iGenericsSerializator) {
        this.mGenericsSerializator = iGenericsSerializator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
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
    @Override // com.starburst.sdk.common.okhttp.callback.Callback
    public T parseNetworkResponse(Response response, int i9) {
        ?? r8 = (T) response.body().string();
        Class cls = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return cls == String.class ? r8 : (T) this.mGenericsSerializator.transform(r8, cls);
    }
}

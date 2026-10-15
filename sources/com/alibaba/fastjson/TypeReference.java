package com.alibaba.fastjson;

import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class TypeReference<T> {
    protected final Type type;
    static ConcurrentMap<Type, Type> classTypeCache = new ConcurrentHashMap(16, 0.75f, 1);
    public static final Type LIST_STRING = new TypeReference<List<String>>() { // from class: com.alibaba.fastjson.TypeReference.1
    }.getType();

    public TypeReference() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = classTypeCache.get(type);
        if (type2 == null) {
            classTypeCache.putIfAbsent(type, type);
            type2 = classTypeCache.get(type);
        }
        this.type = type2;
    }

    private Type handlerParameterizedType(ParameterizedType parameterizedType, Type[] typeArr, int i9) {
        Class<?> cls = getClass();
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            if ((actualTypeArguments[i10] instanceof TypeVariable) && i9 < typeArr.length) {
                actualTypeArguments[i10] = typeArr[i9];
                i9++;
            }
            Type type = actualTypeArguments[i10];
            if (type instanceof GenericArrayType) {
                actualTypeArguments[i10] = TypeUtils.checkPrimitiveArray((GenericArrayType) type);
            }
            Type type2 = actualTypeArguments[i10];
            if (type2 instanceof ParameterizedType) {
                actualTypeArguments[i10] = handlerParameterizedType((ParameterizedType) type2, typeArr, i9);
            }
        }
        return new ParameterizedTypeImpl(actualTypeArguments, cls, rawType);
    }

    public static Type intern(ParameterizedTypeImpl parameterizedTypeImpl) {
        Type type = classTypeCache.get(parameterizedTypeImpl);
        if (type != null) {
            return type;
        }
        classTypeCache.putIfAbsent(parameterizedTypeImpl, parameterizedTypeImpl);
        return classTypeCache.get(parameterizedTypeImpl);
    }

    public Type getType() {
        return this.type;
    }

    public TypeReference(Type... typeArr) {
        Class<?> cls = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int i9 = 0;
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            if ((actualTypeArguments[i10] instanceof TypeVariable) && i9 < typeArr.length) {
                actualTypeArguments[i10] = typeArr[i9];
                i9++;
            }
            Type type = actualTypeArguments[i10];
            if (type instanceof GenericArrayType) {
                actualTypeArguments[i10] = TypeUtils.checkPrimitiveArray((GenericArrayType) type);
            }
            Type type2 = actualTypeArguments[i10];
            if (type2 instanceof ParameterizedType) {
                actualTypeArguments[i10] = handlerParameterizedType((ParameterizedType) type2, typeArr, i9);
            }
        }
        ParameterizedTypeImpl parameterizedTypeImpl = new ParameterizedTypeImpl(actualTypeArguments, cls, rawType);
        Type type3 = classTypeCache.get(parameterizedTypeImpl);
        if (type3 == null) {
            classTypeCache.putIfAbsent(parameterizedTypeImpl, parameterizedTypeImpl);
            type3 = classTypeCache.get(parameterizedTypeImpl);
        }
        this.type = type3;
    }
}

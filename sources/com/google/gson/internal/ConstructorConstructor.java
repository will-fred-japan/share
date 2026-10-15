package com.google.gson.internal;

import W5.e;
import W5.f;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z8, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z8;
        this.reflectionFilters = list;
    }

    public static String checkInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + TroubleshootingGuide.createUrl("r8-abstract-class");
    }

    private static boolean hasStringKeyType(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return true;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        return actualTypeArguments.length != 0 && GsonTypes.getRawType(actualTypeArguments[0]) == String.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$get$2(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$get$3(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$get$4(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$10() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$11() {
        return new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$12() {
        return new TreeSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$newCollectionConstructor$13() {
        return new ArrayDeque();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$7(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$8(String str) {
        throw new JsonIOException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newDefaultConstructor$9(Constructor constructor) {
        try {
            return constructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e9) {
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e9);
        } catch (InstantiationException e10) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e11.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$14() {
        return new LinkedTreeMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$15() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$16() {
        return new TreeMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$17() {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$newMapConstructor$18() {
        return new ConcurrentSkipListMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newSpecialCollectionConstructor$5(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newSpecialCollectionConstructor$6(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new JsonIOException("Invalid EnumMap type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return new EnumMap((Class) type2);
        }
        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newUnsafeAllocator$19(Class cls) {
        try {
            return UnsafeAllocator.INSTANCE.newInstance(cls);
        } catch (Exception e9) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newUnsafeAllocator$20(String str) {
        throw new JsonIOException(str);
    }

    private static ObjectConstructor<? extends Collection<? extends Object>> newCollectionConstructor(Class<?> cls) {
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new f(13);
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new defpackage.f(11);
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new e(13);
        }
        if (cls.isAssignableFrom(ArrayDeque.class)) {
            return new f(14);
        }
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        String strTryMakeAccessible;
        if (!Modifier.isAbstract(cls.getModifiers())) {
            try {
                Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
                if (filterResult == filterResult2 || (ReflectionAccessFilterHelper.canAccess(declaredConstructor, null) && (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                    return (filterResult != filterResult2 || (strTryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) == null) ? new R3.a(5, declaredConstructor) : new b(strTryMakeAccessible, 1);
                }
                return new c("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.", 0);
            } catch (NoSuchMethodException unused) {
            }
        }
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return (ObjectConstructor<T>) newCollectionConstructor(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return (ObjectConstructor<T>) newMapConstructor(type, cls);
        }
        return null;
    }

    private static ObjectConstructor<? extends Map<? extends Object, Object>> newMapConstructor(Type type, Class<?> cls) {
        if (cls.isAssignableFrom(LinkedTreeMap.class) && hasStringKeyType(type)) {
            return new f(11);
        }
        if (cls.isAssignableFrom(LinkedHashMap.class)) {
            return new defpackage.f(9);
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new e(12);
        }
        if (cls.isAssignableFrom(ConcurrentHashMap.class)) {
            return new f(12);
        }
        if (cls.isAssignableFrom(ConcurrentSkipListMap.class)) {
            return new defpackage.f(10);
        }
        return null;
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new R3.e(6, type);
        }
        if (cls == EnumMap.class) {
            return new R3.a(4, type);
        }
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new R3.e(8, cls);
        }
        String strU = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            strU = e.u(strU, " Or adjust your R8 configuration to keep the no-args constructor of the class.");
        }
        return new b(strU, 0);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        return get(typeToken, true);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken, boolean z8) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new a(instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new d(0, instanceCreator2, type);
        }
        ObjectConstructor<T> objectConstructorNewSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (objectConstructorNewSpecialCollectionConstructor != null) {
            return objectConstructorNewSpecialCollectionConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        ObjectConstructor<T> objectConstructorNewDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (objectConstructorNewDefaultConstructor != null) {
            return objectConstructorNewDefaultConstructor;
        }
        ObjectConstructor<T> objectConstructorNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (objectConstructorNewDefaultImplementationConstructor != null) {
            return objectConstructorNewDefaultImplementationConstructor;
        }
        String strCheckInstantiable = checkInstantiable(rawType);
        if (strCheckInstantiable != null) {
            return new b(strCheckInstantiable, 2);
        }
        if (!z8) {
            return new R3.e(7, "Unable to create instance of " + rawType + "; Register an InstanceCreator or a TypeAdapter for this type.");
        }
        if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        return new c("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.", 1);
    }
}

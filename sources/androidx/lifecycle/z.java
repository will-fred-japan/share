package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SavedStateHandle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class<? extends Object>[] f7782f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f7783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f7784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f7785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f7786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p131r0.b.InterfaceC0248b f7787e;

    /* JADX INFO: compiled from: SavedStateHandle.kt */
    public static final class a {
        public static z a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new z();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.k.d(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new z(map);
            }
            ClassLoader classLoader = z.class.getClassLoader();
            kotlin.jvm.internal.k.b(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                Object obj = parcelableArrayList.get(i9);
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i9));
            }
            return new z(linkedHashMap);
        }
    }

    public z(HashMap map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f7783a = linkedHashMap;
        this.f7784b = new LinkedHashMap();
        this.f7785c = new LinkedHashMap();
        this.f7786d = new LinkedHashMap();
        this.f7787e = new p131r0.b.InterfaceC0248b() { // from class: androidx.lifecycle.y
            @Override // p131r0.b.InterfaceC0248b
            public final Bundle a() {
                return z.a(this.f7781a);
            }
        };
        linkedHashMap.putAll(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bundle a(z this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        Iterator it = y7.u.I(this$0.f7784b).entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap = this$0.f7783a;
            int i9 = 0;
            if (!zHasNext) {
                Set<String> setKeySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : setKeySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                p188x7.e[] eVarArr = {new p188x7.e("keys", arrayList), new p188x7.e("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                while (i9 < 2) {
                    p188x7.e eVar = eVarArr[i9];
                    String str2 = (String) eVar.f22353a;
                    B b9 = eVar.f22354b;
                    if (b9 == 0) {
                        bundle.putString(str2, null);
                    } else if (b9 instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) b9).booleanValue());
                    } else if (b9 instanceof Byte) {
                        bundle.putByte(str2, ((Number) b9).byteValue());
                    } else if (b9 instanceof Character) {
                        bundle.putChar(str2, ((Character) b9).charValue());
                    } else if (b9 instanceof Double) {
                        bundle.putDouble(str2, ((Number) b9).doubleValue());
                    } else if (b9 instanceof Float) {
                        bundle.putFloat(str2, ((Number) b9).floatValue());
                    } else if (b9 instanceof Integer) {
                        bundle.putInt(str2, ((Number) b9).intValue());
                    } else if (b9 instanceof Long) {
                        bundle.putLong(str2, ((Number) b9).longValue());
                    } else if (b9 instanceof Short) {
                        bundle.putShort(str2, ((Number) b9).shortValue());
                    } else if (b9 instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) b9);
                    } else if (b9 instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) b9);
                    } else if (b9 instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) b9);
                    } else if (b9 instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) b9);
                    } else if (b9 instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) b9);
                    } else if (b9 instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) b9);
                    } else if (b9 instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) b9);
                    } else if (b9 instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) b9);
                    } else if (b9 instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) b9);
                    } else if (b9 instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) b9);
                    } else if (b9 instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) b9);
                    } else if (b9 instanceof Object[]) {
                        Class<?> componentType = b9.getClass().getComponentType();
                        kotlin.jvm.internal.k.b(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) b9);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) b9);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) b9);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                            }
                            bundle.putSerializable(str2, (Serializable) b9);
                        }
                    } else if (b9 instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) b9);
                    } else if (b9 instanceof IBinder) {
                        bundle.putBinder(str2, (IBinder) b9);
                    } else if (b9 instanceof Size) {
                        bundle.putSize(str2, (Size) b9);
                    } else {
                        if (!(b9 instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + b9.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                        bundle.putSizeF(str2, (SizeF) b9);
                    }
                    i9++;
                }
                return bundle;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Bundle bundleA = ((p131r0.b.InterfaceC0248b) entry.getValue()).a();
            kotlin.jvm.internal.k.e(key, "key");
            if (bundleA != null) {
                Class<? extends Object>[] clsArr = f7782f;
                while (true) {
                    if (i9 >= 29) {
                        throw new IllegalArgumentException("Can't put value with type " + bundleA.getClass() + " into saved state");
                    }
                    Class<? extends Object> cls = clsArr[i9];
                    kotlin.jvm.internal.k.b(cls);
                    if (cls.isInstance(bundleA)) {
                        break;
                    }
                    i9++;
                }
            }
            Object obj = this$0.f7785c.get(key);
            s sVar = obj instanceof s ? (s) obj : null;
            if (sVar != null) {
                sVar.d(bundleA);
            } else {
                linkedHashMap.put(key, bundleA);
            }
            V7.o oVar = (V7.o) this$0.f7786d.get(key);
            if (oVar != null) {
                oVar.setValue(bundleA);
            }
        }
    }

    public z() {
        this.f7783a = new LinkedHashMap();
        this.f7784b = new LinkedHashMap();
        this.f7785c = new LinkedHashMap();
        this.f7786d = new LinkedHashMap();
        this.f7787e = new p131r0.b.InterfaceC0248b() { // from class: androidx.lifecycle.y
            @Override // p131r0.b.InterfaceC0248b
            public final Bundle a() {
                return z.a(this.f7781a);
            }
        };
    }
}

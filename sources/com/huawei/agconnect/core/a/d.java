package com.huawei.agconnect.core.a;

import W5.f;
import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Class<?>, Service> f14644a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Class<?>, Object> f14645b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Class<?>, Service> f14646c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<Class<?>, Object> f14647d = new HashMap();

    public d(List<Service> list, Context context) {
        a(list, context);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor constructorA = a(type, Context.class, AGConnectInstance.class);
            if (constructorA != null) {
                return constructorA.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor constructorA2 = a(type, Context.class);
            return constructorA2 != null ? constructorA2.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (IllegalAccessException e9) {
            e = e9;
            sb = new StringBuilder("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb.toString());
            return null;
        } catch (InstantiationException e10) {
            e = e10;
            sb = new StringBuilder("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb.toString());
            return null;
        } catch (InvocationTargetException e11) {
            e = e11;
            sb = new StringBuilder("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb.toString());
            return null;
        }
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service = this.f14646c.get(cls);
        if (service == null && (service = f14644a.get(cls)) != null) {
            return (T) f14645b.get(cls);
        }
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t = (T) this.f14647d.get(cls)) != null) {
            return t;
        }
        T t6 = (T) a(aGConnectInstance, service);
        if (t6 != null && service.isSingleton()) {
            this.f14647d.put(cls, t6);
        }
        return t6;
    }

    private static Constructor a(Class cls, Class... clsArr) {
        boolean z8 = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i9 = 0; i9 < clsArr.length; i9++) {
                    z8 = parameterTypes[i9] == clsArr[i9];
                }
                if (z8) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private void a(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        f.n(new StringBuilder("cause message:"), exc.getCause() != null ? exc.getCause().getMessage() : "", "AGC_ServiceRepository");
    }

    public void a(List<Service> list, Context context) {
        Map<Class<?>, Service> map;
        String str;
        Log.d("AGC_ServiceRepository", "addService start");
        if (list == null) {
            return;
        }
        for (Service service : list) {
            if (service.isSharedInstance()) {
                if (!f14644a.containsKey(service.getInterface())) {
                    map = f14644a;
                }
                if (!service.isAutoCreated() && service.getType() != null && !f14645b.containsKey(service.getInterface())) {
                    try {
                        Constructor constructorA = a(service.getType(), Context.class);
                        f14645b.put(service.getInterface(), constructorA != null ? constructorA.newInstance(context) : service.getType().newInstance());
                    } catch (IllegalAccessException e9) {
                        e = e9;
                        str = "AccessException";
                        a(str, e);
                    } catch (InstantiationException e10) {
                        e = e10;
                        str = "InstantiationException";
                        a(str, e);
                    } catch (InvocationTargetException e11) {
                        e = e11;
                        str = "TargetException";
                        a(str, e);
                    }
                }
            } else {
                map = this.f14646c;
            }
            map.put(service.getInterface(), service);
            if (!service.isAutoCreated()) {
            }
        }
        Log.d("AGC_ServiceRepository", "addService end");
    }
}

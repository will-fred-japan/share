package com.starburst.sdk.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.starburst.sdk.utils.j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceIdentifierResolver {
    private static final IdentifierProvider EMPTY_PROVIDER = new a();
    public static final String PROVIDER_METADATA_KEY = "com.starburst.sdk.DEVICE_IDENTIFIER_PROVIDER";
    private static final String PROVIDER_METHOD_NAME = "getDeviceIdentifier";
    private static final String TAG = "DeviceIdentifierResolver";
    private static volatile IdentifierProvider provider;

    public interface IdentifierProvider {
        String getDeviceIdentifier(Context context);
    }

    private DeviceIdentifierResolver() {
    }

    public static String getDeviceIdentifier(Context context) {
        try {
            String deviceIdentifier = getProvider(context).getDeviceIdentifier(context);
            if (TextUtils.isEmpty(deviceIdentifier)) {
                return null;
            }
            return deviceIdentifier;
        } catch (LinkageError | RuntimeException e9) {
            j.y(TAG, "Device identifier provider failed", e9);
            return null;
        }
    }

    private static IdentifierProvider getProvider(Context context) {
        IdentifierProvider identifierProvider;
        if (context == null) {
            return EMPTY_PROVIDER;
        }
        IdentifierProvider identifierProvider2 = provider;
        if (identifierProvider2 != null) {
            return identifierProvider2;
        }
        synchronized (DeviceIdentifierResolver.class) {
            try {
                if (provider == null) {
                    provider = loadProvider(context);
                }
                identifierProvider = provider;
            } catch (Throwable th) {
                throw th;
            }
        }
        return identifierProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String invokeProvider(Object obj, Method method, Context context) {
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (IllegalAccessException | LinkageError | RuntimeException | InvocationTargetException e9) {
            j.y(TAG, "Device identifier provider invocation failed", e9);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0(Context context) {
        return null;
    }

    private static IdentifierProvider loadProvider(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            String string = bundle == null ? null : bundle.getString(PROVIDER_METADATA_KEY);
            if (!TextUtils.isEmpty(string)) {
                Class<?> cls = Class.forName(string);
                final Method method = cls.getMethod(PROVIDER_METHOD_NAME, Context.class);
                if (method.getReturnType() == String.class) {
                    final Object objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    return new IdentifierProvider() { // from class: com.starburst.sdk.common.utils.b
                        @Override // com.starburst.sdk.common.utils.DeviceIdentifierResolver.IdentifierProvider
                        public final String getDeviceIdentifier(Context context2) {
                            return DeviceIdentifierResolver.invokeProvider(objNewInstance, method, context2);
                        }
                    };
                }
                j.x(TAG, "Configured device identifier provider has an invalid return type");
            }
            return EMPTY_PROVIDER;
        } catch (PackageManager.NameNotFoundException e9) {
            e = e9;
            j.y(TAG, "Device identifier provider is unavailable", e);
            return EMPTY_PROVIDER;
        } catch (LinkageError e10) {
            e = e10;
            j.y(TAG, "Device identifier provider is unavailable", e);
            return EMPTY_PROVIDER;
        } catch (ReflectiveOperationException e11) {
            e = e11;
            j.y(TAG, "Device identifier provider is unavailable", e);
            return EMPTY_PROVIDER;
        } catch (RuntimeException e12) {
            e = e12;
            j.y(TAG, "Device identifier provider is unavailable", e);
            return EMPTY_PROVIDER;
        }
    }
}

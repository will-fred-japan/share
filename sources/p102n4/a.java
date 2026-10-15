package p102n4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f20580a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<String, byte[]> f20581b = new LinkedHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0236a f20582c = new C0236a();

    /* JADX INFO: renamed from: n4.a$a, reason: collision with other inner class name */
    public static class C0236a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
            byte[] bArrMarshall;
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeBundle(bundle);
                bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
            } catch (Throwable unused) {
                parcelObtain.recycle();
                bArrMarshall = null;
            }
            if (bArrMarshall == null) {
                bundle.clear();
                return;
            }
            if (bArrMarshall.length > 1024) {
                String string = UUID.randomUUID().toString();
                LinkedHashMap<String, byte[]> linkedHashMap = a.f20581b;
                try {
                    linkedHashMap.put(string, bArrMarshall);
                    if (linkedHashMap.size() > 64) {
                        Set<Map.Entry<String, byte[]>> setEntrySet = linkedHashMap.entrySet();
                        ArrayList arrayList = new ArrayList();
                        Iterator<Map.Entry<String, byte[]>> it = setEntrySet.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getKey());
                            if (arrayList.size() >= 12) {
                                break;
                            }
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            linkedHashMap.remove((String) it2.next());
                        }
                    }
                    bundle.clear();
                    bundle.putString("APMPLUS_TTL_ActivityRecordKey", string);
                } catch (Throwable unused2) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreCreated(Activity activity, Bundle bundle) {
            if (bundle == null) {
                return;
            }
            Object obj = bundle.get("APMPLUS_TTL_ActivityRecordKey");
            if (obj instanceof String) {
                try {
                    bundle.clear();
                    byte[] bArr = a.f20581b.get(obj);
                    if (bArr == null) {
                        return;
                    }
                    ClassLoader classLoader = activity.getClassLoader();
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.unmarshall(bArr, 0, bArr.length);
                        parcelObtain.setDataPosition(0);
                        Bundle bundle2 = parcelObtain.readBundle(classLoader);
                        parcelObtain.recycle();
                        if (bundle2 != null) {
                            bundle.putAll(bundle2);
                        }
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}

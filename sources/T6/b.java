package T6;

import R7.i;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import p096m7.j;
import p096m7.l;
import y7.h;

/* JADX INFO: compiled from: MethodCallHandlerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements l.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackageManager f4567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityManager f4568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContentResolver f4569c;

    public b(PackageManager packageManager, ActivityManager activityManager, ContentResolver contentResolver) {
        this.f4567a = packageManager;
        this.f4568b = activityManager;
        this.f4569c = contentResolver;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:37:0x014b  */
    @Override // m7.l.c
    public final void onMethodCall(j call, l.d dVar) {
        boolean z8;
        k.e(call, "call");
        if (!call.f20496a.equals("getDeviceInfo")) {
            ((p096m7.k) dVar).notImplemented();
            return;
        }
        HashMap map = new HashMap();
        map.put("board", Build.BOARD);
        map.put("bootloader", Build.BOOTLOADER);
        String BRAND = Build.BRAND;
        map.put(Constants.PHONE_BRAND, BRAND);
        String DEVICE = Build.DEVICE;
        map.put("device", DEVICE);
        map.put("display", Build.DISPLAY);
        String FINGERPRINT = Build.FINGERPRINT;
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, FINGERPRINT);
        String HARDWARE = Build.HARDWARE;
        map.put("hardware", HARDWARE);
        map.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, Build.HOST);
        map.put("id", Build.ID);
        String MANUFACTURER = Build.MANUFACTURER;
        map.put("manufacturer", MANUFACTURER);
        String MODEL = Build.MODEL;
        map.put("model", MODEL);
        String PRODUCT = Build.PRODUCT;
        map.put("product", PRODUCT);
        String string = Settings.Global.getString(this.f4569c, "device_name");
        if (string == null) {
            string = "";
        }
        map.put(MTCommonConstants.Network.KEY_NAME, string);
        String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
        map.put("supported32BitAbis", h.C(Arrays.copyOf(strArr, strArr.length)));
        String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
        map.put("supported64BitAbis", h.C(Arrays.copyOf(strArr2, strArr2.length)));
        String[] strArr3 = Build.SUPPORTED_ABIS;
        map.put("supportedAbis", h.C(Arrays.copyOf(strArr3, strArr3.length)));
        map.put("tags", Build.TAGS);
        map.put("type", Build.TYPE);
        k.d(BRAND, "BRAND");
        String serial = "unknown";
        if (i.N(BRAND, "generic", false)) {
            k.d(DEVICE, "DEVICE");
            if (i.N(DEVICE, "generic", false)) {
                z8 = true;
            } else {
                k.d(FINGERPRINT, "FINGERPRINT");
                if (!i.N(FINGERPRINT, "generic", false) || i.N(FINGERPRINT, "unknown", false)) {
                    z8 = true;
                } else {
                    k.d(HARDWARE, "HARDWARE");
                    if (R7.l.O(HARDWARE, "goldfish", false) || R7.l.O(HARDWARE, "ranchu", false)) {
                        z8 = true;
                    } else {
                        k.d(MODEL, "MODEL");
                        if (R7.l.O(MODEL, "google_sdk", false) || R7.l.O(MODEL, "Emulator", false) || R7.l.O(MODEL, "Android SDK built for x86", false)) {
                            z8 = true;
                        } else {
                            k.d(MANUFACTURER, "MANUFACTURER");
                            if (R7.l.O(MANUFACTURER, "Genymotion", false)) {
                                z8 = true;
                            } else {
                                k.d(PRODUCT, "PRODUCT");
                                if (R7.l.O(PRODUCT, "sdk", false) || R7.l.O(PRODUCT, "vbox86p", false) || R7.l.O(PRODUCT, "emulator", false) || R7.l.O(PRODUCT, "simulator", false)) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            k.d(FINGERPRINT, "FINGERPRINT");
            if (i.N(FINGERPRINT, "generic", false)) {
                z8 = true;
            } else {
                z8 = true;
            }
        }
        map.put("isPhysicalDevice", Boolean.valueOf(!z8));
        FeatureInfo[] systemAvailableFeatures = this.f4567a.getSystemAvailableFeatures();
        k.d(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
        ArrayList arrayList = new ArrayList();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo.name != null) {
                arrayList.add(featureInfo);
            }
        }
        ArrayList arrayList2 = new ArrayList(y7.i.E(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((FeatureInfo) it.next()).name);
        }
        map.put("systemFeatures", arrayList2);
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        map.put("freeDiskSize", Long.valueOf(statFs.getFreeBytes()));
        map.put("totalDiskSize", Long.valueOf(statFs.getTotalBytes()));
        HashMap map2 = new HashMap();
        int i9 = Build.VERSION.SDK_INT;
        map2.put("baseOS", Build.VERSION.BASE_OS);
        map2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
        map2.put("securityPatch", Build.VERSION.SECURITY_PATCH);
        map2.put("codename", Build.VERSION.CODENAME);
        map2.put("incremental", Build.VERSION.INCREMENTAL);
        map2.put("release", Build.VERSION.RELEASE);
        map2.put("sdkInt", Integer.valueOf(i9));
        map.put("version", map2);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.f4568b.getMemoryInfo(memoryInfo);
        map.put("isLowRamDevice", Boolean.valueOf(memoryInfo.lowMemory));
        map.put("physicalRamSize", Long.valueOf(memoryInfo.totalMem / Config.DEFAULT_MAX_FILE_LENGTH));
        map.put("availableRamSize", Long.valueOf(memoryInfo.availMem / Config.DEFAULT_MAX_FILE_LENGTH));
        try {
            serial = Build.getSerial();
        } catch (SecurityException unused) {
        }
        map.put("serialNumber", serial);
        ((p096m7.k) dVar).success(map);
    }
}

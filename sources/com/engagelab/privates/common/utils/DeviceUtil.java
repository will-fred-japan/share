package com.engagelab.privates.common.utils;

import A.f;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.helper.CollectControlHelper;
import com.engagelab.privates.common.ids.IdHelper;
import com.starburst.sdk.api.GuiControlConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes.dex */
public class DeviceUtil {
    private static final FileFilter CPU_FILTER = new a();
    private static String CPU_HARDWARE = "";
    private static String CPU_INFO = "";
    public static String GAID = null;
    private static final String TAG = "DeviceUtil";

    public static class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i9 = 3; i9 < name.length(); i9++) {
                if (name.charAt(i9) < '0' || name.charAt(i9) > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    public static Long directoryStatAvailableBytes(File file) {
        if (file == null) {
            return null;
        }
        try {
            return statFsAvailableBytesSafe(new StatFs(file.getPath()));
        } catch (Throwable th) {
            f.n("directoryStatAvailableBytes: ", TAG, th);
            return null;
        }
    }

    public static Long directoryStatTotalBytes(File file) {
        if (file == null) {
            return null;
        }
        try {
            return statFsTotalBytesSafe(new StatFs(file.getPath()));
        } catch (Throwable th) {
            f.n("directoryStatTotalBytes: ", TAG, th);
            return null;
        }
    }

    private static int extractValue(byte[] bArr, int i9) {
        byte b9;
        byte b10;
        while (i9 < bArr.length && (b9 = bArr[i9]) != 10) {
            try {
                if (b9 >= 48 && b9 <= 57) {
                    int i10 = i9 + 1;
                    while (i10 < bArr.length && (b10 = bArr[i10]) >= 48 && b10 <= 57) {
                        i10++;
                    }
                    return Integer.parseInt(new String(bArr, 0, i9, i10 - i9));
                }
                i9++;
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static File findNonPrimaryExternalFilesDir(File file, Context context) {
        File[] externalFilesDirsOrSingle = getExternalFilesDirsOrSingle(context);
        if (externalFilesDirsOrSingle == null) {
            return null;
        }
        String absolutePath = file != null ? file.getAbsolutePath() : null;
        for (File file2 : externalFilesDirsOrSingle) {
            if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                return file2;
            }
        }
        return null;
    }

    public static String getAndroidId(Context context) {
        return "";
    }

    public static String getAppLabel(Context context) {
        if (context == null) {
            return "";
        }
        try {
            CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            return applicationLabel != null ? applicationLabel.toString() : "";
        } catch (Throwable th) {
            f.n("getAppLabel: ", TAG, th);
            return "";
        }
    }

    public static long getAppVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo == null) {
            return 0L;
        }
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }

    public static String getAppVersionName(Context context) {
        String str;
        PackageInfo packageInfo = getPackageInfo(context);
        return (packageInfo == null || (str = packageInfo.versionName) == null) ? "" : str;
    }

    public static Float getBatteryLevelPercent(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Float getBatteryTemperatureCelsius(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(intExtra / 10.0f);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getBrand() {
        return String.format(Locale.ENGLISH, Build.BRAND, new Object[0]);
    }

    public static int getCPUMaxFreqKHz() {
        int i9 = 0;
        while (true) {
            FileInputStream fileInputStream = null;
            try {
                if (i9 >= getCpuCoreCount()) {
                    FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                    try {
                        int fileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused) {
                        }
                        return fileForValue;
                    } catch (Throwable unused2) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        return -1;
                    }
                }
                try {
                    File file = new File("/sys/devices/system/cpu/cpu" + i9 + "/cpufreq/cpuinfo_max_freq");
                    if (file.exists()) {
                        byte[] bArr = new byte[128];
                        FileInputStream fileInputStream3 = new FileInputStream(file);
                        try {
                            if (-1 == fileInputStream3.read(bArr)) {
                                try {
                                    fileInputStream3.close();
                                } catch (Throwable unused4) {
                                }
                                try {
                                    fileInputStream3.close();
                                } catch (Throwable unused5) {
                                }
                                return -1;
                            }
                            int i10 = 0;
                            while (true) {
                                byte b9 = bArr[i10];
                                if (b9 < 48 || b9 > 57) {
                                    break;
                                }
                                i10++;
                            }
                            int i11 = Integer.parseInt(new String(bArr, 0, i10));
                            try {
                                fileInputStream3.close();
                            } catch (Throwable unused6) {
                            }
                            try {
                                fileInputStream3.close();
                            } catch (Throwable unused7) {
                            }
                            return i11;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream3;
                        }
                    } else {
                        i9++;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused8) {
                    }
                }
                throw th;
            } catch (Throwable unused9) {
            }
        }
    }

    public static String getCarrier(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(GuiControlConfig.DEVICE_PHONE)).getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getCountryCodeByLocale() {
        return Locale.getDefault().getCountry();
    }

    public static int getCpuCoreCount() {
        File[] fileArrListFiles;
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (file.exists() && (fileArrListFiles = file.listFiles(CPU_FILTER)) != null && fileArrListFiles.length != 0) {
                return fileArrListFiles.length;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getCpuHardwareInfo() {
        if (!TextUtils.isEmpty(CPU_HARDWARE)) {
            return CPU_HARDWARE;
        }
        matchCpuInfo();
        return CPU_HARDWARE;
    }

    public static String getCpuInfo() {
        if (!TextUtils.isEmpty(CPU_INFO)) {
            return CPU_INFO;
        }
        matchCpuInfo();
        return CPU_INFO;
    }

    public static DisplayMetrics getDisplayMetricsOrNull(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            f.n("getDisplayMetricsOrNull: ", TAG, th);
            return null;
        }
    }

    public static File[] getExternalFilesDirsOrSingle(Context context) {
        if (context == null) {
            return null;
        }
        return context.getExternalFilesDirs(null);
    }

    public static String getGAID(Context context) {
        if (!CollectControlHelper.getInstance().getCollectControl("gaid")) {
            return "";
        }
        String str = GAID;
        if (str != null) {
            return str;
        }
        String gaid = IdHelper.getGaid(context);
        GAID = gaid;
        return gaid;
    }

    public static String getKernelVersion() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"));
            try {
                String line = bufferedReader.readLine();
                if (!TextUtils.isEmpty(line)) {
                    bufferedReader.close();
                    return line;
                }
                bufferedReader.close();
                String property = System.getProperty("os.version");
                return property != null ? property : "";
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String getLanguage(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String getManufacturer() {
        return String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
    }

    public static String getModel() {
        return String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
    }

    public static String getNetworkOperator(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(GuiControlConfig.DEVICE_PHONE)).getNetworkOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static PackageInfo getPackageInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable th) {
            f.n("getPackageInfo: ", TAG, th);
            return null;
        }
    }

    public static String getPackageName(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static String getPrimaryCpuAbi() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null && strArr.length > 0 && !TextUtils.isEmpty(strArr[0])) {
            return strArr[0];
        }
        String str = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = Build.CPU_ABI2;
        return str2 != null ? str2 : "";
    }

    public static long getProcessStartWallTimeMillis() {
        return System.currentTimeMillis() - (SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
    }

    public static String getProduct() {
        return String.format(Locale.ENGLISH, Build.PRODUCT, new Object[0]);
    }

    public static long getRamSize(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(MTCommonConstants.Lifecycle.KEY_ACTIVITY);
            activityManager.getProcessMemoryInfo(new int[]{0});
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String getResolution(Context context) {
        DisplayMetrics displayMetrics;
        try {
            if (context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
                return "0*0";
            }
            return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        } catch (Throwable unused) {
            return "0*0";
        }
    }

    public static long getRomSize(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static double getScreenSize(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static String getSystemDevice() {
        return Build.DEVICE.toLowerCase();
    }

    public static String getSystemVersionRelease() {
        return String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
    }

    public static int getSystemVersionSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    public static String getTimeZone() {
        String strD;
        long rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset > 0) {
            strD = defpackage.f.d(rawOffset, "+");
        } else {
            strD = rawOffset < 0 ? defpackage.f.d(rawOffset, Constants.ACCEPT_TIME_SEPARATOR_SERVER) : defpackage.f.d(rawOffset, "");
        }
        return strD.replace("--", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String getTimeZoneId() {
        return ZoneId.systemDefault().getId();
    }

    public static long getTotalMemBytes(ActivityManager.MemoryInfo memoryInfo) {
        return memoryInfo.totalMem;
    }

    public static boolean hasGAIDPermission(Context context) {
        return IdHelper.hasGAIDPermission(context);
    }

    public static String inferDeviceFamilyName() {
        try {
            String model = getModel();
            return !TextUtils.isEmpty(model) ? model.split(" ", -1)[0] : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean isAdTrackingEnabled(Context context) {
        return !IdHelper.isLimitAdTrackingEnabled(context);
    }

    public static Boolean isBatteryCharging(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z8 = true;
            if (intExtra != 1 && intExtra != 2) {
                z8 = false;
            }
            return Boolean.valueOf(z8);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isExternalStorageStateMounted() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    private static void matchCpuInfo() {
        BufferedReader bufferedReader;
        try {
            File file = new File("/proc/cpuinfo");
            try {
                if (file.exists()) {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.contains("Processor")) {
                                StringBuilder sb = new StringBuilder();
                                int iIndexOf = line.indexOf(Constants.COLON_SEPARATOR);
                                if (iIndexOf >= 0 && iIndexOf < line.length() - 1) {
                                    sb.append(line.substring(iIndexOf + 1).trim());
                                }
                                CPU_INFO = sb.toString();
                            }
                            if (line.contains("Hardware")) {
                                CPU_HARDWARE = line.substring(line.indexOf(Constants.COLON_SEPARATOR) + 1).trim();
                            }
                        } catch (Throwable unused) {
                            if (bufferedReader == null) {
                            }
                        }
                    }
                    bufferedReader.close();
                    return;
                }
                return;
                bufferedReader.close();
                return;
            } catch (Throwable unused2) {
                return;
            }
        } catch (Throwable unused3) {
            bufferedReader = null;
        }
        if (bufferedReader == null) {
        }
    }

    public static Long nonPrimaryExternalAvailableBytes(File file, Context context) {
        return statFsAvailableBytesSafe(statFsForNonPrimaryExternalIfMounted(file, context));
    }

    public static Long nonPrimaryExternalTotalBytes(File file, Context context) {
        return statFsTotalBytesSafe(statFsForNonPrimaryExternalIfMounted(file, context));
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        try {
            byte[] bArr = new byte[1024];
            int i9 = fileInputStream.read(bArr);
            int i10 = 0;
            while (i10 < i9) {
                byte b9 = bArr[i10];
                if (b9 == 10 || i10 == 0) {
                    if (b9 == 10) {
                        i10++;
                    }
                    for (int i11 = i10; i11 < i9; i11++) {
                        int i12 = i11 - i10;
                        if (bArr[i11] != str.charAt(i12)) {
                            break;
                        }
                        if (i12 == str.length() - 1) {
                            return extractValue(bArr, i11);
                        }
                    }
                }
                i10++;
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public static ActivityManager.MemoryInfo queryMemoryInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(MTCommonConstants.Lifecycle.KEY_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
        } catch (Throwable th) {
            f.n("queryMemoryInfo: ", TAG, th);
        }
        return null;
    }

    public static Intent registerBatteryStickyIntent(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable th) {
            f.n("registerBatteryStickyIntent: ", TAG, th);
            return null;
        }
    }

    private static long statFsAvailableBlocksLong(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    public static Long statFsAvailableBytesSafe(StatFs statFs) {
        if (statFs == null) {
            return null;
        }
        try {
            return Long.valueOf(statFsBlockSizeLong(statFs) * statFsAvailableBlocksLong(statFs));
        } catch (Throwable th) {
            f.n("statFsAvailableBytesSafe: ", TAG, th);
            return null;
        }
    }

    private static long statFsBlockCountLong(StatFs statFs) {
        return statFs.getBlockCountLong();
    }

    private static long statFsBlockSizeLong(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    public static StatFs statFsForNonPrimaryExternalIfMounted(File file, Context context) {
        File fileFindNonPrimaryExternalFilesDir;
        if (!isExternalStorageStateMounted() || (fileFindNonPrimaryExternalFilesDir = findNonPrimaryExternalFilesDir(file, context)) == null) {
            return null;
        }
        try {
            return new StatFs(fileFindNonPrimaryExternalFilesDir.getPath());
        } catch (Throwable th) {
            f.n("statFsForNonPrimaryExternalIfMounted: ", TAG, th);
            return null;
        }
    }

    public static Long statFsTotalBytesSafe(StatFs statFs) {
        if (statFs == null) {
            return null;
        }
        try {
            return Long.valueOf(statFsBlockSizeLong(statFs) * statFsBlockCountLong(statFs));
        } catch (Throwable th) {
            f.n("statFsTotalBytesSafe: ", TAG, th);
            return null;
        }
    }
}

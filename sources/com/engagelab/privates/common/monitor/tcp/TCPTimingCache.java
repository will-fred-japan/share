package com.engagelab.privates.common.monitor.tcp;

import W5.e;
import android.content.Context;
import android.content.SharedPreferences;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.engagelab.privates.common.global.MTGlobal;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TCPTimingCache {
    private static final String CTRL_PREFS = "com.engagelab.privates.common.prefs.tcp_timing_ctrl";
    private static final String DIR_NAME = "tcp_timing";
    private static final String FIRST_TS = "_first_ts";
    private static final String F_C = "_f_c";
    private static final String F_MAX = "_f_max";
    private static final String F_MIN = "_f_min";
    private static final String F_SUM = "_f_sum";
    private static final String F_TYPES = "_f_types";
    private static final String INIT_F_NN_MAX = "init_f_nn_max";
    private static final String INIT_F_NN_MIN = "init_f_nn_min";
    private static final String INIT_F_NN_SUM = "init_f_nn_sum";
    private static final String INIT_S_NN_MAX = "init_s_nn_max";
    private static final String INIT_S_NN_MIN = "init_s_nn_min";
    private static final String INIT_S_NN_SUM = "init_s_nn_sum";
    private static final String LAST_REPORT_TIME = "last_report_time";
    private static final int MAX_STORE_DAYS = 10;
    private static final String MT_CONNECT = "TCP_CONNECT_TIME";
    private static final String MT_DNS = "TCP_DNS_TIME";
    private static final String MT_GLOBAL_SIS = "TCP_GLOBALSIS_TIME";
    private static final String MT_INIT = "TCP_INIT_TIME";
    private static final String MT_LOGIN = "TCP_LOGIN_TIME";
    private static final String MT_REGISTER = "TCP_REGISTER_TIME";
    private static final String MT_SIS = "TCP_SIS_TIME";
    public static final String P_CONNECT = "connect";
    public static final String P_DNS = "dns";
    public static final String P_GLOBAL_SIS = "globalsis";
    public static final String P_INIT = "init";
    public static final String P_LOGIN = "login";
    public static final String P_REGISTER = "register";
    public static final String P_SIS = "sis";
    private static final long REPORT_INTERVAL_MS = 86400000;
    private static final String S_C = "_s_c";
    private static final String S_MAX = "_s_max";
    private static final String S_MIN = "_s_min";
    private static final String S_SUM = "_s_sum";
    private static final String TOTAL_C = "_total_c";
    private static final Map<String, JSONObject> dayCache = new ConcurrentHashMap();

    public static class a implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    public static class b implements Comparator<File> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    private static String addFailureType(String str, int i9) {
        String strValueOf = String.valueOf(i9);
        if (str.isEmpty()) {
            return e.u(strValueOf, ":1");
        }
        String[] strArrSplit = str.split("\\|");
        StringBuilder sb = new StringBuilder();
        boolean z8 = false;
        for (String str2 : strArrSplit) {
            if (sb.length() > 0) {
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
            int iIndexOf = str2.indexOf(58);
            if (iIndexOf <= 0 || !str2.substring(0, iIndexOf).equals(strValueOf)) {
                sb.append(str2);
            } else {
                sb.append(strValueOf);
                sb.append(Constants.COLON_SEPARATOR);
                sb.append(Integer.parseInt(str2.substring(iIndexOf + 1)) + 1);
                z8 = true;
            }
        }
        if (!z8) {
            if (sb.length() > 0) {
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
            sb.append(strValueOf);
            sb.append(":1");
        }
        return sb.toString();
    }

    private static JSONObject buildInitItem(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        try {
            int iOptInt = jSONObject.optInt("init_total_c", 0);
            if (iOptInt <= 0) {
                return null;
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("c", iOptInt);
            int iOptInt2 = jSONObject.optInt("init_s_c", 0);
            if (iOptInt2 > 0) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("c", iOptInt2);
                jSONObject2 = null;
                long j = iOptInt2;
                try {
                    jSONObject5.put("avg", jSONObject.optLong("init_s_sum", 0L) / j);
                    jSONObject5.put("min", jSONObject.optLong("init_s_min", 0L));
                    jSONObject5.put("max", jSONObject.optLong("init_s_max", 0L));
                    jSONObject5.put("n_n_avg", jSONObject.optLong(INIT_S_NN_SUM, 0L) / j);
                    jSONObject5.put("n_n_min", jSONObject.optLong(INIT_S_NN_MIN, 0L));
                    jSONObject5.put("n_n_max", jSONObject.optLong(INIT_S_NN_MAX, 0L));
                    jSONObject3 = jSONObject4;
                    jSONObject3.put("s", jSONObject5);
                } catch (Throwable unused) {
                    return jSONObject2;
                }
            } else {
                jSONObject2 = null;
                jSONObject3 = jSONObject4;
            }
            int iOptInt3 = jSONObject.optInt("init_f_c", 0);
            if (iOptInt3 > 0) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("c", iOptInt3);
                long j8 = iOptInt3;
                jSONObject6.put("avg", jSONObject.optLong("init_f_sum", 0L) / j8);
                jSONObject6.put("min", jSONObject.optLong("init_f_min", 0L));
                jSONObject6.put("max", jSONObject.optLong("init_f_max", 0L));
                jSONObject6.put("n_n_avg", jSONObject.optLong(INIT_F_NN_SUM, 0L) / j8);
                jSONObject6.put("n_n_min", jSONObject.optLong(INIT_F_NN_MIN, 0L));
                jSONObject6.put("n_n_max", jSONObject.optLong(INIT_F_NN_MAX, 0L));
                String strOptString = jSONObject.optString("init_f_types", "");
                if (!strOptString.isEmpty()) {
                    jSONObject6.put("t", strOptString);
                }
                jSONObject3.put("f", jSONObject6);
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("monitor_type", MT_INIT);
            jSONObject7.put("monitor_id", UUID.randomUUID().toString());
            jSONObject7.put("timestamp", jSONObject.optLong("init_first_ts", 0L) / 1000);
            jSONObject7.put(JThirdPlatFormInterface.KEY_EXTRA, jSONObject3);
            return jSONObject7;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static JSONObject buildNonInitItem(JSONObject jSONObject, String str, String str2) {
        JSONObject jSONObject2;
        try {
            int iOptInt = jSONObject.optInt(str + TOTAL_C, 0);
            if (iOptInt <= 0) {
                return null;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("c", iOptInt);
            int iOptInt2 = jSONObject.optInt(str + S_C, 0);
            if (iOptInt2 > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("c", iOptInt2);
                jSONObject2 = null;
                try {
                    jSONObject4.put("n_avg", jSONObject.optLong(str + S_SUM, 0L) / ((long) iOptInt2));
                    jSONObject4.put("n_min", jSONObject.optLong(str + S_MIN, 0L));
                    jSONObject4.put("n_max", jSONObject.optLong(str + S_MAX, 0L));
                    jSONObject3.put("s", jSONObject4);
                } catch (Throwable unused) {
                    return jSONObject2;
                }
            } else {
                jSONObject2 = null;
            }
            int iOptInt3 = jSONObject.optInt(str + F_C, 0);
            if (iOptInt3 > 0) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("c", iOptInt3);
                jSONObject5.put("n_avg", jSONObject.optLong(str + F_SUM, 0L) / ((long) iOptInt3));
                jSONObject5.put("n_min", jSONObject.optLong(str + F_MIN, 0L));
                jSONObject5.put("n_max", jSONObject.optLong(str + F_MAX, 0L));
                String strOptString = jSONObject.optString(str + F_TYPES, "");
                if (!strOptString.isEmpty()) {
                    jSONObject5.put("t", strOptString);
                }
                jSONObject3.put("f", jSONObject5);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("monitor_type", str2);
            jSONObject6.put("monitor_id", UUID.randomUUID().toString());
            jSONObject6.put("timestamp", jSONObject.optLong(str + FIRST_TS, 0L) / 1000);
            jSONObject6.put(JThirdPlatFormInterface.KEY_EXTRA, jSONObject3);
            return jSONObject6;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static synchronized JSONObject buildReportJson(Context context) {
        try {
            File[] fileArrListFiles = getDataDir(context).listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                Arrays.sort(fileArrListFiles, new b());
                JSONArray jSONArray = new JSONArray();
                String[] strArr = {P_GLOBAL_SIS, P_DNS, P_SIS, P_CONNECT, "register", P_LOGIN};
                String[] strArr2 = {MT_GLOBAL_SIS, MT_DNS, MT_SIS, MT_CONNECT, MT_REGISTER, MT_LOGIN};
                String str = today();
                for (File file : fileArrListFiles) {
                    String strReplace = file.getName().replace(".json", "");
                    if (!strReplace.equals(str)) {
                        JSONObject jSONObjectLoadDayJson = loadDayJson(context, strReplace);
                        for (int i9 = 0; i9 < 6; i9++) {
                            JSONObject jSONObjectBuildNonInitItem = buildNonInitItem(jSONObjectLoadDayJson, strArr[i9], strArr2[i9]);
                            if (jSONObjectBuildNonInitItem != null) {
                                jSONArray.put(jSONObjectBuildNonInitItem);
                            }
                        }
                        JSONObject jSONObjectBuildInitItem = buildInitItem(jSONObjectLoadDayJson);
                        if (jSONObjectBuildInitItem != null) {
                            jSONArray.put(jSONObjectBuildInitItem);
                        }
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", jSONArray);
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized void clearAll(Context context) {
        try {
            File[] fileArrListFiles = getDataDir(context).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
            dayCache.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void clearReportedData(Context context) {
        File[] fileArrListFiles = getDataDir(context).listFiles();
        String str = today();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String strReplace = file.getName().replace(".json", "");
                if (!strReplace.equals(str)) {
                    dayCache.remove(strReplace);
                    file.delete();
                }
            }
        }
    }

    private static void ensureMaxDays(Context context) {
        File[] fileArrListFiles = getDataDir(context).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 10) {
            return;
        }
        Arrays.sort(fileArrListFiles, new a());
        int length = fileArrListFiles.length - 10;
        for (int i9 = 0; i9 < length; i9++) {
            dayCache.remove(fileArrListFiles[i9].getName().replace(".json", ""));
            fileArrListFiles[i9].delete();
        }
    }

    private static SharedPreferences getCtrlSP(Context context) {
        return context.getSharedPreferences("com.engagelab.privates.common.prefs.tcp_timing_ctrl." + MTGlobal.getAppKey(context), 0);
    }

    private static File getDataDir(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder("com_engagelab_privates_common");
        String str = File.separator;
        sb.append(str);
        sb.append(MTGlobal.getAppKey(context));
        sb.append(str);
        sb.append(DIR_NAME);
        File file = new File(filesDir, sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File getDateFile(Context context, String str) {
        return new File(getDataDir(context), e.u(str, ".json"));
    }

    public static long getLastReportTime(Context context) {
        return getCtrlSP(context).getLong(LAST_REPORT_TIME, 0L);
    }

    public static boolean isReportIntervalElapsed(Context context) {
        return System.currentTimeMillis() - getLastReportTime(context) >= 86400000;
    }

    private static JSONObject loadDayJson(Context context, String str) {
        JSONObject jSONObject = dayCache.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            File dateFile = getDateFile(context, str);
            if (!dateFile.exists()) {
                return new JSONObject();
            }
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dateFile));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    JSONObject jSONObject2 = new JSONObject(sb.toString());
                    dayCache.put(str, jSONObject2);
                    return jSONObject2;
                }
                sb.append(line);
            }
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static synchronized void recordFailure(Context context, String str, long j, int i9) {
        String str2 = today();
        boolean zExists = getDateFile(context, str2).exists();
        JSONObject jSONObjectLoadDayJson = loadDayJson(context, str2);
        try {
            int iOptInt = jSONObjectLoadDayJson.optInt(str + F_C, 0) + 1;
            long jOptLong = jSONObjectLoadDayJson.optLong(str + F_SUM, 0L) + j;
            long jOptLong2 = jSONObjectLoadDayJson.optLong(str + F_MIN, 0L);
            long jOptLong3 = jSONObjectLoadDayJson.optLong(str + F_MAX, 0L);
            if (jOptLong2 == 0 || j < jOptLong2) {
                jOptLong2 = j;
            }
            long j8 = j > jOptLong3 ? j : jOptLong3;
            jSONObjectLoadDayJson.put(str + TOTAL_C, jSONObjectLoadDayJson.optInt(str + TOTAL_C, 0) + 1);
            jSONObjectLoadDayJson.put(str + F_C, iOptInt);
            jSONObjectLoadDayJson.put(str + F_SUM, jOptLong);
            jSONObjectLoadDayJson.put(str + F_MIN, jOptLong2);
            jSONObjectLoadDayJson.put(str + F_MAX, j8);
            jSONObjectLoadDayJson.put(str + F_TYPES, addFailureType(jSONObjectLoadDayJson.optString(str + F_TYPES, ""), i9));
            recordFirstTs(jSONObjectLoadDayJson, str);
        } catch (Throwable unused) {
        }
        saveDayJson(context, str2, jSONObjectLoadDayJson);
        if (!zExists) {
            ensureMaxDays(context);
        }
    }

    private static void recordFirstTs(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.optLong(str + FIRST_TS, 0L) == 0) {
            jSONObject.put(e.u(str, FIRST_TS), System.currentTimeMillis());
        }
    }

    public static synchronized void recordInitFailure(Context context, long j, long j8, int i9) throws Throwable {
        String str;
        boolean z8;
        Class<TCPTimingCache> cls = TCPTimingCache.class;
        synchronized (cls) {
            try {
                try {
                    String str2 = today();
                    boolean zExists = getDateFile(context, str2).exists();
                    JSONObject jSONObjectLoadDayJson = loadDayJson(context, str2);
                    try {
                        int iOptInt = jSONObjectLoadDayJson.optInt("init_f_c", 0) + 1;
                        long jOptLong = jSONObjectLoadDayJson.optLong("init_f_sum", 0L) + j;
                        long jOptLong2 = jSONObjectLoadDayJson.optLong("init_f_min", 0L);
                        long jOptLong3 = jSONObjectLoadDayJson.optLong("init_f_max", 0L);
                        if (jOptLong2 == 0 || j < jOptLong2) {
                            jOptLong2 = j;
                        }
                        if (j > jOptLong3) {
                            jOptLong3 = j;
                        }
                        long jOptLong4 = jSONObjectLoadDayJson.optLong(INIT_F_NN_SUM, 0L) + j8;
                        z8 = zExists;
                        try {
                            long jOptLong5 = jSONObjectLoadDayJson.optLong(INIT_F_NN_MIN, 0L);
                            long jOptLong6 = jSONObjectLoadDayJson.optLong(INIT_F_NN_MAX, 0L);
                            long j9 = (jOptLong5 == 0 || j8 < jOptLong5) ? j8 : jOptLong5;
                            str = str2;
                            long j10 = j8 > jOptLong6 ? j8 : jOptLong6;
                            try {
                                jSONObjectLoadDayJson.put("init_total_c", jSONObjectLoadDayJson.optInt("init_total_c", 0) + 1);
                                jSONObjectLoadDayJson.put("init_f_c", iOptInt);
                                jSONObjectLoadDayJson.put("init_f_sum", jOptLong);
                                jSONObjectLoadDayJson.put("init_f_min", jOptLong2);
                                jSONObjectLoadDayJson.put("init_f_max", jOptLong3);
                                jSONObjectLoadDayJson.put("init_f_types", addFailureType(jSONObjectLoadDayJson.optString("init_f_types", ""), i9));
                                jSONObjectLoadDayJson.put(INIT_F_NN_SUM, jOptLong4);
                                jSONObjectLoadDayJson.put(INIT_F_NN_MIN, j9);
                                jSONObjectLoadDayJson.put(INIT_F_NN_MAX, j10);
                                recordFirstTs(jSONObjectLoadDayJson, P_INIT);
                            } catch (Throwable unused) {
                            }
                        } catch (Throwable unused2) {
                            cls = cls;
                            str = str2;
                        }
                    } catch (Throwable unused3) {
                        str = str2;
                        z8 = zExists;
                        cls = cls;
                    }
                    saveDayJson(context, str, jSONObjectLoadDayJson);
                    if (!z8) {
                        ensureMaxDays(context);
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
        throw th;
    }

    public static synchronized void recordInitSuccess(Context context, long j, long j8) throws Throwable {
        String str;
        boolean z8;
        Class<TCPTimingCache> cls = TCPTimingCache.class;
        synchronized (cls) {
            try {
                try {
                    String str2 = today();
                    boolean zExists = getDateFile(context, str2).exists();
                    JSONObject jSONObjectLoadDayJson = loadDayJson(context, str2);
                    try {
                        int iOptInt = jSONObjectLoadDayJson.optInt("init_s_c", 0) + 1;
                        long jOptLong = jSONObjectLoadDayJson.optLong("init_s_sum", 0L) + j;
                        long jOptLong2 = jSONObjectLoadDayJson.optLong("init_s_min", 0L);
                        long jOptLong3 = jSONObjectLoadDayJson.optLong("init_s_max", 0L);
                        if (jOptLong2 == 0 || j < jOptLong2) {
                            jOptLong2 = j;
                        }
                        if (j > jOptLong3) {
                            jOptLong3 = j;
                        }
                        long jOptLong4 = jSONObjectLoadDayJson.optLong(INIT_S_NN_SUM, 0L) + j8;
                        z8 = zExists;
                        try {
                            long jOptLong5 = jSONObjectLoadDayJson.optLong(INIT_S_NN_MIN, 0L);
                            long jOptLong6 = jSONObjectLoadDayJson.optLong(INIT_S_NN_MAX, 0L);
                            long j9 = (jOptLong5 == 0 || j8 < jOptLong5) ? j8 : jOptLong5;
                            str = str2;
                            long j10 = j8 > jOptLong6 ? j8 : jOptLong6;
                            try {
                                jSONObjectLoadDayJson.put("init_total_c", jSONObjectLoadDayJson.optInt("init_total_c", 0) + 1);
                                jSONObjectLoadDayJson.put("init_s_c", iOptInt);
                                jSONObjectLoadDayJson.put("init_s_sum", jOptLong);
                                jSONObjectLoadDayJson.put("init_s_min", jOptLong2);
                                jSONObjectLoadDayJson.put("init_s_max", jOptLong3);
                                jSONObjectLoadDayJson.put(INIT_S_NN_SUM, jOptLong4);
                                jSONObjectLoadDayJson.put(INIT_S_NN_MIN, j9);
                                jSONObjectLoadDayJson.put(INIT_S_NN_MAX, j10);
                                recordFirstTs(jSONObjectLoadDayJson, P_INIT);
                            } catch (Throwable unused) {
                            }
                        } catch (Throwable unused2) {
                            cls = cls;
                            str = str2;
                        }
                    } catch (Throwable unused3) {
                        str = str2;
                        z8 = zExists;
                        cls = cls;
                    }
                    saveDayJson(context, str, jSONObjectLoadDayJson);
                    if (!z8) {
                        ensureMaxDays(context);
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
        throw th;
    }

    public static synchronized void recordSuccess(Context context, String str, long j) {
        String str2 = today();
        boolean zExists = getDateFile(context, str2).exists();
        JSONObject jSONObjectLoadDayJson = loadDayJson(context, str2);
        try {
            int iOptInt = jSONObjectLoadDayJson.optInt(str + S_C, 0) + 1;
            long jOptLong = jSONObjectLoadDayJson.optLong(str + S_SUM, 0L) + j;
            long jOptLong2 = jSONObjectLoadDayJson.optLong(str + S_MIN, 0L);
            long jOptLong3 = jSONObjectLoadDayJson.optLong(str + S_MAX, 0L);
            if (jOptLong2 == 0 || j < jOptLong2) {
                jOptLong2 = j;
            }
            long j8 = j > jOptLong3 ? j : jOptLong3;
            jSONObjectLoadDayJson.put(str + TOTAL_C, jSONObjectLoadDayJson.optInt(str + TOTAL_C, 0) + 1);
            jSONObjectLoadDayJson.put(str + S_C, iOptInt);
            jSONObjectLoadDayJson.put(str + S_SUM, jOptLong);
            jSONObjectLoadDayJson.put(str + S_MIN, jOptLong2);
            jSONObjectLoadDayJson.put(str + S_MAX, j8);
            recordFirstTs(jSONObjectLoadDayJson, str);
        } catch (Throwable unused) {
        }
        saveDayJson(context, str2, jSONObjectLoadDayJson);
        if (!zExists) {
            ensureMaxDays(context);
        }
    }

    private static void saveDayJson(Context context, String str, JSONObject jSONObject) {
        try {
            dayCache.put(str, jSONObject);
            FileWriter fileWriter = new FileWriter(getDateFile(context, str));
            fileWriter.write(jSONObject.toString());
            fileWriter.close();
        } catch (Throwable unused) {
        }
    }

    public static void setLastReportTime(Context context, long j) {
        getCtrlSP(context).edit().putLong(LAST_REPORT_TIME, j).apply();
    }

    public static String today() {
        return new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date());
    }
}

package com.jieli.jl_bt_ota.util;

import H2.a;
import W5.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class JL_Log {
    public static long FILE_SIZE_LIMIT = 314572800;
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_VERBOSE = 1;
    public static final int LEVEL_WARN = 4;
    public static int SAVE_LOG_LEVEL = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16328a = "ota:";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f16329b = "logcat";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f16330c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f16331d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f16332e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"ConstantLocale"})
    private static final SimpleDateFormat f16333f = new SimpleDateFormat("yyyyMMddHHmmss.SSS", Locale.getDefault());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static SaveLogFileThread f16334g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Context f16335h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ILogOutput f16336i = null;
    public static boolean isTest = false;

    public interface ILogOutput {
        void output(String str);
    }

    public static class SaveLogFileThread extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LinkedBlockingQueue<byte[]> f16337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f16338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f16339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile boolean f16340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f16341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private FileOutputStream f16342f;

        public SaveLogFileThread(Context context) {
            super("SaveLogFileThread");
            this.f16337a = new LinkedBlockingQueue<>();
            this.f16338b = context;
        }

        public void addLog(byte[] bArr) {
            if (bArr != null) {
                try {
                    this.f16337a.put(bArr);
                    a();
                } catch (InterruptedException e9) {
                    e9.printStackTrace();
                }
            }
        }

        public synchronized void closeSaveFile() {
            this.f16340d = false;
            a();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            this.f16340d = a(this.f16338b);
            synchronized (this.f16337a) {
                while (this.f16340d) {
                    try {
                        if (this.f16337a.isEmpty()) {
                            this.f16339c = true;
                            try {
                                this.f16337a.wait();
                            } catch (InterruptedException e9) {
                                e9.printStackTrace();
                            }
                        } else {
                            this.f16339c = false;
                            byte[] bArrPoll = this.f16337a.poll();
                            if (bArrPoll != null && (fileOutputStream = this.f16342f) != null) {
                                try {
                                    fileOutputStream.write(bArrPoll);
                                    this.f16341e += (long) bArrPoll.length;
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                                if (this.f16341e >= JL_Log.FILE_SIZE_LIMIT) {
                                    try {
                                        this.f16342f.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                    }
                                    this.f16340d = a(this.f16338b);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f16340d = false;
            this.f16339c = false;
            this.f16337a.clear();
            FileOutputStream fileOutputStream2 = this.f16342f;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            SaveLogFileThread unused = JL_Log.f16334g = null;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.f16341e = 0L;
            this.f16340d = this.f16338b != null;
            super.start();
        }

        private void a() {
            if (this.f16339c) {
                synchronized (this.f16337a) {
                    this.f16337a.notify();
                }
            }
        }

        private boolean a(Context context) {
            if (context == null) {
                return false;
            }
            if (TextUtils.isEmpty(JL_Log.f16332e)) {
                String unused = JL_Log.f16332e = JL_Log.b(context, JL_Log.f16329b);
            }
            try {
                this.f16342f = new FileOutputStream(JL_Log.f16332e + "/ota_log_app_" + JL_Log.d() + ".txt", true);
                this.f16341e = 0L;
                return true;
            } catch (FileNotFoundException e9) {
                e9.printStackTrace();
                return false;
            }
        }
    }

    public static void addLogOutput(String str) {
        if (f16331d) {
            if (f16334g == null) {
                a(f16335h);
                SystemClock.sleep(20L);
            }
            SaveLogFileThread saveLogFileThread = f16334g;
            if (saveLogFileThread != null) {
                saveLogFileThread.addLog(str.getBytes());
            }
        }
    }

    private static void c(int i9, String str, String str2) {
        String strA = a(a(i9), str, str2);
        ILogOutput iLogOutput = f16336i;
        if (iLogOutput != null) {
            iLogOutput.output(strA);
        } else {
            if (i9 < SAVE_LOG_LEVEL) {
                return;
            }
            addLogOutput(strA);
        }
    }

    public static void d(String str, String str2) {
        a(2, str, str2);
    }

    public static void e(String str, String str2) {
        a(5, str, str2);
    }

    public static boolean getSaveLogFile() {
        return f16331d;
    }

    public static String getSaveLogPath(Context context) {
        return b(context, f16329b);
    }

    public static void i(String str, String str2) {
        a(3, str, str2);
    }

    public static boolean isIsLog() {
        return f16330c;
    }

    public static void setIsSaveLogFile(Context context, boolean z8) {
        f16331d = z8;
        if (z8) {
            a(context);
        } else {
            c();
        }
    }

    public static void setIsTest(boolean z8) {
        isTest = z8;
    }

    public static void setLog(boolean z8) {
        f16330c = z8;
    }

    public static void setLogOutput(ILogOutput iLogOutput) {
        f16336i = iLogOutput;
    }

    public static void v(String str, String str2) {
        a(1, str, str2);
    }

    public static void w(String str, String str2) {
        a(4, str, str2);
    }

    private static String b(String str) {
        return e.l(f16328a, str);
    }

    public static void d(String str, String str2, String str3) {
        d(str, a(str2, str3));
    }

    public static void e(String str, String str2, String str3) {
        e(str, a(str2, str3));
    }

    public static void i(String str, String str2, String str3) {
        i(str, a(str2, str3));
    }

    public static void v(String str, String str2, String str3) {
        v(str, a(str2, str3));
    }

    public static void w(String str, String str2, String str3) {
        w(str, a(str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d() {
        return f16333f.format(Calendar.getInstance().getTime());
    }

    private static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        a.j(sb, d(), "   ", str, "   ");
        if (str2 == null) {
            str2 = "null";
        }
        sb.append(str2);
        sb.append(" :  ");
        if (str3 == null) {
            str3 = "null";
        }
        return A.a.j(sb, str3, "\n");
    }

    private static void c() {
        SaveLogFileThread saveLogFileThread = f16334g;
        if (saveLogFileThread != null) {
            saveLogFileThread.closeSaveFile();
            f16334g = null;
        }
        f16335h = null;
    }

    private static void b(int i9, String str, String str2) {
        System.out.printf(Locale.ENGLISH, "%s\t%s\t%s%n", a(i9), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String... strArr) {
        File externalFilesDir;
        if (context == null || strArr == null || strArr.length == 0 || (externalFilesDir = context.getExternalFilesDir(null)) == null || !externalFilesDir.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(externalFilesDir.getPath());
        if (sb.toString().endsWith("/")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf("/")));
        }
        for (String str : strArr) {
            sb.append("/");
            sb.append(str);
            File file = new File(sb.toString());
            if ((!file.exists() || file.isFile()) && !file.mkdir()) {
                w("jieli", "createFilePath", "create dir failed. filePath = " + ((Object) sb));
                break;
            }
        }
        return sb.toString();
    }

    private static String a(String str, String str2) {
        Locale locale = Locale.ENGLISH;
        return "[" + str + "]\t" + str2;
    }

    private static String a(int i9) {
        if (i9 == 1) {
            return "v";
        }
        if (i9 == 2) {
            return "d";
        }
        if (i9 == 3) {
            return "i";
        }
        if (i9 == 4) {
            return "w";
        }
        if (i9 != 5) {
            return "";
        }
        return "e";
    }

    private static void a(int i9, String str, String str2) {
        String strB = b(str);
        if (f16330c) {
            if (isTest) {
                b(i9, strB, str2);
            } else if (i9 == 1) {
                Log.v(strB, str2);
            } else if (i9 == 2) {
                Log.d(strB, str2);
            } else if (i9 == 3) {
                Log.i(strB, str2);
            } else if (i9 == 4) {
                Log.w(strB, str2);
            } else if (i9 != 5) {
                return;
            } else {
                Log.e(strB, str2);
            }
        }
        c(i9, strB, str2);
    }

    private static void a(Context context) {
        SaveLogFileThread saveLogFileThread = f16334g;
        if (saveLogFileThread == null || !saveLogFileThread.f16340d) {
            if (f16335h == null) {
                if (context == null) {
                    context = CommonUtil.getMainContext();
                }
                f16335h = context;
            }
            SaveLogFileThread saveLogFileThread2 = new SaveLogFileThread(f16335h);
            f16334g = saveLogFileThread2;
            saveLogFileThread2.start();
        }
    }
}

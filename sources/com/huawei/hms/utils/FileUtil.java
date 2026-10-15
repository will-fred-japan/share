package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15601a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ScheduledExecutorService f15602b = Executors.newSingleThreadScheduledExecutor();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f15603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f15604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15605c;

        public a(File file, long j, String str) {
            this.f15603a = file;
            this.f15604b = j;
            this.f15605c = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            RandomAccessFile randomAccessFile;
            Throwable th;
            File file = this.f15603a;
            if (file == null) {
                HMSLog.e("FileUtil", "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || !(parentFile.mkdirs() || parentFile.isDirectory())) {
                HMSLog.e("FileUtil", "In writeFile, Failed to create directory.");
                return;
            }
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    long length = this.f15603a.length();
                    if (length > this.f15604b) {
                        String canonicalPath = this.f15603a.getCanonicalPath();
                        if (!this.f15603a.delete()) {
                            HMSLog.e("FileUtil", "last file delete failed.");
                        }
                        randomAccessFile2 = new RandomAccessFile(new File(canonicalPath), "rw");
                    } else {
                        randomAccessFile = new RandomAccessFile(this.f15603a, "rw");
                        try {
                            randomAccessFile.seek(length);
                            randomAccessFile2 = randomAccessFile;
                        } catch (IOException e9) {
                            e = e9;
                            randomAccessFile2 = randomAccessFile;
                            HMSLog.e("FileUtil", "writeFile exception:", e);
                        } catch (Throwable th2) {
                            th = th2;
                            IOUtils.closeQuietly(randomAccessFile);
                            throw th;
                        }
                    }
                    randomAccessFile2.writeBytes(this.f15605c + System.getProperty("line.separator"));
                } catch (Throwable th3) {
                    randomAccessFile = null;
                    th = th3;
                }
            } catch (IOException e10) {
                e = e10;
            }
            IOUtils.closeQuietly(randomAccessFile2);
        }
    }

    public static boolean verifyHash(String str, File file) throws Throwable {
        byte[] bArrDigest = SHA256.digest(file);
        return bArrDigest != null && HEX.encodeHexString(bArrDigest, true).equalsIgnoreCase(str);
    }

    public static void writeFile(File file, String str, long j) {
        f15602b.execute(new a(file, j, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j, int i9) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f15601a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e("FileUtil", "file delete failed.");
                }
                f15601a = true;
            }
            writeFile(file2, str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + j + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i9, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}

package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class bw {
    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + k.e();
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] bArrCopyOf = Arrays.copyOf(bj.m125a(str), 16);
        bArrCopyOf[0] = 68;
        bArrCopyOf[15] = 84;
        return bArrCopyOf;
    }

    public static String a(Context context) {
        String strA = bx.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strA2 = bm.a(20);
        bx.a(context).m138a("sp_client_report_status", "sp_client_report_key", strA2);
        return strA2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m134a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra(MTCommonConstants.Network.KEY_NAME, "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m134a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x012d  */
    public static void a(Context context, String str, String str2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        Exception e9;
        if (context == null || str == null || str2 == null) {
            return;
        }
        File file2 = new File(context.getFilesDir(), str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(context.getFilesDir(), str);
        if (!file3.exists()) {
            file3.mkdirs();
            return;
        }
        File[] fileArrListFiles = file3.listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bw.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file4, String str3) {
                return (TextUtils.isEmpty(str3) || str3.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        FileLock fileLockLock = null;
        File file4 = null;
        RandomAccessFile randomAccessFile2 = null;
        for (File file5 : fileArrListFiles) {
            if (file5 != null) {
                try {
                    if (!TextUtils.isEmpty(file5.getAbsolutePath())) {
                        file = new File(file5.getAbsolutePath() + ".lock");
                        try {
                            y.m844a(file);
                            randomAccessFile = new RandomAccessFile(file, "rw");
                            try {
                                try {
                                    fileLockLock = randomAccessFile.getChannel().lock();
                                    File file6 = new File(file2.getAbsolutePath() + File.separator + file5.getName() + jCurrentTimeMillis);
                                    try {
                                        y.b(file5, file6);
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                        file5.delete();
                                        file6.delete();
                                    }
                                    file5.delete();
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            fileLockLock.release();
                                        } catch (IOException e11) {
                                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e11);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile2 = randomAccessFile;
                                    file4 = file;
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            fileLockLock.release();
                                        } catch (IOException e12) {
                                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e12);
                                        }
                                    }
                                    y.a(randomAccessFile2);
                                    if (file4 != null) {
                                        file4.delete();
                                        throw th;
                                    }
                                    throw th;
                                }
                            } catch (Exception e13) {
                                e9 = e13;
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException e14) {
                                        com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e14);
                                    }
                                }
                                y.a(randomAccessFile);
                                if (file != null) {
                                }
                                randomAccessFile2 = randomAccessFile;
                                file4 = file;
                            }
                        } catch (Exception e15) {
                            randomAccessFile = randomAccessFile2;
                            e9 = e15;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        file.delete();
                        randomAccessFile2 = randomAccessFile;
                        file4 = file;
                    } else {
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException e16) {
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e16);
                            }
                        }
                        y.a(randomAccessFile2);
                        if (file4 != null) {
                            file4.delete();
                        }
                    }
                } catch (Exception e17) {
                    file = file4;
                    randomAccessFile = randomAccessFile2;
                    e9 = e17;
                } catch (Throwable th3) {
                    th = th3;
                }
                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    fileLockLock.release();
                }
                y.a(randomAccessFile);
                if (file != null) {
                    file.delete();
                }
                randomAccessFile2 = randomAccessFile;
                file4 = file;
            } else {
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                y.a(randomAccessFile2);
                if (file4 != null) {
                    file4.delete();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m135a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).m20a().getMaxFileLength();
        if (file.exists()) {
            try {
                return file.length() <= maxFileLength;
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                return false;
            }
        }
        y.m844a(file);
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static File[] m136a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bw.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return (TextUtils.isEmpty(str2) || str2.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
    }
}

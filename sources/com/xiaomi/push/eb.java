package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class eb extends ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f17290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Context f304a;

    public eb(Context context, int i9) {
        this.f17290a = i9;
        this.f304a = context;
    }

    private String d() {
        return "dc_job_result_" + mo133a();
    }

    public abstract hw a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m256a() {
        return dy.a(this.f304a, String.valueOf(mo133a()), this.f17290a);
    }

    public abstract String b();

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m257b() {
        return true;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m258c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (m256a()) {
            com.xiaomi.channel.commonutils.logger.c.m9a("DC run job mutual: " + mo133a());
            return;
        }
        dv dvVarM254a = dw.a().m254a();
        String strA = dvVarM254a == null ? "" : dvVarM254a.a();
        if (!TextUtils.isEmpty(strA) && m257b()) {
            if (m258c()) {
                SharedPreferences sharedPreferences = this.f304a.getSharedPreferences("mipush_extra", 0);
                if (bm.a(strB).equals(sharedPreferences.getString(d(), null))) {
                    long j = sharedPreferences.getLong(c(), 0L);
                    int iA = com.xiaomi.push.service.aq.a(this.f304a).a(hz.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.f17290a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j) / 1000 < iA) {
                        strB = defpackage.f.d(j, "same_");
                    }
                }
            }
            ic icVar = new ic();
            icVar.a(strB);
            icVar.a(System.currentTimeMillis());
            icVar.a(a());
            a(this.f304a, icVar, strA);
        }
    }

    private String c() {
        return "dc_job_result_time_" + mo133a();
    }

    public static void a(Context context, ic icVar) {
        dv dvVarM254a = dw.a().m254a();
        String strA = dvVarM254a == null ? "" : dvVarM254a.a();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(icVar.a())) {
            return;
        }
        a(context, icVar, strA);
    }

    private static void a(Context context, ic icVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] bArrB = dy.b(str, je.a(icVar));
        if (bArrB == null || bArrB.length == 0) {
            return;
        }
        synchronized (dz.f17286a) {
            FileLock fileLock = null;
            BufferedOutputStream bufferedOutputStream2 = null;
            fileLock = null;
            fileLock = null;
            fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), "push_cdata.lock");
                    y.m844a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock fileLockLock = randomAccessFile.getChannel().lock();
                        try {
                            File file2 = new File(context.getFilesDir(), "push_cdata.data");
                            if (x.m843a(file2)) {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                                try {
                                    bufferedOutputStream.write(aa.a(bArrB.length));
                                    bufferedOutputStream.write(bArrB);
                                    bufferedOutputStream.flush();
                                    file2.setLastModified(0L);
                                    bufferedOutputStream2 = bufferedOutputStream;
                                } catch (IOException e9) {
                                    e = e9;
                                    fileLock = fileLockLock;
                                    try {
                                        e.printStackTrace();
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException unused) {
                                            }
                                        }
                                        y.a(bufferedOutputStream);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        y.a(bufferedOutputStream);
                                        y.a(randomAccessFile);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileLock = fileLockLock;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    y.a(bufferedOutputStream);
                                    y.a(randomAccessFile);
                                    throw th;
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            y.a(bufferedOutputStream2);
                        } catch (IOException e10) {
                            e = e10;
                            bufferedOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e11) {
                        e = e11;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (IOException e12) {
                e = e12;
                bufferedOutputStream = null;
                randomAccessFile = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
                randomAccessFile = null;
            }
            y.a(randomAccessFile);
        }
    }
}

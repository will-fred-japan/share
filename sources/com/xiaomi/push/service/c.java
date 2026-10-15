package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f18352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1101a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile String f18356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f18357f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f1102a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f18353b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String f1103a = "mipush_region";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final String f1104b = "mipush_country_code";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18354c = "mipush_region.lock";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18355d = "mipush_country_code.lock";

    public c(Context context) {
        this.f1101a = context;
    }

    public static c a(Context context) {
        if (f18352a == null) {
            synchronized (c.class) {
                try {
                    if (f18352a == null) {
                        f18352a = new c(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18352a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f18357f)) {
            this.f18357f = a(this.f1101a, "mipush_country_code", "mipush_country_code.lock", this.f18353b);
        }
        return this.f18357f;
    }

    public void b(String str, boolean z8) {
        if (!TextUtils.equals(str, this.f18357f)) {
            this.f18357f = str;
        }
        if (z8) {
            a(this.f1101a, str, "mipush_country_code", "mipush_region.lock", this.f1102a);
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f18356e)) {
            this.f18356e = a(this.f1101a, "mipush_region", "mipush_region.lock", this.f1102a);
        }
        return this.f18356e;
    }

    public void a(String str, boolean z8) {
        if (!TextUtils.equals(str, this.f18356e)) {
            this.f18356e = str;
        }
        if (z8) {
            a(this.f1101a, str, "mipush_region", "mipush_region.lock", this.f1102a);
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLockLock = null;
            try {
                File file = new File(context.getFilesDir(), str3);
                com.xiaomi.push.y.m844a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    try {
                        fileLockLock = randomAccessFile.getChannel().lock();
                        com.xiaomi.push.y.a(new File(context.getFilesDir(), str2), str);
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException e9) {
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException e11) {
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e11);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e12) {
                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e12);
                        }
                    }
                    com.xiaomi.push.y.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e13) {
                e = e13;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                com.xiaomi.push.y.a(randomAccessFile);
                throw th;
            }
            com.xiaomi.push.y.a(randomAccessFile);
        }
    }

    private String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock = null;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.c.m9a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                com.xiaomi.push.y.m844a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    try {
                        try {
                            String strA = com.xiaomi.push.y.a(file);
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e9) {
                                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                                }
                            }
                            com.xiaomi.push.y.a(randomAccessFile);
                            return strA;
                        } catch (Exception e10) {
                            e = e10;
                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e11) {
                                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e11);
                                }
                            }
                            com.xiaomi.push.y.a(randomAccessFile);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileLock = fileLockLock;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e12) {
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e12);
                            }
                        }
                        com.xiaomi.push.y.a(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e13) {
                    e = e13;
                    fileLockLock = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    com.xiaomi.push.y.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e14) {
                e = e14;
                randomAccessFile = null;
                fileLockLock = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
            }
        }
    }
}

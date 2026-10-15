package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hy;
import com.xiaomi.push.je;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f18344a = new Object();

    public static void a(final Context context, final hy hyVar) {
        if (bl.a(hyVar.e())) {
            com.xiaomi.push.ah.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.bm.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v0 */
                /* JADX WARN: Type inference failed for: r1v11 */
                /* JADX WARN: Type inference failed for: r1v14 */
                /* JADX WARN: Type inference failed for: r1v15 */
                /* JADX WARN: Type inference failed for: r1v16 */
                /* JADX WARN: Type inference failed for: r1v17 */
                /* JADX WARN: Type inference failed for: r1v18 */
                /* JADX WARN: Type inference failed for: r1v19 */
                /* JADX WARN: Type inference failed for: r1v2, types: [java.nio.channels.FileLock] */
                /* JADX WARN: Type inference failed for: r1v20 */
                /* JADX WARN: Type inference failed for: r1v21 */
                /* JADX WARN: Type inference failed for: r1v4 */
                /* JADX WARN: Type inference failed for: r1v7 */
                @Override // java.lang.Runnable
                public void run() {
                    RandomAccessFile randomAccessFile;
                    synchronized (bm.f18344a) {
                        ?? r8 = 0;
                        fileLockLock = null;
                        FileLock fileLockLock = null;
                        r8 = 0;
                        try {
                            try {
                                File file = new File(context.getFilesDir(), "tiny_data.lock");
                                com.xiaomi.push.y.m844a(file);
                                randomAccessFile = new RandomAccessFile(file, "rw");
                                try {
                                    fileLockLock = randomAccessFile.getChannel().lock();
                                    bm.c(context, hyVar);
                                    r8 = fileLockLock;
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            r8 = fileLockLock;
                                            fileLockLock.release();
                                            r8 = fileLockLock;
                                        } catch (IOException e9) {
                                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                                            r8 = e9;
                                        }
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                                    r8 = fileLockLock;
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            r8 = fileLockLock;
                                            fileLockLock.release();
                                            r8 = fileLockLock;
                                        } catch (IOException e11) {
                                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e11);
                                            r8 = e11;
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (r8 != 0 && r8.isValid()) {
                                    try {
                                        r8.release();
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
                            if (r8 != 0) {
                                r8.release();
                            }
                            com.xiaomi.push.y.a(randomAccessFile);
                            throw th;
                        }
                        r8 = fileLockLock;
                        r8 = fileLockLock;
                        com.xiaomi.push.y.a(randomAccessFile);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, hy hyVar) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        try {
            byte[] bArrB = com.xiaomi.push.i.b(a(context), je.a(hyVar));
            if (bArrB != null && bArrB.length >= 1) {
                if (bArrB.length > 30720) {
                    com.xiaomi.channel.commonutils.logger.c.m9a("TinyData write to cache file failed case too much data content item:" + hyVar.d() + "  ts:" + System.currentTimeMillis());
                    com.xiaomi.push.y.a((Closeable) null);
                    com.xiaomi.push.y.a((Closeable) null);
                    return;
                }
                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                try {
                    bufferedOutputStream3.write(com.xiaomi.push.aa.a(bArrB.length));
                    bufferedOutputStream3.write(bArrB);
                    bufferedOutputStream3.flush();
                    com.xiaomi.push.y.a((Closeable) null);
                    com.xiaomi.push.y.a(bufferedOutputStream3);
                    return;
                } catch (IOException e9) {
                    bufferedOutputStream2 = bufferedOutputStream3;
                    e = e9;
                    try {
                        com.xiaomi.channel.commonutils.logger.c.a("TinyData write to cache file failed cause io exception item:" + hyVar.d(), e);
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a(bufferedOutputStream2);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a(bufferedOutputStream);
                        throw th;
                    }
                } catch (Exception e10) {
                    bufferedOutputStream = bufferedOutputStream3;
                    e = e10;
                    try {
                        com.xiaomi.channel.commonutils.logger.c.a("TinyData write to cache file  failed item:" + hyVar.d(), e);
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a(bufferedOutputStream);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        com.xiaomi.push.y.a((Closeable) null);
                        com.xiaomi.push.y.a(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    bufferedOutputStream = bufferedOutputStream3;
                    th = th3;
                    com.xiaomi.push.y.a((Closeable) null);
                    com.xiaomi.push.y.a(bufferedOutputStream);
                    throw th;
                }
            }
            com.xiaomi.channel.commonutils.logger.c.m9a("TinyData write to cache file failed case encryption fail item:" + hyVar.d() + "  ts:" + System.currentTimeMillis());
            com.xiaomi.push.y.a((Closeable) null);
            com.xiaomi.push.y.a((Closeable) null);
        } catch (IOException e11) {
            e = e11;
            bufferedOutputStream2 = null;
        } catch (Exception e12) {
            e = e12;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }

    public static byte[] a(Context context) {
        String strA = com.xiaomi.push.p.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(strA)) {
            strA = com.xiaomi.push.bm.a(20);
            com.xiaomi.push.p.a(context).m660a("mipush", "td_key", strA);
        }
        return a(strA);
    }

    private static byte[] a(String str) {
        byte[] bArrCopyOf = Arrays.copyOf(com.xiaomi.push.bj.m125a(str), 16);
        bArrCopyOf[0] = 68;
        bArrCopyOf[15] = 84;
        return bArrCopyOf;
    }
}

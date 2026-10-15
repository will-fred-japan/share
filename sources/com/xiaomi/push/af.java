package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class af {
    public static boolean a(Context context, String str, long j) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock = null;
        try {
            try {
                File file = new File(context.getFilesDir(), "/.vdevdir/");
                if (!x.m843a(file)) {
                    y.a((Closeable) null);
                    return true;
                }
                File file2 = new File(file, "lcfp.lock");
                y.m844a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    boolean zB = b(context, str, j);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    y.a(randomAccessFile);
                    return zB;
                } catch (IOException e9) {
                    e = e9;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0 && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException unused2) {
                    }
                }
                y.a((Closeable) null);
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                fileLockLock.release();
            }
            y.a((Closeable) null);
            throw th;
        }
        e.printStackTrace();
        if (fileLockLock != null && fileLockLock.isValid()) {
            try {
                fileLockLock.release();
            } catch (IOException unused3) {
            }
        }
        y.a(randomAccessFile);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    private static boolean b(Context context, String str, long j) throws Throwable {
        boolean z8;
        BufferedReader bufferedReader;
        File file = new File(context.getFilesDir(), "/.vdevdir/");
        ?? r8 = 1;
        if (!x.m843a(file)) {
            return true;
        }
        File file2 = new File(file, "lcfp");
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sbC = p171w.a.c(str, Constants.COLON_SEPARATOR);
        sbC.append(context.getPackageName());
        sbC.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sbC.append(jCurrentTimeMillis);
        String string = sbC.toString();
        ?? Exists = file2.exists();
        ?? r10 = 0;
        bufferedWriter = null;
        bufferedWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (Exists != 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file2));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                z8 = r8 == true ? 1 : 0;
                                break;
                            }
                            String[] strArrSplit = line.split(Constants.COLON_SEPARATOR);
                            if (strArrSplit.length == 2) {
                                String str2 = strArrSplit[0];
                                z8 = r8 == true ? 1 : 0;
                                try {
                                    if (TextUtils.equals(str2, String.valueOf(str))) {
                                        String[] strArrSplit2 = strArrSplit[z8 ? 1 : 0].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                        if (strArrSplit2.length == 2) {
                                            long j8 = Long.parseLong(strArrSplit2[z8 ? 1 : 0]);
                                            if (!TextUtils.equals(strArrSplit2[0], context.getPackageName()) && Math.abs(jCurrentTimeMillis - j8) < 1000 * j * 0.9f) {
                                                y.a(bufferedReader);
                                                return false;
                                            }
                                        }
                                    } else {
                                        arrayList.add(line);
                                    }
                                    r8 = z8 ? 1 : 0;
                                } catch (Exception unused) {
                                }
                            }
                        } catch (Exception unused2) {
                            z8 = r8 == true ? 1 : 0;
                        }
                        arrayList.clear();
                    }
                } catch (Exception unused3) {
                    z8 = true;
                    bufferedReader = null;
                } catch (Throwable th) {
                    th = th;
                    y.a((Closeable) r10);
                    throw th;
                }
                y.a(bufferedReader);
            } else {
                z8 = true;
                if (!y.m844a(file2)) {
                    return true;
                }
            }
            arrayList.add(string);
            try {
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                    try {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            bufferedWriter2.write((String) it.next());
                            bufferedWriter2.newLine();
                            bufferedWriter2.flush();
                        }
                        y.a(bufferedWriter2);
                    } catch (IOException e9) {
                        e = e9;
                        bufferedWriter = bufferedWriter2;
                        com.xiaomi.channel.commonutils.logger.c.d(e.toString());
                        y.a(bufferedWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter2;
                        y.a(bufferedWriter);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e10) {
                e = e10;
            }
            return z8;
        } catch (Throwable th4) {
            th = th4;
            r10 = Exists;
        }
    }
}

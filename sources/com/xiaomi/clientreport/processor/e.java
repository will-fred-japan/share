package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.y;
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
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(String str, com.xiaomi.clientreport.data.a[] aVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        boolean zIsValid;
        IOException iOException;
        if (aVarArr == null || aVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLockLock = null;
        try {
            File file = new File(str + ".lock");
            y.m844a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> mapM25a = m25a(str);
                for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                    if (aVar != null) {
                        String strA = a((PerfClientReport) aVar);
                        long j = ((PerfClientReport) aVar).perfCounts;
                        long j8 = ((PerfClientReport) aVar).perfLatencies;
                        if (!TextUtils.isEmpty(strA) && j > 0 && j8 >= 0) {
                            a(mapM25a, strA, j, j8);
                        }
                    }
                }
                a(str, mapM25a);
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e9) {
                        iOException = e9;
                        com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) iOException);
                    }
                }
            } catch (Throwable unused) {
                fileLock = fileLockLock;
                try {
                    com.xiaomi.channel.commonutils.logger.c.c("failed to write perf to file ");
                    if (fileLock != null) {
                        if (zIsValid) {
                            try {
                            } catch (IOException e10) {
                                iOException = e10;
                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) iOException);
                            }
                        }
                    }
                } finally {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e11) {
                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e11);
                        }
                    }
                    y.a(randomAccessFile);
                }
            }
        } catch (Throwable unused2) {
            fileLock = null;
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0050  */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x0050, please report this as an issue */
    private static void a(HashMap<String, String> map, String str, long j, long j8) {
        String str2;
        String str3 = map.get(str);
        if (TextUtils.isEmpty(str3)) {
            map.put(str, j + "#" + j8);
            return;
        }
        long[] jArrM26a = m26a(str3);
        if (jArrM26a != null) {
            long j9 = jArrM26a[0];
            if (j9 > 0) {
                long j10 = jArrM26a[1];
                if (j10 >= 0) {
                    str2 = (j + j9) + "#" + (j8 + j10);
                } else {
                    str2 = j + "#" + j8;
                }
            } else {
                str2 = j + "#" + j8;
            }
        } else {
            str2 = j + "#" + j8;
        }
        map.put(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static long[] m26a(String str) {
        long[] jArr = new long[2];
        try {
            String[] strArrSplit = str.split("#");
            if (strArrSplit.length >= 2) {
                jArr[0] = Long.parseLong(strArrSplit[0].trim());
                jArr[1] = Long.parseLong(strArrSplit[1].trim());
            }
            return jArr;
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            return null;
        }
    }

    private static void a(String str, HashMap<String, String> map) throws Throwable {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e9;
        if (TextUtils.isEmpty(str) || map == null || map.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                try {
                    for (String str2 : map.keySet()) {
                        bufferedWriter.write(str2 + "%%%" + map.get(str2));
                        bufferedWriter.newLine();
                    }
                    y.a(bufferedWriter);
                } catch (Exception e10) {
                    e9 = e10;
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                    y.a(bufferedWriter);
                }
            } catch (Throwable th2) {
                th = th2;
                y.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e11) {
            bufferedWriter = null;
            e9 = e11;
        } catch (Throwable th3) {
            bufferedWriter = null;
            th = th3;
            y.a(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static HashMap<String, String> m25a(String str) throws Throwable {
        HashMap<String, String> map = new HashMap<>();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line != null) {
                                String[] strArrSplit = line.split("%%%");
                                if (strArrSplit.length >= 2 && !TextUtils.isEmpty(strArrSplit[0]) && !TextUtils.isEmpty(strArrSplit[1])) {
                                    map.put(strArrSplit[0], strArrSplit[1]);
                                }
                            } else {
                                y.a(bufferedReader2);
                                return map;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            bufferedReader = bufferedReader2;
                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                            y.a(bufferedReader);
                            return map;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            y.a(bufferedReader);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e10) {
                e = e10;
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static List<String> a(Context context, String str) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        ?? bufferedReader;
        PerfClientReport perfClientReportA;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            FileLock fileLock = null;
            try {
                file = new File(str + ".lock");
                try {
                    y.m844a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock fileLockLock = randomAccessFile.getChannel().lock();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str));
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    String[] strArrSplit = line.split("%%%");
                                    if (strArrSplit.length >= 2 && !TextUtils.isEmpty(strArrSplit[0]) && !TextUtils.isEmpty(strArrSplit[1]) && (perfClientReportA = a(a(strArrSplit[0]), strArrSplit[1])) != null) {
                                        arrayList.add(perfClientReportA.toJsonString());
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                    fileLock = fileLockLock;
                                    bufferedReader = bufferedReader;
                                    try {
                                        com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e10) {
                                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e10);
                                            }
                                        }
                                        y.a(randomAccessFile);
                                        y.a((Closeable) bufferedReader);
                                        if (file != null) {
                                        }
                                        return arrayList;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e11) {
                                                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e11);
                                            }
                                        }
                                        y.a(randomAccessFile);
                                        y.a((Closeable) bufferedReader);
                                        if (file != null) {
                                            file.delete();
                                            throw th;
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileLock = fileLockLock;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    y.a(randomAccessFile);
                                    y.a((Closeable) bufferedReader);
                                    if (file != null) {
                                        file.delete();
                                        throw th;
                                    }
                                    throw th;
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e12) {
                                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e12);
                                }
                            }
                            y.a(randomAccessFile);
                            y.a((Closeable) bufferedReader);
                        } catch (Exception e13) {
                            e = e13;
                            bufferedReader = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = 0;
                        }
                    } catch (Exception e14) {
                        e = e14;
                        bufferedReader = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = 0;
                    }
                } catch (Exception e15) {
                    e = e15;
                    randomAccessFile = null;
                    bufferedReader = randomAccessFile;
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    y.a(randomAccessFile);
                    y.a((Closeable) bufferedReader);
                    if (file != null) {
                        file.delete();
                    }
                    return arrayList;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = null;
                    bufferedReader = randomAccessFile;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    y.a(randomAccessFile);
                    y.a((Closeable) bufferedReader);
                    if (file != null) {
                        file.delete();
                        throw th;
                    }
                    throw th;
                }
            } catch (Exception e16) {
                e = e16;
                file = null;
                randomAccessFile = null;
            } catch (Throwable th6) {
                th = th6;
                file = null;
                randomAccessFile = null;
            }
            file.delete();
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String[] m27a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }

    private static PerfClientReport a(String str) {
        PerfClientReport blankInstance = null;
        try {
            String[] strArrM27a = m27a(str);
            if (strArrM27a == null || strArrM27a.length < 4 || TextUtils.isEmpty(strArrM27a[0]) || TextUtils.isEmpty(strArrM27a[1]) || TextUtils.isEmpty(strArrM27a[2]) || TextUtils.isEmpty(strArrM27a[3])) {
                return null;
            }
            blankInstance = PerfClientReport.getBlankInstance();
            blankInstance.production = Integer.parseInt(strArrM27a[0]);
            blankInstance.clientInterfaceId = strArrM27a[1];
            blankInstance.reportType = Integer.parseInt(strArrM27a[2]);
            blankInstance.code = Integer.parseInt(strArrM27a[3]);
            return blankInstance;
        } catch (Exception unused) {
            com.xiaomi.channel.commonutils.logger.c.c("parse per key error");
            return blankInstance;
        }
    }

    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] jArrM26a;
        if (perfClientReport == null || (jArrM26a = m26a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = jArrM26a[0];
        perfClientReport.perfLatencies = jArrM26a[1];
        return perfClientReport;
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }
}

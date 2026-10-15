package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dt implements LoggerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile dt f17280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f17281b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final SimpleDateFormat f293a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f292a = "/MiPushLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<Pair<String, Throwable>> f294a = Collections.synchronizedList(new ArrayList());

    private dt(Context context) {
        this.f295a = context;
        if (context.getApplicationContext() != null) {
            this.f295a = context.getApplicationContext();
        }
        this.f17281b = this.f295a.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f296a = new Handler(handlerThread.getLooper());
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.f17281b = str;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(final String str, final Throwable th) {
        this.f296a.post(new Runnable() { // from class: com.xiaomi.push.dt.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                dt.f294a.add(new Pair(String.format("%1$s %2$s %3$s ", dt.f293a.format(new Date()), dt.this.f17281b, str), th));
                if (dt.f294a.size() > 20000) {
                    int size = dt.f294a.size() - 19950;
                    for (int i9 = 0; i9 < size; i9++) {
                        try {
                            if (dt.f294a.size() > 0) {
                                dt.f294a.remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    dt.f294a.add(new Pair(String.format("%1$s %2$s %3$s ", dt.f293a.format(new Date()), dt.this.f17281b, defpackage.f.b(size, "flush ", " lines logs.")), null));
                }
                try {
                    dt.this.m252a();
                } catch (Exception e9) {
                    Log.e(dt.this.f17281b, "", e9);
                }
            }
        });
    }

    public static dt a(Context context) {
        if (f17280a == null) {
            synchronized (dt.class) {
                try {
                    if (f17280a == null) {
                        f17280a = new dt(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17280a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m252a() throws Throwable {
        FileLock fileLockLock;
        RandomAccessFile randomAccessFile;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                File file = new File(this.f295a.getFilesDir(), f292a);
                if (!x.m843a(file)) {
                    Log.w(this.f17281b, "Cannot wirte internal file: " + file);
                    return;
                }
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                    Log.w(this.f17281b, "Create mipushlog directory fail.");
                    return;
                }
                File file2 = new File(file, "log.lock");
                if (!file2.exists() || file2.isDirectory()) {
                    file2.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    try {
                        try {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                            while (!f294a.isEmpty()) {
                                try {
                                    Pair<String, Throwable> pairRemove = f294a.remove(0);
                                    String str = (String) pairRemove.first;
                                    if (pairRemove.second != null) {
                                        str = (str + "\n") + Log.getStackTraceString((Throwable) pairRemove.second);
                                    }
                                    bufferedWriter2.write(str + "\n");
                                } catch (Exception e9) {
                                    e = e9;
                                    bufferedWriter = bufferedWriter2;
                                    Log.e(this.f17281b, "", e);
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e10) {
                                            Log.e(this.f17281b, "", e10);
                                        }
                                    }
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            fileLockLock.release();
                                        } catch (IOException e11) {
                                            Log.e(this.f17281b, "", e11);
                                        }
                                    }
                                    if (randomAccessFile == null) {
                                        return;
                                    } else {
                                        randomAccessFile.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedWriter = bufferedWriter2;
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e12) {
                                            Log.e(this.f17281b, "", e12);
                                        }
                                    }
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            fileLockLock.release();
                                        } catch (IOException e13) {
                                            Log.e(this.f17281b, "", e13);
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                            throw th;
                                        } catch (IOException e14) {
                                            Log.e(this.f17281b, "", e14);
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            bufferedWriter2.flush();
                            bufferedWriter2.close();
                            File file3 = new File(file, "log1.txt");
                            if (file3.length() >= Config.DEFAULT_MAX_FILE_LENGTH) {
                                File file4 = new File(file, "log0.txt");
                                if (file4.exists() && file4.isFile()) {
                                    file4.delete();
                                }
                                file3.renameTo(file4);
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e15) {
                                    Log.e(this.f17281b, "", e15);
                                }
                            }
                            randomAccessFile.close();
                        } catch (Exception e16) {
                            e = e16;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e17) {
                    e = e17;
                    fileLockLock = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLockLock = null;
                }
            } catch (IOException e18) {
                Log.e(this.f17281b, "", e18);
            }
        } catch (Exception e19) {
            e = e19;
            fileLockLock = null;
            randomAccessFile = null;
        } catch (Throwable th4) {
            th = th4;
            fileLockLock = null;
            randomAccessFile = null;
        }
    }
}

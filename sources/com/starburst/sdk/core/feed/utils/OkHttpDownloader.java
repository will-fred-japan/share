package com.starburst.sdk.core.feed.utils;

import android.content.Context;
import com.starburst.sdk.common.okhttp.OkHttpUtils;
import com.starburst.sdk.utils.d;
import com.starburst.sdk.utils.j;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class OkHttpDownloader {
    private static final String TAG = "lishunOkHttpDownloader";
    private static volatile OkHttpDownloader instance;
    private final File baseDir;
    private final OkHttpClient client;
    private final ExecutorService executor;
    private final ConcurrentHashMap<String, DownloadStatus> taskStatusMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, DownloadTask> pendingTasks = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.starburst.sdk.core.feed.utils.OkHttpDownloader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$starburst$sdk$core$feed$utils$OkHttpDownloader$DownloadStatus;

        static {
            int[] iArr = new int[DownloadStatus.values().length];
            $SwitchMap$com$starburst$sdk$core$feed$utils$OkHttpDownloader$DownloadStatus = iArr;
            try {
                iArr[DownloadStatus.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$starburst$sdk$core$feed$utils$OkHttpDownloader$DownloadStatus[DownloadStatus.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$starburst$sdk$core$feed$utils$OkHttpDownloader$DownloadStatus[DownloadStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface DownloadListener {
        void onCancel(String str, File file);

        void onFailure(String str, File file, Throwable th);

        void onProgress(String str, long j, long j8);

        void onStart(String str, File file);

        void onSuccess(String str, File file);
    }

    public enum DownloadStatus {
        PENDING,
        RUNNING,
        COMPLETED,
        FAILED
    }

    public class DownloadTask implements Runnable, Comparable<DownloadTask> {
        private Call call;
        private final DownloadListener listener;
        final int priority;
        final File targetFile;
        private final String taskKey;
        final String url;

        public DownloadTask(String str, File file, int i9, DownloadListener downloadListener, String str2) {
            this.url = str;
            this.targetFile = file;
            this.priority = i9;
            this.listener = downloadListener;
            this.taskKey = str2;
        }

        private void cleanupFailedFile() {
            if (!this.targetFile.exists() || this.targetFile.delete()) {
                return;
            }
            j.x(OkHttpDownloader.TAG, "Failed to delete corrupted file: " + this.targetFile);
        }

        @Override // java.lang.Comparable
        public int compareTo(DownloadTask downloadTask) {
            return Integer.compare(downloadTask.priority, this.priority);
        }

        /* JADX WARN: Code duplicated, block: B:110:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:123:? A[Catch: all -> 0x009a, SYNTHETIC, TryCatch #7 {all -> 0x009a, blocks: (B:18:0x0077, B:20:0x007d, B:22:0x0085, B:24:0x008b, B:27:0x0092, B:28:0x0099, B:31:0x009e, B:51:0x0102, B:73:0x0128, B:72:0x0125, B:74:0x0129, B:75:0x013a, B:69:0x0120, B:32:0x00ae, B:50:0x00ff, B:67:0x011d, B:66:0x011a), top: B:116:0x0077, inners: #4, #10 }] */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (OkHttpDownloader.this.taskStatusMap) {
                try {
                    if (OkHttpDownloader.this.taskStatusMap.get(this.taskKey) != DownloadStatus.PENDING) {
                        j.f(OkHttpDownloader.TAG, "任务已被取消: " + this.taskKey);
                        return;
                    }
                    OkHttpDownloader.this.taskStatusMap.put(this.taskKey, DownloadStatus.RUNNING);
                    OkHttpDownloader.this.pendingTasks.remove(this.taskKey);
                    DownloadListener downloadListener = this.listener;
                    if (downloadListener != null) {
                        downloadListener.onStart(this.url, this.targetFile);
                    }
                    Call callNewCall = OkHttpDownloader.this.client.newCall(new Request.Builder().url(this.url).build());
                    this.call = callNewCall;
                    try {
                        try {
                            Response responseExecute = callNewCall.execute();
                            try {
                                if (!responseExecute.isSuccessful()) {
                                    throw new IOException("Unexpected code " + responseExecute);
                                }
                                File parentFile = this.targetFile.getParentFile();
                                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                                    throw new IOException("Failed to create directories");
                                }
                                long jContentLength = responseExecute.body().contentLength();
                                InputStream inputStreamByteStream = responseExecute.body().byteStream();
                                try {
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.targetFile));
                                    try {
                                        byte[] bArr = new byte[8192];
                                        long j = 0;
                                        while (true) {
                                            int i9 = inputStreamByteStream.read(bArr);
                                            if (i9 == -1) {
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, i9);
                                            long j8 = ((long) i9) + j;
                                            DownloadListener downloadListener2 = this.listener;
                                            if (downloadListener2 != null) {
                                                downloadListener2.onProgress(this.url, j8, jContentLength);
                                            }
                                            j = j8;
                                            if (inputStreamByteStream != null) {
                                                throw th;
                                            }
                                            try {
                                                inputStreamByteStream.close();
                                                throw th;
                                            } catch (Throwable th) {
                                                th.addSuppressed(th);
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        DownloadListener downloadListener3 = this.listener;
                                        if (downloadListener3 != null) {
                                            downloadListener3.onSuccess(this.url, this.targetFile);
                                        }
                                        synchronized (OkHttpDownloader.this.taskStatusMap) {
                                            try {
                                                OkHttpDownloader.this.taskStatusMap.put(this.taskKey, DownloadStatus.COMPLETED);
                                            } catch (Throwable th2) {
                                                throw th2;
                                            }
                                        }
                                        bufferedOutputStream.close();
                                        inputStreamByteStream.close();
                                        responseExecute.close();
                                        OkHttpDownloader.this.pendingTasks.remove(this.taskKey);
                                    } catch (Throwable th3) {
                                        try {
                                            bufferedOutputStream.close();
                                            throw th3;
                                        } catch (Throwable th4) {
                                            th3.addSuppressed(th4);
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    if (inputStreamByteStream != null) {
                                        throw th5;
                                    }
                                    inputStreamByteStream.close();
                                    throw th5;
                                }
                            } catch (Throwable th6) {
                                if (responseExecute == null) {
                                    throw th6;
                                }
                                try {
                                    responseExecute.close();
                                    throw th6;
                                } catch (Throwable th7) {
                                    th6.addSuppressed(th7);
                                    throw th6;
                                }
                            }
                        } catch (IOException e9) {
                            cleanupFailedFile();
                            if (this.call.isCanceled()) {
                                DownloadListener downloadListener4 = this.listener;
                                if (downloadListener4 != null) {
                                    downloadListener4.onCancel(this.url, this.targetFile);
                                }
                            } else {
                                DownloadListener downloadListener5 = this.listener;
                                if (downloadListener5 != null) {
                                    downloadListener5.onFailure(this.url, this.targetFile, e9);
                                }
                            }
                            j.f(OkHttpDownloader.TAG, "Download failed: " + this.url);
                            e9.printStackTrace();
                            synchronized (OkHttpDownloader.this.taskStatusMap) {
                                OkHttpDownloader.this.taskStatusMap.put(this.taskKey, DownloadStatus.FAILED);
                            }
                        }
                    } catch (Throwable th8) {
                        OkHttpDownloader.this.pendingTasks.remove(this.taskKey);
                        throw th8;
                    }
                } catch (Throwable th9) {
                    throw th9;
                }
            }
        }
    }

    private OkHttpDownloader(Context context, File file) {
        if (file == null) {
            d.a(context);
            file = new File(d.a(context), "feedcache");
        }
        this.baseDir = validateDirectory(file);
        new Dispatcher().setMaxRequestsPerHost(5);
        this.client = OkHttpUtils.getInstance().getOkHttpClient();
        this.executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 2, 60L, TimeUnit.SECONDS, new PriorityBlockingQueue(64, new a()), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    private String generateTaskKey(String str, String str2) {
        return p171w.a.a(str, "::", str2);
    }

    public static OkHttpDownloader getInstance(Context context, File file) {
        if (instance == null) {
            synchronized (OkHttpDownloader.class) {
                try {
                    if (instance == null) {
                        instance = new OkHttpDownloader(context, file);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$0(Runnable runnable, Runnable runnable2) {
        return ((DownloadTask) runnable2).priority - ((DownloadTask) runnable).priority;
    }

    private static File validateDirectory(File file) {
        if (!file.exists() && !file.mkdirs()) {
            throw new IllegalArgumentException("Cannot create directory: " + file);
        }
        if (file.isDirectory()) {
            return file;
        }
        throw new IllegalArgumentException("Path is not a directory: " + file);
    }

    public void download(String str, String str2, int i9) throws Throwable {
        download(str, str2, i9, null);
    }

    public void downloadUrgent(String str, String str2, DownloadListener downloadListener) {
        download(str, str2, Integer.MAX_VALUE, downloadListener);
    }

    public File getBaseDir() {
        return this.baseDir;
    }

    public boolean isDownloading(String str, String str2) {
        boolean z8;
        String strGenerateTaskKey = generateTaskKey(str, str2);
        synchronized (this.taskStatusMap) {
            try {
                DownloadStatus downloadStatus = this.taskStatusMap.get(strGenerateTaskKey);
                z8 = downloadStatus == DownloadStatus.RUNNING || downloadStatus == DownloadStatus.PENDING;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z8;
    }

    public void shutdown() {
        this.executor.shutdown();
        try {
            if (!this.executor.awaitTermination(5L, TimeUnit.SECONDS)) {
                this.executor.shutdownNow();
            }
        } catch (InterruptedException unused) {
            this.executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        this.client.dispatcher().executorService().shutdown();
        this.client.connectionPool().evictAll();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:32:0x00a2
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void download(java.lang.String r11, java.lang.String r12, int r13, com.starburst.sdk.core.feed.utils.OkHttpDownloader.DownloadListener r14) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "文件已存在: "
            java.lang.String r1 = "任务已在等待队列: "
            java.lang.String r2 = "任务正在下载中: "
            java.lang.String r9 = r10.generateTaskKey(r11, r12)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadStatus> r3 = r10.taskStatusMap
            monitor-enter(r3)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadStatus> r4 = r10.taskStatusMap     // Catch: java.lang.Throwable -> L9d
            boolean r4 = r4.containsKey(r9)     // Catch: java.lang.Throwable -> L9d
            if (r4 == 0) goto L7a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadStatus> r4 = r10.taskStatusMap     // Catch: java.lang.Throwable -> L52
            java.lang.Object r4 = r4.get(r9)     // Catch: java.lang.Throwable -> L52
            com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadStatus r4 = (com.starburst.sdk.core.feed.utils.OkHttpDownloader.DownloadStatus) r4     // Catch: java.lang.Throwable -> L52
            int[] r5 = com.starburst.sdk.core.feed.utils.OkHttpDownloader.AnonymousClass1.$SwitchMap$com$starburst$sdk$core$feed$utils$OkHttpDownloader$DownloadStatus     // Catch: java.lang.Throwable -> L52
            int r4 = r4.ordinal()     // Catch: java.lang.Throwable -> L52
            r4 = r5[r4]     // Catch: java.lang.Throwable -> L52
            r5 = 1
            if (r4 == r5) goto L68
            r2 = 2
            if (r4 == r2) goto L56
            r1 = 3
            if (r4 == r1) goto L32
            goto L7a
        L32:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L52
            java.io.File r2 = r10.baseDir     // Catch: java.lang.Throwable -> L52
            r1.<init>(r2, r12)     // Catch: java.lang.Throwable -> L52
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L7a
            java.lang.String r11 = "lishunOkHttpDownloader"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r13.<init>(r0)     // Catch: java.lang.Throwable -> L52
            r13.append(r12)     // Catch: java.lang.Throwable -> L52
            java.lang.String r12 = r13.toString()     // Catch: java.lang.Throwable -> L52
            com.starburst.sdk.utils.j.f(r11, r12)     // Catch: java.lang.Throwable -> L52
        L50:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L52
            return
        L52:
            r0 = move-exception
            r11 = r0
            r4 = r10
            goto La0
        L56:
            java.lang.String r11 = "lishunOkHttpDownloader"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r12.<init>(r1)     // Catch: java.lang.Throwable -> L52
            r12.append(r9)     // Catch: java.lang.Throwable -> L52
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L52
            com.starburst.sdk.utils.j.f(r11, r12)     // Catch: java.lang.Throwable -> L52
            goto L50
        L68:
            java.lang.String r11 = "lishunOkHttpDownloader"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r12.<init>(r2)     // Catch: java.lang.Throwable -> L52
            r12.append(r9)     // Catch: java.lang.Throwable -> L52
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L52
            com.starburst.sdk.utils.j.f(r11, r12)     // Catch: java.lang.Throwable -> L52
            goto L50
        L7a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadStatus> r0 = r10.taskStatusMap     // Catch: java.lang.Throwable -> L9d
            com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadStatus r1 = com.starburst.sdk.core.feed.utils.OkHttpDownloader.DownloadStatus.PENDING     // Catch: java.lang.Throwable -> L9d
            r0.put(r9, r1)     // Catch: java.lang.Throwable -> L9d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L9d
            com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadTask r3 = new com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadTask
            java.io.File r6 = new java.io.File
            java.io.File r0 = r10.baseDir
            r6.<init>(r0, r12)
            r4 = r10
            r5 = r11
            r7 = r13
            r8 = r14
            r3.<init>(r5, r6, r7, r8, r9)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadTask> r11 = r4.pendingTasks
            r11.put(r9, r3)
            java.util.concurrent.ExecutorService r11 = r4.executor
            r11.execute(r3)
            return
        L9d:
            r0 = move-exception
            r4 = r10
        L9f:
            r11 = r0
        La0:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La2
            throw r11
        La2:
            r0 = move-exception
            goto L9f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.starburst.sdk.core.feed.utils.OkHttpDownloader.download(java.lang.String, java.lang.String, int, com.starburst.sdk.core.feed.utils.OkHttpDownloader$DownloadListener):void");
    }
}

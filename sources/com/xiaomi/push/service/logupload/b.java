package com.xiaomi.push.service.logupload;

import A.f;
import W5.e;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.framework.common.BundleUtil;
import com.xiaomi.push.bz;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http.StatusLine;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18367a = 306;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f1112a;

    public static class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18368a;

        public a(int i9, String str) {
            super(str);
            this.f18368a = i9;
        }

        public int a() {
            return this.f18368a;
        }
    }

    public b(Context context) {
        this.f1112a = context;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m789a() {
        return this.f18367a;
    }

    public File a(String str, long j, long j8, bz bzVar) {
        this.f18367a = 306;
        if (TextUtils.isEmpty(str) || j <= 0) {
            com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "retrievalId or timestamp is empty when compressLogs");
            this.f18367a = 301;
            return null;
        }
        if (j8 <= 0) {
            com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "invalid maxSize: " + j8 + "when compressLogs");
            this.f18367a = 301;
            return null;
        }
        List<String> listA = a();
        if (listA.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "log paths are empty when compressLogs");
            this.f18367a = 303;
            return null;
        }
        File cacheDir = this.f1112a.getCacheDir();
        if (cacheDir == null || !cacheDir.exists()) {
            com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "cache directory not available when compressLogs");
            this.f18367a = StatusLine.HTTP_PERM_REDIRECT;
            return null;
        }
        File file = new File(cacheDir, "push_log_upload");
        if (!file.exists() && !file.mkdirs()) {
            com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "failed to create upload dir when compressLogs");
            this.f18367a = StatusLine.HTTP_PERM_REDIRECT;
            return null;
        }
        a(file);
        File file2 = new File(file, str + BundleUtil.UNDERLINE_TAG + j + ".zip");
        try {
            if (listA.size() == 1) {
                a(listA.get(0), file2);
            } else {
                a(listA, j, file, file2, bzVar);
            }
            if (!file2.exists()) {
                com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "zip file not created");
                this.f18367a = 306;
                return null;
            }
            long length = file2.length();
            if (length == 0) {
                com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "zip file is zero byte");
                file2.delete();
                this.f18367a = 306;
                return null;
            }
            bzVar.b(3006);
            if (length <= j8) {
                return file2;
            }
            com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "zip exceeds limit: " + length + " > " + j8);
            file2.delete();
            this.f18367a = StatusLine.HTTP_TEMP_REDIRECT;
            return null;
        } catch (a e9) {
            com.xiaomi.channel.commonutils.logger.c.c("LogFileProcessor", "compress failed with code " + e9.a() + ": " + e9.getMessage());
            if (file2.exists()) {
                file2.delete();
            }
            this.f18367a = e9.a();
            return null;
        } catch (Exception e10) {
            com.xiaomi.channel.commonutils.logger.c.c("LogFileProcessor", "compress failed with unexpected exception: " + e10.getMessage());
            if (file2.exists()) {
                file2.delete();
            }
            this.f18367a = 306;
            return null;
        } catch (OutOfMemoryError e11) {
            com.xiaomi.channel.commonutils.logger.c.c("LogFileProcessor", "compress OOM: " + e11.getMessage());
            if (file2.exists()) {
                file2.delete();
            }
            this.f18367a = 306;
            return null;
        }
    }

    private void a(String str, File file) throws a {
        File[] fileArrListFiles;
        File file2 = new File(str);
        if (file2.exists()) {
            if (file2.isDirectory() && ((fileArrListFiles = file2.listFiles()) == null || fileArrListFiles.length == 0)) {
                com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "No files in directory when compressSinglePath: " + str);
                throw new a(304, e.l("No files in source directory: ", str));
            }
            try {
                com.xiaomi.push.service.logupload.a.a(file2, file);
                return;
            } catch (Exception e9) {
                throw new a(306, f.h(e9, new StringBuilder("Zip directory failed: ")));
            }
        }
        throw new a(303, e.l("Source not exist: ", str));
    }

    private void a(List<String> list, long j, File file, File file2, bz bzVar) throws a {
        if (list != null && !list.isEmpty()) {
            File file3 = new File(file, defpackage.f.d(j, "temp_"));
            try {
                try {
                    try {
                        if (!file3.mkdirs()) {
                            throw new a(305, "Failed to create temp dir: " + file3.getAbsolutePath());
                        }
                        int i9 = 0;
                        int i10 = 0;
                        for (String str : list) {
                            File file4 = new File(str);
                            if (file4.exists()) {
                                i9++;
                                try {
                                    com.xiaomi.push.service.logupload.a.b(file4, file3);
                                    i10++;
                                } catch (Exception e9) {
                                    com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "copy failed, skipped: " + str + ", error: " + e9.getMessage());
                                }
                            } else {
                                com.xiaomi.channel.commonutils.logger.c.m10a("LogFileProcessor", "source not exist when compressMultiplePaths: " + str);
                            }
                        }
                        if (i9 == 0) {
                            throw new a(304, "All source paths not exist when compressMultiplePaths");
                        }
                        if (i10 != 0) {
                            File[] fileArrListFiles = file3.listFiles();
                            if (fileArrListFiles != null) {
                                if (fileArrListFiles.length != 0) {
                                    if (bzVar != null) {
                                        try {
                                            bzVar.b(3005);
                                        } catch (RemoteException e10) {
                                            com.xiaomi.channel.commonutils.logger.c.c("LogFileProcessor", "report status failed when compressMultiplePaths: " + e10.getMessage());
                                        }
                                    }
                                    try {
                                        com.xiaomi.push.service.logupload.a.a(file3, file2);
                                        com.xiaomi.push.service.logupload.a.b(file3);
                                        return;
                                    } catch (Exception e11) {
                                        throw new a(306, "Zip directory failed: " + e11.getMessage());
                                    }
                                }
                                throw new a(304, "After copying, no files in temp dir, copiedCount: " + i10);
                            }
                            throw new a(StatusLine.HTTP_PERM_REDIRECT, "Cannot access to temp dir: " + file3.getAbsolutePath());
                        }
                        throw new a(305, "Failed to copy to temp dir when compressMultiplePaths. copiedCount: " + i10);
                    } catch (Throwable th) {
                        com.xiaomi.push.service.logupload.a.b(file3);
                        throw th;
                    }
                } catch (a e12) {
                    throw e12;
                }
            } catch (Exception e13) {
                throw new a(305, "Compress multiple paths failed: " + e13.getMessage());
            }
        }
        throw new a(303, "paths is empty when compressMultiplePaths.");
    }

    private List<String> a() {
        ArrayList arrayList = new ArrayList();
        try {
            String string = this.f1112a.getSharedPreferences("mipush_log_upload_config", 0).getString("log_paths", null);
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                    String strOptString = jSONArray.optString(i9);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                    }
                }
            }
        } catch (Exception e9) {
            com.xiaomi.channel.commonutils.logger.c.c("LogFileProcessor", "read log paths from SP failed: " + e9.getMessage());
        }
        return arrayList;
    }

    private void a(File file) {
        com.xiaomi.push.service.logupload.a.a(file);
    }
}

package com.xiaomi.push.service.logupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(File file, File file2) throws IOException {
        if (file == null || !file.exists()) {
            throw new IOException("Source not exist: " + file + "when zipDirectory");
        }
        if (!file.isDirectory()) {
            c(file, file2);
            return;
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
        try {
            a(file, file, zipOutputStream);
            zipOutputStream.close();
        } catch (Throwable th) {
            try {
                zipOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void b(File file, File file2) throws IOException {
        if (file == null || !file.exists()) {
            com.xiaomi.channel.commonutils.logger.c.m10a("FileOperationHelper", "source not exist: " + file + "when copyToDirectory");
            return;
        }
        if (!file2.exists() && !file2.mkdirs()) {
            throw new IOException("Failed to create target dir: " + file2 + file + "when copyToDirectory");
        }
        File file3 = new File(file2, file.getName());
        if (file.isDirectory()) {
            e(file, file3);
        } else {
            d(file, file3);
        }
    }

    private static void c(File file, File file2) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                byte[] bArr = new byte[8192];
                while (true) {
                    int i9 = fileInputStream.read(bArr);
                    if (i9 <= 0) {
                        zipOutputStream.closeEntry();
                        fileInputStream.close();
                        zipOutputStream.close();
                        return;
                    }
                    zipOutputStream.write(bArr, 0, i9);
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            zipOutputStream.close();
            throw th4;
        }
    }

    private static void d(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                fileInputStream.getChannel().transferTo(0L, fileInputStream.getChannel().size(), fileOutputStream.getChannel());
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            try {
                fileInputStream.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    private static void e(File file, File file2) throws IOException {
        if (!file2.exists() && !file2.mkdirs()) {
            throw new IOException("Failed to create directory: " + file2);
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            if (file3 != null) {
                File file4 = new File(file2, file3.getName());
                if (file3.isDirectory()) {
                    e(file3, file4);
                } else {
                    d(file3, file4);
                }
            }
        }
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && !b(file)) {
            com.xiaomi.channel.commonutils.logger.c.m10a("FileOperationHelper", "Failed to delete folder: " + file);
            return false;
        }
        if (file.mkdirs() || file.exists()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.c.m10a("FileOperationHelper", "Failed to create folder: " + file);
        return false;
    }

    public static boolean b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!b(file2)) {
                    com.xiaomi.channel.commonutils.logger.c.m10a("FileOperationHelper", "failed to delete: " + file2);
                }
            }
        }
        boolean zDelete = file.delete();
        if (!zDelete) {
            com.xiaomi.channel.commonutils.logger.c.m10a("FileOperationHelper", "failed to delete: " + file);
        }
        return zDelete;
    }

    private static void a(File file, File file2, ZipOutputStream zipOutputStream) throws IOException {
        File[] fileArrListFiles = file2.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            if (file3.isDirectory()) {
                a(file, file3, zipOutputStream);
            } else {
                zipOutputStream.putNextEntry(new ZipEntry(file.toURI().relativize(file3.toURI()).getPath()));
                FileInputStream fileInputStream = new FileInputStream(file3);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i9 = fileInputStream.read(bArr);
                        if (i9 <= 0) {
                            break;
                        } else {
                            zipOutputStream.write(bArr, 0, i9);
                        }
                    }
                    fileInputStream.close();
                    zipOutputStream.closeEntry();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
    }
}

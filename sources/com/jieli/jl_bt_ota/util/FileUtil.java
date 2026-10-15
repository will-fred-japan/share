package com.jieli.jl_bt_ota.util;

import A.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileUtil {
    public static final int FILE_TYPE_PIC = 1;
    public static final int FILE_TYPE_UNKNOWN = 0;
    public static final int FILE_TYPE_VIDEO = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16327a = "FileUtil";

    private static String a(Context context) {
        File externalFilesDir;
        return (Build.VERSION.SDK_INT < 29 || context == null || (externalFilesDir = context.getExternalFilesDir(null)) == null) ? Environment.getExternalStorageDirectory().getPath() : externalFilesDir.getPath();
    }

    public static boolean bitmapToFile(Bitmap bitmap, String str, int i9) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i9, fileOutputStream);
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                        return true;
                    } catch (IOException e10) {
                        e = e10;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        }
        return false;
    }

    public static boolean bytesToFile(byte[] bArr, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bArr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    fileOutputStream.write(bArr);
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        return true;
                    }
                } catch (IOException e10) {
                    e = e10;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream2 == null) {
                        return false;
                    }
                    try {
                        fileOutputStream2.close();
                        return false;
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        } catch (IOException e13) {
            e = e13;
        }
    }

    public static boolean checkFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0078 A[Catch: IOException -> 0x0092, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x0092, blocks: (B:30:0x004b, B:52:0x0078, B:62:0x008e), top: B:81:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:62:0x008e A[Catch: IOException -> 0x0092, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x0092, blocks: (B:30:0x004b, B:52:0x0078, B:62:0x008e), top: B:81:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:78:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static void copyFromAssetsToSdcard(Context context, boolean z8, String str, String str2) throws Throwable {
        IOException e9;
        FileNotFoundException e10;
        FileOutputStream fileOutputStream;
        IOException e11;
        FileNotFoundException e12;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str2);
        if (!z8 && (z8 || file.exists())) {
            return;
        }
        try {
            try {
                try {
                    context = context.getResources().getAssets().open(str);
                    try {
                        fileOutputStream = new FileOutputStream(str2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i9 = context.read(bArr, 0, 1024);
                                if (i9 >= 0) {
                                    fileOutputStream.write(bArr, 0, i9);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e13) {
                                        e13.printStackTrace();
                                    }
                                }
                            }
                            fileOutputStream.close();
                            context.close();
                        } catch (FileNotFoundException e14) {
                            e12 = e14;
                            e12.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            if (context == 0) {
                            } else {
                                context.close();
                            }
                        } catch (IOException e16) {
                            e11 = e16;
                            e11.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            if (context == 0) {
                            } else {
                                context.close();
                            }
                        }
                    } catch (FileNotFoundException e18) {
                        e10 = e18;
                        FileNotFoundException fileNotFoundException = e10;
                        fileOutputStream = null;
                        e12 = fileNotFoundException;
                        e12.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (context == 0) {
                            context.close();
                        }
                    } catch (IOException e19) {
                        e9 = e19;
                        IOException iOException = e9;
                        fileOutputStream = null;
                        e11 = iOException;
                        e11.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (context == 0) {
                            context.close();
                        }
                    } catch (Throwable th) {
                        str = 0;
                        th = th;
                        if (str != 0) {
                            try {
                                str.close();
                            } catch (IOException e20) {
                                e20.printStackTrace();
                            }
                        }
                        if (context == 0) {
                            throw th;
                        }
                        try {
                            context.close();
                            throw th;
                        } catch (IOException e21) {
                            e21.printStackTrace();
                            throw th;
                        }
                    }
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            } catch (FileNotFoundException e23) {
                e10 = e23;
                context = 0;
            } catch (IOException e24) {
                e9 = e24;
                context = 0;
            } catch (Throwable th2) {
                str = 0;
                th = th2;
                context = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void deleteFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            if (file.delete()) {
                JL_Log.i(f16327a, "deleteFile", "delete file success!");
                return;
            }
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                if (file.delete()) {
                    JL_Log.i(f16327a, "deleteFile", "delete empty file success!");
                    return;
                }
                return;
            }
            for (File file2 : fileArrListFiles) {
                deleteFile(file2);
            }
            if (file.delete()) {
                JL_Log.i(f16327a, "deleteFile", "delete empty file success!");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:88:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.FileInputStream] */
    public static byte[] getBytes(String str) throws Throwable {
        Throwable th;
        IOException e9;
        ByteArrayOutputStream byteArrayOutputStream;
        FileNotFoundException e10;
        Throwable th2;
        byte[] byteArray = null;
        ?? r8 = 0;
        byteArray = null;
        byteArray = null;
        if (str == 0 || str.isEmpty()) {
            return null;
        }
        File file = new File((String) str);
        try {
            try {
                try {
                    str = new FileInputStream(file);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i9 = str.read(bArr);
                                if (i9 != -1) {
                                    byteArrayOutputStream.write(bArr, 0, i9);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                    }
                                }
                            }
                            byteArrayOutputStream.close();
                            byteArray = byteArrayOutputStream.toByteArray();
                            str.close();
                        } catch (FileNotFoundException e12) {
                            e10 = e12;
                            e10.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                                byteArray = byteArrayOutputStream.toByteArray();
                            }
                            if (str != 0) {
                                str.close();
                            }
                            return byteArray;
                        } catch (IOException e14) {
                            e9 = e14;
                            e9.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                                byteArray = byteArrayOutputStream.toByteArray();
                            }
                            if (str != 0) {
                                str.close();
                            }
                            return byteArray;
                        }
                    } catch (FileNotFoundException e16) {
                        e10 = e16;
                        byteArrayOutputStream = null;
                    } catch (IOException e17) {
                        e9 = e17;
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (r8 != 0) {
                            try {
                                r8.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                            r8.toByteArray();
                        }
                        if (str != 0) {
                            try {
                                str.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    File file2 = file;
                    th2 = th;
                    r8 = file2;
                    if (r8 != 0) {
                        r8.close();
                        r8.toByteArray();
                    }
                    if (str != 0) {
                        str.close();
                    }
                    throw th2;
                }
            } catch (FileNotFoundException e20) {
                e10 = e20;
                str = 0;
                byteArrayOutputStream = null;
            } catch (IOException e21) {
                e9 = e21;
                str = 0;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                file = null;
                th = th5;
                str = 0;
                File file3 = file;
                th2 = th;
                r8 = file3;
                if (r8 != 0) {
                    r8.close();
                    r8.toByteArray();
                }
                if (str != 0) {
                    str.close();
                }
                throw th2;
            }
        } catch (IOException e22) {
            e22.printStackTrace();
        }
        return byteArray;
    }

    public static byte[] getFromRaw(Context context, int i9) throws Throwable {
        byte[] bArr;
        IOException e9;
        InputStream inputStream = null;
        bArr = null;
        byte[] bArr2 = null;
        inputStream = null;
        try {
            try {
                InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i9);
                try {
                    Runtime runtime = Runtime.getRuntime();
                    int iFreeMemory = 512000;
                    if (runtime != null && runtime.freeMemory() < 512000) {
                        iFreeMemory = (int) runtime.freeMemory();
                    }
                    byte[] bArr3 = new byte[iFreeMemory];
                    byte[] bArr4 = new byte[1024];
                    int i10 = 0;
                    while (true) {
                        int i11 = inputStreamOpenRawResource.read(bArr4, 0, 1024);
                        if (i11 < 0) {
                            break;
                        }
                        int i12 = i10 + i11;
                        if (i12 <= iFreeMemory) {
                            System.arraycopy(bArr4, 0, bArr3, i10, i11);
                            i10 = i12;
                        }
                        e9.printStackTrace();
                        return bArr2;
                    }
                    if (i10 > 0) {
                        bArr2 = new byte[i10];
                        System.arraycopy(bArr3, 0, bArr2, 0, i10);
                    }
                    try {
                        inputStreamOpenRawResource.close();
                        return bArr2;
                    } catch (IOException e10) {
                        e9 = e10;
                    }
                } catch (Exception e11) {
                    e = e11;
                    byte[] bArr5 = bArr2;
                    inputStream = inputStreamOpenRawResource;
                    bArr = bArr5;
                    e.printStackTrace();
                    if (inputStream == null) {
                        return bArr;
                    }
                    try {
                        inputStream.close();
                        return bArr;
                    } catch (IOException e12) {
                        bArr2 = bArr;
                        e9 = e12;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenRawResource;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e14) {
                e = e14;
                bArr = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int judgeFileType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.endsWith(".png") || str.endsWith(".PNG") || str.endsWith(".JPEG") || str.endsWith(".jpeg") || str.endsWith(".jpg") || str.endsWith(".JPG")) {
            return 1;
        }
        return (str.endsWith(".mov") || str.endsWith(".MOV") || str.endsWith(".mp4") || str.endsWith(".MP4") || str.endsWith(".avi") || str.endsWith(".AVI")) ? 2 : 0;
    }

    public static String splicingFilePath(Context context, String str, String str2, String str3, String str4) {
        String strA = a(context);
        if (!TextUtils.isEmpty(str)) {
            String str5 = File.separator;
            if (str.contains(str5)) {
                for (String str6 : str.split(str5)) {
                    if (!TextUtils.isEmpty(str6)) {
                        strA = a.j(p171w.a.b(strA), File.separator, str6);
                        File file = new File(strA);
                        if (!file.exists() && file.mkdir()) {
                            JL_Log.w(f16327a, "splicingFilePath", "create root dir success! path : " + strA);
                        }
                    }
                }
            } else {
                strA = p171w.a.a(strA, str5, str);
                File file2 = new File(strA);
                if (!file2.exists() && file2.mkdir()) {
                    JL_Log.w(f16327a, "splicingFilePath", "create root dir success! path : " + strA);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return strA;
            }
            StringBuilder sbB = p171w.a.b(strA);
            String str7 = File.separator;
            String strJ = a.j(sbB, str7, str2);
            File file3 = new File(strJ);
            if (!file3.exists() && file3.mkdir()) {
                JL_Log.w(f16327a, "splicingFilePath", "create one dir success!");
            }
            if (TextUtils.isEmpty(str3)) {
                return strJ;
            }
            String strA2 = p171w.a.a(strJ, str7, str3);
            File file4 = new File(strA2);
            if (!file4.exists() && file4.mkdir()) {
                JL_Log.w(f16327a, "splicingFilePath", "create two dir success!");
            }
            if (TextUtils.isEmpty(str4)) {
                return strA2;
            }
            strA = p171w.a.a(strA2, str7, str4);
            File file5 = new File(strA);
            if (!file5.exists() && file5.mkdir()) {
                JL_Log.w(f16327a, "splicingFilePath", "create three sub dir success!");
            }
        }
        return strA;
    }
}

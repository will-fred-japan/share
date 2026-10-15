package com.engagelab.privates.common.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ImageUtils {
    private static final String TAG = "ImageUtils";

    public static void compressImage(String str, String str2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BitmapFactory.decodeFile(str, options);
            int iComputeSize = computeSize(options.outWidth, options.outHeight);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = iComputeSize;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options2);
            if (bitmapDecodeFile == null) {
                return;
            }
            String typeFromUrl = Utils.getTypeFromUrl(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (bitmapDecodeFile.compress(getCompressFormat(typeFromUrl), 60, byteArrayOutputStream)) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                bitmapDecodeFile.recycle();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    try {
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static int computeSize(int i9, int i10) {
        if (i9 % 2 == 1) {
            i9++;
        }
        if (i10 % 2 == 1) {
            i10++;
        }
        int iMax = Math.max(i9, i10);
        float fMin = Math.min(i9, i10) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d9 = fMin;
            if (d9 > 0.5625d || d9 <= 0.5d) {
                return (int) Math.ceil(((double) iMax) / (1280.0d / d9));
            }
            int i11 = iMax / 1280;
            if (i11 == 0) {
                return 1;
            }
            return i11;
        }
        if (iMax < 1664) {
            return 1;
        }
        if (iMax < 4990) {
            return 2;
        }
        if (iMax > 4990 && iMax < 10240) {
            return 4;
        }
        int i12 = iMax / 1280;
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public static Bitmap getBitmap(String str, int i9, int i10) {
        return BitmapFactory.decodeFile(str, new BitmapFactory.Options());
    }

    private static Bitmap.CompressFormat getCompressFormat(String str) {
        str.getClass();
        return !str.equals("image/png") ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
    }
}

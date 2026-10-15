package com.starburst.sdk.core.feed.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class ImageConverter {
    private static final int LV_COLOR_FORMAT = 18;

    private static Bitmap applyAntiAliasing(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i9, int i10) {
        int i11 = options.outHeight;
        int i12 = options.outWidth;
        int i13 = 1;
        if (i11 <= i10 && i12 <= i9) {
            return 1;
        }
        int i14 = i11 / 2;
        int i15 = i12 / 2;
        while (i14 / i13 >= i10 && i15 / i13 >= i9) {
            i13 *= 2;
        }
        return i13;
    }

    public static void convertRgb565WithHeader(String str, String str2, int i9, int i10) throws IOException {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile == null) {
            throw new IOException("无法解码输入图片");
        }
        try {
            saveWithHeader(Bitmap.createScaledBitmap(bitmapDecodeFile, i9, i10, true).copy(Bitmap.Config.RGB_565, false), new File(str2));
        } finally {
            bitmapDecodeFile.recycle();
        }
    }

    public static void convertWithHeader2(String str, String str2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, 320, 240);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (bitmapDecodeFile == null) {
            throw new IOException("无法解码输入图片");
        }
        try {
            saveWithHeader(applyAntiAliasing(highQualityScale(bitmapDecodeFile, 320, 240)), new File(str2));
        } finally {
            bitmapDecodeFile.recycle();
        }
    }

    private static int createHeaderValue(int i9, int i10) {
        return (i9 << 10) | (i10 << 21) | 18;
    }

    public static void createScaledFile(String str, String str2, int i9, int i10) throws IOException {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile == null) {
            throw new IOException("无法解码输入图片");
        }
        try {
            saveWithHeader(Bitmap.createScaledBitmap(bitmapDecodeFile, i9, i10, true), new File(str2));
        } finally {
            bitmapDecodeFile.recycle();
        }
    }

    private static Bitmap highQualityScale(Bitmap bitmap, int i9, int i10) {
        Matrix matrix = new Matrix();
        matrix.postScale(i9 / bitmap.getWidth(), i10 / bitmap.getHeight());
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static void saveWithHeader(Bitmap bitmap, File file) throws IOException {
        byte[] bArrArray = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(createHeaderValue(bitmap.getWidth(), bitmap.getHeight())).array();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArrArray);
            writePixelData(bitmap, fileOutputStream);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void writePixelData(Bitmap bitmap, OutputStream outputStream) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getWidth() * 2);
        for (int i9 = 0; i9 < bitmap.getHeight(); i9++) {
            for (int i10 = 0; i10 < bitmap.getWidth(); i10++) {
                int pixel = bitmap.getPixel(i10, i9);
                short s8 = (short) (((pixel >> 3) & 31) | ((pixel >> 8) & 63488) | ((pixel >> 5) & 2016));
                byteBufferAllocate.putShort((short) ((s8 >> 8) | (s8 << 8)));
            }
        }
        outputStream.write(byteBufferAllocate.array());
    }
}

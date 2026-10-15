package com.starburst.sdk.core.device.bt.http;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class BitmapConvertor {
    private static BitmapConvertor INSTANCE;
    private byte[] Color_palette = new byte[1024];
    private byte[] BMP_File_Header = new byte[14];
    private byte[] DIB_header = new byte[40];
    private byte[] Bitmap_Data = null;

    public static BitmapConvertor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BitmapConvertor();
        }
        return INSTANCE;
    }

    public void save16Bmp(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return;
        }
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.RGB_565, true);
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i9 = width * 3;
        int i10 = ((width % 4) + i9) * height;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            writeWord(fileOutputStream, 19778);
            writeDword(fileOutputStream, i10 + 54);
            writeWord(fileOutputStream, 0);
            writeWord(fileOutputStream, 0);
            writeDword(fileOutputStream, 54L);
            writeDword(fileOutputStream, 40L);
            writeLong(fileOutputStream, width);
            writeLong(fileOutputStream, height);
            writeWord(fileOutputStream, 1);
            writeWord(fileOutputStream, 16);
            writeDword(fileOutputStream, 0L);
            writeDword(fileOutputStream, 0L);
            writeLong(fileOutputStream, 0L);
            writeLong(fileOutputStream, 0L);
            writeDword(fileOutputStream, 0L);
            writeDword(fileOutputStream, 0L);
            byte[] bArr = new byte[i10];
            int i11 = i9 + (width % 4);
            int i12 = height - 1;
            int i13 = 0;
            while (i13 < height) {
                int i14 = 0;
                int i15 = 0;
                while (i14 < width) {
                    int pixel = bitmapCopy.getPixel(i14, i13);
                    int i16 = (i12 * i11) + i15;
                    bArr[i16] = (byte) Color.blue(pixel);
                    bArr[i16 + 1] = (byte) Color.green(pixel);
                    bArr[i16 + 2] = (byte) Color.red(pixel);
                    i14++;
                    i15 += 3;
                }
                i13++;
                i12--;
            }
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e9) {
            e = e9;
            e.printStackTrace();
        } catch (IOException e10) {
            e = e10;
            e.printStackTrace();
        }
    }

    public void save16Bmp2(Bitmap bitmap, String str) {
        if (bitmap == null) {
            return;
        }
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.RGB_565, true);
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i9 = width * height;
        int[] iArr = new int[i9];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i10 = (width % 2 == 0 ? width : width + 2) * height * 2;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            writeWord(fileOutputStream, 19778);
            writeDword(fileOutputStream, i10 + 54);
            writeWord(fileOutputStream, 0);
            writeWord(fileOutputStream, 0);
            writeDword(fileOutputStream, 54L);
            writeDword(fileOutputStream, 40L);
            writeLong(fileOutputStream, width);
            writeLong(fileOutputStream, height);
            writeWord(fileOutputStream, 1);
            writeWord(fileOutputStream, 16);
            writeDword(fileOutputStream, 0L);
            writeDword(fileOutputStream, i10);
            writeLong(fileOutputStream, 2834L);
            writeLong(fileOutputStream, 2834L);
            writeDword(fileOutputStream, 0L);
            writeDword(fileOutputStream, 0L);
            byte[] bArr = new byte[i10];
            int i11 = i9 - 1;
            int i12 = 0;
            while (i11 >= width) {
                int i13 = i11 - width;
                int i14 = i13 + 1;
                while (i14 <= i11) {
                    int i15 = iArr[i14];
                    bArr[i12] = (byte) i15;
                    bArr[i12 + 1] = (byte) (i15 >> 8);
                    int i16 = i12 + 2;
                    bArr[i16] = (byte) (i15 >> 16);
                    bArr[i12 + 3] = (byte) (i15 >> 24);
                    i14++;
                    i12 = i16;
                }
                i11 = i13;
            }
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmapCopy.recycle();
            bitmap.recycle();
        } catch (FileNotFoundException e9) {
            e = e9;
            e.printStackTrace();
        } catch (IOException e10) {
            e = e10;
            e.printStackTrace();
        }
    }

    public void writeDword(FileOutputStream fileOutputStream, long j) throws IOException {
        fileOutputStream.write(new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)});
    }

    public void writeLong(FileOutputStream fileOutputStream, long j) throws IOException {
        fileOutputStream.write(new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)});
    }

    public void writeWord(FileOutputStream fileOutputStream, int i9) throws IOException {
        fileOutputStream.write(new byte[]{(byte) (i9 & 255), (byte) ((i9 >> 8) & 255)});
    }
}

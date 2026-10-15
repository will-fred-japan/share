package com.starburst.sdk.core.device.bt.http;

import android.graphics.Bitmap;
import com.starburst.sdk.common.utils.ByteTools;
import com.starburst.sdk.utils.j;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class BmpUtil {
    private static BmpUtil INSTANCE;

    private byte[] addBMPImageHeader(int i9, int i10) {
        int i11 = i10 + 14;
        int i12 = i9 + i11;
        return new byte[]{66, 77, (byte) i12, (byte) (i12 >> 8), (byte) (i12 >> 16), (byte) (i12 >> 24), 0, 0, 0, 0, (byte) i11, (byte) (i11 >> 8), (byte) (i11 >> 16), (byte) (i11 >> 24)};
    }

    private byte[] addBMPImageInfosHeader(int i9, int i10) {
        byte b9 = (byte) 0;
        return new byte[]{(byte) 40, b9, b9, b9, (byte) i9, (byte) (i9 >> 8), (byte) (i9 >> 16), (byte) (i9 >> 24), (byte) i10, (byte) (i10 >> 8), (byte) (i10 >> 16), (byte) (i10 >> 24), 1, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 78, 0, 0, 32, 78, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private byte[] addBMPImageInfosHeaderTable(int i9, int i10) {
        byte[] bArr = new byte[1024];
        for (int i11 = 0; i11 < 256; i11++) {
            int i12 = i11 * 4;
            byte b9 = (byte) i11;
            bArr[i12] = b9;
            bArr[i12 + 1] = b9;
            bArr[i12 + 2] = b9;
            bArr[i12 + 3] = -1;
        }
        return bArr;
    }

    private byte[] addBMP_8(byte[] bArr, int i9, int i10) {
        int length = bArr.length;
        j.f("BmpUtil", "addBMP_8 input length = " + bArr.length);
        byte[] bArr2 = new byte[i10 * i9];
        int i11 = length + (-1);
        int i12 = 0;
        while (i11 >= i9 - 1) {
            int i13 = i11 - i9;
            for (int i14 = i13 + 1; i14 <= i11; i14++) {
                bArr2[i12] = bArr[i14];
                i12++;
            }
            i11 = i13;
        }
        return bArr2;
    }

    private byte[] getBinHeader(int i9, int i10) {
        byte[] bArrInt2Bytes = ByteTools.int2Bytes(i9, 2);
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b9 : bArrInt2Bytes) {
            stringBuffer.append(ByteTools.byteToBit(b9));
        }
        j.f("getBinHeader", "wSb--" + ((Object) stringBuffer));
        StringBuffer stringBufferReverse = new StringBuffer(stringBuffer.substring(5, stringBuffer.length())).reverse();
        j.f("getBinHeader", "wStr--" + ((Object) stringBufferReverse));
        byte[] bArrInt2Bytes2 = ByteTools.int2Bytes(i10, 2);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b10 : bArrInt2Bytes2) {
            stringBuffer2.append(ByteTools.byteToBit(b10));
        }
        j.f("getBinHeader", "hSb--" + ((Object) stringBuffer2));
        StringBuffer stringBufferReverse2 = new StringBuffer(stringBuffer2.substring(5, stringBuffer2.length())).reverse();
        j.f("getBinHeader", "hStr--" + ((Object) stringBufferReverse2));
        StringBuffer stringBuffer3 = new StringBuffer("00");
        stringBuffer3.append(stringBufferReverse);
        stringBuffer3.append(stringBufferReverse2);
        j.f("getBinHeader", "head2--" + ((Object) stringBuffer3));
        byte[] bArr = {4, ByteTools.bitToByte(new StringBuffer(stringBuffer3.substring(0, 8)).reverse().toString()), ByteTools.bitToByte(new StringBuffer(stringBuffer3.substring(8, 16)).reverse().toString()), ByteTools.bitToByte(new StringBuffer(stringBuffer3.substring(16, 24)).reverse().toString())};
        j.f("getBinHeader", "head--" + ByteTools.byteArrToHex(bArr));
        return bArr;
    }

    public static BmpUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BmpUtil();
        }
        return INSTANCE;
    }

    private int gui_color_rgb565(byte b9, byte b10, byte b11) {
        return ((b9 & 248) << 8) | ((b10 & 252) << 3) | ((b11 & 248) >> 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileOutputStream] */
    public void saveBmpWith8(Bitmap bitmap, String str) throws Throwable {
        ?? r8;
        Throwable th;
        Exception exc;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i9 = width * height;
        int[] iArr = new int[i9];
        bitmap.copy(Bitmap.Config.ARGB_8888, true).getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[i10] = (byte) (iArr[i10] >> 24);
        }
        byte[] bArrAddBMP_8 = addBMP_8(bArr, width, height);
        byte[] bArrAddBMPImageInfosHeaderTable = addBMPImageInfosHeaderTable(width, height);
        byte[] bArrAddBMPImageInfosHeader = addBMPImageInfosHeader(width, height);
        byte[] bArrAddBMPImageHeader = addBMPImageHeader(bArrAddBMP_8.length, bArrAddBMPImageInfosHeader.length + bArrAddBMPImageInfosHeaderTable.length);
        byte[] bArr2 = new byte[bArrAddBMPImageHeader.length + bArrAddBMPImageInfosHeader.length + bArrAddBMPImageInfosHeaderTable.length + bArrAddBMP_8.length];
        System.arraycopy(bArrAddBMPImageHeader, 0, bArr2, 0, bArrAddBMPImageHeader.length);
        System.arraycopy(bArrAddBMPImageInfosHeader, 0, bArr2, bArrAddBMPImageHeader.length, bArrAddBMPImageInfosHeader.length);
        System.arraycopy(bArrAddBMPImageInfosHeaderTable, 0, bArr2, bArrAddBMPImageHeader.length + bArrAddBMPImageInfosHeader.length, bArrAddBMPImageInfosHeaderTable.length);
        int length = bArrAddBMPImageHeader.length + bArrAddBMPImageInfosHeader.length + bArrAddBMPImageInfosHeaderTable.length;
        ?? length2 = bArrAddBMP_8.length;
        System.arraycopy(bArrAddBMP_8, 0, bArr2, length, length2);
        try {
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    try {
                        fileOutputStream.write(bArr2);
                        fileOutputStream.close();
                    } catch (Exception e9) {
                        exc = e9;
                        length2 = fileOutputStream;
                        exc.printStackTrace();
                        length2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r8 = length2;
                    try {
                        r8.close();
                        throw th;
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        throw th;
                    }
                }
            } catch (Exception e11) {
                length2 = 0;
                exc = e11;
            } catch (Throwable th3) {
                r8 = 0;
                th = th3;
                r8.close();
                throw th;
            }
        } catch (IOException e12) {
            e12.printStackTrace();
        }
    }

    public void saveRGB565(Bitmap bitmap, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.RGB_565, true);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmapCopy.getHeight() * bitmapCopy.getWidth() * 2);
        bitmapCopy.copyPixelsToBuffer(byteBufferAllocate);
        byte[] bArrAddBytes = ByteTools.addBytes(getBinHeader(width, height), byteBufferAllocate.array());
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                    try {
                        fileOutputStream.write(bArrAddBytes);
                        fileOutputStream.close();
                    } catch (Exception e9) {
                        e = e9;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        fileOutputStream2.close();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            fileOutputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }
}

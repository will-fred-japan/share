package com.starburst.sdk.utils;

import com.starburst.sdk.core.tts.EventType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16448a;

    public final void a(String str, String str2) {
        long j = 16000;
        long j8 = 32000;
        byte[] bArr = new byte[this.f16448a];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            long size = fileInputStream.getChannel().size();
            long j9 = size + 36;
            fileOutputStream.write(new byte[]{82, 73, 70, 70, (byte) (j9 & 255), (byte) ((j9 >> 8) & 255), (byte) ((j9 >> 16) & 255), (byte) ((j9 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) 1, 0, (byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255), (byte) (j8 & 255), (byte) ((j8 >> 8) & 255), (byte) ((j8 >> 16) & 255), (byte) ((j8 >> 24) & 255), (byte) 2, 0, 16, 0, EventType.ERROR, 97, 116, 97, (byte) (size & 255), (byte) ((size >> 8) & 255), (byte) ((size >> 16) & 255), (byte) ((size >> 24) & 255)}, 0, 44);
            while (fileInputStream.read(bArr) != -1) {
                fileOutputStream.write(bArr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e9) {
            e9.printStackTrace();
        }
    }
}

package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import cn.jpush.android.api.InAppSlotParams;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.aa;
import com.xiaomi.push.bm;
import com.xiaomi.push.bw;
import com.xiaomi.push.i;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes.dex */
public class a implements IEventProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f16933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f20a;

    public a(Context context) {
        a(context);
    }

    public void a(Context context) {
        this.f16933a = context;
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() throws Throwable {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map = this.f20a;
        if (map == null) {
            return;
        }
        if (map.size() > 0) {
            Iterator<String> it = this.f20a.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f20a.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                    arrayList.toArray(aVarArr);
                    m24a(aVarArr);
                }
            }
        }
        this.f20a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] bArrA;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.f16933a).m20a().isEventEncrypted()) {
                return bm.b(bArr);
            }
            String strA = bw.a(this.f16933a);
            if (!TextUtils.isEmpty(strA) && (bArrA = bw.a(strA)) != null && bArrA.length > 0) {
                try {
                    return bm.b(Base64.decode(i.a(bArrA, bArr), 2));
                } catch (InvalidAlgorithmParameterException e9) {
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                } catch (InvalidKeyException e10) {
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e10);
                } catch (NoSuchAlgorithmException e11) {
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e11);
                } catch (BadPaddingException e12) {
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e12);
                } catch (IllegalBlockSizeException e13) {
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e13);
                } catch (NoSuchPaddingException e14) {
                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e14);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> map) {
        this.f20a = map;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] bArrA;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.clientreport.manager.a.a(this.f16933a).m20a().isEventEncrypted()) {
            return bm.m128a(str);
        }
        String strA = bw.a(this.f16933a);
        byte[] bArrM128a = bm.m128a(str);
        if (!TextUtils.isEmpty(strA) && bArrM128a != null && bArrM128a.length > 1 && (bArrA = bw.a(strA)) != null) {
            try {
                if (bArrA.length > 1) {
                    return i.b(bArrA, Base64.encode(bArrM128a, 2));
                }
            } catch (Exception e9) {
                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            }
        }
        return null;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    public void a(List<String> list) {
        bw.a(this.f16933a, list);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0037 A[PHI: r2 r3 r4
  0x0037: PHI (r2v11 java.nio.channels.FileLock) = (r2v4 java.nio.channels.FileLock), (r2v2 java.nio.channels.FileLock), (r2v2 java.nio.channels.FileLock) binds: [B:68:0x010b, B:32:0x0092, B:19:0x0035] A[DONT_GENERATE, DONT_INLINE]
  0x0037: PHI (r3v15 java.io.RandomAccessFile) = (r3v4 java.io.RandomAccessFile), (r3v2 java.io.RandomAccessFile), (r3v2 java.io.RandomAccessFile) binds: [B:68:0x010b, B:32:0x0092, B:19:0x0035] A[DONT_GENERATE, DONT_INLINE]
  0x0037: PHI (r4v9 java.io.File) = (r4v3 java.io.File), (r4v1 java.io.File), (r4v1 java.io.File) binds: [B:68:0x010b, B:32:0x0092, B:19:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.xiaomi.clientreport.processor.c
    public void a() throws Throwable {
        bw.a(this.f16933a, InAppSlotParams.SLOT_KEY.EVENT, "eventUploading");
        File[] fileArrM136a = bw.m136a(this.f16933a, "eventUploading");
        if (fileArrM136a == null || fileArrM136a.length <= 0) {
            return;
        }
        FileLock fileLockLock = null;
        File file = null;
        RandomAccessFile randomAccessFile = null;
        for (File file2 : fileArrM136a) {
            if (file2 == null) {
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException e9) {
                        com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
                    }
                }
                y.a(randomAccessFile);
                if (file != null) {
                    file.delete();
                }
            } else {
                try {
                    try {
                        if (file2.length() > 5242880) {
                            com.xiaomi.channel.commonutils.logger.c.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                            a(file2.getName(), Formatter.formatFileSize(this.f16933a, file2.length()));
                            file2.delete();
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e10) {
                                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e10);
                                }
                            }
                            y.a(randomAccessFile);
                            if (file != null) {
                                file.delete();
                            }
                        } else {
                            String absolutePath = file2.getAbsolutePath();
                            File file3 = new File(absolutePath + ".lock");
                            try {
                                y.m844a(file3);
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file3, "rw");
                                try {
                                    fileLockLock = randomAccessFile2.getChannel().lock();
                                    a(a(absolutePath));
                                    file2.delete();
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            fileLockLock.release();
                                        } catch (IOException e11) {
                                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e11);
                                        }
                                    }
                                    y.a(randomAccessFile2);
                                    file3.delete();
                                    randomAccessFile = randomAccessFile2;
                                    file = file3;
                                } catch (Exception e12) {
                                    e = e12;
                                    randomAccessFile = randomAccessFile2;
                                    file = file3;
                                    com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            fileLockLock.release();
                                        } catch (IOException e13) {
                                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e13);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    if (file != null) {
                                        file.delete();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile = randomAccessFile2;
                                    file = file3;
                                    if (fileLockLock != null && fileLockLock.isValid()) {
                                        try {
                                            fileLockLock.release();
                                        } catch (IOException e14) {
                                            com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e14);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    if (file != null) {
                                        file.delete();
                                        throw th;
                                    }
                                    throw th;
                                }
                            } catch (Exception e15) {
                                e = e15;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e16) {
                    e = e16;
                }
            }
        }
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File file = new File(this.f16933a.getFilesDir(), InAppSlotParams.SLOT_KEY.EVENT);
        String strA = a(aVar);
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        String strJ = A.a.j(sb, File.separator, strA);
        for (int i9 = 0; i9 < 100; i9++) {
            String str = strJ + i9;
            if (bw.m135a(this.f16933a, str)) {
                return str;
            }
        }
        return null;
    }

    private void a(String str, String str2) {
        EventClientReport eventClientReportA = com.xiaomi.clientreport.manager.a.a(this.f16933a).a(5001, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventClientReportA.toJsonString());
        a(arrayList);
    }

    private List<String> a(String str) throws Throwable {
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                while (true) {
                    try {
                        int i9 = fileInputStream2.read(bArr);
                        if (i9 == -1) {
                            break;
                        }
                        if (i9 != 4) {
                            com.xiaomi.channel.commonutils.logger.c.d("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        if (aa.a(bArr) != -573785174) {
                            com.xiaomi.channel.commonutils.logger.c.d("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        int i10 = fileInputStream2.read(bArr2);
                        if (i10 == -1) {
                            break;
                        }
                        if (i10 != 4) {
                            com.xiaomi.channel.commonutils.logger.c.d("eventData read from cache file failed cause lengthBuffer error");
                            break;
                        }
                        int iA = aa.a(bArr2);
                        if (iA >= 1 && iA <= 4096) {
                            byte[] bArr3 = new byte[iA];
                            if (fileInputStream2.read(bArr3) != iA) {
                                com.xiaomi.channel.commonutils.logger.c.d("eventData read from cache file failed cause buffer size not equal length");
                                break;
                            }
                            String strBytesToString = bytesToString(bArr3);
                            if (!TextUtils.isEmpty(strBytesToString)) {
                                arrayList.add(strBytesToString);
                            }
                        } else {
                            com.xiaomi.channel.commonutils.logger.c.d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
                            break;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        fileInputStream = fileInputStream2;
                        com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e);
                        y.a((Closeable) fileInputStream);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        y.a((Closeable) fileInputStream);
                        throw th;
                    }
                }
                y.a((Closeable) fileInputStream2);
                return arrayList;
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m24a(com.xiaomi.clientreport.data.a[] aVarArr) throws Throwable {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            com.xiaomi.channel.commonutils.logger.c.m9a("event data write to cache file failed because data null");
            return;
        }
        do {
            aVarArr = a(aVarArr);
            if (aVarArr == null || aVarArr.length <= 0) {
                return;
            }
        } while (aVarArr[0] != null);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) throws Throwable {
        FileLock fileLockLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String strB = b(aVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            File file = new File(strB + ".lock");
            y.m844a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(strB), true));
                    try {
                        try {
                            int i9 = 0;
                            for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                                if (aVar != null) {
                                    byte[] bArrStringToBytes = stringToBytes(aVar.toJsonString());
                                    if (bArrStringToBytes != null && bArrStringToBytes.length >= 1 && bArrStringToBytes.length <= 4096) {
                                        if (!bw.m135a(this.f16933a, strB)) {
                                            int length = aVarArr.length - i9;
                                            com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                            System.arraycopy(aVarArr, i9, aVarArr2, 0, length);
                                            y.a(bufferedOutputStream);
                                            a(randomAccessFile, fileLockLock);
                                            return aVarArr2;
                                        }
                                        bufferedOutputStream.write(aa.a(-573785174));
                                        bufferedOutputStream.write(aa.a(bArrStringToBytes.length));
                                        bufferedOutputStream.write(bArrStringToBytes);
                                        bufferedOutputStream.flush();
                                        i9++;
                                    } else {
                                        com.xiaomi.channel.commonutils.logger.c.d("event data throw a invalid item ");
                                    }
                                }
                            }
                        } catch (Exception e9) {
                            e = e9;
                            com.xiaomi.channel.commonutils.logger.c.a("event data write to cache file failed cause exception", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream;
                        y.a(bufferedOutputStream2);
                        a(randomAccessFile, fileLockLock);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    y.a(bufferedOutputStream2);
                    a(randomAccessFile, fileLockLock);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileLockLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileLockLock = null;
            }
        } catch (Exception e12) {
            e = e12;
            fileLockLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileLockLock = null;
            randomAccessFile = null;
        }
        y.a(bufferedOutputStream);
        a(randomAccessFile, fileLockLock);
        return null;
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e9) {
                com.xiaomi.channel.commonutils.logger.c.m12a((Throwable) e9);
            }
        }
        y.a(randomAccessFile);
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo23a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f20a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String strA = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.f20a.get(strA);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f20a.put(strA, arrayList);
        }
    }
}

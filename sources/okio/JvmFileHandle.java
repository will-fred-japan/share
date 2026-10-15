package okio;

import java.io.RandomAccessFile;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: JvmFileHandle.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmFileHandle extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z8, RandomAccessFile randomAccessFile) {
        super(z8);
        k.e(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }

    @Override // okio.FileHandle
    public synchronized void protectedClose() {
        this.randomAccessFile.close();
    }

    @Override // okio.FileHandle
    public synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    @Override // okio.FileHandle
    public synchronized int protectedRead(long j, byte[] array, int i9, int i10) {
        k.e(array, "array");
        this.randomAccessFile.seek(j);
        int i11 = 0;
        while (i11 < i10) {
            int i12 = this.randomAccessFile.read(array, i9, i10 - i11);
            if (i12 == -1) {
                if (i11 != 0) {
                    break;
                }
                return -1;
            }
            i11 += i12;
        }
        return i11;
    }

    @Override // okio.FileHandle
    public synchronized void protectedResize(long j) throws Throwable {
        try {
            try {
                long size = size();
                long j8 = j - size;
                if (j8 > 0) {
                    int i9 = (int) j8;
                    protectedWrite(size, new byte[i9], 0, i9);
                } else {
                    this.randomAccessFile.setLength(j);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // okio.FileHandle
    public synchronized long protectedSize() {
        return this.randomAccessFile.length();
    }

    @Override // okio.FileHandle
    public synchronized void protectedWrite(long j, byte[] array, int i9, int i10) {
        k.e(array, "array");
        this.randomAccessFile.seek(j);
        this.randomAccessFile.write(array, i9, i10);
    }
}

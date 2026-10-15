package okio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: NioFileSystemFileHandle.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NioFileSystemFileHandle extends FileHandle {
    private final FileChannel fileChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NioFileSystemFileHandle(boolean z8, FileChannel fileChannel) {
        super(z8);
        k.e(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    @Override // okio.FileHandle
    public synchronized void protectedClose() {
        this.fileChannel.close();
    }

    @Override // okio.FileHandle
    public synchronized void protectedFlush() {
        this.fileChannel.force(true);
    }

    @Override // okio.FileHandle
    public synchronized int protectedRead(long j, byte[] array, int i9, int i10) {
        k.e(array, "array");
        this.fileChannel.position(j);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, i9, i10);
        int i11 = 0;
        while (i11 < i10) {
            int i12 = this.fileChannel.read(byteBufferWrap);
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
                    this.fileChannel.truncate(j);
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
        return this.fileChannel.size();
    }

    @Override // okio.FileHandle
    public synchronized void protectedWrite(long j, byte[] array, int i9, int i10) {
        k.e(array, "array");
        this.fileChannel.position(j);
        this.fileChannel.write(ByteBuffer.wrap(array, i9, i10));
    }
}

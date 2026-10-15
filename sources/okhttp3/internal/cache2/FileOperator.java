package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.k;
import okio.Buffer;

/* JADX INFO: compiled from: FileOperator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        k.e(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j, Buffer sink, long j8) throws IOException {
        k.e(sink, "sink");
        if (j8 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j9 = j;
        long j10 = j8;
        while (j10 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j9, j10, sink);
            j9 += jTransferTo;
            j10 -= jTransferTo;
        }
    }

    public final void write(long j, Buffer source, long j8) throws IOException {
        k.e(source, "source");
        if (j8 < 0 || j8 > source.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j9 = j;
        long j10 = j8;
        while (j10 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(source, j9, j10);
            j9 += jTransferFrom;
            j10 -= jTransferFrom;
        }
    }
}

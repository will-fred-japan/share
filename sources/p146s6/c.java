package p146s6;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.k;
import p188x7.d;

/* JADX INFO: compiled from: IContainerWriter.kt */
/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: compiled from: IContainerWriter.kt */
    public static final class a {
        public static RandomAccessFile a(String path) throws IOException {
            k.e(path, "path");
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
            randomAccessFile.setLength(0L);
            return randomAccessFile;
        }

        public static void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            k.e(bufferInfo, "bufferInfo");
            throw new d("An operation is not implemented.");
        }
    }

    boolean a();

    int b(MediaFormat mediaFormat);

    byte[] c(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    boolean d();

    void e(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    void release();

    void start();

    void stop();
}

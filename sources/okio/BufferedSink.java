package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: BufferedSink.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit();

    BufferedSink emitCompleteSegments();

    @Override // okio.Sink, java.io.Flushable
    void flush();

    Buffer getBuffer();

    OutputStream outputStream();

    BufferedSink write(ByteString byteString);

    BufferedSink write(ByteString byteString, int i9, int i10);

    BufferedSink write(Source source, long j);

    BufferedSink write(byte[] bArr);

    BufferedSink write(byte[] bArr, int i9, int i10);

    long writeAll(Source source);

    BufferedSink writeByte(int i9);

    BufferedSink writeDecimalLong(long j);

    BufferedSink writeHexadecimalUnsignedLong(long j);

    BufferedSink writeInt(int i9);

    BufferedSink writeIntLe(int i9);

    BufferedSink writeLong(long j);

    BufferedSink writeLongLe(long j);

    BufferedSink writeShort(int i9);

    BufferedSink writeShortLe(int i9);

    BufferedSink writeString(String str, int i9, int i10, Charset charset);

    BufferedSink writeString(String str, Charset charset);

    BufferedSink writeUtf8(String str);

    BufferedSink writeUtf8(String str, int i9, int i10);

    BufferedSink writeUtf8CodePoint(int i9);
}

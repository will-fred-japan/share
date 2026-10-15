package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.k;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.InflaterSource;
import okio.Source;

/* JADX INFO: compiled from: MessageInflater.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageInflater implements Closeable {
    private final Buffer deflatedBytes;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z8) {
        this.noContextTakeover = z8;
        Buffer buffer = new Buffer();
        this.deflatedBytes = buffer;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource((Source) buffer, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    public final void inflate(Buffer buffer) throws IOException {
        k.e(buffer, "buffer");
        if (!(this.deflatedBytes.size() == 0)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.writeAll(buffer);
        this.deflatedBytes.writeInt(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        long size = this.deflatedBytes.size() + this.inflater.getBytesRead();
        do {
            this.inflaterSource.readOrInflate(buffer, Long.MAX_VALUE);
        } while (this.inflater.getBytesRead() < size);
    }
}

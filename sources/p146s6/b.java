package p146s6;

import W5.e;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: FlacContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f21279e = {102, 76, 97, 67};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f21280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21283d;

    public b(String path) {
        k.e(path, "path");
        this.f21280a = c.a.a(path);
        this.f21282c = -1L;
        this.f21283d = -1;
    }

    @Override // p146s6.c
    public final boolean a() {
        return false;
    }

    @Override // p146s6.c
    public final int b(MediaFormat mediaFormat) throws Exception {
        k.e(mediaFormat, "mediaFormat");
        if (this.f21281b) {
            throw new Exception("Container already started");
        }
        if (this.f21283d >= 0) {
            throw new Exception("Track already added");
        }
        this.f21283d = 0;
        return 0;
    }

    @Override // p146s6.c
    public final byte[] c(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        c.a.b(byteBuffer, bufferInfo);
        throw null;
    }

    @Override // p146s6.c
    public final boolean d() {
        return false;
    }

    @Override // p146s6.c
    public final void e(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws Exception {
        k.e(bufferInfo, "bufferInfo");
        if (!this.f21281b) {
            throw new Exception("Container not started");
        }
        int i10 = this.f21283d;
        if (i10 < 0) {
            throw new Exception("No track has been added");
        }
        if (i10 != i9) {
            throw new Exception(e.i(i9, "Invalid track: "));
        }
        Os.write(this.f21280a.getFD(), byteBuffer);
        if ((bufferInfo.flags & 4) != 0) {
            this.f21282c = bufferInfo.presentationTimeUs;
        }
    }

    @Override // p146s6.c
    public final void release() throws Exception {
        if (this.f21281b) {
            stop();
        }
    }

    @Override // p146s6.c
    public final void start() throws Exception {
        if (this.f21281b) {
            throw new Exception("Container already started");
        }
        RandomAccessFile randomAccessFile = this.f21280a;
        Os.lseek(randomAccessFile.getFD(), 0L, OsConstants.SEEK_SET);
        Os.ftruncate(randomAccessFile.getFD(), 0L);
        this.f21281b = true;
    }

    @Override // p146s6.c
    public final void stop() throws Exception {
        String string;
        if (!this.f21281b) {
            throw new Exception("Container not started");
        }
        this.f21281b = false;
        long j = this.f21282c;
        RandomAccessFile randomAccessFile = this.f21280a;
        if (j >= 0) {
            FileDescriptor fd = randomAccessFile.getFD();
            int i9 = OsConstants.SEEK_SET;
            Os.lseek(fd, 0L, i9);
            byte[] bArr = new byte[42];
            if (Os.read(randomAccessFile.getFD(), bArr, 0, 42) != 42) {
                throw new IOException("EOF reached when reading FLAC headers");
            }
            if (!k.a(ByteBuffer.wrap(bArr, 0, 4), ByteBuffer.wrap(f21279e))) {
                throw new IOException("FLAC magic not found");
            }
            if (((byte) (bArr[4] & 127)) != ((byte) 0)) {
                throw new IOException("First metadata block is not STREAMINFO");
            }
            if (Integer.compareUnsigned(((bArr[5] & 255) << 16) | ((bArr[6] & 255) << 8) | (bArr[7] & 255), 34) < 0) {
                throw new IOException("STREAMINFO block is too small");
            }
            long jDivideUnsigned = Long.divideUnsigned(this.f21282c * (((long) (((bArr[20] & 255) >>> 4) | ((bArr[18] & 255) << 12) | ((bArr[19] & 255) << 4))) & 4294967295L), 1000000L);
            if (Long.compareUnsigned(jDivideUnsigned, 137438953472L) >= 0) {
                if (jDivideUnsigned < 0) {
                    long j8 = 10;
                    long j9 = ((jDivideUnsigned >>> 1) / j8) << 1;
                    long j10 = jDivideUnsigned - (j9 * j8);
                    if (j10 >= j8) {
                        j10 -= j8;
                        j9++;
                    }
                    p199z2.b.q(10);
                    String string2 = Long.toString(j9, 10);
                    k.d(string2, "toString(...)");
                    p199z2.b.q(10);
                    String string3 = Long.toString(j10, 10);
                    k.d(string3, "toString(...)");
                    string = string2.concat(string3);
                } else {
                    p199z2.b.q(10);
                    string = Long.toString(jDivideUnsigned, 10);
                    k.d(string, "toString(...)");
                }
                throw new IOException(e.l("Frame count cannot be represented in FLAC: ", string));
            }
            bArr[21] = (byte) (((byte) (bArr[21] & (-16))) | ((byte) ((jDivideUnsigned >>> 32) & 15)));
            bArr[22] = (byte) ((jDivideUnsigned >>> 24) & 255);
            bArr[23] = (byte) ((jDivideUnsigned >>> 16) & 255);
            bArr[24] = (byte) ((jDivideUnsigned >>> 8) & 255);
            bArr[25] = (byte) (jDivideUnsigned & 255);
            Os.lseek(randomAccessFile.getFD(), 21L, i9);
            if (Os.write(randomAccessFile.getFD(), bArr, 21, 5) != 5) {
                throw new IOException("EOF reached when writing frame count");
            }
        }
        randomAccessFile.close();
    }
}

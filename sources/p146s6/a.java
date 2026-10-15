package p146s6;

import W5.e;
import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.k;
import y7.f;

/* JADX INFO: compiled from: AdtsContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21275c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21277e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f21276d = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21278f = -1;

    public a(int i9, int i10, int i11) {
        this.f21273a = i9;
        this.f21274b = i10;
        this.f21275c = i11;
    }

    @Override // p146s6.c
    public final boolean a() {
        return true;
    }

    @Override // p146s6.c
    public final int b(MediaFormat mediaFormat) {
        k.e(mediaFormat, "mediaFormat");
        if (this.f21277e) {
            throw new IllegalStateException("Container already started");
        }
        if (this.f21278f >= 0) {
            throw new IllegalStateException("Track already added");
        }
        this.f21278f = 0;
        return 0;
    }

    @Override // p146s6.c
    public final byte[] c(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        k.e(bufferInfo, "bufferInfo");
        int iRemaining = byteBuffer.remaining();
        int i10 = iRemaining + 7;
        int[] iArr = this.f21276d;
        int length = iArr.length;
        int i11 = 0;
        while (i11 < length) {
            if (this.f21273a == iArr[i11]) {
                int i12 = ((this.f21275c - 1) << 6) + (i11 << 2);
                int i13 = this.f21274b;
                byte[] bArr = {-1, -7, (byte) (i12 + (i13 >> 2)), (byte) (((i13 & 3) << 6) + (i10 >> 11)), (byte) ((i10 & 2047) >> 3), (byte) (((i10 & 7) << 5) + 31), -4};
                byte[] bArr2 = new byte[iRemaining];
                byteBuffer.get(bArr2, 0, iRemaining);
                return f.j(bArr, bArr2);
            }
            i11++;
        }
        i11 = -1;
        int i14 = ((this.f21275c - 1) << 6) + (i11 << 2);
        int i15 = this.f21274b;
        byte[] bArr3 = {-1, -7, (byte) (i14 + (i15 >> 2)), (byte) (((i15 & 3) << 6) + (i10 >> 11)), (byte) ((i10 & 2047) >> 3), (byte) (((i10 & 7) << 5) + 31), -4};
        byte[] bArr4 = new byte[iRemaining];
        byteBuffer.get(bArr4, 0, iRemaining);
        return f.j(bArr3, bArr4);
    }

    @Override // p146s6.c
    public final boolean d() {
        return false;
    }

    @Override // p146s6.c
    public final void e(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        k.e(bufferInfo, "bufferInfo");
        if (!this.f21277e) {
            throw new IllegalStateException("Container not started");
        }
        int i10 = this.f21278f;
        if (i10 < 0) {
            throw new IllegalStateException("No track has been added");
        }
        if (i10 != i9) {
            throw new IllegalStateException(e.i(i9, "Invalid track: "));
        }
    }

    @Override // p146s6.c
    public final void release() {
        if (this.f21277e) {
            stop();
        }
    }

    @Override // p146s6.c
    public final void start() {
        if (this.f21277e) {
            throw new IllegalStateException("Container already started");
        }
        this.f21277e = true;
    }

    @Override // p146s6.c
    public final void stop() {
        if (!this.f21277e) {
            throw new IllegalStateException("Container not started");
        }
        this.f21277e = false;
    }
}

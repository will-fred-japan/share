package p146s6;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: MuxerContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MediaMuxer f21287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21289f;

    public d(int i9, String path, boolean z8) {
        k.e(path, "path");
        this.f21284a = path;
        this.f21285b = z8;
        this.f21286c = i9;
    }

    @Override // p146s6.c
    public final boolean a() {
        return false;
    }

    @Override // p146s6.c
    public final int b(MediaFormat mediaFormat) {
        k.e(mediaFormat, "mediaFormat");
        if (this.f21288e || this.f21289f) {
            return -1;
        }
        if (this.f21287d == null) {
            this.f21287d = new MediaMuxer(this.f21284a, this.f21286c);
        }
        MediaMuxer mediaMuxer = this.f21287d;
        k.b(mediaMuxer);
        return mediaMuxer.addTrack(mediaFormat);
    }

    @Override // p146s6.c
    public final byte[] c(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        c.a.b(byteBuffer, bufferInfo);
        throw null;
    }

    @Override // p146s6.c
    public final boolean d() {
        return this.f21285b;
    }

    @Override // p146s6.c
    public final void e(int i9, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        MediaMuxer mediaMuxer;
        k.e(bufferInfo, "bufferInfo");
        if (!this.f21288e || this.f21289f || (mediaMuxer = this.f21287d) == null) {
            return;
        }
        mediaMuxer.writeSampleData(i9, byteBuffer, bufferInfo);
    }

    @Override // p146s6.c
    public final void release() {
        stop();
        MediaMuxer mediaMuxer = this.f21287d;
        if (mediaMuxer != null) {
            mediaMuxer.release();
        }
        this.f21287d = null;
    }

    @Override // p146s6.c
    public final void start() {
        if (this.f21288e || this.f21289f) {
            return;
        }
        this.f21288e = true;
        MediaMuxer mediaMuxer = this.f21287d;
        if (mediaMuxer != null) {
            mediaMuxer.start();
        }
    }

    @Override // p146s6.c
    public final void stop() {
        if (!this.f21288e || this.f21289f) {
            return;
        }
        this.f21288e = false;
        this.f21289f = true;
        MediaMuxer mediaMuxer = this.f21287d;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
        }
    }
}

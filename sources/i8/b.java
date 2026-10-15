package i8;

import android.media.MediaPlayer;
import h8.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: BytesSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f19319a;

    public b(byte[] bArr) {
        this.f19319a = new a(bArr);
    }

    @Override // i8.c
    public final void a(MediaPlayer mediaPlayer) {
        k.e(mediaPlayer, "mediaPlayer");
        mediaPlayer.setDataSource(this.f19319a);
    }

    @Override // i8.c
    public final void b(l soundPoolPlayer) {
        k.e(soundPoolPlayer, "soundPoolPlayer");
        throw new IllegalStateException("Bytes sources are not supported on LOW_LATENCY mode yet.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && k.a(this.f19319a, ((b) obj).f19319a);
    }

    public final int hashCode() {
        return this.f19319a.hashCode();
    }

    public final String toString() {
        return "BytesSource(dataSource=" + this.f19319a + ')';
    }
}

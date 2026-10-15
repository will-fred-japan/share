package okio;

import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    /* JADX INFO: compiled from: Segment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i9;
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException("cannot compact");
        }
        k.b(segment);
        if (segment.owner) {
            int i10 = this.limit - this.pos;
            Segment segment2 = this.prev;
            k.b(segment2);
            int i11 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            k.b(segment3);
            if (segment3.shared) {
                i9 = 0;
            } else {
                Segment segment4 = this.prev;
                k.b(segment4);
                i9 = segment4.pos;
            }
            if (i10 > i11 + i9) {
                return;
            }
            Segment segment5 = this.prev;
            k.b(segment5);
            writeTo(segment5, i10);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        k.b(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        k.b(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        k.e(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        k.b(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i9) {
        Segment segmentTake;
        if (i9 <= 0 || i9 > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i9 >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.take();
            byte[] bArr = this.data;
            byte[] bArr2 = segmentTake.data;
            int i10 = this.pos;
            y7.f.c(bArr, 0, bArr2, i10, i10 + i9);
        }
        segmentTake.limit = segmentTake.pos + i9;
        this.pos += i9;
        Segment segment = this.prev;
        k.b(segment);
        segment.push(segmentTake);
        return segmentTake;
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        k.d(bArrCopyOf, "copyOf(this, size)");
        return new Segment(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment sink, int i9) {
        k.e(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i10 = sink.limit;
        int i11 = i10 + i9;
        if (i11 > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i12 = sink.pos;
            if (i11 - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            y7.f.c(bArr, 0, bArr, i12, i10);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i13 = sink.limit;
        int i14 = this.pos;
        y7.f.c(bArr2, i13, bArr3, i14, i14 + i9);
        sink.limit += i9;
        this.pos += i9;
    }

    public Segment(byte[] data, int i9, int i10, boolean z8, boolean z9) {
        k.e(data, "data");
        this.data = data;
        this.pos = i9;
        this.limit = i10;
        this.shared = z8;
        this.owner = z9;
    }
}

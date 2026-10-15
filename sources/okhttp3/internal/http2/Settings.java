package okhttp3.internal.http2;

import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* JADX INFO: compiled from: Settings.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public final void clear() {
        this.set = 0;
        int[] iArr = this.values;
        int length = iArr.length;
        k.e(iArr, "<this>");
        Arrays.fill(iArr, 0, length, 0);
    }

    public final int get(int i9) {
        return this.values[i9];
    }

    public final boolean getEnablePush(boolean z8) {
        if ((this.set & 4) != 0) {
            return this.values[2] == 1;
        }
        return z8;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        return (this.set & 128) != 0 ? this.values[7] : DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int i9) {
        return (this.set & 32) != 0 ? this.values[5] : i9;
    }

    public final int getMaxHeaderListSize(int i9) {
        return (this.set & 64) != 0 ? this.values[6] : i9;
    }

    public final boolean isSet(int i9) {
        return ((1 << i9) & this.set) != 0;
    }

    public final void merge(Settings other) {
        k.e(other, "other");
        for (int i9 = 0; i9 < 10; i9++) {
            if (other.isSet(i9)) {
                set(i9, other.get(i9));
            }
        }
    }

    public final Settings set(int i9, int i10) {
        if (i9 >= 0) {
            int[] iArr = this.values;
            if (i9 < iArr.length) {
                this.set = (1 << i9) | this.set;
                iArr[i9] = i10;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}

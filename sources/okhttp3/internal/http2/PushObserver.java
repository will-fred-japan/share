package okhttp3.internal.http2;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okio.BufferedSource;

/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface PushObserver {
    public static final Companion Companion = new Companion(null);
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    /* JADX INFO: compiled from: PushObserver.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        /* JADX INFO: compiled from: PushObserver.kt */
        public static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i9, BufferedSource source, int i10, boolean z8) {
                k.e(source, "source");
                source.skip(i10);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i9, List<Header> responseHeaders, boolean z8) {
                k.e(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i9, List<Header> requestHeaders) {
                k.e(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i9, ErrorCode errorCode) {
                k.e(errorCode, "errorCode");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    boolean onData(int i9, BufferedSource bufferedSource, int i10, boolean z8);

    boolean onHeaders(int i9, List<Header> list, boolean z8);

    boolean onRequest(int i9, List<Header> list);

    void onReset(int i9, ErrorCode errorCode);
}

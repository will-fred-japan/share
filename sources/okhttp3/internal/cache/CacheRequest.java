package okhttp3.internal.cache;

import okio.Sink;

/* JADX INFO: compiled from: CacheRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface CacheRequest {
    void abort();

    Sink body();
}

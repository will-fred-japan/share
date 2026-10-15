package okhttp3.sse;

import kotlin.jvm.internal.k;
import okhttp3.Response;

/* JADX INFO: compiled from: EventSourceListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EventSourceListener {
    public void onClosed(EventSource eventSource) {
        k.e(eventSource, "eventSource");
    }

    public void onEvent(EventSource eventSource, String str, String str2, String data) {
        k.e(eventSource, "eventSource");
        k.e(data, "data");
    }

    public void onFailure(EventSource eventSource, Throwable th, Response response) {
        k.e(eventSource, "eventSource");
    }

    public void onOpen(EventSource eventSource, Response response) {
        k.e(eventSource, "eventSource");
        k.e(response, "response");
    }
}

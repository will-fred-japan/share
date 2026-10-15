package okhttp3.sse;

import okhttp3.Request;

/* JADX INFO: compiled from: EventSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface EventSource {

    /* JADX INFO: compiled from: EventSource.kt */
    public interface Factory {
        EventSource newEventSource(Request request, EventSourceListener eventSourceListener);
    }

    void cancel();

    Request request();
}

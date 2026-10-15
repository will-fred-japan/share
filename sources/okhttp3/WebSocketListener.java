package okhttp3;

import kotlin.jvm.internal.k;
import okio.ByteString;

/* JADX INFO: compiled from: WebSocketListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i9, String reason) {
        k.e(webSocket, "webSocket");
        k.e(reason, "reason");
    }

    public void onClosing(WebSocket webSocket, int i9, String reason) {
        k.e(webSocket, "webSocket");
        k.e(reason, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        k.e(webSocket, "webSocket");
        k.e(t, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        k.e(webSocket, "webSocket");
        k.e(text, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        k.e(webSocket, "webSocket");
        k.e(response, "response");
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        k.e(webSocket, "webSocket");
        k.e(bytes, "bytes");
    }
}

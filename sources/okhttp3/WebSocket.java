package okhttp3;

import okio.ByteString;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WebSocket {

    /* JADX INFO: compiled from: WebSocket.kt */
    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i9, String str);

    long queueSize();

    Request request();

    boolean send(String str);

    boolean send(ByteString byteString);
}

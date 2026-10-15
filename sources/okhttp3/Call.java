package okhttp3;

import okio.Timeout;

/* JADX INFO: compiled from: Call.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface Call extends Cloneable {

    /* JADX INFO: compiled from: Call.kt */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    Response execute();

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}

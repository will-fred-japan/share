package p096m7;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: BinaryMessenger.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: BinaryMessenger.java */
    public interface a {
        void a(ByteBuffer byteBuffer, b7.c.e eVar);
    }

    /* JADX INFO: compiled from: BinaryMessenger.java */
    public interface b {
        void a(ByteBuffer byteBuffer);
    }

    /* JADX INFO: renamed from: m7.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BinaryMessenger.java */
    public interface InterfaceC0232c {
    }

    /* JADX INFO: compiled from: BinaryMessenger.java */
    public static class d {
    }

    void a(String str, ByteBuffer byteBuffer, b bVar);

    default void b(String str, a aVar, InterfaceC0232c interfaceC0232c) {
        if (interfaceC0232c != null) {
            throw new UnsupportedOperationException("setMessageHandler called with nonnull taskQueue is not supported.");
        }
        e(str, aVar);
    }

    default InterfaceC0232c c(d dVar) {
        throw new UnsupportedOperationException("makeBackgroundTaskQueue not implemented.");
    }

    void d(String str, ByteBuffer byteBuffer);

    void e(String str, a aVar);
}

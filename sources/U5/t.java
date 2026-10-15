package U5;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: OutputPrefixUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p012b6.a f4731a = p012b6.a.a(new byte[0]);

    public static final p012b6.a a(int i9) {
        return p012b6.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(i9).array());
    }

    public static final p012b6.a b(int i9) {
        return p012b6.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(i9).array());
    }
}

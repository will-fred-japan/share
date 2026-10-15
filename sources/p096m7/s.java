package p096m7;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: StandardMethodCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f20511a;

    static {
        r rVar = r.f20508a;
        f20511a = new s();
    }

    @Override // p096m7.m
    public final ByteBuffer a(Object obj) {
        r.a aVar = new r.a();
        aVar.write(0);
        r.f20508a.k(aVar, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // p096m7.m
    public final ByteBuffer b(String str, String str2) throws IOException {
        r.a aVar = new r.a();
        aVar.write(1);
        r rVar = r.f20508a;
        rVar.k(aVar, "error");
        rVar.k(aVar, str);
        aVar.write(0);
        rVar.k(aVar, str2);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // p096m7.m
    public final ByteBuffer c(String str, String str2, Object obj) {
        r.a aVar = new r.a();
        aVar.write(1);
        r rVar = r.f20508a;
        rVar.k(aVar, str);
        rVar.k(aVar, str2);
        if (obj instanceof Throwable) {
            rVar.k(aVar, Log.getStackTraceString((Throwable) obj));
        } else {
            rVar.k(aVar, obj);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // p096m7.m
    public final ByteBuffer d(j jVar) {
        r.a aVar = new r.a();
        r rVar = r.f20508a;
        rVar.k(aVar, jVar.f20496a);
        rVar.k(aVar, jVar.f20497b);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // p096m7.m
    public final j e(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        r rVar = r.f20508a;
        Object objE = rVar.e(byteBuffer);
        Object objE2 = rVar.e(byteBuffer);
        if (!(objE instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new j(objE2, (String) objE);
    }

    @Override // p096m7.m
    public final Object f(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byte b9 = byteBuffer.get();
        if (b9 != 0) {
            if (b9 == 1) {
            }
            throw new IllegalArgumentException("Envelope corrupted");
        }
        Object objE = r.f20508a.e(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return objE;
        }
        r rVar = r.f20508a;
        Object objE2 = rVar.e(byteBuffer);
        Object objE3 = rVar.e(byteBuffer);
        Object objE4 = rVar.e(byteBuffer);
        if ((objE2 instanceof String) && ((objE3 == null || (objE3 instanceof String)) && !byteBuffer.hasRemaining())) {
            throw new e((String) objE2, (String) objE3, objE4);
        }
        throw new IllegalArgumentException("Envelope corrupted");
    }
}

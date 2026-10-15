package p022d0;

import java.nio.ByteBuffer;
import p031e0.a;
import p031e0.b;

/* JADX INFO: compiled from: TypefaceEmojiRasterizer.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<a> f18478d = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f18480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f18481c = 0;

    public k(i iVar, int i9) {
        this.f18480b = iVar;
        this.f18479a = i9;
    }

    public final int a(int i9) {
        a aVarB = b();
        int iA = aVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = aVarB.f18589b;
        int i10 = iA + aVarB.f18588a;
        return byteBuffer.getInt((i9 * 4) + byteBuffer.getInt(i10) + i10 + 4);
    }

    public final a b() {
        ThreadLocal<a> threadLocal = f18478d;
        a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new a();
            threadLocal.set(aVar);
        }
        b bVar = this.f18480b.f18468a;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i9 = iA + bVar.f18588a;
            int i10 = (this.f18479a * 4) + bVar.f18589b.getInt(i9) + i9 + 4;
            int i11 = bVar.f18589b.getInt(i10) + i10;
            ByteBuffer byteBuffer = bVar.f18589b;
            aVar.f18589b = byteBuffer;
            if (byteBuffer != null) {
                aVar.f18588a = i11;
                int i12 = i11 - byteBuffer.getInt(i11);
                aVar.f18590c = i12;
                aVar.f18591d = aVar.f18589b.getShort(i12);
                return aVar;
            }
            aVar.f18588a = 0;
            aVar.f18590c = 0;
            aVar.f18591d = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i9;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        a aVarB = b();
        int iA = aVarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? aVarB.f18589b.getInt(iA + aVarB.f18588a) : 0));
        sb.append(", codepoints:");
        a aVarB2 = b();
        int iA2 = aVarB2.a(16);
        if (iA2 != 0) {
            int i10 = iA2 + aVarB2.f18588a;
            i9 = aVarB2.f18589b.getInt(aVarB2.f18589b.getInt(i10) + i10);
        } else {
            i9 = 0;
        }
        for (int i11 = 0; i11 < i9; i11++) {
            sb.append(Integer.toHexString(a(i11)));
            sb.append(" ");
        }
        return sb.toString();
    }
}

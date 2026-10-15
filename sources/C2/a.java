package C2;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: LogFile.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f1795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f1796e;

    public a() {
        throw null;
    }

    public static a a(ByteBuffer byteBuffer) {
        try {
            if (byteBuffer.getShort() != 2082) {
                return null;
            }
            long j = byteBuffer.getLong();
            int i9 = byteBuffer.getInt();
            int i10 = byteBuffer.getInt();
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            for (int i12 = 0; i12 < i9; i12++) {
                int i13 = byteBuffer.getInt();
                i11 += i13;
                if (i11 > i10) {
                    return null;
                }
                byte[] bArr = new byte[i13];
                byteBuffer.get(bArr);
                b bVar = new b();
                bVar.f1797a = bArr;
                arrayList.add(bVar);
            }
            a aVar = new a();
            aVar.f1792a = j;
            aVar.f1793b = i9;
            aVar.f1794c = i10;
            aVar.f1796e = arrayList;
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String toString() {
        return "LogFile{startID=" + this.f1792a + ", totalCount=" + this.f1793b + ", totalBytes=" + this.f1794c + ", source=" + this.f1795d + ", logList=" + this.f1796e + '}';
    }
}

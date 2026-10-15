package p199z2;

import com.huawei.hms.framework.common.BundleUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import p010b3.b;

/* JADX INFO: compiled from: SeqNumGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MappedByteBuffer f22491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22492b;

    /* JADX INFO: compiled from: SeqNumGenerator.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f22493a;

        static {
            e eVar = new e();
            eVar.f22492b = 0L;
            f22493a = eVar;
        }
    }

    public final long a() {
        if (this.f22491a == null) {
            try {
                File file = new File(b.o(), N2.a.u1().replace(".", BundleUtil.UNDERLINE_TAG).replace(Constants.COLON_SEPARATOR, Constants.ACCEPT_TIME_SEPARATOR_SERVER) + "_seq_num.txt");
                boolean zExists = file.exists();
                if (!zExists) {
                    file.createNewFile();
                }
                MappedByteBuffer map = new RandomAccessFile(file, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8L);
                this.f22491a = map;
                if (!zExists) {
                    map.putLong(0, 0L);
                    return 0L;
                }
            } catch (Throwable th) {
                b.b(p199z2.a.f22469a, "prepare seq_number fail.", th);
            }
        }
        MappedByteBuffer mappedByteBuffer = this.f22491a;
        if (mappedByteBuffer == null) {
            long j = this.f22492b;
            this.f22492b = 1 + j;
            return j;
        }
        long j8 = mappedByteBuffer.getLong(0) + 1;
        this.f22492b = j8;
        this.f22491a.putLong(0, j8);
        return this.f22492b;
    }
}

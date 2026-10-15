package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ProfileVerifier.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p171w.c<c> f7901a = new p171w.c<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f7902b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f7903c = null;

    /* JADX INFO: compiled from: ProfileVerifier.java */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* JADX INFO: compiled from: ProfileVerifier.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f7906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f7907d;

        public b(int i9, int i10, long j, long j8) {
            this.f7904a = i9;
            this.f7905b = i10;
            this.f7906c = j;
            this.f7907d = j8;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }

        public final void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f7904a);
                dataOutputStream.writeInt(this.f7905b);
                dataOutputStream.writeLong(this.f7906c);
                dataOutputStream.writeLong(this.f7907d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (this.f7905b == bVar.f7905b && this.f7906c == bVar.f7906c && this.f7904a == bVar.f7904a && this.f7907d == bVar.f7907d) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.f7905b), Long.valueOf(this.f7906c), Integer.valueOf(this.f7904a), Long.valueOf(this.f7907d));
        }
    }

    /* JADX INFO: compiled from: ProfileVerifier.java */
    public static class c {
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b() {
        c cVar = new c();
        f7903c = cVar;
        p171w.c<c> cVar2 = f7901a;
        cVar2.getClass();
        if (p171w.b.f21944f.b(cVar2, null, cVar)) {
            p171w.b.b(cVar2);
        }
        return f7903c;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x002e  */
    /* JADX WARN: Code duplicated, block: B:43:0x006f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0092  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    public static void c(Context context, boolean z8) {
        int i9;
        boolean z9;
        int i10;
        File file;
        boolean z10;
        File file2;
        long length;
        boolean z11;
        File file3;
        b bVarA;
        b bVar;
        int i11;
        AssetFileDescriptor assetFileDescriptorOpenFd;
        if (z8 || f7903c == null) {
            synchronized (f7902b) {
                if (z8) {
                    i9 = 0;
                    assetFileDescriptorOpenFd = context.getAssets().openFd("dexopt/baseline.prof");
                    if (assetFileDescriptorOpenFd.getLength() > 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    assetFileDescriptorOpenFd.close();
                    i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 28) {
                        file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                        long length2 = file.length();
                        if (file.exists()) {
                            z10 = false;
                        } else {
                            z10 = false;
                        }
                        file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                        length = file2.length();
                        if (file2.exists()) {
                            z11 = false;
                        } else {
                            z11 = false;
                        }
                        long jA = a(context);
                        file3 = new File(context.getFilesDir(), "profileInstalled");
                        if (file3.exists()) {
                            bVarA = b.a(file3);
                        } else {
                            bVarA = null;
                        }
                        if (bVarA == null) {
                            if (!z9) {
                                i9 = 327680;
                            } else if (z10) {
                                i9 = 1;
                            } else if (z11) {
                                i9 = 2;
                            }
                        } else if (!z9) {
                            i9 = 327680;
                        } else if (z10) {
                            i9 = 1;
                        } else if (z11) {
                            i9 = 2;
                        }
                        if (z8) {
                            i9 = 2;
                        }
                        if (bVarA != null) {
                            i9 = 3;
                        }
                        bVar = new b(1, i9, jA, length);
                        if (bVarA != null) {
                            bVar.b(file3);
                        } else {
                            bVar.b(file3);
                        }
                        b();
                        return;
                    }
                    b();
                    return;
                }
                if (f7903c != null) {
                    return;
                }
                i9 = 0;
                try {
                    assetFileDescriptorOpenFd = context.getAssets().openFd("dexopt/baseline.prof");
                    try {
                        if (assetFileDescriptorOpenFd.getLength() > 0) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        assetFileDescriptorOpenFd.close();
                    } catch (Throwable th) {
                        if (assetFileDescriptorOpenFd == null) {
                            throw th;
                        }
                        try {
                            assetFileDescriptorOpenFd.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (IOException unused) {
                    z9 = false;
                }
                i10 = Build.VERSION.SDK_INT;
                if (i10 >= 28 && i10 != 30) {
                    file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length3 = file.length();
                    if (file.exists() || length3 <= 0) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    length = file2.length();
                    if (file2.exists() || length <= 0) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    try {
                        long jA2 = a(context);
                        file3 = new File(context.getFilesDir(), "profileInstalled");
                        if (file3.exists()) {
                            try {
                                bVarA = b.a(file3);
                            } catch (IOException unused2) {
                                b();
                                return;
                            }
                        } else {
                            bVarA = null;
                        }
                        if (bVarA == null && bVarA.f7906c == jA2 && (i11 = bVarA.f7905b) != 2) {
                            i9 = i11;
                        } else if (!z9) {
                            i9 = 327680;
                        } else if (z10) {
                            i9 = 1;
                        } else if (z11) {
                            i9 = 2;
                        }
                        if (z8 && z11 && i9 != 1) {
                            i9 = 2;
                        }
                        if (bVarA != null && bVarA.f7905b == 2 && i9 == 1 && length3 < bVarA.f7907d) {
                            i9 = 3;
                        }
                        bVar = new b(1, i9, jA2, length);
                        if (bVarA != null || !bVarA.equals(bVar)) {
                            try {
                                bVar.b(file3);
                            } catch (IOException unused3) {
                            }
                        }
                        b();
                        return;
                    } catch (PackageManager.NameNotFoundException unused4) {
                        b();
                        return;
                    }
                }
                b();
                return;
                throw th;
            }
        }
    }
}

package E;

import L4.d;
import S.c;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import defpackage.f;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.zip.ZipFile;
import p155u.g;

/* JADX INFO: compiled from: DirectedAcyclicGraph.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f1949e;

    public a(int i9) {
        this.f1945a = i9;
        switch (i9) {
            case 1:
                d dVar = new d();
                L4.a aVar = new L4.a();
                this.f1946b = new HashSet();
                this.f1947c = dVar;
                this.f1948d = aVar;
                break;
            case 2:
                break;
            default:
                this.f1947c = new c(10);
                this.f1948d = new g();
                this.f1949e = new ArrayList();
                this.f1946b = new HashSet();
                break;
        }
    }

    public void a(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((g) this.f1948d).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i9 = 0; i9 < size; i9++) {
                a(arrayList2.get(i9), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public File b(Context context, String str) {
        return new File(context.getDir("lib", 0), ((d) this.f1947c).a(str));
    }

    public void c(Context context, String str) {
        L4.a.C0030a c0030a;
        String[] strArrC;
        ZipFile zipFile;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        d("Beginning load of %s...", str);
        d dVar = (d) this.f1947c;
        HashSet hashSet = (HashSet) this.f1946b;
        if (hashSet.contains(str)) {
            d("%s already loaded previously!", str);
            return;
        }
        try {
            dVar.getClass();
            System.loadLibrary(str);
            hashSet.add(str);
            d("%s (%s) was loaded normally!", str, null);
        } catch (UnsatisfiedLinkError e9) {
            d("Loading the library normally failed: %s", Log.getStackTraceString(e9));
            d("%s (%s) was not loaded normally, re-linking...", str, null);
            File fileB = b(context, str);
            if (!fileB.exists()) {
                File dir = context.getDir("lib", 0);
                File fileB2 = b(context, str);
                File[] fileArrListFiles = dir.listFiles(new L4.c(dVar.a(str)));
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        if (!file.getAbsolutePath().equals(fileB2.getAbsolutePath())) {
                            file.delete();
                        }
                    }
                }
                dVar.getClass();
                String[] strArr = Build.SUPPORTED_ABIS;
                if (strArr.length <= 0) {
                    String str2 = Build.CPU_ABI2;
                    strArr = (str2 == null || str2.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str2};
                }
                String strA = dVar.a(str);
                ((L4.a) this.f1948d).getClass();
                try {
                    L4.a.C0030a c0030aB = L4.a.b(context, strArr, strA, this);
                    try {
                        if (c0030aB == null) {
                            try {
                                strArrC = L4.a.c(context, strA);
                            } catch (Exception e10) {
                                strArrC = new String[]{e10.toString()};
                            }
                            StringBuilder sbI = f.i("Could not find '", strA, "'. Looked for: ");
                            sbI.append(Arrays.toString(strArr));
                            sbI.append(", but only found: ");
                            throw new L4.b(A.a.j(sbI, Arrays.toString(strArrC), "."));
                        }
                        int i9 = 0;
                        while (true) {
                            int i10 = i9 + 1;
                            zipFile = c0030aB.f2840a;
                            if (i9 >= 5) {
                                if (((H2.a) this.f1949e) == null) {
                                    break;
                                }
                                FlutterJNI.lambda$loadLibrary$0("FATAL! Couldn't extract the library from the APK!");
                                break;
                            }
                            d("Found %s! Extracting...", strA);
                            try {
                                if (fileB.exists() || fileB.createNewFile()) {
                                    try {
                                        inputStream2 = zipFile.getInputStream(c0030aB.f2841b);
                                        try {
                                            fileOutputStream2 = new FileOutputStream(fileB);
                                            try {
                                                byte[] bArr = new byte[4096];
                                                long j = 0;
                                                while (true) {
                                                    int i11 = inputStream2.read(bArr);
                                                    if (i11 == -1) {
                                                        break;
                                                    }
                                                    fileOutputStream2.write(bArr, 0, i11);
                                                    j += (long) i11;
                                                    strA = strA;
                                                }
                                                fileOutputStream2.flush();
                                                fileOutputStream2.getFD().sync();
                                                if (j == fileB.length()) {
                                                    L4.a.a(inputStream2);
                                                    L4.a.a(fileOutputStream2);
                                                    fileB.setReadable(true, false);
                                                    fileB.setExecutable(true, false);
                                                    fileB.setWritable(true);
                                                    break;
                                                }
                                                L4.a.a(inputStream2);
                                                L4.a.a(fileOutputStream2);
                                            } catch (FileNotFoundException unused) {
                                                strA = strA;
                                                L4.a.a(inputStream2);
                                                L4.a.a(fileOutputStream2);
                                                i9 = i10;
                                                strA = strA;
                                            } catch (IOException unused2) {
                                                strA = strA;
                                                L4.a.a(inputStream2);
                                                L4.a.a(fileOutputStream2);
                                                i9 = i10;
                                                strA = strA;
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStream = inputStream2;
                                                fileOutputStream = fileOutputStream2;
                                                L4.a.a(inputStream);
                                                L4.a.a(fileOutputStream);
                                                throw th;
                                            }
                                        } catch (FileNotFoundException unused3) {
                                            fileOutputStream2 = null;
                                            L4.a.a(inputStream2);
                                            L4.a.a(fileOutputStream2);
                                            i9 = i10;
                                            strA = strA;
                                        } catch (IOException unused4) {
                                            fileOutputStream2 = null;
                                            L4.a.a(inputStream2);
                                            L4.a.a(fileOutputStream2);
                                            i9 = i10;
                                            strA = strA;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            inputStream = inputStream2;
                                            fileOutputStream = null;
                                            L4.a.a(inputStream);
                                            L4.a.a(fileOutputStream);
                                            throw th;
                                        }
                                    } catch (FileNotFoundException unused5) {
                                        inputStream2 = null;
                                    } catch (IOException unused6) {
                                        inputStream2 = null;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStream = null;
                                    }
                                }
                            } catch (IOException unused7) {
                            }
                            strA = strA;
                            i9 = i10;
                            strA = strA;
                        }
                        try {
                            zipFile.close();
                        } catch (IOException unused8) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        c0030a = c0030aB;
                        if (c0030a != null) {
                            try {
                                c0030a.f2840a.close();
                            } catch (IOException unused9) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    c0030a = null;
                }
            }
            String absolutePath = fileB.getAbsolutePath();
            dVar.getClass();
            System.load(absolutePath);
            hashSet.add(str);
            d("%s (%s) was re-linked!", str, null);
        }
    }

    public void d(String str, Object... objArr) {
        String str2 = String.format(Locale.US, str, objArr);
        if (((H2.a) this.f1949e) != null) {
            FlutterJNI.lambda$loadLibrary$0(str2);
        }
    }

    public String toString() {
        switch (this.f1945a) {
            case 2:
                StringBuilder sb = new StringBuilder("CloudMessage{mParams='");
                sb.append((String) this.f1947c);
                sb.append("', mType=");
                sb.append((String) this.f1948d);
                sb.append(", send_time=0, command_id='");
                return A.a.j(sb, (String) this.f1949e, "'}");
            default:
                return super.toString();
        }
    }
}

package L4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ApkLibraryInstaller.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: L4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApkLibraryInstaller.java */
    public static class C0030a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipFile f2840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZipEntry f2841b;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static C0030a b(Context context, String[] strArr, String str, E.a aVar) {
        String[] strArrD = d(context);
        int length = strArrD.length;
        int i9 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i9 >= length) {
                return null;
            }
            String str2 = strArrD[i9];
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i10 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i10 = i11;
                }
            }
            if (zipFile != null) {
                int i12 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    if (i12 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c5 = File.separatorChar;
                            sb.append(c5);
                            sb.append(str3);
                            sb.append(c5);
                            sb.append(str);
                            String string = sb.toString();
                            aVar.d("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                C0030a c0030a = new C0030a();
                                c0030a.f2840a = zipFile;
                                c0030a.f2841b = entry;
                                return c0030a;
                            }
                        }
                        i12 = i13;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i9++;
        }
    }

    public static String[] c(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c5 = File.separatorChar;
        sb.append(c5);
        sb.append("([^\\");
        sb.append(c5);
        sb.append("]*)");
        sb.append(c5);
        sb.append(str);
        Pattern patternCompile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : d(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static String[] d(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}

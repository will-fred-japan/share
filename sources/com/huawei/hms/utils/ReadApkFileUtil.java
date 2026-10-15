package com.huawei.hms.utils;

import A.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15646a = "ReadApkFileUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f15648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f15649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f15650e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f15647b = Pattern.compile("\\s*|\t|\r|\n");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f15651f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f15652g = null;

    private static byte[] a(ZipFile zipFile) {
        return a(zipFile, "META-INF/MANIFEST.MF");
    }

    @TargetApi(19)
    private static void b(byte[] bArr) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null) {
            HMSLog.e(f15646a, "manifest is null！");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        ByteArrayInputStream byteArrayInputStream2 = null;
        bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        f15648c = null;
        f15649d = null;
        f15650e = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    String strA = a(bufferedReader);
                    while (strA != null) {
                        if (strA.length() != 0) {
                            if (strA.startsWith("ApkHash:")) {
                                f15651f = a(strA.substring(strA.indexOf(Constants.COLON_SEPARATOR) + 1));
                            }
                            if (strA.startsWith(KEY_SIGNATURE)) {
                                f15648c = a(strA.substring(strA.indexOf(Constants.COLON_SEPARATOR) + 1));
                                strA = a(bufferedReader);
                            } else if (strA.startsWith(KEY_SIGNATURE2)) {
                                f15649d = a(strA.substring(strA.indexOf(Constants.COLON_SEPARATOR) + 1));
                                strA = a(bufferedReader);
                            } else if (strA.startsWith(KEY_SIGNATURE3)) {
                                f15650e = a(strA.substring(strA.indexOf(Constants.COLON_SEPARATOR) + 1));
                                strA = a(bufferedReader);
                            } else {
                                stringBuffer.append(strA);
                                stringBuffer.append("\r\n");
                            }
                        }
                        strA = a(bufferedReader);
                    }
                    f15652g = stringBuffer.toString();
                } catch (Exception unused) {
                    bufferedReader3 = bufferedReader;
                    try {
                        HMSLog.e(f15646a, "loadApkCert Exception!");
                        bufferedReader = bufferedReader3;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        byteArrayInputStream2 = byteArrayInputStream;
                        byteArrayInputStream = byteArrayInputStream2;
                        bufferedReader2 = bufferedReader;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((Reader) bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th4) {
                th = th4;
                IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                IOUtils.closeQuietly((Reader) bufferedReader2);
                throw th;
            }
        } catch (Exception unused3) {
            byteArrayInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            byteArrayInputStream = byteArrayInputStream2;
            bufferedReader2 = bufferedReader;
            IOUtils.closeQuietly((InputStream) byteArrayInputStream);
            IOUtils.closeQuietly((Reader) bufferedReader2);
            throw th;
        }
        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i9 = 0; i9 < bArr.length; i9++) {
            byte b9 = bArr[i9];
            int i10 = i9 * 2;
            cArr2[i10] = cArr[(b9 & 255) >>> 4];
            cArr2[i10 + 1] = cArr[b9 & 15];
        }
        return String.valueOf(cArr2);
    }

    private static boolean c() {
        try {
            if (a(Base64.decode(EMUI11_PK, 0), a(f15652g, "SHA-384"), b(f15650e), "SHA384withRSA")) {
                HMSLog.i(f15646a, "verifyMDMSignatureV3 verify successful!");
                return true;
            }
            HMSLog.i(f15646a, "verifyMDMSignatureV3 verify failure!");
            return false;
        } catch (Exception e9) {
            HMSLog.i(f15646a, "verifyMDMSignatureV3 MDM verify Exception!:" + e9.getMessage());
        }
    }

    public static boolean checkSignature() {
        if (f15650e != null) {
            return c();
        }
        if (f15649d != null) {
            return b();
        }
        if (f15648c != null) {
            return a();
        }
        return false;
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e(f15646a, "HMS is not found!");
            return null;
        }
    }

    @TargetApi(19)
    public static boolean isCertFound(String str) throws Throwable {
        ZipFile zipFile;
        boolean z8 = false;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    boolean z9 = zipFile.getEntry("META-INF/HUAWEI.CER") != null;
                    if (z9) {
                        b(a(zipFile, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e9) {
                        HMSLog.e(f15646a, "zipFile.close Exception!" + e9.getMessage());
                    }
                    z8 = z9;
                } catch (Exception e10) {
                    e = e10;
                    zipFile2 = zipFile;
                    HMSLog.e(f15646a, "isCertFound Exception!" + e.getMessage());
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e11) {
                            HMSLog.e(f15646a, "zipFile.close Exception!" + e11.getMessage());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e12) {
                            HMSLog.e(f15646a, "zipFile.close Exception!" + e12.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
            }
        } catch (Exception e13) {
            e = e13;
        }
        return z8;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static boolean verifyApkHash(String str) throws Throwable {
        ?? r8;
        StringBuilder sb = null;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    byte[] bArrA = a(zipFile2);
                    ArrayList<String> arrayListA = a(bArrA);
                    if (arrayListA != null) {
                        bArrA = a(arrayListA);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(bArrA);
                    String strBytesToString = bytesToString(messageDigest.digest());
                    String str2 = f15651f;
                    if (str2 == null || !str2.equals(strBytesToString)) {
                        try {
                            zipFile2.close();
                            return false;
                        } catch (Exception e9) {
                            HMSLog.i(f15646a, "close stream Exception!" + e9.getMessage());
                            return false;
                        }
                    }
                    try {
                        zipFile2.close();
                        return true;
                    } catch (Exception e10) {
                        HMSLog.i(f15646a, "close stream Exception!" + e10.getMessage());
                        return true;
                    }
                } catch (Exception e11) {
                    e = e11;
                    zipFile = zipFile2;
                    HMSLog.i(f15646a, "verifyApkHash Exception!" + e.getMessage());
                    if (zipFile == null) {
                        return false;
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (Exception e12) {
                        String str3 = f15646a;
                        sb = new StringBuilder("close stream Exception!");
                        sb.append(e12.getMessage());
                        HMSLog.i(str3, sb.toString());
                        return false;
                    }
                    if (r8 != 0) {
                        try {
                            r8.close();
                        } catch (Exception e13) {
                            HMSLog.i(f15646a, "close stream Exception!" + e13.getMessage());
                        }
                    }
                    throw th;
                } catch (Throwable th) {
                    th = th;
                    r8 = zipFile2;
                    if (r8 != 0) {
                        r8.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r8 = sb;
            }
        } catch (Exception e14) {
            e = e14;
        }
    }

    private static byte[] a(ZipFile zipFile, String str) throws Throwable {
        Throwable th;
        InputStream inputStream;
        Exception e9;
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        OutputStream outputStream2;
        OutputStream outputStream3;
        ZipEntry entry = zipFile.getEntry(str);
        OutputStream outputStream4 = null;
        outputStream4 = null;
        if (entry == null) {
            return null;
        }
        try {
            inputStream = zipFile.getInputStream(entry);
            if (inputStream == null) {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    byte[] bArr = new byte[4096];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
                        try {
                            for (int i9 = bufferedInputStream.read(bArr, 0, 4096); i9 > 0; i9 = bufferedInputStream.read(bArr, 0, 4096)) {
                                bufferedOutputStream.write(bArr, 0, i9);
                            }
                            bufferedOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly((InputStream) bufferedInputStream);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                            return byteArray;
                        } catch (Exception e10) {
                            e9 = e10;
                            outputStream = bufferedOutputStream;
                            try {
                                HMSLog.i(f15646a, "getManifestBytes Exception!" + e9.getMessage());
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                                IOUtils.closeQuietly(outputStream);
                                return null;
                            } catch (Throwable th3) {
                                th2 = th3;
                                outputStream3 = outputStream;
                                bufferedInputStream = bufferedInputStream;
                                outputStream2 = outputStream3;
                                outputStream4 = outputStream2;
                                IOUtils.closeQuietly(inputStream);
                                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                                IOUtils.closeQuietly(outputStream4);
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            outputStream2 = bufferedOutputStream;
                            outputStream4 = outputStream2;
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly((InputStream) bufferedInputStream);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            IOUtils.closeQuietly(outputStream4);
                            throw th2;
                        }
                    } catch (Exception e11) {
                        e9 = e11;
                        outputStream = null;
                    } catch (Throwable th5) {
                        th2 = th5;
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly((InputStream) bufferedInputStream);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly(outputStream4);
                        throw th2;
                    }
                } catch (Exception e12) {
                    e9 = e12;
                    byteArrayOutputStream = null;
                    outputStream = byteArrayOutputStream;
                    HMSLog.i(f15646a, "getManifestBytes Exception!" + e9.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream);
                    return null;
                } catch (Throwable th6) {
                    th2 = th6;
                    byteArrayOutputStream = null;
                    outputStream3 = null;
                    bufferedInputStream = bufferedInputStream;
                    outputStream2 = outputStream3;
                    outputStream4 = outputStream2;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream4);
                    throw th2;
                }
            } catch (Exception e13) {
                e9 = e13;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                outputStream = byteArrayOutputStream;
                HMSLog.i(f15646a, "getManifestBytes Exception!" + e9.getMessage());
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream);
                return null;
            } catch (Throwable th7) {
                th = th7;
                th2 = th;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream4);
                throw th2;
            }
        } catch (Exception e14) {
            e9 = e14;
            inputStream = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    @TargetApi(19)
    private static ArrayList<String> a(byte[] bArr) {
        if (bArr == null) {
            HMSLog.e(f15646a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    if (a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            HMSLog.e(f15646a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    private static boolean b() {
        try {
            if (a(Base64.decode(EMUI10_PK, 0), a(f15652g, "SHA-256"), b(f15649d), "SHA256withRSA")) {
                HMSLog.i(f15646a, "verifyMDMSignatureV2 verify successful!");
                return true;
            }
            HMSLog.i(f15646a, "verifyMDMSignatureV2 verify failure!");
            return false;
        } catch (Exception e9) {
            HMSLog.i(f15646a, "verifyMDMSignatureV2 MDM verify Exception!:" + e9.getMessage());
        }
    }

    private static byte[] b(String str) {
        int i9;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i9 = length / 2;
        } else {
            i9 = (length / 2) + 1;
        }
        byte[] bArr = new byte[i9];
        for (int i10 = 0; i10 < length; i10 += 2) {
            int i11 = i10 + 1;
            if (i11 < length) {
                bArr[i10 / 2] = (byte) (Character.digit(str.charAt(i11), 16) + (Character.digit(str.charAt(i10), 16) << 4));
            } else {
                bArr[i10 / 2] = (byte) (Character.digit(str.charAt(i10), 16) << 4);
            }
        }
        return bArr;
    }

    @TargetApi(19)
    private static byte[] a(ArrayList<String> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i9 = 0; i9 < size; i9++) {
                    String str = arrayList.get(i9);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write("\r\n", 0, 2);
                }
                bufferedWriter.flush();
            } catch (Exception e9) {
                HMSLog.i(f15646a, "getManifestBytesbySorted Exception!" + e9.getMessage());
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
        }
    }

    private static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String strA = a(bufferedReader);
        boolean z8 = false;
        while (strA != null) {
            if (strA.equals("Name: META-INF/HUAWEI.CER")) {
                String strA2 = a(bufferedReader);
                while (strA2 != null) {
                    if (strA2.startsWith("Name:")) {
                        strA = strA2;
                        break;
                    }
                    strA2 = a(bufferedReader);
                }
                z8 = true;
            }
            if (strA.length() != 0) {
                arrayList.add(strA);
            }
            strA = a(bufferedReader);
        }
        return z8;
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        int i9;
        if (bufferedReader == null || (i9 = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder(10);
        while (i9 != -1) {
            char c5 = (char) i9;
            if (c5 == '\n') {
                break;
            }
            if (sb.length() < 4096) {
                sb.append(c5);
                i9 = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String string = sb.toString();
        return (string.isEmpty() || !string.endsWith("\r")) ? string : a.h(1, 0, string);
    }

    private static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f15652g, "SHA-256"), b(f15648c), "SHA256withRSA")) {
                HMSLog.i(f15646a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.i(f15646a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e9) {
            HMSLog.i(f15646a, "verifyMDMSignatureV1 MDM verify Exception!:" + e9.getMessage());
            return false;
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    @TargetApi(19)
    private static byte[] a(String str, String str2) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    private static String a(String str) {
        if (str == null) {
            return "";
        }
        return f15647b.matcher(str).replaceAll("");
    }
}

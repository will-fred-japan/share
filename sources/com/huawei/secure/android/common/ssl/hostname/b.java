package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.e;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f15899a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f15900b;

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f15900b = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z8) throws SSLException {
        String[] strArrA = a(x509Certificate);
        String[] strArrB = b(x509Certificate);
        e.a("", "cn is : " + Arrays.toString(strArrA));
        e.a("", "san is : " + Arrays.toString(strArrB));
        a(str, strArrA, strArrB, z8);
    }

    public static String[] b(X509Certificate x509Certificate) {
        Collection<List<?>> subjectAlternativeNames;
        LinkedList linkedList = new LinkedList();
        try {
            subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e9) {
            e.a("", "Error parsing certificate.", e9);
            subjectAlternativeNames = null;
        }
        if (subjectAlternativeNames != null) {
            for (List<?> list : subjectAlternativeNames) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    private static boolean c(String str) {
        return f15899a.matcher(str).matches();
    }

    public static final void a(String str, String[] strArr, String[] strArr2, boolean z8) throws SSLException {
        String str2;
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && (str2 = strArr[0]) != null) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator it = linkedList.iterator();
            boolean zEquals = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append('>');
                if (it.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && a(lowerCase2) && !c(str)) {
                    boolean zEndsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (zEndsWith && z8) {
                        zEquals = b(lowerCase) == b(lowerCase2);
                    } else {
                        zEquals = zEndsWith;
                    }
                } else {
                    zEquals = lowerCase.equals(lowerCase2);
                }
                if (zEquals) {
                    break;
                }
            }
            if (zEquals) {
                return;
            }
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
        }
        throw new SSLException(A.a.i("Certificate for <", str, "> doesn't contain CN or DNS subjectAlt"));
    }

    public static int b(String str) {
        int i9 = 0;
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (str.charAt(i10) == '.') {
                i9++;
            }
        }
        return i9;
    }

    public static boolean a(String str) {
        int length = str.length();
        if (length >= 7 && length <= 9) {
            int i9 = length - 3;
            if (str.charAt(i9) == '.') {
                return Arrays.binarySearch(f15900b, str.substring(2, i9)) < 0;
            }
        }
        return true;
    }

    public static String[] a(X509Certificate x509Certificate) {
        List<String> listB = new a(x509Certificate.getSubjectX500Principal()).b("cn");
        if (listB.isEmpty()) {
            return null;
        }
        String[] strArr = new String[listB.size()];
        listB.toArray(strArr);
        return strArr;
    }
}
